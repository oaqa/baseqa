package edu.cmu.lti.oaqa.baseqa.gerpphase.evidencer;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CASException;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.baseqa.data.nlp.Keyterm;
import edu.cmu.lti.oaqa.baseqa.data.nlp.KeytermList;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.PassageCandidate;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.PassageCandidateArray;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.RetrievalResult;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.RetrievalResultArray;
import edu.cmu.lti.oaqa.baseqa.gerpphase.GerpViewManager;
import edu.cmu.lti.oaqa.baseqa.gerpphase.GerpViewManager.ViewType;
import edu.cmu.lti.oaqa.framework.BaseJCasHelper;
import edu.cmu.lti.oaqa.framework.ViewManager;
import edu.cmu.lti.oaqa.framework.types.InputElement;

public abstract class AbstractPassageEvidencer extends AbstractEvidencer {

  @Override
  public void evidenceCandidates(JCas jcas) throws AnalysisEngineProcessException {
    // prepare input
    final String question = ((InputElement) BaseJCasHelper.getAnnotation(jcas,
            InputElement.type)).getQuestion();
    final KeytermList keytermList = new KeytermList(jcas);
    final List<Keyterm> keyterms = keytermList.getKeyterms();
    final List<RetrievalResult> documents;
    List<PassageCandidate> passages;
    try {
      documents = RetrievalResultArray.retrieveRetrievalResults(ViewManager.getDocumentView(jcas));
      passages = PassageCandidateArray
              .retrievePassageCandidates(ViewManager.getCandidateView(jcas));
    } catch (CASException e) {
      throw new AnalysisEngineProcessException(e);
    }
    // do task
    evidencePassages(question, keyterms, documents, passages);
    // save output
    try {
      PassageCandidateArray.storePassageCandidates(
              GerpViewManager.getOrCreateView(jcas, ViewType.CANDIDATE_EVIDENCE), passages, false);
    } catch (CASException e) {
      throw new AnalysisEngineProcessException(e);
    }
  }

  protected abstract void evidencePassages(final String question, final List<Keyterm> keyterms,
          final List<RetrievalResult> documents, List<PassageCandidate> passages)
          throws AnalysisEngineProcessException;
}
