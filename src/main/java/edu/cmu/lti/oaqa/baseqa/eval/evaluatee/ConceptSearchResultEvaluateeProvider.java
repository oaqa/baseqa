package edu.cmu.lti.oaqa.baseqa.eval.evaluatee;

import java.util.Collection;
import java.util.Comparator;
import java.util.function.Function;

import org.apache.uima.cas.CASException;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.baseqa.eval.EvaluateeProvider;
import edu.cmu.lti.oaqa.ecd.config.ConfigurableProvider;
import edu.cmu.lti.oaqa.framework.ViewManager;
import edu.cmu.lti.oaqa.framework.ViewManager.ViewType;
import edu.cmu.lti.oaqa.type.retrieval.ConceptSearchResult;
import edu.cmu.lti.oaqa.util.TypeUtil;

public class ConceptSearchResultEvaluateeProvider extends ConfigurableProvider implements
        EvaluateeProvider<ConceptSearchResult> {

  @Override
  public Collection<ConceptSearchResult> getGoldStandard(JCas jcas) throws CASException {
    return TypeUtil.getRankedConceptSearchResults(ViewManager.getOrCreateView(jcas,
            ViewType.FINAL_ANSWER_GS));
  }

  @Override
  public Collection<ConceptSearchResult> getResults(JCas jcas) throws CASException {
    return TypeUtil.getRankedConceptSearchResults(jcas);
  }

  @Override
  public Comparator<ConceptSearchResult> comparator() {
    return Comparator.comparing(ConceptSearchResult::getRank);
  }

  @Override
  public Function<ConceptSearchResult, String> uniqueIdMapper() {
    return ConceptSearchResult::getUri;
  }

}
