package edu.cmu.lti.oaqa.baseqa.data.core;

import java.util.ArrayList;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.EmptyFSList;
import org.apache.uima.jcas.cas.EmptyStringList;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.cas.NonEmptyFSList;
import org.apache.uima.jcas.cas.NonEmptyStringList;
import org.apache.uima.jcas.cas.StringArray;
import org.apache.uima.jcas.cas.StringList;
import org.oaqa.model.core.OAQAAnnotation;
import org.oaqa.model.core.OAQATop;

import com.google.common.collect.Lists;

public class WrapperHelper {

  public static List<String> wrapStringList(StringList list) {
    List<String> wrappers = new ArrayList<String>();
    StringList tail = list;
    while (tail instanceof NonEmptyStringList) {
      wrappers.add(((NonEmptyStringList) tail).getHead());
      tail = ((NonEmptyStringList) tail).getTail();
    }
    return wrappers;
  }

  public static StringList unwrapStringList(List<String> wrappers, JCas jcas) {
    StringList list = new EmptyStringList(jcas);
    StringList tail;
    for (String wrapper : Lists.reverse(wrappers)) {
      tail = list;
      list = new NonEmptyStringList(jcas);
      ((NonEmptyStringList) list).setHead(wrapper);
      ((NonEmptyStringList) list).setTail(tail);
    }
    return list;
  }

  public static List<String> wrapStringArray(StringArray array) {
    List<String> wrappers = new ArrayList<String>(array.size());
    for (int i = 0; i < array.size(); i++) {
      wrappers.add(array.get(i));
    }
    return wrappers;
  }

  public static StringArray unwrapStringArray(List<String> wrappers, JCas jcas) {
    StringArray array = new StringArray(jcas, wrappers.size());
    int i = 0;
    for (String wrapper : wrappers) {
      array.set(i++, wrapper);
    }
    return array;
  }

  public static <T extends OAQATop, W extends OAQATopWrapper<T>> List<W> wrapTopList(FSList list,
          Class<W> wrapperClass) throws AnalysisEngineProcessException {
    List<W> wrappers = new ArrayList<W>();
    FSList tail = list;
    while (tail instanceof NonEmptyFSList) {
      OAQATop head = (OAQATop) ((NonEmptyFSList) tail).getHead();
      wrappers.add(OAQATopWrapper.wrap(head, wrapperClass));
      tail = ((NonEmptyFSList) tail).getTail();
    }
    return wrappers;
  }

  public static <T extends OAQATop, W extends OAQATopWrapper<T>> FSList unwrapTopList(
          List<W> wrappers, JCas jcas) throws AnalysisEngineProcessException {
    FSList list = new EmptyFSList(jcas);
    FSList tail;
    for (W wrapper : Lists.reverse(wrappers)) {
      tail = list;
      list = new NonEmptyFSList(jcas);
      ((NonEmptyFSList) list).setHead(wrapper.unwrap(jcas));
      ((NonEmptyFSList) list).setTail(tail);
    }
    return list;
  }

  public static <T extends OAQATop, W extends OAQATopWrapper<T>> List<W> wrapTopArray(
          FSArray array, Class<W> wrapperClass) throws AnalysisEngineProcessException {
    List<W> wrappers = new ArrayList<W>(array.size());
    for (int i = 0; i < array.size(); i++) {
      wrappers.add(OAQATopWrapper.wrap((OAQATop) array.get(i), wrapperClass));
    }
    return wrappers;
  }

  public static <T extends OAQATop, W extends OAQATopWrapper<T>> FSArray unwrapTopArray(
          List<W> wrappers, JCas jcas) throws AnalysisEngineProcessException {
    FSArray array = new FSArray(jcas, wrappers.size());
    int i = 0;
    for (W wrapper : wrappers) {
      array.set(i, wrapper.unwrap(jcas));
    }
    return array;
  }

  public static <T extends OAQAAnnotation, W extends OAQAAnnotationWrapper<T>> List<W> wrapAnnotationList(
          FSList list, Class<W> wrapperClass) throws AnalysisEngineProcessException {
    List<W> wrappers = new ArrayList<W>();
    FSList tail = list;
    while (tail instanceof NonEmptyFSList) {
      OAQAAnnotation head = (OAQAAnnotation) ((NonEmptyFSList) tail).getHead();
      wrappers.add(OAQAAnnotationWrapper.wrap(head, wrapperClass));
      tail = ((NonEmptyFSList) tail).getTail();
    }
    return wrappers;
  }

  public static <T extends OAQAAnnotation, W extends OAQAAnnotationWrapper<T>> FSList unwrapAnnotationList(
          List<W> wrappers, JCas jcas) throws AnalysisEngineProcessException {
    FSList list = new EmptyFSList(jcas);
    FSList tail;
    for (W wrapper : Lists.reverse(wrappers)) {
      tail = list;
      list = new NonEmptyFSList(jcas);
      ((NonEmptyFSList) list).setHead(wrapper.unwrap(jcas));
      ((NonEmptyFSList) list).setTail(tail);
    }
    return list;
  }

  public static <T extends OAQAAnnotation, W extends OAQAAnnotationWrapper<T>> List<W> wrapAnnotationArray(
          FSArray array, Class<W> wrapperClass) throws AnalysisEngineProcessException {
    List<W> wrappers = new ArrayList<W>(array.size());
    for (int i = 0; i < array.size(); i++) {
      wrappers.add(OAQAAnnotationWrapper.wrap((OAQAAnnotation) array.get(i), wrapperClass));
    }
    return wrappers;
  }

  public static <T extends OAQAAnnotation, W extends OAQAAnnotationWrapper<T>> FSArray unwrapAnnotationArray(
          List<W> wrappers, JCas jcas) throws AnalysisEngineProcessException {
    FSArray array = new FSArray(jcas, wrappers.size());
    int i = 0;
    for (W wrapper : wrappers) {
      array.set(i, wrapper.unwrap(jcas));
    }
    return array;
  }

}
