package edu.cmu.lti.oaqa.baseqa.data.gerp;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.oaqa.model.gerp.GerpBase;

import edu.cmu.lti.oaqa.baseqa.data.core.OAQATopWrapper;

public abstract class GerpBaseWrapper<T extends GerpBase> extends OAQATopWrapper<T> {

  private static final long serialVersionUID = 1L;

  protected GerpBaseWrapper() {
    super();
  }

  @Override
  public void wrap(T top) throws AnalysisEngineProcessException {
    super.wrap(top);
    wrapComments(top);
  }

  @Override
  public void unwrap(T top) throws AnalysisEngineProcessException {
    super.unwrap(top);
    unwrapComments(top);
  }

  protected abstract void wrapComments(T top);

  protected abstract void unwrapComments(T top);

}
