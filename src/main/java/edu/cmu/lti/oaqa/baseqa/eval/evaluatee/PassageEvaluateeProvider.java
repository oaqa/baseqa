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
import edu.cmu.lti.oaqa.type.retrieval.Passage;
import edu.cmu.lti.oaqa.util.TypeUtil;

public class PassageEvaluateeProvider extends ConfigurableProvider implements
        EvaluateeProvider<Passage> {

  @Override
  public Collection<Passage> getGoldStandard(JCas jcas) throws CASException {
    return TypeUtil.getPassages(ViewManager.getOrCreateView(jcas, ViewType.FINAL_ANSWER_GS));
  }

  @Override
  public Collection<Passage> getResults(JCas jcas) throws CASException {
    return TypeUtil.getPassages(jcas);
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
    return Passage::getUri;
  }

}
