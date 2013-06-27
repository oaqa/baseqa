package edu.cmu.lti.oaqa.baseqa.data.core;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.core.Triple;

import com.google.common.base.Objects;

public class TripleWrapper extends OAQATopWrapper<Triple> {

  private static final long serialVersionUID = 1L;

  private String subject;

  private String predicate;

  private String object;

  private boolean isObjUri;

  public TripleWrapper(String subject, String predicate, String object, boolean isObjUri) {
    super();
    this.subject = subject;
    this.predicate = predicate;
    this.object = object;
    this.isObjUri = isObjUri;
  }

  @Override
  public Class<? extends Triple> getTypeClass() {
    return Triple.class;
  }

  @Override
  public void wrap(Triple top) throws AnalysisEngineProcessException {
    super.wrap(top);
    this.subject = top.getSubject();
    this.predicate = top.getPredicate();
    this.object = top.getObject();
    this.isObjUri = top.getIsObjUri();
  }

  @Override
  public Triple unwrap(JCas jcas) throws AnalysisEngineProcessException {
    Triple top = super.unwrap(jcas);
    top.setSubject(subject);
    top.setPredicate(predicate);
    top.setObject(object);
    top.setIsObjUri(isObjUri);
    return top;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(object, predicate, subject);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    TripleWrapper other = (TripleWrapper) obj;
    return Objects.equal(subject, other.subject) && Objects.equal(predicate, other.predicate)
            && Objects.equal(object, other.object);
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getPredicate() {
    return predicate;
  }

  public void setPredicate(String predicate) {
    this.predicate = predicate;
  }

  public String getObject() {
    return object;
  }

  public void setObject(String object) {
    this.object = object;
  }

  public boolean isObjUri() {
    return isObjUri;
  }

  public void setObjUri(boolean isObjUri) {
    this.isObjUri = isObjUri;
  }

}
