package edu.cmu.lti.oaqa.baseqa.gerp.answer;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.cas.TOP;
import org.oaqa.model.answer.Answer;
import org.oaqa.model.input.Question;
import org.oaqa.model.kb.Interpretation;
import org.oaqa.model.nlp.Parse;
import org.oaqa.model.retrieval.AbstractQuery;

import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.data.answer.AnswerWrapper;
import edu.cmu.lti.oaqa.baseqa.data.kb.InterpretationWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.ParseWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.QuestionWrapper;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.AbstractQueryWrapper;
import edu.cmu.lti.oaqa.core.data.TopWrapper;
import edu.cmu.lti.oaqa.gerp.core.AbstractIndependentEvidencer;
import edu.cmu.lti.oaqa.gerp.data.EvidenceWrapper;

public abstract class AbstractAnswerEvidencer extends
        AbstractIndependentEvidencer<Answer, AnswerWrapper> {

  @Override
  public List<Integer> getRequiredInputTypes() {
    return Lists.newArrayList(Question.type, Parse.type, Interpretation.type, AbstractQuery.type);
  }

  @Override
  protected EvidenceWrapper<?, ?> evidence(AnswerWrapper answer,
          List<? extends TopWrapper<? extends TOP>> inputs) throws AnalysisEngineProcessException {
    QuestionWrapper question = (QuestionWrapper) inputs.get(0);
    ParseWrapper parse = (ParseWrapper) inputs.get(1);
    InterpretationWrapper interpretation = (InterpretationWrapper) inputs.get(2);
    AbstractQueryWrapper abstractQuery = (AbstractQueryWrapper) inputs.get(3);
    return evidence(answer, question, parse, interpretation, abstractQuery);
  }

  protected abstract EvidenceWrapper<?, ?> evidence(AnswerWrapper answer, QuestionWrapper question,
          ParseWrapper parse, InterpretationWrapper interpretation,
          AbstractQueryWrapper abstractQuery) throws AnalysisEngineProcessException;

}
