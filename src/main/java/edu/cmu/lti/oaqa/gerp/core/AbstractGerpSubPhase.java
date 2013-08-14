package edu.cmu.lti.oaqa.gerp.core;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.TOP;
import org.oaqa.model.gerp.GerpMeta;

import com.google.common.collect.Iterables;

import edu.cmu.lti.oaqa.core.data.TopWrapper;
import edu.cmu.lti.oaqa.core.data.WrapperHelper;
import edu.cmu.lti.oaqa.core.data.WrapperIndexer;
import edu.cmu.lti.oaqa.ecd.log.AbstractLoggedComponent;
import edu.cmu.lti.oaqa.gerp.data.GerpMetaWrapper;

public class AbstractGerpSubPhase extends AbstractLoggedComponent {

  protected Class<? extends TOP> gerpableClass;

  protected int gerpableType;

  protected WrapperIndexer indexer = new WrapperIndexer();

  @Override
  public void process(JCas jcas) throws AnalysisEngineProcessException {
    super.process(jcas);
    TopWrapper<TOP> wrapper = Iterables.getOnlyElement(WrapperHelper.wrapAllFromJCas(indexer, jcas,
            GerpMeta.type));
    GerpMetaWrapper gerpMeta = (GerpMetaWrapper) (TopWrapper<?>) wrapper;
    try {
      gerpableClass = Class.forName(gerpMeta.getGerpableClassName()).asSubclass(TOP.class);
      gerpableType = (Integer) gerpableClass.getDeclaredField("type").get(null);
    } catch (Exception e) {
      throw new AnalysisEngineProcessException(e);
    }
  }
}
