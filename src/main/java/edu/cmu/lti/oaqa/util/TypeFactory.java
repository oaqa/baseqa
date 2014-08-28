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
import edu.cmu.lti.oaqa.type.kb.Relation;
import edu.cmu.lti.oaqa.type.retrieval.Document;
import edu.cmu.lti.oaqa.type.retrieval.Passage;

public class TypeFactory {

  public static Question createQuestion(String id, String source, String questionType, String text,
          JCas jcas) {
    Question ret = new Question(jcas);
    ret.setBegin(0);
    ret.setEnd(text.length());
    ret.setId(id);
    ret.setSource(source);
    ret.setQuestionType(questionType);
    ret.setText(text);
    return ret;
  }

  public static Answer createAnswer(String text, JCas jcas) {
    Answer ret = new Answer(jcas);
    ret.setText(text);
    return ret;
  }

  public static Document createDocument(String title, String docId, String uri, double score,
          String text, int rank, String queryString, String searchId,
          Collection<CandidateAnswerVariant> candidateAnswers, JCas jcas) {
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

  public static Document createDocument(String uri, JCas jcas) {
    return createDocument(null, null, uri, Double.NaN, null, 0, null, null, new ArrayList<>(), jcas);
  }

  public static Passage createPassage(String title, String docId, int offsetInBeginSection,
          int offsetInEndSection, String beginSection, String endSection, String aspects,
          String uri, double score, String text, int rank, String queryString, String searchId,
          Collection<CandidateAnswerVariant> candidateAnswers, JCas jcas) {
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

  public static Passage createPassage(String uri, int offsetInBeginSection, int offsetInEndSection,
          String beginSection, String endSection, String text, JCas jcas) {
    return createPassage(null, null, offsetInBeginSection, offsetInEndSection, beginSection,
            endSection, null, uri, Double.NaN, text, 0, null, null, new ArrayList<>(), jcas);
  }

  public static Concept createConcept(String name, List<String> uris,
          List<ConceptMention> mentions, JCas jcas) {
    Concept ret = new Concept(jcas);
    ret.setName(name);
    ret.setUris(FSCollectionFactory.createStringList(jcas, uris));
    ret.setMentions(FSCollectionFactory.createFSList(jcas, mentions));
    return ret;
  }

  public static Concept createConcept(String id, JCas jcas) {
    return createConcept(null, Arrays.asList(id), new ArrayList<>(), jcas);
  }

  public static Relation createRelation(List<Entity> arguments, String name, List<String> uris,
          List<ConceptMention> mentions, JCas jcas) {
    Relation ret = new Relation(jcas);
    ret.setArguments(FSCollectionFactory.createFSList(jcas, arguments));
    ret.setName(name);
    ret.setUris(FSCollectionFactory.createStringList(jcas, uris));
    ret.setMentions(FSCollectionFactory.createFSList(jcas, mentions));
    return ret;
  }

  public static Relation createRelation(String subject, String predicate, String object, JCas jcas) {
    return createRelation(
            Arrays.asList(createEntity(subject, jcas), createEntity(predicate, jcas),
                    createEntity(object, jcas)), null, new ArrayList<>(), new ArrayList<>(), jcas);
  }

  public static Entity createEntity(String name, List<String> uris, List<ConceptMention> mentions,
          JCas jcas) {
    Entity ret = new Entity(jcas);
    ret.setName(name);
    ret.setUris(FSCollectionFactory.createStringList(jcas, uris));
    ret.setMentions(FSCollectionFactory.createFSList(jcas, mentions));
    return ret;
  }

  public static Entity createEntity(String uri, JCas jcas) {
    return createEntity(null, Arrays.asList(uri), new ArrayList<>(), jcas);
  }

  public static Summary createSummary(String text, List<String> variants, int rank, JCas jcas) {
    Summary ret = new Summary(jcas);
    ret.setText(text);
    ret.setVariants(FSCollectionFactory.createStringList(jcas, variants));
    ret.setRank(rank);
    return ret;
  }

  public static Summary createSummary(List<String> alternatives, JCas jcas) {
    String text = alternatives.get(0);
    List<String> variants = alternatives.size() > 1 ? alternatives.subList(1, alternatives.size())
            : null;
    return createSummary(text, variants, 0, jcas);
  }

  public static Answer createAnswer(String text, List<String> variants, int rank, JCas jcas) {
    Answer ret = new Answer(jcas);
    ret.setText(text);
    ret.setVariants(FSCollectionFactory.createStringList(jcas, variants));
    ret.setRank(rank);
    return ret;
  }

  public static Answer createAnswer(List<String> alternatives, JCas jcas) {
    String text = alternatives.get(0);
    List<String> variants = alternatives.size() > 1 ? alternatives.subList(1, alternatives.size())
            : null;
    return createAnswer(text, variants, 0, jcas);
  }

}
