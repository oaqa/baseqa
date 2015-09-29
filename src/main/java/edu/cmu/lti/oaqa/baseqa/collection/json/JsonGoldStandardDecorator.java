package edu.cmu.lti.oaqa.baseqa.collection.json;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collector;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import edu.cmu.lti.oaqa.baseqa.collection.json.gson.TrainingQuestion;
import edu.cmu.lti.oaqa.baseqa.collection.json.gson.TrainingSet;
import edu.cmu.lti.oaqa.baseqa.util.ViewType;
import edu.cmu.lti.oaqa.ecd.phase.ProcessingStepUtils;
import edu.cmu.lti.oaqa.util.TypeUtil;

public class JsonGoldStandardDecorator extends JCasAnnotator_ImplBase {

  private Map<String, TrainingQuestion> id2input;

  private static final Collector<TrainingQuestion, ?, Map<String, TrainingQuestion>> TO_MAP_COLLECTOR = groupingBy(
          TrainingQuestion::getId, reducing(null, (x, y) -> y));

  @Override
  public void initialize(UimaContext context) throws ResourceInitializationException {
    super.initialize(context);
    Object value = context.getConfigParameterValue("file");
    if (String.class.isAssignableFrom(value.getClass())) {
      id2input = TrainingSet.load(getClass().getResourceAsStream(String.class.cast(value))).stream()
              .collect(TO_MAP_COLLECTOR);
    } else if (String[].class.isAssignableFrom(value.getClass())) {
      id2input = Arrays.stream(String[].class.cast(value))
              .flatMap(path -> TrainingSet.load(getClass().getResourceAsStream(path)).stream())
              .collect(TO_MAP_COLLECTOR);
    }
    // trim question texts
    id2input.values().stream().filter(input -> input.getBody() != null)
            .forEach(input -> input.setBody(input.getBody().trim().replaceAll("\\s+", " ")));
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
