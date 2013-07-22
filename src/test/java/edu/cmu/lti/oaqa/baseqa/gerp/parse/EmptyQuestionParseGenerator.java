package edu.cmu.lti.oaqa.baseqa.gerp.parse;

import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.data.nlp.ParseWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.QuestionWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.SemanticRoleWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.TokenWrapper;

public class EmptyQuestionParseGenerator extends AbstractQuestionParseGenerator {

  @Override
  protected ParseWrapper generate(QuestionWrapper question) {
    ParseWrapper parse = new ParseWrapper(Lists.<TokenWrapper> newArrayList(),
            Lists.<SemanticRoleWrapper> newArrayList());
    return parse;
  }
}