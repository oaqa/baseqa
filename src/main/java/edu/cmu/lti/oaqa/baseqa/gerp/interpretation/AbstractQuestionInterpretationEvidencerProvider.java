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
import edu.cmu.lti.oaqa.gerp.core.AbstractIndependentEvidencerProvider;
import edu.cmu.lti.oaqa.gerp.data.EvidenceWrapper;

public abstract class AbstractQuestionInterpretationEvidencerProvider extends
        AbstractIndependentEvidencerProvider<InterpretationWrapper> {

  @Override
  public List<Integer> getRequiredInputTypes() {
    return Lists.newArrayList(Question.type, Parse.type);
  }

  @Override
  protected EvidenceWrapper<?, ?> evidence(InterpretationWrapper interpretation,
          List<? extends TopWrapper<? extends TOP>> inputs) throws AnalysisEngineProcessException {
    QuestionWrapper question = (QuestionWrapper) inputs.get(0);
    ParseWrapper parse = (ParseWrapper) inputs.get(1);
    return evidence(interpretation, question, parse);
  }

  protected abstract EvidenceWrapper<?, ?> evidence(InterpretationWrapper interpretation,
          QuestionWrapper question, ParseWrapper parse) throws AnalysisEngineProcessException;

}
