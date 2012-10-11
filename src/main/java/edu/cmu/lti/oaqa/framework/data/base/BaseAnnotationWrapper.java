package edu.cmu.lti.oaqa.framework.data.base;

import java.lang.reflect.Constructor;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.OAQATop;

public abstract class BaseAnnotationWrapper<T extends OAQATop> implements AnnotationWrapper<T> {

  protected final Class<? extends T> typeClass = getType();

  protected String implementingWrapper = getClass().getCanonicalName();

  protected String componentId;

  protected float probablity;

  public abstract Class<? extends T> getType();

  @Override
  public T unwrap(JCas jcas) throws Exception {
    Constructor<? extends T> c = typeClass.getConstructor(JCas.class);
    T top = c.newInstance(jcas);
    top.setImplementingWrapper(implementingWrapper);
    top.setComponentId(componentId);
    top.setProbability(probablity);
    return top;
  }

  @Override
  public void wrap(T top) {
    implementingWrapper = top.getImplementingWrapper();
    componentId = top.getComponentId();
    probablity = top.getProbability();
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

  public float getProbablity() {
    return probablity;
  }

  public void setProbablity(float probablity) {
    this.probablity = probablity;
  }

}
