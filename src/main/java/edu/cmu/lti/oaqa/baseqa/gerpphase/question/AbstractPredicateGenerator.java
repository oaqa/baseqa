package edu.cmu.lti.oaqa.baseqa.gerpphase.question;

import java.util.List;

import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.data.core.OAQATopWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.PredicateWrapper;
import edu.cmu.lti.oaqa.baseqa.gerpphase.core.generator.AbstractGenerator;

public abstract class AbstractPredicateGenerator extends AbstractGenerator<PredicateWrapper> {

  @Override
  public List<Class<? extends OAQATopWrapper<?>>> getRequiredInputTypes() {
    return Lists.newArrayList(InputElementWrapper.class);
  }
}
