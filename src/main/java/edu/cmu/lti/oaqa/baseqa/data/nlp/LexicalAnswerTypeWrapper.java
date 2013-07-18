package edu.cmu.lti.oaqa.baseqa.data.nlp;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.oaqa.model.nlp.LexicalAnswerType;

import com.google.common.base.Objects;

import edu.cmu.lti.oaqa.baseqa.data.core.WrapperHelper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.GerpAnnotationWrapper;

public class LexicalAnswerTypeWrapper extends GerpAnnotationWrapper<LexicalAnswerType> {

  private static final long serialVersionUID = 1L;

  private TokenWrapper token;

  private String label;

  public LexicalAnswerTypeWrapper(int begin, int end, TokenWrapper token, String label) {
    super(begin, end);
    this.token = token;
    this.label = label;
  }

  public LexicalAnswerTypeWrapper(int begin, int end, TokenWrapper token, String label,
          String generator) {
    this(begin, end, token, label);
    addGenerator(generator);
  }

  public LexicalAnswerTypeWrapper() {
    this(0, Integer.MAX_VALUE, null, null);
  }

  @Override
  public Class<? extends LexicalAnswerType> getTypeClass() {
    return LexicalAnswerType.class;
  }

  @Override
  public void wrap(LexicalAnswerType annotation) throws AnalysisEngineProcessException {
    super.wrap(annotation);
    if (annotation.getToken() != null) {
      this.token = WrapperHelper.matchSubclassAndWrap(annotation.getToken(), TokenWrapper.class);
    }
    this.label = annotation.getLabel();
  }

  @Override
  public void unwrap(LexicalAnswerType annotation) throws AnalysisEngineProcessException {
    super.unwrap(annotation);
    if (token != null) {
      annotation.setToken(WrapperHelper.unwrap(token, WrapperHelper.getJCas(annotation)));
    }
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
    LexicalAnswerTypeWrapper other = (LexicalAnswerTypeWrapper) obj;
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
