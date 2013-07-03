package edu.cmu.lti.oaqa.baseqa.data.nlp;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.nlp.Parse;

import com.google.common.base.Objects;

import edu.cmu.lti.oaqa.baseqa.data.core.WrapperHelper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.GerpTopWrapper;

public class ParseWrapper extends GerpTopWrapper<Parse> {

  private static final long serialVersionUID = 1L;

  private List<PredicateWrapper> predicates;

  private List<NamedEntityWrapper> namedEntities;

  private List<SemanticRoleWrapper> semanticRoles;

  public ParseWrapper(List<PredicateWrapper> predicates, List<NamedEntityWrapper> namedEntities,
          List<SemanticRoleWrapper> semanticRoles) {
    super();
    this.predicates = predicates;
    this.namedEntities = namedEntities;
    this.semanticRoles = semanticRoles;
  }

  public ParseWrapper(List<PredicateWrapper> predicates, List<NamedEntityWrapper> namedEntities,
          List<SemanticRoleWrapper> semanticRoles, String generator) {
    super(generator);
    this.predicates = predicates;
    this.namedEntities = namedEntities;
    this.semanticRoles = semanticRoles;
  }

  @Override
  public void wrap(Parse top) throws AnalysisEngineProcessException {
    super.wrap(top);
    try {
      this.predicates = WrapperHelper.wrapAnnotationList(top.getPredicates(),
              PredicateWrapper.class);
      this.namedEntities = WrapperHelper.wrapAnnotationList(top.getNamedEntities(),
              NamedEntityWrapper.class);
      this.semanticRoles = WrapperHelper.wrapAnnotationList(top.getSemanticRoles(),
              SemanticRoleWrapper.class);
    } catch (Exception e) {
      throw new AnalysisEngineProcessException(e);
    }
  }

  @Override
  public Parse unwrap(JCas jcas) throws AnalysisEngineProcessException {
    Parse top = super.unwrap(jcas);
    top.setPredicates(WrapperHelper.unwrapAnnotationList(predicates, jcas));
    top.setNamedEntities(WrapperHelper.unwrapAnnotationList(namedEntities, jcas));
    top.setSemanticRoles(WrapperHelper.unwrapAnnotationList(semanticRoles, jcas));
    return top;
  }

  @Override
  public Class<? extends Parse> getTypeClass() {
    return Parse.class;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), predicates, namedEntities, semanticRoles);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    ParseWrapper other = (ParseWrapper) obj;
    return Objects.equal(predicates, other.predicates)
            && Objects.equal(namedEntities, other.namedEntities)
            && Objects.equal(semanticRoles, other.semanticRoles);
  }

  public List<PredicateWrapper> getPredicates() {
    return predicates;
  }

  public void setPredicates(List<PredicateWrapper> predicates) {
    this.predicates = predicates;
  }

  public List<NamedEntityWrapper> getNamedEntities() {
    return namedEntities;
  }

  public void setNamedEntities(List<NamedEntityWrapper> namedEntities) {
    this.namedEntities = namedEntities;
  }

  public List<SemanticRoleWrapper> getSemanticRoles() {
    return semanticRoles;
  }

  public void setSemanticRoles(List<SemanticRoleWrapper> semanticRoles) {
    this.semanticRoles = semanticRoles;
  }

}
