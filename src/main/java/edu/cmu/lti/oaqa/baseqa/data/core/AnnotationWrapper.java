package edu.cmu.lti.oaqa.baseqa.data.core;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

public interface AnnotationWrapper<T extends Annotation> extends TopWrapper<T> {

  Class<? extends T> getTypeClass();
  
  T unwrapIfNotUnwrapped(JCas jcas) throws AnalysisEngineProcessException;
  
  T unwrap(JCas jcas) throws AnalysisEngineProcessException;

  void wrap(T annotation) throws AnalysisEngineProcessException;

  int getBegin();

  int getEnd();

}