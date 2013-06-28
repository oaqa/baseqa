package edu.cmu.lti.oaqa.baseqa.gerpphase.evidencer;

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

public abstract class AbstractKeytermEvidencer extends AbstractEvidencer {

  @Override
  public void evidenceCandidates(JCas jcas) throws AnalysisEngineProcessException {
    // prepare input
    final String question = ((InputElement) BaseJCasHelper.getAnnotation(jcas, InputElement.type))
            .getQuestion();
    final List<Keyterm> keyterms = KeytermList.retrieveKeyterms(jcas);
    // do task
    evidenceKeyterms(question, keyterms);
    // save output
    try {
      KeytermList.storeKeyterms(GerpViewManager.getOrCreateView(jcas, ViewType.KEYTERM_EVIDENCE),
              keyterms, false);
    } catch (CASException e) {
      throw new AnalysisEngineProcessException(e);
    }
  }

  protected abstract void evidenceKeyterms(final String question, List<Keyterm> keyterms)
          throws AnalysisEngineProcessException;
}
