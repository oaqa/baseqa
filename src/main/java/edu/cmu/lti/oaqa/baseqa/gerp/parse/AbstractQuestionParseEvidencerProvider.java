package edu.cmu.lti.oaqa.baseqa.gerp.parse;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.cas.TOP;
import org.oaqa.model.input.Question;

import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.data.nlp.ParseWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.QuestionWrapper;
import edu.cmu.lti.oaqa.core.data.TopWrapper;
import edu.cmu.lti.oaqa.gerp.core.AbstractIndependentEvidencerProvider;
import edu.cmu.lti.oaqa.gerp.data.EvidenceWrapper;

public abstract class AbstractQuestionParseEvidencerProvider extends
        AbstractIndependentEvidencerProvider<ParseWrapper> {

  @Override
  public List<Integer> getRequiredInputTypes() {
    return Lists.newArrayList(Question.type);
  }

  @Override
  protected EvidenceWrapper<?, ?> evidence(ParseWrapper parse,
          List<? extends TopWrapper<? extends TOP>> inputs) throws AnalysisEngineProcessException {
    QuestionWrapper question = (QuestionWrapper) inputs.get(0);
    return evidence(parse, question);
  }

  protected abstract EvidenceWrapper<?, ?> evidence(ParseWrapper parse, QuestionWrapper question)
          throws AnalysisEngineProcessException;

}
