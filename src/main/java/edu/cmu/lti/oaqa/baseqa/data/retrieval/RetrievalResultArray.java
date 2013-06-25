package edu.cmu.lti.oaqa.baseqa.data.retrieval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.retrieval.Passage;
import org.oaqa.model.test.Search;

import edu.cmu.lti.oaqa.baseqa.data.core.FSArrayWrapper;
import edu.cmu.lti.oaqa.framework.BaseJCasHelper;

@Deprecated
public class RetrievalResultArray extends FSArrayWrapper<Passage> {

  public RetrievalResultArray(JCas jcas, int length) {
    super(jcas, length);
  }

  @Override
  public void clear() {
    Iterator<?> it = jcas.getJFSIndexRepository().getAllIndexedFS(Search.type);
    while (it.hasNext()) {
      Search search = (Search) it.next();
      search.removeFromIndexes();
    }
  }

  @Override
  public void complete() {
    Search search = new Search(jcas);
    search.setHitList(array);
    search.addToIndexes();
  }

  private void appendRetrievalResults(List<RetrievalResult> results)
          throws AnalysisEngineProcessException {
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
    appendArray(results);
  }

  public void setRetrievalResults(List<RetrievalResult> results)
          throws AnalysisEngineProcessException {
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

  public static void storeRetrievalResults(JCas jcas, List<RetrievalResult> results,
          boolean overwrite) throws AnalysisEngineProcessException {
    if (overwrite) {
      new RetrievalResultArray(jcas, results.size()).setRetrievalResults(results);
    } else {
      new RetrievalResultArray(jcas, results.size()).appendRetrievalResults(results);
    }
  }

  @Deprecated
  public static void storeRetrievalResults(JCas jcas, List<RetrievalResult> results)
          throws Exception {
    storeRetrievalResults(jcas, results, true);
  }

  public List<RetrievalResult> getRetrievalResults() throws AnalysisEngineProcessException {
    Search search = (Search) BaseJCasHelper.getFS(jcas, Search.type);
    if (search != null) {
      array = search.getHitList();
      return getArray(Passage.class, RetrievalResult.class);
    } else {
      return new ArrayList<RetrievalResult>();
    }
  }

  public static List<RetrievalResult> retrieveRetrievalResults(JCas jcas)
          throws AnalysisEngineProcessException {
    return new RetrievalResultArray(jcas, 0).getRetrievalResults();
  }

}
