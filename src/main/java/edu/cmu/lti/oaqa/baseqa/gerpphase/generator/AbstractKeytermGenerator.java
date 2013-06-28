package edu.cmu.lti.oaqa.baseqa.gerpphase.generator;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.baseqa.data.nlp.Keyterm;
import edu.cmu.lti.oaqa.baseqa.data.nlp.KeytermList;
import edu.cmu.lti.oaqa.baseqa.gerpphase.core.generator.AbstractGenerator;
import edu.cmu.lti.oaqa.framework.BaseJCasHelper;
import edu.cmu.lti.oaqa.framework.types.InputElement;

public abstract class AbstractKeytermGenerator extends AbstractGenerator {

  @Override
  public void generateCandidates(JCas jcas) throws AnalysisEngineProcessException {
    // prepare input
    final String question = ((InputElement) BaseJCasHelper.getAnnotation(jcas, InputElement.type))
            .getQuestion();
    // do task
    List<Keyterm> keyterms = generateKeyterms(question);
    // save output
    KeytermList.storeKeyterms(jcas, keyterms, false);
  }

  protected abstract List<Keyterm> generateKeyterms(final String question)
          throws AnalysisEngineProcessException;
}
