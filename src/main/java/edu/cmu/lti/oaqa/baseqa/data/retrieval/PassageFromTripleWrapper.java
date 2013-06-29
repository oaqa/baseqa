package edu.cmu.lti.oaqa.baseqa.data.retrieval;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.retrieval.Passage;
import org.oaqa.model.retrieval.PassageFromTriple;
import org.oaqa.model.retrieval.SearchResult;

import com.google.common.base.Objects;

import edu.cmu.lti.oaqa.baseqa.data.answer.CandidateAnswerVariantWrapper;
import edu.cmu.lti.oaqa.baseqa.data.core.OAQATopWrapper;
import edu.cmu.lti.oaqa.baseqa.data.core.TripleWrapper;

public class PassageFromTripleWrapper extends PassageWrapper {

  private static final long serialVersionUID = 1L;

  private TripleWrapper sourceTriple;

  public PassageFromTripleWrapper(String uri, float score, String text, int rank,
          String queryString, String searchId,
          List<CandidateAnswerVariantWrapper> candidateAnswers, String title, String docId,
          int begin, int end, String aspects, TripleWrapper sourceTriple) {
    super(uri, score, text, rank, queryString, searchId, candidateAnswers, title, docId, begin,
            end, aspects);
    this.sourceTriple = sourceTriple;
  }

  public PassageFromTripleWrapper(String uri, float score, String text, int rank,
          String queryString, String searchId,
          List<CandidateAnswerVariantWrapper> candidateAnswers, String title, String docId,
          int begin, int end, String aspects, TripleWrapper sourceTriple, String generator) {
    super(uri, score, text, rank, queryString, searchId, candidateAnswers, title, docId, begin,
            end, aspects, generator);
    this.sourceTriple = sourceTriple;
  }

  @Override
  public Class<? extends Passage> getTypeClass() {
    return PassageFromTriple.class;
  }

  @Override
  public void wrap(SearchResult top) throws AnalysisEngineProcessException {
    super.wrap(top);
    sourceTriple = OAQATopWrapper.wrap(((PassageFromTriple) top).getSourceTriple(),
            TripleWrapper.class);
  }

  @Override
  public Passage unwrap(JCas jcas) throws AnalysisEngineProcessException {
    PassageFromTriple top = (PassageFromTriple) super.unwrap(jcas);
    top.setSourceTriple(sourceTriple.unwrap(jcas));
    return top;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), sourceTriple);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    PassageFromTripleWrapper other = (PassageFromTripleWrapper) obj;
    return Objects.equal(sourceTriple, other.sourceTriple);
  }

  public TripleWrapper getSourceTriple() {
    return sourceTriple;
  }

  public void setSourceTriple(TripleWrapper sourceTriple) {
    this.sourceTriple = sourceTriple;
  }

}
