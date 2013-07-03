

/* First created by JCasGen Wed Jul 03 11:52:04 EDT 2013 */
package org.oaqa.model.nlp;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.oaqa.model.gerp.GerpAnnotation;


/** Annotates a span of text identified as a candidate answer.
 * Updated by JCasGen Wed Jul 03 15:44:17 EDT 2013
 * XML source: C:/Users/yangz13/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class CandidateAnswerOccurrence extends GerpAnnotation {
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
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected CandidateAnswerOccurrence() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public CandidateAnswerOccurrence(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public CandidateAnswerOccurrence(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public CandidateAnswerOccurrence(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: text

  /** getter for text - gets The candidate answer string.
   * @generated */
  public String getText() {
    if (CandidateAnswerOccurrence_Type.featOkTst && ((CandidateAnswerOccurrence_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "org.oaqa.model.nlp.CandidateAnswerOccurrence");
    return jcasType.ll_cas.ll_getStringValue(addr, ((CandidateAnswerOccurrence_Type)jcasType).casFeatCode_text);}
    
  /** setter for text - sets The candidate answer string. 
   * @generated */
  public void setText(String v) {
    if (CandidateAnswerOccurrence_Type.featOkTst && ((CandidateAnswerOccurrence_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "org.oaqa.model.nlp.CandidateAnswerOccurrence");
    jcasType.ll_cas.ll_setStringValue(addr, ((CandidateAnswerOccurrence_Type)jcasType).casFeatCode_text, v);}    
   
    
  //*--------------*
  //* Feature: mentionType

  /** getter for mentionType - gets The manner in which covered text refers to some entity, e.g.  NAME, NOMINAL, PRONOUN
   * @generated */
  public String getMentionType() {
    if (CandidateAnswerOccurrence_Type.featOkTst && ((CandidateAnswerOccurrence_Type)jcasType).casFeat_mentionType == null)
      jcasType.jcas.throwFeatMissing("mentionType", "org.oaqa.model.nlp.CandidateAnswerOccurrence");
    return jcasType.ll_cas.ll_getStringValue(addr, ((CandidateAnswerOccurrence_Type)jcasType).casFeatCode_mentionType);}
    
  /** setter for mentionType - sets The manner in which covered text refers to some entity, e.g.  NAME, NOMINAL, PRONOUN 
   * @generated */
  public void setMentionType(String v) {
    if (CandidateAnswerOccurrence_Type.featOkTst && ((CandidateAnswerOccurrence_Type)jcasType).casFeat_mentionType == null)
      jcasType.jcas.throwFeatMissing("mentionType", "org.oaqa.model.nlp.CandidateAnswerOccurrence");
    jcasType.ll_cas.ll_setStringValue(addr, ((CandidateAnswerOccurrence_Type)jcasType).casFeatCode_mentionType, v);}    
  }

    