package edu.cmu.lti.oaqa.baseqa.gerp.interpretation;

import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.data.kb.ConceptMentionWrapper;
import edu.cmu.lti.oaqa.baseqa.data.kb.ConceptWrapper;
import edu.cmu.lti.oaqa.baseqa.data.kb.InterpretationWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.ParseWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.QuestionWrapper;
import edu.cmu.lti.oaqa.baseqa.gerp.interpretation.AbstractQuestionInterpretationGeneratorProvider;

public class EmptyQuestionInterpretationGeneratorProvider extends
        AbstractQuestionInterpretationGeneratorProvider {

  @Override
  protected InterpretationWrapper generate(QuestionWrapper question, ParseWrapper parse) {
    return new InterpretationWrapper(Lists.<ConceptWrapper> newArrayList(),
            Lists.<ConceptMentionWrapper> newArrayList());
  }

}
