package edu.cmu.lti.oaqa.baseqa.framework.collection;

import java.util.List;
import java.util.Map;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CASException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.yaml.snakeyaml.Yaml;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.data.answer.AnswerListWrapper;
import edu.cmu.lti.oaqa.baseqa.data.answer.AnswerWrapper;
import edu.cmu.lti.oaqa.core.data.WrapperHelper;
import edu.cmu.lti.oaqa.core.data.WrapperIndexer;
import edu.cmu.lti.oaqa.ecd.phase.ProcessingStepUtils;
import edu.cmu.lti.oaqa.framework.ViewManager;
import edu.cmu.lti.oaqa.framework.ViewManager.ViewType;
import edu.cmu.lti.oaqa.framework.types.InputElement;

public class AnswerCandidateDecorator extends JCasAnnotator_ImplBase {

  private static Yaml yaml = new Yaml();

  private Map<String, List<String>> id2candidates;

  @SuppressWarnings("unchecked")
  @Override
  public void initialize(UimaContext context) throws ResourceInitializationException {
    super.initialize(context);
    String candidates = (String) context.getConfigParameterValue("candidates");
    id2candidates = (Map<String, List<String>>) yaml.load(getClass()
            .getResourceAsStream(candidates));
  }

  @Override
  public void process(JCas jcas) throws AnalysisEngineProcessException {
    InputElement input = ProcessingStepUtils.getInputElement(jcas);
    AnswerListWrapper answerList = new AnswerListWrapper(ImmutableList.copyOf(Lists.transform(
            id2candidates.get(input.getSequenceId()), new Function<String, AnswerWrapper>() {

              @Override
              public AnswerWrapper apply(String input) {
                return new AnswerWrapper(input, Lists.<String> newArrayList());
              }
            })));
    try {
      JCas candidateView = ViewManager.getOrCreateView(jcas, ViewType.CANDIDATE);
      WrapperHelper.unwrap(new WrapperIndexer(), answerList, candidateView).addToIndexes(
              candidateView);
    } catch (CASException e) {
      throw new AnalysisEngineProcessException(e);
    }
  }

}
