package edu.cmu.lti.oaqa.bio.core.ie;

import java.util.ArrayList;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CASException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.Passage;

import edu.cmu.lti.oaqa.ecd.log.AbstractLoggedComponent;
import edu.cmu.lti.oaqa.framework.JCasHelper;
import edu.cmu.lti.oaqa.framework.ViewManager;
import edu.cmu.lti.oaqa.framework.ViewManager.ViewType;
import edu.cmu.lti.oaqa.framework.data.PassageCandidate;
import edu.cmu.lti.oaqa.framework.eval.passage.PassageHelper;

public class GoldStandardPassageExtractor extends AbstractLoggedComponent {

  @Override
  public final void process(JCas jcas) throws AnalysisEngineProcessException {
    super.process(jcas);
    try {
      JCas gsView = ViewManager.getView(jcas, ViewType.DOCUMENT_GS);
      List<Passage> gs = PassageHelper.loadDocumentSet(gsView);
      List<PassageCandidate> passages = new ArrayList<PassageCandidate>();
      for (Passage passage : gs) {
        passages.add(new PassageCandidate(passage));
      }
      JCas candidateView = ViewManager.getCandidateView(jcas);
      JCasHelper.storePassages(candidateView, passages);
    } catch (CASException e) {
      throw new AnalysisEngineProcessException(e);
    }
  }

}
