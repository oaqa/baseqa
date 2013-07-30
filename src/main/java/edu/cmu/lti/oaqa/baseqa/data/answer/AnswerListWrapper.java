package edu.cmu.lti.oaqa.baseqa.data.answer;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.oaqa.model.answer.AnswerList;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.core.data.WrapperHelper;
import edu.cmu.lti.oaqa.core.data.WrapperIndexer;
import edu.cmu.lti.oaqa.gerp.data.GerpTopWrapper;

public class AnswerListWrapper extends GerpTopWrapper<AnswerList> {

  private static final long serialVersionUID = 1L;

  private List<AnswerWrapper> answerList;

  public AnswerListWrapper(List<AnswerWrapper> answerList) {
    super();
    this.answerList = answerList;
  }

  public AnswerListWrapper(List<AnswerWrapper> answerList, String generator) {
    this(answerList);
    addGenerator(generator);
  }

  public AnswerListWrapper() {
    this(Lists.<AnswerWrapper> newArrayList());
  }

  @Override
  public void wrap(WrapperIndexer indexer, AnswerList top) throws AnalysisEngineProcessException {
    super.wrap(indexer, top);
    this.answerList = WrapperHelper.wrapTopArray(indexer, top.getAnswerList(), AnswerWrapper.class);
  }

  @Override
  public void unwrap(WrapperIndexer indexer, AnswerList top) throws AnalysisEngineProcessException {
    super.unwrap(indexer, top);
    top.setAnswerList(WrapperHelper.unwrapTopArray(indexer, answerList, WrapperHelper.getJCas(top)));
  }

  @Override
  public Class<? extends AnswerList> getTypeClass() {
    return AnswerList.class;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(answerList);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    AnswerListWrapper other = (AnswerListWrapper) obj;
    return Objects.equal(this.answerList, other.answerList);
  }

  public List<AnswerWrapper> getAnswerList() {
    return answerList;
  }

  public void setAnswerList(List<AnswerWrapper> answerList) {
    this.answerList = answerList;
  }

}
