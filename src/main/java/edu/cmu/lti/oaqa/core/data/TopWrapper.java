package edu.cmu.lti.oaqa.core.data;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.cas.TOP;

public interface TopWrapper<T extends TOP> {

  Class<? extends T> getTypeClass();

  void unwrap(WrapperIndexer indexer, T top) throws AnalysisEngineProcessException;

  void wrap(WrapperIndexer indexer, T top) throws AnalysisEngineProcessException;

  String getImplementingWrapper();

  void setImplementingWrapper(String implementingWrapper);
}