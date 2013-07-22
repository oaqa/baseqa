package edu.cmu.lti.oaqa.gerp.core;

import edu.cmu.lti.oaqa.ecd.log.AbstractLoggedComponent;

public abstract class AbstractRanker extends AbstractLoggedComponent implements Ranker {

  protected void log(String message) {
    super.log(GerpLogEntry.getRankLog(null), message);
  }
}
