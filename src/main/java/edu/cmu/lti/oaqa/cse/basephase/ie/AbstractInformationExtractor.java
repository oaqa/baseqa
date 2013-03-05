package edu.cmu.lti.oaqa.cse.basephase.ie;

import java.util.ArrayList;
import java.util.List;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import edu.cmu.lti.oaqa.ecd.log.AbstractLoggedComponent;
import edu.cmu.lti.oaqa.framework.BaseJCasHelper;
import edu.cmu.lti.oaqa.framework.ViewManager;
import edu.cmu.lti.oaqa.framework.data.base.JCasHelper;
import edu.cmu.lti.oaqa.framework.types.InputElement;
import edu.cmu.lti.oaqa.cse.basephase.retrieval.SourceIdHelper;
import edu.cmu.lti.oaqa.framework.data.AnswerWrapper;
import edu.cmu.lti.oaqa.framework.data.AnswerArray;
import edu.cmu.lti.oaqa.framework.data.RetrievalResult;
import edu.cmu.lti.oaqa.framework.data.RetrievalResultArray;


public abstract class AbstractInformationExtractor extends
		AbstractLoggedComponent {
	
  @Override
  public void initialize(UimaContext c) throws ResourceInitializationException {
    super.initialize(c);
    SourceId = SourceIdHelper.GetSourceId(c); 
  }

	public abstract List<AnswerWrapper> extractAnswerCandidates(String qid,
			String questionText, String answerType, List<String> keyterms,
			List<String> keyphrases, List<RetrievalResult> documents);

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		try {
			InputElement input = (InputElement) BaseJCasHelper.getAnnotation(
					jcas, InputElement.type);
			String question = input.getQuestion();
			String qid = input.getSequenceId();
			String answerType = JCasHelper.loadAnswerType(jcas);
			List<String> keyterms = new ArrayList<String>();
			List<String> keyphrases = new ArrayList<String>();
			JCasHelper.loadKeyTermsAndPhrases(jcas, keyterms, keyphrases);
			
			List<RetrievalResult> documents
								= RetrievalResultArray.retrieveRetrievalResults(SourceId, 
																						ViewManager.getDocumentView(jcas));
			
			
			List<AnswerWrapper> answers = extractAnswerCandidates(qid, question, 
																	answerType, keyterms, keyphrases, documents);
			
			AnswerArray.storeAnswers(SourceId, 
															ViewManager.getCandidateView(jcas), 
															answers);
		} catch (Exception e) {
			throw new AnalysisEngineProcessException(e);
		}
	}
	
  private String SourceId;
}
