package edu.cmu.lti.oaqa.cse.basephase.gerp.ranker;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CASException;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.cse.basephase.gerp.GerpViewManager;
import edu.cmu.lti.oaqa.cse.basephase.gerp.GerpViewManager.ViewType;
import edu.cmu.lti.oaqa.framework.BaseJCasHelper;
import edu.cmu.lti.oaqa.framework.ViewManager;
import edu.cmu.lti.oaqa.framework.data.Keyterm;
import edu.cmu.lti.oaqa.framework.data.KeytermList;
import edu.cmu.lti.oaqa.framework.data.PassageCandidate;
import edu.cmu.lti.oaqa.framework.data.PassageCandidateArray;
import edu.cmu.lti.oaqa.framework.data.RetrievalResult;
import edu.cmu.lti.oaqa.framework.data.RetrievalResultArray;
import edu.cmu.lti.oaqa.framework.types.InputElement;

public abstract class AbstractPassageRanker extends AbstractCandidateRanker {

  @Override
  public void rankCandidates(JCas jcas) throws AnalysisEngineProcessException {
    // prepare input
    final String question = ((InputElement) BaseJCasHelper.getAnnotation(jcas, InputElement.type))
            .getQuestion();
    final KeytermList keytermList = new KeytermList(jcas);
    final List<Keyterm> keyterms = keytermList.getKeyterms();
    final List<RetrievalResult> documents;
    List<PassageCandidate> passages;
    try {
      documents = RetrievalResultArray.retrieveRetrievalResults(ViewManager.getDocumentView(jcas));
      passages = PassageCandidateArray.retrievePassageCandidates(GerpViewManager.getView(jcas,
              ViewType.CANDIDATE_EVIDENCE));
    } catch (CASException e) {
      throw new AnalysisEngineProcessException(e);
    }
    // do task
    rankPassages(question, keyterms, documents, passages);
    // save output
    try {
      PassageCandidateArray.storePassageCandidates(
              GerpViewManager.getView(jcas, ViewType.CANDIDATE_RANK), passages, false);
    } catch (CASException e) {
      throw new AnalysisEngineProcessException(e);
    }
  }

  protected abstract void rankPassages(final String question, final List<Keyterm> keyterms,
          final List<RetrievalResult> documents, List<PassageCandidate> passages)
          throws AnalysisEngineProcessException;
}
