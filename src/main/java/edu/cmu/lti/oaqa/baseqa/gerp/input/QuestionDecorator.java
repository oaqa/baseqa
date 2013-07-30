package edu.cmu.lti.oaqa.baseqa.gerp.input;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.input.Question;
import org.uimafit.component.JCasAnnotator_ImplBase;

import edu.cmu.lti.oaqa.baseqa.data.nlp.QuestionWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.QuestionWrapper.QuestionClassType;
import edu.cmu.lti.oaqa.core.data.WrapperHelper;
import edu.cmu.lti.oaqa.core.data.WrapperIndexer;
import edu.cmu.lti.oaqa.ecd.phase.ProcessingStepUtils;
import edu.cmu.lti.oaqa.framework.types.InputElement;

public class QuestionDecorator extends JCasAnnotator_ImplBase {

  @Override
  public void process(JCas jcas) throws AnalysisEngineProcessException {
    InputElement input = ProcessingStepUtils.getInputElement(jcas);
    QuestionWrapper question = new QuestionWrapper(input.getBegin(), input.getEnd(),
            input.getSequenceId(), input.getDataset(), input.getQuestion(),
            QuestionClassType.UNCLASSIFIED);
    if (question != null) {
      WrapperIndexer indexer = new WrapperIndexer();
      Question annotation = WrapperHelper.unwrap(indexer, question, jcas);
      annotation.addToIndexes();
    }
  }

}
