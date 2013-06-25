package edu.cmu.lti.oaqa.baseqa.data.core;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.TOP;

public interface TopWrapper<T extends TOP> {

  Class<? extends T> getTypeClass();

  T unwrap(JCas jcas) throws AnalysisEngineProcessException;

  void wrap(T top) throws AnalysisEngineProcessException;

}