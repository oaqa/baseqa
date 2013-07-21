package edu.cmu.lti.oaqa.baseqa.data.nlp;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.oaqa.model.core.OAQAAnnotation;
import org.oaqa.model.nlp.AnswerType;

import com.google.common.base.Objects;

import edu.cmu.lti.oaqa.core.data.OAQAAnnotationWrapper;
import edu.cmu.lti.oaqa.core.data.WrapperHelper;
import edu.cmu.lti.oaqa.gerp.data.GerpAnnotationWrapper;

public class AnswerTypeWrapper extends GerpAnnotationWrapper<AnswerType> {

  private static final long serialVersionUID = 1L;

  private String label;

  private OAQAAnnotationWrapper<?> targetType;

  public AnswerTypeWrapper(int begin, int end, String label, OAQAAnnotationWrapper<?> targetType) {
    super(begin, end);
    this.label = label;
    this.targetType = targetType;
  }

  public AnswerTypeWrapper(int begin, int end, String label, OAQAAnnotationWrapper<?> targetType,
          String generator) {
    this(begin, end, label, targetType);
    addGenerator(generator);
  }

  public AnswerTypeWrapper() {
    this(0, Integer.MAX_VALUE, null, null, null);
  }

  @Override
  public Class<? extends AnswerType> getTypeClass() {
    return AnswerType.class;
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  @Override
  public void wrap(AnswerType annotation) throws AnalysisEngineProcessException {
    super.wrap(annotation);
    this.label = annotation.getLabel();
    if (annotation.getTargetType() != null) {
      this.targetType = WrapperHelper.matchSubclassAndWrap(
              (OAQAAnnotation) annotation.getTargetType(),
              (Class<OAQAAnnotationWrapper<OAQAAnnotation>>) (Class) OAQAAnnotationWrapper.class);
    }
  }

  @Override
  public void unwrap(AnswerType annotation) throws AnalysisEngineProcessException {
    super.unwrap(annotation);
    annotation.setLabel(label);
    if (targetType != null) {
      annotation.setTargetType(WrapperHelper.unwrap(targetType, WrapperHelper.getJCas(annotation)));
    }
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), label);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    AnswerTypeWrapper other = (AnswerTypeWrapper) obj;
    return Objects.equal(this.label, other.label);
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public OAQAAnnotationWrapper<?> getTargetType() {
    return targetType;
  }

  public void setTargetType(OAQAAnnotationWrapper<?> targetType) {
    this.targetType = targetType;
  }

}
