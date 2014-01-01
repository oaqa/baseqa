package edu.cmu.lti.oaqa.gerp.core;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.cas.TOP;

import edu.cmu.lti.oaqa.core.data.TopWrapper;
import edu.cmu.lti.oaqa.gerp.data.EvidenceWrapper;
import edu.cmu.lti.oaqa.gerp.data.Gerpable;

public interface Evidencer<W extends Gerpable> {

  List<EvidenceWrapper<?, ?>> evidence(List<W> gerpables,
          List<? extends TopWrapper<? extends TOP>> inputs) throws AnalysisEngineProcessException;

}
