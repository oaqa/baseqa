package edu.cmu.lti.oaqa.baseqa.gerp.providers.retrieval;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.cas.TOP;
import org.oaqa.model.input.Question;
import org.oaqa.model.kb.Interpretation;
import org.oaqa.model.nlp.Parse;

import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.data.kb.InterpretationWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.ParseWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.QuestionWrapper;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.AbstractQueryWrapper;
import edu.cmu.lti.oaqa.core.data.TopWrapper;
import edu.cmu.lti.oaqa.gerp.providers.generator.AbstractGenerator;

public abstract class AbstractQueryGenerator extends AbstractGenerator<AbstractQueryWrapper> {

  @Override
  public List<Integer> getRequiredInputTypes() {
    return Lists.newArrayList(Question.type, Parse.type, Interpretation.type);
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
