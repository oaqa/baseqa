package edu.cmu.lti.oaqa.baseqa.collection.json;

import static java.util.stream.Collectors.toList;

import java.util.*;

import edu.cmu.lti.oaqa.baseqa.collection.json.gson.TrainingSet;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceAccessException;
import org.apache.uima.resource.ResourceInitializationException;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

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
    List<String> paths = new ArrayList<>();
    if (String.class.isAssignableFrom(value.getClass())) {
      paths.add(String.class.cast(value));
    } else if (String[].class.isAssignableFrom(value.getClass())) {
      paths.addAll(Arrays.asList(String[].class.cast(value)));
    }
    for (String path : paths) {
      try {
        inputs.addAll(TestSet.load(getUimaContext().getResourceAsStream(path)));
      } catch (ResourceAccessException e) {
        throw new ResourceInitializationException(e);
      }
    }
    // trim question texts
    inputs.stream().filter(input -> input.getBody() != null)
            .forEach(input -> input.setBody(input.getBody().trim().replaceAll("\\s+", " ")));
    // filter by question type
    String[] type = (String[]) getConfigParameterValue("type");
    if (type != null) {
      Set<String> typeSet = Sets.newHashSet(type);
      inputs = inputs.stream().filter(input -> typeSet.contains(input.getType().name()))
              .collect(toList());
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
