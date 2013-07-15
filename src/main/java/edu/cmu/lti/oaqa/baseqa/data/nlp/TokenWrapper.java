package edu.cmu.lti.oaqa.baseqa.data.nlp;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.nlp.Token;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.data.core.WrapperHelper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.GerpAnnotationWrapper;

public class TokenWrapper extends GerpAnnotationWrapper<Token> {

  private static final long serialVersionUID = 1L;

  private List<? extends TokenWrapper> arguments;

  private List<String> argumentLabels;

  private TokenWrapper parse;

  private String semanticType;

  private String partOfSpeech;

  private String lemmaForm;

  private boolean isMainReference;

  private boolean isVariable;

  private String determiner;

  public TokenWrapper(int begin, int end, List<TokenWrapper> arguments,
          List<String> argumentLabels, TokenWrapper parse, String semanticType,
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

  public TokenWrapper(int begin, int end, List<TokenWrapper> arguments,
          List<String> argumentLabels, TokenWrapper parse, String semanticType,
          String partOfSpeech, String lemmaForm, boolean isMainReference, boolean isVariable,
          String determiner, String generator) {
    this(begin, end, arguments, argumentLabels, parse, semanticType, partOfSpeech, lemmaForm,
            isMainReference, isVariable, determiner);
    addGenerator(generator);
  }

  public TokenWrapper() {
    this(0, Integer.MAX_VALUE, Lists.<TokenWrapper> newArrayList(), Lists.<String> newArrayList(),
            null, null, null, null, false, false, null);
  }

  @Override
  public Class<? extends Token> getTypeClass() {
    return Token.class;
  }

  @Override
  public void wrap(Token annotation) throws AnalysisEngineProcessException {
    super.wrap(annotation);
    this.arguments = WrapperHelper.wrapAnnotationArray(annotation.getArguments(), this.getClass());
    this.argumentLabels = WrapperHelper.wrapStringArray(annotation.getArgumentLabels());
    if (annotation.getParse() != null) {
      this.parse = WrapperHelper.matchSubclassAndWrapIfNotWrapped(annotation.getParse(),
              this.getClass());
    }
    this.semanticType = annotation.getSemanticType();
    this.partOfSpeech = annotation.getPartOfSpeech();
    this.lemmaForm = annotation.getLemmaForm();
    this.isMainReference = annotation.getIsMainReference();
    this.isVariable = annotation.getIsVariable();
    this.determiner = annotation.getDeterminer();
  }

  @Override
  public Token unwrap(JCas jcas) throws AnalysisEngineProcessException {
    Token annotation = super.unwrap(jcas);
    annotation.setArguments(WrapperHelper.unwrapAnnotationArray(arguments, jcas));
    annotation.setArgumentLabels(WrapperHelper.unwrapStringArray(argumentLabels, jcas));
    if (parse != null) {
      annotation.setParse(parse.unwrapIfNotUnwrapped(jcas));
    }
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
    return Objects.hashCode(super.hashCode(), arguments, argumentLabels, semanticType,
            partOfSpeech, lemmaForm, isMainReference, isVariable, determiner);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    TokenWrapper other = (TokenWrapper) obj;
    return Objects.equal(this.arguments, other.arguments)
            && Objects.equal(this.argumentLabels, other.argumentLabels)
            && Objects.equal(this.semanticType, other.semanticType)
            && Objects.equal(this.partOfSpeech, other.partOfSpeech)
            && Objects.equal(this.lemmaForm, other.lemmaForm)
            && Objects.equal(this.isMainReference, other.isMainReference)
            && Objects.equal(this.isVariable, other.isVariable)
            && Objects.equal(this.determiner, other.determiner);
  }

  public List<? extends TokenWrapper> getArguments() {
    return arguments;
  }

  public void setArguments(List<? extends TokenWrapper> arguments) {
    this.arguments = arguments;
  }

  public List<String> getArgumentLabels() {
    return argumentLabels;
  }

  public void setArgumentLabels(List<String> argumentLabels) {
    this.argumentLabels = argumentLabels;
  }

  public TokenWrapper getParse() {
    return parse;
  }

  public void setParse(TokenWrapper parse) {
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
