package edu.cmu.lti.oaqa.baseqa.gerpphase.core.pruner;

import java.util.Collection;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.baseqa.data.gerp.PruningDecisionWrapper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.RankWrapper;
import edu.cmu.lti.oaqa.ecd.config.ConfigurableProvider;

public abstract class AbstractPruner extends ConfigurableProvider implements Pruner {

  protected abstract Collection<? extends RankWrapper> collectRanks(JCas jcas);

  protected abstract void persistPruningDecision(PruningDecisionWrapper pruningDecision, JCas jcas);

  public void process(JCas jcas) throws AnalysisEngineProcessException {
    Collection<? extends RankWrapper> ranks = collectRanks(jcas);
    PruningDecisionWrapper pruningDecision = prune(ranks);
    persistPruningDecision(pruningDecision, jcas);
  }

}
