package edu.cmu.lti.oaqa.baseqa.data.retrieval;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.retrieval.Passage;
import org.oaqa.model.retrieval.PassageFromRelation;
import org.oaqa.model.retrieval.SearchResult;

import com.google.common.base.Objects;

import edu.cmu.lti.oaqa.baseqa.data.answer.CandidateAnswerVariantWrapper;
import edu.cmu.lti.oaqa.baseqa.data.core.WrapperHelper;
import edu.cmu.lti.oaqa.baseqa.data.kb.RelationWrapper;

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
    super(uri, score, text, rank, queryString, searchId, candidateAnswers, title, docId, begin,
            end, aspects, generator);
    this.sourceRelation = sourceRelation;
  }

  @Override
  public Class<? extends Passage> getTypeClass() {
    return PassageFromRelation.class;
  }

  @Override
  public void wrap(SearchResult top) throws AnalysisEngineProcessException {
    super.wrap(top);
    try {
      sourceRelation = WrapperHelper.matchSubclassAndWrap(
              ((PassageFromRelation) top).getSourceRelation(), RelationWrapper.class);
    } catch (Exception e) {
      throw new AnalysisEngineProcessException(e);
    }
  }

  @Override
  public PassageFromRelation unwrap(JCas jcas) throws AnalysisEngineProcessException {
    PassageFromRelation top = (PassageFromRelation) super.unwrap(jcas);
    top.setSourceRelation(sourceRelation.unwrap(jcas));
    return top;
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
