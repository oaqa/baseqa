package edu.cmu.lti.oaqa.gerp.data;

import java.util.ArrayList;
import java.util.List;

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
  
  public PassageEvidenceWrapper(float confidence, List<PassageWrapper> passages) {
    super();
    this.confidence = confidence;
    this.additionalEvidenceWrapperClass = PassageWrapper.class;
    this.additionalEvidences = passages;
  }

  public PassageEvidenceWrapper() {
    this(0f);
  }

}
