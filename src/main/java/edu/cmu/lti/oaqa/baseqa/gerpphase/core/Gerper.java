package edu.cmu.lti.oaqa.baseqa.gerpphase.core;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.TOP;
import org.apache.uima.resource.ResourceInitializationException;
import org.oaqa.model.core.OAQATop;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import edu.cmu.lti.oaqa.baseqa.data.core.OAQATopWrapper;
import edu.cmu.lti.oaqa.baseqa.data.core.TopWrapper;
import edu.cmu.lti.oaqa.baseqa.data.core.WrapperHelper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.DefaultEvidenceWrapper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.Gerpable;
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
    // collecting required types from jcas as input
    List<Class<? extends OAQATopWrapper<? extends OAQATop>>> allRequiredWrapperClasses = Lists
            .newArrayList();
    List<Set<? extends OAQATopWrapper<? extends OAQATop>>> allWrappedFSs = Lists.newArrayList();
    for (AbstractGenerator<W> generator : generators) {
      for (Class<? extends OAQATopWrapper<? extends OAQATop>> clazz : generator
              .getRequiredInputTypes()) {
        if (!allRequiredWrapperClasses.contains(clazz)) {
          assert Arrays.asList(clazz.getInterfaces()).contains(TopWrapper.class);
          allRequiredWrapperClasses.add(clazz);
          try {
            allWrappedFSs.add(WrapperHelper.wrapAllFromJCas(jcas, clazz));
          } catch (Exception e) {
            throw new AnalysisEngineProcessException(e);
          }
        }
      }
    }
    Set<List<OAQATopWrapper<? extends OAQATop>>> inputCombinations = Sets
            .cartesianProduct(allWrappedFSs);
    for (List<OAQATopWrapper<? extends OAQATop>> inputCombination : inputCombinations) {
      Map<Class<? extends OAQATopWrapper<? extends OAQATop>>, OAQATopWrapper<? extends OAQATop>> class2input = Maps
              .newHashMap();
      for (int i = 0; i < allRequiredWrapperClasses.size(); i++) {
        class2input.put(allRequiredWrapperClasses.get(i), inputCombination.get(i));
      }
      List<W> outputs = Lists.newArrayList();
      // gerping for all combinations of inputs
      for (AbstractGenerator<W> generator : generators) {
        List<Class<? extends OAQATopWrapper<?>>> classes = generator.getRequiredInputTypes();
        List<OAQATopWrapper<?>> inputs = Lists.newArrayList();
        for (Class<? extends OAQATopWrapper<?>> clazz : classes) {
          inputs.add(class2input.get(clazz));
        }
        outputs.add(generator.generate(inputs.toArray(new OAQATopWrapper<?>[0])));
      }
      for (AbstractEvidencer<W> evidencer : evidencers) {
        for (W output : outputs) {
          DefaultEvidenceWrapper evidence = (DefaultEvidenceWrapper) evidencer.evidence(output);
          output.addEvidence(evidence);
        }
      }
      for (AbstractRanker ranker : rankers) {
        for (W output : outputs) {
          RankWrapper rank = ranker.rank(output.getEvidences());
          output.addRank(rank);
        }
      }
      for (AbstractPruner pruner : pruners) {
        for (W output : outputs) {
          PruningDecisionWrapper pruningDecision = pruner.prune(output.getRanks());
          output.addPruningDecision(pruningDecision);
        }
      }
      // persisting output
      for (W output : outputs) {
        TOP top = output.unwrap(jcas);
        top.addToIndexes(jcas);
      }
    }
  }
}
