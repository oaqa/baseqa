package edu.cmu.lti.oaqa.baseqa.data.core;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CASException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.TOP;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.SetMultimap;

/**
 * This class acts as a wrapper for a particular view in a {@link JCas} or a middle layer between
 * the view in {@link JCas} and the wrappers. The constructor {@link #getWrapperIndexer(JCas)} takes
 * a view as the input.
 * <p>
 * To use it as a wrapper for {@link JCas}, one can retrieve all the wrappers by the {@link Class}
 * of the wrapper, similar to {@link JCas#getAnnotationIndex(int)}, by invoking
 * {@link #getWrappersByTypes(List)}.
 * <p>
 * Since this class is responsible to guarantee the one-to-one correspondence between {@link TOP}s
 * in the view of the {@link JCas} and the wrappers included in an instance of this class. Two
 * mappings have been creat: a mapping between the native hash code (aka identical Java Object
 * reference id for each instance) of wrappers to the actual TOPs, and a mapping between the
 * identical address of TOPs to the actual wrappers. Identical hash code (from
 * {@link System#identityHashCode(Object)} should be used since most wrappers override original
 * {@link Object#hashCode()} method, whereas the identical address is generated from
 * {@link TOP#getAddress()}. Both mappings ensure the uniqueness of wrapper while wrappingand the
 * uniqueness of TOP while unwrapping. {@link #checkWrapped(TOP)} and {@link #getWrapped(TOP)} can
 * be used to check and retrieve the wrapper by a {@link TOP}, {@link #checkUnwrapped(TopWrapper)}
 * and {@link #getUnwrapped(TopWrapper)} can be used to check and retrieve the TOP by a
 * {@link TopWrapper}.
 * 
 * @author Zi Yang <ziy@cs.cmu.edu>
 * 
 */
public class WrapperIndexer {

  /*
   * Global static variables and methods
   */
  /**
   * A global mapping variable to simulate the whole CAS including multiple views.
   * <p>
   * TODO a wrapper for the global JCas can be implemented.
   */
  private static Map<Integer, WrapperIndexer> jcasHash2wrapperIndexer = Maps.newHashMap();

  private static void addJCasWrapperIndexerPair(JCas jcas, WrapperIndexer indexer) {
    jcasHash2wrapperIndexer.put(System.identityHashCode(jcas), indexer);
  }

  public static WrapperIndexer getWrapperIndexer(JCas jcas) {
    int jcasHash = System.identityHashCode(jcas);
    return jcasHash2wrapperIndexer.containsKey(jcasHash) ? jcasHash2wrapperIndexer.get(jcasHash)
            : new WrapperIndexer(jcas);
  }

  /*
   * Member variables and methods
   */
  private JCas jcas;

  /**
   * A local cache for the mapping between wrapper {@link Class} and actual wrappers.
   */
  private SetMultimap<Integer, TopWrapper<? extends TOP>> type2wrappers;

  /**
   * A mapping between the native hash code (aka identical Java Object reference id for each
   * instance) of wrappers to the actual TOPs. Identical hash code (from
   * {@link System#identityHashCode(Object)} should be used since most wrappers override original
   * {@link Object#hashCode()} method. The mapping ensures the uniqueness of top while unwrapping.
   */
  private Map<Integer, TOP> wrapperHashcode2top;

  /**
   * A mapping between the identical address of TOPs to the actual wrappers. Identical address is
   * generated from {@link TOP#getAddress()}. The mapping ensures the uniqueness of wrapper while
   * wrapping.
   */
  private Map<Integer, TopWrapper<? extends TOP>> topAddress2wrapper;

  private WrapperIndexer(JCas jcas) {
    this.jcas = jcas;
    type2wrappers = HashMultimap.create();
    wrapperHashcode2top = Maps.newHashMap();
    topAddress2wrapper = Maps.newHashMap();
    addJCasWrapperIndexerPair(jcas, this);
  }

  public List<Set<TopWrapper<? extends TOP>>> getWrappersByTypes(List<Integer> types)
          throws AnalysisEngineProcessException, IllegalArgumentException, SecurityException,
          InstantiationException, IllegalAccessException, NoSuchFieldException,
          ClassNotFoundException, CASException {
    List<Set<TopWrapper<?>>> wrappers = Lists.newArrayList();
    for (int type : types) {
      if (!type2wrappers.containsKey(type)) {
        addClassWrappersToIndex(type);
      }
      wrappers.add(type2wrappers.get(type));
    }
    return wrappers;
  }

  private void addClassWrappersToIndex(int type) throws AnalysisEngineProcessException,
          IllegalArgumentException, SecurityException, InstantiationException,
          IllegalAccessException, NoSuchFieldException, ClassNotFoundException, CASException {
    if (type2wrappers.containsKey(type)) {
      return;
    }
    type2wrappers.putAll(type, WrapperHelper.wrapAllFromJCas(jcas, type));
  }

  public boolean checkWrapped(TOP top) {
    return topAddress2wrapper.containsKey(top.getAddress());
  }

  public TopWrapper<?> getWrapped(TOP top) {
    return topAddress2wrapper.get(top.getAddress());
  }

  public boolean checkUnwrapped(TopWrapper<? extends TOP> wrapper) {
    return wrapperHashcode2top.containsKey(System.identityHashCode(wrapper));
  }

  public TOP getUnwrapped(TopWrapper<? extends TOP> wrapper) {
    return wrapperHashcode2top.get(System.identityHashCode(wrapper));
  }

  public JCas getJCas() {
    return jcas;
  }

  public void setJCas(JCas jcas) {
    this.jcas = jcas;
  }
}
