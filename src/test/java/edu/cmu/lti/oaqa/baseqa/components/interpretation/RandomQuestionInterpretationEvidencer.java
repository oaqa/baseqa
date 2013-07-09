package edu.cmu.lti.oaqa.baseqa.components.interpretation;

import java.util.Random;

import edu.cmu.lti.oaqa.baseqa.data.gerp.DefaultEvidenceWrapper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.EvidenceWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.ParseWrapper;
import edu.cmu.lti.oaqa.baseqa.gerpphase.parse.AbstractQuestionParseEvidencer;

public class RandomQuestionInterpretationEvidencer extends AbstractQuestionParseEvidencer {

  private static Random random = new Random();

  @Override
  protected EvidenceWrapper<?, ?> evidence(ParseWrapper gerpable) {
    return new DefaultEvidenceWrapper(random.nextFloat());
  }

}
