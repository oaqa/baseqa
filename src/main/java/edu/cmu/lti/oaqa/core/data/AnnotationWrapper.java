package edu.cmu.lti.oaqa.core.data;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.tcas.Annotation;

public interface AnnotationWrapper<T extends Annotation> extends TopWrapper<T> {

  Class<? extends T> getTypeClass();

  void unwrap(T annotation) throws AnalysisEngineProcessException;

  void wrap(T annotation) throws AnalysisEngineProcessException;

  int getBegin();

  int getEnd();

  String getImplementingWrapper();

  void setImplementingWrapper(String implementingWrapper);

}