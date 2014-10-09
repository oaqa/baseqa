package edu.cmu.lti.oaqa.baseqa.eval.calculator;

import static edu.cmu.lti.oaqa.baseqa.eval.calculator.RetrievalEvalMeasure.AVERAGE_PRECISION;
import static edu.cmu.lti.oaqa.baseqa.eval.calculator.RetrievalEvalMeasure.BINARY_RECALL;
import static edu.cmu.lti.oaqa.baseqa.eval.calculator.RetrievalEvalMeasure.BINARY_RELEVANT;
import static edu.cmu.lti.oaqa.baseqa.eval.calculator.RetrievalEvalMeasure.F1;
import static edu.cmu.lti.oaqa.baseqa.eval.calculator.RetrievalEvalMeasure.MAP;
import static edu.cmu.lti.oaqa.baseqa.eval.calculator.RetrievalEvalMeasure.PRECISION;
import static edu.cmu.lti.oaqa.baseqa.eval.calculator.RetrievalEvalMeasure.RECALL;
import static edu.cmu.lti.oaqa.baseqa.eval.calculator.RetrievalEvalMeasure.RELEVANT;
import static edu.cmu.lti.oaqa.baseqa.eval.calculator.RetrievalEvalMeasure.RELEVANT_RETRIEVED;
import static edu.cmu.lti.oaqa.baseqa.eval.calculator.RetrievalEvalMeasure.RETRIEVAL_COUNT;
import static edu.cmu.lti.oaqa.baseqa.eval.calculator.RetrievalEvalMeasure.RETRIEVED;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;

import edu.cmu.lti.oaqa.baseqa.eval.EvalCalculator;
import edu.cmu.lti.oaqa.baseqa.eval.Measure;
import edu.cmu.lti.oaqa.ecd.config.ConfigurableProvider;

public class RetrievalEvalCalculator<T> extends ConfigurableProvider implements EvalCalculator<T> {

  @Override
  public Map<Measure, Double> calculate(Iterable<T> resultEvaluatees, Iterable<T> gsEvaluatees,
          Comparator<T> comparator, Function<T, String> uniqueIdMapper) {
    Set<String> gsSet = StreamSupport.stream(gsEvaluatees.spliterator(), true).map(uniqueIdMapper)
            .collect(toSet());
    List<String> resultArray = StreamSupport.stream(resultEvaluatees.spliterator(), false)
            .sorted(comparator).map(uniqueIdMapper).distinct().collect(toList());
    Set<String> resultSet = new HashSet<>(resultArray);
    return ImmutableMap.<Measure, Double> builder()
            .put(RELEVANT_RETRIEVED, (double) Sets.intersection(resultSet, gsSet).size())
            .put(RETRIEVED, (double) resultSet.size()).put(RELEVANT, (double) gsSet.size())
            .put(AVERAGE_PRECISION, calculateAveragePrecision(resultArray, gsSet))
            .put(BINARY_RELEVANT, Sets.intersection(resultSet, gsSet).isEmpty() ? 0.0 : 1.0)
            .put(RETRIEVAL_COUNT, 1.0).build();
  }

  @Override
  public Map<Measure, Double> accumulate(Map<Measure, ? extends Iterable<Double>> measure2values) {
    double relevantRetrieved = sumMeasurementValues(measure2values.get(RELEVANT_RETRIEVED));
    double retrieved = sumMeasurementValues(measure2values.get(RETRIEVED));
    double relevant = sumMeasurementValues(measure2values.get(RELEVANT));
    double sumAvgPrec = sumMeasurementValues(measure2values.get(AVERAGE_PRECISION));
    double count = sumMeasurementValues(measure2values.get(RETRIEVAL_COUNT));
    double binaryRelevant = sumMeasurementValues(measure2values.get(BINARY_RELEVANT));
    double recall = calculateRecall(relevant, relevantRetrieved);
    double precision = calculatePrecision(retrieved, relevantRetrieved);
    return ImmutableMap.<Measure, Double> builder().put(PRECISION, precision).put(RECALL, recall)
            .put(F1, calculateF1(precision, recall)).put(MAP, sumAvgPrec / count)
            .put(BINARY_RECALL, binaryRelevant / count).put(RETRIEVAL_COUNT, count).build();
  }

  private static double sumMeasurementValues(Iterable<Double> values) {
    return StreamSupport.stream(values.spliterator(), true).mapToDouble(Double::doubleValue).sum();
  }

  public static double calculateAveragePrecision(List<String> resultArray, Set<String> gsSet) {
    int[] relIndices = IntStream.range(0, resultArray.size())
            .filter(i -> gsSet.contains(resultArray.get(i))).toArray();
    double sumPrec = IntStream.range(0, relIndices.length)
            .mapToDouble(i -> (i + 1.0) / (relIndices[i] + 1.0)).sum();
    return sumPrec / gsSet.size();
  }

  public static double calculateRecall(double relevant, double relevantRetrieved) {
    return (relevant != 0.0) ? relevantRetrieved / relevant : 0.0;
  }

  public static double calculatePrecision(double retrieved, double relevantRetrieved) {
    return (retrieved != 0.0) ? relevantRetrieved / retrieved : 0.0;
  }

  public static double calculateF1(double precision, double recall) {
    return ((precision + recall) != 0) ? (2 * precision * recall) / (precision + recall) : 0.0;
  }
  
  @Override
  public String getName() {
    return "Retrieval";
  }

}
