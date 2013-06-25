package edu.cmu.lti.oaqa.baseqa.data.gerp;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSList;
import org.oaqa.model.gerp.PruningDecision;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

public final class PruningDecisionWrapper extends GerpBaseWrapper<PruningDecision> implements
        Comparable<PruningDecisionWrapper> {

  private static final long serialVersionUID = 1L;

  private boolean decision;

  public PruningDecisionWrapper(boolean decision) {
    super();
    this.decision = decision;
  }

  @Override
  public Class<? extends PruningDecision> getTypeClass() {
    return PruningDecision.class;
  }

  @Override
  public void wrap(PruningDecision top) throws AnalysisEngineProcessException {
    super.wrap(top);
    decision = top.getDecision();
  }

  @Override
  public PruningDecision unwrap(JCas jcas) throws AnalysisEngineProcessException {
    PruningDecision top = super.unwrap(jcas);
    top.setDecision(decision);
    return top;
  }

  @Override
  protected void wrapComments(PruningDecision top) {
    // TODO Auto-generated method stub

  }

  @Override
  protected FSList unwrapComments(JCas jcas) {
    // TODO Auto-generated method stub
    return null;
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

  public boolean isPruned() {
    return decision;
  }

  public void setDecision(boolean decision) {
    this.decision = decision;
  }

}
