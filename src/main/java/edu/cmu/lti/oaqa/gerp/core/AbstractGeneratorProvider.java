package edu.cmu.lti.oaqa.gerp.core;

import java.util.List;

import com.google.common.reflect.TypeToken;

import edu.cmu.lti.oaqa.ecd.config.ConfigurableProvider;
import edu.cmu.lti.oaqa.gerp.data.Gerpable;

public abstract class AbstractGeneratorProvider<W extends Gerpable> extends ConfigurableProvider
        implements Generator<W> {

  public abstract List<Integer> getRequiredInputTypes();

  public TypeToken<W> wrapperType = new TypeToken<W>(getClass()) {

    private static final long serialVersionUID = 1L;

  };

}
