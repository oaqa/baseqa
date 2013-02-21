package edu.cmu.lti.oaqa.framework.helper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.uima.cas.CASException;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.DoubleArray;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.cas.NonEmptyFSList;
import org.apache.uima.jcas.cas.StringArray;
import org.apache.uima.jcas.cas.TOP;
import org.oaqa.model.AbstractQuery;
import org.oaqa.model.Answer;
import org.oaqa.model.AnswerList;
import org.oaqa.model.AnswerType;
import org.oaqa.model.QueryConcept;
import org.oaqa.model.QueryOperator;
import org.oaqa.model.Question;
import org.oaqa.model.Search;
import org.oaqa.model.SearchResult;

import edu.cmu.lti.oaqa.trec.framework.data.AnswerCandidate;
import edu.cmu.lti.oaqa.trec.framework.data.RetrievalResult;

public class JCasHelper {

	private final static String TERM = "TIE";
	private final static String PHRASE = "PHRASE";

	/**
	 * Helper method to add an item to a stupid FS list. UIMA's FSList seems to
	 * be a classic linked-list implementation
	 */
	public static NonEmptyFSList addToFSList(JCas aJCas, FSList list, TOP item) {
		NonEmptyFSList result = new NonEmptyFSList(aJCas);
		result.setHead(item);
		result.setTail(list);
		return result;
	}

	/**
	 * Convert UIMA data model
	 * 
	 * @param questionView
	 * @return answerType
	 */
	public static String loadAnswerType(JCas questionView) {
		String result = null;
		AnnotationIndex<?> index = questionView
				.getAnnotationIndex(AnswerType.type);
		Iterator<?> it = index.iterator();

		if (it.hasNext()) {
			AnswerType atype = (AnswerType) it.next();
			result = atype.getLabel();
		}
		return result;
	}

	/**
	 * Convert UIMA data model
	 * 
	 * @param questionView
	 * @return keyterms
	 */
	private static List<String> loadConcepts(JCas questionView, String type) {
		List<String> reversedResult = new ArrayList<String>();
		Iterator<?> it = questionView.getJFSIndexRepository().getAllIndexedFS(
				AbstractQuery.type);

		if (it.hasNext()) {
			AbstractQuery query = (AbstractQuery) it.next();
			FSList concepts = query.getConcepts();

			// According to a UIMA forum, there isn't any simpler way to iterate
			// FSList.
			while (concepts instanceof NonEmptyFSList) {
				QueryConcept head = (QueryConcept) ((NonEmptyFSList) concepts)
						.getHead();
				if (type.equals(head.getOperator().getName())) {
					reversedResult.add(head.getText());
				}
				concepts = ((NonEmptyFSList) concepts).getTail();
			}
		}
		List<String> result = new ArrayList<String>(reversedResult.size());
		for (int i = 0; i < reversedResult.size(); i++) {
			result.add(reversedResult.get(reversedResult.size() - (i + 1)));
		}
		return result;
	}

	public static List<String> loadKeyterms(JCas questionView) {
		return loadConcepts(questionView, TERM);
	}

	public static List<String> loadKeyphrases(JCas questionView) {
		return loadConcepts(questionView, PHRASE);
	}

	public static List<RetrievalResult> loadDocuments(JCas documentView) {
		List<RetrievalResult> result = new ArrayList<RetrievalResult>();
		Iterator<?> it = documentView.getJFSIndexRepository().getAllIndexedFS(
				Search.type);

		if (it.hasNext()) {
			Search retrievalResult = (Search) it.next();
			FSArray hitList = retrievalResult.getHitList();
			for (int i = 0; i < hitList.size(); i++) {
				SearchResult sr = (SearchResult) hitList.get(i);
				result.add(new RetrievalResult(sr));
			}
		}
		return result;
	}

