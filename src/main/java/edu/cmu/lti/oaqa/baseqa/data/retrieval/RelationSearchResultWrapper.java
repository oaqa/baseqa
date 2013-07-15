package edu.cmu.lti.oaqa.baseqa.data.retrieval;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.retrieval.RelationSearchResult;
import org.oaqa.model.retrieval.SearchResult;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.data.answer.CandidateAnswerVariantWrapper;
import edu.cmu.lti.oaqa.baseqa.data.core.WrapperHelper;
import edu.cmu.lti.oaqa.baseqa.data.kb.RelationWrapper;

public class RelationSearchResultWrapper extends AnswerSearchResultWrapper {

  private static final long serialVersionUID = 1L;

  private List<RelationWrapper> context;

  public RelationSearchResultWrapper(String uri, float score, String text, int rank,
          String queryString, String searchId,
          List<CandidateAnswerVariantWrapper> candidateAnswers, List<RelationWrapper> context) {
    super(uri, score, text, rank, queryString, searchId, candidateAnswers);
    this.context = context;
  }

  public RelationSearchResultWrapper(String uri, float score, String text, int rank,
          String queryString, String searchId,
          List<CandidateAnswerVariantWrapper> candidateAnswers, List<RelationWrapper> context,
          String generator) {
    this(uri, score, text, rank, queryString, searchId, candidateAnswers, context);
    addGenerator(generator);
  }

  public RelationSearchResultWrapper() {
    this(null, Float.NEGATIVE_INFINITY, null, Integer.MAX_VALUE, null, null, Lists
            .<CandidateAnswerVariantWrapper> newArrayList(), Lists.<RelationWrapper> newArrayList());
  }

  @Override
  public Class<? extends RelationSearchResult> getTypeClass() {
    return RelationSearchResult.class;
  }

  @Override
  public void wrap(SearchResult top) throws AnalysisEngineProcessException {
    super.wrap(top);
    try {
      this.context = WrapperHelper.wrapTopArray(((RelationSearchResult) top).getContext(),
              RelationWrapper.class);
    } catch (Exception e) {
      throw new AnalysisEngineProcessException(e);
    }
  }

  @Override
  public RelationSearchResult unwrap(JCas jcas) throws AnalysisEngineProcessException {
    RelationSearchResult top = (RelationSearchResult) super.unwrap(jcas);
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
    RelationSearchResultWrapper other = (RelationSearchResultWrapper) obj;
    return Objects.equal(this.context, other.context);
  }

  public List<RelationWrapper> getContext() {
    return context;
  }

  public void setContext(List<RelationWrapper> context) {
    this.context = context;
  }

}
