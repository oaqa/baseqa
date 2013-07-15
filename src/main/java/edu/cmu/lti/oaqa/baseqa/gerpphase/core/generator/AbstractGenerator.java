package edu.cmu.lti.oaqa.baseqa.gerpphase.core.generator;

import java.util.List;

import com.google.common.reflect.TypeToken;

import edu.cmu.lti.oaqa.baseqa.data.gerp.Gerpable;
import edu.cmu.lti.oaqa.ecd.config.ConfigurableProvider;

public abstract class AbstractGenerator<W extends Gerpable> extends ConfigurableProvider implements
        Generator<W> {

  public abstract List<Integer> getRequiredInputTypes();

  public TypeToken<W> type = new TypeToken<W>(getClass()) {

    private static final long serialVersionUID = 1L;

  };

}
