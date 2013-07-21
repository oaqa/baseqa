package edu.cmu.lti.oaqa.gerp.data;

import java.util.ArrayList;

import org.oaqa.model.core.OAQATop;

import edu.cmu.lti.oaqa.core.data.OAQATopWrapper;

public class DefaultEvidenceWrapper extends EvidenceWrapper<OAQATop, OAQATopWrapper<OAQATop>> {

  private static final long serialVersionUID = 1L;

  private Class<OAQATopWrapper<OAQATop>> clazz;

  public DefaultEvidenceWrapper(float confidence) {
    super();
    this.confidence = confidence;
    this.additionalEvidenceWrapperClass = clazz;
    this.additionalEvidences = new ArrayList<OAQATopWrapper<OAQATop>>();
  }

  public DefaultEvidenceWrapper(float confidence, OAQATopWrapper<OAQATop> additionalEvidence) {
    this(confidence);
    addAdditionalEvidence(additionalEvidence);
  }

  public DefaultEvidenceWrapper() {
    this(0f);
  }

}
