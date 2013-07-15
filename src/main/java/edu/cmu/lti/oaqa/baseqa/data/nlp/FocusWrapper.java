package edu.cmu.lti.oaqa.baseqa.data.nlp;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.nlp.Focus;

import com.google.common.base.Objects;

import edu.cmu.lti.oaqa.baseqa.data.core.WrapperHelper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.GerpAnnotationWrapper;

public class FocusWrapper extends GerpAnnotationWrapper<Focus> {

  private static final long serialVersionUID = 1L;

  private TokenWrapper token;

  private String label;

  public FocusWrapper(int begin, int end, TokenWrapper token, String label) {
    super(begin, end);
    this.token = token;
    this.label = label;
  }

  public FocusWrapper(int begin, int end, TokenWrapper token, String label, String generator) {
    this(begin, end, token, label);
    addGenerator(generator);
  }

  public FocusWrapper() {
    this(0, Integer.MAX_VALUE, null, null);
  }

  @Override
  public Class<? extends Focus> getTypeClass() {
    return Focus.class;
  }

  @Override
  public void wrap(Focus annotation) throws AnalysisEngineProcessException {
    super.wrap(annotation);
    try {
      this.token = WrapperHelper.matchSubclassAndWrapIfNotWrapped(annotation.getToken(),
              TokenWrapper.class);
    } catch (Exception e) {
      throw new AnalysisEngineProcessException(e);
    }
    this.label = annotation.getLabel();
  }

  @Override
  public Focus unwrap(JCas jcas) throws AnalysisEngineProcessException {
    Focus annotation = super.unwrap(jcas);
    annotation.setToken(token.unwrapIfNotUnwrapped(jcas));
    annotation.setLabel(label);
    return annotation;
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
    FocusWrapper other = (FocusWrapper) obj;
    return Objects.equal(this.label, other.label);
  }

  public TokenWrapper getToken() {
    return token;
  }

  public void setToken(TokenWrapper token) {
    this.token = token;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

}
