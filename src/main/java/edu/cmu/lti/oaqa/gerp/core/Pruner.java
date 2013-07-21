package edu.cmu.lti.oaqa.gerp.core;

import java.util.Collection;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;

import edu.cmu.lti.oaqa.gerp.data.PruningDecisionWrapper;
import edu.cmu.lti.oaqa.gerp.data.RankWrapper;

public interface Pruner {

  List<PruningDecisionWrapper> prune(List<? extends Collection<? extends RankWrapper>> ranks)
          throws AnalysisEngineProcessException;

}
