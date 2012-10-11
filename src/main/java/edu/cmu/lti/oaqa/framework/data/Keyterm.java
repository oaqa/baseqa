package edu.cmu.lti.oaqa.framework.data;

import java.io.Serializable;

import org.apache.uima.jcas.JCas;
import org.oaqa.model.QueryConcept;

import edu.cmu.lti.oaqa.framework.data.base.BaseAnnotationWrapper;


/**
 * TOKEN type refers to the original token terms, and phrases refer to the name entities identified
 * by NameEntity.
 * 
 * @author Zi Yang <ziy@cs.cmu.edu>
 * 
 */
public class Keyterm extends BaseAnnotationWrapper<QueryConcept> implements Serializable {

  private static final long serialVersionUID = 1L;

  private String text = null;

  public Keyterm(QueryConcept top) {
    super(top);
  }

  public Keyterm(String text) {
    this.text = text;
  }
  
  public String getText() {
    return text;
  }

  @Override
  public String toString() {
    return text;
  }

  @Override
  public QueryConcept unwrap(JCas jcas) {
    QueryConcept keyterm = new QueryConcept(jcas);
    keyterm.setText(getText());
    keyterm.setImplementingWrapper(getClass().getCanonicalName());
    return keyterm;
  }

  @Override
  public void wrap(QueryConcept top) {
    super.wrap(top);
    text = top.getText();
  }

}
