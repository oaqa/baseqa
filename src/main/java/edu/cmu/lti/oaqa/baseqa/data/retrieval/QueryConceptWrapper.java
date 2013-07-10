package edu.cmu.lti.oaqa.baseqa.data.retrieval;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.retrieval.QueryConcept;

import com.google.common.base.Objects;

import edu.cmu.lti.oaqa.baseqa.data.core.WrapperHelper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.GerpTopWrapper;

public class QueryConceptWrapper extends GerpTopWrapper<QueryConcept> {

  private static final long serialVersionUID = 1L;

  private List<String> namedEntityTypes;

  private String conceptType;

  private String text;

  private String originalText;

  private QueryOperatorWrapper operator;

  private List<QueryConceptWrapper> operatorArgs;

  private String partOfSpeech;

  public QueryConceptWrapper(List<String> namedEntityTypes, String conceptType, String text,
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

  public QueryConceptWrapper(List<String> namedEntityTypes, String conceptType, String text,
          String originalText, QueryOperatorWrapper operator,
          List<QueryConceptWrapper> operatorArgs, String partOfSpeech, String generator) {
    super(generator);
    this.namedEntityTypes = namedEntityTypes;
    this.conceptType = conceptType;
    this.text = text;
    this.originalText = originalText;
    this.operator = operator;
    this.operatorArgs = operatorArgs;
    this.partOfSpeech = partOfSpeech;
  }

  @Override
  public Class<? extends QueryConcept> getTypeClass() {
    return QueryConcept.class;
  }

  @Override
  public void wrap(QueryConcept top) throws AnalysisEngineProcessException {
    super.wrap(top);
    this.namedEntityTypes = WrapperHelper.wrapStringList(top.getNamedEntityTypes());
    this.conceptType = top.getConceptType();
    this.text = top.getText();
    this.originalText = top.getOriginalText();
    try {
      this.operator = WrapperHelper.matchSubclassAndWrap(top.getOperator(),
              QueryOperatorWrapper.class);
      this.operatorArgs = WrapperHelper.wrapTopList(top.getOperatorArgs(),
              QueryConceptWrapper.class);
    } catch (Exception e) {
      throw new AnalysisEngineProcessException(e);
    }
    this.partOfSpeech = top.getPartOfSpeech();
  }

  @Override
  public QueryConcept unwrap(JCas jcas) throws AnalysisEngineProcessException {
    QueryConcept top = super.unwrap(jcas);
    top.setNamedEntityTypes(WrapperHelper.unwrapStringList(namedEntityTypes, jcas));
    top.setConceptType(conceptType);
    top.setText(text);
    top.setOriginalText(originalText);
    top.setOperator(operator.unwrap(jcas));
    top.setOperatorArgs(WrapperHelper.unwrapTopList(operatorArgs, jcas));
    top.setPartOfSpeech(partOfSpeech);
    return top;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(text, originalText, operator, operatorArgs);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
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

  public String getConceptType() {
    return conceptType;
  }

  public void setConceptType(String conceptType) {
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
