package edu.cmu.lti.oaqa.baseqa.data.gerp;

import org.oaqa.model.gerp.PruningDecision;

import edu.cmu.lti.oaqa.baseqa.data.core.OAQATopWrapper;

public class PruningDecisionWrapper extends OAQATopWrapper<PruningDecision> {

  @Override
  public Class<? extends PruningDecision> getTypeClass() {
    return PruningDecision.class;
  }

}
