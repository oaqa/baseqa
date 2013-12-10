package edu.cmu.lti.oaqa.baseqa.gerp.answer;

import java.util.List;

import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.data.answer.AnswerListWrapper;
import edu.cmu.lti.oaqa.baseqa.data.answer.AnswerWrapper;
import edu.cmu.lti.oaqa.baseqa.data.kb.InterpretationWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.ParseWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.QuestionWrapper;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.AbstractQueryWrapper;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.QueryConceptWrapper;
import edu.cmu.lti.oaqa.gerp.data.DefaultEvidenceWrapper;
import edu.cmu.lti.oaqa.gerp.data.RankWrapper;

public class QueryTermAnswerGenerator extends AbstractAnswerGenerator {

  @Override
  protected AnswerListWrapper generate(QuestionWrapper question, ParseWrapper parse,
          InterpretationWrapper interpretation, AbstractQueryWrapper abstractQuery) {
    List<AnswerWrapper> answers = Lists.newArrayList();
    float answerConfidence = 1.0f / abstractQuery.getConcepts().size();
    for (QueryConceptWrapper queryConcept : abstractQuery.getConcepts()) {
      AnswerWrapper answer = new AnswerWrapper(queryConcept.getText(),
              Lists.<String> newArrayList());
      answer.addEvidence(new DefaultEvidenceWrapper(answerConfidence));
      answer.addRank(new RankWrapper(1, answerConfidence));
      answers.add(answer);
    }
    return new AnswerListWrapper(answers);
  }

}
