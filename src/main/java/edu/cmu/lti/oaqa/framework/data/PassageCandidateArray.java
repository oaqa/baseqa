package edu.cmu.lti.oaqa.framework.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.naming.ConfigurationException;

import org.apache.uima.jcas.JCas;
import org.oaqa.model.Passage;
import org.oaqa.model.Search;

import edu.cmu.lti.oaqa.framework.BaseJCasHelper;
import edu.cmu.lti.oaqa.framework.data.base.FSArrayWrapper;

public class PassageCandidateArray extends FSArrayWrapper<Passage> {

  public PassageCandidateArray(String SourceId, JCas jcas, int length) throws ConfigurationException {
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

  public void setPassageCandidates(List<PassageCandidate> results) throws Exception {
    Collections.sort(results, Collections.reverseOrder());
    double prevScore = Double.NaN;
    int prevRank = 0;
    for (int i = 0; i < results.size(); i++) {
      PassageCandidate candidate = results.get(i);
      double curScore = candidate.getScore();
      if (curScore != prevScore) {
        candidate.setRank(i + 1);
        prevScore = curScore;
        prevRank = i + 1;
      } else {
        candidate.setRank(prevRank);
      }
    }
    setArray(results);
  }

  public static void storePassageCandidates(String SourceId, JCas jcas, List<PassageCandidate> results)
          throws Exception {
    new PassageCandidateArray(SourceId, jcas, results.size()).setPassageCandidates(results);
  }

  public List<PassageCandidate> getPassageCandidates() throws Exception {
    Iterator<?> it = jcas.getJFSIndexRepository().getAllIndexedFS(Search.type);
    while (it.hasNext()) {
      Search search = (Search) it.next(); 
      if (search.getSourceId() == this.SourceId) {
        array = search.getHitList();
        return getArray(Passage.class, PassageCandidate.class);
      }
    }
    
    return new ArrayList<PassageCandidate>();
  }

  public static List<PassageCandidate> retrievePassageCandidates(String SourceId, JCas jcas) throws Exception {
    return new PassageCandidateArray(SourceId, jcas, 0).getPassageCandidates();
  }
  
  private String SourceId;
}