	public static List<AnswerCandidate> loadAnswerCandidates(JCas candidateView)
			throws CASException {
		List<AnswerCandidate> result = new ArrayList<AnswerCandidate>();
		Iterator<?> it = candidateView.getJFSIndexRepository().getAllIndexedFS(
				AnswerList.type);

		if (it.hasNext()) {
			AnswerList answerCandidates = (AnswerList) it.next();
			String[] featureLabels = null;
			if (answerCandidates.getFeatureLabels() != null) {
				featureLabels = new String[answerCandidates.getFeatureLabels()
						.size()];
				for (int i = 0; i < answerCandidates.getFeatureLabels().size(); i++) {
					featureLabels[i] = answerCandidates.getFeatureLabels(i);
				}
			}
			FSArray answerList = answerCandidates.getAnswerList();
			for (int i = 0; i < answerList.size(); i++) {
				Answer a = (Answer) answerList.get(i);
				AnswerCandidate candidate = new AnswerCandidate(a);
				candidate.setFeatureLables(featureLabels);
				result.add(candidate);
			}
		}
		return result;
	}

	public static Question loadQuestion(JCas questionView) {
		AnnotationIndex<?> index = questionView
				.getAnnotationIndex(Question.type);
		Iterator<?> it = index.iterator();

		Question question = null;
		if (it.hasNext()) {
			question = (Question) it.next();
		}
		return question;
	}

	/**
	 * Stores (overwrite) answer type in a view
	 * 
	 * @param questionView
	 * @param type
	 */
	public static void storeAnswerType(JCas questionView, String type) {
		// Remove old content first! (otherwise, it would work only once)
		Iterator<?> it = questionView.getJFSIndexRepository().getAllIndexedFS(
				AnswerType.type);
		while (it.hasNext()) {
			AnswerType oaqaType = (AnswerType) it.next();
			oaqaType.removeFromIndexes();
		}

		AnswerType oaqaType = new AnswerType(questionView);
		oaqaType.setLabel(type);
		oaqaType.addToIndexes();
	}

	/**
	 * Store (overwrite) concepts (i.e. key terms) into a view
	 * 
	 * @param questionView
	 * @param keyterms
	 */
	public static void storeKeyterms(JCas questionView, List<String> keyterms) {
		storeConcepts(questionView, keyterms, new ArrayList<String>());
	}

	/**
	 * Store (overwrite) concepts (i.e. key phrases) into a view
	 * 
	 * @param questionView
	 * @param keyterms
	 */
	public static void storeKeyTermsAndPhrases(JCas questionView,
			List<String> keyterms, List<String> keyphrases) {
		storeConcepts(questionView, keyterms, keyphrases);
	}

	/**
	 * Store (overwrite) concepts (i.e. key terms / phrases in our
	 * implementation) into a view
	 * 
	 * @param questionView
	 * @param keyterms
	 * @param type
	 */
	private static void storeConcepts(JCas questionView, List<String> keyterms,
			List<String> keyphrases) {
		// Remove old content first! (otherwise, it would work only once)
		Iterator<?> it = questionView.getJFSIndexRepository().getAllIndexedFS(
				AbstractQuery.type);
		while (it.hasNext()) {
			AbstractQuery query = (AbstractQuery) it.next();
			query.removeFromIndexes();
		}

		AbstractQuery query = new AbstractQuery(questionView);
		FSList concepts = new FSList(questionView);

		for (String keyterm : keyterms) {
			QueryConcept concept = new QueryConcept(questionView);
			concept.setText(keyterm);
			QueryOperator operator = new QueryOperator(questionView);
			operator.addToIndexes();
			operator.setName(TERM);
			concept.setOperator(operator);
			concept.addToIndexes();

			// add a QueryConcept into FSList
			concepts = JCasHelper.addToFSList(questionView, concepts,
					concept);
		}
		for (String keyterm : keyphrases) {
			QueryConcept concept = new QueryConcept(questionView);
			concept.setText(keyterm);
			QueryOperator operator = new QueryOperator(questionView);
			operator.addToIndexes();
			operator.setName(PHRASE);
			concept.setOperator(operator);
			concept.addToIndexes();

			// add a QueryConcept into FSList
			concepts = JCasHelper.addToFSList(questionView, concepts,
					concept);
		}
		query.setConcepts(concepts);
		concepts.addToIndexes();
		query.addToIndexes();
	}

