package edu.cmu.lti.oaqa.baseqa.gerpphase.core.generator;

import java.util.List;

import edu.cmu.lti.oaqa.baseqa.data.core.TopWrapper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.Gerpable;
import edu.cmu.lti.oaqa.ecd.config.ConfigurableProvider;

public abstract class AbstractGenerator<W extends Gerpable> extends ConfigurableProvider implements
        Generator<W> {

  public abstract List<Class<? extends TopWrapper<?>>> getRequiredInputTypes();

}
