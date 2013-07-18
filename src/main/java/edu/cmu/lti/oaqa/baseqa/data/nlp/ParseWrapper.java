package edu.cmu.lti.oaqa.baseqa.data.nlp;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.nlp.Parse;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.data.core.WrapperHelper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.GerpTopWrapper;

public class ParseWrapper extends GerpTopWrapper<Parse> {

  private static final long serialVersionUID = 1L;

  private List<TokenWrapper> tokens;

  private List<SemanticRoleWrapper> semanticRoles;

  public ParseWrapper(List<TokenWrapper> tokens, List<SemanticRoleWrapper> semanticRoles) {
    super();
    this.tokens = tokens;
    this.semanticRoles = semanticRoles;
  }

  public ParseWrapper(List<TokenWrapper> tokens, List<SemanticRoleWrapper> semanticRoles,
          String generator) {
    this(tokens, semanticRoles);
    addGenerator(generator);
  }

  public ParseWrapper() {
    this(Lists.<TokenWrapper> newArrayList(), Lists.<SemanticRoleWrapper> newArrayList());
  }

  @Override
  public void wrap(Parse top) throws AnalysisEngineProcessException {
    super.wrap(top);
    this.tokens = WrapperHelper.wrapAnnotationList(top.getTokens(), TokenWrapper.class);
    this.semanticRoles = WrapperHelper.wrapAnnotationList(top.getSemanticRoles(),
            SemanticRoleWrapper.class);
  }

  @Override
  public void unwrap(Parse top) throws AnalysisEngineProcessException {
    super.unwrap(top);
    JCas jcas = WrapperHelper.getJCas(top);
    top.setTokens(WrapperHelper.unwrapAnnotationList(tokens, jcas));
    top.setSemanticRoles(WrapperHelper.unwrapAnnotationList(semanticRoles, jcas));
  }

  @Override
  public Class<? extends Parse> getTypeClass() {
    return Parse.class;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(tokens, semanticRoles);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ParseWrapper other = (ParseWrapper) obj;
    return Objects.equal(this.tokens, other.tokens)
            && Objects.equal(this.semanticRoles, other.semanticRoles);
  }

  public List<TokenWrapper> getTokens() {
    return tokens;
  }

  public void setTokens(List<TokenWrapper> tokens) {
    this.tokens = tokens;
  }

  public List<SemanticRoleWrapper> getSemanticRoles() {
    return semanticRoles;
  }

  public void setSemanticRoles(List<SemanticRoleWrapper> semanticRoles) {
    this.semanticRoles = semanticRoles;
  }

}
