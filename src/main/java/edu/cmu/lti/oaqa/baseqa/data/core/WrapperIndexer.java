package edu.cmu.lti.oaqa.baseqa.data.core;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.TOP;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.SetMultimap;

public class WrapperIndexer {

  private JCas jcas;

  private SetMultimap<Class<? extends TopWrapper<? extends TOP>>, TopWrapper<? extends TOP>> class2wrappers;

  public WrapperIndexer(JCas jcas) {
    this.jcas = jcas;
    class2wrappers = HashMultimap.create();
  }

  public void addClassWrappersToIndex(Class<? extends TopWrapper<? extends TOP>> clazz)
          throws AnalysisEngineProcessException, IllegalArgumentException, SecurityException,
          InstantiationException, IllegalAccessException, NoSuchFieldException,
          ClassNotFoundException {
    if (class2wrappers.containsKey(clazz)) {
      return;
    }
    assert Arrays.asList(clazz.getInterfaces()).contains(TopWrapper.class);
    class2wrappers.putAll(clazz, WrapperHelper.wrapAllFromJCas(jcas, clazz));
  }

  public void addAllClassesToIndex(Collection<Class<? extends TopWrapper<?>>> classes)
          throws AnalysisEngineProcessException, IllegalArgumentException, SecurityException,
          InstantiationException, IllegalAccessException, NoSuchFieldException,
          ClassNotFoundException {
    for (Class<? extends TopWrapper<?>> clazz : classes) {
      addClassWrappersToIndex(clazz);
    }
  }

  public List<Set<TopWrapper<? extends TOP>>> getWrappersByClasses(
          List<Class<? extends TopWrapper<?>>> classes) {
    List<Set<TopWrapper<?>>> wrappers = Lists.newArrayList();
    for (Class<? extends TopWrapper<?>> clazz : classes) {
      wrappers.add(class2wrappers.get(clazz));
    }
    return wrappers;
  }
}
