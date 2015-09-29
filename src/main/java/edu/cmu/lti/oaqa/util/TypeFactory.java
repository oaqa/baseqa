package edu.cmu.lti.oaqa.util;

import edu.cmu.lti.oaqa.type.answer.Answer;
import edu.cmu.lti.oaqa.type.answer.CandidateAnswerOccurrence;
import edu.cmu.lti.oaqa.type.answer.CandidateAnswerVariant;
import edu.cmu.lti.oaqa.type.answer.Summary;
import edu.cmu.lti.oaqa.type.input.Question;
import edu.cmu.lti.oaqa.type.kb.Concept;
import edu.cmu.lti.oaqa.type.kb.ConceptMention;
import edu.cmu.lti.oaqa.type.kb.ConceptType;
import edu.cmu.lti.oaqa.type.kb.Triple;
import edu.cmu.lti.oaqa.type.nlp.Focus;
import edu.cmu.lti.oaqa.type.nlp.LexicalAnswerType;
import edu.cmu.lti.oaqa.type.nlp.Token;
import edu.cmu.lti.oaqa.type.retrieval.*;
import org.apache.uima.fit.util.FSCollectionFactory;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.StringArray;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class TypeFactory {

  public static Question createQuestion(JCas jcas, String id, String source, String questionType,
          String text) {
    Question ret = new Question(jcas);
    ret.setBegin(0);
    ret.setEnd(text.length());
    ret.setId(id);
    ret.setSource(source);
    ret.setQuestionType(questionType);
    ret.setText(text);
    return ret;
  }

  public static Token createToken(JCas jcas, int begin, int end, Token head, String depLabel,
          String semanticType, String partOfSpeech, String lemmaForm, boolean isMainReference,
          boolean isVariable, String determiner) {
    Token ret = new Token(jcas);
    ret.setBegin(begin);
    ret.setEnd(end);
    ret.setHead(head);
    ret.setDepLabel(depLabel);
    ret.setSemanticType(semanticType);
    ret.setPartOfSpeech(partOfSpeech);
    ret.setLemmaForm(lemmaForm);
    ret.setIsMainReference(isMainReference);
    ret.setIsVariable(isVariable);
    ret.setDeterminer(determiner);
    return ret;
  }

  public static Token createToken(JCas jcas, int begin, int end) {
    return createToken(jcas, begin, end, TypeConstants.HEAD_UNKNOWN, TypeConstants.DEPLABEL_UNKNOWN,
            TypeConstants.SEMANTIC_TYPE_UNKNOWN, TypeConstants.PART_OF_SPEECH_UNKNOWN,
            TypeConstants.LEMMA_FORM_UNKNOWN, TypeConstants.IS_MAIN_REFERENCE_UNKNOWN,
            TypeConstants.IS_VARIABLE_UNKNOWN, TypeConstants.DETERMINER_UNKNOWN);
  }

  public static Focus createFocus(JCas jcas, Token token, String label) {
    Focus ret = new Focus(jcas);
    ret.setToken(token);
    ret.setLabel(label);
    return ret;
  }

  public static Concept createConcept(JCas jcas, List<String> names, List<String> uris,
          List<String> ids, List<ConceptMention> mentions, List<ConceptType> types) {
    Concept ret = new Concept(jcas);
    ret.setNames(FSCollectionFactory.createStringList(jcas, names));
    ret.setUris(FSCollectionFactory.createStringList(jcas, uris));
    ret.setIds(FSCollectionFactory.createStringList(jcas, ids));
    ret.setMentions(FSCollectionFactory.createFSList(jcas, mentions));
    mentions.stream().forEach(mention -> mention.setConcept(ret));
    ret.setTypes(FSCollectionFactory.createFSList(jcas, types));
    return ret;
  }

  public static Concept createConcept(JCas jcas, List<String> names, String id,
          ConceptMention mentions, List<ConceptType> types) {
    return createConcept(jcas, names, new ArrayList<>(), Collections.singletonList(id),
            Collections.singletonList(mentions), types);
  }

  public static Concept createConcept(JCas jcas, ConceptMention mention, ConceptType type) {
    String name = mention.getCoveredText();
    return createConcept(jcas, Collections.singletonList(name), name, mention,
            Collections.singletonList(type));
  }

  public static Concept createConcept(JCas jcas, String name, String id, List<ConceptType> types) {
    return createConcept(jcas, Collections.singletonList(name), new ArrayList<>(),
            Collections.singletonList(id), new ArrayList<>(), types);
  }

  public static Concept createConcept(JCas jcas, String name, String uri) {
    return createConcept(jcas, Collections.singletonList(name), Collections.singletonList(uri),
            new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
  }

  public static Concept createConcept(JCas jcas, String uri) {
    return createConcept(jcas, TypeConstants.NAME_UNKNOWN, uri);
  }

  public static ConceptType createConceptType(JCas jcas, String id, String name,
          String abbreviation) {
    ConceptType ret = new ConceptType(jcas);
    ret.setId(id);
    ret.setName(name);
    ret.setAbbreviation(abbreviation);
    return ret;
  }

  public static ConceptType createConceptType(JCas jcas, String name) {
    return createConceptType(jcas, TypeConstants.CONCEPT_TYPE_ID_UNKNOWN, name, name);
  }

  public static ConceptMention createConceptMention(JCas jcas, int begin, int end, Concept concept,
          String matchedName, double score) {
    ConceptMention ret = new ConceptMention(jcas);
    ret.setBegin(begin);
    ret.setEnd(end);
    ret.setConcept(concept);
    ret.setMatchedName(matchedName);
    ret.setScore(score);
    return ret;
  }

  public static ConceptMention createConceptMention(JCas jcas, int begin, int end,
          String matchedName, double score) {
    return createConceptMention(jcas, begin, end, null, matchedName, score);
  }

  public static ConceptMention createConceptMention(JCas jcas, int begin, int end) {
    return createConceptMention(jcas, begin, end, null,
            jcas.getDocumentText().substring(begin, end), TypeConstants.SCORE_UNKNOWN);
  }

  public static Triple createTriple(JCas jcas, String subject, String predicate, String object,
          boolean isObjUri) {
    Triple ret = new Triple(jcas);
    ret.setSubject(subject);
    ret.setPredicate(predicate);
    ret.setObject(object);
    ret.setIsObjUri(isObjUri);
    return ret;
  }

  public static Triple createTriple(JCas jcas, String subject, String predicate, String object) {
    return createTriple(jcas, subject, predicate, object, true);
  }

  public static Summary createSummary(JCas jcas, String text, double score, List<String> variants) {
    Summary ret = new Summary(jcas);
    ret.setText(text);
    ret.setScore(score);
    ret.setVariants(FSCollectionFactory.createStringList(jcas, variants));
    return ret;
  }

  public static Summary createSummary(JCas jcas, List<String> alternatives) {
    String text = alternatives.get(0);
    List<String> variants = alternatives.subList(1, alternatives.size());
    return createSummary(jcas, text, TypeConstants.SCORE_UNKNOWN, variants);
  }

  public static LexicalAnswerType createLexicalAnswerType(JCas jcas, Token token, String label) {
    LexicalAnswerType ret = new LexicalAnswerType(jcas);
    ret.setToken(token);
    ret.setLabel(label);
    return ret;
  }

  public static LexicalAnswerType createLexicalAnswerType(JCas jcas, String label) {
    return createLexicalAnswerType(jcas, TypeConstants.TOKEN_UNKNOWN, label);
  }

  public static Answer createAnswer(JCas jcas, String text, double score,
          List<CandidateAnswerVariant> cavs) {
    Answer ret = new Answer(jcas);
    ret.setText(text);
    ret.setScore(score);
    ret.setVariants(FSCollectionFactory.createFSList(jcas, cavs));
    return ret;
  }

  public static Answer createAnswer(JCas jcas, double score, List<CandidateAnswerVariant> cavs) {
    Answer ret = new Answer(jcas);
    Optional<String> name = cavs.stream().map(TypeUtil::getCandidateAnswerVariantNames)
            .flatMap(Collection::stream).findFirst();
    if (name.isPresent()) {
      ret.setText(name.get());
    }
    ret.setScore(score);
    ret.setVariants(FSCollectionFactory.createFSList(jcas, cavs));
    return ret;
  }

  public static Answer createAnswer(JCas jcas, String text) {
    return createAnswer(jcas, Collections.singletonList(text));
  }

  public static Answer createAnswer(JCas jcas, List<String> names) {
    String text = names.get(0);
    List<CandidateAnswerVariant> variants = names.stream()
            .map(avariantText -> createCandidateAnswerVariant(jcas, avariantText))
            .collect(toList());
    return createAnswer(jcas, text, TypeConstants.RANK_UNKNOWN, variants);
  }

  public static CandidateAnswerVariant createCandidateAnswerVariant(JCas jcas,
          List<CandidateAnswerOccurrence> caos, List<String> names, String docId) {
    CandidateAnswerVariant ret = new CandidateAnswerVariant(jcas);
    ret.setOccurrences(FSCollectionFactory.createFSList(jcas, caos));
    ret.setNames(FSCollectionFactory.createStringList(jcas, names));
    ret.setDocId(docId);
    return ret;
  }

  public static CandidateAnswerVariant createCandidateAnswerVariant(JCas jcas,
          List<CandidateAnswerOccurrence> caos, List<String> names) {
    return createCandidateAnswerVariant(jcas, caos, names, TypeConstants.DOC_ID_UNKNOWN);
  }

  public static CandidateAnswerVariant createCandidateAnswerVariant(JCas jcas,
          List<CandidateAnswerOccurrence> caos) {
    return createCandidateAnswerVariant(jcas, caos,
            caos.stream().map(CandidateAnswerOccurrence::getCoveredText).collect(toList()));
  }

  public static CandidateAnswerVariant createCandidateAnswerVariant(JCas jcas, String text) {
    return createCandidateAnswerVariant(jcas, new ArrayList<>(), Collections.singletonList(text));
  }

  public static CandidateAnswerOccurrence createCandidateAnswerOccurrence(JCas jcas, int begin,
          int end, String text, String mentionType) {
    CandidateAnswerOccurrence ret = new CandidateAnswerOccurrence(jcas, begin, end);
    ret.setText(text);
    ret.setMentionType(mentionType);
    return ret;
  }

  public static CandidateAnswerOccurrence createCandidateAnswerOccurrence(JCas jcas, int begin,
          int end) {
    CandidateAnswerOccurrence ret = new CandidateAnswerOccurrence(jcas, begin, end);
    ret.setText(ret.getCoveredText());
    ret.setMentionType("NAME");
    return ret;
  }

  public static AbstractQuery createAbstractQuery(JCas jcas,
          List<? extends QueryConcept> concepts) {
    AbstractQuery ret = new AbstractQuery(jcas);
    ret.setConcepts(FSCollectionFactory.createFSList(jcas, concepts));
    return ret;
  }

  public static AbstractQuery createAbstractQuery(JCas jcas, QueryConcept... concepts) {
    return createAbstractQuery(jcas, Arrays.asList(concepts));
  }

  public static AtomicQueryConcept createAtomicQueryConcept(JCas jcas,
          List<String> namedEntityTypes, TypeConstants.ConceptType conceptType, String text,
          String originalText) {
    AtomicQueryConcept ret = new AtomicQueryConcept(jcas);
    ret.setNamedEntityTypes(FSCollectionFactory.createStringList(jcas, namedEntityTypes));
    ret.setConceptType(conceptType.name());
    ret.setText(text);
    ret.setOriginalText(originalText);
    return ret;
  }

  public static AtomicQueryConcept createAtomicQueryConcept(JCas jcas, String namedEntityType,
          TypeConstants.ConceptType conceptType, String text, String originalText) {
    return createAtomicQueryConcept(jcas, Collections.singletonList(namedEntityType), conceptType,
            text, originalText);
  }

  public static AtomicQueryConcept createAtomicQueryConcept(JCas jcas,
          TypeConstants.ConceptType conceptType, String text, String originalText) {
    return createAtomicQueryConcept(jcas, new ArrayList<>(), conceptType, text, originalText);
  }

  public static AtomicQueryConcept createAtomicQueryConcept(JCas jcas, String text,
          String originalText) {
    return createAtomicQueryConcept(jcas, new ArrayList<>(), TypeConstants.ConceptType.KEYWORD_TYPE,
            text, originalText);
  }

  public static AtomicQueryConcept createAtomicQueryConcept(JCas jcas, String text) {
    return createAtomicQueryConcept(jcas, new ArrayList<>(), TypeConstants.ConceptType.KEYWORD_TYPE,
            text, text);
  }

  public static ComplexQueryConcept createComplexQueryConcept(JCas jcas,
          List<String> namedEntityTypes, TypeConstants.ConceptType conceptType,
          QueryOperator operator, List<? extends QueryConcept> operatorArgs) {
    ComplexQueryConcept ret = new ComplexQueryConcept(jcas);
    ret.setNamedEntityTypes(FSCollectionFactory.createStringList(jcas, namedEntityTypes));
    ret.setConceptType(conceptType.name());
    ret.setOperator(operator);
    ret.setOperatorArgs(FSCollectionFactory.createFSList(jcas, operatorArgs));
    return ret;
  }

  public static ComplexQueryConcept createComplexQueryConcept(JCas jcas,
          List<String> namedEntityTypes, TypeConstants.ConceptType conceptType,
          QueryOperator operator, QueryConcept... operatorArgs) {
    return createComplexQueryConcept(jcas, namedEntityTypes, conceptType, operator,
            Arrays.asList(operatorArgs));
  }

  public static ComplexQueryConcept createComplexQueryConcept(JCas jcas, String namedEntityType,
          TypeConstants.ConceptType conceptType, QueryOperator operator,
          List<? extends QueryConcept> operatorArgs) {
    return createComplexQueryConcept(jcas, Collections.singletonList(namedEntityType), conceptType,
            operator, operatorArgs);
  }

  public static ComplexQueryConcept createComplexQueryConcept(JCas jcas, String namedEntityType,
          TypeConstants.ConceptType conceptType, QueryOperator operator,
          QueryConcept... operatorArgs) {
    return createComplexQueryConcept(jcas, namedEntityType, conceptType, operator,
            Arrays.asList(operatorArgs));
  }

  public static ComplexQueryConcept createComplexQueryConcept(JCas jcas,
          TypeConstants.ConceptType conceptType, QueryOperator operator,
          List<? extends QueryConcept> operatorArgs) {
    return createComplexQueryConcept(jcas, new ArrayList<>(), conceptType, operator, operatorArgs);
  }

  public static ComplexQueryConcept createComplexQueryConcept(JCas jcas, QueryOperator operator,
          List<? extends QueryConcept> operatorArgs) {
    return createComplexQueryConcept(jcas, new ArrayList<>(),
            TypeConstants.ConceptType.KEYWORD_TYPE, operator, operatorArgs);
  }

  public static ComplexQueryConcept createComplexQueryConcept(JCas jcas,
          TypeConstants.ConceptType conceptType, QueryOperator operator,
          QueryConcept... operatorArgs) {
    return createComplexQueryConcept(jcas, conceptType, operator, Arrays.asList(operatorArgs));
  }

  public static ComplexQueryConcept createComplexQueryConcept(JCas jcas, QueryOperator operator,
          QueryConcept... operatorArgs) {
    return createComplexQueryConcept(jcas, TypeConstants.ConceptType.KEYWORD_TYPE, operator,
            Arrays.asList(operatorArgs));
  }

  public static QueryOperator createQueryOperator(JCas jcas, TypeConstants.QueryOperatorName name,
          List<Object> args) {
    QueryOperator ret = new QueryOperator(jcas);
    ret.setName(name.name());
    List<String> argStrings = args.stream().map(Object::toString).collect(toList());
    ret.setArgs(FSCollectionFactory.createStringList(jcas, argStrings));
    return ret;
  }

  public static QueryOperator createQueryOperator(JCas jcas, TypeConstants.QueryOperatorName name,
          Object... args) {
    return createQueryOperator(jcas, name, Arrays.asList(args));
  }

  public static Document createDocument(JCas jcas, String uri, double score, String text, int rank,
          String queryString, String searchId, Collection<CandidateAnswerVariant> candidateAnswers,
          String title, String docId, List<String> sections, List<String> sectionLabels) {
    Document ret = new Document(jcas);
    ret.setUri(uri);
    ret.setScore(score);
    ret.setText(text);
    ret.setRank(rank);
    ret.setQueryString(queryString);
    ret.setSearchId(searchId);
    ret.setCandidateAnswers(FSCollectionFactory.createFSArray(jcas, candidateAnswers));
    ret.setTitle(title);
    ret.setDocId(docId);
    ret.setSections((StringArray) FSCollectionFactory.createStringArray(jcas, sections));
    ret.setSectionLabels((StringArray) FSCollectionFactory.createStringArray(jcas, sectionLabels));
    return ret;
  }

  public static Document createDocument(JCas jcas, String uri, String text, int rank,
          String queryString, String title, String docId) {
    return TypeFactory.createDocument(jcas, uri, TypeConstants.SCORE_UNKNOWN, text, rank,
            queryString, TypeConstants.SEARCH_ID_UNKNOWN, new ArrayList<>(), title, docId,
            new ArrayList<>(), new ArrayList<>());
  }

  public static Document createDocument(JCas jcas, String uri) {
    return createDocument(jcas, uri, TypeConstants.SCORE_UNKNOWN, TypeConstants.TEXT_UNKNOWN,
            TypeConstants.RANK_UNKNOWN, TypeConstants.QUERY_STRING_UNKNOWN,
            TypeConstants.SEARCH_ID_UNKNOWN, new ArrayList<>(), TypeConstants.TITLE_UNKNOWN,
            TypeConstants.DOC_ID_UNKNOWN, new ArrayList<>(), new ArrayList<>());
  }

  public static Passage createPassage(JCas jcas, String uri, double score, String text, int rank,
          String queryString, String searchId, Collection<CandidateAnswerVariant> candidateAnswers,
          String title, String docId, int offsetInBeginSection, int offsetInEndSection,
          String beginSection, String endSection, String aspects) {
    Passage ret = new Passage(jcas);
    ret.setUri(uri);
    ret.setScore(score);
    ret.setText(text);
    ret.setRank(rank);
    ret.setQueryString(queryString);
    ret.setSearchId(searchId);
    ret.setCandidateAnswers(FSCollectionFactory.createFSArray(jcas, candidateAnswers));
    ret.setTitle(title);
    ret.setDocId(docId);
    ret.setOffsetInBeginSection(offsetInBeginSection);
    ret.setOffsetInEndSection(offsetInEndSection);
    ret.setBeginSection(beginSection);
    ret.setEndSection(endSection);
    ret.setAspects(aspects);
    return ret;
  }

  public static Passage createPassage(JCas jcas, String uri, String text, String docId,
          int offsetInBeginSection, int offsetInEndSection, String beginSection,
          String endSection) {
    return createPassage(jcas, uri, TypeConstants.SCORE_UNKNOWN, text, TypeConstants.RANK_UNKNOWN,
            TypeConstants.QUERY_STRING_UNKNOWN, TypeConstants.SEARCH_ID_UNKNOWN, new ArrayList<>(),
            TypeConstants.TITLE_UNKNOWN, docId, offsetInBeginSection, offsetInEndSection,
            beginSection, endSection, TypeConstants.ASPECTS_UNKNOWN);
  }

  public static Passage createPassage(JCas jcas, String uri, String text, int offsetInBeginSection,
          int offsetInEndSection, String beginSection, String endSection) {
    return createPassage(jcas, uri, TypeConstants.SCORE_UNKNOWN, text, TypeConstants.RANK_UNKNOWN,
            TypeConstants.QUERY_STRING_UNKNOWN, TypeConstants.SEARCH_ID_UNKNOWN, new ArrayList<>(),
            TypeConstants.TITLE_UNKNOWN, TypeConstants.DOC_ID_UNKNOWN, offsetInBeginSection,
            offsetInEndSection, beginSection, endSection, TypeConstants.ASPECTS_UNKNOWN);
  }

  public static ConceptSearchResult createConceptSearchResult(JCas jcas, Concept concept,
          String uri, double score, String text, int rank, String queryString, String searchId,
          Collection<CandidateAnswerVariant> candidateAnswers) {
    ConceptSearchResult ret = new ConceptSearchResult(jcas);
    ret.setConcept(concept);
    ret.setUri(uri);
    ret.setScore(score);
    ret.setText(text);
    ret.setRank(rank);
    ret.setQueryString(queryString);
    ret.setSearchId(searchId);
    ret.setCandidateAnswers(FSCollectionFactory.createFSArray(jcas, candidateAnswers));
    return ret;
  }

  public static ConceptSearchResult createConceptSearchResult(JCas jcas, Concept concept,
          String uri, double score, String text, String queryString) {
    return createConceptSearchResult(jcas, concept, uri, score, text, TypeConstants.RANK_UNKNOWN,
            queryString, TypeConstants.SEARCH_ID_UNKNOWN, new ArrayList<>());
  }

  public static ConceptSearchResult createConceptSearchResult(JCas jcas, Concept concept,
          String uri) {
    return createConceptSearchResult(jcas, concept, uri, TypeConstants.SCORE_UNKNOWN,
            TypeConstants.TEXT_UNKNOWN, TypeConstants.QUERY_STRING_UNKNOWN);
  }

  public static TripleSearchResult createTripleSearchResult(JCas jcas, Triple triple, String uri,
          double score, String text, int rank, String queryString, String searchId,
          Collection<CandidateAnswerVariant> candidateAnswers) {
    TripleSearchResult ret = new TripleSearchResult(jcas);
    ret.setTriple(triple);
    ret.setUri(uri);
    ret.setScore(score);
    ret.setText(text);
    ret.setRank(rank);
    ret.setQueryString(queryString);
    ret.setSearchId(searchId);
    ret.setCandidateAnswers(FSCollectionFactory.createFSArray(jcas, candidateAnswers));
    return ret;
  }

  public static TripleSearchResult createTripleSearchResult(JCas jcas, Triple triple,
          String queryString) {
    return createTripleSearchResult(jcas, triple, TypeConstants.URI_UNKNOWN,
            TypeConstants.SCORE_UNKNOWN, TypeConstants.TEXT_UNKNOWN, TypeConstants.RANK_UNKNOWN,
            queryString, TypeConstants.SEARCH_ID_UNKNOWN, new ArrayList<>());
  }

  public static TripleSearchResult createTripleSearchResult(JCas jcas, Triple triple) {
    return createTripleSearchResult(jcas, triple, TypeConstants.URI_UNKNOWN,
            TypeConstants.SCORE_UNKNOWN, TypeConstants.TEXT_UNKNOWN, TypeConstants.RANK_UNKNOWN,
            TypeConstants.QUERY_STRING_UNKNOWN, TypeConstants.SEARCH_ID_UNKNOWN, new ArrayList<>());
  }

  public static Search createSearch(JCas jcas, String query, List<SearchResult> hitList,
          AbstractQuery abstractQuery, String searchId) {
    Search ret = new Search(jcas);
    ret.setQuery(query);
    ret.setHitList(FSCollectionFactory.createFSArray(jcas, hitList));
    ret.setAbstractQuery(abstractQuery);
    ret.setSearchId(searchId);
    return ret;
  }

}
