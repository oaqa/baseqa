package edu.cmu.lti.oaqa.baseqa.data.retrieval;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.oaqa.model.kb.Relation;
import org.oaqa.model.retrieval.Passage;
import org.oaqa.model.retrieval.PassageFromRelation;
import org.oaqa.model.retrieval.SearchResult;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.data.answer.CandidateAnswerVariantWrapper;
import edu.cmu.lti.oaqa.baseqa.data.kb.RelationWrapper;
import edu.cmu.lti.oaqa.core.data.WrapperHelper;

public class PassageFromRelationWrapper extends PassageWrapper {

  private static final long serialVersionUID = 1L;

  private RelationWrapper sourceRelation;

  public PassageFromRelationWrapper(String uri, float score, String text, int rank,
          String queryString, String searchId,
          List<CandidateAnswerVariantWrapper> candidateAnswers, String title, String docId,
          int begin, int end, String aspects, RelationWrapper sourceRelation) {
    super(uri, score, text, rank, queryString, searchId, candidateAnswers, title, docId, begin,
            end, aspects);
    this.sourceRelation = sourceRelation;
  }

  public PassageFromRelationWrapper(String uri, float score, String text, int rank,
          String queryString, String searchId,
          List<CandidateAnswerVariantWrapper> candidateAnswers, String title, String docId,
          int begin, int end, String aspects, RelationWrapper sourceRelation, String generator) {
    this(uri, score, text, rank, queryString, searchId, candidateAnswers, title, docId, begin, end,
            aspects, sourceRelation);
    addGenerator(generator);
  }

  public PassageFromRelationWrapper() {
    this(null, Float.NEGATIVE_INFINITY, null, Integer.MAX_VALUE, null, null, Lists
            .<CandidateAnswerVariantWrapper> newArrayList(), null, null, 0, Integer.MAX_VALUE,
            null, null);
  }

  @Override
  public Class<? extends Passage> getTypeClass() {
    return PassageFromRelation.class;
  }

  @Override
  public void wrap(SearchResult top) throws AnalysisEngineProcessException {
    super.wrap(top);
    if (((PassageFromRelation) top).getSourceRelation() != null) {
      sourceRelation = WrapperHelper.matchSubclassAndWrap(
              ((PassageFromRelation) top).getSourceRelation(), RelationWrapper.class);
    }
  }

  @Override
  public void unwrap(SearchResult top) throws AnalysisEngineProcessException {
    super.unwrap(top);
    if (sourceRelation != null) {
      ((PassageFromRelation) top).setSourceRelation((Relation) WrapperHelper.unwrap(sourceRelation,
              WrapperHelper.getJCas(top)));
    }
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), sourceRelation);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    PassageFromRelationWrapper other = (PassageFromRelationWrapper) obj;
    return Objects.equal(this.sourceRelation, other.sourceRelation);
  }

  public RelationWrapper getSourceRelation() {
    return sourceRelation;
  }

  public void setSourceRelation(RelationWrapper sourceRelation) {
    this.sourceRelation = sourceRelation;
  }

}
