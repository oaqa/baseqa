package edu.cmu.lti.oaqa.gerp.data;

import java.util.ArrayList;

import org.oaqa.model.gerp.Evidence;
import org.oaqa.model.kb.Concept;

import edu.cmu.lti.oaqa.baseqa.data.kb.ConceptWrapper;

public class ConceptEvidenceWrapper extends EvidenceWrapper<Concept, ConceptWrapper> {

  private static final long serialVersionUID = 1L;

  public ConceptEvidenceWrapper(float confidence) {
    super();
    this.confidence = confidence;
    this.additionalEvidenceWrapperClass = ConceptWrapper.class;
    this.additionalEvidences = new ArrayList<ConceptWrapper>();
  }

  public ConceptEvidenceWrapper() {
    this(0f);
  }
  
  @Override
  public Class<? extends Evidence> getTypeClass() {
    return Evidence.class;
  }

}
