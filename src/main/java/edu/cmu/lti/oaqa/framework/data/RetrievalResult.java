package edu.cmu.lti.oaqa.framework.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.uima.cas.CASException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;
import org.oaqa.model.Passage;
import org.oaqa.model.Search;
import org.oaqa.model.SearchResult;

public class RetrievalResult implements Comparable<RetrievalResult>, Serializable {

  private static final long serialVersionUID = 1L;

  private String docID;

  private double score;

  private int rank = -1;

  private String queryString;

  public RetrievalResult(String docID, double score, String queryString) {
    this.docID = docID;
    this.score = score;
    this.queryString = queryString;
  }

  public RetrievalResult(SearchResult result) {
    this.docID = result.getUri();
    this.score = result.getScore();
    this.rank = result.getRank();
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

  public static List<RetrievalResult> getDocuments(JCas documentView) throws CASException {

    List<RetrievalResult> documents = new ArrayList<RetrievalResult>();
    Iterator<?> it = documentView.getJFSIndexRepository().getAllIndexedFS(Search.type);

    if (it.hasNext()) {
      Search retrievalResult = (Search) it.next();
      FSArray hitList = retrievalResult.getHitList();
      for (int i = 0; i < hitList.size(); i++) {
        Passage sr = (Passage) hitList.get(i);
        RetrievalResult document = new RetrievalResult(sr);
        documents.add(document);
      }
    }
    return documents;
  }

  /**
   * @deprecated Use {@link #getDocuments(JCas)} directly.
   */
  @Deprecated
  public static List<RetrievalResult> getDocumentsNoText(JCas documentView) throws CASException {
    return getDocuments(documentView);
  }

  public static void storeDocuments(JCas documentView, List<RetrievalResult> documents) {

    Collections.sort(documents, Collections.reverseOrder());
    Iterator<?> it = documentView.getJFSIndexRepository().getAllIndexedFS(Search.type);
    while (it.hasNext()) {
      Search search = (Search) it.next();
      search.removeFromIndexes();
    }

    FSArray hitList = new FSArray(documentView, documents.size());
    double prevScore = Double.NaN;
    int prevRank = 0;
    for (int i = 0; i < documents.size(); i++) {
      RetrievalResult document = documents.get(i);
      Passage sr = new Passage(documentView);
      sr.setUri(document.getDocID());
      sr.setQueryString(document.getQueryString());
      double curScore = document.getScore();
      sr.setScore(curScore);
      if (curScore != prevScore) {
        sr.setRank(i + 1);
        prevScore = curScore;
        prevRank = i + 1;
      } else {
        sr.setRank(prevRank);
      }
      hitList.set(i, sr);
    }

    Search search = new Search(documentView);
    search.setHitList(hitList);
    search.addToIndexes();
  }

}
