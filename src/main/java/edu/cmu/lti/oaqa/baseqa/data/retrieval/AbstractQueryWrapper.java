package edu.cmu.lti.oaqa.baseqa.data.retrieval;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.retrieval.AbstractQuery;

import com.google.common.base.Objects;

import edu.cmu.lti.oaqa.baseqa.data.core.WrapperHelper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.GerpTopWrapper;

public class AbstractQueryWrapper extends GerpTopWrapper<AbstractQuery> {

  private static final long serialVersionUID = 1L;

  private List<QueryConceptWrapper> concepts;

  public AbstractQueryWrapper(List<QueryConceptWrapper> concepts) {
    super();
    this.concepts = concepts;
  }

  public AbstractQueryWrapper(List<QueryConceptWrapper> concepts, String generator) {
    super(generator);
    this.concepts = concepts;
  }

  @Override
  public Class<? extends AbstractQuery> getTypeClass() {
    return AbstractQuery.class;
  }

  @Override
  public void wrap(AbstractQuery top) throws AnalysisEngineProcessException {
    super.wrap(top);
    try {
      this.concepts = WrapperHelper.wrapTopList(top.getConcepts(), QueryConceptWrapper.class);
    } catch (Exception e) {
      throw new AnalysisEngineProcessException(e);
    }
  }

  @Override
  public AbstractQuery unwrap(JCas jcas) throws AnalysisEngineProcessException {
    AbstractQuery top = super.unwrap(jcas);
    top.setConcepts(WrapperHelper.unwrapTopList(concepts, jcas));
    return top;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(concepts);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    AbstractQueryWrapper other = (AbstractQueryWrapper) obj;
    return Objects.equal(this.concepts, other.concepts);
  }

  public List<QueryConceptWrapper> getConcepts() {
    return concepts;
  }

  public void setConcepts(List<QueryConceptWrapper> concepts) {
    this.concepts = concepts;
  }

}
