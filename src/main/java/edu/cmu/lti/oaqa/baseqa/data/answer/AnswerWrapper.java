package edu.cmu.lti.oaqa.baseqa.data.answer;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.answer.Answer;

import com.google.common.base.Objects;

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

  public AnswerWrapper(String text, List<String> variants, String generator) {
    super(generator);
    this.text = text;
    this.variants = variants;
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
  public Answer unwrap(JCas jcas) throws AnalysisEngineProcessException {
    Answer top = super.unwrap(jcas);
    top.setText(text);
    top.setVariants(WrapperHelper.unwrapStringArray(variants, jcas));
    return top;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), text, variants);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    AnswerWrapper other = (AnswerWrapper) obj;
    return Objects.equal(text, other.text) && Objects.equal(variants, other.variants);
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
