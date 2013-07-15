package edu.cmu.lti.oaqa.baseqa.data.retrieval;

import java.util.List;

import org.oaqa.model.retrieval.AnswerSearchResult;

import edu.cmu.lti.oaqa.baseqa.data.answer.CandidateAnswerVariantWrapper;

public class AnswerSearchResultWrapper extends SearchResultWrapper {

  private static final long serialVersionUID = 1L;

  public AnswerSearchResultWrapper(String uri, float score, String text, int rank,
          String queryString, String searchId, List<CandidateAnswerVariantWrapper> candidateAnswers) {
    super(uri, score, text, rank, queryString, searchId, candidateAnswers);
  }

  public AnswerSearchResultWrapper(String uri, float score, String text, int rank,
          String queryString, String searchId,
          List<CandidateAnswerVariantWrapper> candidateAnswers, String generator) {
    this(uri, score, text, rank, queryString, searchId, candidateAnswers);
    addGenerator(generator);
  }

  @Override
  public Class<? extends AnswerSearchResult> getTypeClass() {
    return AnswerSearchResult.class;
  }

}
