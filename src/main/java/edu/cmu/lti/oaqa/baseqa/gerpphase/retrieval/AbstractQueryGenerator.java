package edu.cmu.lti.oaqa.baseqa.gerpphase.retrieval;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.cas.TOP;

import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.data.core.TopWrapper;
import edu.cmu.lti.oaqa.baseqa.data.kb.InterpretationWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.ParseWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.QuestionWrapper;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.AbstractQueryWrapper;
import edu.cmu.lti.oaqa.baseqa.gerpphase.core.generator.AbstractGenerator;

public abstract class AbstractQueryGenerator extends
        AbstractGenerator<AbstractQueryWrapper> {

  @SuppressWarnings("unchecked")
  @Override
  public List<Class<? extends TopWrapper<?>>> getRequiredInputTypes() {
    return Lists.<Class<? extends TopWrapper<?>>> newArrayList(QuestionWrapper.class,
            ParseWrapper.class, InterpretationWrapper.class);
  }

  @Override
  public AbstractQueryWrapper generate(List<? extends TopWrapper<? extends TOP>> input)
          throws AnalysisEngineProcessException {
    QuestionWrapper question = (QuestionWrapper) input.get(0);
    ParseWrapper parse = (ParseWrapper) input.get(1);
    InterpretationWrapper interpretation = (InterpretationWrapper) input.get(2);
    return generate(question, parse, interpretation);
  }

  protected abstract AbstractQueryWrapper generate(QuestionWrapper question, ParseWrapper parse,
          InterpretationWrapper interpretation);

}
