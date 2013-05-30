package edu.cmu.lti.oaqa.framework.data;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.QueryConcept;

import edu.cmu.lti.oaqa.framework.data.base.BaseAnnotationWrapper;

public class PlaceHolder extends BaseAnnotationWrapper<QueryConcept> {


	  private static final long serialVersionUID = 1L;

	  protected String text = null;

	  public PlaceHolder() {
	    super();
	  }

	  public PlaceHolder(String text) {
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
	  public QueryConcept unwrap(JCas jcas) throws AnalysisEngineProcessException {
	    QueryConcept keyterm = super.unwrap(jcas);
	    keyterm.setText(text);
	    return keyterm;
	  }

	  @Override
	  public Class<? extends QueryConcept> getTypeClass() {
	    return QueryConcept.class;
	  }

}
