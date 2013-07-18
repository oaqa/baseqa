package edu.cmu.lti.oaqa.baseqa.data.gerp;

import java.util.Collection;
import java.util.List;

import org.apache.uima.jcas.cas.TOP;

import edu.cmu.lti.oaqa.baseqa.data.core.TopWrapper;

public interface Gerpable {

  void addGenerator(String generator);

  void addGenerators(Collection<String> generators);

  void addEvidence(EvidenceWrapper<?, ?> evidence);

  void addEvidences(Collection<EvidenceWrapper<?, ?>> evidences);

  void addRank(RankWrapper rank);

  void addRanks(Collection<RankWrapper> ranks);

  void addPruningDecision(PruningDecisionWrapper pruningDecision);

  void addPruningDecisions(Collection<PruningDecisionWrapper> pruningDecisions);

  List<String> getGenerators();

  void setGenerators(List<String> generators);

  List<EvidenceWrapper<?, ?>> getEvidences();

  void setEvidences(List<EvidenceWrapper<?, ?>> evidences);

  List<RankWrapper> getRanks();

  void setRanks(List<RankWrapper> ranks);

  List<PruningDecisionWrapper> getPruningDecisions();

  void setPruningDecisions(List<PruningDecisionWrapper> pruningDecisions);

  GerpMetaWrapper getGerpMeta();

  void setGerpMeta(GerpMetaWrapper gerpMeta);

  List<? extends TopWrapper<? extends TOP>> getDependencies();

  void setDependencies(List<? extends TopWrapper<? extends TOP>> dependencies);

}