	/**
	 * Store (overwrite) documents in a view
	 * 
	 * @param documentView
	 * @param documents
	 */
	public static void storeDocuments(JCas documentView,
			List<RetrievalResult> documents) {
		// Remove old content first! (otherwise, it would work only once)
		Iterator<?> it = documentView.getJFSIndexRepository().getAllIndexedFS(
				Search.type);
		while (it.hasNext()) {
			Search search = (Search) it.next();
			search.removeFromIndexes();
		}

		FSArray hitList = new FSArray(documentView, documents.size());
		hitList.addToIndexes();
		for (int i = 0; i < documents.size(); i++) {
			SearchResult sr = new SearchResult(documentView);
			sr.addToIndexes();
			sr.setRank((i + 1));
			sr.setText(documents.get(i).getText());
			sr.setScore(documents.get(i).getScore());
			sr.setUri(documents.get(i).getDocID());
			sr.setQueryString(documents.get(i).getQueryString());

			List<Double> features = documents.get(i).getRankScoreList();
			DoubleArray featureList = new DoubleArray(documentView,
					features.size());
			featureList.addToIndexes();
			for (int j = 0; j < features.size(); j++) {
				featureList.set(j, features.get(j));
			}
			sr.setFeatureVector(featureList);

			hitList.set(i, sr);
		}

		Search search = new Search(documentView);
		search.setHitList(hitList);
		search.addToIndexes();
	}

	/**
	 * Store (overwrite) answers into a view
	 * 
	 * @param view
	 *            either candidate view or final answer view
	 * @param answers
	 */
	private static void storeAnswers(JCas view, List<AnswerCandidate> answers) {
		// Remove old content first! (otherwise, it would work only once)
		Iterator<?> it = view.getJFSIndexRepository().getAllIndexedFS(
				AnswerList.type);
		while (it.hasNext()) {
			AnswerList answerCandidates = (AnswerList) it.next();
			answerCandidates.removeFromIndexes();
		}

		FSArray answerArray = new FSArray(view, answers.size());

		// Erase currently registered items
		// candidateView.reset();
		answerArray.addToIndexes();
		for (int i = 0; i < answers.size(); i++) {
			AnswerCandidate candidate = answers.get(i);
			Answer a = new Answer(view);
			// a.addToIndexes();
			a.setText(candidate.getText());

			double[] features = candidate.getFeatures();
			DoubleArray featureList = new DoubleArray(view, features.length);
			featureList.addToIndexes();
			for (int j = 0; j < features.length; j++) {
				featureList.set(j, features[j]);
			}
			a.setFeatureVector(featureList);

			int resultCount = 0;
			FSArray hitList = new FSArray(view, candidate.getRetrievalResults()
					.size());
			hitList.addToIndexes();
			for (RetrievalResult result : candidate.getRetrievalResults()) {
				SearchResult sr = new SearchResult(view);
				sr.addToIndexes();
				sr.setRank((resultCount + 1));
				sr.setText(result.getText());
				sr.setScore(result.getScore());
				sr.setUri(result.getDocID());
				sr.setQueryString(result.getQueryString());

				List<Double> rerankfeatures = result.getRankScoreList();
				DoubleArray rerankfeaturesArray = new DoubleArray(view,
						rerankfeatures.size());
				rerankfeaturesArray.addToIndexes();
				for (int j = 0; j < rerankfeatures.size(); j++) {
					rerankfeaturesArray.set(j, rerankfeatures.get(j));
				}
				sr.setFeatureVector(rerankfeaturesArray);

				hitList.set(resultCount, sr);
				resultCount++;
			}
			a.setSearchResultList(hitList);
			a.setScore(candidate.getScore());
			a.addToIndexes();

			answerArray.set(i, a);
		}

		AnswerList answerList = new AnswerList(view);
		answerList.setAnswerList(answerArray);
		if (answers.size() > 0) {
			if (answers.get(0).getFeatureLabels() != null) {
				String[] featureLabels = answers.get(0).getFeatureLabels();
				StringArray featureLabelList = new StringArray(view,
						featureLabels.length);
				featureLabelList.addToIndexes();
				for (int j = 0; j < featureLabels.length; j++) {
					featureLabelList.set(j, featureLabels[j]);
				}
				answerList.setFeatureLabels(featureLabelList);
			}
		}
		answerList.addToIndexes();
	}

	public static void storeCandidates(JCas candidateView,
			List<AnswerCandidate> answers) {
		storeAnswers(candidateView, answers);
	}

	public static void storeFinalAnswers(JCas finalAnswerView,
			List<AnswerCandidate> answers) {
		storeAnswers(finalAnswerView, answers);
	}

}
