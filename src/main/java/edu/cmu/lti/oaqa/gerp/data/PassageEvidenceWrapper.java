package edu.cmu.lti.oaqa.gerp.data;

import java.util.ArrayList;

import org.oaqa.model.retrieval.SearchResult;

import edu.cmu.lti.oaqa.baseqa.data.retrieval.PassageWrapper;

public class PassageEvidenceWrapper extends EvidenceWrapper<SearchResult, PassageWrapper> {

  private static final long serialVersionUID = 1L;

  public PassageEvidenceWrapper(float confidence) {
    super();
    this.confidence = confidence;
    this.additionalEvidenceWrapperClass = PassageWrapper.class;
    this.additionalEvidences = new ArrayList<PassageWrapper>();
  }

  public PassageEvidenceWrapper() {
    this(0f);
  }

}
