package edu.cmu.lti.oaqa.framework.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.naming.ConfigurationException;

import org.apache.uima.jcas.JCas;
import org.oaqa.model.Document;
import org.oaqa.model.Search;

import edu.cmu.lti.oaqa.framework.data.base.FSArrayWrapper;

public class RetrievalResultArray extends FSArrayWrapper<Document> {

  public RetrievalResultArray(String SearchId, JCas jcas, int length) throws ConfigurationException {
    super(jcas, length);
    if (null == SearchId || SearchId.isEmpty()) {
      throw new ConfigurationException("SearchId should not be empty!");
    }
    this.SearchId = SearchId;
  }

  @Override
  public void clear() {
    Iterator<?> it = jcas.getJFSIndexRepository().getAllIndexedFS(Search.type);
    while (it.hasNext()) {
      Search search = (Search) it.next();
      // Delete only entry with the specified searchId
      if (search.getSearchId() == this.SearchId) {
        search.removeFromIndexes();
      }
    }
  }

  @Override
  public void complete() {
    Search search = new Search(jcas);
    search.setSearchId(SearchId);
    search.setHitList(array);
    search.addToIndexes();
  }

  public void setRetrievalResults(List<RetrievalResult> results) throws Exception {
    Collections.sort(results, Collections.reverseOrder());
    double prevScore = Double.NaN;
    int prevRank = 0;
    for (int i = 0; i < results.size(); i++) {
      RetrievalResult result = results.get(i);
      double curScore = result.getProbability();
      if (curScore != prevScore) {
        result.setRank(i + 1);
        prevScore = curScore;
        prevRank = i + 1;
      } else {
        result.setRank(prevRank);
      }
    }
    setArray(results);
  }

  public static void storeRetrievalResults(String SearchId, JCas jcas, List<RetrievalResult> results)
          throws Exception {
    new RetrievalResultArray(SearchId, jcas, results.size()).setRetrievalResults(results);
  }

  public List<RetrievalResult> getRetrievalResults() throws Exception {
    Iterator<?> it = jcas.getJFSIndexRepository().getAllIndexedFS(Search.type);
    while (it.hasNext()) {
      Search search = (Search) it.next();
      if (search.getSearchId() == this.SearchId) {
        array = search.getHitList();
        return getArray(Document.class, RetrievalResult.class);        
      }
    }
    // @ Zi Yang from Leonid Boytsov: shouldn't we actually panic here? Why didn't we get the result, something MUST be wrong. 
    return new ArrayList<RetrievalResult>();
  }

  public static List<RetrievalResult> retrieveRetrievalResults(String SearchId, JCas jcas) throws Exception {
    return new RetrievalResultArray(SearchId, jcas, 0).getRetrievalResults();
  }
  
  private String SearchId;
}
