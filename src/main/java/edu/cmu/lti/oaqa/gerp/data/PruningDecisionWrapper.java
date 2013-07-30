package edu.cmu.lti.oaqa.gerp.data;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.oaqa.model.gerp.PruningDecision;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

import edu.cmu.lti.oaqa.core.data.WrapperIndexer;

public class PruningDecisionWrapper extends GerpBaseWrapper<PruningDecision> implements
        Comparable<PruningDecisionWrapper> {

  private static final long serialVersionUID = 1L;

  private boolean decision;

  public PruningDecisionWrapper(boolean decision) {
    super();
    this.decision = decision;
  }

  public PruningDecisionWrapper() {
    this(false);
  }

  @Override
  public Class<? extends PruningDecision> getTypeClass() {
    return PruningDecision.class;
  }

  @Override
  public void wrap(WrapperIndexer indexer, PruningDecision top)
          throws AnalysisEngineProcessException {
    super.wrap(indexer, top);
    decision = top.getDecision();
  }

  @Override
  public void unwrap(WrapperIndexer indexer, PruningDecision top)
          throws AnalysisEngineProcessException {
    super.unwrap(indexer, top);
    top.setDecision(decision);
  }

  @Override
  protected void wrapComments(WrapperIndexer indexer, PruningDecision top) {
    // TODO Auto-generated method stub

  }

  @Override
  protected void unwrapComments(WrapperIndexer indexer, PruningDecision top) {
    // TODO Auto-generated method stub

  }

  @Override
  public int compareTo(PruningDecisionWrapper o) {
    return ComparisonChain.start().compareFalseFirst(decision, o.decision).result();
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(decision);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    PruningDecisionWrapper other = (PruningDecisionWrapper) obj;
    return Objects.equal(decision, other.decision);
  }

  @Override
  public String toString() {
    return String.valueOf(decision);
  }

  public boolean isPruned() {
    return decision;
  }

  public void setDecision(boolean decision) {
    this.decision = decision;
  }

}
