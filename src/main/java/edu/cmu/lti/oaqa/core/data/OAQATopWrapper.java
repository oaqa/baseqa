package edu.cmu.lti.oaqa.core.data;

import java.io.Serializable;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.oaqa.model.core.OAQATop;

public abstract class OAQATopWrapper<T extends OAQATop> implements TopWrapper<T>, Serializable {

  private static final long serialVersionUID = 1L;

  protected final Class<? extends T> typeClass = getTypeClass();

  protected String implementingWrapper = getClass().getCanonicalName();

  public abstract Class<? extends T> getTypeClass();

  public OAQATopWrapper() {
    super();
  }

  @Override
  public void unwrap(T top) throws AnalysisEngineProcessException {
    top.setImplementingWrapper(implementingWrapper);
  }

  @Override
  public void wrap(T top) throws AnalysisEngineProcessException {
    implementingWrapper = top.getImplementingWrapper();
  }

  @Override
  public String getImplementingWrapper() {
    return implementingWrapper;
  }

  @Override
  public void setImplementingWrapper(String implementingWrapper) {
    this.implementingWrapper = implementingWrapper;
  }

}
