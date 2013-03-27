/**
 * 
 */
package edu.cmu.lti.oaqa.framework.data;

import java.util.List;

import org.apache.uima.jcas.JCas;

/**
 * @author sushant3d
 * 
 */
public interface RetrieveStoreInterface<T> {
  
  public abstract List<T> retrieveList(JCas jcas);
  public abstract void storeList(JCas jcas, List<T> elements);
}
