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

  public RetrievalResultArray(String SourceId, JCas jcas, int length) throws ConfigurationException {
    super(jcas, length);
    if (null == SourceId || SourceId.isEmpty()) {
      throw new ConfigurationException("SourceId should not be empty!");
    }
    this.SourceId = SourceId;
  }

  @Override
  public void clear() {
    Iterator<?> it = jcas.getJFSIndexRepository().getAllIndexedFS(Search.type);
    while (it.hasNext()) {
      Search search = (Search) it.next();
      // Delete only entry with the specified SourceId
      if (search.getSourceId() == this.SourceId) {
        search.removeFromIndexes();
        break;
      }
    }
  }
  
  public static void GetAllSourceIds(JCas jcas, List<String> res) {
    res.clear();
    Iterator<?> it = jcas.getJFSIndexRepository().getAllIndexedFS(Search.type);
    while (it.hasNext()) {
      Search search = (Search) it.next();

      res.add(search.getSourceId()); 
    }    
  }

  @Override
  public void complete() {
    Search search = new Search(jcas);
    search.setSourceId(SourceId);
    search.setHitList(array);
    search.addToIndexes();
  }

  public void setRetrievalResults(List<RetrievalResult> results) throws Exception {
    Collections.sort(results, Collections.reverseOrder());
    double prevScore = Double.NaN;
    int prevRank = 0;
    for (int i = 0; i < results.size(); i++) {
      RetrievalResult result = results.get(i);
      double curScore = result.getScore();
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

  public static void storeRetrievalResults(String SourceId, JCas jcas, List<RetrievalResult> results)
          throws Exception {
    new RetrievalResultArray(SourceId, jcas, results.size()).setRetrievalResults(results);
  }

  public List<RetrievalResult> getRetrievalResults() throws Exception {
    Iterator<?> it = jcas.getJFSIndexRepository().getAllIndexedFS(Search.type);
    while (it.hasNext()) {
      Search search = (Search) it.next();
      if (search.getSourceId() == this.SourceId) {
        array = search.getHitList();
        return getArray(Document.class, RetrievalResult.class);        
      }
    }
    // @ Zi Yang from Leonid Boytsov: shouldn't we actually panic here? Why didn't we get the result, something MUST be wrong. 
    return new ArrayList<RetrievalResult>();
  }

  public static List<RetrievalResult> retrieveRetrievalResults(String SourceId, JCas jcas) throws Exception {
    return new RetrievalResultArray(SourceId, jcas, 0).getRetrievalResults();
  }
  
  private String SourceId;
}
