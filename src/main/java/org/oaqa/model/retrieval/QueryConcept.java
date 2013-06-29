

/* First created by JCasGen Mon Jun 24 14:02:20 EDT 2013 */
package org.oaqa.model.retrieval;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.oaqa.model.gerp.GerpTop;
import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.cas.StringList;


/** A query concept in the abstract search query model.
 * Updated by JCasGen Sat Jun 29 17:56:00 EDT 2013
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class QueryConcept extends GerpTop {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(QueryConcept.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected QueryConcept() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public QueryConcept(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public QueryConcept(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: namedEntityTypes

  /** getter for namedEntityTypes - gets List of Named Entity types associated with this concept.
   * @generated */
  public StringList getNamedEntityTypes() {
    if (QueryConcept_Type.featOkTst && ((QueryConcept_Type)jcasType).casFeat_namedEntityTypes == null)
      jcasType.jcas.throwFeatMissing("namedEntityTypes", "org.oaqa.model.retrieval.QueryConcept");
    return (StringList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((QueryConcept_Type)jcasType).casFeatCode_namedEntityTypes)));}
    
  /** setter for namedEntityTypes - sets List of Named Entity types associated with this concept. 
   * @generated */
  public void setNamedEntityTypes(StringList v) {
    if (QueryConcept_Type.featOkTst && ((QueryConcept_Type)jcasType).casFeat_namedEntityTypes == null)
      jcasType.jcas.throwFeatMissing("namedEntityTypes", "org.oaqa.model.retrieval.QueryConcept");
    jcasType.ll_cas.ll_setRefValue(addr, ((QueryConcept_Type)jcasType).casFeatCode_namedEntityTypes, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: conceptType

  /** getter for conceptType - gets The type of this concept.
   * @generated */
  public String getConceptType() {
    if (QueryConcept_Type.featOkTst && ((QueryConcept_Type)jcasType).casFeat_conceptType == null)
      jcasType.jcas.throwFeatMissing("conceptType", "org.oaqa.model.retrieval.QueryConcept");
    return jcasType.ll_cas.ll_getStringValue(addr, ((QueryConcept_Type)jcasType).casFeatCode_conceptType);}
    
  /** setter for conceptType - sets The type of this concept. 
   * @generated */
  public void setConceptType(String v) {
    if (QueryConcept_Type.featOkTst && ((QueryConcept_Type)jcasType).casFeat_conceptType == null)
      jcasType.jcas.throwFeatMissing("conceptType", "org.oaqa.model.retrieval.QueryConcept");
    jcasType.ll_cas.ll_setStringValue(addr, ((QueryConcept_Type)jcasType).casFeatCode_conceptType, v);}    
   
    
  //*--------------*
  //* Feature: text

  /** getter for text - gets The keyword text.
   * @generated */
  public String getText() {
    if (QueryConcept_Type.featOkTst && ((QueryConcept_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "org.oaqa.model.retrieval.QueryConcept");
    return jcasType.ll_cas.ll_getStringValue(addr, ((QueryConcept_Type)jcasType).casFeatCode_text);}
    
  /** setter for text - sets The keyword text. 
   * @generated */
  public void setText(String v) {
    if (QueryConcept_Type.featOkTst && ((QueryConcept_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "org.oaqa.model.retrieval.QueryConcept");
    jcasType.ll_cas.ll_setStringValue(addr, ((QueryConcept_Type)jcasType).casFeatCode_text, v);}    
   
    
  //*--------------*
  //* Feature: originalText

  /** getter for originalText - gets The lexical string in the question.
   * @generated */
  public String getOriginalText() {
    if (QueryConcept_Type.featOkTst && ((QueryConcept_Type)jcasType).casFeat_originalText == null)
      jcasType.jcas.throwFeatMissing("originalText", "org.oaqa.model.retrieval.QueryConcept");
    return jcasType.ll_cas.ll_getStringValue(addr, ((QueryConcept_Type)jcasType).casFeatCode_originalText);}
    
  /** setter for originalText - sets The lexical string in the question. 
   * @generated */
  public void setOriginalText(String v) {
    if (QueryConcept_Type.featOkTst && ((QueryConcept_Type)jcasType).casFeat_originalText == null)
      jcasType.jcas.throwFeatMissing("originalText", "org.oaqa.model.retrieval.QueryConcept");
    jcasType.ll_cas.ll_setStringValue(addr, ((QueryConcept_Type)jcasType).casFeatCode_originalText, v);}    
   
    
  //*--------------*
  //* Feature: operator

  /** getter for operator - gets The operator associated with this concept.  This must be a complex concept.
   * @generated */
  public QueryOperator getOperator() {
    if (QueryConcept_Type.featOkTst && ((QueryConcept_Type)jcasType).casFeat_operator == null)
      jcasType.jcas.throwFeatMissing("operator", "org.oaqa.model.retrieval.QueryConcept");
    return (QueryOperator)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((QueryConcept_Type)jcasType).casFeatCode_operator)));}
    
  /** setter for operator - sets The operator associated with this concept.  This must be a complex concept. 
   * @generated */
  public void setOperator(QueryOperator v) {
    if (QueryConcept_Type.featOkTst && ((QueryConcept_Type)jcasType).casFeat_operator == null)
      jcasType.jcas.throwFeatMissing("operator", "org.oaqa.model.retrieval.QueryConcept");
    jcasType.ll_cas.ll_setRefValue(addr, ((QueryConcept_Type)jcasType).casFeatCode_operator, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: operatorArgs

  /** getter for operatorArgs - gets The operator arguments in a complex query concept.
   * @generated */
  public FSList getOperatorArgs() {
    if (QueryConcept_Type.featOkTst && ((QueryConcept_Type)jcasType).casFeat_operatorArgs == null)
      jcasType.jcas.throwFeatMissing("operatorArgs", "org.oaqa.model.retrieval.QueryConcept");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((QueryConcept_Type)jcasType).casFeatCode_operatorArgs)));}
    
  /** setter for operatorArgs - sets The operator arguments in a complex query concept. 
   * @generated */
  public void setOperatorArgs(FSList v) {
    if (QueryConcept_Type.featOkTst && ((QueryConcept_Type)jcasType).casFeat_operatorArgs == null)
      jcasType.jcas.throwFeatMissing("operatorArgs", "org.oaqa.model.retrieval.QueryConcept");
    jcasType.ll_cas.ll_setRefValue(addr, ((QueryConcept_Type)jcasType).casFeatCode_operatorArgs, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: partOfSpeech

  /** getter for partOfSpeech - gets The part of speech of the concept.
   * @generated */
  public String getPartOfSpeech() {
    if (QueryConcept_Type.featOkTst && ((QueryConcept_Type)jcasType).casFeat_partOfSpeech == null)
      jcasType.jcas.throwFeatMissing("partOfSpeech", "org.oaqa.model.retrieval.QueryConcept");
    return jcasType.ll_cas.ll_getStringValue(addr, ((QueryConcept_Type)jcasType).casFeatCode_partOfSpeech);}
    
  /** setter for partOfSpeech - sets The part of speech of the concept. 
   * @generated */
  public void setPartOfSpeech(String v) {
    if (QueryConcept_Type.featOkTst && ((QueryConcept_Type)jcasType).casFeat_partOfSpeech == null)
      jcasType.jcas.throwFeatMissing("partOfSpeech", "org.oaqa.model.retrieval.QueryConcept");
    jcasType.ll_cas.ll_setStringValue(addr, ((QueryConcept_Type)jcasType).casFeatCode_partOfSpeech, v);}    
  }

    