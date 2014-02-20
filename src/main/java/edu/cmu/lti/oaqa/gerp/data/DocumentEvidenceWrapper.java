package edu.cmu.lti.oaqa.gerp.data;

import java.util.ArrayList;

import org.oaqa.model.retrieval.SearchResult;

import edu.cmu.lti.oaqa.baseqa.data.retrieval.DocumentWrapper;

public class DocumentEvidenceWrapper extends EvidenceWrapper<SearchResult, DocumentWrapper> {

  private static final long serialVersionUID = 1L;

  public DocumentEvidenceWrapper(float confidence) {
    super();
    this.confidence = confidence;
    this.additionalEvidenceWrapperClass = DocumentWrapper.class;
    this.additionalEvidences = new ArrayList<DocumentWrapper>();
  }

  public DocumentEvidenceWrapper() {
    this(0f);
  }

}
