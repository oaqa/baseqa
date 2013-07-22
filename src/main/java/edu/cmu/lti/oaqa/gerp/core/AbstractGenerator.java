package edu.cmu.lti.oaqa.gerp.core;

import java.util.List;

import com.google.common.reflect.TypeToken;

import edu.cmu.lti.oaqa.ecd.log.AbstractLoggedComponent;
import edu.cmu.lti.oaqa.gerp.data.Gerpable;

public abstract class AbstractGenerator<W extends Gerpable> extends AbstractLoggedComponent
        implements Generator<W> {

  public abstract List<Integer> getRequiredInputTypes();

  public TypeToken<W> type = new TypeToken<W>(getClass()) {

    private static final long serialVersionUID = 1L;

  };

  protected void log(String message) {
    super.log(GerpLogEntry.getGenerateLog(type.getClass()), message);
  };
}
