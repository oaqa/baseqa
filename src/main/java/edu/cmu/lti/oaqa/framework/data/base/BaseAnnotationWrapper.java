package edu.cmu.lti.oaqa.framework.data.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.OAQATop;

public abstract class BaseAnnotationWrapper<T extends OAQATop> implements AnnotationWrapper<T>,
        Comparable<BaseAnnotationWrapper<T>> {

  protected final Class<? extends T> typeClass = getTypeClass();

  protected String implementingWrapper = getClass().getCanonicalName();

  protected String componentId;

  protected float probability;

  public abstract Class<? extends T> getTypeClass();

  @Override
  public T unwrap(JCas jcas) throws AnalysisEngineProcessException {
    try {
      Constructor<? extends T> c = typeClass.getConstructor(JCas.class);
      T top = c.newInstance(jcas);
      top.setImplementingWrapper(implementingWrapper);
      top.setComponentId(componentId);
      top.setProbability(probability);
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
  public void wrap(T top) {
    implementingWrapper = top.getImplementingWrapper();
    componentId = top.getComponentId();
    probability = top.getProbability();
  }

  @SuppressWarnings("unchecked")
  public static <T extends OAQATop, W extends AnnotationWrapper<T>> W wrap(OAQATop top,
          Class<T> type, Class<W> wrapperClass) throws AnalysisEngineProcessException {
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

  @Override
  public int compareTo(BaseAnnotationWrapper<T> w) {
    if (probability != w.probability) {
      return probability > w.probability ? 1 : -1;
    }
    return 0;
  }

  public String getImplementingWrapper() {
    return implementingWrapper;
  }

  public void setImplementingWrapper(String implementingWrapper) {
    this.implementingWrapper = implementingWrapper;
  }

  public String getComponentId() {
    return componentId;
  }

  public void setComponentId(String componentId) {
    this.componentId = componentId;
  }

  public float getProbability() {
    return probability;
  }

  public void setProbablity(float probablity) {
    this.probability = probablity;
  }

}
