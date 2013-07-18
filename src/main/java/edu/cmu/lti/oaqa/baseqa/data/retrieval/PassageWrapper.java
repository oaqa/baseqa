package edu.cmu.lti.oaqa.baseqa.data.retrieval;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.oaqa.model.retrieval.Passage;
import org.oaqa.model.retrieval.SearchResult;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.data.answer.CandidateAnswerVariantWrapper;

public class PassageWrapper extends SearchResultWrapper {

  private static final long serialVersionUID = 1L;

  private String title;

  private String docId;

  private int begin;

  private int end;

  private String aspects;

  public PassageWrapper(String uri, float score, String text, int rank, String queryString,
          String searchId, List<CandidateAnswerVariantWrapper> candidateAnswers, String title,
          String docId, int begin, int end, String aspects) {
    super(uri, score, text, rank, queryString, searchId, candidateAnswers);
    this.title = title;
    this.docId = docId;
    this.begin = begin;
    this.end = end;
    this.aspects = aspects;
  }

  public PassageWrapper(String uri, float score, String text, int rank, String queryString,
          String searchId, List<CandidateAnswerVariantWrapper> candidateAnswers, String title,
          String docId, int begin, int end, String aspects, String generator) {
    this(uri, score, text, rank, queryString, searchId, candidateAnswers, title, docId, begin, end,
            aspects);
    addGenerator(generator);
  }

  public PassageWrapper() {
    this(null, Float.NEGATIVE_INFINITY, null, Integer.MAX_VALUE, null, null, Lists
            .<CandidateAnswerVariantWrapper> newArrayList(), null, null, 0, Integer.MAX_VALUE, null);
  }

  @Override
  public Class<? extends Passage> getTypeClass() {
    return Passage.class;
  }

  @Override
  public void wrap(SearchResult top) throws AnalysisEngineProcessException {
    super.wrap(top);
    this.title = ((Passage) top).getTitle();
    this.docId = ((Passage) top).getDocId();
    this.begin = ((Passage) top).getBegin();
    this.end = ((Passage) top).getEnd();
    this.aspects = ((Passage) top).getAspects();
  }

  @Override
  public void unwrap(SearchResult top) throws AnalysisEngineProcessException {
    super.unwrap(top);
    ((Passage) top).setTitle(title);
    ((Passage) top).setDocId(docId);
    ((Passage) top).setBegin(begin);
    ((Passage) top).setEnd(end);
    ((Passage) top).setAspects(aspects);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), docId, begin, end);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    PassageWrapper other = (PassageWrapper) obj;
    return Objects.equal(this.docId, other.docId) && Objects.equal(this.begin, other.begin)
            && Objects.equal(this.end, other.end);
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDocId() {
    return docId;
  }

  public void setDocId(String docId) {
    this.docId = docId;
  }

  public int getBegin() {
    return begin;
  }

  public void setBegin(int begin) {
    this.begin = begin;
  }

  public int getEnd() {
    return end;
  }

  public void setEnd(int end) {
    this.end = end;
  }

  public String getAspects() {
    return aspects;
  }

  public void setAspects(String aspects) {
    this.aspects = aspects;
  }

}
