package edu.cmu.lti.oaqa.baseqa.collection.json;

import java.util.Iterator;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.collection.json.gson.TestQuestion;
import edu.cmu.lti.oaqa.baseqa.collection.json.gson.TestSet;
import edu.cmu.lti.oaqa.framework.DataElement;
import edu.cmu.lti.oaqa.framework.collection.IterableCollectionReader;

public class JsonCollectionReader extends IterableCollectionReader {

  private List<TestQuestion> inputs;

  @Override
  public void initialize() throws ResourceInitializationException {
    super.initialize();
    inputs = Lists.newArrayList();
    Object value = getConfigParameterValue("file");
    if (value instanceof String) {
      inputs.addAll(TestSet.load(getClass().getResourceAsStream((String) value)));
    } else if (value instanceof String[]) {
      for (String path : (String[]) value) {
        inputs.addAll(TestSet.load(getClass().getResourceAsStream(path)));
      }
    }
  }

  private int seqId = -1;

  @Override
  protected Iterator<DataElement> getInputSet() throws ResourceInitializationException {
    return new Iterator<DataElement>() {

      @Override
      public void remove() {
        // Do nothing
      }

      @Override
      public DataElement next() {
        TestQuestion input = inputs.get(++seqId);
        return new DataElement(getDataset(), String.valueOf(seqId), input.getBody(), input.getId());
      }

      @Override
      public boolean hasNext() {
        return seqId + 1 < inputs.size();
      }
    };
  }

  @Override
  protected void decorate(JCas jcas) throws AnalysisEngineProcessException {
    TestQuestion input = inputs.get(seqId);
    JsonCollectionReaderHelper.addQuestionToIndex(input, getDataset(), jcas);
    super.decorate(jcas);
  }

}
