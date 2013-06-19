package edu.cmu.lti.oaqa.cse.basephase.gerp.generator;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CASException;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.framework.BaseJCasHelper;
import edu.cmu.lti.oaqa.framework.ViewManager;
import edu.cmu.lti.oaqa.framework.data.Keyterm;
import edu.cmu.lti.oaqa.framework.data.KeytermList;
import edu.cmu.lti.oaqa.framework.data.PassageCandidate;
import edu.cmu.lti.oaqa.framework.data.PassageCandidateArray;
import edu.cmu.lti.oaqa.framework.data.RetrievalResult;
import edu.cmu.lti.oaqa.framework.data.RetrievalResultArray;
import edu.cmu.lti.oaqa.framework.types.InputElement;

public abstract class AbstractPassageGenerator extends AbstractCandidateGenerator {

  @Override
  public void generateCandidates(JCas jcas) throws AnalysisEngineProcessException {
    // prepare input
    final String question = ((InputElement) BaseJCasHelper.getAnnotation(jcas,
            InputElement.type)).getQuestion();
    final KeytermList keytermList = new KeytermList(jcas);
    final List<Keyterm> keyterms = keytermList.getKeyterms();
    final List<RetrievalResult> documents;
    try {
      documents = RetrievalResultArray.retrieveRetrievalResults(ViewManager.getDocumentView(jcas));
    } catch (CASException e) {
      throw new AnalysisEngineProcessException(e);
    }
    // do task
    final List<PassageCandidate> passages = generatePassages(question, keyterms, documents);
    // save output
    try {
      PassageCandidateArray.storePassageCandidates(ViewManager.getCandidateView(jcas), passages,
              false);
    } catch (CASException e) {
      throw new AnalysisEngineProcessException(e);
    }
  }

  protected abstract List<PassageCandidate> generatePassages(final String question,
          final List<Keyterm> keyterms, final List<RetrievalResult> documents)
          throws AnalysisEngineProcessException;
}
