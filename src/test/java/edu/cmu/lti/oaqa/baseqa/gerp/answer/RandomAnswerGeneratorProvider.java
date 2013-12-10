package edu.cmu.lti.oaqa.baseqa.gerp.answer;

import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.data.answer.AnswerListWrapper;
import edu.cmu.lti.oaqa.baseqa.data.answer.AnswerWrapper;
import edu.cmu.lti.oaqa.baseqa.data.kb.InterpretationWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.ParseWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.QuestionWrapper;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.AbstractQueryWrapper;
import edu.cmu.lti.oaqa.baseqa.gerp.answer.AbstractAnswerGeneratorProvider;
import edu.cmu.lti.oaqa.gerp.data.DefaultEvidenceWrapper;
import edu.cmu.lti.oaqa.gerp.data.RankWrapper;

public class RandomAnswerGeneratorProvider extends AbstractAnswerGeneratorProvider {

  @Override
  protected AnswerListWrapper generate(QuestionWrapper question, ParseWrapper parse,
          InterpretationWrapper interpretation, AbstractQueryWrapper abstractQuery) {
    AnswerWrapper abc = new AnswerWrapper("ABC", Lists.<String> newArrayList());
    double randomConfidence = Math.random() * 0.5 + 0.5;
    abc.addEvidence(new DefaultEvidenceWrapper((float) randomConfidence));
    abc.addRank(new RankWrapper(1, (float) randomConfidence));
    AnswerWrapper def = new AnswerWrapper("DEF", Lists.<String> newArrayList());
    randomConfidence = Math.random() * 0.5;
    def.addEvidence(new DefaultEvidenceWrapper((float) randomConfidence));
    def.addRank(new RankWrapper(1, (float) randomConfidence));
    return new AnswerListWrapper(Lists.newArrayList(abc, def));
  }

}
