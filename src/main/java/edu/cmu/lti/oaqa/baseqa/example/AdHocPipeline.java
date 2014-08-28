package edu.cmu.lti.oaqa.baseqa.example;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.uima.cas.CAS;
import org.apache.uima.fit.factory.TypeSystemDescriptionFactory;
import org.apache.uima.fit.util.CasIOUtil;
import org.apache.uima.resource.metadata.TypeSystemDescription;

import edu.cmu.lti.oaqa.cse.driver.AdHocDriver;
import edu.cmu.lti.oaqa.ecd.BaseExperimentBuilder;
import edu.cmu.lti.oaqa.ecd.ExperimentBuilder;
import edu.cmu.lti.oaqa.framework.DataElement;
import edu.cmu.lti.oaqa.framework.collection.adhoc.AdHocCollectionReader;
import edu.cmu.lti.oaqa.framework.collection.adhoc.AdHocSource;
import edu.cmu.lti.oaqa.framework.collection.adhoc.BaseAdHocSource;
import edu.cmu.lti.oaqa.framework.collection.adhoc.CasProcessedCallback;

public class AdHocPipeline {

  public static void main(String[] args) throws Exception {
    runPipeline(args[0], args[1], args[2], args[3], args[4]);
  }

  public static void runPipeline(String pipelinePath, String datasetName, String sequenceId,
          String question, String outputXmiPath) throws Exception {
    String uuid = UUID.randomUUID().toString();
    TypeSystemDescription typeSystem = TypeSystemDescriptionFactory.createTypeSystemDescription();
    ExperimentBuilder builder = new BaseExperimentBuilder(uuid, pipelinePath, typeSystem);
    AdHocDriver driver = new AdHocDriver(builder);
    AdHocSource source = new BaseAdHocSource() {
      public void publish(String quuid, String question) throws InterruptedException {
        DataElement result = new DataElement(datasetName, sequenceId, question, quuid);
        getReader().putQuestion(result);
      }
    };
    XmiPrintCallbackListener callback = new XmiPrintCallbackListener(new File(outputXmiPath));
    AdHocCollectionReader reader = driver.setupAndRun(source, callback);
    String quuid = UUID.randomUUID().toString();
    source.publish(quuid, question);
    callback.await();
    reader.shutdown();
  }

}

class XmiPrintCallbackListener implements CasProcessedCallback {

  protected final Object lock = new Object();

  private File file;

  public XmiPrintCallbackListener(File file) {
    this.file = file;
  }

  @Override
  public void entityProcessComplete(CAS cas) {
    try {
      CasIOUtil.writeXmi(cas, file);
    } catch (IOException e) {
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
