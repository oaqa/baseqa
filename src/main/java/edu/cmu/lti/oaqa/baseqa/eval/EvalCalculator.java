package edu.cmu.lti.oaqa.baseqa.eval;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;

import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.Resource;

public interface EvalCalculator<T> extends Resource {

  Map<Measure, Double> calculate(JCas jcas, Collection<T> resultEvaluatees,
          Collection<T> gsEvaluatees, Comparator<T> comparator, Function<T, String> uniqueIdMapper);

  Map<Measure, Double> accumulate(Map<Measure, ? extends Collection<Double>> measure2values);

  String getName();

}
