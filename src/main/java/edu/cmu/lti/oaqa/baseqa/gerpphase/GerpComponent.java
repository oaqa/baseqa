package edu.cmu.lti.oaqa.baseqa.gerpphase;

import java.util.List;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.oaqa.model.core.OAQATop;

import edu.cmu.lti.oaqa.baseqa.data.core.OAQATopWrapper;
import edu.cmu.lti.oaqa.baseqa.gerpphase.evidencer.AbstractCandidateEvidencer;
import edu.cmu.lti.oaqa.baseqa.gerpphase.generator.AbstractCandidateGenerator;
import edu.cmu.lti.oaqa.baseqa.gerpphase.pruner.AbstractCandidatePruner;
import edu.cmu.lti.oaqa.baseqa.gerpphase.ranker.AbstractCandidateRanker;
import edu.cmu.lti.oaqa.ecd.BaseExperimentBuilder;
import edu.cmu.lti.oaqa.ecd.log.AbstractLoggedComponent;

/**
 * Component that supports 4-step processing: candidate Generation -> Evidencing -> Ranking ->
 * Pruning, which are defined by the interfaces {@link AbstractCandidateGenerator},
 * {@link AbstractCandidateEvidencer}, {@link AbstractCandidateRanker}, and
 * {@link AbstractCandidatePruner}. The implementing classes and parameters (together defined in a
 * yaml file) need to be specified for the parameters "generators", "gatherer", "rankers", and
 * "pruners".
 * <p>
 * For short yaml names, the following yaml syntax is recommended:
 * <p>
 * <blockquote>
 * 
 * <pre>
 * generators: [inherit: yaml.path.for.generator1, inherit: yaml.path.for.generator2]
 * </pre>
 * 
 * </blockquote>
 * <p>
 * <p>
 * Otherwise, please use the equivalent hyphen+space syntax for easy reading as follows:
 * <p>
 * <blockquote>
 * 
 * <pre>
 * generators: 
 *   - inherit: yaml.path.for.generator1
 *   - inherit: yaml.path.for.generator2
 * </pre>
 * 
 * </blockquote>
 * <p>
 * 
 * TODO power set of components need to be considered for cross-opts
 * <p>
 * TODO cross-opts for parameters within Resource and the corresponding resource is then aggregated
 * by modifiers, e.g. generators, instead of options, the cross-opts will not work
 * 
 * @author Zi Yang <ziy@cs.cmu.edu>
 * 
 */
public class GerpComponent<C extends OAQATopWrapper<? extends OAQATop>> extends
        AbstractLoggedComponent {

  protected List<AbstractCandidateGenerator> generators;

  protected List<AbstractCandidateEvidencer> evidencers;

  protected List<AbstractCandidateRanker> rankers;

  protected List<AbstractCandidatePruner> pruners;

  @Override
  public void initialize(UimaContext c) throws ResourceInitializationException {
    super.initialize(c);
    Object generatorNames = c.getConfigParameterValue("generators");
    if (generatorNames != null) {
      generators = BaseExperimentBuilder.createResourceList(generatorNames,
              AbstractCandidateGenerator.class);
    }
    Object evidencerNames = c.getConfigParameterValue("evidencers");
    if (evidencerNames != null) {
      evidencers = BaseExperimentBuilder.createResourceList(evidencerNames,
              AbstractCandidateEvidencer.class);
    }
    Object rankerNames = c.getConfigParameterValue("rankers");
    if (rankerNames != null) {
      rankers = BaseExperimentBuilder
              .createResourceList(rankerNames, AbstractCandidateRanker.class);
    }
    Object prunerNames = c.getConfigParameterValue("pruners");
    if (prunerNames != null) {
      pruners = BaseExperimentBuilder
              .createResourceList(prunerNames, AbstractCandidatePruner.class);
    }
  }

  @Override
  public void process(JCas jcas) throws AnalysisEngineProcessException {
    super.process(jcas);
    // different phase defines its own generators and extractors, and nothing need to be done here.
    // unified rankers, and pruners, and all the bookkeeping should be done here;
    // TODO mapping fields to CAS types
    // TODO directly use generated Java classes vs. wrapper classes
    for (AbstractCandidateGenerator generator : generators) {
      generator.generateCandidates(jcas);
    }
    for (AbstractCandidateEvidencer evidencer : evidencers) {
      evidencer.evidenceCandidates(jcas);
    }
    for (AbstractCandidateRanker ranker : rankers) {
      ranker.rankCandidates(jcas);
    }
    for (AbstractCandidatePruner pruner : pruners) {
      pruner.pruneCandidates(jcas);
    }
  }
}
