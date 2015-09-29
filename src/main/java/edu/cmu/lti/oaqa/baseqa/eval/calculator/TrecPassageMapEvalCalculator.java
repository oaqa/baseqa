package edu.cmu.lti.oaqa.baseqa.eval.calculator;

import com.google.common.collect.*;
import edu.cmu.lti.oaqa.baseqa.eval.EvalCalculator;
import edu.cmu.lti.oaqa.baseqa.eval.Measure;
import edu.cmu.lti.oaqa.ecd.config.ConfigurableProvider;
import edu.cmu.lti.oaqa.type.retrieval.Passage;
import edu.cmu.lti.oaqa.util.TypeUtil;
import org.apache.uima.jcas.JCas;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collector.Characteristics;
import java.util.stream.Stream;

import static edu.cmu.lti.oaqa.baseqa.eval.EvalCalculatorUtil.calculateAveragePrecision;
import static edu.cmu.lti.oaqa.baseqa.eval.EvalCalculatorUtil.sumMeasurementValues;
import static edu.cmu.lti.oaqa.baseqa.eval.calculator.TrecPassageMapEvalMeasure.*;
import static java.util.stream.Collectors.*;

public class TrecPassageMapEvalCalculator<T extends Passage> extends ConfigurableProvider
        implements EvalCalculator<T> {

  @Override
  public Map<Measure, Double> calculate(JCas jcas, Collection<T> resultEvaluatees,
          Collection<T> gsEvaluatees, Comparator<T> comparator,
          Function<T, String> uniqueIdMapper) {
    List<String> resultArray = resultEvaluatees.stream().sorted(comparator).map(Passage::getUri)
            .distinct().collect(toList());
    Set<String> gsSet = gsEvaluatees.parallelStream().map(Passage::getUri).collect(toSet());
    double avgDocPrec = calculateAveragePrecision(resultArray, gsSet);
    double avgPsgPrec = calculatePassageAveragePrecision(resultEvaluatees, gsEvaluatees);
    double avgPsg2Prec = calculatePassage2AveragePrecision(resultEvaluatees, gsEvaluatees);
    double avgAspPrec = calculateAspectAveragePrecision(resultEvaluatees, gsEvaluatees);
    return ImmutableMap.<Measure, Double> builder().put(TREC_PASSAGE_MAP_COUNT, 1.0)
            .put(TREC_DOCUMENT_AVERAGE_PRECISION, avgDocPrec)
            .put(TREC_PASSAGE_AVERAGE_PRECISION, avgPsgPrec)
            .put(TREC_PASSAGE2_AVERAGE_PRECISION, avgPsg2Prec)
            .put(TREC_ASPECT_AVERAGE_PRECISION, avgAspPrec).build();
  }

  @Override
  public Map<Measure, Double> accumulate(
          Map<Measure, ? extends Collection<Double>> measure2values) {
    double count = sumMeasurementValues(measure2values.get(TREC_PASSAGE_MAP_COUNT));
    double sumDocPrec = sumMeasurementValues(measure2values.get(TREC_DOCUMENT_AVERAGE_PRECISION));
    double sumPsgPrec = sumMeasurementValues(measure2values.get(TREC_PASSAGE_AVERAGE_PRECISION));
    double sumPsg2Prec = sumMeasurementValues(measure2values.get(TREC_PASSAGE2_AVERAGE_PRECISION));
    double sumAspPrec = sumMeasurementValues(measure2values.get(TREC_ASPECT_AVERAGE_PRECISION));
    return ImmutableMap.<Measure, Double> builder().put(TREC_PASSAGE_MAP_COUNT, count)
            .put(TREC_DOCUMENT_MAP, sumDocPrec / count).put(TREC_PASSAGE_MAP, sumPsgPrec / count)
            .put(TREC_PASSAGE2_MAP, sumPsg2Prec / count).put(TREC_ASPECT_MAP, sumAspPrec / count)
            .build();
  }

  public static <T extends Passage> double calculatePassageAveragePrecision(
          Collection<T> resultPassages, Collection<T> gsPassages) {
    return calculatePassageAveragePrecision(resultPassages, toUriPassages(gsPassages));
  }

  public static <T extends Passage> double calculatePassageAveragePrecision(
          Collection<T> resultPassages, Multimap<String, T> gsUriPassages) {
    int totalChars = 0;
    int overlapLength = 0;
    double sumPrecision = 0;
    int count = 0;
    Set<Passage> found = Sets.newHashSet();
    for (Passage resultPassage : resultPassages) {
      Range<Integer> resultRange = TypeUtil.spanRangeInSection(resultPassage);
      totalChars += resultRange.upperEndpoint() - resultRange.lowerEndpoint();
      if (!gsUriPassages.containsKey(resultPassage.getUri())) {
        continue;
      }
      for (Passage gsPassage : gsUriPassages.get(resultPassage.getUri())) {
        Range<Integer> gsRange = TypeUtil.spanRangeInSection(gsPassage);
        Range<Integer> overlap;
        if (!gsRange.isConnected(resultRange)
                || (overlap = resultRange.intersection(gsRange)).isEmpty()) {
          continue;
        }
        overlapLength += overlap.upperEndpoint() - overlap.lowerEndpoint();
        sumPrecision += (double) overlapLength / totalChars;
        count++;
        found.add(gsPassage);
        break;
      }
    }
    long numZeros = gsUriPassages.values().stream().filter(p -> !found.contains(p)).count();
    return sumPrecision / (count + numZeros);
  }

  private static <T extends Passage> Multimap<String, T> toUriPassages(Collection<T> passages) {
    return Multimaps.index(passages, Passage::getUri);
  }

  public static double calculatePassage2AveragePrecision(
          Collection<? extends Passage> resultPassages, Collection<? extends Passage> gsPassages) {
    return calculatePassage2AveragePrecision(resultPassages, toUriSpans(gsPassages));
  }

  public static double calculatePassage2AveragePrecision(
          Collection<? extends Passage> resultPassages, Map<String, RangeSet<Integer>> gsUriSpans) {
    Map<String, RangeSet<Integer>> trackGsUriSpans = Maps.newHashMap(gsUriSpans);
    int totalChars = 0;
    int overlapLength = 0;
    double sumPrecision = 0;
    for (Passage resultPassage : resultPassages) {
      Range<Integer> resultRange = TypeUtil.spanRangeInSection(resultPassage);
      String resultUri = resultPassage.getUri();
      if (!gsUriSpans.containsKey(resultUri) || !gsUriSpans.get(resultUri).encloses(resultRange)) {
        totalChars += resultRange.upperEndpoint() - resultRange.lowerEndpoint();
        continue;
      }
      for (int offset = resultRange.lowerEndpoint(); offset < resultRange
              .upperEndpoint(); offset++) {
        if (gsUriSpans.get(resultUri).contains(offset)) {
          if (trackGsUriSpans.get(resultUri).contains(offset)) {
            trackGsUriSpans.get(resultUri).remove(Range.singleton(offset));
            // +1
            totalChars++;
            overlapLength++;
            sumPrecision += (double) overlapLength / totalChars;
          }
        } else {
          // -1
          totalChars++;
        }
      }
    }
    int count = gsUriSpans.values().stream().flatMap(set -> set.asRanges().stream())
            .mapToInt(range -> range.upperEndpoint() - range.lowerEndpoint()).sum();
    return sumPrecision / count;
  }

  private static <T extends Passage> Map<String, RangeSet<Integer>> toUriSpans(
          Collection<T> passages) {
    Characteristics[] characters = new Collector.Characteristics[] {
        Collector.Characteristics.CONCURRENT, Collector.Characteristics.UNORDERED,
        Collector.Characteristics.IDENTITY_FINISH };
    Collector<Passage, RangeSet<Integer>, RangeSet<Integer>> collector = Collector
            .<Passage, RangeSet<Integer>>of(
                    () -> TreeRangeSet.create(),
                    (s, p) -> s.add(TypeUtil.spanRangeInSection(p)),
                    (s1, s2) -> {
                      s1.addAll(s2);
                      return s1;
                    }, characters);
    return passages.parallelStream().collect(groupingBy(Passage::getUri, collector));
  }

  public static <T extends Passage> double calculateAspectAveragePrecision(
          Collection<T> resultPassages, Collection<T> gsPassages) {
    return calculateAspectAveragePrecision(resultPassages, toUriSpanAspects(gsPassages));
  }

  public static <T extends Passage> double calculateAspectAveragePrecision(
          Collection<T> resultPassages, Map<String, RangeMap<Integer, String>> gsUriSpanAspects) {
    int numerator = 0;
    int denominator = 0;
    double sumPrecision = 0;
    Set<String> foundAspects = new HashSet<>();
    for (Passage resultPassage : resultPassages) {
      Range<Integer> resultRange = TypeUtil.spanRangeInSection(resultPassage);
      if (!gsUriSpanAspects.containsKey(resultPassage.getUri())) {
        continue;
      }
      RangeMap<Integer, String> gsSpanAspects = gsUriSpanAspects.get(resultPassage.getUri());
      RangeMap<Integer, String> overlapSpanAspects = gsSpanAspects.subRangeMap(resultRange);
      Set<String> overlapAspects = toSplitAspects(overlapSpanAspects.asMapOfRanges().values());
      if (overlapAspects.isEmpty()) {
        denominator++;
      } else {
        long numNewAspects = overlapAspects.stream().filter(a -> !foundAspects.contains(a)).count();
        if (numNewAspects > 0) {
          numerator++;
          denominator++;
          sumPrecision += numNewAspects * numerator / (double) denominator;
        }
        foundAspects.addAll(overlapAspects);
      }
    }
    Set<String> gsAspects = gsUriSpanAspects.values().stream()
            .flatMap(rangemap -> rangemap.asMapOfRanges().values().stream()).collect(toSet());
    return sumPrecision / toSplitAspects(gsAspects).size();
  }

  private static <T extends Passage> Map<String, RangeMap<Integer, String>> toUriSpanAspects(
          Collection<T> passages) {
    Characteristics[] characters = new Collector.Characteristics[] {
        Collector.Characteristics.CONCURRENT, Collector.Characteristics.UNORDERED,
        Collector.Characteristics.IDENTITY_FINISH };
    Collector<Passage, RangeMap<Integer, String>, RangeMap<Integer, String>> collector = Collector
            .<Passage, RangeMap<Integer, String>> of(
                    () -> TreeRangeMap.create(),
                    (s, p) -> s.put(TypeUtil.spanRangeInSection(p), p.getAspects()),
                    (s1, s2) -> {
                      s1.putAll(s2);
                      return s1;
                    }, characters);
    return passages.parallelStream().filter(p -> p.getAspects() != null)
            .collect(groupingBy(Passage::getUri, collector));
  }

  private static Set<String> toSplitAspects(Collection<String> aspects) {
    return aspects.parallelStream().flatMap(aspect -> Stream.of(aspect.split("\\|")))
            .collect(toSet());
  }

  @Override
  public String getName() {
    return "Trec";
  }

}
