package edu.cmu.lti.oaqa.baseqa.framework.eval.answer;

import java.util.Collection;
import java.util.List;

import org.apache.uima.cas.CASException;
import org.apache.uima.fit.util.FSCollectionFactory;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.answer.Answer;
import org.oaqa.model.answer.AnswerList;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

import edu.cmu.lti.oaqa.framework.ViewManager;
import edu.cmu.lti.oaqa.framework.ViewManager.ViewType;
import edu.cmu.lti.oaqa.framework.eval.retrieval.RetrievalEvalConsumer;

public class AnswerEvalConsumer extends RetrievalEvalConsumer<Answer> {

  @Override
  protected Ordering<Answer> getOrdering() {
    return new Ordering<Answer>() {

      @Override
      public int compare(Answer left, Answer right) {
        return left.getText().compareTo(right.getText());
      }

    }.reverse();
  }

  @Override
  protected Function<Answer, String> getToIdStringFct() {
    return new Function<Answer, String>() {

      @Override
      public String apply(Answer input) {
        return input.getText();
      }
    };
  }

  @Override
  protected List<Answer> getGoldStandard(JCas jcas) throws CASException {
    return getAnswers(ViewManager.getOrCreateView(jcas, ViewType.FINAL_ANSWER_GS));
  }

  @Override
  protected List<Answer> getResults(JCas jcas) throws CASException {
    return getAnswers(jcas);
  }

  private List<Answer> getAnswers(JCas view) {
    Collection<AnswerList> answerLists = JCasUtil.select(view, AnswerList.class);
    if (answerLists.size() == 0) {
      return Lists.newArrayList();
    } else {
      return (List<Answer>) FSCollectionFactory.create(Iterables.getLast(answerLists)
              .getAnswerList(), Answer.class);
    }
  }

}
