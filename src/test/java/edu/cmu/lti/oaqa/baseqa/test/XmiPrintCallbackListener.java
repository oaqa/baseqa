package edu.cmu.lti.oaqa.baseqa.test;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;

import edu.cmu.lti.oaqa.framework.collection.adhoc.CasProcessedCallback;
import edu.cmu.lti.oaqa.gerp.core.GerpPhaseUtils;

public class XmiPrintCallbackListener implements CasProcessedCallback {

  protected final Object lock = new Object();

  @Override
  public void entityProcessComplete(CAS aCas) {
    try {
      GerpPhaseUtils.printCas(aCas.getJCas());
    } catch (CASException e) {
      e.printStackTrace();
    }
  }

  protected void await() throws InterruptedException {
    synchronized (lock) {
      lock.wait();
    }
  }

  @Override
  public void collectionProcessComplete() {
    synchronized (lock) {
      lock.notify();
    }
  }

}