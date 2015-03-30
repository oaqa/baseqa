package edu.cmu.lti.oaqa.baseqa.eval;

import java.util.List;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CASException;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.TOP;
import org.apache.uima.resource.ResourceInitializationException;

import edu.cmu.lti.oaqa.baseqa.util.ProviderCache;
import edu.cmu.lti.oaqa.baseqa.util.UimaContextHelper;
import edu.cmu.lti.oaqa.framework.ViewManager;
import edu.cmu.lti.oaqa.framework.ViewManager.ViewType;
import edu.cmu.lti.oaqa.framework.types.InputElement;

public class GoldStandardDecorator<T extends TOP> extends JCasAnnotator_ImplBase {

  private GoldStandardPersistenceProvider<T> persistence;

  @SuppressWarnings("unchecked")
  @Override
  public void initialize(UimaContext context) throws ResourceInitializationException {
    String pp = UimaContextHelper.getConfigParameterStringValue(context, "persistence-provider");
    persistence = ProviderCache.getProvider(pp, GoldStandardPersistenceProvider.class);
  }

  @Override
  public void process(JCas jcas) throws AnalysisEngineProcessException {
    InputElement input = JCasUtil.select(jcas, InputElement.class).stream().findFirst().get();
    List<? extends T> gsAnnotations;
    try {
      gsAnnotations = persistence.populateGoldStandard(input.getDataset(), input.getSequenceId(),
              ViewManager.getOrCreateView(jcas, ViewType.FINAL_ANSWER_GS));
    } catch (CASException e) {
      throw new AnalysisEngineProcessException(e);
    }
    gsAnnotations.forEach(annotation -> annotation.addToIndexes());
  }

}
