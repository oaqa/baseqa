package edu.cmu.lti.oaqa.util;

import java.util.Collection;

import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

import com.google.common.collect.Range;

import edu.cmu.lti.oaqa.type.answer.Answer;
import edu.cmu.lti.oaqa.type.input.Question;
import edu.cmu.lti.oaqa.type.retrieval.AbstractQuery;
import edu.cmu.lti.oaqa.type.retrieval.Document;
import edu.cmu.lti.oaqa.type.retrieval.Passage;

public class TypeUtil {

  public static Question getQuestion(JCas jcas) {
    return JCasUtil.selectSingle(jcas, Question.class);
  }

  public static Collection<Document> getDocuments(JCas jcas) {
    return JCasUtil.select(jcas, Document.class);
  }

  public static Collection<Answer> getAnswers(JCas jcas) {
    return JCasUtil.select(jcas, Answer.class);
  }

  public static Collection<Passage> getPassages(JCas jcas) {
    return JCasUtil.select(jcas, Passage.class);
  }
  
  public static Collection<AbstractQuery> getAbstractQuery(JCas jcas) {
    return JCasUtil.select(jcas, AbstractQuery.class);
  }

  public static Range<Integer> spanRange(Annotation annotation) {
    return Range.closedOpen(annotation.getBegin(), annotation.getEnd());
  }

  public static Range<Integer> spanRangeInSection(Passage passage) {
    return Range.closedOpen(passage.getOffsetInBeginSection(), passage.getOffsetInEndSection());
  }

}
