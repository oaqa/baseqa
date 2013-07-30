package edu.cmu.lti.oaqa.gerp.data;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.TOP;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.core.data.TopWrapper;
import edu.cmu.lti.oaqa.core.data.WrapperHelper;
import edu.cmu.lti.oaqa.core.data.WrapperIndexer;

public class GerpableList<T extends TOP, W extends Gerpable & TopWrapper<T>> {

  private List<W> gerpables;

  private int gerpableCount;

  public GerpableList() {
    this.gerpables = Lists.newArrayList();
    this.gerpableCount = 0;
  }

  public void add(W gerpable) {
    int index = -1;
    if ((index = gerpables.indexOf(gerpable)) > 0) {
      gerpables.get(index).addGenerators(gerpable.getGenerators());
    } else {
      gerpables.add(gerpable);
      gerpableCount++;
    }
  }

  public void add(W gerpable, String generator) {
    int index = -1;
    if ((index = gerpables.indexOf(gerpable)) > 0) {
      gerpables.get(index).addGenerator(generator);
    } else {
      gerpable.addGenerator(generator);
      gerpables.add(gerpable);
      gerpableCount++;
    }
  }

  public void addAllEvidences(List<EvidenceWrapper<?, ?>> evidences) {
    assert evidences.size() == gerpableCount;
    for (int i = 0; i < gerpableCount; i++) {
      gerpables.get(i).addEvidence(evidences.get(i));
    }
  }

  public void addAllEvidences(Map<W, EvidenceWrapper<?, ?>> gerpable2evidence) {
    assert gerpable2evidence.size() == gerpableCount;
    for (W gerpable : gerpable2evidence.keySet()) {
      int idx = gerpables.indexOf(gerpable);
      gerpables.get(idx).addEvidence(gerpable2evidence.get(gerpable));
    }
  }

  public List<Collection<EvidenceWrapper<?, ?>>> getAllEvidences() {
    List<Collection<EvidenceWrapper<?, ?>>> evidences = Lists.newArrayList();
    for (W gerpable : gerpables) {
      evidences.add(gerpable.getEvidences());
    }
    return evidences;
  }

  public void addAllRanks(List<RankWrapper> ranks) {
    for (int i = 0; i < gerpableCount; i++) {
      gerpables.get(i).addRank(ranks.get(i));
    }
  }

  public void addAllRanks(Map<W, RankWrapper> gerpable2ranks) {
    assert gerpable2ranks.size() == gerpableCount;
    for (W gerpable : gerpable2ranks.keySet()) {
      int idx = gerpables.indexOf(gerpable);
      gerpables.get(idx).addRank(gerpable2ranks.get(gerpable));
    }
  }

  public List<Collection<RankWrapper>> getAllRanks() {
    List<Collection<RankWrapper>> ranks = Lists.newArrayList();
    for (W gerpable : gerpables) {
      ranks.add(gerpable.getRanks());
    }
    return ranks;
  }

  public void addAllPruningDecisions(List<PruningDecisionWrapper> pruningDecisions) {
    for (int i = 0; i < gerpableCount; i++) {
      gerpables.get(i).addPruningDecision(pruningDecisions.get(i));
    }
  }

  public void addAllPruningDecisions(Map<W, PruningDecisionWrapper> gerpable2pruningDecisions) {
    assert gerpable2pruningDecisions.size() == gerpableCount;
    for (W gerpable : gerpable2pruningDecisions.keySet()) {
      int idx = gerpables.indexOf(gerpable);
      gerpables.get(idx).addPruningDecision(gerpable2pruningDecisions.get(gerpable));
    }
  }

  public void unwrapAllAndAddToIndexes(WrapperIndexer indexer, JCas jcas)
          throws AnalysisEngineProcessException {
    for (W gerpable : gerpables) {
      TOP top = WrapperHelper.unwrap(indexer, gerpable, jcas);
      top.addToIndexes(jcas);
    }
  }

  public W get(int i) {
    return gerpables.get(i);
  }

  public int size() {
    return gerpables.size();
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(gerpables);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    @SuppressWarnings("rawtypes")
    GerpableList other = (GerpableList) obj;
    return Objects.equal(this.gerpables, other.gerpables);
  }

  public List<W> getGerpables() {
    return gerpables;
  }

  public void setGerpables(List<W> gerpables) {
    this.gerpables = gerpables;
  }

}
