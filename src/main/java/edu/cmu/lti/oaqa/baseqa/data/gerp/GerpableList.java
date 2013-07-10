package edu.cmu.lti.oaqa.baseqa.data.gerp;

import java.util.Collection;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.TOP;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.data.core.TopWrapper;

public class GerpableList<W extends Gerpable & TopWrapper<? extends TOP>> {

  private List<W> gerpables;

  private int gerpableCount;

  public GerpableList() {
    this.gerpables = Lists.newArrayList();
    this.gerpableCount = 0;
  }

  public void add(W gerpable, String generator) {
    int index = -1;
    if ((index = gerpables.indexOf(gerpable)) > 0) {
      gerpables.get(index).addGenerator(generator);
    } else {
      gerpable.addGenerator(generator);
      gerpables.add(gerpable);
    }
    gerpableCount++;
  }

  public void addAllEvidences(List<EvidenceWrapper<?, ?>> evidences) {
    assert evidences.size() == gerpableCount;
    for (int i = 0; i < gerpableCount; i++) {
      gerpables.get(i).addEvidence(evidences.get(i));
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

  public void unwrapAllAndAddToIndexes(JCas jcas) throws AnalysisEngineProcessException {
    for (W gerpable : gerpables) {
      TOP top = gerpable.unwrap(jcas);
      top.addToIndexes(jcas);
    }
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
