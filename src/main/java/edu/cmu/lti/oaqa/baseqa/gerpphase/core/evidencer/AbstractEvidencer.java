package edu.cmu.lti.oaqa.baseqa.gerpphase.core.evidencer;

import com.google.common.reflect.TypeToken;

import edu.cmu.lti.oaqa.baseqa.data.gerp.Gerpable;
import edu.cmu.lti.oaqa.ecd.config.ConfigurableProvider;

public abstract class AbstractEvidencer<W extends Gerpable> extends ConfigurableProvider implements
        Evidencer<W> {

  protected TypeToken<W> type = new TypeToken<W>(getClass()) {

    private static final long serialVersionUID = 1L;
  
  };
  
  
  
}
