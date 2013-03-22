package edu.cmu.lti.oaqa.framework.eval.gs;


/**
 * Equivalent to Annotation, without the requirement to specify a CAS for the annotation, since
 * during initialize(), the CAS is still not clear to the pipeline.
 * 
 * @author Zi Yang <ziy@cs.cmu.edu>
 * 
 */
public class GoldStandardSpan {
  String docId;

  int begin, end;

  String aspects;

  public GoldStandardSpan(String docId, int begin, int end, String aspects) {
    super();
    this.docId = docId;
    this.begin = begin;
    this.end = end;
    this.aspects = aspects;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + begin;
    result = prime * result + ((docId == null) ? 0 : docId.hashCode());
    result = prime * result + end;
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
    GoldStandardSpan other = (GoldStandardSpan) obj;
    if (begin != other.begin)
      return false;
    if (docId == null) {
      if (other.docId != null)
        return false;
    } else if (!docId.equals(other.docId))
      return false;
    if (end != other.end)
      return false;
    return true;
  }
}
