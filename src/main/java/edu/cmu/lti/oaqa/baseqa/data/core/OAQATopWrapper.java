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

  @Override
  public T unwrap(JCas jcas) throws AnalysisEngineProcessException {
    try {
      Constructor<? extends T> c = typeClass.getConstructor(JCas.class);
      T top = c.newInstance(jcas);
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

  public String getImplementingWrapper() {
    return implementingWrapper;
  }

  public void setImplementingWrapper(String implementingWrapper) {
    this.implementingWrapper = implementingWrapper;
  }

}
