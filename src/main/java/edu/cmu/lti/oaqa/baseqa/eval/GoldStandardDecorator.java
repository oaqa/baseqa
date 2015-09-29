package edu.cmu.lti.oaqa.baseqa.eval;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.TOP;
import org.apache.uima.resource.ResourceInitializationException;

import edu.cmu.lti.oaqa.baseqa.util.ProviderCache;
import edu.cmu.lti.oaqa.baseqa.util.UimaContextHelper;
import edu.cmu.lti.oaqa.baseqa.util.ViewType;
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
    persistence.populateGoldStandard(input.getDataset(), input.getSequenceId(),
            ViewType.getGsView(jcas)).forEach(T::addToIndexes);
  }

}
