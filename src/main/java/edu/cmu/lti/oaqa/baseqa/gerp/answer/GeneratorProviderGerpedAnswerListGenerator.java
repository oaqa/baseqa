package edu.cmu.lti.oaqa.baseqa.gerp.answer;

import java.util.List;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.resource.ResourceInitializationException;

import edu.cmu.lti.oaqa.baseqa.data.answer.AnswerWrapper;
import edu.cmu.lti.oaqa.baseqa.data.kb.InterpretationWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.ParseWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.QuestionWrapper;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.AbstractQueryWrapper;
import edu.cmu.lti.oaqa.ecd.BaseExperimentBuilder;

public class GeneratorProviderGerpedAnswerListGenerator extends GerpedAnswerListGenerator {

  private AbstractAnswerListGeneratorProvider generator;

  @Override
  public void initialize(UimaContext c) throws ResourceInitializationException {
    super.initialize(c);
    String generatorName = (String) c.getConfigParameterValue("generator");
    generator = BaseExperimentBuilder.loadProvider(generatorName,
            AbstractAnswerListGeneratorProvider.class);
  }

  @Override
  protected List<AnswerWrapper> getAnswerCandidates(QuestionWrapper question, ParseWrapper parse,
          InterpretationWrapper interpretation, AbstractQueryWrapper abstractQuery)
          throws AnalysisEngineProcessException {
    return generator.generate(question, parse, interpretation, abstractQuery).getAnswerList();
  }

}
