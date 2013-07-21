package edu.cmu.lti.oaqa.gerp.pruner;

import java.util.Collection;
import java.util.Random;

import edu.cmu.lti.oaqa.gerp.core.AbstractIndependentPrunerProvider;
import edu.cmu.lti.oaqa.gerp.data.PruningDecisionWrapper;
import edu.cmu.lti.oaqa.gerp.data.RankWrapper;

public class RandomPrunerProvider extends AbstractIndependentPrunerProvider {

  private static Random random = new Random();

  @Override
  protected PruningDecisionWrapper prune(Collection<? extends RankWrapper> rank) {
    return new PruningDecisionWrapper(random.nextBoolean());
  }

}
