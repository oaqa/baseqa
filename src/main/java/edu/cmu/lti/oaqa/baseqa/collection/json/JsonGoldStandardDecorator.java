package edu.cmu.lti.oaqa.baseqa.collection.json;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CASException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import edu.cmu.lti.oaqa.baseqa.collection.json.gson.TrainingQuestion;
import edu.cmu.lti.oaqa.baseqa.collection.json.gson.TrainingSet;
import edu.cmu.lti.oaqa.ecd.phase.ProcessingStepUtils;
import edu.cmu.lti.oaqa.framework.ViewManager;
import edu.cmu.lti.oaqa.framework.ViewManager.ViewType;
import edu.cmu.lti.oaqa.util.TypeUtil;

public class JsonGoldStandardDecorator extends JCasAnnotator_ImplBase {

  private Map<String, TrainingQuestion> id2input;

  private static final Collector<TrainingQuestion, ?, Map<String, TrainingQuestion>> TO_MAP_COLLECTOR = Collectors
          .groupingBy(TrainingQuestion::getId, Collectors.reducing(null, (x, y) -> y));

  @Override
  public void initialize(UimaContext context) throws ResourceInitializationException {
    super.initialize(context);
    Object value = context.getConfigParameterValue("file");
    if (String.class.isAssignableFrom(value.getClass())) {
      id2input = TrainingSet.load(getClass().getResourceAsStream(String.class.cast(value)))
              .stream().collect(TO_MAP_COLLECTOR);
    } else if (String[].class.isAssignableFrom(value.getClass())) {
      id2input = Arrays.stream(String[].class.cast(value))
              .flatMap(path -> TrainingSet.load(getClass().getResourceAsStream(path)).stream())
              .collect(TO_MAP_COLLECTOR);
    }
  }

  @Override
  public void process(JCas jcas) throws AnalysisEngineProcessException {
    String id = ProcessingStepUtils.getInputElement(jcas).getQuuid();
    String source = TypeUtil.getQuestion(jcas).getSource();
    try {
      JsonCollectionReaderHelper.addQuestionToIndex(id2input.get(id), source,
              ViewManager.getOrCreateView(jcas, ViewType.FINAL_ANSWER_GS));
    } catch (CASException e) {
      throw new AnalysisEngineProcessException(e);
    }
  }

}
