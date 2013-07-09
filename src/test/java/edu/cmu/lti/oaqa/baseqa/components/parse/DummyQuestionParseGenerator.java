package edu.cmu.lti.oaqa.baseqa.components.parse;

import java.util.List;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.data.nlp.ParseWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.QuestionWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.SemanticRoleWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.TokenWrapper;
import edu.cmu.lti.oaqa.baseqa.gerpphase.parse.AbstractQuestionParseGenerator;

public class DummyQuestionParseGenerator extends AbstractQuestionParseGenerator {

  @Override
  protected ParseWrapper generate(QuestionWrapper question) {
    List<TokenWrapper> tokens = Lists.newArrayList();
    for (String seg : Splitter.on(" ").split(question.getText())) {
      tokens.add(new TokenWrapper(0, 0, Lists.<TokenWrapper> newArrayList(), Lists
              .<String> newArrayList(), null, new String(), new String(), seg.toLowerCase(), false,
              false, new String()));
    }
    ParseWrapper parse = new ParseWrapper(tokens, Lists.<SemanticRoleWrapper> newArrayList());
    return parse;
  }

}
