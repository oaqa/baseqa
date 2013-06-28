package edu.cmu.lti.oaqa.baseqa.data.gerp;

import java.util.Collection;
import java.util.List;

public interface Gerpable {

  public abstract void addGenerator(String generator);

  public abstract void addGenerators(Collection<String> generators);

  public abstract void addEvidence(DefaultEvidenceWrapper evidence);

  public abstract void addEvidences(Collection<DefaultEvidenceWrapper> evidences);

  public abstract void addRank(RankWrapper rank);

  public abstract void addRanks(Collection<RankWrapper> ranks);

  public abstract void addPruningDecision(PruningDecisionWrapper pruningDecision);

  public abstract void addPruningDecisions(Collection<PruningDecisionWrapper> pruningDecisions);

  public abstract List<String> getGenerators();

  public abstract void setGenerators(List<String> generators);

  public abstract List<DefaultEvidenceWrapper> getEvidences();

  public abstract void setEvidences(List<DefaultEvidenceWrapper> evidences);

  public abstract List<RankWrapper> getRanks();

  public abstract void setRanks(List<RankWrapper> ranks);

  public abstract List<PruningDecisionWrapper> getPruningDecisions();

  public abstract void setPruningDecisions(List<PruningDecisionWrapper> pruningDecisions);

}