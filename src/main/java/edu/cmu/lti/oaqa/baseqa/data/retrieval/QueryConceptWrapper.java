package edu.cmu.lti.oaqa.baseqa.data.retrieval;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.retrieval.QueryConcept;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.data.core.WrapperHelper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.GerpTopWrapper;

public class QueryConceptWrapper extends GerpTopWrapper<QueryConcept> {

  private static final long serialVersionUID = 1L;

  public static enum ConceptType {
    KEYWORD_TYPE, QATOKEN_TYPE, ANSWER_TYPE
  }

  private List<String> namedEntityTypes;

  private ConceptType conceptType;

  private String text;

  private String originalText;

  private QueryOperatorWrapper operator;

  private List<QueryConceptWrapper> operatorArgs;

  private String partOfSpeech;

  public QueryConceptWrapper(List<String> namedEntityTypes, ConceptType conceptType, String text,
          String originalText, QueryOperatorWrapper operator,
          List<QueryConceptWrapper> operatorArgs, String partOfSpeech) {
    super();
    this.namedEntityTypes = namedEntityTypes;
    this.conceptType = conceptType;
    this.text = text;
    this.originalText = originalText;
    this.operator = operator;
    this.operatorArgs = operatorArgs;
    this.partOfSpeech = partOfSpeech;
  }

  public QueryConceptWrapper(List<String> namedEntityTypes, ConceptType conceptType, String text,
          String originalText, QueryOperatorWrapper operator,
          List<QueryConceptWrapper> operatorArgs, String partOfSpeech, String generator) {
    this(namedEntityTypes, conceptType, text, originalText, operator, operatorArgs, partOfSpeech);
    addGenerator(generator);
  }

  public QueryConceptWrapper() {
    this(Lists.<String> newArrayList(), ConceptType.QATOKEN_TYPE, null, null, null, Lists
            .<QueryConceptWrapper> newArrayList(), null);
  }

  @Override
  public Class<? extends QueryConcept> getTypeClass() {
    return QueryConcept.class;
  }

  @Override
  public void wrap(QueryConcept top) throws AnalysisEngineProcessException {
    super.wrap(top);
    this.namedEntityTypes = WrapperHelper.wrapStringList(top.getNamedEntityTypes());
    this.conceptType = ConceptType.valueOf(top.getConceptType());
    this.text = top.getText();
    this.originalText = top.getOriginalText();
    if (top.getOperator() != null) {
      this.operator = WrapperHelper.matchSubclassAndWrap(top.getOperator(),
              QueryOperatorWrapper.class);
    }
    this.operatorArgs = WrapperHelper.wrapTopList(top.getOperatorArgs(), QueryConceptWrapper.class);
    this.partOfSpeech = top.getPartOfSpeech();
  }

  @Override
  public void unwrap(QueryConcept top) throws AnalysisEngineProcessException {
    super.unwrap(top);
    JCas jcas = WrapperHelper.getJCas(top);
    top.setNamedEntityTypes(WrapperHelper.unwrapStringList(namedEntityTypes, jcas));
    top.setConceptType(conceptType.toString());
    top.setText(text);
    top.setOriginalText(originalText);
    if (operator != null) {
      top.setOperator(WrapperHelper.unwrap(operator, jcas));
    }
    top.setOperatorArgs(WrapperHelper.unwrapTopList(operatorArgs, jcas));
    top.setPartOfSpeech(partOfSpeech);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(text, originalText, operator, operatorArgs);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    QueryConceptWrapper other = (QueryConceptWrapper) obj;
    return Objects.equal(this.text, other.text)
            && Objects.equal(this.originalText, other.originalText)
            && Objects.equal(this.operator, other.operator)
            && Objects.equal(this.operatorArgs, other.operatorArgs);
  }

  public List<String> getNamedEntityTypes() {
    return namedEntityTypes;
  }

  public void setNamedEntityTypes(List<String> namedEntityTypes) {
    this.namedEntityTypes = namedEntityTypes;
  }

  public ConceptType getConceptType() {
    return conceptType;
  }

  public void setConceptType(ConceptType conceptType) {
    this.conceptType = conceptType;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getOriginalText() {
    return originalText;
  }

  public void setOriginalText(String originalText) {
    this.originalText = originalText;
  }

  public QueryOperatorWrapper getOperator() {
    return operator;
  }

  public void setOperator(QueryOperatorWrapper operator) {
    this.operator = operator;
  }

  public List<QueryConceptWrapper> getOperatorArgs() {
    return operatorArgs;
  }

  public void setOperatorArgs(List<QueryConceptWrapper> operatorArgs) {
    this.operatorArgs = operatorArgs;
  }

  public String getPartOfSpeech() {
    return partOfSpeech;
  }

  public void setPartOfSpeech(String partOfSpeech) {
    this.partOfSpeech = partOfSpeech;
  }

}
