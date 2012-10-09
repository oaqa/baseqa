package edu.cmu.lti.oaqa.framework.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;
import org.oaqa.model.Passage;
import org.oaqa.model.Search;

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
  
  public static List<PassageCandidate> getPassages(JCas candidateView) {

    List<PassageCandidate> passages = new ArrayList<PassageCandidate>();
    Iterator<?> it = candidateView.getJFSIndexRepository().getAllIndexedFS(Search.type);

    if (it.hasNext()) {
      Search retrievalResult = (Search) it.next();
      FSArray hitList = retrievalResult.getHitList();
      for (int i = 0; i < hitList.size(); i++) {
        Passage p = (Passage) hitList.get(i);
        passages.add(new PassageCandidate(p));
      }
    }
    return passages;
  }

  public static void storePassages(JCas candidateView, List<PassageCandidate> passages) {

    Collections.sort(passages, Collections.reverseOrder());
    Iterator<?> it = candidateView.getJFSIndexRepository().getAllIndexedFS(Search.type);
    while (it.hasNext()) {
      Search search = (Search) it.next();
      search.removeFromIndexes();
    }

    FSArray hitList = new FSArray(candidateView, passages.size());
    double prevScore = Double.NaN;
    int prevRank = 0;
    for (int i = 0; i < passages.size(); i++) {
      PassageCandidate passage = passages.get(i);
      Passage p = new Passage(candidateView);
      p.setUri(passage.getDocID());
      p.setBegin(passage.getStart());
      p.setEnd(passage.getEnd());
      p.setQueryString(passage.getQueryString());
      double curScore = passage.getScore();
      p.setScore(curScore);
      if (curScore != prevScore) {
        p.setRank(i + 1);
        prevScore = curScore;
        prevRank = i + 1;
      } else {
        p.setRank(prevRank);
      }
      hitList.set(i, p);
    }

    Search search = new Search(candidateView);
    search.setHitList(hitList);
    search.addToIndexes();
  }

  public static void storePassageTexts(JCas finalView, List<PassageCandidate> passages,
          List<String> texts) {

    Collections.sort(passages, Collections.reverseOrder());
    Iterator<?> it = finalView.getJFSIndexRepository().getAllIndexedFS(Search.type);
    while (it.hasNext()) {
      Search search = (Search) it.next();
      search.removeFromIndexes();
    }

    FSArray hitList = new FSArray(finalView, passages.size());
    for (int i = 0; i < passages.size(); i++) {
      PassageCandidate passage = passages.get(i);
      String text = texts.get(i);
      Passage p = new Passage(finalView);
      p.setUri(passage.getDocID());
      p.setBegin(passage.getStart());
      p.setEnd(passage.getEnd());
      p.setRank(passage.getRank());
      p.setScore(passage.getScore());
      p.setQueryString(passage.getQueryString());
      p.setText(text);
      hitList.set(i, p);
    }

    Search search = new Search(finalView);
    search.setHitList(hitList);
    search.addToIndexes();
  }

}
