package edu.cmu.lti.oaqa.gerp.data;

import java.util.ArrayList;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.cas.TOP;
import org.oaqa.model.gerp.Evidence;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

import edu.cmu.lti.oaqa.core.data.TopWrapper;
import edu.cmu.lti.oaqa.core.data.WrapperHelper;
import edu.cmu.lti.oaqa.core.data.WrapperIndexer;

public abstract class EvidenceWrapper<T extends TOP, W extends TopWrapper<T>> extends
        GerpBaseWrapper<Evidence> implements Comparable<EvidenceWrapper<T, W>> {

  private static final long serialVersionUID = 1L;

  protected float confidence;

  protected List<W> additionalEvidences;

  protected Class<W> additionalEvidenceWrapperClass;

  protected EvidenceWrapper() {
    super();
  }

  protected EvidenceWrapper(float confidence, Class<W> additionalEvidenceWrapperClass) {
    super();
    this.confidence = confidence;
    this.additionalEvidenceWrapperClass = additionalEvidenceWrapperClass;
    this.additionalEvidences = new ArrayList<W>();
  }

  protected EvidenceWrapper(float confidence, W additionalEvidence,
          Class<W> additionalEvidenceWrapperClass) {
    this(confidence, additionalEvidenceWrapperClass);
    addAdditionalEvidence(additionalEvidence);
  }

  public void addAdditionalEvidence(W additionalEvidence) {
    this.additionalEvidences.add(additionalEvidence);
  }

  @Override
  public Class<? extends Evidence> getTypeClass() {
    return Evidence.class;
  }

  @Override
  public void wrap(WrapperIndexer indexer, Evidence top) throws AnalysisEngineProcessException {
    super.wrap(indexer, top);
    confidence = top.getConfidence();
    additionalEvidences = WrapperHelper.wrapTopList(indexer, top.getAdditionalEvidences(),
            additionalEvidenceWrapperClass);
  }

  @Override
  public void unwrap(WrapperIndexer indexer, Evidence top) throws AnalysisEngineProcessException {
    super.unwrap(indexer, top);
    top.setConfidence(confidence);
    top.setAdditionalEvidences(WrapperHelper.unwrapTopList(indexer, additionalEvidences,
            WrapperHelper.getJCas(top)));
  }

  @Override
  protected void wrapComments(WrapperIndexer indexer, Evidence top) {
    // TODO Auto-generated method stub

  }

  @Override
  protected void unwrapComments(WrapperIndexer indexer, Evidence top) {
    // TODO Auto-generated method stub

  }

  @Override
  public int compareTo(EvidenceWrapper<T, W> o) {
    return ComparisonChain.start().compare(confidence, o.confidence).result();
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(confidence, additionalEvidences);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    @SuppressWarnings("rawtypes")
    EvidenceWrapper other = (EvidenceWrapper) obj;
    return Objects.equal(this.confidence, other.confidence)
            && Objects.equal(this.additionalEvidences, other.additionalEvidences);
  }

  @Override
  public String toString() {
    return String.valueOf(confidence);
  }

  public float getConfidence() {
    return confidence;
  }

  public void setConfidence(float confidence) {
    this.confidence = confidence;
  }

  public List<W> getAdditionalEvidences() {
    return additionalEvidences;
  }

  public void setAdditionalEvidences(List<W> additionalEvidences) {
    this.additionalEvidences = additionalEvidences;
  }

}
