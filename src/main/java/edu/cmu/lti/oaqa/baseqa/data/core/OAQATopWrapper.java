package edu.cmu.lti.oaqa.baseqa.data.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.core.OAQATop;

public abstract class OAQATopWrapper<T extends OAQATop> implements TopWrapper<T> {

  protected final Class<? extends T> typeClass = getTypeClass();

  protected String implementingWrapper = getClass().getCanonicalName();

  public abstract Class<? extends T> getTypeClass();

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

  @SuppressWarnings("unchecked")
  public static <T extends OAQATop, W extends TopWrapper<T>> W wrap(OAQATop top, Class<T> type,
          Class<W> wrapperClass) throws AnalysisEngineProcessException {
    Feature feature = top.getType().getFeatureByBaseName("implementingWrapper");
    String className = top.getFeatureValueAsString(feature);
    try {
      Class<? extends W> clazz = Class.forName(className).asSubclass(wrapperClass);
      W inst = clazz.newInstance();
      inst.wrap((T) top);
      return inst;
    } catch (Exception e) {
      throw new AnalysisEngineProcessException(e);
    }
  }

  public String getImplementingWrapper() {
    return implementingWrapper;
  }

  public void setImplementingWrapper(String implementingWrapper) {
    this.implementingWrapper = implementingWrapper;
  }

}
