package edu.cmu.lti.oaqa.baseqa.data.gerp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.gerp.GerpAnnotation;

import edu.cmu.lti.oaqa.baseqa.data.core.OAQAAnnotationWrapper;
import edu.cmu.lti.oaqa.baseqa.data.core.WrapperHelper;

public abstract class GerpAnnotationWrapper<T extends GerpAnnotation> extends
        OAQAAnnotationWrapper<T> implements Gerpable {

  private static final long serialVersionUID = 1L;

  protected List<String> generators;

  protected List<EvidenceWrapper<?, ?>> evidences;

  protected List<RankWrapper> ranks;

  protected List<PruningDecisionWrapper> pruningDecisions;

  protected GerpAnnotationWrapper(int begin, int end) {
    super(begin, end);
    generators = new ArrayList<String>();
    evidences = new ArrayList<EvidenceWrapper<?, ?>>();
    ranks = new ArrayList<RankWrapper>();
    pruningDecisions = new ArrayList<PruningDecisionWrapper>();
  }

  protected GerpAnnotationWrapper(int begin, int end, String generator) {
    this(begin, end);
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
  public void addEvidence(EvidenceWrapper<?, ?> evidence) {
    this.evidences.add(evidence);
  }

  @Override
  public void addEvidences(Collection<EvidenceWrapper<?, ?>> evidences) {
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

  @SuppressWarnings("unchecked")
  @Override
  public void wrap(T annotation) throws AnalysisEngineProcessException {
    super.wrap(annotation);
    generators = WrapperHelper.wrapStringList(annotation.getGenerators());
    evidences = WrapperHelper.wrapTopList(annotation.getEvidences(), EvidenceWrapper.class);
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
  public List<String> getGenerators() {
    return generators;
  }

  @Override
  public void setGenerators(List<String> generators) {
    this.generators = generators;
  }

  @Override
  public List<EvidenceWrapper<?, ?>> getEvidences() {
    return evidences;
  }

  @Override
  public void setEvidences(List<EvidenceWrapper<?, ?>> evidences) {
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
