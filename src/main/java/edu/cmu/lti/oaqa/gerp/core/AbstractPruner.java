package edu.cmu.lti.oaqa.gerp.core;

import edu.cmu.lti.oaqa.ecd.log.AbstractLoggedComponent;

public abstract class AbstractPruner extends AbstractLoggedComponent implements Pruner {

  protected void log(String message) {
    super.log(GerpLogEntry.getPruneLog(null), message);
  }
}
