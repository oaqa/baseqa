package edu.cmu.lti.oaqa.gerp.data;

import java.util.ArrayList;
import java.util.List;

import org.oaqa.model.retrieval.SearchResult;

import edu.cmu.lti.oaqa.baseqa.data.retrieval.RelationSearchResultWrapper;

public class RelationSearchResultEvidenceWrapper extends
        EvidenceWrapper<SearchResult, RelationSearchResultWrapper> {

  private static final long serialVersionUID = 1L;

  public RelationSearchResultEvidenceWrapper(float confidence) {
    super();
    this.confidence = confidence;
    this.additionalEvidenceWrapperClass = RelationSearchResultWrapper.class;
    this.additionalEvidences = new ArrayList<RelationSearchResultWrapper>();
  }

  public RelationSearchResultEvidenceWrapper(float confidence,
          List<RelationSearchResultWrapper> relations) {
    super();
    this.confidence = confidence;
    this.additionalEvidenceWrapperClass = RelationSearchResultWrapper.class;
    this.additionalEvidences = relations;
  }

  public RelationSearchResultEvidenceWrapper() {
    this(0f);
  }

}
