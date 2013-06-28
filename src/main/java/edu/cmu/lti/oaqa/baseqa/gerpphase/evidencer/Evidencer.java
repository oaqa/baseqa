package edu.cmu.lti.oaqa.baseqa.gerpphase.evidencer;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.oaqa.model.gerp.Evidence;

import edu.cmu.lti.oaqa.baseqa.data.gerp.Gerpable;

public interface Evidencer<W extends Gerpable> {

  Evidence evidence(W gerpable) throws AnalysisEngineProcessException;

}
