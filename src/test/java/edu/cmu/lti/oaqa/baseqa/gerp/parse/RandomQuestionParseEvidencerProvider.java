package edu.cmu.lti.oaqa.baseqa.gerp.parse;

import java.util.Random;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;

import edu.cmu.lti.oaqa.baseqa.data.nlp.ParseWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.QuestionWrapper;
import edu.cmu.lti.oaqa.baseqa.gerp.parse.AbstractQuestionParseEvidencerProvider;
import edu.cmu.lti.oaqa.gerp.data.DefaultEvidenceWrapper;
import edu.cmu.lti.oaqa.gerp.data.EvidenceWrapper;

public class RandomQuestionParseEvidencerProvider extends AbstractQuestionParseEvidencerProvider {

  private static Random random = new Random();

  @Override
  protected EvidenceWrapper<?, ?> evidence(ParseWrapper parse, QuestionWrapper question)
          throws AnalysisEngineProcessException {
    return new DefaultEvidenceWrapper(random.nextFloat());
  }

}
