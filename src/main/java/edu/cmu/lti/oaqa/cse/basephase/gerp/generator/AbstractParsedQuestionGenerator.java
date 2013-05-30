package edu.cmu.lti.oaqa.cse.basephase.gerp.generator;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.framework.BaseJCasHelper;
import edu.cmu.lti.oaqa.framework.data.Keyterm;
import edu.cmu.lti.oaqa.framework.data.KeytermList;
import edu.cmu.lti.oaqa.framework.data.PlaceHolder;
import edu.cmu.lti.oaqa.framework.data.PlaceHolderList;
import edu.cmu.lti.oaqa.framework.types.InputElement;

public abstract class AbstractParsedQuestionGenerator extends
		AbstractCandidateGenerator {

	@Override
	public void generateCandidates(JCas jcas)
			throws AnalysisEngineProcessException {
	    final String question = ((InputElement) BaseJCasHelper.getAnnotation(jcas, InputElement.type))
	            .getQuestion();
	    // do task
	    List<PlaceHolder> placeholders = generateParsedQuestion(question);
	    // save output
	    PlaceHolderList.storePlaceHolders(jcas, placeholders, false); 
	}

	  protected abstract List<PlaceHolder> generateParsedQuestion(final String question)
	          throws AnalysisEngineProcessException;
	
	

}
