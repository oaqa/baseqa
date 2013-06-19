package edu.cmu.lti.oaqa.cse.basephase.gerp.ranker;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.ecd.config.ConfigurableProvider;

public abstract class AbstractCandidateRanker extends ConfigurableProvider {

  public abstract void rankCandidates(JCas jcas) throws AnalysisEngineProcessException;

}
