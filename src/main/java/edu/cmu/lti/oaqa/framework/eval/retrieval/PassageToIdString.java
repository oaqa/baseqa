package edu.cmu.lti.oaqa.framework.eval.retrieval;

import org.oaqa.model.Passage;

import com.google.common.base.Function;

public final class PassageToIdString implements Function<Passage, String> {
  @Override
  public String apply(Passage input) {
    return input.getUri();
  }
}