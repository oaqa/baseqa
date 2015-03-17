package edu.cmu.lti.oaqa.util;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import org.apache.uima.fit.util.FSCollectionFactory;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

import com.google.common.collect.Range;

import edu.cmu.lti.oaqa.type.answer.Answer;
import edu.cmu.lti.oaqa.type.answer.Summary;
import edu.cmu.lti.oaqa.type.input.Question;
import edu.cmu.lti.oaqa.type.nlp.Token;
import edu.cmu.lti.oaqa.type.retrieval.AbstractQuery;
import edu.cmu.lti.oaqa.type.retrieval.ConceptSearchResult;
import edu.cmu.lti.oaqa.type.retrieval.Document;
import edu.cmu.lti.oaqa.type.retrieval.Passage;
import edu.cmu.lti.oaqa.type.retrieval.QueryConcept;
import edu.cmu.lti.oaqa.type.retrieval.SearchResult;
import edu.cmu.lti.oaqa.type.retrieval.TripleSearchResult;

public class TypeUtil {

  public static Question getQuestion(JCas jcas) {
    return JCasUtil.selectSingle(jcas, Question.class);
  }

  public static List<Token> getOrderedTokens(JCas jcas) {
    return JCasUtil.select(jcas, Token.class).stream()
            .sorted(Comparator.comparing(Token::getBegin)).collect(toList());
  }

  public static Collection<AbstractQuery> getAbstractQueries(JCas jcas) {
    return JCasUtil.select(jcas, AbstractQuery.class);
  }

  public static AbstractQuery getAbstractQueriesCombined(JCas jcas) {
    List<QueryConcept> conceptsCombined = getAbstractQueries(jcas).stream()
            .flatMap(a -> FSCollectionFactory.create(a.getConcepts(), QueryConcept.class).stream())
            .collect(toList());
    return TypeFactory.createAbstractQuery(jcas, conceptsCombined);
  }

  public static final Comparator<SearchResult> SEARCH_RESULT_SCORE_COMPARATOR = Comparator
          .comparing(SearchResult::getScore).reversed();

  public static <T extends SearchResult> List<T> rankedSearchResultsByScore(Collection<T> results,
          int hitSize) {
    List<T> sorted = results.stream().sorted(SEARCH_RESULT_SCORE_COMPARATOR).limit(hitSize)
            .collect(toList());
    IntStream.range(0, sorted.size()).forEach(rank -> sorted.get(rank).setRank(rank));
    return sorted;
  }

  public static final Comparator<SearchResult> SEARCH_RESULT_RANK_COMPARATOR = Comparator
          .comparing(SearchResult::getRank);

  private static <T extends SearchResult> Collection<T> rankedSearchResultsByRank(
          Collection<T> results) {
    return results.stream().sorted(SEARCH_RESULT_RANK_COMPARATOR)
            .collect(toCollection(ArrayList::new));
  }

  public static Collection<ConceptSearchResult> getRankedConceptSearchResults(JCas jcas) {
    return rankedSearchResultsByRank(JCasUtil.select(jcas, ConceptSearchResult.class));
  }

  public static Collection<TripleSearchResult> getRankedTripleSearchResults(JCas jcas) {
    return rankedSearchResultsByRank(JCasUtil.select(jcas, TripleSearchResult.class));
  }

  public static Collection<Document> getRankedDocuments(JCas jcas) {
    return rankedSearchResultsByRank(JCasUtil.select(jcas, Document.class));
  }

  public static Collection<Passage> getRankedPassages(JCas jcas) {
    return rankedSearchResultsByRank(JCasUtil.select(jcas, Passage.class));
  }

  public static Collection<Answer> getAnswers(JCas jcas) {
    return JCasUtil.select(jcas, Answer.class);
  }

  public static Collection<Summary> getSummary(JCas jcas) {
    return JCasUtil.select(jcas, Summary.class);
  }
  
  public static List<String> getAnswerVariants(Answer answer) {
    List<String> variants = Arrays.asList(answer.getText());
    variants.addAll(FSCollectionFactory.create(answer.getVariants()));
    return variants;
  }

  public static Range<Integer> spanRange(Annotation annotation) {
    return Range.closedOpen(annotation.getBegin(), annotation.getEnd());
  }

  public static Range<Integer> spanRangeInSection(Passage passage) {
    return Range.closedOpen(passage.getOffsetInBeginSection(), passage.getOffsetInEndSection());
  }

  public static int hash(Passage passage) {
    return Objects.hash(passage.getUri(), passage.getDocId(), passage.getOffsetInBeginSection(),
            passage.getOffsetInEndSection(), passage.getBeginSection(), passage.getEndSection());
  }

}
