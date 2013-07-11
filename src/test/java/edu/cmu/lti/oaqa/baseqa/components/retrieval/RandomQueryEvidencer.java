package edu.cmu.lti.oaqa.baseqa.components.retrieval;

import java.util.Random;

import edu.cmu.lti.oaqa.baseqa.data.gerp.DefaultEvidenceWrapper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.EvidenceWrapper;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.AbstractQueryWrapper;
import edu.cmu.lti.oaqa.baseqa.gerpphase.retrieval.AbstractQueryEvidencer;

public class RandomQueryEvidencer extends AbstractQueryEvidencer {

  private static Random random = new Random();

  @Override
  protected EvidenceWrapper<?, ?> evidence(AbstractQueryWrapper gerpable) {
    return new DefaultEvidenceWrapper(random.nextFloat());
  }

}
