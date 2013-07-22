package edu.cmu.lti.oaqa.baseqa.gerp.interpretation;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.data.kb.ConceptMentionWrapper;
import edu.cmu.lti.oaqa.baseqa.data.kb.ConceptWrapper;
import edu.cmu.lti.oaqa.baseqa.data.kb.InterpretationWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.ParseWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.QuestionWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.TokenWrapper;

public class DummyQuestionInterpretationGenerator extends AbstractQuestionInterpretationGenerator {

  private static Random random = new Random();

  @Override
  protected InterpretationWrapper generate(QuestionWrapper question, ParseWrapper parse) {
    ConceptWrapper a = new ConceptWrapper("A", Lists.<String> newArrayList(),
            Lists.<ConceptMentionWrapper> newArrayList());
    ConceptWrapper b = new ConceptWrapper("B", Lists.<String> newArrayList(),
            Lists.<ConceptMentionWrapper> newArrayList());
    List<ConceptWrapper> concepts = Lists.newArrayList(a, b);
    List<ConceptMentionWrapper> mentions = Lists.newArrayList();
    for (TokenWrapper token : parse.getTokens()) {
      ConceptWrapper concept = random.nextBoolean() ? a : b;
      ConceptMentionWrapper mention = new ConceptMentionWrapper(token.getBegin(), token.getEnd(),
              concept);
      mentions.add(mention);
      concept.getMentions().add(mention);
    }
    return new InterpretationWrapper(concepts, mentions);
  }
}
