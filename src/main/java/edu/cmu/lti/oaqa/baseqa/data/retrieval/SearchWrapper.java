package edu.cmu.lti.oaqa.baseqa.data.retrieval;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.retrieval.Search;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.core.data.WrapperHelper;
import edu.cmu.lti.oaqa.core.data.WrapperIndexer;
import edu.cmu.lti.oaqa.gerp.data.GerpTopWrapper;

public class SearchWrapper extends GerpTopWrapper<Search> {

  private static final long serialVersionUID = 1L;

  private String query;

  private List<SearchResultWrapper> hitList;

  private AbstractQueryWrapper abstractQuery;

  private String searchId;

  public SearchWrapper(String query, List<SearchResultWrapper> hitList,
          AbstractQueryWrapper abstractQuery, String searchId) {
    super();
    this.query = query;
    this.hitList = hitList;
    this.abstractQuery = abstractQuery;
    this.searchId = searchId;
  }

  public SearchWrapper(String query, List<SearchResultWrapper> hitList,
          AbstractQueryWrapper abstractQuery, String searchId, String generator) {
    this(query, hitList, abstractQuery, searchId);
    addGenerator(generator);
  }

  public SearchWrapper() {
    this(null, Lists.<SearchResultWrapper> newArrayList(), null, null);
  }

  @Override
  public void wrap(WrapperIndexer indexer, Search top) throws AnalysisEngineProcessException {
    super.wrap(indexer, top);
    this.query = top.getQuery();
    this.hitList = WrapperHelper.wrapTopArray(indexer, top.getHitList(), SearchResultWrapper.class);
    if (top.getAbstractQuery() != null) {
      this.abstractQuery = WrapperHelper.matchSubclassAndWrap(indexer, top.getAbstractQuery(),
              AbstractQueryWrapper.class);
    }
    this.searchId = top.getSearchId();
  }

  @Override
  public void unwrap(WrapperIndexer indexer, Search top) throws AnalysisEngineProcessException {
    super.unwrap(indexer, top);
    top.setQuery(query);
    JCas jcas = WrapperHelper.getJCas(top);
    top.setHitList(WrapperHelper.unwrapTopArray(indexer, hitList, jcas));
    if (abstractQuery != null) {
      top.setAbstractQuery(WrapperHelper.unwrap(indexer, abstractQuery, jcas));
    }
    top.setSearchId(searchId);
  }

  @Override
  public Class<? extends Search> getTypeClass() {
    return Search.class;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(query, hitList, searchId);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    SearchWrapper other = (SearchWrapper) obj;
    return Objects.equal(this.query, other.query) && Objects.equal(this.hitList, other.hitList)
            && Objects.equal(this.searchId, other.searchId);
  }

  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public List<SearchResultWrapper> getHitList() {
    return hitList;
  }

  public void setHitList(List<SearchResultWrapper> hitList) {
    this.hitList = hitList;
  }

  public AbstractQueryWrapper getAbstractQuery() {
    return abstractQuery;
  }

  public void setAbstractQuery(AbstractQueryWrapper abstractQuery) {
    this.abstractQuery = abstractQuery;
  }

  public String getSearchId() {
    return searchId;
  }

  public void setSearchId(String searchId) {
    this.searchId = searchId;
  }

}
