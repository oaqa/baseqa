package edu.cmu.lti.oaqa.gerp.data;

import java.util.ArrayList;
import java.util.List;

import org.oaqa.model.retrieval.SearchResult;

import edu.cmu.lti.oaqa.baseqa.data.retrieval.EntitySearchResultWrapper;

public class EntitySearchResultEvidenceWrapper extends
        EvidenceWrapper<SearchResult, EntitySearchResultWrapper> {

  private static final long serialVersionUID = 1L;

  public EntitySearchResultEvidenceWrapper(float confidence) {
    super();
    this.confidence = confidence;
    this.additionalEvidenceWrapperClass = EntitySearchResultWrapper.class;
    this.additionalEvidences = new ArrayList<EntitySearchResultWrapper>();
  }

  public EntitySearchResultEvidenceWrapper(float confidence,
          List<EntitySearchResultWrapper> entities) {
    super();
    this.confidence = confidence;
    this.additionalEvidenceWrapperClass = EntitySearchResultWrapper.class;
    this.additionalEvidences = entities;
  }

  public EntitySearchResultEvidenceWrapper() {
    this(0f);
  }

}
