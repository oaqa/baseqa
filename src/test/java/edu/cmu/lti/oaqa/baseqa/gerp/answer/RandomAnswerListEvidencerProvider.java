package edu.cmu.lti.oaqa.baseqa.gerp.answer;

import java.util.Random;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;

import edu.cmu.lti.oaqa.baseqa.data.answer.AnswerListWrapper;
import edu.cmu.lti.oaqa.baseqa.data.kb.InterpretationWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.ParseWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.QuestionWrapper;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.AbstractQueryWrapper;
import edu.cmu.lti.oaqa.baseqa.gerp.answer.AbstractAnswerListEvidencerProvider;
import edu.cmu.lti.oaqa.gerp.data.DefaultEvidenceWrapper;
import edu.cmu.lti.oaqa.gerp.data.EvidenceWrapper;

public class RandomAnswerListEvidencerProvider extends AbstractAnswerListEvidencerProvider {

  private static Random random = new Random();

  @Override
  protected EvidenceWrapper<?, ?> evidence(AnswerListWrapper answerList, QuestionWrapper question,
          ParseWrapper parse, InterpretationWrapper interpretation,
          AbstractQueryWrapper abstractQuery) throws AnalysisEngineProcessException {
    return new DefaultEvidenceWrapper(random.nextFloat());
  }

}
