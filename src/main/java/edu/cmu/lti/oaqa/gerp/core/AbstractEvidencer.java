package edu.cmu.lti.oaqa.gerp.core;

import com.google.common.reflect.TypeToken;

import edu.cmu.lti.oaqa.ecd.log.AbstractLoggedComponent;
import edu.cmu.lti.oaqa.gerp.data.Gerpable;

public abstract class AbstractEvidencer<W extends Gerpable> extends AbstractLoggedComponent
        implements Evidencer<W> {

  public TypeToken<W> type = new TypeToken<W>(getClass()) {

    private static final long serialVersionUID = 1L;

  };

  protected void log(String message) {
    super.log(GerpLogEntry.getEvidenceLog(type.getClass()), message);
  };

}
