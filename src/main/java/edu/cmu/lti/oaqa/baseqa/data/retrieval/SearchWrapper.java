package edu.cmu.lti.oaqa.baseqa.data.retrieval;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.retrieval.Search;

import com.google.common.base.Objects;

import edu.cmu.lti.oaqa.baseqa.data.core.OAQATopWrapper;
import edu.cmu.lti.oaqa.baseqa.data.core.WrapperHelper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.GerpTopWrapper;

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
    super(generator);
    this.query = query;
    this.hitList = hitList;
    this.abstractQuery = abstractQuery;
    this.searchId = searchId;
  }

  @Override
  public void wrap(Search top) throws AnalysisEngineProcessException {
    super.wrap(top);
    this.query = top.getQuery();
    this.hitList = WrapperHelper.wrapTopArray(top.getHitList(), SearchResultWrapper.class);
    this.abstractQuery = OAQATopWrapper.wrap(top.getAbstractQuery(), AbstractQueryWrapper.class);
    this.searchId = top.getSearchId();
  }

  @Override
  public Search unwrap(JCas jcas) throws AnalysisEngineProcessException {
    Search top = super.unwrap(jcas);
    top.setQuery(query);
    top.setHitList(WrapperHelper.unwrapTopArray(hitList, jcas));
    top.setAbstractQuery(abstractQuery.unwrap(jcas));
    top.setSearchId(searchId);
    return top;
  }

  @Override
  public Class<? extends Search> getTypeClass() {
    return Search.class;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), query, hitList, searchId);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    SearchWrapper other = (SearchWrapper) obj;
    return Objects.equal(query, other.query) && Objects.equal(hitList, other.hitList)
            && Objects.equal(searchId, other.searchId);
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
