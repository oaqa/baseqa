package edu.cmu.lti.oaqa.cse.basephase.gerp.pruner;

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

public abstract class AbstractFormulatedQueryPruner extends
		AbstractCandidatePruner {

	@Override
	public void pruneCandidates(JCas jcas)
			throws AnalysisEngineProcessException {
		// prepare input
		final String question = ((InputElement) BaseJCasHelper.getAnnotation(
				jcas, InputElement.type)).getQuestion();
		List<PlaceHolder> placeholders;
		try {
			placeholders = PlaceHolderList.retrievePlaceHolders(GerpViewManager
					.getOrCreateView(jcas, ViewType.PLACEHOLDER_RANK));
		} catch (CASException e) {
			throw new AnalysisEngineProcessException(e);
		}
		// do task
		pruneFormulatedQueries(question, placeholders);
		// save output
		PlaceHolderList.storePlaceHolders(jcas, placeholders, true);
	}

	protected abstract void pruneFormulatedQueries(final String question,
			List<PlaceHolder> placeholders) throws AnalysisEngineProcessException;

}
