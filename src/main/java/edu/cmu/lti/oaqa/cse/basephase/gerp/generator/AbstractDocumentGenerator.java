package edu.cmu.lti.oaqa.cse.basephase.gerp.generator;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CASException;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.framework.BaseJCasHelper;
import edu.cmu.lti.oaqa.framework.ViewManager;
import edu.cmu.lti.oaqa.framework.data.Keyterm;
import edu.cmu.lti.oaqa.framework.data.KeytermList;
import edu.cmu.lti.oaqa.framework.data.RetrievalResult;
import edu.cmu.lti.oaqa.framework.data.RetrievalResultArray;
import edu.cmu.lti.oaqa.framework.types.InputElement;

public abstract class AbstractDocumentGenerator extends AbstractCandidateGenerator {

  @Override
  public void generateCandidates(JCas jcas) throws AnalysisEngineProcessException {
    // prepare input
    final InputElement input = ((InputElement) BaseJCasHelper
            .getAnnotation(jcas, InputElement.type));
    final List<Keyterm> keyterms = KeytermList.retrieveKeyterms(jcas);
    // do task
    List<RetrievalResult> documents = generateDocuments(input.getQuestion(), keyterms);
    // save output
    try {
      RetrievalResultArray.storeRetrievalResults(ViewManager.getDocumentView(jcas), documents,
              false);
    } catch (CASException e) {
      new AnalysisEngineProcessException(e);
    }
  }

  protected abstract List<RetrievalResult> generateDocuments(final String question,
          final List<Keyterm> keyterms) throws AnalysisEngineProcessException;
}
