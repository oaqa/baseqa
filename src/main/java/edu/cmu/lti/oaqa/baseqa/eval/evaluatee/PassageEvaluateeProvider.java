package edu.cmu.lti.oaqa.baseqa.eval.evaluatee;

import java.util.Collection;
import java.util.Comparator;
import java.util.function.Function;

import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.baseqa.eval.EvaluateeProvider;
import edu.cmu.lti.oaqa.baseqa.util.ViewType;
import edu.cmu.lti.oaqa.ecd.config.ConfigurableProvider;
import edu.cmu.lti.oaqa.type.retrieval.Passage;
import edu.cmu.lti.oaqa.util.TypeUtil;

public class PassageEvaluateeProvider extends ConfigurableProvider implements
        EvaluateeProvider<Passage> {

  @Override
  public Collection<Passage> getGoldStandard(JCas jcas) {
    return TypeUtil.getRankedPassages(ViewType.getGsView(jcas));
  }

  @Override
  public Collection<Passage> getResults(JCas jcas) {
    return TypeUtil.getRankedPassages(jcas);
  }

  @Override
  public Comparator<Passage> comparator() {
    return Comparator.comparing(Passage::getRank).thenComparing(Passage::getUri)
            .thenComparing(Passage::getBeginSection)
            .thenComparingInt(Passage::getOffsetInBeginSection)
            .thenComparing(Passage::getEndSection).thenComparingInt(Passage::getOffsetInEndSection);
  }

  @Override
  public Function<Passage, String> uniqueIdMapper() {
    return result -> result.getUri() + "[" + result.getBeginSection() + ":"
            + result.getOffsetInBeginSection() + "," + result.getEndSection() + ":"
            + result.getOffsetInEndSection() + "]";
  }

  @Override
  public String getName() {
    return "Passage";
  }
  
}
