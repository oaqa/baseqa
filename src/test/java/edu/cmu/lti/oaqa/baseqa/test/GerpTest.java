package edu.cmu.lti.oaqa.baseqa.test;

import java.io.StringWriter;
import java.util.UUID;

import org.apache.uima.resource.metadata.TypeSystemDescription;
import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.junit.Test;
import org.uimafit.factory.TypeSystemDescriptionFactory;

import edu.cmu.lti.oaqa.cse.driver.AdHocDriver;
import edu.cmu.lti.oaqa.ecd.BaseExperimentBuilder;
import edu.cmu.lti.oaqa.ecd.ExperimentBuilder;
import edu.cmu.lti.oaqa.framework.DataElement;
import edu.cmu.lti.oaqa.framework.collection.adhoc.AdHocCollectionReader;
import edu.cmu.lti.oaqa.framework.collection.adhoc.AdHocSource;
import edu.cmu.lti.oaqa.framework.collection.adhoc.BaseAdHocSource;

public class GerpTest {

  @Test
  public void testGerp() throws Exception {
    Document xmi = runPipeline("baseqa.gerp-providers-test", "Gerp One Question Set", "TEST",
            "This is an empty question");
    StringWriter xmiStr = new StringWriter();
    XMLWriter writer = new XMLWriter(xmiStr, OutputFormat.createPrettyPrint());
    writer.write(xmi);
    writer.close();
    System.out.println(xmiStr);
  }

  public Document runPipeline(String pipelinePath, final String datasetName,
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
    XmiReturnCallbackListener callback = new XmiReturnCallbackListener();
    AdHocCollectionReader reader = driver.setupAndRun(source, callback);
    String quuid = UUID.randomUUID().toString();
    source.publish(quuid, question);
    callback.await();
    Document xmi = callback.getXmi();
    reader.shutdown();
    return xmi;
  }
}
