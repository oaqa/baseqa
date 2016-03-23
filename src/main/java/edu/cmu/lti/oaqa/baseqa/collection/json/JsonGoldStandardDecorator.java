package edu.cmu.lti.oaqa.baseqa.collection.json;

import edu.cmu.lti.oaqa.baseqa.collection.json.gson.TrainingQuestion;
import edu.cmu.lti.oaqa.baseqa.collection.json.gson.TrainingSet;
import edu.cmu.lti.oaqa.baseqa.util.ViewType;
import edu.cmu.lti.oaqa.ecd.phase.ProcessingStepUtils;
import edu.cmu.lti.oaqa.util.TypeUtil;
import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceAccessException;
import org.apache.uima.resource.ResourceInitializationException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JsonGoldStandardDecorator extends JCasAnnotator_ImplBase {

  private Map<String, TrainingQuestion> id2input;

  @Override
  public void initialize(UimaContext context) throws ResourceInitializationException {
    super.initialize(context);
    Object value = context.getConfigParameterValue("file");
    List<String> paths = new ArrayList<>();
    if (String.class.isAssignableFrom(value.getClass())) {
      paths.add(String.class.cast(value));
    } else if (String[].class.isAssignableFrom(value.getClass())) {
      paths.addAll(Arrays.asList(String[].class.cast(value)));
    }
    List<TrainingQuestion> inputs = new ArrayList<>();
    for (String path : paths) {
      try {
        inputs.addAll(TrainingSet.load(context.getResourceAsStream(path)));
      } catch (ResourceAccessException e) {
        throw new ResourceInitializationException(e);
      }
    }
    // trim question texts
    inputs.stream().filter(input -> input.getBody() != null)
            .forEach(input -> input.setBody(input.getBody().trim().replaceAll("\\s+", " ")));
    id2input = inputs.stream()
            .collect(Collectors.toMap(TrainingQuestion::getId, Function.identity(), (x, y) -> x));
  }

  @Override
  public void process(JCas jcas) throws AnalysisEngineProcessException {
    String id = ProcessingStepUtils.getInputElement(jcas).getQuuid();
    String source = TypeUtil.getQuestion(jcas).getSource();
    if (!id2input.containsKey(id)) {
      return;
    }
    JsonCollectionReaderHelper.addQuestionToIndex(id2input.get(id), source,
            ViewType.getGsView(jcas));
  }

}
