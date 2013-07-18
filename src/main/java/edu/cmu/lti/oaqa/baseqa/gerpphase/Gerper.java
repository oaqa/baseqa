package edu.cmu.lti.oaqa.baseqa.gerpphase;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.TOP;
import org.apache.uima.resource.ResourceInitializationException;
import org.oaqa.model.gerp.GerpMeta;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import edu.cmu.lti.oaqa.baseqa.data.core.TopWrapper;
import edu.cmu.lti.oaqa.baseqa.data.core.WrapperHelper;
import edu.cmu.lti.oaqa.baseqa.data.core.WrapperIndexer;
import edu.cmu.lti.oaqa.baseqa.data.gerp.EvidenceWrapper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.GerpMetaWrapper;
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
 * "evidencers", "rankers", and "pruners".
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
public class Gerper<T extends TOP, W extends Gerpable & TopWrapper<T>> extends
        AbstractLoggedComponent {

  private Class<W> wrapperClass;

  protected List<AbstractGenerator<W>> generators = Lists.newArrayList();

  protected List<AbstractEvidencer<W>> evidencers = Lists.newArrayList();

  protected List<AbstractRanker> rankers = Lists.newArrayList();

  protected List<AbstractPruner> pruners = Lists.newArrayList();

  @SuppressWarnings("unchecked")
  @Override
  public void initialize(UimaContext c) throws ResourceInitializationException {
    super.initialize(c);
    Object generatorNames = c.getConfigParameterValue("generators");
    if (generatorNames != null) {
      for (AbstractGenerator<?> generator : BaseExperimentBuilder.createResourceList(
              generatorNames, AbstractGenerator.class)) {
        generators.add((AbstractGenerator<W>) generator);
      }
    }
    Object evidencerNames = c.getConfigParameterValue("evidencers");
    if (evidencerNames != null) {
      for (AbstractEvidencer<?> evidencer : BaseExperimentBuilder.createResourceList(
              evidencerNames, AbstractEvidencer.class)) {
        evidencers.add((AbstractEvidencer<W>) evidencer);
      }
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
    generateGerpMeta(jcas);
    executeGerp(jcas);
  }

  private void generateGerpMeta(JCas jcas) throws AnalysisEngineProcessException {
    GerpMetaWrapper gerpMeta = new GerpMetaWrapper(toClassNames(generators),
            toClassNames(evidencers), toClassNames(rankers), toClassNames(pruners));
    GerpMeta top = WrapperHelper.unwrap(gerpMeta, jcas);
    top.addToIndexes(jcas);
  }

  @SuppressWarnings("unchecked")
  private void executeGerp(JCas jcas) throws AnalysisEngineProcessException {
    WrapperIndexer indexer = WrapperIndexer.getWrapperIndexer(jcas);
    GerpableList<T, W> outputs = new GerpableList<T, W>();
    // generate
    for (AbstractGenerator<W> generator : generators) {
      wrapperClass = (Class<W>) generator.type.getClass();
      // collecting required types from jcas as inputs
      List<Set<TopWrapper<? extends TOP>>> inputOptions;
      try {
        inputOptions = indexer.getWrappersByTypes(generator.getRequiredInputTypes());
      } catch (Exception e) {
        throw new AnalysisEngineProcessException(e);
      }
      Set<List<TopWrapper<? extends TOP>>> inputCombinations = Sets.cartesianProduct(inputOptions);
      log(generator.getClass().getSimpleName() + " requires "
              + generator.getRequiredInputTypes().size() + " input type(s), retrieves "
              + inputCombinations.size() + " input combination(s).");
      for (List<TopWrapper<? extends TOP>> inputCombination : inputCombinations) {
        W gerpable = generator.generate(inputCombination);
        outputs.add(gerpable, generator.getClass().getSimpleName());
      }
    }
    log("Generate " + outputs.getSize() + " " + wrapperClass.getSimpleName() + "(s).");
    // evidence
    for (AbstractEvidencer<W> evidencer : evidencers) {
      List<W> gerpables = outputs.getGerpables();
      List<EvidenceWrapper<?, ?>> evidences = evidencer.evidence(gerpables);
      outputs.addAllEvidences(evidences);
      log(evidencer.getClass().getSimpleName() + " gives evidences of " + evidences);
    }
    // rank
    for (AbstractRanker ranker : rankers) {
      List<Collection<EvidenceWrapper<?, ?>>> evidences = outputs.getAllEvidences();
      List<RankWrapper> ranks = ranker.rank(evidences);
      outputs.addAllRanks(ranks);
      log(ranker.getClass().getSimpleName() + " gives ranks of " + ranks);
    }
    // prune
    for (AbstractPruner pruner : pruners) {
      List<Collection<RankWrapper>> ranks = outputs.getAllRanks();
      List<PruningDecisionWrapper> pruningDecisions = pruner.prune(ranks);
      outputs.addAllPruningDecisions(pruningDecisions);
      log(pruner.getClass().getSimpleName() + " gives pruning decisions of " + pruningDecisions);
    }
    // persisting outputs
    outputs.unwrapAllAndAddToIndexes(indexer);
  }

  private static List<String> toClassNames(List<? extends Object> objects) {
    List<String> classNames = Lists.newArrayList();
    for (Object object : objects) {
      classNames.add(object.getClass().getSimpleName());
    }
    return classNames;
  }

  private void log(String message) {
    log(GerpLogEntry.getMetaLog(), message);
  }

}
