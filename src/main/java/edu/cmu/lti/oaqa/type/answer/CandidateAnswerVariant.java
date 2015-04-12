

/* First created by JCasGen Sat Apr 11 19:49:33 EDT 2015 */
package edu.cmu.lti.oaqa.type.answer;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.cas.TOP;
import org.apache.uima.jcas.cas.StringList;


/** A variant of a candidate answer. A variant may have multiple occurrences, all of which are collected in a variant object.
 * Updated by JCasGen Mon Apr 13 16:42:07 EDT 2015
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
  //* Feature: names

  /** getter for names - gets Names for a given candidate answer variant, e.g. Tandy, Tandy Inc. for candidate answer Variant Tandy Incorporated.
   * @generated
   * @return value of the feature 
   */
  public StringList getNames() {
    if (CandidateAnswerVariant_Type.featOkTst && ((CandidateAnswerVariant_Type)jcasType).casFeat_names == null)
      jcasType.jcas.throwFeatMissing("names", "edu.cmu.lti.oaqa.type.answer.CandidateAnswerVariant");
    return (StringList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((CandidateAnswerVariant_Type)jcasType).casFeatCode_names)));}
    
  /** setter for names - sets Names for a given candidate answer variant, e.g. Tandy, Tandy Inc. for candidate answer Variant Tandy Incorporated. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setNames(StringList v) {
    if (CandidateAnswerVariant_Type.featOkTst && ((CandidateAnswerVariant_Type)jcasType).casFeat_names == null)
      jcasType.jcas.throwFeatMissing("names", "edu.cmu.lti.oaqa.type.answer.CandidateAnswerVariant");
    jcasType.ll_cas.ll_setRefValue(addr, ((CandidateAnswerVariant_Type)jcasType).casFeatCode_names, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
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

    