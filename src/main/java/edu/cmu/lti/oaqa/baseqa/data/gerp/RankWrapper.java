package edu.cmu.lti.oaqa.baseqa.data.gerp;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSList;
import org.oaqa.model.gerp.Rank;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

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
  public void wrap(Rank top) throws AnalysisEngineProcessException {
    super.wrap(top);
    rank = top.getRank();
    score = top.getScore();
  }

  @Override
  public Rank unwrap(JCas jcas) throws AnalysisEngineProcessException {
    Rank top = super.unwrap(jcas);
    top.setRank(rank);
    top.setScore(score);
    return top;
  }

  @Override
  protected void wrapComments(Rank top) {
    // TODO Auto-generated method stub

  }

  @Override
  protected FSList unwrapComments(JCas jcas) {
    // TODO Auto-generated method stub
    return null;
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
