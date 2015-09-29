package edu.cmu.lti.oaqa.baseqa.eval;

import java.util.List;
import java.util.Map;

import org.apache.uima.resource.Resource;

import com.google.common.collect.Table;

import edu.cmu.lti.oaqa.framework.eval.ExperimentKey;
import edu.cmu.lti.oaqa.framework.eval.Key;

public interface EvalPeristenceProvider extends Resource {

  void insertPartialMeasurements(Key key, String sequenceId, String calculatorName,
          String evaluateeName, Map<Measure, Double> measure2value);

  Table<Key, Measure, List<Double>> selectPartialMeasurements(ExperimentKey experiment,
          String calculatorName, String evaluateeName);

  void deletePartialMeasurements(Key key, String sequenceId, String calculatorName,
          String evaluateeName);

  void insertAccumulatedMeasurements(Key key, String calculatorName, String evaluateeName,
          Map<Measure, Double> measure2value);

  void deleteAccumulatedMeasurements(ExperimentKey experiment, String calculatorName,
          String evaluateeName);

}
