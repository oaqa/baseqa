package edu.cmu.lti.oaqa.gerp.core;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.TOP;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.core.data.TopWrapper;
import edu.cmu.lti.oaqa.core.data.WrapperHelper;
import edu.cmu.lti.oaqa.gerp.data.EvidenceWrapper;
import edu.cmu.lti.oaqa.gerp.data.Gerpable;
import edu.cmu.lti.oaqa.gerp.data.GerpableList;

public abstract class AbstractEvidencer<T extends TOP, W extends Gerpable & TopWrapper<T>> extends
        AbstractGerpSubPhase implements Evidencer<W> {

  public abstract List<Integer> getRequiredInputTypes();

  protected void log(String message) {
    super.log(GerpLogEntry.getEvidenceLog(gerpableClass), message);
  };

  @SuppressWarnings("unchecked")
  @Override
  public void process(JCas jcas) throws AnalysisEngineProcessException {
    super.process(jcas);
    // retrieve candidates
    GerpableList<T, W> gerpables = new GerpableList<T, W>();
    for (TopWrapper<?> gerpable : WrapperHelper.wrapAllFromJCas(indexer, jcas, gerpableType)) {
      gerpables.add((W) gerpable);
    }
    // retrieve inputs
    List<TopWrapper<? extends TOP>> inputs = Lists.newArrayList();
    for (int type : getRequiredInputTypes()) {
      inputs.add(Iterables.getOnlyElement(WrapperHelper.wrapAllFromJCas(indexer, jcas, type)));
    }
    List<EvidenceWrapper<?, ?>> evidences = evidence(gerpables.getGerpables(), inputs);
    gerpables.addAllEvidences(evidences);
    GerpPhaseUtils.removeAllTopsFromIndexesAndIndexer(jcas, indexer, gerpableType);
    for (Gerpable gerpable : gerpables.getGerpables()) {
      WrapperHelper.unwrap(indexer, (W) gerpable, jcas).addToIndexes(jcas);
    }
  }
}
