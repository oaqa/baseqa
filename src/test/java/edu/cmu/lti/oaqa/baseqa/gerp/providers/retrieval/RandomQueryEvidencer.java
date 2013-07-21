package edu.cmu.lti.oaqa.baseqa.gerp.providers.retrieval;

import java.util.Random;

import edu.cmu.lti.oaqa.baseqa.data.retrieval.AbstractQueryWrapper;
import edu.cmu.lti.oaqa.baseqa.gerp.providers.retrieval.AbstractQueryEvidencer;
import edu.cmu.lti.oaqa.gerp.data.DefaultEvidenceWrapper;
import edu.cmu.lti.oaqa.gerp.data.EvidenceWrapper;

public class RandomQueryEvidencer extends AbstractQueryEvidencer {

  private static Random random = new Random();

  @Override
  protected EvidenceWrapper<?, ?> evidence(AbstractQueryWrapper gerpable) {
    return new DefaultEvidenceWrapper(random.nextFloat());
  }

}
