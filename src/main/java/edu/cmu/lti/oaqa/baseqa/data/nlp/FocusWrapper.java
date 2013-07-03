package edu.cmu.lti.oaqa.baseqa.data.nlp;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.nlp.Focus;

import com.google.common.base.Objects;

import edu.cmu.lti.oaqa.baseqa.data.core.WrapperHelper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.GerpAnnotationWrapper;

public class FocusWrapper extends GerpAnnotationWrapper<Focus> {

  private static final long serialVersionUID = 1L;

  private PredicateWrapper predicate;

  private String label;

  public FocusWrapper(int begin, int end, PredicateWrapper predicate, String label) {
    super(begin, end);
    this.predicate = predicate;
    this.label = label;
  }

  public FocusWrapper(int begin, int end, PredicateWrapper predicate, String label, String generator) {
    super(begin, end, generator);
    this.predicate = predicate;
    this.label = label;
  }

  @Override
  public Class<? extends Focus> getTypeClass() {
    return Focus.class;
  }

  @Override
  public void wrap(Focus annotation) throws AnalysisEngineProcessException {
    super.wrap(annotation);
    try {
      this.predicate = WrapperHelper.matchSubclassAndWrap(annotation.getPredicate(),
              PredicateWrapper.class);
    } catch (Exception e) {
      throw new AnalysisEngineProcessException(e);
    }
    this.label = annotation.getLabel();
  }

  @Override
  public Focus unwrap(JCas jcas) throws AnalysisEngineProcessException {
    Focus annotation = super.unwrap(jcas);
    annotation.setPredicate(predicate.unwrap(jcas));
    annotation.setLabel(label);
    return annotation;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode());
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    return true;
  }

  public PredicateWrapper getPredicate() {
    return predicate;
  }

  public void setPredicate(PredicateWrapper predicate) {
    this.predicate = predicate;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

}
