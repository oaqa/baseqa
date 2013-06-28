package edu.cmu.lti.oaqa.baseqa.gerpphase.ranker;

import java.util.Collection;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;

import edu.cmu.lti.oaqa.baseqa.data.gerp.EvidenceWrapper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.RankWrapper;

public interface Ranker {

  RankWrapper generate(Collection<? extends EvidenceWrapper<?, ?>> evidences)
          throws AnalysisEngineProcessException;

}
