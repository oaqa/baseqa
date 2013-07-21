package edu.cmu.lti.oaqa.baseqa.gerp.providers.parse;

import edu.cmu.lti.oaqa.baseqa.data.nlp.ParseWrapper;
import edu.cmu.lti.oaqa.baseqa.gerp.providers.parse.AbstractQuestionParseEvidencer;
import edu.cmu.lti.oaqa.gerp.data.DefaultEvidenceWrapper;
import edu.cmu.lti.oaqa.gerp.data.EvidenceWrapper;

public class IdenticalQuestionParseEvidencer extends AbstractQuestionParseEvidencer {

  @Override
  protected EvidenceWrapper<?, ?> evidence(ParseWrapper gerpable) {
    return new DefaultEvidenceWrapper(1.0f);
  }

}
