package edu.cmu.lti.oaqa.baseqa.data.core;

import org.apache.uima.jcas.cas.TOP;

@Deprecated
public interface ContainerWrapper<T extends TOP> {

  void add(TopWrapper<T> annotation) throws Exception;

  void clear();

  void complete();

}
