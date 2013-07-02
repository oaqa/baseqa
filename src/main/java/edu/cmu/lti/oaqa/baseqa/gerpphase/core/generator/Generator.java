package edu.cmu.lti.oaqa.baseqa.gerpphase.core.generator;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.cas.TOP;

import edu.cmu.lti.oaqa.baseqa.data.core.TopWrapper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.Gerpable;

public interface Generator<W extends Gerpable> {

  W generate(List<? extends TopWrapper<? extends TOP>> input) throws AnalysisEngineProcessException;

}
