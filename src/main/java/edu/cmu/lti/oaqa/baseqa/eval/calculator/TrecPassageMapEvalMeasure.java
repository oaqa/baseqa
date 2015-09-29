package edu.cmu.lti.oaqa.baseqa.eval.calculator;

import edu.cmu.lti.oaqa.baseqa.eval.Measure;

public enum TrecPassageMapEvalMeasure implements Measure {

  // PER-TOPIC MEASURES
  TREC_PASSAGE_MAP_COUNT, TREC_DOCUMENT_AVERAGE_PRECISION, TREC_PASSAGE_AVERAGE_PRECISION, TREC_PASSAGE2_AVERAGE_PRECISION, TREC_ASPECT_AVERAGE_PRECISION,

  // ACCUMULATED MEASURES
  TREC_DOCUMENT_MAP, TREC_PASSAGE_MAP, TREC_PASSAGE2_MAP, TREC_ASPECT_MAP;

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
