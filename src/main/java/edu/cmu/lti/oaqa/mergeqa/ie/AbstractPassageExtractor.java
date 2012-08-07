package edu.cmu.lti.oaqa.mergeqa.ie;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CASException;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.framework.JCasHelper;
import edu.cmu.lti.oaqa.framework.QALogEntry;
import edu.cmu.lti.oaqa.framework.ViewManager;
import edu.cmu.lti.oaqa.framework.data.Keyterm;
import edu.cmu.lti.oaqa.framework.data.PassageCandidate;
import edu.cmu.lti.oaqa.framework.data.RetrievalResult;
import edu.cmu.lti.oaqa.framework.types.InputElement;
import edu.cmu.lti.oaqa.mergeqa.AbstractComponent;

/**
 * 
 * @author Zi Yang <ziy@cs.cmu.edu>
 * 
 */
public abstract class AbstractPassageExtractor extends AbstractComponent {

  protected abstract List<PassageCandidate> extractPassages(String question,
          List<Keyterm> keyterms, List<RetrievalResult> documents);

  @Override
  public final void process(JCas jcas) throws AnalysisEngineProcessException {
    super.process(jcas);
    try {
      String questionText = ((InputElement) JCasHelper.getAnnotation(jcas, InputElement.type))
              .getQuestion();
      List<Keyterm> keyterms = JCasHelper.getKeyterms(jcas);
      JCas documentView = ViewManager.getDocumentView(jcas);
      List<RetrievalResult> documents = JCasHelper.getDocuments(documentView);
      List<PassageCandidate> answers = extractPassages(questionText, keyterms, documents);
      JCas candidateView = ViewManager.getCandidateView(jcas);
      JCasHelper.storePassages(candidateView, answers);
      log("ANSWER PASSAGES: " + answers.size());
    } catch (CASException e) {
      throw new AnalysisEngineProcessException(e);
    }
  }

  protected final void log(String message) {
    super.log(QALogEntry.INFORMATION_EXTRACTION, message);
  }

}
