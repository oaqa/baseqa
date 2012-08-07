package edu.cmu.lti.oaqa.mergeqa.retrieval;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.framework.JCasHelper;
import edu.cmu.lti.oaqa.framework.QALogEntry;
import edu.cmu.lti.oaqa.framework.ViewManager;
import edu.cmu.lti.oaqa.framework.data.Keyterm;
import edu.cmu.lti.oaqa.framework.data.RetrievalResult;
import edu.cmu.lti.oaqa.framework.types.InputElement;
import edu.cmu.lti.oaqa.mergeqa.AbstractComponent;

/**
 * 
 * @author Zi Yang <ziy@cs.cmu.edu>
 * 
 */
public abstract class AbstractRetrievalUpdater extends AbstractComponent {

  protected abstract List<RetrievalResult> updateDocuments(String question, List<Keyterm> keyterms,
          List<RetrievalResult> documents);

  @Override
  public final void process(JCas jcas) throws AnalysisEngineProcessException {
    super.process(jcas);
    try {
      InputElement input = ((InputElement) JCasHelper.getAnnotation(jcas, InputElement.type));
      List<Keyterm> keyterms = JCasHelper.getKeyterms(jcas);
      System.out.println("Retrieving Docs for Question: " + input.getSequenceId());
      JCas documentView = ViewManager.getDocumentView(jcas);
      List<RetrievalResult> documents = JCasHelper.getDocuments(documentView);
      documents = updateDocuments(input.getQuestion(), keyterms, documents);
      JCasHelper.storeDocuments(documentView, documents);
      log("RETRIEVED: " + documents.size());
    } catch (Exception e) {
      throw new AnalysisEngineProcessException(e);
    }
  }

  protected final void log(String message) {
    super.log(QALogEntry.RETRIEVAL, message);
  }
  
}
