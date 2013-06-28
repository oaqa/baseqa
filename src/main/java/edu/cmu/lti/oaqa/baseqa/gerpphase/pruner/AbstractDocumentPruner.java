package edu.cmu.lti.oaqa.baseqa.gerpphase.pruner;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CASException;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.baseqa.data.nlp.Keyterm;
import edu.cmu.lti.oaqa.baseqa.data.nlp.KeytermList;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.RetrievalResult;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.RetrievalResultArray;
import edu.cmu.lti.oaqa.baseqa.gerpphase.GerpViewManager;
import edu.cmu.lti.oaqa.baseqa.gerpphase.GerpViewManager.ViewType;
import edu.cmu.lti.oaqa.framework.BaseJCasHelper;
import edu.cmu.lti.oaqa.framework.ViewManager;
import edu.cmu.lti.oaqa.framework.types.InputElement;

public abstract class AbstractDocumentPruner extends AbstractPruner {

  @Override
  public void pruneCandidates(JCas jcas) throws AnalysisEngineProcessException {
    // prepare input
    final InputElement input = ((InputElement) BaseJCasHelper
            .getAnnotation(jcas, InputElement.type));
    final List<Keyterm> keyterms = KeytermList.retrieveKeyterms(jcas);
    List<RetrievalResult> documents = null;
    try {
      documents = RetrievalResultArray.retrieveRetrievalResults(GerpViewManager.getView(jcas,
              ViewType.DOCUMENT_RANK));
    } catch (CASException e) {
      new AnalysisEngineProcessException(e);
    }
    // do task
    pruneDocuments(input.getQuestion(), keyterms, documents);
    // save output
    try {
      RetrievalResultArray
              .storeRetrievalResults(ViewManager.getDocumentView(jcas), documents, true);
    } catch (CASException e) {
      new AnalysisEngineProcessException(e);
    }
  }

  protected abstract void pruneDocuments(final String question, final List<Keyterm> keyterms,
          List<RetrievalResult> documents) throws AnalysisEngineProcessException;
}
