package edu.cmu.lti.oaqa.baseqa.components.retrieval;

import edu.cmu.lti.oaqa.baseqa.data.gerp.DefaultEvidenceWrapper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.EvidenceWrapper;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.AbstractQueryWrapper;
import edu.cmu.lti.oaqa.baseqa.gerpphase.retrieval.AbstractQueryEvidencer;

public class IdenticalQueryEvidencer extends AbstractQueryEvidencer {

  @Override
  protected EvidenceWrapper<?, ?> evidence(AbstractQueryWrapper gerpable) {
    return new DefaultEvidenceWrapper(1.0f);
  }

}
