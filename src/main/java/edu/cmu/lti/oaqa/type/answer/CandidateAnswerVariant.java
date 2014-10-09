

/* First created by JCasGen Sun Oct 05 18:02:25 EDT 2014 */
package edu.cmu.lti.oaqa.type.answer;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.cas.TOP;
import org.apache.uima.jcas.cas.StringList;


/** A variant of a candidate answer.  A variant may have multiple occurrences, all of which are collected in a variant object.
 * Updated by JCasGen Mon Oct 06 20:47:17 EDT 2014
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/baseqa/type/OAQATypes.xml
 * @generated */
public class CandidateAnswerVariant extends TOP {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(CandidateAnswerVariant.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected CandidateAnswerVariant() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public CandidateAnswerVariant(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public CandidateAnswerVariant(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: occurrences

  /** getter for occurrences - gets The occurrences of this variant.
   * @generated
   * @return value of the feature 
   */
  public FSList getOccurrences() {
    if (CandidateAnswerVariant_Type.featOkTst && ((CandidateAnswerVariant_Type)jcasType).casFeat_occurrences == null)
      jcasType.jcas.throwFeatMissing("occurrences", "edu.cmu.lti.oaqa.type.answer.CandidateAnswerVariant");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((CandidateAnswerVariant_Type)jcasType).casFeatCode_occurrences)));}
    
  /** setter for occurrences - sets The occurrences of this variant. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setOccurrences(FSList v) {
    if (CandidateAnswerVariant_Type.featOkTst && ((CandidateAnswerVariant_Type)jcasType).casFeat_occurrences == null)
      jcasType.jcas.throwFeatMissing("occurrences", "edu.cmu.lti.oaqa.type.answer.CandidateAnswerVariant");
    jcasType.ll_cas.ll_setRefValue(addr, ((CandidateAnswerVariant_Type)jcasType).casFeatCode_occurrences, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: candidateId

  /** getter for candidateId - gets Unique id of this candidate answer variant.
   * @generated
   * @return value of the feature 
   */
  public String getCandidateId() {
    if (CandidateAnswerVariant_Type.featOkTst && ((CandidateAnswerVariant_Type)jcasType).casFeat_candidateId == null)
      jcasType.jcas.throwFeatMissing("candidateId", "edu.cmu.lti.oaqa.type.answer.CandidateAnswerVariant");
    return jcasType.ll_cas.ll_getStringValue(addr, ((CandidateAnswerVariant_Type)jcasType).casFeatCode_candidateId);}
    
  /** setter for candidateId - sets Unique id of this candidate answer variant. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setCandidateId(String v) {
    if (CandidateAnswerVariant_Type.featOkTst && ((CandidateAnswerVariant_Type)jcasType).casFeat_candidateId == null)
      jcasType.jcas.throwFeatMissing("candidateId", "edu.cmu.lti.oaqa.type.answer.CandidateAnswerVariant");
    jcasType.ll_cas.ll_setStringValue(addr, ((CandidateAnswerVariant_Type)jcasType).casFeatCode_candidateId, v);}    
   
    
  //*--------------*
  //* Feature: text

  /** getter for text - gets The candidate answer string.
   * @generated
   * @return value of the feature 
   */
  public String getText() {
    if (CandidateAnswerVariant_Type.featOkTst && ((CandidateAnswerVariant_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "edu.cmu.lti.oaqa.type.answer.CandidateAnswerVariant");
    return jcasType.ll_cas.ll_getStringValue(addr, ((CandidateAnswerVariant_Type)jcasType).casFeatCode_text);}
    
  /** setter for text - sets The candidate answer string. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setText(String v) {
    if (CandidateAnswerVariant_Type.featOkTst && ((CandidateAnswerVariant_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "edu.cmu.lti.oaqa.type.answer.CandidateAnswerVariant");
    jcasType.ll_cas.ll_setStringValue(addr, ((CandidateAnswerVariant_Type)jcasType).casFeatCode_text, v);}    
   
    
  //*--------------*
  //* Feature: alternativeNames

  /** getter for alternativeNames - gets alternative names for a given candidate answer variant, e.g. Tandy, Tandy Inc. for candidate answer Variant Tandy Incorporated
   * @generated
   * @return value of the feature 
   */
  public StringList getAlternativeNames() {
    if (CandidateAnswerVariant_Type.featOkTst && ((CandidateAnswerVariant_Type)jcasType).casFeat_alternativeNames == null)
      jcasType.jcas.throwFeatMissing("alternativeNames", "edu.cmu.lti.oaqa.type.answer.CandidateAnswerVariant");
    return (StringList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((CandidateAnswerVariant_Type)jcasType).casFeatCode_alternativeNames)));}
    
