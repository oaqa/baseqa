package edu.cmu.lti.oaqa.baseqa.data.nlp;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.input.QuestionClass;

import com.google.common.base.Objects;

import edu.cmu.lti.oaqa.baseqa.data.gerp.GerpAnnotationWrapper;

public class QuestionClassWrapper extends GerpAnnotationWrapper<QuestionClass> {

  private static final long serialVersionUID = 1L;

  public static enum QuestionClassType {
    FACTOID, DEFINITION, MULTI_SENTENCE, COMPOUND, ABBREVIATION, UNCLASSIFIED, LIST, OPINION
  };

  private QuestionClassType questionClass;

  protected QuestionClassWrapper(int begin, int end, QuestionClassType questionClass) {
    super(begin, end);
    this.questionClass = questionClass;
  }

  protected QuestionClassWrapper(int begin, int end, QuestionClassType questionClass,
          String generator) {
    super(begin, end, generator);
    this.questionClass = questionClass;
  }

  @Override
  public Class<? extends QuestionClass> getTypeClass() {
    return QuestionClass.class;
  }

  @Override
  public void wrap(QuestionClass annotation) throws AnalysisEngineProcessException {
    super.wrap(annotation);
    this.questionClass = QuestionClassType.valueOf(annotation.getQuestionClass());
  }

  @Override
  public QuestionClass unwrap(JCas jcas) throws AnalysisEngineProcessException {
    QuestionClass top = super.unwrap(jcas);
    top.setQuestionClass(questionClass.toString());
    return top;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), questionClass);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    QuestionClassWrapper other = (QuestionClassWrapper) obj;
    return Objects.equal(questionClass, other.questionClass);
  }

}
