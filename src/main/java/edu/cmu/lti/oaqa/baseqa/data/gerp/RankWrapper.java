package edu.cmu.lti.oaqa.baseqa.data.gerp;

import org.oaqa.model.gerp.Rank;

import edu.cmu.lti.oaqa.baseqa.data.core.OAQATopWrapper;

public class RankWrapper extends OAQATopWrapper<Rank> {

  @Override
  public Class<? extends Rank> getTypeClass() {
    return Rank.class;
  }

}
