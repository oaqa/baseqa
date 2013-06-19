package edu.cmu.lti.oaqa.cse.basephase.gerp.evidencer;

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
import edu.cmu.lti.oaqa.framework.data.RetrievalResult;
import edu.cmu.lti.oaqa.framework.data.RetrievalResultArray;
import edu.cmu.lti.oaqa.framework.types.InputElement;

public abstract class AbstractDocumentEvidencer extends AbstractCandidateEvidencer {

  @Override
  public void evidenceCandidates(JCas jcas) throws AnalysisEngineProcessException {
    // prepare input
    final InputElement input = ((InputElement) BaseJCasHelper
            .getAnnotation(jcas, InputElement.type));
    final List<Keyterm> keyterms = KeytermList.retrieveKeyterms(jcas);
    List<RetrievalResult> documents = null;
    try {
      documents = RetrievalResultArray.retrieveRetrievalResults(ViewManager.getDocumentView(jcas));
    } catch (CASException e) {
      new AnalysisEngineProcessException(e);
    }
    // do task
    evidenceDocuments(input.getQuestion(), keyterms, documents);
    // save output
    try {
      RetrievalResultArray.storeRetrievalResults(
              GerpViewManager.getView(jcas, ViewType.DOCUMENT_EVIDENCE), documents, false);
    } catch (CASException e) {
      new AnalysisEngineProcessException(e);
    }
  }

  protected abstract void evidenceDocuments(final String question, final List<Keyterm> keyterms,
          List<RetrievalResult> documents) throws AnalysisEngineProcessException;
}
