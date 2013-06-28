package edu.cmu.lti.oaqa.baseqa.gerpphase.core.generator;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.baseqa.data.gerp.Gerpable;
import edu.cmu.lti.oaqa.ecd.config.ConfigurableProvider;

public abstract class AbstractGenerator<W extends Gerpable> extends ConfigurableProvider implements
        Generator<W> {

  protected abstract Gerpable[] collectInputs(JCas jcas);

  protected abstract void persistNewGerpable(W output, JCas jcas);

  public void process(JCas jcas) throws AnalysisEngineProcessException {
    Gerpable[] inputs = collectInputs(jcas);
    W output = generate(inputs);
    persistNewGerpable(output, jcas);
  }

}
