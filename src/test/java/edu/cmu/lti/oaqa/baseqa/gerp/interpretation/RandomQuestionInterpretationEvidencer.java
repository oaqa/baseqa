package edu.cmu.lti.oaqa.baseqa.gerp.interpretation;

import java.util.Random;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;

import edu.cmu.lti.oaqa.baseqa.data.kb.InterpretationWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.ParseWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.QuestionWrapper;
import edu.cmu.lti.oaqa.gerp.data.DefaultEvidenceWrapper;
import edu.cmu.lti.oaqa.gerp.data.EvidenceWrapper;

public class RandomQuestionInterpretationEvidencer extends AbstractQuestionInterpretationEvidencer {

  private static Random random = new Random();

  @Override
  protected EvidenceWrapper<?, ?> evidence(InterpretationWrapper interpretation,
          QuestionWrapper question, ParseWrapper parse) throws AnalysisEngineProcessException {
    return new DefaultEvidenceWrapper(random.nextFloat());
  }

}
