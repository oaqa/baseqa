package edu.cmu.lti.oaqa.baseqa.data.nlp;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.oaqa.model.nlp.SemanticRole;

import com.google.common.base.Objects;

import edu.cmu.lti.oaqa.baseqa.data.gerp.GerpAnnotationWrapper;

public class SemanticRoleWrapper extends GerpAnnotationWrapper<SemanticRole> {

  private static final long serialVersionUID = 1L;

  private String label;

  public SemanticRoleWrapper(int begin, int end, String label) {
    super(begin, end);
    this.label = label;
  }

  public SemanticRoleWrapper(int begin, int end, String label, String generator) {
    this(begin, end, label);
    addGenerator(generator);
  }

  public SemanticRoleWrapper() {
    this(0, Integer.MAX_VALUE, null);
  }

  @Override
  public Class<? extends SemanticRole> getTypeClass() {
    return SemanticRole.class;
  }

  @Override
  public void wrap(SemanticRole annotation) throws AnalysisEngineProcessException {
    super.wrap(annotation);
    this.label = annotation.getLabel();
  }

  @Override
  public void unwrap(SemanticRole annotation) throws AnalysisEngineProcessException {
    super.unwrap(annotation);
    annotation.setLabel(label);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), label);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    SemanticRoleWrapper other = (SemanticRoleWrapper) obj;
    return Objects.equal(this.label, other.label);
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

}
