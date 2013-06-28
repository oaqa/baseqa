package edu.cmu.lti.oaqa.baseqa.gerpphase.generator;

import edu.cmu.lti.oaqa.baseqa.data.gerp.Gerpable;
import edu.cmu.lti.oaqa.ecd.config.ConfigurableProvider;

public abstract class AbstractGenerator<W extends Gerpable> extends ConfigurableProvider implements
        Generator<W> {

}
