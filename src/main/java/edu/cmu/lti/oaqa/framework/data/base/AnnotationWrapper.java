package edu.cmu.lti.oaqa.framework.data.base;

import org.apache.uima.jcas.JCas;
import org.oaqa.model.OAQATop;

public interface AnnotationWrapper<T extends OAQATop> {

  public abstract T unwrap(JCas jcas);

  public abstract void wrap(T top);

}