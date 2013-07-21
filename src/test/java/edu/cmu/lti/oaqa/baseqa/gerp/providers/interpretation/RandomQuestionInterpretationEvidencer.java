package edu.cmu.lti.oaqa.baseqa.gerp.providers.interpretation;

import java.util.Random;

import edu.cmu.lti.oaqa.baseqa.data.kb.InterpretationWrapper;
import edu.cmu.lti.oaqa.baseqa.gerp.providers.interpretation.AbstractQuestionInterpretationEvidencer;
import edu.cmu.lti.oaqa.gerp.data.DefaultEvidenceWrapper;
import edu.cmu.lti.oaqa.gerp.data.EvidenceWrapper;

public class RandomQuestionInterpretationEvidencer extends AbstractQuestionInterpretationEvidencer {

  private static Random random = new Random();

  @Override
  protected EvidenceWrapper<?, ?> evidence(InterpretationWrapper gerpable) {
    return new DefaultEvidenceWrapper(random.nextFloat());
  }

}
