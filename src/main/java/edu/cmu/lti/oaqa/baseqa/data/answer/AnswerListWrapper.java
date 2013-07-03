package edu.cmu.lti.oaqa.baseqa.data.answer;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.answer.AnswerList;

import com.google.common.base.Objects;

import edu.cmu.lti.oaqa.baseqa.data.core.WrapperHelper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.GerpTopWrapper;

public class AnswerListWrapper extends GerpTopWrapper<AnswerList> {

  private static final long serialVersionUID = 1L;

  private List<AnswerWrapper> answerList;

  public AnswerListWrapper(List<AnswerWrapper> answerList) {
    super();
    this.answerList = answerList;
  }

  public AnswerListWrapper(List<AnswerWrapper> answerList, String generator) {
    super(generator);
    this.answerList = answerList;
  }

  @Override
  public void wrap(AnswerList top) throws AnalysisEngineProcessException {
    super.wrap(top);
    try {
      this.answerList = WrapperHelper.wrapTopArray(top.getAnswerList(), AnswerWrapper.class);
    } catch (Exception e) {
      throw new AnalysisEngineProcessException(e);
    }
  }

  @Override
  public AnswerList unwrap(JCas jcas) throws AnalysisEngineProcessException {
    AnswerList top = super.unwrap(jcas);
    top.setAnswerList(WrapperHelper.unwrapTopArray(answerList, jcas));
    return top;
  }

  @Override
  public Class<? extends AnswerList> getTypeClass() {
    return AnswerList.class;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), answerList);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    AnswerListWrapper other = (AnswerListWrapper) obj;
    return Objects.equal(answerList, other.answerList);
  }

  public List<AnswerWrapper> getAnswerList() {
    return answerList;
  }

  public void setAnswerList(List<AnswerWrapper> answerList) {
    this.answerList = answerList;
  }

}
