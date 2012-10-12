package edu.cmu.lti.oaqa.framework.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.AbstractQuery;
import org.oaqa.model.QueryConcept;

import edu.cmu.lti.oaqa.framework.BaseJCasHelper;
import edu.cmu.lti.oaqa.framework.data.base.FSListWrapper;

public class KeytermList extends FSListWrapper<QueryConcept> {

  public KeytermList(JCas jcas) {
    super(jcas);
  }

  @Override
  public void clear() {
    Iterator<?> it = jcas.getJFSIndexRepository().getAllIndexedFS(AbstractQuery.type);
    while (it.hasNext()) {
      AbstractQuery query = (AbstractQuery) it.next();
      query.removeFromIndexes();
    }
  }

  @Override
  public void complete() {
    AbstractQuery query = new AbstractQuery(jcas);
    query.setConcepts(list);
    query.addToIndexes();
  }

  public void setKeyterms(List<Keyterm> keyterms) throws Exception {
    setList(keyterms);
  }

  public static void storeKeyterms(JCas jcas, List<Keyterm> keyterms) throws Exception {
    new KeytermList(jcas).setKeyterms(keyterms);
  }

  public List<Keyterm> getKeyterms() throws AnalysisEngineProcessException {
    AbstractQuery query = (AbstractQuery) BaseJCasHelper.getFS(jcas, AbstractQuery.type);
    if (query != null) {
      list = query.getConcepts();
      return getList(QueryConcept.class, Keyterm.class);
    } else {
      return new ArrayList<Keyterm>();
    }
  }

  public static List<Keyterm> retrieveKeyterms(JCas jcas) throws Exception {
    return new KeytermList(jcas).getKeyterms();
  }

}