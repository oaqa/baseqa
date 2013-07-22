package edu.cmu.lti.oaqa.baseqa.gerp.answer;

import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.data.answer.AnswerListWrapper;
import edu.cmu.lti.oaqa.baseqa.data.answer.AnswerWrapper;
import edu.cmu.lti.oaqa.baseqa.data.kb.InterpretationWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.ParseWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.QuestionWrapper;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.AbstractQueryWrapper;

public class RandomAnswerGenerator extends AbstractAnswerGenerator {

  @Override
  protected AnswerListWrapper generate(QuestionWrapper question, ParseWrapper parse,
          InterpretationWrapper interpretation, AbstractQueryWrapper abstractQuery) {
    return new AnswerListWrapper(Lists.newArrayList(
            new AnswerWrapper("ABC", Lists.<String> newArrayList()),
            new AnswerWrapper("DEF", Lists.<String> newArrayList())));
  }

}
