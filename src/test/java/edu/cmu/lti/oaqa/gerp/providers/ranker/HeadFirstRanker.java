package edu.cmu.lti.oaqa.gerp.providers.ranker;

import java.util.Collection;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;

import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.gerp.data.EvidenceWrapper;
import edu.cmu.lti.oaqa.gerp.data.RankWrapper;
import edu.cmu.lti.oaqa.gerp.providers.ranker.AbstractRanker;

public class HeadFirstRanker extends AbstractRanker {

  @Override
  public List<RankWrapper> rank(List<? extends Collection<EvidenceWrapper<?, ?>>> evidences)
          throws AnalysisEngineProcessException {
    List<RankWrapper> ranks = Lists.newArrayList();
    for (int i = 0; i < evidences.size(); i++) {
      ranks.add(new RankWrapper(i, (float) Math.exp(-i)));
    }
    return ranks;
  }

}
