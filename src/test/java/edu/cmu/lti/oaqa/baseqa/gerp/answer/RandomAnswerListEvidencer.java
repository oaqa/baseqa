package edu.cmu.lti.oaqa.baseqa.gerp.answer;

import java.util.Random;

import edu.cmu.lti.oaqa.baseqa.data.answer.AnswerListWrapper;
import edu.cmu.lti.oaqa.gerp.data.DefaultEvidenceWrapper;
import edu.cmu.lti.oaqa.gerp.data.EvidenceWrapper;

public class RandomAnswerListEvidencer extends AbstractAnswerListEvidencer {

  private static Random random = new Random();

  @Override
  protected EvidenceWrapper<?, ?> evidence(AnswerListWrapper gerpable) {
    return new DefaultEvidenceWrapper(random.nextFloat());
  }

}
