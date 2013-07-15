package edu.cmu.lti.oaqa.baseqa.data.kb;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.kb.ConceptMention;
import org.oaqa.model.kb.RelationMention;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

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
    this(begin, end, concept, argumentMentions);
    addGenerator(generator);
  }

  public RelationMentionWrapper() {
    this(0, Integer.MAX_VALUE, null, Lists.<EntityMentionWrapper> newArrayList());
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
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    RelationMentionWrapper other = (RelationMentionWrapper) obj;
    return Objects.equal(this.argumentMentions, other.argumentMentions);
  }

  public List<EntityMentionWrapper> getArgumentMentions() {
    return argumentMentions;
  }

  public void setArguments(List<EntityMentionWrapper> argumentMentions) {
    this.argumentMentions = argumentMentions;
  }

}
