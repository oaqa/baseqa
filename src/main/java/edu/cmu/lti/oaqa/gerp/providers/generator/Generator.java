package edu.cmu.lti.oaqa.gerp.providers.generator;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.cas.TOP;

import edu.cmu.lti.oaqa.core.data.TopWrapper;
import edu.cmu.lti.oaqa.gerp.data.Gerpable;

public interface Generator<W extends Gerpable> {

  W generate(List<? extends TopWrapper<? extends TOP>> input) throws AnalysisEngineProcessException;

}
