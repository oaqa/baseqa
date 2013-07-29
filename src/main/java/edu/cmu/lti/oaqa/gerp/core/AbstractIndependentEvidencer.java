package edu.cmu.lti.oaqa.gerp.core;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.cas.TOP;

import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.core.data.TopWrapper;
import edu.cmu.lti.oaqa.gerp.data.EvidenceWrapper;
import edu.cmu.lti.oaqa.gerp.data.Gerpable;

public abstract class AbstractIndependentEvidencer<T extends TOP, W extends Gerpable & TopWrapper<T>>
        extends AbstractEvidencer<T, W> {

  protected abstract EvidenceWrapper<?, ?> evidence(W gerpable);

  @Override
  public List<EvidenceWrapper<?, ?>> evidence(List<W> gerpables)
          throws AnalysisEngineProcessException {
    List<EvidenceWrapper<?, ?>> evidences = Lists.newArrayList();
    for (W gerpable : gerpables) {
      evidences.add(evidence(gerpable));
    }
    return evidences;
  }
}
