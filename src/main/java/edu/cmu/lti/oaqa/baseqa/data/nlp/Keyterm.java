package edu.cmu.lti.oaqa.baseqa.data.nlp;

import java.io.Serializable;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.oaqa.model.retrieval.QueryConcept;

import edu.cmu.lti.oaqa.core.data.OAQATopWrapper;

/**
 * TOKEN type refers to the original token terms, and phrases refer to the name entities identified
 * by NameEntity.
 * <p>
 * Legacy type wrapper for QueryConcept, used in phrases defined in basephase. In a GERP
 * environment, the candidates generates from generators will be stored in the same index without
 * any additional container.
 * 
 * @author Zi Yang <ziy@cs.cmu.edu>
 * 
 */
@Deprecated
public class Keyterm extends OAQATopWrapper<QueryConcept> implements Serializable {

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
  public void wrap(QueryConcept top) throws AnalysisEngineProcessException {
    super.wrap(top);
    text = top.getText();
  }

  @Override
  public void unwrap(QueryConcept top) throws AnalysisEngineProcessException {
    super.unwrap(top);
    top.setText(text);
  }

  @Override
  public Class<? extends QueryConcept> getTypeClass() {
    return QueryConcept.class;
  }

}
