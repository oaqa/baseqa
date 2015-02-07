package edu.cmu.lti.oaqa.baseqa.eval.calculator;

import static edu.cmu.lti.oaqa.baseqa.eval.EvalCalculatorUtil.calculateF1;
import static edu.cmu.lti.oaqa.baseqa.eval.EvalCalculatorUtil.calculatePrecision;
import static edu.cmu.lti.oaqa.baseqa.eval.EvalCalculatorUtil.calculateRecall;
import static edu.cmu.lti.oaqa.baseqa.eval.EvalCalculatorUtil.sumMeasurementValues;
import static edu.cmu.lti.oaqa.baseqa.eval.EvalCalculatorUtil.sumOfLogMeasurementValues;
import static edu.cmu.lti.oaqa.baseqa.eval.calculator.PassageMapEvalMeasure.PASSAGE_AVERAGE_PRECISION;
import static edu.cmu.lti.oaqa.baseqa.eval.calculator.PassageMapEvalMeasure.PASSAGE_F1;
import static edu.cmu.lti.oaqa.baseqa.eval.calculator.PassageMapEvalMeasure.PASSAGE_GMAP;
import static edu.cmu.lti.oaqa.baseqa.eval.calculator.PassageMapEvalMeasure.PASSAGE_MAP;
import static edu.cmu.lti.oaqa.baseqa.eval.calculator.PassageMapEvalMeasure.PASSAGE_MAP_COUNT;
import static edu.cmu.lti.oaqa.baseqa.eval.calculator.PassageMapEvalMeasure.PASSAGE_MEAN_F1;
import static edu.cmu.lti.oaqa.baseqa.eval.calculator.PassageMapEvalMeasure.PASSAGE_MEAN_PRECISION;
import static edu.cmu.lti.oaqa.baseqa.eval.calculator.PassageMapEvalMeasure.PASSAGE_MEAN_RECALL;
import static edu.cmu.lti.oaqa.baseqa.eval.calculator.PassageMapEvalMeasure.PASSAGE_PRECISION;
import static edu.cmu.lti.oaqa.baseqa.eval.calculator.PassageMapEvalMeasure.PASSAGE_RECALL;
import static java.util.stream.Collectors.toList;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;

import edu.cmu.lti.oaqa.baseqa.eval.EvalCalculator;
import edu.cmu.lti.oaqa.baseqa.eval.Measure;
import edu.cmu.lti.oaqa.ecd.config.ConfigurableProvider;
import edu.cmu.lti.oaqa.type.retrieval.Passage;

