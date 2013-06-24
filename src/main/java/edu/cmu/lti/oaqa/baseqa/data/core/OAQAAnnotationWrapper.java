package edu.cmu.lti.oaqa.baseqa.data.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.core.OAQAAnnotation;

public abstract class OAQAAnnotationWrapper<T extends OAQAAnnotation> implements
        AnnotationWrapper<T> {

  protected final Class<? extends T> typeClass = getTypeClass();

  public abstract Class<? extends T> getTypeClass();

  protected String implementingWrapper = getClass().getCanonicalName();

  protected int begin;

  protected int end;

  @Override
  public T unwrap(JCas jcas) throws AnalysisEngineProcessException {
    try {
      Constructor<? extends T> c = typeClass.getConstructor(JCas.class);
      T annotation = c.newInstance(jcas);
      annotation.setImplementingWrapper(implementingWrapper);
      annotation.setBegin(begin);
      annotation.setEnd(end);
      return annotation;
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
  public void wrap(T annotation) throws AnalysisEngineProcessException {
    implementingWrapper = annotation.getImplementingWrapper();
    begin = annotation.getBegin();
    end = annotation.getEnd();
  }

  @SuppressWarnings("unchecked")
  public static <T extends OAQAAnnotation, W extends AnnotationWrapper<T>> W wrap(
          OAQAAnnotation annotation, Class<T> type, Class<W> wrapperClass)
          throws AnalysisEngineProcessException {
    Feature feature = annotation.getType().getFeatureByBaseName("implementingWrapper");
    String className = annotation.getFeatureValueAsString(feature);
    try {
      Class<? extends W> clazz = Class.forName(className).asSubclass(wrapperClass);
      W inst = clazz.newInstance();
      inst.wrap((T) annotation);
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

  public int getBegin() {
    return begin;
  }

  public void setBegin(int begin) {
    this.begin = begin;
  }

  public int getEnd() {
    return end;
  }

  public void setEnd(int end) {
    this.end = end;
  }
  
}
