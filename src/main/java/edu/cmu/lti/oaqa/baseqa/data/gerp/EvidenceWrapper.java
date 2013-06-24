package edu.cmu.lti.oaqa.baseqa.data.gerp;

import org.oaqa.model.gerp.Evidence;

import edu.cmu.lti.oaqa.baseqa.data.core.OAQATopWrapper;

public class EvidenceWrapper extends OAQATopWrapper<Evidence> {

  @Override
  public Class<? extends Evidence> getTypeClass() {
    return Evidence.class;
  }

}
