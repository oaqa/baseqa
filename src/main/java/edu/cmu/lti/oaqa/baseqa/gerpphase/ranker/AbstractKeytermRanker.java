package edu.cmu.lti.oaqa.baseqa.gerpphase.ranker;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CASException;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.baseqa.data.nlp.Keyterm;
import edu.cmu.lti.oaqa.baseqa.data.nlp.KeytermList;
import edu.cmu.lti.oaqa.baseqa.gerpphase.GerpViewManager;
import edu.cmu.lti.oaqa.baseqa.gerpphase.GerpViewManager.ViewType;
import edu.cmu.lti.oaqa.framework.BaseJCasHelper;
import edu.cmu.lti.oaqa.framework.types.InputElement;

public abstract class AbstractKeytermRanker extends AbstractCandidateRanker {

  @Override
  public void rankCandidates(JCas jcas) throws AnalysisEngineProcessException {
    // prepare input
    final String question = ((InputElement) BaseJCasHelper.getAnnotation(jcas, InputElement.type))
            .getQuestion();
    List<Keyterm> keyterms;
    try {
      keyterms = KeytermList.retrieveKeyterms(GerpViewManager.getOrCreateView(jcas,
              ViewType.KEYTERM_EVIDENCE));
    } catch (CASException e) {
      throw new AnalysisEngineProcessException(e);
    }
    // do task
    rankKeyterms(question, keyterms);
    // save output
    try {
      KeytermList.storeKeyterms(GerpViewManager.getOrCreateView(jcas, ViewType.KEYTERM_RANK),
              keyterms, false);
    } catch (CASException e) {
      throw new AnalysisEngineProcessException(e);
    }
  }

  protected abstract void rankKeyterms(final String question, List<Keyterm> keyterms)
          throws AnalysisEngineProcessException;
}
