package edu.cmu.lti.oaqa.cse.basephase.gerp.generator;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.framework.BaseJCasHelper;
import edu.cmu.lti.oaqa.framework.data.Keyterm;
import edu.cmu.lti.oaqa.framework.data.KeytermList;
import edu.cmu.lti.oaqa.framework.types.InputElement;

public abstract class AbstractKeytermGenerator extends AbstractCandidateGenerator {

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
