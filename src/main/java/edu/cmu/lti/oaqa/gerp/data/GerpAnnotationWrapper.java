package edu.cmu.lti.oaqa.gerp.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.TOP;
import org.oaqa.model.gerp.GerpAnnotation;

import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.core.data.OAQAAnnotationWrapper;
import edu.cmu.lti.oaqa.core.data.TopWrapper;
import edu.cmu.lti.oaqa.core.data.WrapperHelper;
import edu.cmu.lti.oaqa.core.data.WrapperIndexer;

public abstract class GerpAnnotationWrapper<T extends GerpAnnotation> extends
        OAQAAnnotationWrapper<T> implements Gerpable {

  private static final long serialVersionUID = 1L;

  protected List<String> generators;

  protected List<EvidenceWrapper<?, ?>> evidences;

  protected List<RankWrapper> ranks;

  protected List<PruningDecisionWrapper> pruningDecisions;

  protected GerpMetaWrapper gerpMeta;

  protected List<? extends TopWrapper<? extends TOP>> dependencies;

  protected GerpAnnotationWrapper(int begin, int end) {
    super(begin, end);
    generators = new ArrayList<String>();
    evidences = new ArrayList<EvidenceWrapper<?, ?>>();
    ranks = new ArrayList<RankWrapper>();
    pruningDecisions = new ArrayList<PruningDecisionWrapper>();
    gerpMeta = null;
    dependencies = Lists.newArrayList();
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
  public void wrap(WrapperIndexer indexer, T annotation) throws AnalysisEngineProcessException {
    super.wrap(indexer, annotation);
    generators = WrapperHelper.wrapStringList(annotation.getGenerators());
    evidences = WrapperHelper
            .wrapTopList(indexer, annotation.getEvidences(), EvidenceWrapper.class);
    ranks = WrapperHelper.wrapTopList(indexer, annotation.getRanks(), RankWrapper.class);
    pruningDecisions = WrapperHelper.wrapTopList(indexer, annotation.getPruningDecisions(),
            PruningDecisionWrapper.class);
    if (annotation.getGerpMeta() != null) {
      gerpMeta = WrapperHelper.matchSubclassAndWrap(indexer, annotation.getGerpMeta(),
              GerpMetaWrapper.class);
    }
    dependencies = WrapperHelper.wrapTopList(indexer, annotation.getDependencies(),
            TopWrapper.class);
  }

  @Override
  public void unwrap(WrapperIndexer indexer, T annotation) throws AnalysisEngineProcessException {
    super.unwrap(indexer, annotation);
    JCas jcas = WrapperHelper.getJCas(annotation);
    annotation.setGenerators(WrapperHelper.unwrapStringList(generators, jcas));
    annotation.setEvidences(WrapperHelper.unwrapTopList(indexer, evidences, jcas));
    annotation.setRanks(WrapperHelper.unwrapTopList(indexer, ranks, jcas));
    annotation.setPruningDecisions(WrapperHelper.unwrapTopList(indexer, pruningDecisions, jcas));
    if (gerpMeta != null) {
      annotation.setGerpMeta(WrapperHelper.unwrap(indexer, gerpMeta, jcas));
    }
    annotation.setDependencies(WrapperHelper.unwrapTopListUnsafe(indexer, dependencies, jcas));
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
