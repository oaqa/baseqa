package edu.cmu.lti.oaqa.baseqa.components.interpretation;

import java.util.Random;

import edu.cmu.lti.oaqa.baseqa.data.gerp.DefaultEvidenceWrapper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.EvidenceWrapper;
import edu.cmu.lti.oaqa.baseqa.data.kb.InterpretationWrapper;
import edu.cmu.lti.oaqa.baseqa.gerpphase.interpretation.AbstractQuestionInterpretationEvidencer;

public class RandomQuestionInterpretationEvidencer extends AbstractQuestionInterpretationEvidencer {

  private static Random random = new Random();

  @Override
  protected EvidenceWrapper<?, ?> evidence(InterpretationWrapper gerpable) {
    return new DefaultEvidenceWrapper(random.nextFloat());
  }

}
