package edu.cmu.lti.oaqa.baseqa.eval.calculator;

import edu.cmu.lti.oaqa.baseqa.eval.Measure;

public enum PassageMapEvalMeasure implements Measure {

  // PER-TOPIC MEASURES
  PASSAGE_MAP_COUNT, PASSAGE_PRECISION, PASSAGE_RECALL, PASSAGE_F1, PASSAGE_AVERAGE_PRECISION,

  // ACCUMULATED MEASURES
  PASSAGE_MEAN_PRECISION, PASSAGE_MEAN_RECALL, PASSAGE_MEAN_F1, PASSAGE_MAP, PASSAGE_GMAP;

  static {
    for (PassageMapEvalMeasure measure : values()) {
      Measure.name2measure.put(measure.getName(), measure);
    }
  }

  @Override
  public String getName() {
    return name();
  }

}
