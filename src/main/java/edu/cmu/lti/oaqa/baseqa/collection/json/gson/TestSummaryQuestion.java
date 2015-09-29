package edu.cmu.lti.oaqa.baseqa.collection.json.gson;

import java.util.List;

public class TestSummaryQuestion extends TestQuestion {

  public TestSummaryQuestion(String id, String body, QuestionType type, List<String> documents,
          List<Snippet> snippets, List<String> concepts, List<Triple> triples, String idealAnswer) {
    super(id, body, type, documents, snippets, concepts, triples, idealAnswer);
  }

}
