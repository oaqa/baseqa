package edu.cmu.lti.oaqa.baseqa.data.retrieval;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.retrieval.QueryOperator;

import com.google.common.base.Objects;

import edu.cmu.lti.oaqa.baseqa.data.core.WrapperHelper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.GerpTopWrapper;

public class QueryOperatorWrapper extends GerpTopWrapper<QueryOperator> {

  private static final long serialVersionUID = 1L;

  private String name;

  private List<String> args;

  public QueryOperatorWrapper(String name, List<String> args) {
    super();
    this.name = name;
    this.args = args;
  }

  public QueryOperatorWrapper(String name, List<String> args, String generator) {
    super(generator);
    this.name = name;
    this.args = args;
  }

  @Override
  public Class<? extends QueryOperator> getTypeClass() {
    return QueryOperator.class;
  }

  @Override
  public void wrap(QueryOperator top) throws AnalysisEngineProcessException {
    super.wrap(top);
    this.name = top.getName();
    this.args = WrapperHelper.wrapStringList(top.getArgs());
  }

  @Override
  public QueryOperator unwrap(JCas jcas) throws AnalysisEngineProcessException {
    QueryOperator top = super.unwrap(jcas);
    top.setName(name);
    top.setArgs(WrapperHelper.unwrapStringList(args, jcas));
    return top;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), name, args);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    QueryOperatorWrapper other = (QueryOperatorWrapper) obj;
    return Objects.equal(name, other.name) && Objects.equal(args, other.args);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getArgs() {
    return args;
  }

  public void setArgs(List<String> args) {
    this.args = args;
  }

}
