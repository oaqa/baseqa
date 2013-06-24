package edu.cmu.lti.oaqa.baseqa.gerpphase.generator;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.ecd.config.ConfigurableProvider;

public abstract class AbstractCandidateGenerator extends ConfigurableProvider {

  public abstract void generateCandidates(JCas jcas) throws AnalysisEngineProcessException;

}
