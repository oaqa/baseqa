package edu.cmu.lti.oaqa.gerp.core;

import edu.cmu.lti.oaqa.ecd.log.LogEntry;

public class GerpLogEntry implements LogEntry {

  private static enum Step {
    GENERATE, EVIDENCE, RANK, PRUNE, META
  };

  private Step step;

  private Class<?> outputType;

  private GerpLogEntry(Step step, Class<?> outputType) {
    this.step = step;
    this.outputType = outputType;
  }

  public static GerpLogEntry getGenerateLog(Class<?> outputType) {
    return new GerpLogEntry(Step.GENERATE, outputType);
  }

  public static GerpLogEntry getEvidenceLog(Class<?> outputType) {
    return new GerpLogEntry(Step.EVIDENCE, outputType);
  }

  public static GerpLogEntry getRankLog(Class<?> outputType) {
    return new GerpLogEntry(Step.RANK, outputType);
  }

  public static GerpLogEntry getPruneLog(Class<?> outputType) {
    return new GerpLogEntry(Step.PRUNE, outputType);
  }

  public static GerpLogEntry getMetaLog() {
    return new GerpLogEntry(Step.META, null);
  }

  @Override
  public String toString() {
    if (step.equals(Step.META)) {
      return "GERPER";
    } else {
      return step + "/" + outputType.getSimpleName();
    }
  }
}
