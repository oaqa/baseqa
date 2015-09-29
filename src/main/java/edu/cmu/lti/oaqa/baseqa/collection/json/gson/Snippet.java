package edu.cmu.lti.oaqa.baseqa.collection.json.gson;

public final class Snippet {

  private String document;

  private String text;

  private int offsetInBeginSection;

  private int offsetInEndSection;

  private String beginSection;

  private String endSection;

  public Snippet(String document, String text, int offsetInBeginSection, int offsetInEndSection,
          String beginSection, String endSection) {
    super();
    this.document = document;
    this.text = text;
    this.offsetInBeginSection = offsetInBeginSection;
    this.offsetInEndSection = offsetInEndSection;
    this.beginSection = beginSection;
    this.endSection = endSection;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((beginSection == null) ? 0 : beginSection.hashCode());
    result = prime * result + ((document == null) ? 0 : document.hashCode());
    result = prime * result + ((endSection == null) ? 0 : endSection.hashCode());
    result = prime * result + offsetInBeginSection;
    result = prime * result + offsetInEndSection;
    result = prime * result + ((text == null) ? 0 : text.hashCode());
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
    Snippet other = (Snippet) obj;
    if (beginSection == null) {
      if (other.beginSection != null)
        return false;
    } else if (!beginSection.equals(other.beginSection))
      return false;
    if (document == null) {
      if (other.document != null)
        return false;
    } else if (!document.equals(other.document))
      return false;
    if (endSection == null) {
      if (other.endSection != null)
        return false;
    } else if (!endSection.equals(other.endSection))
      return false;
    if (offsetInBeginSection != other.offsetInBeginSection)
      return false;
    if (offsetInEndSection != other.offsetInEndSection)
      return false;
    if (text == null) {
      if (other.text != null)
        return false;
    } else if (!text.equals(other.text))
      return false;
    return true;
  }

  public String getDocument() {
    return document;
  }

  public void setDocument(String document) {
    this.document = document;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public int getOffsetInBeginSection() {
    return offsetInBeginSection;
  }

  public void setOffsetInBeginSection(int offsetInBeginSection) {
    this.offsetInBeginSection = offsetInBeginSection;
  }

  public int getOffsetInEndSection() {
    return offsetInEndSection;
  }

  public void setOffsetInEndSection(int offsetInEndSection) {
    this.offsetInEndSection = offsetInEndSection;
  }

  public String getBeginSection() {
    return beginSection;
  }

  public void setBeginSection(String beginSection) {
    this.beginSection = beginSection;
  }

  public String getEndSection() {
    return endSection;
  }

  public void setEndSection(String endSection) {
    this.endSection = endSection;
  }

}