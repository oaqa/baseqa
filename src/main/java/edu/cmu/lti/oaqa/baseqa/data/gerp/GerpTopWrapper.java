package edu.cmu.lti.oaqa.baseqa.data.gerp;

import java.util.Collection;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.TOP;
import org.oaqa.model.gerp.GerpTop;

import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.data.core.OAQATopWrapper;
import edu.cmu.lti.oaqa.baseqa.data.core.TopWrapper;
import edu.cmu.lti.oaqa.baseqa.data.core.WrapperHelper;

public abstract class GerpTopWrapper<T extends GerpTop> extends OAQATopWrapper<T> implements
        Gerpable {

  private static final long serialVersionUID = 1L;

  protected List<String> generators;

  protected List<EvidenceWrapper<?, ?>> evidences;

  protected List<RankWrapper> ranks;

  protected List<PruningDecisionWrapper> pruningDecisions;

  protected GerpMetaWrapper gerpMeta;

  protected List<? extends TopWrapper<? extends TOP>> dependencies;

  protected GerpTopWrapper() {
    super();
    generators = Lists.newArrayList();
    evidences = Lists.newArrayList();
    ranks = Lists.newArrayList();
    pruningDecisions = Lists.newArrayList();
    gerpMeta = null;
    dependencies = Lists.newArrayList();
  }

  protected GerpTopWrapper(String generator) {
    this();
    addGenerator(generator);
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
  public void wrap(T top) throws AnalysisEngineProcessException {
    super.wrap(top);
    generators = WrapperHelper.wrapStringList(top.getGenerators());
    evidences = WrapperHelper.wrapTopList(top.getEvidences(), EvidenceWrapper.class);
    ranks = WrapperHelper.wrapTopList(top.getRanks(), RankWrapper.class);
    pruningDecisions = WrapperHelper.wrapTopList(top.getPruningDecisions(),
            PruningDecisionWrapper.class);
    if (top.getGerpMeta() != null) {
      gerpMeta = WrapperHelper.matchSubclassAndWrap(top.getGerpMeta(), GerpMetaWrapper.class);
    }
    dependencies = WrapperHelper.wrapTopList(top.getDependencies(), TopWrapper.class);
  }

  @Override
  public void unwrap(T top) throws AnalysisEngineProcessException {
    super.unwrap(top);
    JCas jcas = WrapperHelper.getJCas(top);
    top.setGenerators(WrapperHelper.unwrapStringList(generators, jcas));
    top.setEvidences(WrapperHelper.unwrapTopList(evidences, jcas));
    top.setRanks(WrapperHelper.unwrapTopList(ranks, jcas));
    top.setPruningDecisions(WrapperHelper.unwrapTopList(pruningDecisions, jcas));
    if (gerpMeta != null) {
      top.setGerpMeta(WrapperHelper.unwrap(gerpMeta, jcas));
    }
    top.setDependencies(WrapperHelper.unwrapTopList(dependencies, jcas));
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

  @Override
  public GerpMetaWrapper getGerpMeta() {
    return gerpMeta;
  }

  @Override
  public void setGerpMeta(GerpMetaWrapper gerpMeta) {
    this.gerpMeta = gerpMeta;
  }

  @Override
  public List<? extends TopWrapper<? extends TOP>> getDependencies() {
    return dependencies;
  }

  @Override
  public void setDependencies(List<? extends TopWrapper<? extends TOP>> dependencies) {
    this.dependencies = dependencies;
  }

}