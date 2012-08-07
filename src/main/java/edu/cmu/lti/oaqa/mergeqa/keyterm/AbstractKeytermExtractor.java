package edu.cmu.lti.oaqa.mergeqa.keyterm;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.framework.JCasHelper;
import edu.cmu.lti.oaqa.framework.QALogEntry;
import edu.cmu.lti.oaqa.framework.data.Keyterm;
import edu.cmu.lti.oaqa.framework.types.InputElement;
import edu.cmu.lti.oaqa.mergeqa.AbstractComponent;

/**
 * 
 * @author Zi Yang <ziy@cs.cmu.edu>
 * 
 */
public abstract class AbstractKeytermExtractor extends AbstractComponent {

  protected abstract List<Keyterm> getKeyterms(String question);

  @Deprecated
  protected List<Keyterm> getKeyterms(String question, int topicId) {
    return getKeyterms(question);
  }

  @Override
  public final void process(JCas jcas) throws AnalysisEngineProcessException {
    super.process(jcas);
    InputElement input = (InputElement) JCasHelper.getAnnotation(jcas, InputElement.type);
    String question = input.getQuestion();
    int sequenceId = input.getSequenceId();
    List<Keyterm> keyterms = getKeyterms(question, sequenceId);
    JCasHelper.storeKeyterms(jcas, keyterms);
    log(keyterms.toString());
  }

  protected final void log(String message) {
    super.log(QALogEntry.KEYTERM, message);
  }
}
