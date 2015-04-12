package edu.cmu.lti.oaqa.baseqa.eval.evaluatee;

import java.util.Collection;
import java.util.Comparator;
import java.util.function.Function;

import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.baseqa.eval.EvaluateeProvider;
import edu.cmu.lti.oaqa.baseqa.util.ViewType;
import edu.cmu.lti.oaqa.ecd.config.ConfigurableProvider;
import edu.cmu.lti.oaqa.type.kb.Triple;
import edu.cmu.lti.oaqa.type.retrieval.TripleSearchResult;
import edu.cmu.lti.oaqa.util.TypeUtil;

public class TripleSearchResultEvaluateeProvider extends ConfigurableProvider
        implements EvaluateeProvider<TripleSearchResult> {

  @Override
  public Collection<TripleSearchResult> getGoldStandard(JCas jcas) {
    return TypeUtil.getRankedTripleSearchResults(ViewType.getGsView(jcas));
  }

  @Override
  public Collection<TripleSearchResult> getResults(JCas jcas) {
    return TypeUtil.getRankedTripleSearchResults(jcas);
  }

  @Override
  public Comparator<TripleSearchResult> comparator() {
    return Comparator.comparing(TripleSearchResult::getRank);
  }

  @Override
  public Function<TripleSearchResult, String> uniqueIdMapper() {
    return result -> {
      Triple triple = result.getTriple();
      return triple.getPredicate() + "(" + triple.getSubject() + "," + triple.getObject() + ")";
    };
  }

  @Override
  public String getName() {
    return "Triple";
  }

}
