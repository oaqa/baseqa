package edu.cmu.lti.oaqa.baseqa.gerp.providers.interpretation;

import edu.cmu.lti.oaqa.baseqa.data.kb.InterpretationWrapper;
import edu.cmu.lti.oaqa.baseqa.gerp.providers.interpretation.AbstractQuestionInterpretationEvidencer;
import edu.cmu.lti.oaqa.gerp.data.DefaultEvidenceWrapper;
import edu.cmu.lti.oaqa.gerp.data.EvidenceWrapper;

public class IdenticalQuestionInterpretationEvidencer extends
        AbstractQuestionInterpretationEvidencer {

  @Override
  protected EvidenceWrapper<?, ?> evidence(InterpretationWrapper gerpable) {
    return new DefaultEvidenceWrapper(1.0f);
  }

}
