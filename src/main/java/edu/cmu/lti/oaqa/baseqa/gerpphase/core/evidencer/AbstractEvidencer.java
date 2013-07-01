package edu.cmu.lti.oaqa.baseqa.gerpphase.core.evidencer;

import edu.cmu.lti.oaqa.baseqa.data.gerp.Gerpable;
import edu.cmu.lti.oaqa.ecd.config.ConfigurableProvider;

public abstract class AbstractEvidencer<W extends Gerpable> extends ConfigurableProvider implements
        Evidencer<W> {

}
