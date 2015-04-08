package edu.cmu.lti.oaqa.baseqa.eval.calculator;

import static edu.cmu.lti.oaqa.baseqa.eval.EvalCalculatorUtil.calculateAveragePrecision;
import static edu.cmu.lti.oaqa.baseqa.eval.EvalCalculatorUtil.calculateF1;
import static edu.cmu.lti.oaqa.baseqa.eval.EvalCalculatorUtil.calculatePrecision;
import static edu.cmu.lti.oaqa.baseqa.eval.EvalCalculatorUtil.calculateRecall;
import static edu.cmu.lti.oaqa.baseqa.eval.EvalCalculatorUtil.sumMeasurementValues;
import static edu.cmu.lti.oaqa.baseqa.eval.EvalCalculatorUtil.sumOfLogMeasurementValues;
import static edu.cmu.lti.oaqa.baseqa.eval.calculator.RetrievalEvalMeasure.AVERAGE_PRECISION;
import static edu.cmu.lti.oaqa.baseqa.eval.calculator.RetrievalEvalMeasure.BINARY_RELEVANT;
import static edu.cmu.lti.oaqa.baseqa.eval.calculator.RetrievalEvalMeasure.F1;
import static edu.cmu.lti.oaqa.baseqa.eval.calculator.RetrievalEvalMeasure.GMAP;
import static edu.cmu.lti.oaqa.baseqa.eval.calculator.RetrievalEvalMeasure.MAP;
import static edu.cmu.lti.oaqa.baseqa.eval.calculator.RetrievalEvalMeasure.MEAN_BINARY_RECALL;
import static edu.cmu.lti.oaqa.baseqa.eval.calculator.RetrievalEvalMeasure.MEAN_F1;
import static edu.cmu.lti.oaqa.baseqa.eval.calculator.RetrievalEvalMeasure.MEAN_PRECISION;
import static edu.cmu.lti.oaqa.baseqa.eval.calculator.RetrievalEvalMeasure.MEAN_RECALL;
import static edu.cmu.lti.oaqa.baseqa.eval.calculator.RetrievalEvalMeasure.PRECISION;
import static edu.cmu.lti.oaqa.baseqa.eval.calculator.RetrievalEvalMeasure.RECALL;
import static edu.cmu.lti.oaqa.baseqa.eval.calculator.RetrievalEvalMeasure.RELEVANT;
import static edu.cmu.lti.oaqa.baseqa.eval.calculator.RetrievalEvalMeasure.RELEVANT_RETRIEVED;
import static edu.cmu.lti.oaqa.baseqa.eval.calculator.RetrievalEvalMeasure.RETRIEVAL_COUNT;
import static edu.cmu.lti.oaqa.baseqa.eval.calculator.RetrievalEvalMeasure.RETRIEVED;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;

import edu.cmu.lti.oaqa.baseqa.eval.EvalCalculator;
import edu.cmu.lti.oaqa.baseqa.eval.Measure;
import edu.cmu.lti.oaqa.ecd.config.ConfigurableProvider;
import edu.cmu.lti.oaqa.type.retrieval.SearchResult;

public class RetrievalEvalCalculator<T extends SearchResult> extends ConfigurableProvider implements
        EvalCalculator<T> {

  @Override
  public Map<Measure, Double> calculate(Collection<T> resultEvaluatees, Collection<T> gsEvaluatees,
          Comparator<T> comparator, Function<T, String> uniqueIdMapper) {
    Set<String> gsSet = gsEvaluatees.parallelStream().map(uniqueIdMapper).collect(toSet());
    List<String> resultArray = resultEvaluatees.stream().sorted(comparator).map(uniqueIdMapper)
            .distinct().collect(toList());
    Set<String> resultSet = new HashSet<>(resultArray);
    double retrieved = (double) resultSet.size();
    double relevant = (double) gsSet.size();
    double relevantRetrieved = (double) Sets.intersection(resultSet, gsSet).size();
    double binaryRelevant = relevantRetrieved > 0 ? 1.0 : 0.0;
    double precision = calculatePrecision(retrieved, relevantRetrieved);
    double recall = calculateRecall(relevant, relevantRetrieved);
    double f1 = calculateF1(precision, recall);
    double averagePrecision = calculateAveragePrecision(resultArray, gsSet);
    return ImmutableMap.<Measure, Double> builder().put(RETRIEVAL_COUNT, 1.0)
            .put(RETRIEVED, retrieved).put(RELEVANT, relevant)
            .put(RELEVANT_RETRIEVED, relevantRetrieved).put(BINARY_RELEVANT, binaryRelevant)
            .put(PRECISION, precision).put(RECALL, recall).put(F1, f1)
            .put(AVERAGE_PRECISION, averagePrecision).build();
  }

  @Override
  public Map<Measure, Double> accumulate(Map<Measure, ? extends Collection<Double>> measure2values) {
    double count = sumMeasurementValues(measure2values.get(RETRIEVAL_COUNT));
    double meanPrecision = sumMeasurementValues(measure2values.get(PRECISION)) / count;
    double meanRecall = sumMeasurementValues(measure2values.get(RECALL)) / count;
    double meanBinaryRecall = sumMeasurementValues(measure2values.get(BINARY_RELEVANT)) / count;
    double meanF1 = sumMeasurementValues(measure2values.get(F1)) / count;
    double map = sumMeasurementValues(measure2values.get(AVERAGE_PRECISION)) / count;
    double gmap = Math
            .exp(sumOfLogMeasurementValues(measure2values.get(AVERAGE_PRECISION)) / count);
    return ImmutableMap.<Measure, Double> builder().put(RETRIEVAL_COUNT, count)
            .put(MEAN_PRECISION, meanPrecision).put(MEAN_RECALL, meanRecall)
            .put(MEAN_BINARY_RECALL, meanBinaryRecall).put(MEAN_F1, meanF1).put(MAP, map)
            .put(GMAP, gmap).build();
  }

  @Override
  public String getName() {
    return "Retrieval";
  }

}
