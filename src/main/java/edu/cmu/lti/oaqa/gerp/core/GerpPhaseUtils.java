package edu.cmu.lti.oaqa.gerp.core;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.impl.XmiCasSerializer;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.TOP;
import org.apache.uima.resource.ResourceInitializationException;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.uimafit.factory.AnalysisEngineFactory;
import org.xml.sax.SAXException;

import com.google.common.base.CharMatcher;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import edu.cmu.lti.oaqa.core.data.WrapperIndexer;
import edu.cmu.lti.oaqa.ecd.BaseExperimentBuilder;
import edu.cmu.lti.oaqa.ecd.phase.BasePhase;

public class GerpPhaseUtils {

  private static CharMatcher matcher = CharMatcher.anyOf("./ :");

  // TODO Since the vbar in the descritpor should be removed and replaced with the YAML list
  // syntax, the returned value should be String array (String[])
  public static List<String> toClassNames(String options) {
    List<String> names = Lists.newArrayList();
    for (String option : options.split("\\n+")) {
      names.add(option.substring(matcher.lastIndexIn(option) + 1));
    }
    return names;
  }

  public static AnalysisEngine createBasePhase(Map<String, Object> confs)
          throws AnalysisEngineProcessException {
    AnalysisEngineDescription aeDescription;
    try {
      aeDescription = AnalysisEngineFactory.createPrimitiveDescription(BasePhase.class,
              BaseExperimentBuilder.getParamList(confs));
    } catch (ResourceInitializationException e) {
      throw new AnalysisEngineProcessException(e);
    }
    try {
      return AnalysisEngineFactory.createAggregate(aeDescription);
    } catch (ResourceInitializationException e) {
      throw new AnalysisEngineProcessException(e);
    }
  }

  public static Collection<TOP> getAllTops(JCas jcas, int type) {
    List<TOP> tops = Lists.newArrayList();
    FSIterator<TOP> topIter = jcas.getJFSIndexRepository().getAllIndexedFS(type);
    while (topIter.hasNext()) {
      tops.add(topIter.next());
    }
    return tops;
  }

  public static void removeAllTopsFromIndexesAndIndexer(JCas jcas, WrapperIndexer indexer, int type) {
    FSIterator<TOP> topIter = jcas.getJFSIndexRepository().getAllIndexedFS(type);
    Set<TOP> tops = Sets.newHashSet();
    while (topIter.hasNext()) {
      tops.add(topIter.next());
    }
    for (TOP top : tops) {
      indexer.remove(top);
      top.removeFromIndexes(jcas);
    }
  }

  public static void removeAllTops(JCas jcas, int type) {
    FSIterator<TOP> topIter = jcas.getJFSIndexRepository().getAllIndexedFS(type);
    Set<TOP> tops = Sets.newHashSet();
    while (topIter.hasNext()) {
      tops.add(topIter.next());
    }
    for (TOP top : tops) {
      top.removeFromIndexes(jcas);
    }
  }

  public static Map<String, Object> getConfigurationTuples(UimaContext context, String... keys) {
    Map<String, Object> tuples = Maps.newLinkedHashMap();
    for (String key : keys) {
      tuples.put(key, context.getConfigParameterValue(key));
    }
    return tuples;
  }

  public static <K, V> Map<K, V> copyTuples(Map<K, V> map, K... keys) {
    Map<K, V> ret = Maps.newLinkedHashMap();
    for (K key : keys) {
      ret.put(key, map.get(key));
    }
    return ret;
  }

  public static void printCasIndexes(JCas jcas) {
    Iterator<FSIndex<TOP>> indexes = jcas.getJFSIndexRepository().getIndexes();
    while (indexes.hasNext()) {
      FSIndex<TOP> index = indexes.next();
      System.out.println(index.getType().getName());
      FSIterator<TOP> it = index.iterator();
      while (it.hasNext()) {
        System.out.println(" - " + it.next());
      }
    }
  }

  public static void printCas(JCas jcas) {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try {
      XmiCasSerializer.serialize(jcas.getCas(), baos);
    } catch (SAXException e) {
      e.printStackTrace();
    }
    StringWriter xmiStr = new StringWriter();
    XMLWriter writer = new XMLWriter(xmiStr, OutputFormat.createPrettyPrint());
    try {
      writer.write(DocumentHelper.parseText(baos.toString()));
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (DocumentException e) {
      e.printStackTrace();
    }
    System.out.println(xmiStr);
  }
}
