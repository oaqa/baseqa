package edu.cmu.lti.oaqa.baseqa.gerp.answer;

import java.util.Collection;
import java.util.List;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.resource.ResourceInitializationException;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.math.DoubleMath;

import edu.cmu.lti.oaqa.baseqa.data.answer.AnswerListWrapper;
import edu.cmu.lti.oaqa.baseqa.data.answer.AnswerWrapper;
import edu.cmu.lti.oaqa.baseqa.data.kb.InterpretationWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.ParseWrapper;
import edu.cmu.lti.oaqa.baseqa.data.nlp.QuestionWrapper;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.AbstractQueryWrapper;
import edu.cmu.lti.oaqa.ecd.BaseExperimentBuilder;
import edu.cmu.lti.oaqa.gerp.core.AbstractPrunerProvider;
import edu.cmu.lti.oaqa.gerp.core.AbstractRankerProvider;
import edu.cmu.lti.oaqa.gerp.data.EvidenceWrapper;
import edu.cmu.lti.oaqa.gerp.data.PruningDecisionWrapper;
import edu.cmu.lti.oaqa.gerp.data.RankWrapper;

public class GerpedAnswerListGenerator extends AbstractAnswerListGenerator {

  private AbstractAnswerListGeneratorProvider generator;

  private List<AbstractAnswerEvidencerProvider> evidencers;

  private List<AbstractRankerProvider> rankers;

  private List<AbstractPrunerProvider> pruners;

  @Override
  public void initialize(UimaContext c) throws ResourceInitializationException {
    super.initialize(c);
    String generatorName = (String) c.getConfigParameterValue("generator");
    generator = BaseExperimentBuilder.loadProvider(generatorName, AbstractAnswerListGeneratorProvider.class);
    Object evidencerNames = c.getConfigParameterValue("evidencers");
    if (evidencerNames != null) {
      evidencers = BaseExperimentBuilder.createResourceList(evidencerNames,
              AbstractAnswerEvidencerProvider.class);
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

  protected AnswerListWrapper generate(QuestionWrapper question, ParseWrapper parse,
          InterpretationWrapper interpretation, AbstractQueryWrapper abstractQuery)
          throws AnalysisEngineProcessException {
    // generate answers
    List<AnswerWrapper> answers = generator
            .generate(question, parse, interpretation, abstractQuery).getAnswerList();
    int numCandidate = answers.size();
    // evidence
    for (AbstractAnswerEvidencerProvider evidencer : evidencers) {
      List<EvidenceWrapper<?, ?>> evidences = evidencer.evidence(answers);
      assert numCandidate == evidences.size();
      for (int i = 0; i < numCandidate; i++) {
        answers.get(i).addEvidence(evidences.get(i));
      }
    }
    // rank
    for (AbstractRankerProvider ranker : rankers) {
      List<Collection<EvidenceWrapper<?, ?>>> evidences = Lists.newArrayList();
      for (AnswerWrapper answer : answers) {
        evidences.add(answer.getEvidences());
      }
      List<RankWrapper> ranks = ranker.rank(evidences);
      assert numCandidate == ranks.size();
      for (int i = 0; i < numCandidate; i++) {
        answers.get(i).addRank(ranks.get(i));
      }
    }
    // prune
    for (AbstractPrunerProvider pruner : pruners) {
      List<Collection<RankWrapper>> ranks = Lists.newArrayList();
      for (AnswerWrapper answer : answers) {
        ranks.add(answer.getRanks());
      }
      List<PruningDecisionWrapper> pruningDecisions = pruner.prune(ranks);
      assert numCandidate == ranks.size();
      for (int i = 0; i < numCandidate; i++) {
        answers.get(i).addPruningDecision(pruningDecisions.get(i));
      }
    }
    // return
    answers = Ordering.natural().onResultOf(new Function<AnswerWrapper, Double>() {

      @Override
      public Double apply(AnswerWrapper input) {
        List<Integer> ranks = Lists.transform(input.getRanks(),
                new Function<RankWrapper, Integer>() {

                  @Override
                  public Integer apply(RankWrapper input) {
                    return input.getRank();
                  }
                });
        return DoubleMath.mean(ranks);
      }
    }).sortedCopy(answers);
    return new AnswerListWrapper(answers);
  }
}
