package edu.cmu.lti.oaqa.cse.basephase.ie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceSpecifier;

import edu.cmu.lti.oaqa.cse.baseqa.ConfigurableProviderAnnotator;
import edu.cmu.lti.oaqa.framework.BaseJCasHelper;
import edu.cmu.lti.oaqa.framework.QALogEntry;
import edu.cmu.lti.oaqa.framework.ViewManager;
import edu.cmu.lti.oaqa.framework.data.base.JCasHelper;
import edu.cmu.lti.oaqa.framework.types.InputElement;
import edu.cmu.lti.oaqa.framework.data.AnswerWrapper;
import edu.cmu.lti.oaqa.framework.data.AnswerArray;
import edu.cmu.lti.oaqa.framework.data.RetrievalResult;
import edu.cmu.lti.oaqa.framework.data.RetrievalResultArray;


public abstract class AbstractInformationExtractor extends ConfigurableProviderAnnotator {
  public static String RetrievalScoreName = "RetrievalScore";
  
  @Override
  public boolean initialize(ResourceSpecifier aSpecifier, Map<String, Object> addParams) 
                             throws ResourceInitializationException {
    if (!super.initialize(aSpecifier, addParams)) return false;
    
    return true;
  }

	public abstract List<AnswerWrapper> extractAnswerCandidatesFromOneDoc(String qid,
			                                                    String questionText, 
			                                                    String answerType, 
			                                                    List<String> keyterms,
			                                                    List<String> keyphrases,
			                                                    RetrievalResult OneDoc);
	
	

	@Override
	public void process(JCas FullJCas) throws AnalysisEngineProcessException {
		try {
      JCas jcasSource = ViewManager.getDocumentView(FullJCas);
      JCas jcasTarget = ViewManager.getCandidateView(FullJCas);

			InputElement input = (InputElement) BaseJCasHelper.getAnnotation(
					                                               FullJCas, InputElement.type);
			String question = input.getQuestion();
			String qid = input.getSequenceId();
			String answerType = JCasHelper.loadAnswerType(FullJCas);
			List<String> keyterms = new ArrayList<String>();
			List<String> keyphrases = new ArrayList<String>();
			JCasHelper.loadKeyTermsAndPhrases(FullJCas, keyterms, keyphrases);
			
			ArrayList<String> AllSourceIds = new ArrayList<String>();
			
			RetrievalResultArray.GetAllSourceIds(jcasSource, AllSourceIds);
			
			for (String SourceId: AllSourceIds) {
        // Produced by other information extractors
        List<AnswerWrapper> answers = AnswerArray.retrieveAnswers(SourceId, jcasTarget);
			  
  			List<RetrievalResult> documents
  								= RetrievalResultArray.retrieveRetrievalResults(SourceId, jcasSource);
  			
  			String ExtractorId = this.getClass().getSimpleName();
  			
        log("Loaded " + documents.size() + 
            " candidates to extract answers from Source: "+ SourceId + 
            " Extractor class: " + ExtractorId);
  			
  			for (RetrievalResult doc: documents) {
  			    List<AnswerWrapper> OneDocAnsw = extractAnswerCandidatesFromOneDoc(qid, 
  			                                                             question, 
  																	                                 answerType, 
  																	                                 keyterms, 
  																	                                 keyphrases,
  																	                                 doc);
  			      		      
  			    for (AnswerWrapper ans: OneDocAnsw) {
  			      ans.addFeature(doc.getScore(), RetrievalScoreName);
  			      ans.addFeature(doc.getScore(), SourceId + "#" + ExtractorId);
  			      ans.addRetrievalResult(doc);
  			    }
  	        answers.addAll(OneDocAnsw);
  			}  			
  			
  			AnswerArray.storeAnswers(SourceId, jcasTarget, answers);
  			log("Extracted " + answers.size() + " answer(s) from Source: "+ SourceId);
			}
		} catch (Exception e) {
			throw new AnalysisEngineProcessException(e);
		}
	}
	
  protected final void log(String message) {
    super.log(QALogEntry.INFORMATION_EXTRACTION, message);
  }	
}
