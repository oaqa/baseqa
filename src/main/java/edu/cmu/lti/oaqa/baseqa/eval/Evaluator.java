package edu.cmu.lti.oaqa.baseqa.eval;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CASException;
import org.apache.uima.fit.component.JCasConsumer_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import com.google.common.collect.Sets;
import com.google.common.collect.Table;

import edu.cmu.lti.oaqa.baseqa.util.ProviderCache;
import edu.cmu.lti.oaqa.baseqa.util.UimaContextHelper;
import edu.cmu.lti.oaqa.ecd.phase.ProcessingStepUtils;
import edu.cmu.lti.oaqa.ecd.phase.Trace;
import edu.cmu.lti.oaqa.framework.eval.ExperimentKey;
import edu.cmu.lti.oaqa.framework.eval.Key;
import edu.cmu.lti.oaqa.framework.types.ExperimentUUID;

public final class Evaluator<T> extends JCasConsumer_ImplBase {

  private EvalCalculator<T> calculator;

  private String calculatorName;

  private EvaluateeProvider<T> evaluatee;

  private String evaluateeName;

  private EvalPeristenceProvider persistence;

  private Set<ExperimentKey> experiments = Sets.newHashSet();

  @SuppressWarnings("unchecked")
  @Override
  public void initialize(UimaContext context) throws ResourceInitializationException {
    super.initialize(context);
    String c = UimaContextHelper.getConfigParameterStringValue(context, "calculator");
    calculator = ProviderCache.getProvider(c, EvalCalculator.class);
    calculatorName = calculator.getName();
    String ep = UimaContextHelper.getConfigParameterStringValue(context, "evaluatee-provider");
    evaluatee = ProviderCache.getProvider(ep, EvaluateeProvider.class);
    evaluateeName = evaluatee.getName();
    String pp = UimaContextHelper.getConfigParameterStringValue(context, "persistence-provider");
    persistence = ProviderCache.getProvider(pp, EvalPeristenceProvider.class);
  }

  @Override
  public void process(JCas jcas) throws AnalysisEngineProcessException {
    // prepare evaluatees
    Collection<T> gs;
    Collection<T> results;
    try {
      if ((gs = evaluatee.getGoldStandard(jcas)).isEmpty()) {
        return;
      }
      results = evaluatee.getResults(jcas);
    } catch (CASException e) {
      throw new AnalysisEngineProcessException(e);
    }
    Comparator<T> comparator = evaluatee.comparator();
    Function<T, String> uniqueIdMapper = evaluatee.uniqueIdMapper();
    // calculate evaluator
    Map<Measure, Double> measurements = calculator.calculate(results, gs, comparator,
            uniqueIdMapper);
    // persist evaluation results
    ExperimentUUID experiment = ProcessingStepUtils.getCurrentExperiment(jcas);
    experiments.add(new ExperimentKey(experiment.getUuid(), experiment.getStageId()));
    Trace trace = ProcessingStepUtils.getTrace(jcas);
    Key key = new Key(experiment.getUuid(), trace, experiment.getStageId());
    String sequenceId = ProcessingStepUtils.getSequenceId(jcas);
    persistence.deletePartialMeasurements(key, sequenceId, calculatorName, evaluateeName);
    persistence.insertPartialMeasurements(key, sequenceId, calculatorName, evaluateeName,
            measurements);
  }

  @Override
  public void collectionProcessComplete() throws AnalysisEngineProcessException {
    super.collectionProcessComplete();
    experiments.forEach(experiment -> {
      persistence.deleteAccumulatedMeasurements(experiment, calculatorName, evaluateeName);
      Table<Key, Measure, List<Double>> part = persistence.selectPartialMeasurements(experiment,
              calculatorName, evaluateeName);
      part.rowKeySet().forEach(key -> {
        Map<Measure, Double> accu = calculator.accumulate(part.row(key));
        persistence.insertAccumulatedMeasurements(key, calculatorName, evaluateeName, accu);
      } );
    } );
  }

}
