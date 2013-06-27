package edu.cmu.lti.oaqa.baseqa.data.retrieval;

import java.util.List;

import org.oaqa.model.retrieval.AnswerSearchResult;

import edu.cmu.lti.oaqa.baseqa.data.answer.CandidateAnswerVariantWrapper;

public class AnswerSearchResultWrapper extends SearchResultWrapper<AnswerSearchResult> {

  private static final long serialVersionUID = 1L;

  @Override
  public Class<? extends AnswerSearchResult> getTypeClass() {
    return AnswerSearchResult.class;
  }

  public AnswerSearchResultWrapper(String uri, float score, String text, int rank,
          String queryString, String searchId, List<CandidateAnswerVariantWrapper> candidateAnswers) {
    super(uri, score, text, rank, queryString, searchId, candidateAnswers);
  }

  public AnswerSearchResultWrapper(String uri, float score, String text, int rank,
          String queryString, String searchId,
          List<CandidateAnswerVariantWrapper> candidateAnswers, String generator) {
    super(uri, score, text, rank, queryString, searchId, candidateAnswers, generator);
  }
}
