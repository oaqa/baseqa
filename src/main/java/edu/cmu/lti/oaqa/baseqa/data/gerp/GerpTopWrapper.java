package edu.cmu.lti.oaqa.baseqa.data.gerp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.gerp.GerpTop;

import com.google.common.base.Objects;

import edu.cmu.lti.oaqa.baseqa.data.core.OAQATopWrapper;
import edu.cmu.lti.oaqa.baseqa.data.core.WrapperHelper;

public abstract class GerpTopWrapper<T extends GerpTop> extends OAQATopWrapper<T> implements
        Gerpable {

  private static final long serialVersionUID = 1L;

  protected List<String> generators;

  protected List<DefaultEvidenceWrapper> evidences;

  protected List<RankWrapper> ranks;

  protected List<PruningDecisionWrapper> pruningDecisions;

  protected GerpTopWrapper() {
    super();
    generators = new ArrayList<String>();
    evidences = new ArrayList<DefaultEvidenceWrapper>();
    ranks = new ArrayList<RankWrapper>();
    pruningDecisions = new ArrayList<PruningDecisionWrapper>();
  }

  protected GerpTopWrapper(String generator) {
    this();
    this.addGenerator(generator);
  }

  @Override
  public void addGenerator(String generator) {
    this.generators.add(generator);
  }

  @Override
  public void addGenerators(Collection<String> generators) {
    this.generators.addAll(generators);
  }

  @Override
  public void addEvidence(DefaultEvidenceWrapper evidence) {
    this.evidences.add(evidence);
  }

  @Override
  public void addEvidences(Collection<DefaultEvidenceWrapper> evidences) {
    this.evidences.addAll(evidences);
  }

  @Override
  public void addRank(RankWrapper rank) {
    this.ranks.add(rank);
  }

  @Override
  public void addRanks(Collection<RankWrapper> ranks) {
    this.ranks.addAll(ranks);
  }

  @Override
  public void addPruningDecision(PruningDecisionWrapper pruningDecision) {
    this.pruningDecisions.add(pruningDecision);
  }

  @Override
  public void addPruningDecisions(Collection<PruningDecisionWrapper> pruningDecisions) {
    this.pruningDecisions.addAll(pruningDecisions);
  }

  @Override
  public void wrap(T top) throws AnalysisEngineProcessException {
    super.wrap(top);
    generators = WrapperHelper.wrapStringList(top.getGenerators());
    evidences = WrapperHelper.wrapTopList(top.getEvidences(), DefaultEvidenceWrapper.class);
    ranks = WrapperHelper.wrapTopList(top.getRanks(), RankWrapper.class);
    pruningDecisions = WrapperHelper.wrapTopList(top.getPruningDecisions(),
            PruningDecisionWrapper.class);
  }

  @Override
  public T unwrap(JCas jcas) throws AnalysisEngineProcessException {
    T annotation = super.unwrap(jcas);
    annotation.setGenerators(WrapperHelper.unwrapStringList(generators, jcas));
    annotation.setEvidences(WrapperHelper.unwrapTopList(evidences, jcas));
    annotation.setRanks(WrapperHelper.unwrapTopList(ranks, jcas));
    annotation.setPruningDecisions(WrapperHelper.unwrapTopList(pruningDecisions, jcas));
    return annotation;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(generators, evidences, ranks, pruningDecisions);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    @SuppressWarnings("rawtypes")
    GerpTopWrapper other = (GerpTopWrapper) obj;
    return Objects.equal(generators, other.generators) && Objects.equal(evidences, other.evidences)
            && Objects.equal(ranks, other.ranks)
            && Objects.equal(pruningDecisions, other.pruningDecisions);
  }

  @Override
  public List<String> getGenerators() {
    return generators;
  }

  @Override
  public void setGenerators(List<String> generators) {
    this.generators = generators;
  }

  @Override
  public List<DefaultEvidenceWrapper> getEvidences() {
    return evidences;
  }

  @Override
  public void setEvidences(List<DefaultEvidenceWrapper> evidences) {
    this.evidences = evidences;
  }

  @Override
  public List<RankWrapper> getRanks() {
    return ranks;
  }

  @Override
  public void setRanks(List<RankWrapper> ranks) {
    this.ranks = ranks;
  }

  @Override
  public List<PruningDecisionWrapper> getPruningDecisions() {
    return pruningDecisions;
  }

  @Override
  public void setPruningDecisions(List<PruningDecisionWrapper> pruningDecisions) {
    this.pruningDecisions = pruningDecisions;
  }

}