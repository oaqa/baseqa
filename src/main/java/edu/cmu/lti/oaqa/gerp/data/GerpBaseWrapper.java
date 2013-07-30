package edu.cmu.lti.oaqa.gerp.data;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.oaqa.model.gerp.GerpBase;

import edu.cmu.lti.oaqa.core.data.OAQATopWrapper;
import edu.cmu.lti.oaqa.core.data.WrapperIndexer;

public abstract class GerpBaseWrapper<T extends GerpBase> extends OAQATopWrapper<T> {

  private static final long serialVersionUID = 1L;

  protected GerpBaseWrapper() {
    super();
  }

  @Override
  public void wrap(WrapperIndexer indexer, T top) throws AnalysisEngineProcessException {
    super.wrap(indexer, top);
    wrapComments(indexer, top);
  }

  @Override
  public void unwrap(WrapperIndexer indexer, T top) throws AnalysisEngineProcessException {
    super.unwrap(indexer, top);
    unwrapComments(indexer, top);
  }

  protected abstract void wrapComments(WrapperIndexer indexer, T top);

  protected abstract void unwrapComments(WrapperIndexer indexer, T top);

}
