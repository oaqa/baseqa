package edu.cmu.lti.oaqa.baseqa.gerp.providers.retrieval;

import edu.cmu.lti.oaqa.baseqa.data.retrieval.AbstractQueryWrapper;
import edu.cmu.lti.oaqa.baseqa.gerp.providers.retrieval.AbstractQueryEvidencer;
import edu.cmu.lti.oaqa.gerp.data.DefaultEvidenceWrapper;
import edu.cmu.lti.oaqa.gerp.data.EvidenceWrapper;

public class IdenticalQueryEvidencer extends AbstractQueryEvidencer {

  @Override
  protected EvidenceWrapper<?, ?> evidence(AbstractQueryWrapper gerpable) {
    return new DefaultEvidenceWrapper(1.0f);
  }

}
