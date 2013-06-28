package edu.cmu.lti.oaqa.baseqa.gerpphase.core.evidencer;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.baseqa.data.gerp.EvidenceWrapper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.Gerpable;
import edu.cmu.lti.oaqa.ecd.config.ConfigurableProvider;

public abstract class AbstractEvidencer<W extends Gerpable> extends ConfigurableProvider implements
        Evidencer<W> {

  protected abstract W retrieveGerpable(JCas jcas);

  protected abstract void persistEvidence(EvidenceWrapper<?, ?> evidence, JCas jcas);

  public void process(JCas jcas) throws AnalysisEngineProcessException {
    W gerpable = retrieveGerpable(jcas);
    EvidenceWrapper<?, ?> evidence = evidence(gerpable);
    persistEvidence(evidence, jcas);
  }

}
