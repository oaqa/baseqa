package edu.cmu.lti.oaqa.baseqa.data.retrieval;

import java.io.Serializable;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.retrieval.Passage;

import edu.cmu.lti.oaqa.baseqa.data.core.OAQATopWrapper;

@Deprecated
public class RetrievalResult extends OAQATopWrapper<Passage> implements Serializable {

  private static final long serialVersionUID = 1L;

  private String docID;

  private int rank = -1;

  private String queryString;

  public RetrievalResult() {
    super();
  }

  public RetrievalResult(String docID, float score, String queryString) {
    super();
    this.docID = docID;
    this.probability = score;
    this.queryString = queryString;
  }

  public String getQueryString() {
    return this.queryString;
  }

  public String getDocID() {
    return this.docID;
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
  public void wrap(Passage passage) throws AnalysisEngineProcessException {
    super.wrap(passage);
    docID = passage.getUri();
    queryString = passage.getQueryString();
    rank = passage.getRank();
  }

  @Override
  public Passage unwrap(JCas jcas) throws AnalysisEngineProcessException {
    Passage passage = super.unwrap(jcas);
    passage.setUri(docID);
    passage.setQueryString(queryString);
    passage.setRank(rank);
    return passage;
  }

  @Override
  public Class<? extends Passage> getTypeClass() {
    return Passage.class;
  }

}
