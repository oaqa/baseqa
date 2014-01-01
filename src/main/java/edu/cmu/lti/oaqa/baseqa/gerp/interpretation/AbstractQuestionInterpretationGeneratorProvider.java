package edu.cmu.lti.oaqa.baseqa.gerp.interpretation;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.cas.TOP;
import org.oaqa.model.input.Question;
import org.oaqa.model.nlp.Parse;

import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.data.kb.InterpretationWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.ParseWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.QuestionWrapper;
import edu.cmu.lti.oaqa.core.data.TopWrapper;
import edu.cmu.lti.oaqa.gerp.core.AbstractGeneratorProvider;

public abstract class AbstractQuestionInterpretationGeneratorProvider extends
        AbstractGeneratorProvider<InterpretationWrapper> {

  @Override
  public List<Integer> getRequiredInputTypes() {
    return Lists.newArrayList(Question.type, Parse.type);
  }

  @Override
  public InterpretationWrapper generate(List<? extends TopWrapper<? extends TOP>> inputs)
          throws AnalysisEngineProcessException {
    QuestionWrapper question = (QuestionWrapper) inputs.get(0);
    ParseWrapper parse = (ParseWrapper) inputs.get(1);
    return generate(question, parse);
  }

  protected abstract InterpretationWrapper generate(QuestionWrapper question, ParseWrapper parse)
          throws AnalysisEngineProcessException;

}
