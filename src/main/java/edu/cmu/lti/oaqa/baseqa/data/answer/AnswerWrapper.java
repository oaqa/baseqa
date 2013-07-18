package edu.cmu.lti.oaqa.baseqa.data.answer;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.oaqa.model.answer.Answer;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.data.core.WrapperHelper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.GerpTopWrapper;

public class AnswerWrapper extends GerpTopWrapper<Answer> {

  private static final long serialVersionUID = 1L;

  private String text;

  private List<String> variants;

  public AnswerWrapper(String text, List<String> variants) {
    super();
    this.text = text;
    this.variants = variants;
  }

  public AnswerWrapper() {
    this(null, Lists.<String> newArrayList());
  }

  public AnswerWrapper(String text, List<String> variants, String generator) {
    this(text, variants);
    addGenerator(generator);
  }

  @Override
  public Class<? extends Answer> getTypeClass() {
    return Answer.class;
  }

  @Override
  public void wrap(Answer top) throws AnalysisEngineProcessException {
    super.wrap(top);
    this.text = top.getText();
    this.variants = WrapperHelper.wrapStringArray(top.getVariants());
  }

  @Override
  public void unwrap(Answer top) throws AnalysisEngineProcessException {
    super.unwrap(top);
    top.setText(text);
    top.setVariants(WrapperHelper.unwrapStringArray(variants, WrapperHelper.getJCas(top)));
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(text);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    AnswerWrapper other = (AnswerWrapper) obj;
    return Objects.equal(this.text, other.text);
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public List<String> getVariants() {
    return variants;
  }

  public void setVariants(List<String> variants) {
    this.variants = variants;
  }

}
