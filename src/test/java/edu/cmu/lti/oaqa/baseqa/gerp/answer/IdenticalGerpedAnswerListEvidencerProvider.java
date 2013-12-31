package edu.cmu.lti.oaqa.baseqa.gerp.answer;

import edu.cmu.lti.oaqa.baseqa.data.answer.AnswerWrapper;
import edu.cmu.lti.oaqa.gerp.data.DefaultEvidenceWrapper;
import edu.cmu.lti.oaqa.gerp.data.EvidenceWrapper;

public class IdenticalGerpedAnswerListEvidencerProvider extends AbstractAnswerEvidencerProvider {

  @Override
  protected EvidenceWrapper<?, ?> evidence(AnswerWrapper gerpable) {
    return new DefaultEvidenceWrapper(1f);
  }

}
