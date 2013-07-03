package edu.cmu.lti.oaqa.baseqa.data.retrieval;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.retrieval.AnswerSearchResult;
import org.oaqa.model.retrieval.SearchResult;
import org.oaqa.model.retrieval.TripleStoreSearchResult;

import com.google.common.base.Objects;

import edu.cmu.lti.oaqa.baseqa.data.answer.CandidateAnswerVariantWrapper;
import edu.cmu.lti.oaqa.baseqa.data.core.TripleWrapper;
import edu.cmu.lti.oaqa.baseqa.data.core.WrapperHelper;

public class TripleStoreSearchResultWrapper extends AnswerSearchResultWrapper {

  private static final long serialVersionUID = 1L;

  private List<TripleWrapper> context;

  public TripleStoreSearchResultWrapper(String uri, float score, String text, int rank,
          String queryString, String searchId,
          List<CandidateAnswerVariantWrapper> candidateAnswers, List<TripleWrapper> context) {
    super(uri, score, text, rank, queryString, searchId, candidateAnswers);
    this.context = context;
  }

  public TripleStoreSearchResultWrapper(String uri, float score, String text, int rank,
          String queryString, String searchId,
          List<CandidateAnswerVariantWrapper> candidateAnswers, List<TripleWrapper> context,
          String generator) {
    super(uri, score, text, rank, queryString, searchId, candidateAnswers, generator);
    this.context = context;
  }

  @Override
  public Class<? extends AnswerSearchResult> getTypeClass() {
    return TripleStoreSearchResult.class;
  }

  @Override
  public void wrap(SearchResult top) throws AnalysisEngineProcessException {
    super.wrap(top);
    try {
      this.context = WrapperHelper.wrapTopArray(((TripleStoreSearchResult) top).getContext(),
              TripleWrapper.class);
    } catch (Exception e) {
      throw new AnalysisEngineProcessException(e);
    }
  }

  @Override
  public AnswerSearchResult unwrap(JCas jcas) throws AnalysisEngineProcessException {
    TripleStoreSearchResult top = (TripleStoreSearchResult) super.unwrap(jcas);
    top.setContext(WrapperHelper.unwrapTopArray(context, jcas));
    return top;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), context);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    TripleStoreSearchResultWrapper other = (TripleStoreSearchResultWrapper) obj;
    return Objects.equal(context, other.context);
  }

  public List<TripleWrapper> getContext() {
    return context;
  }

  public void setContext(List<TripleWrapper> context) {
    this.context = context;
  }

}
