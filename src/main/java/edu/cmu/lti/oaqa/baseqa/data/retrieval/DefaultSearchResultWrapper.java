package edu.cmu.lti.oaqa.baseqa.data.retrieval;

import java.util.List;

import org.oaqa.model.retrieval.SearchResult;

import edu.cmu.lti.oaqa.baseqa.data.answer.CandidateAnswerVariantWrapper;

public class DefaultSearchResultWrapper extends SearchResultWrapper<SearchResult> {

  private static final long serialVersionUID = 1L;

  @Override
  public Class<? extends SearchResult> getTypeClass() {
    return SearchResult.class;
  }

  public DefaultSearchResultWrapper(String uri, float score, String text, int rank,
          String queryString, String searchId, List<CandidateAnswerVariantWrapper> candidateAnswers) {
    super(uri, score, text, rank, queryString, searchId, candidateAnswers);
  }

  public DefaultSearchResultWrapper(String uri, float score, String text, int rank,
          String queryString, String searchId,
          List<CandidateAnswerVariantWrapper> candidateAnswers, String generator) {
    super(uri, score, text, rank, queryString, searchId, candidateAnswers, generator);
  }
}
