package edu.cmu.lti.oaqa.baseqa.gerp.parse;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;

import edu.cmu.lti.oaqa.baseqa.data.nlp.ParseWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.QuestionWrapper;
import edu.cmu.lti.oaqa.gerp.data.DefaultEvidenceWrapper;
import edu.cmu.lti.oaqa.gerp.data.EvidenceWrapper;

public class IdenticalQuestionParseEvidencer extends AbstractQuestionParseEvidencer {

  @Override
  protected EvidenceWrapper<?, ?> evidence(ParseWrapper parse, QuestionWrapper question)
          throws AnalysisEngineProcessException {
    return new DefaultEvidenceWrapper(1.0f);
  }

}
