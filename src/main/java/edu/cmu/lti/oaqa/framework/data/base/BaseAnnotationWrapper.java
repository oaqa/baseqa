package edu.cmu.lti.oaqa.framework.data.base;

import java.lang.reflect.Constructor;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.OAQATop;

public abstract class BaseAnnotationWrapper<T extends OAQATop> implements AnnotationWrapper<T> {

  protected String implementingWrapper;

  protected String componentId;

  protected float probablity;

  public BaseAnnotationWrapper() {
  }
  
  public BaseAnnotationWrapper(T top) {
    wrap(top);
  }

  @SuppressWarnings("unchecked")
  @Override
  public T unwrap(JCas jcas) {
    OAQATop top = new OAQATop(jcas);
    top.setImplementingWrapper(implementingWrapper);
    top.setComponentId(componentId);
    top.setProbability(probablity);
    return (T) top;
  }

  @Override
  public void wrap(T top) {
    implementingWrapper = top.getImplementingWrapper();
    componentId = top.getComponentId();
    probablity = top.getProbability();
  }

  public static <W extends AnnotationWrapper<?>> W wrap(OAQATop top, Class<W> wrapperClass)
          throws AnalysisEngineProcessException {
    Feature feature = top.getType().getFeatureByBaseName("implementingWrapper");
    String className = top.getFeatureValueAsString(feature);
    try {
      Class<? extends W> clazz = Class.forName(className).asSubclass(wrapperClass);
      Constructor<? extends W> c = clazz.getConstructor(wrapperClass);
      return c.newInstance(top);
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
