package edu.cmu.lti.oaqa.gerp.providers.ranker;

import java.util.Collection;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;

import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.gerp.data.EvidenceWrapper;
import edu.cmu.lti.oaqa.gerp.data.RankWrapper;

public abstract class AbstractIndependentRanker extends AbstractRanker {

  protected abstract RankWrapper rank(Collection<EvidenceWrapper<?, ?>> evidence);

  @Override
  public List<RankWrapper> rank(List<? extends Collection<EvidenceWrapper<?, ?>>> evidences)
          throws AnalysisEngineProcessException {
    List<RankWrapper> ranks = Lists.newArrayList();
    for (Collection<EvidenceWrapper<?, ?>> evidence : evidences) {
      ranks.add(rank(evidence));
    }
    return null;
  }
}
