package edu.cmu.lti.oaqa.cse.basephase.ie;

import java.util.ArrayList;
import java.util.List;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.oaqa.model.Passage;

import edu.cmu.lti.oaqa.cse.basephase.retrieval.SourceIdHelper;
import edu.cmu.lti.oaqa.ecd.log.AbstractLoggedComponent;
import edu.cmu.lti.oaqa.framework.ViewManager;
import edu.cmu.lti.oaqa.framework.ViewManager.ViewType;
import edu.cmu.lti.oaqa.framework.data.PassageCandidate;
import edu.cmu.lti.oaqa.framework.data.PassageCandidateArray;
import edu.cmu.lti.oaqa.framework.eval.passage.PassageHelper;

public class GoldStandardPassageExtractor extends AbstractLoggedComponent {
  
  @Override
  public void initialize(UimaContext c) throws ResourceInitializationException {
    super.initialize(c);
    SourceId = SourceIdHelper.GetSourceId(c); 
  }
  
  @Override
  public final void process(JCas jcas) throws AnalysisEngineProcessException {
    super.process(jcas);
    try {
      JCas gsView = ViewManager.getView(jcas, ViewType.DOCUMENT_GS);
      List<Passage> gs = PassageHelper.loadDocumentSet(gsView);
      List<PassageCandidate> passages = new ArrayList<PassageCandidate>();
      for (Passage passage : gs) {
        PassageCandidate candidate = new PassageCandidate();
        candidate.wrap(passage);
        passages.add(candidate);
      }
      JCas candidateView = ViewManager.getCandidateView(jcas);
      PassageCandidateArray.storePassageCandidates(SourceId, candidateView, passages);
    } catch (Exception e) {
      throw new AnalysisEngineProcessException(e);
    }
  }

  private String SourceId;
}
