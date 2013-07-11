package edu.cmu.lti.oaqa.baseqa.test;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.resource.metadata.TypeSystemDescription;
import org.junit.Test;
import org.oaqa.model.test.Passage;
import org.oaqa.model.test.Search;
import org.uimafit.factory.TypeSystemDescriptionFactory;

import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.cse.driver.AdHocDriver;
import edu.cmu.lti.oaqa.ecd.BaseExperimentBuilder;
import edu.cmu.lti.oaqa.ecd.ExperimentBuilder;
import edu.cmu.lti.oaqa.ecd.phase.ProcessingStepUtils;
import edu.cmu.lti.oaqa.framework.DataElement;
import edu.cmu.lti.oaqa.framework.ViewManager;
import edu.cmu.lti.oaqa.framework.collection.adhoc.AdHocCollectionReader;
import edu.cmu.lti.oaqa.framework.collection.adhoc.AdHocSource;
import edu.cmu.lti.oaqa.framework.collection.adhoc.BaseAdHocSource;
import edu.cmu.lti.oaqa.framework.collection.adhoc.SyncCasProcessedCallbackListener;
import edu.cmu.lti.oaqa.framework.types.InputElement;

public class GerpTest {

  @Test
  public void setupAdhocPipeline() throws Exception {
    String uuid = UUID.randomUUID().toString();
    TypeSystemDescription typeSystem = TypeSystemDescriptionFactory.createTypeSystemDescription();
    ExperimentBuilder builder = new BaseExperimentBuilder(uuid, "baseqa.gerp-test", typeSystem);
    AdHocDriver driver = new AdHocDriver(builder);
    AdHocSource source = new BaseAdHocSource() {
      public void publish(String quuid, String question) throws InterruptedException {
        DataElement result = new DataElement("Gerp One Question Set", "0", question, quuid);
        getReader().putQuestion(result);
      }
    };
    ResultSizeCallbackListener callback = new ResultSizeCallbackListener();
    AdHocCollectionReader reader = driver.setupAndRun(source, callback);
    String quuid = UUID.randomUUID().toString();
    source.publish(quuid, "This is an empty question");
    callback.await();
    reader.shutdown();
  }

  private static final class ResultSizeCallbackListener extends SyncCasProcessedCallbackListener {

    int size;

    String quuid;

    @Override
    public void entityProcessComplete(CAS aCas) {
      try {
        JCas jcas = aCas.getJCas();
        JCas view = ViewManager.getDocumentView(jcas);
        List<Passage> docs = (view != null) ? loadDocumentSet(view) : Collections
                .<Passage> emptyList();
        size = docs.size();
        InputElement input = ProcessingStepUtils.getInputElement(jcas);
        this.quuid = input.getQuuid();
        latch.countDown();
      } catch (CASException e) {
        e.printStackTrace();
      }
    }

    public static List<Passage> loadDocumentSet(JCas jcas) {
      List<Passage> result = Lists.newArrayList();
      Iterator<?> it = jcas.getJFSIndexRepository().getAllIndexedFS(Search.type);
      if (it.hasNext()) {
        Search retrievalResult = (Search) it.next();
        FSArray hitList = retrievalResult.getHitList();
        for (int i = 0; i < hitList.size(); i++) {
          Passage sr = (Passage) hitList.get(i);
          result.add(sr);
        }
      }
      return result;
    }
  }
}
