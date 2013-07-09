package edu.cmu.lti.oaqa.baseqa.gerpphase.parse;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.cas.TOP;

import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.data.core.TopWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.ParseWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.QuestionWrapper;
import edu.cmu.lti.oaqa.baseqa.gerpphase.core.generator.AbstractGenerator;

public abstract class AbstractQuestionParseGenerator extends AbstractGenerator<ParseWrapper> {

  @SuppressWarnings("unchecked")
  @Override
  public List<Class<? extends TopWrapper<?>>> getRequiredInputTypes() {
    return Lists.<Class<? extends TopWrapper<?>>> newArrayList(QuestionWrapper.class);
  }

  @Override
  public ParseWrapper generate(List<? extends TopWrapper<? extends TOP>> input)
          throws AnalysisEngineProcessException {
    QuestionWrapper question = (QuestionWrapper) input.get(0);
    return generate(question);
  }

  protected abstract ParseWrapper generate(QuestionWrapper question);

}
