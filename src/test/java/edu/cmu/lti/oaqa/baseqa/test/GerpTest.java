package edu.cmu.lti.oaqa.baseqa.test;

import java.util.UUID;

import org.apache.uima.fit.factory.TypeSystemDescriptionFactory;
import org.apache.uima.resource.metadata.TypeSystemDescription;
import org.junit.Test;

import edu.cmu.lti.oaqa.cse.driver.AdHocDriver;
import edu.cmu.lti.oaqa.ecd.BaseExperimentBuilder;
import edu.cmu.lti.oaqa.ecd.ExperimentBuilder;
import edu.cmu.lti.oaqa.framework.DataElement;
import edu.cmu.lti.oaqa.framework.collection.adhoc.AdHocCollectionReader;
import edu.cmu.lti.oaqa.framework.collection.adhoc.AdHocSource;
import edu.cmu.lti.oaqa.framework.collection.adhoc.BaseAdHocSource;

public class GerpTest {
  
  @Test
  public void testGerpProviders() throws Exception {
    runPipeline("baseqa.gerp-providers-test", "Gerp One Question Set", "TEST",
            "This is an empty question");
  }

  @Test
  public void testGerpPhases() throws Exception {
    runPipeline("baseqa.gerp-phases-test", "Gerp One Question Set", "TEST",
            "This is an empty question");
  }

  @Test
  public void testGerpPhasesWithGerpedAnswers() throws Exception {
    runPipeline("baseqa.gerp-phases-with-gerped-answers-test", "Gerp One Question Set", "TEST",
            "This is an empty question");
  }

  protected void runPipeline(String pipelinePath, final String datasetName,
          final String sequenceId, String question) throws Exception {
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
    XmiPrintCallbackListener callback = new XmiPrintCallbackListener();
    AdHocCollectionReader reader = driver.setupAndRun(source, callback);
    String quuid = UUID.randomUUID().toString();
    source.publish(quuid, question);
    callback.await();
    reader.shutdown();
  }
}
