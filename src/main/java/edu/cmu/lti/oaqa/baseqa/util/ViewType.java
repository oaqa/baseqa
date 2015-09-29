package edu.cmu.lti.oaqa.baseqa.util;

import java.util.List;

import org.apache.uima.cas.CASException;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;

import com.google.common.collect.Lists;

public enum ViewType {

  _GS;

  public static JCas getView(JCas jcas, ViewType viewType) {
    return JCasUtil.getView(jcas, viewType.name(), true);
  }

  public static JCas getGsView(JCas jcas) {
    return getView(jcas, _GS);
  }

  public static JCas getView(JCas jcas, String viewNamePrefix, String viewNameSuffix) {
    return JCasUtil.getView(jcas, viewNamePrefix + "." + viewNameSuffix, true);
  }

  public static JCas createView(JCas jcas, String viewNamePrefix, String viewNameSuffix,
          String documentText) {
    JCas view = JCasUtil.getView(jcas, viewNamePrefix + "." + viewNameSuffix, true);
    view.setDocumentText(documentText);
    return view;
  }

  public static List<JCas> listViews(JCas jcas, String viewNamePrefix) {
    try {
      return Lists.newArrayList(jcas.getViewIterator(viewNamePrefix));
    } catch (CASException e) {
      return Lists.newArrayList();
    }
  }

}
