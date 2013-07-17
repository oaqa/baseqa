package edu.cmu.lti.oaqa.baseqa.data.core;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.cas.TOP;

public interface TopWrapper<T extends TOP> {

  Class<? extends T> getTypeClass();

  void unwrap(T top) throws AnalysisEngineProcessException;

  void wrap(T top) throws AnalysisEngineProcessException;

  String getImplementingWrapper();

  void setImplementingWrapper(String implementingWrapper);
}