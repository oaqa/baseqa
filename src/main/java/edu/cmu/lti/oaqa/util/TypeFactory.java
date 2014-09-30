package edu.cmu.lti.oaqa.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.uima.fit.util.FSCollectionFactory;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.type.answer.Answer;
import edu.cmu.lti.oaqa.type.answer.CandidateAnswerVariant;
import edu.cmu.lti.oaqa.type.answer.Summary;
import edu.cmu.lti.oaqa.type.input.Question;
import edu.cmu.lti.oaqa.type.kb.Concept;
import edu.cmu.lti.oaqa.type.kb.ConceptMention;
import edu.cmu.lti.oaqa.type.kb.Entity;
import edu.cmu.lti.oaqa.type.kb.EntityMention;
import edu.cmu.lti.oaqa.type.kb.Relation;
import edu.cmu.lti.oaqa.type.retrieval.AbstractQuery;
import edu.cmu.lti.oaqa.type.retrieval.AtomicQueryConcept;
import edu.cmu.lti.oaqa.type.retrieval.ComplexQueryConcept;
import edu.cmu.lti.oaqa.type.retrieval.Document;
import edu.cmu.lti.oaqa.type.retrieval.Passage;
import edu.cmu.lti.oaqa.type.retrieval.QueryConcept;
import edu.cmu.lti.oaqa.type.retrieval.QueryOperator;

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

  public static Answer createAnswer(JCas jcas, String text) {
    Answer ret = new Answer(jcas);
    ret.setText(text);
    return ret;
  }

  public static Document createDocument(JCas jcas, String title, String docId, String uri,
          double score, String text, int rank, String queryString, String searchId,
          Collection<CandidateAnswerVariant> candidateAnswers) {
    Document ret = new Document(jcas);
    ret.setTitle(title);
    ret.setDocId(title);
    ret.setUri(uri);
    ret.setScore(score);
    ret.setText(text);
    ret.setRank(rank);
    ret.setQueryString(queryString);
    ret.setSearchId(searchId);
    ret.setCandidateAnswers(FSCollectionFactory.createFSArray(jcas, candidateAnswers));
    return ret;
  }

  public static Document createDocument(JCas jcas, String uri) {
    return createDocument(jcas, null, null, uri, Double.NaN, null, 0, null, null, new ArrayList<>());
  }

  public static Passage createPassage(JCas jcas, String title, String docId,
          int offsetInBeginSection, int offsetInEndSection, String beginSection, String endSection,
          String aspects, String uri, double score, String text, int rank, String queryString,
          String searchId, Collection<CandidateAnswerVariant> candidateAnswers) {
    Passage ret = new Passage(jcas);
    ret.setTitle(title);
    ret.setDocId(title);
    ret.setOffsetInBeginSection(offsetInBeginSection);
    ret.setOffsetInEndSection(offsetInEndSection);
    ret.setBeginSection(beginSection);
    ret.setEndSection(endSection);
    ret.setAspects(aspects);
    ret.setUri(uri);
    ret.setScore(score);
    ret.setText(text);
    ret.setRank(rank);
    ret.setQueryString(queryString);
    ret.setSearchId(searchId);
    ret.setCandidateAnswers(FSCollectionFactory.createFSArray(jcas, candidateAnswers));
    return ret;
  }

  public static Passage createPassage(JCas jcas, String uri, int offsetInBeginSection,
          int offsetInEndSection, String beginSection, String endSection, String text) {
    return createPassage(jcas, null, null, offsetInBeginSection, offsetInEndSection, beginSection,
            endSection, null, uri, Double.NaN, text, 0, null, null, new ArrayList<>());
  }

  public static Concept createConcept(JCas jcas, String name, List<String> uris,
          List<ConceptMention> mentions) {
    Concept ret = new Concept(jcas);
    ret.setName(name);
    ret.setUris(FSCollectionFactory.createStringList(jcas, uris));
    ret.setMentions(FSCollectionFactory.createFSList(jcas, mentions));
    return ret;
  }

  public static Concept createConcept(JCas jcas, String uri) {
    return createConcept(jcas, null, Arrays.asList(uri), new ArrayList<>());
  }

  public static ConceptMention createConceptMention(JCas jcas, int begin, int end, Concept concept) {
    ConceptMention ret = new ConceptMention(jcas);
    ret.setBegin(begin);
    ret.setEnd(end);
    ret.setConcept(concept);
    return ret;
  }

  public static ConceptMention createConceptMention(JCas jcas, int begin, int end, String name,
          List<String> uris) {
    ConceptMention ret = new ConceptMention(jcas);
    ret.setBegin(begin);
    ret.setEnd(end);
    ret.setConcept(createConcept(jcas, name, uris, Arrays.asList(ret)));
    return ret;
  }

  public static Entity createEntity(JCas jcas, String name, List<String> uris,
          List<ConceptMention> mentions) {
    Entity ret = new Entity(jcas);
    ret.setName(name);
    ret.setUris(FSCollectionFactory.createStringList(jcas, uris));
    ret.setMentions(FSCollectionFactory.createFSList(jcas, mentions));
    return ret;
  }

  public static Entity createEntity(JCas jcas, String uri) {
    return createEntity(jcas, null, Arrays.asList(uri), new ArrayList<>());
  }

  public static EntityMention createEntityMention(JCas jcas, int begin, int end, Concept concept) {
    EntityMention ret = new EntityMention(jcas);
    ret.setBegin(begin);
    ret.setEnd(end);
    ret.setConcept(concept);
    return ret;
  }

  public static EntityMention createEntityMention(JCas jcas, int begin, int end, String name,
          List<String> uris) {
    EntityMention ret = new EntityMention(jcas);
    ret.setBegin(begin);
    ret.setEnd(end);
    ret.setConcept(createEntity(jcas, name, uris, Arrays.asList(ret)));
    return ret;
  }

  public static Relation createRelation(JCas jcas, List<Entity> arguments, String name,
          List<String> uris, List<ConceptMention> mentions) {
    Relation ret = new Relation(jcas);
    ret.setArguments(FSCollectionFactory.createFSList(jcas, arguments));
    ret.setName(name);
    ret.setUris(FSCollectionFactory.createStringList(jcas, uris));
    ret.setMentions(FSCollectionFactory.createFSList(jcas, mentions));
    return ret;
  }

  public static Relation createRelation(JCas jcas, String subject, String predicate, String object) {
    return createRelation(
            jcas,
            Arrays.asList(createEntity(jcas, subject), createEntity(jcas, predicate),
                    createEntity(jcas, object)), null, new ArrayList<>(), new ArrayList<>());
  }

  public static Summary createSummary(JCas jcas, String text, List<String> variants, int rank) {
    Summary ret = new Summary(jcas);
    ret.setText(text);
    ret.setVariants(FSCollectionFactory.createStringList(jcas, variants));
    ret.setRank(rank);
    return ret;
  }

  public static Summary createSummary(JCas jcas, List<String> alternatives) {
    String text = alternatives.get(0);
    List<String> variants = alternatives.size() > 1 ? alternatives.subList(1, alternatives.size())
            : null;
    return createSummary(jcas, text, variants, 0);
  }

  public static Answer createAnswer(JCas jcas, String text, List<String> variants, int rank) {
    Answer ret = new Answer(jcas);
    ret.setText(text);
    ret.setVariants(FSCollectionFactory.createStringList(jcas, variants));
    ret.setRank(rank);
    return ret;
  }

  public static Answer createAnswer(JCas jcas, List<String> alternatives) {
    String text = alternatives.get(0);
    List<String> variants = alternatives.size() > 1 ? alternatives.subList(1, alternatives.size())
            : null;
    return createAnswer(jcas, text, variants, 0);
  }

  public static AbstractQuery createAbstractQuery(JCas jcas, List<QueryConcept> concepts) {
    AbstractQuery ret = new AbstractQuery(jcas);
    ret.setConcepts(FSCollectionFactory.createFSList(jcas, concepts));
    return ret;
  }

  public static AbstractQuery createAbstractQuery(JCas jcas, QueryConcept... concepts) {
    return createAbstractQuery(jcas, Arrays.asList(concepts));
  }

  public enum ConceptType {
    KEYWORD_TYPE, QATOKEN_TYPE, ANSWER_TYPE;
  }

  public static AtomicQueryConcept createAtomicQueryConcept(JCas jcas,
          List<String> namedEntityTypes, ConceptType conceptType, String text, String originalText) {
    AtomicQueryConcept ret = new AtomicQueryConcept(jcas);
    ret.setNamedEntityTypes(FSCollectionFactory.createStringList(jcas, namedEntityTypes));
    ret.setConceptType(conceptType.name());
    ret.setText(text);
    ret.setOriginalText(originalText);
    return ret;
  }

  public static AtomicQueryConcept createAtomicQueryConcept(JCas jcas, String namedEntityType,
          ConceptType conceptType, String text, String originalText) {
    return createAtomicQueryConcept(jcas, Arrays.asList(namedEntityType), conceptType, text,
            originalText);
  }

  public static AtomicQueryConcept createAtomicQueryConcept(JCas jcas, ConceptType conceptType,
          String text, String originalText) {
    return createAtomicQueryConcept(jcas, new ArrayList<>(), conceptType, text, originalText);
  }

  public static ComplexQueryConcept createComplexQueryConcept(JCas jcas,
          List<String> namedEntityTypes, ConceptType conceptType, QueryOperator operator,
          List<QueryConcept> operatorArgs) {
    ComplexQueryConcept ret = new ComplexQueryConcept(jcas);
    ret.setNamedEntityTypes(FSCollectionFactory.createStringList(jcas, namedEntityTypes));
    ret.setConceptType(conceptType.name());
    ret.setOperator(operator);
    ret.setOperatorArgs(FSCollectionFactory.createFSList(jcas, operatorArgs));
    return ret;
  }

  public static ComplexQueryConcept createComplexQueryConcept(JCas jcas,
          List<String> namedEntityTypes, ConceptType conceptType, QueryOperator operator,
          QueryConcept... operatorArgs) {
    return createComplexQueryConcept(jcas, namedEntityTypes, conceptType, operator,
            Arrays.asList(operatorArgs));
  }

  public static ComplexQueryConcept createComplexQueryConcept(JCas jcas, String namedEntityType,
          ConceptType conceptType, QueryOperator operator, List<QueryConcept> operatorArgs) {
    return createComplexQueryConcept(jcas, Arrays.asList(namedEntityType), conceptType, operator,
            operatorArgs);
  }

  public static ComplexQueryConcept createComplexQueryConcept(JCas jcas, String namedEntityType,
          ConceptType conceptType, QueryOperator operator, QueryConcept... operatorArgs) {
    return createComplexQueryConcept(jcas, namedEntityType, conceptType, operator,
            Arrays.asList(operatorArgs));
  }

  public static ComplexQueryConcept createComplexQueryConcept(JCas jcas, ConceptType conceptType,
          QueryOperator operator, List<QueryConcept> operatorArgs) {
    return createComplexQueryConcept(jcas, new ArrayList<>(), conceptType, operator, operatorArgs);
  }

  public static ComplexQueryConcept createComplexQueryConcept(JCas jcas, ConceptType conceptType,
          QueryOperator operator, QueryConcept... operatorArgs) {
    return createComplexQueryConcept(jcas, conceptType, operator, Arrays.asList(operatorArgs));
  }

  public enum QueryOperatorName {
    SYNONYM, PHRASE, TIE, WEIGHT, REQUIRED, RELATION, QUOTEDPHRASE;
  }

  public static QueryOperator createQueryOperator(JCas jcas, QueryOperatorName name,
          List<String> args) {
    QueryOperator ret = new QueryOperator(jcas);
    ret.setName(name.name());
    ret.setArgs(FSCollectionFactory.createStringList(jcas, args));
    return ret;
  }

  public static QueryOperator createQueryOperator(JCas jcas, QueryOperatorName name, String... args) {
    return createQueryOperator(jcas, name, Arrays.asList(args));
  }

}
