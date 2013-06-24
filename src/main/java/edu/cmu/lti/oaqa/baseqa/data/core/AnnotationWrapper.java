package edu.cmu.lti.oaqa.baseqa.data.core;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

public interface AnnotationWrapper<T extends Annotation> {
  
  public T unwrap(JCas jcas) throws AnalysisEngineProcessException;

  public void wrap(T top) throws AnalysisEngineProcessException;
  
  public int getBegin();
  
  public int getEnd();

}