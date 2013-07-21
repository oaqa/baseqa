package edu.cmu.lti.oaqa.baseqa.gerp.retrieval;

import java.util.List;

import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.data.kb.ConceptMentionWrapper;
import edu.cmu.lti.oaqa.baseqa.data.kb.InterpretationWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.ParseWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.QuestionWrapper;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.AbstractQueryWrapper;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.QueryConceptWrapper;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.QueryOperatorWrapper;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.QueryConceptWrapper.ConceptType;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.QueryOperatorWrapper.QueryOperatorName;
import edu.cmu.lti.oaqa.baseqa.gerp.retrieval.AbstractQueryGeneratorProvider;

public class ConceptAwareQueryGeneratorProvider extends AbstractQueryGeneratorProvider {

  @Override
  protected AbstractQueryWrapper generate(QuestionWrapper question, ParseWrapper parse,
          InterpretationWrapper interpretation) {
    List<QueryConceptWrapper> queryConcepts = Lists.newArrayList();
    for (ConceptMentionWrapper mention : interpretation.getMentions()) {
      queryConcepts.add(new QueryConceptWrapper(Lists.<String> newArrayList(),
              ConceptType.QATOKEN_TYPE, mention.getConcept().getName(), "",
              new QueryOperatorWrapper(QueryOperatorName.WEIGHT, Lists.newArrayList("1")), Lists
                      .<QueryConceptWrapper> newArrayList(), ""));
    }
    return new AbstractQueryWrapper(queryConcepts);
  }

}
