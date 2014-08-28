package edu.cmu.lti.oaqa.baseqa.eval.calculator;

import edu.cmu.lti.oaqa.baseqa.eval.Measure;

public enum RetrievalEvalMeasure implements Measure {

  // PER-TOPIC MEASURES
  RELEVANT_RETRIEVED, RETRIEVED, RELEVANT, AVERAGE_PRECISION, BINARY_RELEVANT, RETRIEVAL_COUNT,

  // ACCUMULATED MEASURES
  PRECISION, RECALL, F1, MAP, BINARY_RECALL;

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
