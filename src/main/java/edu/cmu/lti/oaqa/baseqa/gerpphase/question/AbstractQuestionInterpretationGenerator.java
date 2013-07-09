package edu.cmu.lti.oaqa.baseqa.gerpphase.question;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.cas.TOP;

import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.data.core.TopWrapper;
import edu.cmu.lti.oaqa.baseqa.data.kb.InterpretationWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.ParseWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.QuestionWrapper;
import edu.cmu.lti.oaqa.baseqa.gerpphase.core.generator.AbstractGenerator;

public abstract class AbstractQuestionInterpretationGenerator extends
        AbstractGenerator<InterpretationWrapper> {

  @SuppressWarnings("unchecked")
  @Override
  public List<Class<? extends TopWrapper<?>>> getRequiredInputTypes() {
    return Lists.<Class<? extends TopWrapper<?>>> newArrayList(QuestionWrapper.class,
            ParseWrapper.class);
  }

  @Override
  public InterpretationWrapper generate(List<? extends TopWrapper<? extends TOP>> input)
          throws AnalysisEngineProcessException {
    QuestionWrapper question = (QuestionWrapper) input.get(0);
    ParseWrapper parse = (ParseWrapper) input.get(1);
    return generate(question, parse);
  }

  protected abstract InterpretationWrapper generate(QuestionWrapper question, ParseWrapper parse);

}
