package edu.cmu.lti.oaqa.baseqa.framework.eval.gs;

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

}