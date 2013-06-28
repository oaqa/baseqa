package edu.cmu.lti.oaqa.baseqa.gerpphase.generator;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CASException;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.baseqa.data.nlp.Keyterm;
import edu.cmu.lti.oaqa.baseqa.data.nlp.KeytermList;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.RetrievalResult;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.RetrievalResultArray;
import edu.cmu.lti.oaqa.baseqa.gerpphase.core.generator.AbstractGenerator;
import edu.cmu.lti.oaqa.framework.BaseJCasHelper;
import edu.cmu.lti.oaqa.framework.ViewManager;
import edu.cmu.lti.oaqa.framework.types.InputElement;

public abstract class AbstractDocumentGenerator extends AbstractGenerator {

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
