package edu.cmu.lti.oaqa.baseqa.data.retrieval;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.oaqa.model.retrieval.SearchResult;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.data.answer.CandidateAnswerVariantWrapper;
import edu.cmu.lti.oaqa.baseqa.data.core.WrapperHelper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.GerpTopWrapper;

public abstract class SearchResultWrapper extends GerpTopWrapper<SearchResult> {

  private static final long serialVersionUID = 1L;

  private String uri;

  private float score;

  private String text;

  private int rank;

  private String queryString;

  private String searchId;

  private List<CandidateAnswerVariantWrapper> candidateAnswers;

  public SearchResultWrapper(String uri, float score, String text, int rank, String queryString,
          String searchId, List<CandidateAnswerVariantWrapper> candidateAnswers) {
    super();
    this.uri = uri;
    this.score = score;
    this.text = text;
    this.rank = rank;
    this.queryString = queryString;
    this.searchId = searchId;
    this.candidateAnswers = candidateAnswers;
  }

  public SearchResultWrapper(String uri, float score, String text, int rank, String queryString,
          String searchId, List<CandidateAnswerVariantWrapper> candidateAnswers, String generator) {
    this(uri, score, text, rank, queryString, searchId, candidateAnswers);
    addGenerator(generator);
  }

  public SearchResultWrapper() {
    this(null, Float.NEGATIVE_INFINITY, null, Integer.MAX_VALUE, null, null, Lists
            .<CandidateAnswerVariantWrapper> newArrayList());
  }

  @Override
  public void wrap(SearchResult top) throws AnalysisEngineProcessException {
    super.wrap(top);
    this.uri = top.getUri();
    this.score = top.getScore();
    this.text = top.getText();
    this.rank = top.getRank();
    this.queryString = top.getQueryString();
    this.searchId = top.getSearchId();
    this.candidateAnswers = WrapperHelper.wrapTopArray(top.getCandidateAnswers(),
            CandidateAnswerVariantWrapper.class);
  }

  @Override
  public void unwrap(SearchResult top) throws AnalysisEngineProcessException {
    super.unwrap(top);
    top.setUri(uri);
    top.setScore(score);
    top.setText(text);
    top.setRank(rank);
    top.setQueryString(queryString);
    top.setSearchId(searchId);
    top.setCandidateAnswers(WrapperHelper.unwrapTopArray(candidateAnswers,
            WrapperHelper.getJCas(top)));
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(uri, queryString, searchId);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    SearchResultWrapper other = (SearchResultWrapper) obj;
    return Objects.equal(this.uri, other.uri) && Objects.equal(this.queryString, other.queryString)
            && Objects.equal(this.searchId, other.searchId);
  }

  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }

  public float getScore() {
    return score;
  }

  public void setScore(float score) {
    this.score = score;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public int getRank() {
    return rank;
  }

  public void setRank(int rank) {
    this.rank = rank;
  }

  public String getQueryString() {
    return queryString;
  }

  public void setQueryString(String queryString) {
    this.queryString = queryString;
  }

  public String getSearchId() {
    return searchId;
  }

  public void setSearchId(String searchId) {
    this.searchId = searchId;
  }

  public List<CandidateAnswerVariantWrapper> getCandidateAnswers() {
    return candidateAnswers;
  }

  public void setCandidateAnswers(List<CandidateAnswerVariantWrapper> candidateAnswers) {
    this.candidateAnswers = candidateAnswers;
  }

}
