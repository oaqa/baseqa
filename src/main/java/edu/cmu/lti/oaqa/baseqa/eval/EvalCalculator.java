package edu.cmu.lti.oaqa.baseqa.eval;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;

import org.apache.uima.resource.Resource;

public interface EvalCalculator<T> extends Resource {

  Map<Measure, Double> calculate(Iterable<T> resultEvaluatees, Iterable<T> gsEvaluatees,
          Comparator<T> comparator, Function<T, String> uniqueIdMapper);

  Map<Measure, Double> accumulate(Map<Measure, ? extends Iterable<Double>> measure2values);

}
