package edu.cmu.lti.oaqa.gerp.data;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.oaqa.model.gerp.Rank;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

import edu.cmu.lti.oaqa.core.data.WrapperIndexer;

public class RankWrapper extends GerpBaseWrapper<Rank> implements Comparable<RankWrapper> {

  private static final long serialVersionUID = 1L;

  private int rank;

  private float score;

  public RankWrapper(int rank, float score) {
    super();
    this.rank = rank;
    this.score = score;
  }

  public RankWrapper() {
    this(Integer.MAX_VALUE, Float.NEGATIVE_INFINITY);
  }

  @Override
  public Class<? extends Rank> getTypeClass() {
    return Rank.class;
  }

  @Override
  public void wrap(WrapperIndexer indexer, Rank top) throws AnalysisEngineProcessException {
    super.wrap(indexer, top);
    rank = top.getRank();
    score = top.getScore();
  }

  @Override
  public void unwrap(WrapperIndexer indexer, Rank top) throws AnalysisEngineProcessException {
    super.unwrap(indexer, top);
    top.setRank(rank);
    top.setScore(score);
  }

  @Override
  protected void wrapComments(WrapperIndexer indexer, Rank top) {
    // TODO Auto-generated method stub

  }

  @Override
  protected void unwrapComments(WrapperIndexer indexer, Rank top) {
    // TODO Auto-generated method stub

  }

  @Override
  public int compareTo(RankWrapper o) {
    return ComparisonChain.start().compare(rank, o.rank).result();
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(rank, score);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    RankWrapper other = (RankWrapper) obj;
    return Objects.equal(rank, other.rank) && Objects.equal(score, other.score);
  }

  @Override
  public String toString() {
    return score + "(" + rank + ")";
  }

  public int getRank() {
    return rank;
  }

  public void setRank(int rank) {
    this.rank = rank;
  }

  public float getScore() {
    return score;
  }

  public void setScore(float score) {
    this.score = score;
  }

}
