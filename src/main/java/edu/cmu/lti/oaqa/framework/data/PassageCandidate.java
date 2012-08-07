package edu.cmu.lti.oaqa.framework.data;

import java.io.Serializable;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.oaqa.model.Passage;

/**
 * 
 * @author Zi Yang <ziy@cs.cmu.edu>
 * 
 */
public class PassageCandidate implements Comparable<PassageCandidate>, Serializable {

  private static final long serialVersionUID = 1L;

  private String docID;

  private int start;

  private int end;

  private double score;

  private int rank = -1;

  private String queryString;

  public PassageCandidate(String docID, int start, int end, double score, String queryString)
          throws AnalysisEngineProcessException {
    this.docID = docID;
    this.start = start;
    this.end = end;
    this.score = score;
    this.queryString = queryString;
  }

  public PassageCandidate(Passage result) {
    this.docID = result.getUri();
    this.start = result.getBegin();
    this.end = result.getEnd();
    this.score = result.getScore();
    this.rank = result.getRank();
    this.queryString = result.getQueryString();
  }

  @Override
  public String toString() {
    return docID + "[" + start + "," + end + "]";
  }

  @Override
  public int compareTo(PassageCandidate o) {
    if (score > o.score) {
      return 1;
    } else if (score < o.score) {
      return -1;
    }
    return 0;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((docID == null) ? 0 : docID.hashCode());
    result = prime * result + end;
    result = prime * result + start;
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
    PassageCandidate other = (PassageCandidate) obj;
    if (docID == null) {
      if (other.docID != null)
        return false;
    } else if (!docID.equals(other.docID))
      return false;
    if (end != other.end)
      return false;
    if (start != other.start)
      return false;
    return true;
  }

  public String getDocID() {
    return docID;
  }

  public void setDocID(String docID) {
    this.docID = docID;
  }

  public int getStart() {
    return start;
  }

  public void setStart(int start) {
    this.start = start;
  }

  public int getEnd() {
    return end;
  }

  public void setEnd(int end) {
    this.end = end;
  }

  public double getScore() {
    return score;
  }

  public void setScore(double score) {
    this.score = score;
  }

  public int getRank() {
    return rank;
  }

  public void setRank(int rank) {
    this.rank = rank;
  }

  public String getQueryString() {
    return queryString;
  }

  public void setQueryString(String queryString) {
    this.queryString = queryString;
  }

}
