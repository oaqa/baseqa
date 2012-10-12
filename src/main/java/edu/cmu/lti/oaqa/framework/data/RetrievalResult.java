package edu.cmu.lti.oaqa.framework.data;

import java.io.Serializable;

import org.apache.uima.jcas.JCas;
import org.oaqa.model.Passage;

import edu.cmu.lti.oaqa.framework.data.base.BaseAnnotationWrapper;

public class RetrievalResult extends BaseAnnotationWrapper<Passage> implements
        Comparable<RetrievalResult>, Serializable {

  private static final long serialVersionUID = 1L;

  private String docID;

  private double score;

  private int rank = -1;

  private String queryString;

  public RetrievalResult() {
    super();
  }

  public RetrievalResult(String docID, double score, String queryString) {
    super();
    this.docID = docID;
    this.score = score;
    this.queryString = queryString;
  }

  public String getQueryString() {
    return this.queryString;
  }

  public String getDocID() {
    return this.docID;
  }

  public double getScore() {
    return this.score;
  }

  public int getRank() {
    return this.rank;
  }

  public void setRank(int rank) {
    this.rank = rank;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((docID == null) ? 0 : docID.hashCode());
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
    return true;
  }

  @Override
  public String toString() {
    return docID;
  }

  @Override
  public int compareTo(RetrievalResult o) {
    if (score != o.score) {
      return score > o.score ? 1 : -1;
    }
    return 0;
  }

  @Override
  public void wrap(Passage passage) {
    super.wrap(passage);
    docID = passage.getUri();
    queryString = passage.getQueryString();
    score = passage.getScore();
    rank = passage.getRank();
  }

  @Override
  public Passage unwrap(JCas jcas) throws Exception {
    Passage passage = super.unwrap(jcas);
    passage.setUri(docID);
    passage.setQueryString(queryString);
    passage.setScore(score);
    passage.setRank(rank);
    return passage;
  }

  @Override
  public Class<? extends Passage> getTypeClass() {
    return Passage.class;
  }

}
