package edu.cmu.lti.oaqa.baseqa.gerpphase.generator;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CASException;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.baseqa.data.nlp.Keyterm;
import edu.cmu.lti.oaqa.baseqa.data.nlp.KeytermList;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.PassageCandidate;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.PassageCandidateArray;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.RetrievalResult;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.RetrievalResultArray;
import edu.cmu.lti.oaqa.baseqa.gerpphase.core.generator.AbstractGenerator;
import edu.cmu.lti.oaqa.framework.BaseJCasHelper;
import edu.cmu.lti.oaqa.framework.ViewManager;
import edu.cmu.lti.oaqa.framework.types.InputElement;

public abstract class AbstractPassageGenerator extends AbstractGenerator {

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
