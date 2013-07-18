package edu.cmu.lti.oaqa.baseqa.data.retrieval;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.oaqa.model.retrieval.Document;
import org.oaqa.model.retrieval.SearchResult;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.data.answer.CandidateAnswerVariantWrapper;

public class DocumentWrapper extends SearchResultWrapper {

  private static final long serialVersionUID = 1L;

  private String title;

  private String docId;

  public DocumentWrapper(String uri, float score, String text, int rank, String queryString,
          String searchId, List<CandidateAnswerVariantWrapper> candidateAnswers, String title,
          String docId) {
    super(uri, score, text, rank, queryString, searchId, candidateAnswers);
    this.title = title;
    this.docId = docId;
  }

  public DocumentWrapper(String uri, float score, String text, int rank, String queryString,
          String searchId, List<CandidateAnswerVariantWrapper> candidateAnswers, String title,
          String docId, String generator) {
    this(uri, score, text, rank, queryString, searchId, candidateAnswers, title, docId);
    addGenerator(generator);
  }

  public DocumentWrapper() {
    this(null, Float.NEGATIVE_INFINITY, null, Integer.MAX_VALUE, null, null, Lists
            .<CandidateAnswerVariantWrapper> newArrayList(), null, null);
  }

  @Override
  public Class<? extends Document> getTypeClass() {
    return Document.class;
  }

  @Override
  public void wrap(SearchResult top) throws AnalysisEngineProcessException {
    super.wrap(top);
    this.title = ((Document) top).getTitle();
    this.docId = ((Document) top).getDocId();
  }

  @Override
  public void unwrap(SearchResult top) throws AnalysisEngineProcessException {
    super.unwrap(top);
    ((Document) top).setTitle(title);
    ((Document) top).setDocId(docId);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), docId);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    DocumentWrapper other = (DocumentWrapper) obj;
    return Objects.equal(this.docId, other.docId);
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

}
