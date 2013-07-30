package edu.cmu.lti.oaqa.gerp.core;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.TOP;

import edu.cmu.lti.oaqa.core.data.TopWrapper;
import edu.cmu.lti.oaqa.core.data.WrapperHelper;
import edu.cmu.lti.oaqa.gerp.data.EvidenceWrapper;
import edu.cmu.lti.oaqa.gerp.data.Gerpable;
import edu.cmu.lti.oaqa.gerp.data.GerpableList;

public abstract class AbstractEvidencer<T extends TOP, W extends Gerpable & TopWrapper<T>> extends
        AbstractGerpSubPhase implements Evidencer<W> {

  protected void log(String message) {
    super.log(GerpLogEntry.getEvidenceLog(gerpableClass), message);
  };

  @SuppressWarnings("unchecked")
  @Override
  public void process(JCas jcas) throws AnalysisEngineProcessException {
    super.process(jcas);
    GerpableList<T, W> gerpables = new GerpableList<T, W>();
    for (TopWrapper<?> gerpable : WrapperHelper.wrapAllFromJCas(jcas, gerpableType)) {
      gerpables.add((W) gerpable);
    }
    GerpPhase.removeAllTops(jcas, gerpableType);
    List<EvidenceWrapper<?, ?>> evidences = evidence(gerpables.getGerpables());
    gerpables.addAllEvidences(evidences);
    for (Gerpable gerpable : gerpables.getGerpables()) {
      TOP top = WrapperHelper.unwrap((W) gerpable, jcas);
      top.addToIndexes(jcas);
    }
  }
}
