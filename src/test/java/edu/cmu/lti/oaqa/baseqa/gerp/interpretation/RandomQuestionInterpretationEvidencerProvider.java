package edu.cmu.lti.oaqa.baseqa.gerp.interpretation;

import java.util.Random;

import edu.cmu.lti.oaqa.baseqa.data.kb.InterpretationWrapper;
import edu.cmu.lti.oaqa.baseqa.gerp.interpretation.AbstractQuestionInterpretationEvidencerProvider;
import edu.cmu.lti.oaqa.gerp.data.DefaultEvidenceWrapper;
import edu.cmu.lti.oaqa.gerp.data.EvidenceWrapper;

public class RandomQuestionInterpretationEvidencerProvider extends
        AbstractQuestionInterpretationEvidencerProvider {

  private static Random random = new Random();

  @Override
  protected EvidenceWrapper<?, ?> evidence(InterpretationWrapper gerpable) {
    return new DefaultEvidenceWrapper(random.nextFloat());
  }

}
