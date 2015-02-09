package edu.cmu.lti.oaqa.baseqa.collection.json;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.uima.fit.util.FSCollectionFactory;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.baseqa.collection.json.gson.QuestionType;
import edu.cmu.lti.oaqa.baseqa.collection.json.gson.Snippet;
import edu.cmu.lti.oaqa.baseqa.collection.json.gson.TestFactoidQuestion;
import edu.cmu.lti.oaqa.baseqa.collection.json.gson.TestListQuestion;
import edu.cmu.lti.oaqa.baseqa.collection.json.gson.TestQuestion;
import edu.cmu.lti.oaqa.baseqa.collection.json.gson.TestSummaryQuestion;
import edu.cmu.lti.oaqa.baseqa.collection.json.gson.TestYesNoQuestion;
import edu.cmu.lti.oaqa.baseqa.collection.json.gson.Triple;
import edu.cmu.lti.oaqa.type.answer.Answer;
import edu.cmu.lti.oaqa.type.answer.Summary;
import edu.cmu.lti.oaqa.type.input.Question;
import edu.cmu.lti.oaqa.type.kb.Concept;
import edu.cmu.lti.oaqa.type.retrieval.ConceptSearchResult;
import edu.cmu.lti.oaqa.type.retrieval.Document;
import edu.cmu.lti.oaqa.type.retrieval.TripleSearchResult;
import edu.cmu.lti.oaqa.util.TypeUtil;

public class JsonCasConsumerHelper {

  public static TestQuestion getQuestionFromIndex(JCas jcas, int documentLimit, int snippetLimit,
          int conceptLimit, int tripleLimit, int factoidAnswerLimit, int listAnswerLimit) {
    Question question = TypeUtil.getQuestion(jcas);
    String id = question.getId();
    // question text and type are required
    QuestionType type = convertQuestionType(question.getQuestionType());
    String body = question.getText();
    // retrieve documents, snippets, concepts, and triples from CAS
    List<String> documents = TypeUtil.getRankedDocuments(jcas).stream().limit(documentLimit)
            .map(Document::getUri).collect(toList());
    List<Snippet> snippets = TypeUtil
            .getRankedPassages(jcas)
            .stream()
            .limit(snippetLimit)
            .map(passage -> new Snippet(passage.getUri(), passage.getText(), passage
                    .getOffsetInBeginSection(), passage.getOffsetInEndSection(), passage
                    .getBeginSection(), passage.getEndSection())).collect(toList());
    List<String> concepts = TypeUtil.getRankedConceptSearchResults(jcas).stream()
            .limit(conceptLimit).map(ConceptSearchResult::getConcept).map(Concept::getUris)
            .map(FSCollectionFactory::create).flatMap(Collection::stream).collect(toList());
    List<Triple> triples = TypeUtil
            .getRankedTripleSearchResults(jcas)
            .stream()
            .limit(tripleLimit)
            .map(TripleSearchResult::getTriple)
            .map(triple -> new Triple(triple.getSubject(), triple.getPredicate(), triple
                    .getObject())).collect(toList());
    // retrieve answers from CAS
    String idealAnswer = TypeUtil.getSummary(jcas).stream().map(Summary::getText).findFirst()
            .orElse(null);
    if (QuestionType.factoid.equals(type)) {
      List<String> exactAnswer = TypeUtil.getAnswers(jcas).stream().limit(factoidAnswerLimit)
              .map(Answer::getText).collect(toList());
      return new TestFactoidQuestion(id, body, type, documents, snippets, concepts, triples,
              idealAnswer, exactAnswer);
    } else if (QuestionType.list.equals(type)) {
      List<List<String>> exactAnswer = TypeUtil.getAnswers(jcas).stream().limit(listAnswerLimit)
              .map(Answer::getText).map(Arrays::asList).collect(toList());
      return new TestListQuestion(id, body, type, documents, snippets, concepts, triples,
              idealAnswer, exactAnswer);
    } else if (QuestionType.yesno.equals(type)) {
      String exactAnswer = TypeUtil.getAnswers(jcas).stream().limit(1).map(Answer::getText)
              .findFirst().orElse(null);
      return new TestYesNoQuestion(id, body, type, documents, snippets, concepts, triples,
              idealAnswer, exactAnswer);
    } else if (QuestionType.summary.equals(type)) {
      // summary questions do not have exact answers
      return new TestSummaryQuestion(id, body, type, documents, snippets, concepts, triples,
              idealAnswer);
    }
    return new TestQuestion(id, body, type, documents, snippets, concepts, triples, idealAnswer);
  }

  public static QuestionType convertQuestionType(String type) {
    if (type.equals("FACTOID")) {
      return QuestionType.factoid;
    } else if (type.equals("LIST")) {
      return QuestionType.list;
    } else if (type.equals("OPINION")) {
      return QuestionType.summary;
    } else if (type.equals("YES_NO")) {
      return QuestionType.yesno;
    }
    throw new RuntimeException("Question type " + type + " unknown");
  }

}
