package edu.cmu.lti.oaqa.baseqa.gerpphase.core.evidencer;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;

import edu.cmu.lti.oaqa.baseqa.data.gerp.EvidenceWrapper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.Gerpable;

public interface Evidencer<W extends Gerpable> {

  EvidenceWrapper<?, ?> evidence(W gerpable) throws AnalysisEngineProcessException;

}
