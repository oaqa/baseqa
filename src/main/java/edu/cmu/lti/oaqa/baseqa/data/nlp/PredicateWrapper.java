package edu.cmu.lti.oaqa.baseqa.data.nlp;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.nlp.Predicate;

import com.google.common.base.Objects;

import edu.cmu.lti.oaqa.baseqa.data.core.OAQAAnnotationWrapper;
import edu.cmu.lti.oaqa.baseqa.data.core.WrapperHelper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.GerpAnnotationWrapper;

public class PredicateWrapper extends GerpAnnotationWrapper<Predicate> {

  private static final long serialVersionUID = 1L;

  private List<? extends PredicateWrapper> arguments;

  private List<String> argumentLabels;

  private PredicateWrapper parse;

  private String semanticType;

  private String partOfSpeech;

  private String lemmaForm;

  private boolean isMainReference;

  private boolean isVariable;

  private String determiner;

  public PredicateWrapper(int begin, int end, List<PredicateWrapper> arguments,
          List<String> argumentLabels, PredicateWrapper parse, String semanticType,
          String partOfSpeech, String lemmaForm, boolean isMainReference, boolean isVariable,
          String determiner) {
    super(begin, end);
    this.arguments = arguments;
    this.argumentLabels = argumentLabels;
    this.parse = parse;
    this.semanticType = semanticType;
    this.partOfSpeech = partOfSpeech;
    this.lemmaForm = lemmaForm;
    this.isMainReference = isMainReference;
    this.isVariable = isVariable;
    this.determiner = determiner;
  }

  public PredicateWrapper(int begin, int end, List<PredicateWrapper> arguments,
          List<String> argumentLabels, PredicateWrapper parse, String semanticType,
          String partOfSpeech, String lemmaForm, boolean isMainReference, boolean isVariable,
          String determiner, String generator) {
    super(begin, end, generator);
    this.arguments = arguments;
    this.argumentLabels = argumentLabels;
    this.parse = parse;
    this.semanticType = semanticType;
    this.partOfSpeech = partOfSpeech;
    this.lemmaForm = lemmaForm;
    this.isMainReference = isMainReference;
    this.isVariable = isVariable;
    this.determiner = determiner;
  }

  @Override
  public Class<? extends Predicate> getTypeClass() {
    return Predicate.class;
  }

  @Override
  public void wrap(Predicate annotation) throws AnalysisEngineProcessException {
    super.wrap(annotation);
    this.arguments = WrapperHelper.wrapAnnotationArray(annotation.getArguments(), this.getClass());
    this.argumentLabels = WrapperHelper.wrapStringArray(annotation.getArgumentLabels());
    this.parse = OAQAAnnotationWrapper.wrap(annotation.getParse(), this.getClass());
    this.semanticType = annotation.getSemanticType();
    this.partOfSpeech = annotation.getPartOfSpeech();
    this.lemmaForm = annotation.getLemmaForm();
    this.isMainReference = annotation.getIsMainReference();
    this.isVariable = annotation.getIsVariable();
    this.determiner = annotation.getDeterminer();
  }

  @Override
  public Predicate unwrap(JCas jcas) throws AnalysisEngineProcessException {
    Predicate annotation = super.unwrap(jcas);
    annotation.setArguments(WrapperHelper.unwrapAnnotationArray(arguments, jcas));
    annotation.setArgumentLabels(WrapperHelper.unwrapStringArray(argumentLabels, jcas));
    annotation.setParse(parse.unwrap(jcas));
    annotation.setSemanticType(semanticType);
    annotation.setPartOfSpeech(partOfSpeech);
    annotation.setLemmaForm(lemmaForm);
    annotation.setIsMainReference(isMainReference);
    annotation.setIsVariable(isVariable);
    annotation.setDeterminer(determiner);
    return annotation;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode());
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    return true;
  }

  public List<? extends PredicateWrapper> getArguments() {
    return arguments;
  }

  public void setArguments(List<? extends PredicateWrapper> arguments) {
    this.arguments = arguments;
  }

  public List<String> getArgumentLabels() {
    return argumentLabels;
  }

  public void setArgumentLabels(List<String> argumentLabels) {
    this.argumentLabels = argumentLabels;
  }

  public PredicateWrapper getParse() {
    return parse;
  }

  public void setParse(PredicateWrapper parse) {
    this.parse = parse;
  }

  public String getSemanticType() {
    return semanticType;
  }

  public void setSemanticType(String semanticType) {
    this.semanticType = semanticType;
  }

  public String getPartOfSpeech() {
    return partOfSpeech;
  }

  public void setPartOfSpeech(String partOfSpeech) {
    this.partOfSpeech = partOfSpeech;
  }

  public String getLemmaForm() {
    return lemmaForm;
  }

  public void setLemmaForm(String lemmaForm) {
    this.lemmaForm = lemmaForm;
  }

  public boolean isMainReference() {
    return isMainReference;
  }

  public void setMainReference(boolean isMainReference) {
    this.isMainReference = isMainReference;
  }

  public boolean isVariable() {
    return isVariable;
  }

  public void setVariable(boolean isVariable) {
    this.isVariable = isVariable;
  }

  public String getDeterminer() {
    return determiner;
  }

  public void setDeterminer(String determiner) {
    this.determiner = determiner;
  }

}
