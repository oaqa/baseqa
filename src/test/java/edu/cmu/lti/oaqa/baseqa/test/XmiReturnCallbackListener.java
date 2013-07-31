package edu.cmu.lti.oaqa.baseqa.test;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.impl.XmiCasSerializer;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.xml.sax.SAXException;

import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.framework.collection.adhoc.SyncCasProcessedCallbackListener;

public class XmiReturnCallbackListener extends SyncCasProcessedCallbackListener {

  private List<Document> CASes = Lists.newArrayList();

  @Override
  public void entityProcessComplete(CAS aCas) {
    try {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      XmiCasSerializer.serialize(aCas, baos);
      CASes.add(DocumentHelper.parseText(baos.toString()));
      latch.countDown();
    } catch (SAXException e) {
      e.printStackTrace();
    } catch (DocumentException e) {
      e.printStackTrace();
    }
  }

  public List<Document> getCASes() {
    return CASes;
  }

}