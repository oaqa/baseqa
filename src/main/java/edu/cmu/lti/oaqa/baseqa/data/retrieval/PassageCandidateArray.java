package edu.cmu.lti.oaqa.baseqa.data.retrieval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.retrieval.Passage;
import org.oaqa.model.test.Search;

import edu.cmu.lti.oaqa.core.data.FSArrayWrapper;
import edu.cmu.lti.oaqa.core.data.WrapperIndexer;
import edu.cmu.lti.oaqa.framework.BaseJCasHelper;

/**
 * Legacy type wrapper for Search, defined in basephase. In a GERP environment, the candidates
 * generates from generators will be stored in the same index without any additional container.
 * 
 * @author Zi Yang <ziy@cs.cmu.edu>
 * 
 */
@Deprecated
public class PassageCandidateArray extends FSArrayWrapper<Passage> {

  public PassageCandidateArray(JCas jcas, int length) {
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

  private void appendPassageCandidates(WrapperIndexer indexer, List<PassageCandidate> results)
          throws AnalysisEngineProcessException {
    Collections.sort(results, Collections.reverseOrder());
    double prevScore = Double.NaN;
    int prevRank = 0;
    for (int i = 0; i < results.size(); i++) {
      PassageCandidate candidate = results.get(i);
      double curScore = candidate.getProbability();
      if (curScore != prevScore) {
        candidate.setRank(i + 1);
        prevScore = curScore;
        prevRank = i + 1;
      } else {
        candidate.setRank(prevRank);
      }
    }
    appendArray(indexer, results);
  }

  public void setPassageCandidates(WrapperIndexer indexer, List<PassageCandidate> results)
          throws AnalysisEngineProcessException {
    Collections.sort(results, Collections.reverseOrder());
    double prevScore = Double.NaN;
    int prevRank = 0;
    for (int i = 0; i < results.size(); i++) {
      PassageCandidate candidate = results.get(i);
      double curScore = candidate.getProbability();
      if (curScore != prevScore) {
        candidate.setRank(i + 1);
        prevScore = curScore;
        prevRank = i + 1;
      } else {
        candidate.setRank(prevRank);
      }
    }
    setArray(indexer, results);
  }

  public static void storePassageCandidates(WrapperIndexer indexer, JCas jcas,
          List<PassageCandidate> results, boolean overwrite) throws AnalysisEngineProcessException {
    if (overwrite) {
      new PassageCandidateArray(jcas, results.size()).setPassageCandidates(indexer, results);
    } else {
      new PassageCandidateArray(jcas, results.size()).appendPassageCandidates(indexer, results);
    }
  }

  @Deprecated
  public static void storePassageCandidates(WrapperIndexer indexer, JCas jcas,
          List<PassageCandidate> results) throws AnalysisEngineProcessException {
    storePassageCandidates(indexer, jcas, results, true);
  }

  public List<PassageCandidate> getPassageCandidates(WrapperIndexer indexer)
          throws AnalysisEngineProcessException {
    Search search = (Search) BaseJCasHelper.getFS(jcas, Search.type);
    if (search != null) {
      array = search.getHitList();
      return getArray(indexer, PassageCandidate.class);
    } else {
      return new ArrayList<PassageCandidate>();
    }
  }

  public static List<PassageCandidate> retrievePassageCandidates(WrapperIndexer indexer, JCas jcas)
          throws AnalysisEngineProcessException {
    return new PassageCandidateArray(jcas, 0).getPassageCandidates(indexer);
  }

}
