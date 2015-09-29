package edu.cmu.lti.oaqa.baseqa.collection.json;

import edu.cmu.lti.oaqa.baseqa.collection.json.gson.*;
import edu.cmu.lti.oaqa.type.answer.Answer;
import edu.cmu.lti.oaqa.type.retrieval.ConceptSearchResult;
import edu.cmu.lti.oaqa.type.retrieval.Document;
import edu.cmu.lti.oaqa.type.retrieval.Passage;
import edu.cmu.lti.oaqa.type.retrieval.TripleSearchResult;
import edu.cmu.lti.oaqa.util.TypeFactory;
import org.apache.uima.jcas.JCas;

import java.util.List;

public class JsonCollectionReaderHelper {

  public static void addQuestionToIndex(Question input, String source, JCas jcas) {
    // question text and type are required
    TypeFactory.createQuestion(jcas, input.getId(), source, convertQuestionType(input.getType()),
            input.getBody()).addToIndexes();
    // if documents, snippets, concepts, and triples are found in the input, then add them to CAS
    if (input.getDocuments() != null) {
      input.getDocuments().stream().map(uri -> TypeFactory.createDocument(jcas, uri))
              .forEach(Document::addToIndexes);
    }
    if (input.getSnippets() != null) {
      input.getSnippets().stream()
              .map(snippet -> TypeFactory.createPassage(jcas, snippet.getDocument(),
                      snippet.getText(), snippet.getOffsetInBeginSection(),
                      snippet.getOffsetInEndSection(), snippet.getBeginSection(),
                      snippet.getEndSection()))
              .forEach(Passage::addToIndexes);
    }
    if (input.getConcepts() != null) {
      input.getConcepts().stream()
              .map(concept -> TypeFactory.createConceptSearchResult(jcas,
                      TypeFactory.createConcept(jcas, concept), concept))
              .forEach(ConceptSearchResult::addToIndexes);
    }
    if (input.getTriples() != null) {
      input.getTriples().stream()
              .map(triple -> TypeFactory.createTripleSearchResult(jcas,
                      TypeFactory.createTriple(jcas, triple.getS(), triple.getP(), triple.getO())))
              .forEach(TripleSearchResult::addToIndexes);
    }
    // add answers to CAS index
    if (input instanceof TestQuestion) {
      // test question should not have ideal or exact answers
    } else if (input instanceof TrainingQuestion) {
      List<String> summaryVariants = ((TrainingQuestion) input).getIdealAnswer();
      if (summaryVariants != null) {
        TypeFactory.createSummary(jcas, summaryVariants).addToIndexes();
      }
      if (input instanceof TrainingFactoidQuestion) {
        List<String> answerVariants = ((TrainingFactoidQuestion) input).getExactAnswer();
        if (answerVariants != null) {
          TypeFactory.createAnswer(jcas, answerVariants).addToIndexes();
        }
      } else if (input instanceof TrainingListQuestion) {
        List<List<String>> answerVariantsList = ((TrainingListQuestion) input).getExactAnswer();
        if (answerVariantsList != null) {
          answerVariantsList.stream()
                  .map(answerVariants -> TypeFactory.createAnswer(jcas, answerVariants))
                  .forEach(Answer::addToIndexes);
        }
      } else if (input instanceof TrainingYesNoQuestion) {
        String answer = ((TrainingYesNoQuestion) input).getExactAnswer();
        if (answer != null) {
          TypeFactory.createAnswer(jcas, answer).addToIndexes();
        }
      } else if (input instanceof TrainingSummaryQuestion) {
        // summary questions do not have exact answers
      }
    }
  }

  public static String convertQuestionType(QuestionType type) {
    switch (type) {
      case factoid:
        return "FACTOID";
      case list:
        return "LIST";
      case summary:
        return "OPINION";
      case yesno:
        return "YES_NO";
      default:
        return "UNCLASSIFIED";
    }
  }

}
