package edu.cmu.lti.oaqa.baseqa.data.kb;

import org.oaqa.model.kb.EntityMention;

public class EntityMentionWrapper extends ConceptMentionWrapper {

  private static final long serialVersionUID = 1L;

  public EntityMentionWrapper(int begin, int end, ConceptWrapper concept) {
    super(begin, end, concept);
  }

  public EntityMentionWrapper(int begin, int end, ConceptWrapper concept, String generator) {
    this(begin, end, concept);
    addGenerator(generator);
  }

  public EntityMentionWrapper() {
    this(0, Integer.MAX_VALUE, null);
  }

  @Override
  public Class<? extends EntityMention> getTypeClass() {
    return EntityMention.class;
  }

}
