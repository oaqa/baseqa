package edu.cmu.lti.oaqa.baseqa.components.answer;

import java.util.Random;

import edu.cmu.lti.oaqa.baseqa.data.answer.AnswerListWrapper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.DefaultEvidenceWrapper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.EvidenceWrapper;
import edu.cmu.lti.oaqa.baseqa.gerpphase.answer.AbstractAnswerEvidencer;

public class RandomAnswerEvidencer extends AbstractAnswerEvidencer {

  private static Random random = new Random();

  @Override
  protected EvidenceWrapper<?, ?> evidence(AnswerListWrapper gerpable) {
    return new DefaultEvidenceWrapper(random.nextFloat());
  }

}
