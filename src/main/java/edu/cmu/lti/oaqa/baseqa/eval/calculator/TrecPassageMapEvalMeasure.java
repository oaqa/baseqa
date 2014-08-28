package edu.cmu.lti.oaqa.baseqa.eval.calculator;

import edu.cmu.lti.oaqa.baseqa.eval.Measure;

public enum TrecPassageMapEvalMeasure implements Measure {

  // PER-TOPIC MEASURES
  DOCUMENT_AVERAGE_PRECISION, PASSAGE_AVERAGE_PRECISION, PASSAGE2_AVERAGE_PRECISION, 
  ASPECT_AVERAGE_PRECISION, TREC_PASSAGE_MAP_COUNT,

  // ACCUMULATED MEASURES
  DOCUMENT_MAP, PASSAGE_MAP, PASSAGE2_MAP, ASPECT_MAP;

  static {
    for (TrecPassageMapEvalMeasure measure : values()) {
      Measure.name2measure.put(measure.getName(), measure);
    }
  }

  @Override
  public String getName() {
    return name();
  }

}
