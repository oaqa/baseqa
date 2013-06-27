package edu.cmu.lti.oaqa.baseqa.data.nlp;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.nlp.NamedEntity;

import com.google.common.base.Objects;

import edu.cmu.lti.oaqa.baseqa.data.core.TripleWrapper;
import edu.cmu.lti.oaqa.baseqa.data.core.WrapperHelper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.GerpAnnotationWrapper;

public class NamedEntityWrapper extends GerpAnnotationWrapper<NamedEntity> {

  private static final long serialVersionUID = 1L;

  private List<String> ids;

  private List<TripleWrapper> context;

  public NamedEntityWrapper(int begin, int end, List<String> ids, List<TripleWrapper> context) {
    super(begin, end);
    this.ids = ids;
    this.context = context;
  }

  public NamedEntityWrapper(int begin, int end, List<String> ids, List<TripleWrapper> context,
          String generator) {
    super(begin, end, generator);
    this.ids = ids;
    this.context = context;
  }

  @Override
  public Class<? extends NamedEntity> getTypeClass() {
    return NamedEntity.class;
  }

  @Override
  public void wrap(NamedEntity annotation) throws AnalysisEngineProcessException {
    super.wrap(annotation);
    ids = WrapperHelper.wrapStringArray(annotation.getIds());
    context = WrapperHelper.wrapTopArray(annotation.getContext(), TripleWrapper.class);
  }

  @Override
  public NamedEntity unwrap(JCas jcas) throws AnalysisEngineProcessException {
    NamedEntity annotation = super.unwrap(jcas);
    annotation.setIds(WrapperHelper.unwrapStringArray(ids, jcas));
    annotation.setContext(WrapperHelper.unwrapTopArray(context, jcas));
    return annotation;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode());
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    return true;
  }

  public List<String> getIds() {
    return ids;
  }

  public void setIds(List<String> ids) {
    this.ids = ids;
  }

  public List<TripleWrapper> getContext() {
    return context;
  }

  public void setContext(List<TripleWrapper> context) {
    this.context = context;
  }

}
