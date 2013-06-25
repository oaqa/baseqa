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

public abstract class GerpTopWrapper<T extends GerpTop> extends OAQATopWrapper<T> {

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

  public void addGenerator(String generator) {
    this.generators.add(generator);
  }

  public void addGenerators(Collection<String> generators) {
    this.generators.addAll(generators);
  }

  public void addEvidence(DefaultEvidenceWrapper evidence) {
    this.evidences.add(evidence);
  }

  public void addEvidences(Collection<DefaultEvidenceWrapper> evidences) {
    this.evidences.addAll(evidences);
  }

  public void addRank(RankWrapper rank) {
    this.ranks.add(rank);
  }

  public void addRanks(Collection<RankWrapper> ranks) {
    this.ranks.addAll(ranks);
  }

  public void addPruningDecision(PruningDecisionWrapper pruningDecision) {
    this.pruningDecisions.add(pruningDecision);
  }

  public void addPruningDecisions(Collection<PruningDecisionWrapper> pruningDecisions) {
    this.pruningDecisions.addAll(pruningDecisions);
  }

  @Override
  public void wrap(T annotation) throws AnalysisEngineProcessException {
    super.wrap(annotation);
    generators = WrapperHelper.wrapStringList(annotation.getGenerators());
    evidences = WrapperHelper.wrapTopList(annotation.getEvidences(), DefaultEvidenceWrapper.class);
    ranks = WrapperHelper.wrapTopList(annotation.getRanks(), RankWrapper.class);
    pruningDecisions = WrapperHelper.wrapTopList(annotation.getPruningDecisions(),
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

  public List<String> getGenerators() {
    return generators;
  }

  public void setGenerators(List<String> generators) {
    this.generators = generators;
  }

  public List<DefaultEvidenceWrapper> getEvidences() {
    return evidences;
  }

  public void setEvidences(List<DefaultEvidenceWrapper> evidences) {
    this.evidences = evidences;
  }

  public List<RankWrapper> getRanks() {
    return ranks;
  }

  public void setRanks(List<RankWrapper> ranks) {
    this.ranks = ranks;
  }

  public List<PruningDecisionWrapper> getPruningDecisions() {
    return pruningDecisions;
  }

  public void setPruningDecisions(List<PruningDecisionWrapper> pruningDecisions) {
    this.pruningDecisions = pruningDecisions;
  }

}