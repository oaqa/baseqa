package edu.cmu.lti.oaqa.baseqa.data.kb;

import java.util.List;

import org.oaqa.model.kb.Entity;

import com.google.common.collect.Lists;

public class EntityWrapper extends ConceptWrapper {

  private static final long serialVersionUID = 1L;

  public EntityWrapper(String name, List<String> ids, List<ConceptMentionWrapper> mentions) {
    super(name, ids, mentions);
  }

  public EntityWrapper(String name, List<String> ids, List<ConceptMentionWrapper> mentions,
          String generator) {
    this(name, ids, mentions);
    addGenerator(generator);
  }

  public EntityWrapper() {
    this(null, Lists.<String> newArrayList(), Lists.<ConceptMentionWrapper> newArrayList());
  }

  @Override
  public Class<? extends Entity> getTypeClass() {
    return Entity.class;
  }

}
