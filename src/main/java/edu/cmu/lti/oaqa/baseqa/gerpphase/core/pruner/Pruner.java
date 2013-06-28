package edu.cmu.lti.oaqa.baseqa.gerpphase.core.pruner;

import java.util.Collection;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;

import edu.cmu.lti.oaqa.baseqa.data.gerp.PruningDecisionWrapper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.RankWrapper;

public interface Pruner {

  PruningDecisionWrapper prune(Collection<? extends RankWrapper> ranks)
          throws AnalysisEngineProcessException;

}
