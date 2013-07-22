package edu.cmu.lti.oaqa.baseqa.gerp.parse;

import java.util.Random;

import edu.cmu.lti.oaqa.baseqa.data.nlp.ParseWrapper;
import edu.cmu.lti.oaqa.gerp.data.DefaultEvidenceWrapper;
import edu.cmu.lti.oaqa.gerp.data.EvidenceWrapper;

public class RandomQuestionParseEvidencer extends AbstractQuestionParseEvidencer {

  private static Random random = new Random();

  @Override
  protected EvidenceWrapper<?, ?> evidence(ParseWrapper gerpable) {
    return new DefaultEvidenceWrapper(random.nextFloat());
  }

}
