package edu.cmu.lti.oaqa.gerp.core;

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

import edu.cmu.lti.oaqa.core.data.TopWrapper;
import edu.cmu.lti.oaqa.core.data.WrapperHelper;
import edu.cmu.lti.oaqa.core.data.WrapperIndexer;
import edu.cmu.lti.oaqa.ecd.BaseExperimentBuilder;
import edu.cmu.lti.oaqa.ecd.log.AbstractLoggedComponent;
import edu.cmu.lti.oaqa.gerp.data.EvidenceWrapper;
import edu.cmu.lti.oaqa.gerp.data.GerpMetaWrapper;
import edu.cmu.lti.oaqa.gerp.data.Gerpable;
import edu.cmu.lti.oaqa.gerp.data.GerpableList;
import edu.cmu.lti.oaqa.gerp.data.PruningDecisionWrapper;
import edu.cmu.lti.oaqa.gerp.data.RankWrapper;

/**
 * Component that supports 4-step processing: candidate Generation -> Evidencing -> Ranking ->
 * Pruning, which are defined by the interfaces {@link AbstractGeneratorProvider},
 * {@link AbstractEvidencerProvider} , {@link AbstractRankerProvider}, and
 * {@link AbstractPrunerProvider}. The implementing classes and parameters (together defined in a
 * yaml file) need to be specified for the parameters "generators", "evidencers", "rankers", and
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
public class GerpComponent<T extends TOP, W extends Gerpable & TopWrapper<T>> extends
        AbstractLoggedComponent {

  private Class<W> wrapperClass;

  private String gerpableClassName;

  protected List<AbstractGeneratorProvider<W>> generators = Lists.newArrayList();

  protected List<AbstractEvidencerProvider<W>> evidencers = Lists.newArrayList();

  protected List<AbstractRankerProvider> rankers = Lists.newArrayList();

  protected List<AbstractPrunerProvider> pruners = Lists.newArrayList();

  private GerpMetaWrapper gerpMeta;

  @SuppressWarnings("unchecked")
  @Override
  public void initialize(UimaContext c) throws ResourceInitializationException {
    super.initialize(c);
    gerpableClassName = (String) c.getConfigParameterValue("type");
    Object generatorNames = c.getConfigParameterValue("generators");
    if (generatorNames != null) {
      for (AbstractGeneratorProvider<?> generator : BaseExperimentBuilder.createResourceList(
              generatorNames, AbstractGeneratorProvider.class)) {
        generators.add((AbstractGeneratorProvider<W>) generator);
      }
    }
    Object evidencerNames = c.getConfigParameterValue("evidencers");
    if (evidencerNames != null) {
      for (AbstractEvidencerProvider<?> evidencer : BaseExperimentBuilder.createResourceList(
              evidencerNames, AbstractEvidencerProvider.class)) {
        evidencers.add((AbstractEvidencerProvider<W>) evidencer);
      }
    }
    Object rankerNames = c.getConfigParameterValue("rankers");
    if (rankerNames != null) {
      rankers = BaseExperimentBuilder.createResourceList(rankerNames, AbstractRankerProvider.class);
    }
    Object prunerNames = c.getConfigParameterValue("pruners");
    if (prunerNames != null) {
      pruners = BaseExperimentBuilder.createResourceList(prunerNames, AbstractPrunerProvider.class);
    }
  }

  @Override
  public void process(JCas jcas) throws AnalysisEngineProcessException {
    super.process(jcas);
    generateGerpMeta(jcas);
    executeGerp(jcas);
  }

  private void generateGerpMeta(JCas jcas) throws AnalysisEngineProcessException {
    gerpMeta = new GerpMetaWrapper(gerpableClassName, toClassNames(generators),
            toClassNames(evidencers), toClassNames(rankers), toClassNames(pruners));
    GerpMeta top = WrapperHelper.unwrap(gerpMeta, jcas);
    top.addToIndexes(jcas);
  }

  @SuppressWarnings("unchecked")
  private void executeGerp(JCas jcas) throws AnalysisEngineProcessException {
    WrapperIndexer indexer = WrapperIndexer.getWrapperIndexer(jcas);
    GerpableList<T, W> outputs = new GerpableList<T, W>();
    // generate
    for (AbstractGeneratorProvider<W> generator : generators) {
      wrapperClass = (Class<W>) generator.wrapperType.getClass();
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
        gerpable.setDependencies(inputCombination);
        gerpable.setGerpMeta(gerpMeta);
        outputs.add(gerpable, generator.getClass().getSimpleName());
      }
    }
    log("Generate " + outputs.size() + " " + wrapperClass.getSimpleName() + "(s).");
    // evidence
    for (AbstractEvidencerProvider<W> evidencer : evidencers) {
      List<W> gerpables = outputs.getGerpables();
      List<EvidenceWrapper<?, ?>> evidences = evidencer.evidence(gerpables);
      outputs.addAllEvidences(evidences);
      log(evidencer.getClass().getSimpleName() + " gives evidences of " + evidences);
    }
    // rank
    for (AbstractRankerProvider ranker : rankers) {
      List<Collection<EvidenceWrapper<?, ?>>> evidences = outputs.getAllEvidences();
      List<RankWrapper> ranks = ranker.rank(evidences);
      outputs.addAllRanks(ranks);
      log(ranker.getClass().getSimpleName() + " gives ranks of " + ranks);
    }
    // prune
    for (AbstractPrunerProvider pruner : pruners) {
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
