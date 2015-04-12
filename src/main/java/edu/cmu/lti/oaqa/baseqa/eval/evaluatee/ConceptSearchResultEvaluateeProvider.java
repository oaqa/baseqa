package edu.cmu.lti.oaqa.baseqa.eval.evaluatee;

import java.util.Collection;
import java.util.Comparator;
import java.util.function.Function;

import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.baseqa.eval.EvaluateeProvider;
import edu.cmu.lti.oaqa.baseqa.util.ViewType;
import edu.cmu.lti.oaqa.ecd.config.ConfigurableProvider;
import edu.cmu.lti.oaqa.type.retrieval.ConceptSearchResult;
import edu.cmu.lti.oaqa.util.TypeUtil;

public class ConceptSearchResultEvaluateeProvider extends ConfigurableProvider
        implements EvaluateeProvider<ConceptSearchResult> {

  @Override
  public Collection<ConceptSearchResult> getGoldStandard(JCas jcas) {
    return TypeUtil.getRankedConceptSearchResults(ViewType.getGsView(jcas));
  }

  @Override
  public Collection<ConceptSearchResult> getResults(JCas jcas) {
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

  @Override
  public String getName() {
    return "Concept";
  }

}
