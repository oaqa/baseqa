package edu.cmu.lti.oaqa.core.data;

import org.apache.uima.jcas.cas.TOP;

@Deprecated
public interface ContainerWrapper<T extends TOP> {

  void add(WrapperIndexer indexer, TopWrapper<T> annotation) throws Exception;

  void clear();

  void complete();

}
