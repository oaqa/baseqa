package edu.cmu.lti.oaqa.baseqa.gerp.answer;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.cas.TOP;
import org.oaqa.model.input.Question;
import org.oaqa.model.kb.Interpretation;
import org.oaqa.model.nlp.Parse;
import org.oaqa.model.retrieval.AbstractQuery;

import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.data.answer.AnswerListWrapper;
import edu.cmu.lti.oaqa.baseqa.data.kb.InterpretationWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.ParseWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.QuestionWrapper;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.AbstractQueryWrapper;
import edu.cmu.lti.oaqa.core.data.TopWrapper;
import edu.cmu.lti.oaqa.gerp.core.AbstractGeneratorProvider;

public abstract class AbstractAnswerGeneratorProvider extends
        AbstractGeneratorProvider<AnswerListWrapper> {

  @Override
  public List<Integer> getRequiredInputTypes() {
    return Lists.newArrayList(Question.type, Parse.type, Interpretation.type, AbstractQuery.type);
  }

  @Override
  public AnswerListWrapper generate(List<? extends TopWrapper<? extends TOP>> input)
          throws AnalysisEngineProcessException {
    QuestionWrapper question = (QuestionWrapper) input.get(0);
    ParseWrapper parse = (ParseWrapper) input.get(1);
    InterpretationWrapper interpretation = (InterpretationWrapper) input.get(2);
    AbstractQueryWrapper abstractQuery = (AbstractQueryWrapper) input.get(3);
    return generate(question, parse, interpretation, abstractQuery);
  }

  protected abstract AnswerListWrapper generate(QuestionWrapper question, ParseWrapper parse,
          InterpretationWrapper interpretation, AbstractQueryWrapper abstractQuery);

}
