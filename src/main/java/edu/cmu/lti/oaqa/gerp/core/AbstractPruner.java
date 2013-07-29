package edu.cmu.lti.oaqa.gerp.core;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.TOP;

import edu.cmu.lti.oaqa.core.data.TopWrapper;
import edu.cmu.lti.oaqa.core.data.WrapperHelper;
import edu.cmu.lti.oaqa.gerp.data.Gerpable;
import edu.cmu.lti.oaqa.gerp.data.GerpableList;
import edu.cmu.lti.oaqa.gerp.data.PruningDecisionWrapper;

public abstract class AbstractPruner extends AbstractGerpSubPhase implements Pruner {

  protected void log(String message) {
    super.log(GerpLogEntry.getPruneLog(gerpableClass), message);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  @Override
  public void process(JCas jcas) throws AnalysisEngineProcessException {
    super.process(jcas);
    GerpableList gerpables = new GerpableList();
    for (TopWrapper<?> gerpable : WrapperHelper.wrapAllFromJCas(jcas, gerpableType)) {
      gerpables.add((Gerpable) gerpable);
    }
    List<PruningDecisionWrapper> pruningDecisions = prune(gerpables.getGerpables());
    gerpables.addAllPruningDecisions(pruningDecisions);
    for (Object gerpable : gerpables.getGerpables()) {
      WrapperHelper.unwrap((TopWrapper<? extends TOP>) gerpable, jcas).addToIndexes(jcas);
    }
  }
}
