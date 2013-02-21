package edu.cmu.lti.oaqa.framework.data;

import java.io.Serializable;

import org.apache.uima.jcas.JCas;
import org.oaqa.model.QueryConcept;

import edu.cmu.lti.oaqa.framework.data.base.BaseAnnotationWrapper;

/**
 * 
 * @author Zi Yang <ziy@cs.cmu.edu>
 * @author Leonid Boytsov <srchvrs@cmu.edu>
 * 
 */

public class QueryConceptWrapper extends BaseAnnotationWrapper<QueryConcept> implements Serializable {  
  
  private static final long serialVersionUID = 1L;

  protected String text = null;
  protected String type = null;

  public QueryConceptWrapper() {
    super();
  }
  
  public QueryConceptWrapper(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }
  
  public String getType() {
    return type;
  }  

  @Override
  public String toString() {
    return text;
  }

  @Override
  public void wrap(QueryConcept top) {
    super.wrap(top);
    text = top.getText();
    type = top.getConceptType();
  }

  @Override
  public QueryConcept unwrap(JCas jcas) throws Exception {
    QueryConcept concept = super.unwrap(jcas);
    concept.setText(text);
    concept.setConceptType(type);
    return concept;
  }

  @Override
  public Class<? extends QueryConcept> getTypeClass() {
    return QueryConcept.class;
  }

}
