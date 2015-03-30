package edu.cmu.lti.oaqa.baseqa.collection.candidate;

import java.util.List;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import edu.cmu.lti.oaqa.baseqa.util.ProviderCache;
import edu.cmu.lti.oaqa.baseqa.util.UimaContextHelper;
import edu.cmu.lti.oaqa.type.answer.Answer;
import edu.cmu.lti.oaqa.util.TypeUtil;

public class AnswerCandidateDecorator extends JCasAnnotator_ImplBase {

  private AnswerCandidatePersistenceProvider persistence;

  @Override
  public void initialize(UimaContext context) throws ResourceInitializationException {
    super.initialize(context);
    String pp = UimaContextHelper.getConfigParameterStringValue(context, "persistence-provider");
    this.persistence = ProviderCache.getProvider(pp, AnswerCandidatePersistenceProvider.class);
  }

  @Override
  public void process(JCas jcas) throws AnalysisEngineProcessException {
    String questionId = TypeUtil.getQuestion(jcas).getId();
    List<Answer> answerCandidates = persistence.getAnswerCandidates(questionId, jcas);
    answerCandidates.stream().forEach(Answer::addToIndexes);
  }

}
