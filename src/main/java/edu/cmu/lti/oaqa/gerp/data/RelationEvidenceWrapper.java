package edu.cmu.lti.oaqa.gerp.data;

import java.util.ArrayList;

import org.oaqa.model.kb.Concept;

import edu.cmu.lti.oaqa.baseqa.data.kb.RelationWrapper;

public class RelationEvidenceWrapper extends EvidenceWrapper<Concept, RelationWrapper> {

  private static final long serialVersionUID = 1L;

  public RelationEvidenceWrapper(float confidence) {
    super();
    this.confidence = confidence;
    this.additionalEvidenceWrapperClass = RelationWrapper.class;
    this.additionalEvidences = new ArrayList<RelationWrapper>();
  }

  public RelationEvidenceWrapper() {
    this(0f);
  }

}
