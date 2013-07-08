package edu.cmu.lti.oaqa.baseqa.data.kb;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.kb.ConceptMention;
import org.oaqa.model.kb.RelationMention;

import com.google.common.base.Objects;

import edu.cmu.lti.oaqa.baseqa.data.core.WrapperHelper;

public class RelationMentionWrapper extends ConceptMentionWrapper {

  private static final long serialVersionUID = 1L;

  private List<EntityMentionWrapper> argumentMentions;

  public RelationMentionWrapper(int begin, int end, ConceptWrapper concept,
          List<EntityMentionWrapper> argumentMentions) {
    super(begin, end, concept);
    this.argumentMentions = argumentMentions;
  }

  public RelationMentionWrapper(int begin, int end, ConceptWrapper concept,
          List<EntityMentionWrapper> argumentMentions, String generator) {
    super(begin, end, concept, generator);
    this.argumentMentions = argumentMentions;
  }

  @Override
  public Class<? extends RelationMention> getTypeClass() {
    return RelationMention.class;
  }

  @Override
  public void wrap(ConceptMention top) throws AnalysisEngineProcessException {
    super.wrap(top);
    try {
      this.argumentMentions = WrapperHelper.wrapAnnotationList(
              ((RelationMention) top).getArgumentMentions(), EntityMentionWrapper.class);
    } catch (Exception e) {
      throw new AnalysisEngineProcessException(e);
    }
  }

  @Override
  public RelationMention unwrap(JCas jcas) throws AnalysisEngineProcessException {
    RelationMention top = (RelationMention) super.unwrap(jcas);
    top.setArgumentMentions(WrapperHelper.unwrapAnnotationList(argumentMentions, jcas));
    return top;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), argumentMentions);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    RelationMentionWrapper other = (RelationMentionWrapper) obj;
    return Objects.equal(argumentMentions, other.argumentMentions);
  }

  public List<EntityMentionWrapper> getArgumentMentions() {
    return argumentMentions;
  }

  public void setArguments(List<EntityMentionWrapper> argumentMentions) {
    this.argumentMentions = argumentMentions;
  }

}
