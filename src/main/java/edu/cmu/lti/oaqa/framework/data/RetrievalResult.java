package edu.cmu.lti.oaqa.framework.data;

import java.io.Serializable;

import org.apache.uima.jcas.JCas;
import org.oaqa.model.Document;
import org.oaqa.model.SearchResult;

import edu.cmu.lti.oaqa.framework.data.base.BaseAnnotationWrapper;

public class RetrievalResult extends BaseAnnotationWrapper<Document> implements Serializable {

  private static final long serialVersionUID = 1L;
  private String docID;
  private String text = "";
  private double score = 0.0;
  private int    rank = -1;
  private String queryString;

  public RetrievalResult() {
    super();
  }
  
  public RetrievalResult(Document That) {
    super();
    this.docID = That.getDocId();
    this.text  = That.getText();
    this.score = That.getScore();
    this.rank  = That.getRank();
    this.queryString = That.getQueryString();
  }

  public RetrievalResult(String docID, double score, String queryString, String text) {
    super();
    this.docID = docID;
    this.text  = text;
    this.score = score;
    this.queryString = queryString;
  }

  public String getQueryString() {
    return this.queryString;
  }
  
  public String getDocID() {
    return this.docID;
  }
  
  public String getText() {
    return this.text;
  }

  public int getRank() {
    return this.rank;
  }

  public void setRank(int rank) {
    this.rank = rank;
  }
  
  public double getScore() {
  	return score;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((docID == null) ? 0 : docID.hashCode());
    result = prime * result + ((text == null) ? 0 : text.hashCode());
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
    RetrievalResult other = (RetrievalResult) obj;
    
    if (docID == null) {
      if (other.docID != null)
        return false;
    } else if (!docID.equals(other.docID))
      return false;
        
    if (text == null) {
      if (other.text != null)
        return false;
    } else if (!text.equals(other.text))
      return false;

    
    return true;
  }

  @Override
  public String toString() {
    return (docID != null ? docID:"") + (text != null ? (" " + text):"");
  }

  @Override
  public void wrap(Document Doc) throws Exception {
    super.wrap(Doc);
    docID       = Doc.getUri();
    text        = Doc.getText();
    queryString = Doc.getQueryString();
    rank        = Doc.getRank();
    score       = Doc.getScore();
  }

  @Override
  public Document unwrap(JCas jcas) throws Exception {
    Document Doc = super.unwrap(jcas);
    Doc.setUri(docID);
    Doc.setText(text);    
    Doc.setQueryString(queryString);
    Doc.setRank(rank);
    Doc.setScore(score);

    return Doc;
  }

  @Override
  public Class<? extends Document> getTypeClass() {
    return Document.class;
  }

}
