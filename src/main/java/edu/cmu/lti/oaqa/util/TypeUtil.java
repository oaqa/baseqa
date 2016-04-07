package edu.cmu.lti.oaqa.util;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.uima.cas.CASException;
import org.apache.uima.fit.util.FSCollectionFactory;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

import com.google.common.collect.Range;

import edu.cmu.lti.oaqa.type.answer.Answer;
import edu.cmu.lti.oaqa.type.answer.CandidateAnswerOccurrence;
import edu.cmu.lti.oaqa.type.answer.CandidateAnswerVariant;
import edu.cmu.lti.oaqa.type.answer.Summary;
import edu.cmu.lti.oaqa.type.input.Question;
import edu.cmu.lti.oaqa.type.kb.Concept;
import edu.cmu.lti.oaqa.type.kb.ConceptMention;
import edu.cmu.lti.oaqa.type.kb.ConceptType;
import edu.cmu.lti.oaqa.type.nlp.Focus;
import edu.cmu.lti.oaqa.type.nlp.LexicalAnswerType;
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
    return JCasUtil.select(jcas, Token.class).stream().sorted(Comparator.comparing(Token::getBegin))
            .collect(toList());
  }

  public static Focus getFocus(JCas jcas) {
    return JCasUtil.select(jcas, Focus.class).stream().findAny().orElse(null);
  }

  public static Token getHeadTokenOfAnnotation(Annotation annotation) {
    try {
      return getHeadTokenInRange(annotation.getCAS().getJCas(), annotation.getBegin(),
              annotation.getEnd());
    } catch (CASException e) {
      return null;
    }
  }

  public static Token getHeadTokenInRange(JCas jcas, int begin, int end) {
    // check if the span is smaller than a single token. If yes, return the covering token
    List<Token> tokens = firstNotEmpty(JCasUtil.selectCovered(jcas, Token.class, begin, end),
            JCasUtil.selectCovering(jcas, Token.class, begin, end));
    if (tokens.isEmpty()) {
      return null;
    }
    // get path to root for the first token
    List<Token> pathToRoot = new ArrayList<>();
    Token hop = tokens.get(0);
    do {
      pathToRoot.add(hop);
    } while ((hop = hop.getHead()) != null);
    // prune the path to contain only the common sub path to the root of each remaining token
    for (Token token : tokens) {
      hop = token;
      do {
        int index;
        if ((index = pathToRoot.indexOf(hop)) >= 0) {
          pathToRoot = pathToRoot.subList(index, pathToRoot.size());
          break;
        }
      } while ((hop = hop.getHead()) != null);
      assert false;
    }
    // get the head of the resulting path to root
    assert!pathToRoot.isEmpty();
    return pathToRoot.get(0);
  }

  public static <T extends Collection<?>> T firstNotEmpty(T first, T second) {
    if (first.isEmpty()) {
      return second;
    } else {
      return first;
    }
  }

  public static Collection<Concept> getConcepts(JCas jcas) {
    return JCasUtil.select(jcas, Concept.class);
  }

  public static String toString(Concept concept) {
    return TypeUtil.getConceptNames(concept) + " " + TypeUtil.getConceptIds(concept) + " " +
            TypeUtil.getConceptTypeNames(concept);
  }

  public static Collection<ConceptType> getConceptTypes(JCas jcas) {
    return JCasUtil.select(jcas, ConceptType.class);
  }

  public static Collection<ConceptType> getConceptTypes(Concept concept) {
    return FSCollectionFactory.create(concept.getTypes(), ConceptType.class);
  }

  public static Collection<String> getConceptTypeNames(Concept concept) {
    return getConceptTypes(concept).stream().map(ConceptType::getName)
            .collect(toCollection(ArrayList::new));
  }

  public static Collection<String> getConceptNames(Concept concept) {
    return FSCollectionFactory.create(concept.getNames());
  }

  public static String getConceptPreferredName(Concept concept) {
    return concept.getNames().getNthElement(0);
  }

  public static Collection<String> getConceptUris(Concept concept) {
    return FSCollectionFactory.create(concept.getUris());
  }

  public static Collection<String> getConceptIds(Concept concept) {
    return FSCollectionFactory.create(concept.getIds());
  }

  public static String getFirstConceptId(Concept concept) {
    return getConceptIds(concept).stream().findFirst().get();
  }

  public static void mergeConcept(JCas jcas, Concept dst, Concept src) {
    List<String> names = Stream.concat(getConceptNames(dst).stream(), getConceptNames(dst).stream())
            .filter(Objects::nonNull).distinct().collect(toList());
    dst.setNames(FSCollectionFactory.createStringList(jcas, names));
    List<String> ids = Stream.concat(getConceptIds(dst).stream(), getConceptIds(dst).stream())
            .filter(Objects::nonNull).distinct().collect(toList());
    dst.setIds(FSCollectionFactory.createStringList(jcas, ids));
    List<String> uris = Stream.concat(getConceptUris(dst).stream(), getConceptUris(dst).stream())
            .filter(Objects::nonNull).distinct().collect(toList());
    dst.setUris(FSCollectionFactory.createStringList(jcas, uris));
    List<ConceptType> types = Stream
            .concat(getConceptTypes(dst).stream(), getConceptTypes(dst).stream())
            .filter(Objects::nonNull).distinct().collect(toList());
    dst.setTypes(FSCollectionFactory.createFSList(jcas, types));
    List<ConceptMention> mentions = Stream
            .concat(getConceptMentions(dst).stream(), getConceptMentions(dst).stream())
            .filter(Objects::nonNull).distinct().collect(toList());
    dst.setMentions(FSCollectionFactory.createFSList(jcas, mentions));
  }

  public static Collection<ConceptMention> getConceptMentions(JCas jcas) {
    return JCasUtil.select(jcas, ConceptMention.class);
  }

  public static Collection<ConceptMention> getConceptMentions(Concept concept) {
    return FSCollectionFactory.create(concept.getMentions(), ConceptMention.class);
  }

  public static List<ConceptMention> getOrderedConceptMentions(JCas jcas) {
    return JCasUtil.select(jcas, ConceptMention.class).stream()
            .sorted(Comparator.comparing(ConceptMention::getBegin)).collect(toList());
  }

  public static Collection<AbstractQuery> getAbstractQueries(JCas jcas) {
    return JCasUtil.select(jcas, AbstractQuery.class);
  }

  @Deprecated
  public static AbstractQuery getAbstractQueriesCombined(JCas jcas) {
    List<QueryConcept> conceptsCombined = getAbstractQueries(jcas).stream()
            .flatMap(a -> FSCollectionFactory.create(a.getConcepts(), QueryConcept.class).stream())
            .collect(toList());
    return TypeFactory.createAbstractQuery(jcas, conceptsCombined);
  }

  public static Collection<QueryConcept> getQueryConcepts(AbstractQuery aquery) {
    return FSCollectionFactory.create(aquery.getConcepts(), QueryConcept.class);
  }

  public static final Comparator<SearchResult> SEARCH_RESULT_SCORE_COMPARATOR = Comparator
          .comparing(SearchResult::getScore, Comparator.reverseOrder());

  public static <T extends SearchResult> List<T> rankedSearchResultsByScore(Collection<T> results,
          int hitSize) {
    List<T> sorted = results.stream().sorted(SEARCH_RESULT_SCORE_COMPARATOR).limit(hitSize)
            .collect(toList());
    IntStream.range(0, sorted.size()).forEach(rank -> sorted.get(rank).setRank(rank));
    return sorted;
  }

  public static final Comparator<SearchResult> SEARCH_RESULT_RANK_COMPARATOR = Comparator
          .comparing(SearchResult::getRank);

  private static <T extends SearchResult> List<T> rankedSearchResultsByRank(Collection<T> results) {
    return results.stream().sorted(SEARCH_RESULT_RANK_COMPARATOR).collect(toList());
  }

  public static List<ConceptSearchResult> getRankedConceptSearchResults(JCas jcas) {
    return rankedSearchResultsByRank(JCasUtil.select(jcas, ConceptSearchResult.class));
  }

  public static String toString(ConceptSearchResult result) {
    return result.getScore() + " " + result.getUri() + " " + toString(result.getConcept());
  }

  public static List<TripleSearchResult> getRankedTripleSearchResults(JCas jcas) {
    return rankedSearchResultsByRank(JCasUtil.select(jcas, TripleSearchResult.class));
  }

  public static List<Document> getRankedDocuments(JCas jcas) {
    return rankedSearchResultsByRank(JCasUtil.select(jcas, Document.class));
  }

  public static String toString(Document result) {
    return  result.getScore() + " " + result.getUri() + " " + result.getTitle();
  }

  public static List<Passage> getRankedPassages(JCas jcas) {
    return rankedSearchResultsByRank(JCasUtil.select(jcas, Passage.class));
  }

  public static Collection<LexicalAnswerType> getLexicalAnswerTypes(JCas jcas) {
    return JCasUtil.select(jcas, LexicalAnswerType.class);
  }

  public static final Comparator<Answer> ANSWER_SCORE_COMPARATOR = Comparator
          .comparing(Answer::getScore, Comparator.reverseOrder());

  public static List<Answer> getRankedAnswers(JCas jcas) {
    return JCasUtil.select(jcas, Answer.class).stream().sorted(ANSWER_SCORE_COMPARATOR)
            .collect(toList());
  }

  public static final Comparator<Summary> SUMMARY_SCORE_COMPARATOR = Comparator
          .comparing(Summary::getScore, Comparator.reverseOrder());

  public static List<Summary> getRankedSummary(JCas jcas) {
    return JCasUtil.select(jcas, Summary.class).stream().sorted(SUMMARY_SCORE_COMPARATOR)
            .collect(toList());
  }

  public static Collection<CandidateAnswerVariant> getCandidateAnswerVariants(JCas jcas) {
    return JCasUtil.select(jcas, CandidateAnswerVariant.class);
  }

  public static Collection<CandidateAnswerVariant> getCandidateAnswerVariants(Answer answer) {
    return FSCollectionFactory.create(answer.getVariants(), CandidateAnswerVariant.class);
  }

  public static List<String> getCandidateAnswerVariantNames(Answer answer) {
    return getCandidateAnswerVariants(answer).stream().map(TypeUtil::getCandidateAnswerVariantNames)
            .flatMap(Collection::stream).collect(toList());
  }

  public static Collection<String> getCandidateAnswerVariantNames(CandidateAnswerVariant cav) {
    return FSCollectionFactory.create(cav.getNames());
  }

  public static Collection<CandidateAnswerOccurrence> getCandidateAnswerOccurrences(JCas jcas) {
    return JCasUtil.select(jcas, CandidateAnswerOccurrence.class);
  }

  public static Collection<CandidateAnswerOccurrence> getCandidateAnswerOccurrences(
          CandidateAnswerVariant cav) {
    return FSCollectionFactory.create(cav.getOccurrences(), CandidateAnswerOccurrence.class);
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
