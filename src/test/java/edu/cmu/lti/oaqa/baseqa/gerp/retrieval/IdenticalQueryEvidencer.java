package edu.cmu.lti.oaqa.baseqa.gerp.retrieval;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;

import edu.cmu.lti.oaqa.baseqa.data.kb.InterpretationWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.ParseWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.QuestionWrapper;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.AbstractQueryWrapper;
import edu.cmu.lti.oaqa.gerp.data.DefaultEvidenceWrapper;
import edu.cmu.lti.oaqa.gerp.data.EvidenceWrapper;

public class IdenticalQueryEvidencer extends AbstractQueryEvidencer {

  @Override
  protected EvidenceWrapper<?, ?> evidence(AbstractQueryWrapper abstractQuery,
          QuestionWrapper question, ParseWrapper parse, InterpretationWrapper interpretation)
          throws AnalysisEngineProcessException {
    return new DefaultEvidenceWrapper(1.0f);
  }

}
