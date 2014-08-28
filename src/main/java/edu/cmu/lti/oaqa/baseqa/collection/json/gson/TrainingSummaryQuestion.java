package edu.cmu.lti.oaqa.baseqa.collection.json.gson;

import java.util.List;

public class TrainingSummaryQuestion extends TrainingQuestion {

  public TrainingSummaryQuestion(String id, String body, QuestionType type, List<String> documents,
          List<Snippet> snippets, List<String> concepts, List<Triple> triples,
          List<String> idealAnswer) {
    super(id, body, type, documents, snippets, concepts, triples, idealAnswer);
  }

}