public class PassageMapEvalCalculator<T extends Passage> extends ConfigurableProvider implements
        EvalCalculator<T> {

  @Override
  public Map<Measure, Double> calculate(Collection<T> resultEvaluatees, Collection<T> gsEvaluatees,
          Comparator<T> comparator, Function<T, String> uniqueIdMapper) {
    List<Range<CharacterPosition>> resultList = resultEvaluatees.stream().sorted(comparator)
            .map(CharacterPosition::toRange).collect(toList());
    RangeSet<CharacterPosition> resultSet = resultList.stream().collect(
            () -> TreeRangeSet.create(), RangeSet::add, RangeSet::addAll);
    resultList.forEach(resultSet::add);
    RangeSet<CharacterPosition> gsSet = gsEvaluatees.stream().map(CharacterPosition::toRange)
            .collect(() -> TreeRangeSet.create(), RangeSet::add, RangeSet::addAll);
    int retrieved = countCharacters(resultSet);
    int relevant = countCharacters(gsSet);
    int relevantRetrieved = countCharacters(intersection(resultSet, gsSet));
    double precision = calculatePrecision(retrieved, relevantRetrieved);
    double recall = calculateRecall(relevant, relevantRetrieved);
    double f1 = calculateF1(precision, recall);
    double averagePrecision = calculatePassageAveragePrecision(resultList, gsSet);
    return ImmutableMap.<Measure, Double> builder().put(PASSAGE_MAP_COUNT, 1.0)
            .put(PASSAGE_PRECISION, precision).put(PASSAGE_RECALL, recall).put(PASSAGE_F1, f1)
            .put(PASSAGE_AVERAGE_PRECISION, averagePrecision).build();
  }

  @Override
  public Map<Measure, Double> accumulate(Map<Measure, ? extends Collection<Double>> measure2values) {
    double count = sumMeasurementValues(measure2values.get(PASSAGE_MAP_COUNT));
    double meanPrecision = sumMeasurementValues(measure2values.get(PASSAGE_PRECISION)) / count;
    double meanRecall = sumMeasurementValues(measure2values.get(PASSAGE_RECALL)) / count;
    double meanF1 = sumMeasurementValues(measure2values.get(PASSAGE_F1)) / count;
    double map = sumMeasurementValues(measure2values.get(PASSAGE_AVERAGE_PRECISION)) / count;
    double gmap = Math.exp(sumOfLogMeasurementValues(measure2values.get(PASSAGE_AVERAGE_PRECISION))
            / count);
    return ImmutableMap.<Measure, Double> builder().put(PASSAGE_MAP_COUNT, count)
            .put(PASSAGE_MEAN_PRECISION, meanPrecision).put(PASSAGE_MEAN_RECALL, meanRecall)
            .put(PASSAGE_MEAN_F1, meanF1).put(PASSAGE_MAP, map).put(PASSAGE_GMAP, gmap).build();
  }

  public static int countCharacters(RangeSet<CharacterPosition> ranges) {
    return ranges.asRanges().stream().filter(PassageMapEvalCalculator::isSameSection)
            .mapToInt(PassageMapEvalCalculator::countCharacters).sum();
  }

  public static boolean isSameSection(Range<CharacterPosition> range) {
    return range.lowerEndpoint().section.equals(range.upperEndpoint().section);
  }

  public static int countCharacters(Range<CharacterPosition> range) {
    return range.upperEndpoint().offset - range.lowerEndpoint().offset;
  }

  public static RangeSet<CharacterPosition> intersection(RangeSet<CharacterPosition> r1,
          RangeSet<CharacterPosition> r2) {
    RangeSet<CharacterPosition> inverse = TreeRangeSet.create(r1.complement());
    inverse.addAll(r2.complement());
    return inverse.complement();
  }

  public static double calculatePassageAveragePrecision(
          List<Range<CharacterPosition>> resultPassages, RangeSet<CharacterPosition> gsPassages) {
    double sumOfAveragePrecision = 0.0;
    double retrieved = 0.0;
    double relevantRetrieved = 0.0;
    for (Range<CharacterPosition> resultPassage : resultPassages) {
      retrieved += countCharacters(resultPassage);
      if (gsPassages.encloses(resultPassage)) {
        relevantRetrieved += countCharacters(gsPassages.subRangeSet(resultPassage));
        sumOfAveragePrecision += calculatePrecision(retrieved, relevantRetrieved);
      }
    }
    return sumOfAveragePrecision / gsPassages.asRanges().size();
  }

  @Override
  public String getName() {
    return "Passage";
  }

  private static class CharacterPosition implements Comparable<CharacterPosition> {

    private String uri;

    private String section;

    private int offset;

    private CharacterPosition(String uri, String section, int offset) {
      this.uri = uri;
      this.section = section;
      this.offset = offset;
    }

    private static Range<CharacterPosition> toRange(Passage passage) {
      return Range.closedOpen(
              new CharacterPosition(passage.getUri(), passage.getBeginSection(), passage
                      .getOffsetInBeginSection()),
              new CharacterPosition(passage.getUri(), passage.getEndSection(), passage
                      .getOffsetInEndSection()));
    }

    private static Comparator<CharacterPosition> passageSetComparator = Comparator
            .comparing(CharacterPosition::getUri).thenComparing(CharacterPosition::getSection)
            .thenComparingInt(CharacterPosition::getOffset);

    @Override
    public int compareTo(CharacterPosition o) {
      return passageSetComparator.compare(this, o);
    }

    @Override
    public String toString() {
      return uri + ":" + section + ":" + offset;
    }

    public String getUri() {
      return uri;
    }

    public String getSection() {
      return section;
    }

    public int getOffset() {
      return offset;
    }

  }

}
