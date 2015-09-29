package edu.cmu.lti.oaqa.baseqa.collection.json.gson;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class TestQuestion extends Question {

  @SerializedName("ideal_answer")
  private String idealAnswer;

  public TestQuestion(String id, String body, QuestionType type, List<String> documents,
          List<Snippet> snippets, List<String> concepts, List<Triple> triples, String idealAnswer) {
    super(id, body, type, documents, snippets, concepts, triples);
    this.idealAnswer = idealAnswer;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((idealAnswer == null) ? 0 : idealAnswer.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    TestQuestion other = (TestQuestion) obj;
    if (idealAnswer == null) {
      if (other.idealAnswer != null)
        return false;
    } else if (!idealAnswer.equals(other.idealAnswer))
      return false;
    return true;
  }

  public String getIdealAnswer() {
    return idealAnswer;
  }

  public void setIdealAnswer(String idealAnswer) {
    this.idealAnswer = idealAnswer;
  }

}
