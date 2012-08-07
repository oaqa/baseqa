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
public abstract class AbstractRetrievalStrategist extends AbstractComponent {

  protected abstract List<RetrievalResult> retrieveDocuments(String question, List<Keyterm> keyterms);

  @Override
  public final void process(JCas jcas) throws AnalysisEngineProcessException {
    super.process(jcas);
    try {
      InputElement input = ((InputElement) JCasHelper.getAnnotation(jcas, InputElement.type));
      List<Keyterm> keyterms = JCasHelper.getKeyterms(jcas);
      // System.out.println("Retrieving Docs for Question: " + input.getSequenceId());
      List<RetrievalResult> documents = retrieveDocuments(input.getQuestion(), keyterms);
      // CasKey key = new TopicBasedCasKey(jcas);
      // StatsEngine.report(key, BaseQAStats.DOCUMENTS_RETRIEVED, documents.size());
      JCas documentView = ViewManager.getDocumentView(jcas);
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
