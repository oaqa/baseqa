package edu.cmu.lti.oaqa.baseqa.eval;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class EvalCalculatorUtil {

  public static double sumMeasurementValues(Collection<Double> values) {
    return values.stream().mapToDouble(Double::doubleValue).sum();
  }

  public static double sumOfLogMeasurementValues(Collection<Double> values) {
    return values.stream().mapToDouble(v -> Math.log(v + Double.MIN_NORMAL)).sum();
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

}
