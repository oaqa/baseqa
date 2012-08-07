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
public abstract class AbstractKeytermUpdater extends AbstractComponent {

  protected abstract List<Keyterm> updateKeyterms(String question, List<Keyterm> keyterms);

  @Override
  public final void process(JCas jcas) throws AnalysisEngineProcessException {
    super.process(jcas);
    String question = ((InputElement) JCasHelper.getAnnotation(jcas, InputElement.type))
            .getQuestion();
    List<Keyterm> keyterms = JCasHelper.getKeyterms(jcas);
    keyterms = updateKeyterms(question, keyterms);
    JCasHelper.storeKeyterms(jcas, keyterms);
    log(keyterms.toString());
  }

  protected final void log(String message) {
    super.log(QALogEntry.KEYTERM, message);
  }

}
