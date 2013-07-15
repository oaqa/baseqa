package edu.cmu.lti.oaqa.baseqa.test;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.framework.collection.adhoc.SyncCasProcessedCallbackListener;

public class JCasReturnCallbackListener extends SyncCasProcessedCallbackListener {

  private JCas jcas;

  @Override
  public void entityProcessComplete(CAS aCas) {
    try {
      jcas = aCas.getJCas();
      latch.countDown();
    } catch (CASException e) {
      e.printStackTrace();
    }
  }

  public JCas getJCas() {
    return jcas;
  }

  public void setJCas(JCas jcas) {
    this.jcas = jcas;
  }

}