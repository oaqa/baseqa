package edu.cmu.lti.oaqa.baseqa.data.gerp;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.gerp.Evidence;
import org.oaqa.model.gerp.GerpAnnotation;
import org.oaqa.model.gerp.PruningDecision;
import org.oaqa.model.gerp.Rank;

import edu.cmu.lti.oaqa.baseqa.data.core.OAQAAnnotationWrapper;
import edu.cmu.lti.oaqa.baseqa.data.core.WrapperHelper;

public abstract class GerpAnnotationWrapper<T extends GerpAnnotation> extends
        OAQAAnnotationWrapper<T> {

  protected List<String> generators;

  protected List<EvidenceWrapper> evidences;

  protected List<RankWrapper> ranks;

  protected List<PruningDecisionWrapper> pruningDecisions;

  @Override
  public void wrap(T annotation) throws AnalysisEngineProcessException {
    super.wrap(annotation);
    generators = WrapperHelper.wrapStringList(annotation.getGenerators());
    evidences = WrapperHelper.wrapTopList(annotation.getEvidences(), Evidence.class,
            EvidenceWrapper.class);
    ranks = WrapperHelper.wrapTopList(annotation.getRanks(), Rank.class, RankWrapper.class);
    pruningDecisions = WrapperHelper.wrapTopList(annotation.getPruningDecisions(),
            PruningDecision.class, PruningDecisionWrapper.class);
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

}
