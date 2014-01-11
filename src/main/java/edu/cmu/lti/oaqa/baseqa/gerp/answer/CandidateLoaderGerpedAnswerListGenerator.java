package edu.cmu.lti.oaqa.baseqa.gerp.answer;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CASException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.TOP;
import org.oaqa.model.answer.AnswerList;

import com.google.common.collect.Iterables;

import edu.cmu.lti.oaqa.baseqa.data.answer.AnswerListWrapper;
import edu.cmu.lti.oaqa.baseqa.data.answer.AnswerWrapper;
import edu.cmu.lti.oaqa.baseqa.data.kb.InterpretationWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.ParseWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.QuestionWrapper;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.AbstractQueryWrapper;
import edu.cmu.lti.oaqa.core.data.TopWrapper;
import edu.cmu.lti.oaqa.core.data.WrapperHelper;
import edu.cmu.lti.oaqa.core.data.WrapperIndexer;
import edu.cmu.lti.oaqa.framework.ViewManager;
import edu.cmu.lti.oaqa.framework.ViewManager.ViewType;

public class CandidateLoaderGerpedAnswerListGenerator extends GerpedAnswerListGenerator {

  private List<AnswerWrapper> candidates;

  @Override
  public void process(JCas jcas) throws AnalysisEngineProcessException {
    try {
      JCas candidateView = ViewManager.getOrCreateView(jcas, ViewType.CANDIDATE);
      // new wrapper indexer is required to distinguish objects in different views.
      AnswerListWrapper answerList = (AnswerListWrapper) (TopWrapper<? extends TOP>) Iterables
              .getOnlyElement(WrapperHelper.wrapAllFromJCas(new WrapperIndexer(), candidateView,
                      AnswerList.type));
      candidates = answerList.getAnswerList();
    } catch (CASException e) {
      throw new AnalysisEngineProcessException(e);
    }
    super.process(jcas);
  }

  @Override
  protected List<AnswerWrapper> getAnswerCandidates(QuestionWrapper question, ParseWrapper parse,
          InterpretationWrapper interpretation, AbstractQueryWrapper abstractQuery)
          throws AnalysisEngineProcessException {
    return candidates;
  }

}
