package edu.cmu.lti.oaqa.baseqa.data.nlp;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.oaqa.model.input.Question;

import com.google.common.base.Objects;

import edu.cmu.lti.oaqa.baseqa.data.gerp.GerpAnnotationWrapper;

public class QuestionWrapper extends GerpAnnotationWrapper<Question> {

  private static final long serialVersionUID = 1L;

  public static enum QuestionClassType {
    FACTOID, DEFINITION, MULTI_SENTENCE, COMPOUND, ABBREVIATION, UNCLASSIFIED, LIST, OPINION
  };

  private String id;

  private String source;

  private String text;

  private QuestionClassType classType;

  public QuestionWrapper(int begin, int end, String id, String source, String text,
          QuestionClassType classType) {
    super(begin, end);
    this.id = id;
    this.source = source;
    this.text = text;
    this.classType = classType;
  }

  public QuestionWrapper(int begin, int end, String id, String source, String text,
          QuestionClassType classType, String generator) {
    this(begin, end, id, source, text, classType);
    addGenerator(generator);
  }

  public QuestionWrapper() {
    this(0, Integer.MAX_VALUE, null, null, null, QuestionClassType.UNCLASSIFIED);
  }

  @Override
  public Class<? extends Question> getTypeClass() {
    return Question.class;
  }

  @Override
  public void wrap(Question annotation) throws AnalysisEngineProcessException {
    super.wrap(annotation);
    this.id = annotation.getId();
    this.source = annotation.getSource();
    this.text = annotation.getText();
    this.classType = QuestionClassType.valueOf(annotation.getQuestionType());
  }

  @Override
  public void unwrap(Question annotation) throws AnalysisEngineProcessException {
    super.unwrap(annotation);
    annotation.setId(id);
    annotation.setSource(source);
    annotation.setText(text);
    annotation.setQuestionType(classType.toString());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), text);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    QuestionWrapper other = (QuestionWrapper) obj;
    return Objects.equal(this.text, other.text);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public QuestionClassType getClassType() {
    return classType;
  }

  public void setClassType(QuestionClassType classType) {
    this.classType = classType;
  }

}
