package edu.cmu.lti.oaqa.gerp.providers.ranker;

import java.util.Collection;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;

import edu.cmu.lti.oaqa.gerp.data.EvidenceWrapper;
import edu.cmu.lti.oaqa.gerp.data.RankWrapper;

public interface Ranker {

  List<RankWrapper> rank(List<? extends Collection<EvidenceWrapper<?, ?>>> evidences)
          throws AnalysisEngineProcessException;

}
