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

public class PlaceHolderList extends FSListWrapper<QueryConcept> {

	  public PlaceHolderList(JCas jcas) {
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

	  public void setPlaceHolders(List<PlaceHolder> placeholders) throws AnalysisEngineProcessException {
	    setList(placeholders);
	  }

	  private void appendPlaceHolders(List<PlaceHolder> placeholders) throws AnalysisEngineProcessException {
	    appendList(placeholders);
	  }

	  public static void storePlaceHolders(JCas jcas, List<PlaceHolder> placeholders, boolean overwrite)
	          throws AnalysisEngineProcessException {
	    if (overwrite) {
	      new PlaceHolderList(jcas).setPlaceHolders(placeholders);
	    } else {
	      new PlaceHolderList(jcas).appendPlaceHolders(placeholders);
	    }
	  }

	  @Deprecated
	  public static void storeplaceholders(JCas jcas, List<PlaceHolder> placeholders)
	          throws AnalysisEngineProcessException {
	    storePlaceHolders(jcas, placeholders, true);
	  }

	  public List<PlaceHolder> getplaceholders() throws AnalysisEngineProcessException {
	    AbstractQuery query = (AbstractQuery) BaseJCasHelper.getFS(jcas, AbstractQuery.type);
	    if (query != null) {
	      list = query.getConcepts();
	      return getList(QueryConcept.class, PlaceHolder.class);
	    } else {
	      return new ArrayList<PlaceHolder>();
	    }
	  }

	  public static List<PlaceHolder> retrievePlaceHolders(JCas jcas) throws AnalysisEngineProcessException {
	    return new PlaceHolderList(jcas).getplaceholders();
	  }
}
