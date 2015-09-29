package edu.cmu.lti.oaqa.baseqa.collection.json.gson;

import java.util.List;

public class Question {

  private String id;

  private String body;

  private QuestionType type;

  private List<String> documents;

  private List<Snippet> snippets;

  private List<String> concepts;

  private List<Triple> triples;

  protected Question(String id, String body, QuestionType type, List<String> documents,
          List<Snippet> snippets, List<String> concepts, List<Triple> triples) {
    super();
    this.id = id;
    this.body = body;
    this.type = type;
    this.documents = documents;
    this.snippets = snippets;
    this.concepts = concepts;
    this.triples = triples;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((body == null) ? 0 : body.hashCode());
    result = prime * result + ((concepts == null) ? 0 : concepts.hashCode());
    result = prime * result + ((documents == null) ? 0 : documents.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((snippets == null) ? 0 : snippets.hashCode());
    result = prime * result + ((triples == null) ? 0 : triples.hashCode());
    result = prime * result + ((type == null) ? 0 : type.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Question other = (Question) obj;
    if (body == null) {
      if (other.body != null)
        return false;
    } else if (!body.equals(other.body))
      return false;
    if (concepts == null) {
      if (other.concepts != null)
        return false;
    } else if (!concepts.equals(other.concepts))
      return false;
    if (documents == null) {
      if (other.documents != null)
        return false;
    } else if (!documents.equals(other.documents))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (snippets == null) {
      if (other.snippets != null)
        return false;
    } else if (!snippets.equals(other.snippets))
      return false;
    if (triples == null) {
      if (other.triples != null)
        return false;
    } else if (!triples.equals(other.triples))
      return false;
    if (type != other.type)
      return false;
    return true;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public QuestionType getType() {
    return type;
  }

  public void setType(QuestionType type) {
    this.type = type;
  }

  public List<String> getDocuments() {
    return documents;
  }

  public void setDocuments(List<String> documents) {
    this.documents = documents;
  }

  public List<Snippet> getSnippets() {
    return snippets;
  }

  public void setSnippets(List<Snippet> snippets) {
    this.snippets = snippets;
  }

  public List<String> getConcepts() {
    return concepts;
  }

  public void setConcepts(List<String> concepts) {
    this.concepts = concepts;
  }

  public List<Triple> getTriples() {
    return triples;
  }

  public void setTriples(List<Triple> triples) {
    this.triples = triples;
  }

}