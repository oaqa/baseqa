package edu.cmu.lti.oaqa.baseqa.data.core;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.core.OAQATop;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.SetMultimap;

public class WrapperIndexer {

  private SetMultimap<Class<? extends OAQATopWrapper<? extends OAQATop>>, OAQATopWrapper<? extends OAQATop>> class2wrappers;

  public WrapperIndexer() {
    class2wrappers = HashMultimap.create();
  }

  public void addClassWrappersToIndex(Class<? extends OAQATopWrapper<? extends OAQATop>> clazz,
          JCas jcas) throws AnalysisEngineProcessException, IllegalArgumentException,
          SecurityException, InstantiationException, IllegalAccessException, NoSuchFieldException {
    if (class2wrappers.containsKey(clazz)) {
      return;
    }
    assert Arrays.asList(clazz.getInterfaces()).contains(TopWrapper.class);
    class2wrappers.putAll(clazz, WrapperHelper.wrapAllFromJCas(jcas, clazz));
  }

  public void addAllClassesToIndex(Collection<Class<? extends OAQATopWrapper<?>>> classes, JCas jcas)
          throws AnalysisEngineProcessException, IllegalArgumentException, SecurityException,
          InstantiationException, IllegalAccessException, NoSuchFieldException {
    for (Class<? extends OAQATopWrapper<?>> clazz : classes) {
      addClassWrappersToIndex(clazz, jcas);
    }
  }

  public List<Set<OAQATopWrapper<? extends OAQATop>>> getWrappersByClasses(
          List<Class<? extends OAQATopWrapper<?>>> classes) {
    List<Set<OAQATopWrapper<?>>> wrappers = Lists.newArrayList();
    for (Class<? extends OAQATopWrapper<?>> clazz : classes) {
      wrappers.add(class2wrappers.get(clazz));
    }
    return wrappers;
  }
}
