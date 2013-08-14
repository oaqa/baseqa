package edu.cmu.lti.oaqa.baseqa.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.concurrent.CountDownLatch;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.impl.XmiCasSerializer;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.xml.sax.SAXException;

import edu.cmu.lti.oaqa.framework.collection.adhoc.CasProcessedCallback;

public class XmiPrintCallbackListener implements CasProcessedCallback {

  protected final CountDownLatch latch = new CountDownLatch(16);
  
  public void await() throws InterruptedException {
    latch.await();
  }
  
  @Override
  public void entityProcessComplete(CAS aCas) {
    try {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      XmiCasSerializer.serialize(aCas, baos);
      printXmi(baos.toString());
      latch.countDown();
    } catch (SAXException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (DocumentException e) {
      e.printStackTrace();
    }
  }

  protected void printXmi(String xmi) throws IOException, DocumentException {
    StringWriter xmiStr = new StringWriter();
    XMLWriter writer = new XMLWriter(xmiStr, OutputFormat.createPrettyPrint());
    writer.write(DocumentHelper.parseText(xmi));
    writer.close();
    System.out.println(xmiStr);
  }

}