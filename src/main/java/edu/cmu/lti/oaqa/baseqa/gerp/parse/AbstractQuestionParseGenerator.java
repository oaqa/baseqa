package edu.cmu.lti.oaqa.baseqa.gerp.parse;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.cas.TOP;
import org.oaqa.model.input.Question;
import org.oaqa.model.nlp.Parse;

import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.data.nlp.ParseWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.QuestionWrapper;
import edu.cmu.lti.oaqa.core.data.TopWrapper;
import edu.cmu.lti.oaqa.gerp.core.AbstractGenerator;

public abstract class AbstractQuestionParseGenerator extends AbstractGenerator<Parse, ParseWrapper> {

  @Override
  public List<Integer> getRequiredInputTypes() {
    return Lists.newArrayList(Question.type);
  }

  @Override
  public ParseWrapper generate(List<? extends TopWrapper<? extends TOP>> inputs)
          throws AnalysisEngineProcessException {
    QuestionWrapper question = (QuestionWrapper) inputs.get(0);
    return generate(question);
  }

  protected abstract ParseWrapper generate(QuestionWrapper question)
          throws AnalysisEngineProcessException;

}
