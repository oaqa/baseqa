package edu.cmu.lti.oaqa.baseqa.data.nlp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.retrieval.AbstractQuery;
import org.oaqa.model.retrieval.QueryConcept;

import edu.cmu.lti.oaqa.core.data.FSListWrapper;
import edu.cmu.lti.oaqa.core.data.WrapperIndexer;
import edu.cmu.lti.oaqa.framework.BaseJCasHelper;

/**
 * Legacy type wrapper for AbstractQuery, used for phrases defined in basephase. In a GERP
 * environment, the candidates generates from generators will be stored in the same index without
 * any additional container.
 * 
 * @author Zi Yang <ziy@cs.cmu.edu>
 * 
 */
@Deprecated
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

  public void setKeyterms(WrapperIndexer indexer, List<Keyterm> keyterms)
          throws AnalysisEngineProcessException {
    setList(indexer, keyterms);
  }

  private void appendKeyterms(WrapperIndexer indexer, List<Keyterm> keyterms)
          throws AnalysisEngineProcessException {
    appendList(indexer, keyterms);
  }

  public static void storeKeyterms(WrapperIndexer indexer, JCas jcas, List<Keyterm> keyterms,
          boolean overwrite) throws AnalysisEngineProcessException {
    if (overwrite) {
      new KeytermList(jcas).setKeyterms(indexer, keyterms);
    } else {
      new KeytermList(jcas).appendKeyterms(indexer, keyterms);
    }
  }

  @Deprecated
  public static void storeKeyterms(WrapperIndexer indexer, JCas jcas, List<Keyterm> keyterms)
          throws AnalysisEngineProcessException {
    storeKeyterms(indexer, jcas, keyterms, true);
  }

  public List<Keyterm> getKeyterms(WrapperIndexer indexer) throws AnalysisEngineProcessException {
    AbstractQuery query = (AbstractQuery) BaseJCasHelper.getFS(jcas, AbstractQuery.type);
    if (query != null) {
      list = query.getConcepts();
      return getList(indexer, Keyterm.class);
    } else {
      return new ArrayList<Keyterm>();
    }
  }

  public static List<Keyterm> retrieveKeyterms(WrapperIndexer indexer, JCas jcas)
          throws AnalysisEngineProcessException {
    return new KeytermList(jcas).getKeyterms(indexer);
  }

}