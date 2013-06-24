package edu.cmu.lti.oaqa.baseqa.data.corpus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Article {

  private String id;

  private String text;

  private List<TextSpan> legalspans = new ArrayList<TextSpan>();

  private boolean legalspanSorted = false;

  private List<TextSpan> sentences = new ArrayList<TextSpan>();

  private boolean sentenceSorted = false;

  public Article(String id, String documentText) {
    this.id = id;
    this.text = documentText;
  }

  public void addLegalSpan(int begin, int end) {
    legalspanSorted = false;
    legalspans.add(new TextSpan(begin, end));
  }

  public List<TextSpan> getLegalSpans() {
    sortLegalSpansIfNeeded();
    return legalspans;
  }

  public boolean isSpanLegal(TextSpan span) {
    sortLegalSpansIfNeeded();
    int index = Collections.binarySearch(legalspans, span);
    // exactly a legal span
    if (index >= 0) {
      return true;
    }
    int insertPos = -index - 1;
    // smaller than any existing legal span
    if (insertPos == 0) {
      return false;
    }
    // compare "end" with the previous legal span, as "begin" is guaranteed to be greater than or
    // equal to that of the previous legal span.
    return span.end <= legalspans.get(insertPos - 1).end;
  }

  public void addSentence(int begin, int end) {
    sentenceSorted = false;
    sentences.add(new TextSpan(begin, end));
  }

  private void sortLegalSpansIfNeeded() {
    if (!legalspanSorted) {
      Collections.sort(legalspans);
      legalspanSorted = true;
    }
  }

  public List<TextSpan> getSentences() {
    sortSentencesIfNeeded();
    return sentences;
  }

  private void sortSentencesIfNeeded() {
    if (!sentenceSorted) {
      Collections.sort(sentences);
      sentenceSorted = true;
    }
  }

  public String getSpanText(TextSpan span) {
    return text.substring(span.begin, span.end);
  }
  
  public String getId() {
    return id;
  }

  public String getText() {
    return text;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Article other = (Article) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return id;
  }

}
