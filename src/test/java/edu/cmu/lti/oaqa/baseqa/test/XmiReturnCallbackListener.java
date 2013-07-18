package edu.cmu.lti.oaqa.baseqa.test;

import java.io.ByteArrayOutputStream;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.impl.XmiCasSerializer;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.xml.sax.SAXException;

import edu.cmu.lti.oaqa.framework.collection.adhoc.SyncCasProcessedCallbackListener;

public class XmiReturnCallbackListener extends SyncCasProcessedCallbackListener {

  private Document xmi;

  @Override
  public void entityProcessComplete(CAS aCas) {
    try {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      XmiCasSerializer.serialize(aCas, baos);
      xmi = DocumentHelper.parseText(baos.toString());
      latch.countDown();
    } catch (SAXException e) {
      e.printStackTrace();
    } catch (DocumentException e) {
      e.printStackTrace();
    }
  }

  public Document getXmi() {
    return xmi;
  }

}