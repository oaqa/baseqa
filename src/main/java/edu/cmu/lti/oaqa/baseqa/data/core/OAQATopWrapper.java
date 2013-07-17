package edu.cmu.lti.oaqa.baseqa.data.core;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.core.OAQATop;

public abstract class OAQATopWrapper<T extends OAQATop> implements TopWrapper<T>, Serializable {

  private static final long serialVersionUID = 1L;

  protected final Class<? extends T> typeClass = getTypeClass();

  protected String implementingWrapper = getClass().getCanonicalName();

  public abstract Class<? extends T> getTypeClass();

  public OAQATopWrapper() {
    super();
  }

  @SuppressWarnings("unchecked")
  @Override
  public T unwrap(JCas jcas) throws AnalysisEngineProcessException {
    WrapperIndexer indexer = WrapperIndexer.getWrapperIndexer(jcas);
    if (indexer.checkUnwrapped(this)) {
      return (T) indexer.getUnwrapped(this);
    }
    try {
      Constructor<? extends T> c = typeClass.getConstructor(JCas.class);
      T top = c.newInstance(jcas);
      indexer.addUnwrapped(this, top);
      top.setImplementingWrapper(implementingWrapper);
      return top;
    } catch (NoSuchMethodException e) {
      throw new AnalysisEngineProcessException(e);
    } catch (RuntimeException e) {
      throw new AnalysisEngineProcessException(e);
    } catch (InstantiationException e) {
      throw new AnalysisEngineProcessException(e);
    } catch (IllegalAccessException e) {
      throw new AnalysisEngineProcessException(e);
    } catch (InvocationTargetException e) {
      throw new AnalysisEngineProcessException(e);
    }
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
