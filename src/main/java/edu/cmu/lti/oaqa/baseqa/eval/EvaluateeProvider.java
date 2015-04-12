package edu.cmu.lti.oaqa.baseqa.eval;

import java.util.Collection;
import java.util.Comparator;
import java.util.function.Function;

import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.Resource;

public interface EvaluateeProvider<T> extends Resource {

  Collection<T> getGoldStandard(JCas jcas);

  Collection<T> getResults(JCas jcas);

  Comparator<T> comparator();

  Function<T, String> uniqueIdMapper();

  String getName();

}
