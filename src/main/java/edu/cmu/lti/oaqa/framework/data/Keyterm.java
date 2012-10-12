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

  protected String text = null;

  public Keyterm() {
    super();
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
  public void wrap(QueryConcept top) {
    super.wrap(top);
    text = top.getText();
  }

  @Override
  public QueryConcept unwrap(JCas jcas) throws Exception {
    QueryConcept keyterm = super.unwrap(jcas);
    keyterm.setText(text);
    return keyterm;
  }

  @Override
  public Class<? extends QueryConcept> getTypeClass() {
    return QueryConcept.class;
  }

}
