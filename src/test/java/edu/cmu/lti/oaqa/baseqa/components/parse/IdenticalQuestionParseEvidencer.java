package edu.cmu.lti.oaqa.baseqa.components.parse;

import edu.cmu.lti.oaqa.baseqa.data.gerp.DefaultEvidenceWrapper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.EvidenceWrapper;
import edu.cmu.lti.oaqa.baseqa.data.kb.InterpretationWrapper;
import edu.cmu.lti.oaqa.baseqa.gerpphase.interpretation.AbstractQuestionInterpretationEvidencer;

public class IdenticalQuestionParseEvidencer extends AbstractQuestionInterpretationEvidencer {

  @Override
  protected EvidenceWrapper<?, ?> evidence(InterpretationWrapper gerpable) {
    return new DefaultEvidenceWrapper(1.0f);
  }

}
