package edu.cmu.lti.oaqa.baseqa.data.retrieval;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.oaqa.model.retrieval.EntitySearchResult;
import org.oaqa.model.retrieval.SearchResult;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.data.answer.CandidateAnswerVariantWrapper;
import edu.cmu.lti.oaqa.baseqa.data.kb.EntityWrapper;
import edu.cmu.lti.oaqa.core.data.WrapperHelper;
import edu.cmu.lti.oaqa.core.data.WrapperIndexer;

public class EntitySearchResultWrapper extends AnswerSearchResultWrapper {

  private static final long serialVersionUID = 1L;

  private List<EntityWrapper> entities;

  public EntitySearchResultWrapper(String uri, float score, String text, int rank,
          String queryString, String searchId,
          List<CandidateAnswerVariantWrapper> candidateAnswers, List<EntityWrapper> entities) {
    super(uri, score, text, rank, queryString, searchId, candidateAnswers);
    this.entities = entities;
  }

  public EntitySearchResultWrapper(String uri, float score, String text, int rank,
          String queryString, String searchId,
          List<CandidateAnswerVariantWrapper> candidateAnswers, List<EntityWrapper> entities,
          String generator) {
    this(uri, score, text, rank, queryString, searchId, candidateAnswers, entities);
    addGenerator(generator);
  }

  public EntitySearchResultWrapper() {
    this(null, Float.NEGATIVE_INFINITY, null, Integer.MAX_VALUE, null, null, Lists
            .<CandidateAnswerVariantWrapper> newArrayList(), Lists.<EntityWrapper> newArrayList());
  }

  @Override
  public Class<? extends EntitySearchResult> getTypeClass() {
    return EntitySearchResult.class;
  }

  @Override
  public void wrap(WrapperIndexer indexer, SearchResult top) throws AnalysisEngineProcessException {
    super.wrap(indexer, top);
    this.entities = WrapperHelper.wrapTopArray(indexer, ((EntitySearchResult) top).getEntities(),
            EntityWrapper.class);
  }

  @Override
  public void unwrap(WrapperIndexer indexer, SearchResult top)
          throws AnalysisEngineProcessException {
    super.unwrap(indexer, top);
    ((EntitySearchResult) top).setEntities(WrapperHelper.unwrapTopArray(indexer, entities,
            WrapperHelper.getJCas(top)));
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), entities);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    EntitySearchResultWrapper other = (EntitySearchResultWrapper) obj;
    return Objects.equal(this.entities, other.entities);
  }

  public List<EntityWrapper> getEntities() {
    return entities;
  }

  public void setEntities(List<EntityWrapper> entities) {
    this.entities = entities;
  }

}