  /** setter for alternativeNames - sets alternative names for a given candidate answer variant, e.g. Tandy, Tandy Inc. for candidate answer Variant Tandy Incorporated 
   * @generated
   * @param v value to set into the feature 
   */
  public void setAlternativeNames(StringList v) {
    if (CandidateAnswerVariant_Type.featOkTst && ((CandidateAnswerVariant_Type)jcasType).casFeat_alternativeNames == null)
      jcasType.jcas.throwFeatMissing("alternativeNames", "edu.cmu.lti.oaqa.type.answer.CandidateAnswerVariant");
    jcasType.ll_cas.ll_setRefValue(addr, ((CandidateAnswerVariant_Type)jcasType).casFeatCode_alternativeNames, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: uri

  /** getter for uri - gets A unique identifier for this candidate.  All candidate answers in the same candidate answer group will have the same uri.  A candidate answer group is formed at candidate generation time when additional derived candidate answers are created from the root candidate answer.
   * @generated
   * @return value of the feature 
   */
  public String getUri() {
    if (CandidateAnswerVariant_Type.featOkTst && ((CandidateAnswerVariant_Type)jcasType).casFeat_uri == null)
      jcasType.jcas.throwFeatMissing("uri", "edu.cmu.lti.oaqa.type.answer.CandidateAnswerVariant");
    return jcasType.ll_cas.ll_getStringValue(addr, ((CandidateAnswerVariant_Type)jcasType).casFeatCode_uri);}
    
  /** setter for uri - sets A unique identifier for this candidate.  All candidate answers in the same candidate answer group will have the same uri.  A candidate answer group is formed at candidate generation time when additional derived candidate answers are created from the root candidate answer. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setUri(String v) {
    if (CandidateAnswerVariant_Type.featOkTst && ((CandidateAnswerVariant_Type)jcasType).casFeat_uri == null)
      jcasType.jcas.throwFeatMissing("uri", "edu.cmu.lti.oaqa.type.answer.CandidateAnswerVariant");
    jcasType.ll_cas.ll_setStringValue(addr, ((CandidateAnswerVariant_Type)jcasType).casFeatCode_uri, v);}    
   
    
  //*--------------*
  //* Feature: docId

  /** getter for docId - gets The unique id of the document (if any) from which this candidate answer was generated.
   * @generated
   * @return value of the feature 
   */
  public String getDocId() {
    if (CandidateAnswerVariant_Type.featOkTst && ((CandidateAnswerVariant_Type)jcasType).casFeat_docId == null)
      jcasType.jcas.throwFeatMissing("docId", "edu.cmu.lti.oaqa.type.answer.CandidateAnswerVariant");
    return jcasType.ll_cas.ll_getStringValue(addr, ((CandidateAnswerVariant_Type)jcasType).casFeatCode_docId);}
    
  /** setter for docId - sets The unique id of the document (if any) from which this candidate answer was generated. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setDocId(String v) {
    if (CandidateAnswerVariant_Type.featOkTst && ((CandidateAnswerVariant_Type)jcasType).casFeat_docId == null)
      jcasType.jcas.throwFeatMissing("docId", "edu.cmu.lti.oaqa.type.answer.CandidateAnswerVariant");
    jcasType.ll_cas.ll_setStringValue(addr, ((CandidateAnswerVariant_Type)jcasType).casFeatCode_docId, v);}    
  }

    