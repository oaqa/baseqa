package edu.cmu.lti.oaqa.cse.basephase.gerp.pruner;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.ecd.config.ConfigurableProvider;

public abstract class AbstractCandidatePruner extends ConfigurableProvider {

  public abstract void pruneCandidates(JCas jcas) throws AnalysisEngineProcessException;

}
