package edu.cmu.lti.oaqa.baseqa.framework.eval.gs;

import java.util.List;
import java.util.regex.MatchResult;

import org.apache.uima.fit.util.FSCollectionFactory;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.answer.Answer;
import org.oaqa.model.answer.AnswerList;

import com.google.common.collect.Lists;

public class AnswerGoldStandardFilePersistenceProvider extends
        AbstractGoldStandardFilePersistenceProvider<String> {

  // TODO All intermediate results will be stored in a single container (Parse, AnswerList,
  // Interpretation, etc.) We should change the return value in the method defined in the interface
  // from List<?> to T, which is the same for the gold-standard objects and the system generated
  // ones. As a workaround, the AnswerList here will wrap all the Answers, but only one AnswerList
  // element will exist in the CAS.
  @Override
  public List<AnswerList> populateRetrievalGS(String dataset, String sequenceId, JCas gsView) {
    List<Answer> gsAnnotations = Lists.newArrayList();
    List<String> gsSpans = id2gsSpans.get(new DatasetSequenceId(dataset, sequenceId));
    if (gsSpans != null) {
      for (String gsSpan : gsSpans) {
        Answer answer = new Answer(gsView);
        answer.setText(gsSpan);
        gsAnnotations.add(answer);
      }
    }
    AnswerList container = new AnswerList(gsView);
    container.setAnswerList(FSCollectionFactory.createFSArray(gsView, gsAnnotations));
    return Lists.newArrayList(container);
  }

  @Override
  protected String getGoldStandardFromParsedResult(MatchResult result) {
    return result.group(2);
  }
}
