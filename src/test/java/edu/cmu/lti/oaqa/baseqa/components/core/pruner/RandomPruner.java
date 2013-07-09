package edu.cmu.lti.oaqa.baseqa.components.core.pruner;

import java.util.Collection;
import java.util.Random;

import edu.cmu.lti.oaqa.baseqa.data.gerp.PruningDecisionWrapper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.RankWrapper;
import edu.cmu.lti.oaqa.baseqa.gerpphase.core.pruner.AbstractIndependentPruner;

public class RandomPruner extends AbstractIndependentPruner {

  private static Random random = new Random();

  @Override
  protected PruningDecisionWrapper prune(Collection<? extends RankWrapper> rank) {
    return new PruningDecisionWrapper(random.nextBoolean());
  }

}
