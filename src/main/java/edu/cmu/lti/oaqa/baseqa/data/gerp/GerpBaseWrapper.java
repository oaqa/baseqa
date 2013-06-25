package edu.cmu.lti.oaqa.baseqa.data.gerp;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSList;
import org.oaqa.model.gerp.GerpBase;

import edu.cmu.lti.oaqa.baseqa.data.core.OAQATopWrapper;

public abstract class GerpBaseWrapper<T extends GerpBase> extends OAQATopWrapper<T> {

  private static final long serialVersionUID = 1L;

  protected GerpBaseWrapper() {
    super();
  }

  @Override
  public void wrap(T top) throws AnalysisEngineProcessException {
    super.wrap(top);
    wrapComments(top);
  }

  @Override
  public T unwrap(JCas jcas) throws AnalysisEngineProcessException {
    T top = super.unwrap(jcas);
    FSList list = unwrapComments(jcas);
    if (list != null) {
      top.setComments(list);
    }
    return top;
  }

  protected abstract void wrapComments(T top);

  protected abstract FSList unwrapComments(JCas jcas);

}
