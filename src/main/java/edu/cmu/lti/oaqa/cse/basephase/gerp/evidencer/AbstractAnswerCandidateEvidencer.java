package edu.cmu.lti.oaqa.cse.basephase.gerp.evidencer;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CASException;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.cse.basephase.gerp.GerpViewManager;
import edu.cmu.lti.oaqa.cse.basephase.gerp.GerpViewManager.ViewType;
import edu.cmu.lti.oaqa.framework.BaseJCasHelper;
import edu.cmu.lti.oaqa.framework.data.PlaceHolder;
import edu.cmu.lti.oaqa.framework.data.PlaceHolderList;
import edu.cmu.lti.oaqa.framework.types.InputElement;

public abstract class AbstractAnswerCandidateEvidencer extends
		AbstractCandidateEvidencer {
	  @Override
	  public void evidenceCandidates(JCas jcas) throws AnalysisEngineProcessException {
	    // prepare input
	    final String question = ((InputElement) BaseJCasHelper.getAnnotation(jcas, InputElement.type))
	            .getQuestion();
	    final List<PlaceHolder> placeholders = PlaceHolderList.retrievePlaceHolders(jcas);
	    // do task
	    evidenceAnswerCandidates(question, placeholders);
	    // save output
	    try {
	      PlaceHolderList.storePlaceHolders(GerpViewManager.getOrCreateView(jcas, ViewType.PLACEHOLDER_EVIDENCE),
	              placeholders, false);
	    } catch (CASException e) {
	      throw new AnalysisEngineProcessException(e);
	    }
	  } 

	  protected abstract void evidenceAnswerCandidates(final String question, List<PlaceHolder> placeholders)
	          throws AnalysisEngineProcessException;


}
