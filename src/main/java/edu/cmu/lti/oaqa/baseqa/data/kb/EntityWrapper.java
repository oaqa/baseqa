package edu.cmu.lti.oaqa.baseqa.data.kb;

import java.util.List;

import org.oaqa.model.kb.Entity;

public class EntityWrapper extends ConceptWrapper {

  private static final long serialVersionUID = 1L;

  public EntityWrapper(String name, List<String> ids, List<ConceptMentionWrapper> mentions) {
    super(name, ids, mentions);
  }

  public EntityWrapper(String name, List<String> ids, List<ConceptMentionWrapper> mentions,
          String generator) {
    super(name, ids, mentions, generator);
  }

  @Override
  public Class<? extends Entity> getTypeClass() {
    return Entity.class;
  }

}
