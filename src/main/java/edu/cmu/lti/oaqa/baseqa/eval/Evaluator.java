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

import edu.cmu.lti.oaqa.baseqa.util.UimaContextHelper;
import edu.cmu.lti.oaqa.ecd.BaseExperimentBuilder;
import edu.cmu.lti.oaqa.ecd.phase.ProcessingStepUtils;
import edu.cmu.lti.oaqa.ecd.phase.Trace;
import edu.cmu.lti.oaqa.framework.eval.ExperimentKey;
import edu.cmu.lti.oaqa.framework.eval.Key;
import edu.cmu.lti.oaqa.framework.types.ExperimentUUID;

public final class Evaluator<T> extends JCasConsumer_ImplBase {

  private EvaluateeProvider<T> evaluatee;

  private EvalCalculator<T> calculator;

  private String calculatorName;

  private EvalPeristenceProvider persistence;

  private Set<ExperimentKey> experiments = Sets.newHashSet();

  @SuppressWarnings("unchecked")
  @Override
  public void initialize(UimaContext context) throws ResourceInitializationException {
    super.initialize(context);
    String ep = UimaContextHelper.getConfigParameterStringValue(context, "evaluatee-provider");
    evaluatee = BaseExperimentBuilder.loadProvider(ep, EvaluateeProvider.class);
    String c = UimaContextHelper.getConfigParameterStringValue(context, "calculator");
    calculator = BaseExperimentBuilder.loadProvider(c, EvalCalculator.class);
    calculatorName = calculator.getClass().getSimpleName();
    String pp = UimaContextHelper.getConfigParameterStringValue(context, "persistence-provider");
    persistence = BaseExperimentBuilder.loadProvider(pp, EvalPeristenceProvider.class);
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
    persistence.deletePartialMeasurements(key, sequenceId, calculatorName);
    persistence.insertPartialMeasurements(key, sequenceId, calculatorName, measurements);
  }

  @Override
  public void collectionProcessComplete() throws AnalysisEngineProcessException {
    super.collectionProcessComplete();
    experiments.forEach(experiment -> {
      persistence.deleteAccumulatedMeasurements(experiment, calculatorName);
      Table<Key, Measure, List<Double>> measurements = persistence.selectPartialMeasurements(
              experiment, calculatorName);
      measurements.rowKeySet().forEach(key -> {
        Map<Measure, Double> accuMeasurement = calculator.accumulate(measurements.row(key));
        persistence.insertAccumulatedMeasurements(key, calculatorName, accuMeasurement);
      });
    });
  }
}
