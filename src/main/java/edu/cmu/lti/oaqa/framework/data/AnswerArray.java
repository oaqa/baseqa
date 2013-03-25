package edu.cmu.lti.oaqa.framework.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.naming.ConfigurationException;

import org.apache.uima.jcas.JCas;
import org.oaqa.model.Answer;
import org.oaqa.model.AnswerList;
import org.oaqa.model.Search;

import edu.cmu.lti.oaqa.framework.data.base.FSArrayWrapper;

public class AnswerArray extends FSArrayWrapper<Answer> {
  public static final String MergedSourceId = "__AllMergedAnswersFakeId__";

  public AnswerArray(String SourceId, JCas jcas, int length) throws ConfigurationException {
    super(jcas, length);
    if (null == SourceId || SourceId.isEmpty()) {
      throw new ConfigurationException("SourceId should not be empty!");
    }
    this.SourceId = SourceId;
  }

  @Override
  public void clear() {
    Iterator<?> it = jcas.getJFSIndexRepository().getAllIndexedFS(AnswerList.type);
    while (it.hasNext()) {
      AnswerList answers = (AnswerList) it.next();
      // Delete only entry with the specified SourceId
      if (answers.getSourceId() == this.SourceId) {
        answers.removeFromIndexes();
        break;
      }
    }
  }
  

  public static void GetAllSourceIds(JCas jcas, List<String> res) {
    res.clear();
    
    Iterator<?> it = jcas.getJFSIndexRepository().getAllIndexedFS(AnswerList.type);
    while (it.hasNext()) {
      AnswerList answers = (AnswerList) it.next();
      res.add(answers.getSourceId());
    }
  }
  

  @Override
  public void complete() {
    AnswerList answers = new AnswerList(jcas);
    answers.setSourceId(SourceId);
    answers.setAnswerList(array);
    answers.addToIndexes();
  }

  public void setAnswers(List<AnswerWrapper> answers) throws Exception {
    Collections.sort(answers, Collections.reverseOrder());
    double prevScore = Double.NaN;
    int prevRank = 0;
    for (int i = 0; i < answers.size(); i++) {
      AnswerWrapper answer = answers.get(i);
      double curScore = answer.getScore();
      if (curScore != prevScore) {
        answer.setRank(i + 1);
        prevScore = curScore;
        prevRank = i + 1;
      } else {
        answer.setRank(prevRank);
      }
    }
    setArray(answers);
  }

  public static void storeAnswers(String SourceId, JCas jcas, List<AnswerWrapper> answers)
          throws Exception {
    new AnswerArray(SourceId, jcas, answers.size()).setAnswers(answers);
  }

  public List<AnswerWrapper> getAnswers() throws Exception {
    Iterator<?> it = jcas.getJFSIndexRepository().getAllIndexedFS(AnswerList.type);
    while (it.hasNext()) {
      AnswerList answers = (AnswerList) it.next();
      if (answers.getSourceId() == this.SourceId) {
        array = answers.getAnswerList();
        return getArray(Answer.class, AnswerWrapper.class);        
      }
    }
    // @ Zi Yang from Leonid Boytsov: shouldn't we actually panic here? Why didn't we get the answer, something MUST be wrong. 
    return new ArrayList<AnswerWrapper>();
  }

  public static List<AnswerWrapper> retrieveAnswers(String SourceId, JCas jcas) throws Exception {
    return new AnswerArray(SourceId, jcas, 0).getAnswers();
  }
  
  private String SourceId;
}
