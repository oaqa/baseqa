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
import edu.cmu.lti.oaqa.framework.data.QueryConceptWrapper;

/**
 * 
 * This is a helper class to store query concepts. 
 *
 * The side effect of this method is that it overrides 
 * the AbstractQuery object stored in the CAS.
 * 
 * @author Zi Yang <ziy@cs.cmu.edu>
 * @author Leonid Boytsov
 * 
 */

public class QueryConceptList extends FSListWrapper<QueryConcept> {

  public QueryConceptList(JCas jcas) {
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

  public void setQueryConcepts(List<QueryConceptWrapper> concepts) throws Exception {
    setList(concepts);
  }

  public static void storeQueryConcepts(JCas jcas, List<QueryConceptWrapper> concepts) throws Exception {
    new QueryConceptList(jcas).setQueryConcepts(concepts);
  }

  public List<QueryConceptWrapper> getQueryConcepts() throws AnalysisEngineProcessException {
    AbstractQuery query = (AbstractQuery) BaseJCasHelper.getFS(jcas, AbstractQuery.type);
    if (query != null) {
      list = query.getConcepts();
      return getList(QueryConcept.class, QueryConceptWrapper.class);
    } else {
      return new ArrayList<QueryConceptWrapper>();
    }
  }

  public static List<QueryConceptWrapper> retrieveQueryConcepts(JCas jcas) throws Exception {
    return new QueryConceptList(jcas).getQueryConcepts();
  }
}
