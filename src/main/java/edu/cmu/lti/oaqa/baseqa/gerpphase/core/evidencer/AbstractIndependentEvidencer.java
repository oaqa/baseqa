package edu.cmu.lti.oaqa.baseqa.gerpphase.core.evidencer;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;

import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.data.gerp.EvidenceWrapper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.Gerpable;

public abstract class AbstractIndependentEvidencer<W extends Gerpable> extends AbstractEvidencer<W> {

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
