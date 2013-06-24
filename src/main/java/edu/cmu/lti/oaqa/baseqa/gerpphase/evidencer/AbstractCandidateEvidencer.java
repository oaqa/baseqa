package edu.cmu.lti.oaqa.baseqa.gerpphase.evidencer;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.ecd.config.ConfigurableProvider;

public abstract class AbstractCandidateEvidencer extends ConfigurableProvider {

  public abstract void evidenceCandidates(JCas jcas) throws AnalysisEngineProcessException;

}
