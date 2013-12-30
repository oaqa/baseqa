package edu.cmu.lti.oaqa.baseqa.gerp.answer;

import edu.cmu.lti.oaqa.baseqa.data.answer.AnswerListWrapper;
import edu.cmu.lti.oaqa.gerp.data.DefaultEvidenceWrapper;
import edu.cmu.lti.oaqa.gerp.data.EvidenceWrapper;

public class IdenticalAnswerListEvidencer extends AbstractAnswerListEvidencer {

  @Override
  protected EvidenceWrapper<?, ?> evidence(AnswerListWrapper gerpable) {
    return new DefaultEvidenceWrapper(1.0f);
  }

}
