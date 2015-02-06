package edu.cmu.lti.oaqa.baseqa.eval.calculator;

import edu.cmu.lti.oaqa.baseqa.eval.Measure;

public enum RetrievalEvalMeasure implements Measure {

  // PER-TOPIC MEASURES
  RETRIEVAL_COUNT, RETRIEVED, RELEVANT, RELEVANT_RETRIEVED, BINARY_RELEVANT, PRECISION, RECALL, F1, AVERAGE_PRECISION,

  // ACCUMULATED MEASURES
  MEAN_PRECISION, MEAN_RECALL, MEAN_BINARY_RECALL, MEAN_F1, MAP, GMAP;

  static {
    for (RetrievalEvalMeasure measure : values()) {
      Measure.name2measure.put(measure.getName(), measure);
    }
  }

  @Override
  public String getName() {
    return name();
  }

}
