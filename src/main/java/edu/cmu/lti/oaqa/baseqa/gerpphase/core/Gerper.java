package edu.cmu.lti.oaqa.baseqa.gerpphase.core;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.TOP;
import org.apache.uima.resource.ResourceInitializationException;

import com.google.common.collect.Sets;

import edu.cmu.lti.oaqa.baseqa.data.core.TopWrapper;
import edu.cmu.lti.oaqa.baseqa.data.core.WrapperIndexer;
import edu.cmu.lti.oaqa.baseqa.data.gerp.EvidenceWrapper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.Gerpable;
import edu.cmu.lti.oaqa.baseqa.data.gerp.GerpableList;
import edu.cmu.lti.oaqa.baseqa.data.gerp.PruningDecisionWrapper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.RankWrapper;
import edu.cmu.lti.oaqa.baseqa.gerpphase.core.evidencer.AbstractEvidencer;
import edu.cmu.lti.oaqa.baseqa.gerpphase.core.generator.AbstractGenerator;
import edu.cmu.lti.oaqa.baseqa.gerpphase.core.pruner.AbstractPruner;
import edu.cmu.lti.oaqa.baseqa.gerpphase.core.ranker.AbstractRanker;
import edu.cmu.lti.oaqa.ecd.BaseExperimentBuilder;
import edu.cmu.lti.oaqa.ecd.log.AbstractLoggedComponent;

/**
 * Component that supports 4-step processing: candidate Generation -> Evidencing -> Ranking ->
 * Pruning, which are defined by the interfaces {@link AbstractGenerator}, {@link AbstractEvidencer}
 * , {@link AbstractRanker}, and {@link AbstractPruner}. The implementing classes and parameters
 * (together defined in a yaml file) need to be specified for the parameters "generators",
 * "gatherer", "rankers", and "pruners".
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
public class Gerper<W extends Gerpable & TopWrapper<? extends TOP>> extends AbstractLoggedComponent {

  protected List<AbstractGenerator<W>> generators;

  protected List<AbstractEvidencer<W>> evidencers;

  protected List<AbstractRanker> rankers;

  protected List<AbstractPruner> pruners;

  private AbstractGenerator<W> generatorInstance;

  private AbstractEvidencer<W> evidencerInstance;

  @SuppressWarnings("unchecked")
  @Override
  public void initialize(UimaContext c) throws ResourceInitializationException {
    super.initialize(c);
    Object generatorNames = c.getConfigParameterValue("generators");
    if (generatorNames != null) {
      generators = (List<AbstractGenerator<W>>) BaseExperimentBuilder.createResourceList(
              generatorNames, generatorInstance.getClass());
    }
    Object evidencerNames = c.getConfigParameterValue("evidencers");
    if (evidencerNames != null) {
      evidencers = (List<AbstractEvidencer<W>>) BaseExperimentBuilder.createResourceList(
              evidencerNames, evidencerInstance.getClass());
    }
    Object rankerNames = c.getConfigParameterValue("rankers");
    if (rankerNames != null) {
      rankers = BaseExperimentBuilder.createResourceList(rankerNames, AbstractRanker.class);
    }
    Object prunerNames = c.getConfigParameterValue("pruners");
    if (prunerNames != null) {
      pruners = BaseExperimentBuilder.createResourceList(prunerNames, AbstractPruner.class);
    }
  }

  @Override
  public void process(JCas jcas) throws AnalysisEngineProcessException {
    super.process(jcas);
    WrapperIndexer indexer = new WrapperIndexer();
    for (AbstractGenerator<W> generator : generators) {
      // collecting required types from jcas as inputs
      List<Class<? extends TopWrapper<?>>> classes = generator.getRequiredInputTypes();
      try {
        indexer.addAllClassesToIndex(classes, jcas);
      } catch (Exception e) {
        throw new AnalysisEngineProcessException(e);
      }
      List<Set<TopWrapper<? extends TOP>>> inputs = indexer.getWrappersByClasses(classes);
      for (List<TopWrapper<? extends TOP>> input : Sets.cartesianProduct(inputs)) {
        // gerping for all combinations of inputs
        GerpableList<W> outputs = new GerpableList<W>();
        W gerpable = generator.generate(input);
        outputs.add(gerpable, generator.getClass().getSimpleName());
        for (AbstractEvidencer<W> evidencer : evidencers) {
          List<W> gerpables = outputs.getGerpables();
          List<EvidenceWrapper<?, ?>> evidences = evidencer.evidence(gerpables);
          outputs.addAllEvidences(evidences, evidencer.getClass().getSimpleName());
        }
        for (AbstractRanker ranker : rankers) {
          List<Collection<EvidenceWrapper<?, ?>>> evidences = outputs.getAllEvidences();
          List<RankWrapper> ranks = ranker.rank(evidences, ranker.getClass().getSimpleName());
          outputs.addAllRanks(ranks);
        }
        for (AbstractPruner pruner : pruners) {
          List<Collection<RankWrapper>> ranks = outputs.getAllRanks();
          List<PruningDecisionWrapper> pruningDecisions = pruner.prune(ranks);
          outputs.addAllPruningDecisions(pruningDecisions, pruner.getClass().getSimpleName());
        }
        // persisting outputs
        outputs.unwrapAllAndAddToIndexes(jcas);
      }
    }
  }
}
