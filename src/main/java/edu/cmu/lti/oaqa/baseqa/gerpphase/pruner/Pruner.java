package edu.cmu.lti.oaqa.baseqa.gerpphase.pruner;

import java.util.Collection;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;

import edu.cmu.lti.oaqa.baseqa.data.gerp.PruningDecisionWrapper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.RankWrapper;

public interface Pruner {

  PruningDecisionWrapper generate(Collection<? extends RankWrapper> ranks)
          throws AnalysisEngineProcessException;

}
