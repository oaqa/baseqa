

/* First created by JCasGen Sun Oct 05 18:02:25 EDT 2014 */
package edu.cmu.lti.oaqa.type.nlp;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** Annotates a span of text identified as a candidate answer.
 * Updated by JCasGen Mon Oct 06 20:47:18 EDT 2014
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/baseqa/type/OAQATypes.xml
 * @generated */
public class CandidateAnswerOccurrence extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(CandidateAnswerOccurrence.class);
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
  protected CandidateAnswerOccurrence() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public CandidateAnswerOccurrence(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public CandidateAnswerOccurrence(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public CandidateAnswerOccurrence(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
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
  //* Feature: text

  /** getter for text - gets The candidate answer string.
   * @generated
   * @return value of the feature 
   */
  public String getText() {
    if (CandidateAnswerOccurrence_Type.featOkTst && ((CandidateAnswerOccurrence_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "edu.cmu.lti.oaqa.type.nlp.CandidateAnswerOccurrence");
    return jcasType.ll_cas.ll_getStringValue(addr, ((CandidateAnswerOccurrence_Type)jcasType).casFeatCode_text);}
    
  /** setter for text - sets The candidate answer string. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setText(String v) {
    if (CandidateAnswerOccurrence_Type.featOkTst && ((CandidateAnswerOccurrence_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "edu.cmu.lti.oaqa.type.nlp.CandidateAnswerOccurrence");
    jcasType.ll_cas.ll_setStringValue(addr, ((CandidateAnswerOccurrence_Type)jcasType).casFeatCode_text, v);}    
   
    
  //*--------------*
  //* Feature: mentionType

  /** getter for mentionType - gets The manner in which covered text refers to some entity, e.g.  NAME, NOMINAL, PRONOUN
   * @generated
   * @return value of the feature 
   */
  public String getMentionType() {
    if (CandidateAnswerOccurrence_Type.featOkTst && ((CandidateAnswerOccurrence_Type)jcasType).casFeat_mentionType == null)
      jcasType.jcas.throwFeatMissing("mentionType", "edu.cmu.lti.oaqa.type.nlp.CandidateAnswerOccurrence");
    return jcasType.ll_cas.ll_getStringValue(addr, ((CandidateAnswerOccurrence_Type)jcasType).casFeatCode_mentionType);}
    
  /** setter for mentionType - sets The manner in which covered text refers to some entity, e.g.  NAME, NOMINAL, PRONOUN 
   * @generated
   * @param v value to set into the feature 
   */
  public void setMentionType(String v) {
    if (CandidateAnswerOccurrence_Type.featOkTst && ((CandidateAnswerOccurrence_Type)jcasType).casFeat_mentionType == null)
      jcasType.jcas.throwFeatMissing("mentionType", "edu.cmu.lti.oaqa.type.nlp.CandidateAnswerOccurrence");
    jcasType.ll_cas.ll_setStringValue(addr, ((CandidateAnswerOccurrence_Type)jcasType).casFeatCode_mentionType, v);}    
  }

    