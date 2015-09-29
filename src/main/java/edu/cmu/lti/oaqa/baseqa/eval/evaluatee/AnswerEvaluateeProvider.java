package edu.cmu.lti.oaqa.baseqa.eval.evaluatee;

import static java.util.stream.Collectors.joining;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.baseqa.eval.EvaluateeProvider;
import edu.cmu.lti.oaqa.baseqa.util.ViewType;
import edu.cmu.lti.oaqa.ecd.config.ConfigurableProvider;
import edu.cmu.lti.oaqa.type.answer.Answer;
import edu.cmu.lti.oaqa.util.TypeUtil;

public class AnswerEvaluateeProvider extends ConfigurableProvider
        implements EvaluateeProvider<Answer> {

  @Override
  public Collection<Answer> getGoldStandard(JCas jcas) {
    List<Answer> answers = TypeUtil.getRankedAnswers(ViewType.getGsView(jcas));
    System.out.println(answers.stream().map(TypeUtil::getCandidateAnswerVariantNames)
            .map(Object::toString).collect(joining(", ")));
    return answers;
  }

  @Override
  public Collection<Answer> getResults(JCas jcas) {
    return TypeUtil.getRankedAnswers(jcas);
  }

  @Override
  public Comparator<Answer> comparator() {
    return Comparator.comparing(Answer::getScore, Comparator.reverseOrder());
  }

  @Override
  public Function<Answer, String> uniqueIdMapper() {
    return Answer::getText;
  }

  @Override
  public String getName() {
    return "Answer";
  }

}
