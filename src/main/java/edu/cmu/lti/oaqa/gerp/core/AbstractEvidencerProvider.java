package edu.cmu.lti.oaqa.gerp.core;

import com.google.common.reflect.TypeToken;

import edu.cmu.lti.oaqa.ecd.config.ConfigurableProvider;
import edu.cmu.lti.oaqa.gerp.data.Gerpable;

public abstract class AbstractEvidencerProvider<W extends Gerpable> extends ConfigurableProvider
        implements Evidencer<W> {

  public TypeToken<W> type = new TypeToken<W>(getClass()) {

    private static final long serialVersionUID = 1L;

  };

}
