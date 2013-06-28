package edu.cmu.lti.oaqa.baseqa.gerpphase.core.ranker;

import java.util.Collection;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.baseqa.data.gerp.EvidenceWrapper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.RankWrapper;
import edu.cmu.lti.oaqa.ecd.config.ConfigurableProvider;

public abstract class AbstractRanker extends ConfigurableProvider implements Ranker {

  protected abstract Collection<? extends EvidenceWrapper<?, ?>> collectEvidences(JCas jcas);

  protected abstract void persistRank(RankWrapper output, JCas jcas);

  public void process(JCas jcas) throws AnalysisEngineProcessException {
    Collection<? extends EvidenceWrapper<?, ?>> evidences = collectEvidences(jcas);
    RankWrapper rank = rank(evidences);
    persistRank(rank, jcas);
  }
}
