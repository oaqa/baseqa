

/* First created by JCasGen Mon Oct 08 18:56:44 EDT 2012 */
package org.oaqa.model;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** Annotates a span of text identified as a candidate answer.
<<<<<<< HEAD
 * Updated by JCasGen Thu Oct 11 12:34:48 EDT 2012
=======
 * Updated by JCasGen Tue Oct 09 21:34:48 EDT 2012
>>>>>>> b546a96e32521e5cc420b3a114ad3fb1279252a1
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class CandidateAnswerOccurrence extends OAQAAnnotation {
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
      jcasType.jcas.throwFeatMissing("text", "org.oaqa.model.CandidateAnswerOccurrence");
    return jcasType.ll_cas.ll_getStringValue(addr, ((CandidateAnswerOccurrence_Type)jcasType).casFeatCode_text);}
    
  /** setter for text - sets The candidate answer string. 
   * @generated */
  public void setText(String v) {
    if (CandidateAnswerOccurrence_Type.featOkTst && ((CandidateAnswerOccurrence_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "org.oaqa.model.CandidateAnswerOccurrence");
    jcasType.ll_cas.ll_setStringValue(addr, ((CandidateAnswerOccurrence_Type)jcasType).casFeatCode_text, v);}    
   
    
  //*--------------*
  //* Feature: mentionType

  /** getter for mentionType - gets The manner in which covered text refers to some entity, e.g.  NAME, NOMINAL, PRONOUN
   * @generated */
  public String getMentionType() {
    if (CandidateAnswerOccurrence_Type.featOkTst && ((CandidateAnswerOccurrence_Type)jcasType).casFeat_mentionType == null)
      jcasType.jcas.throwFeatMissing("mentionType", "org.oaqa.model.CandidateAnswerOccurrence");
    return jcasType.ll_cas.ll_getStringValue(addr, ((CandidateAnswerOccurrence_Type)jcasType).casFeatCode_mentionType);}
    
  /** setter for mentionType - sets The manner in which covered text refers to some entity, e.g.  NAME, NOMINAL, PRONOUN 
   * @generated */
  public void setMentionType(String v) {
    if (CandidateAnswerOccurrence_Type.featOkTst && ((CandidateAnswerOccurrence_Type)jcasType).casFeat_mentionType == null)
      jcasType.jcas.throwFeatMissing("mentionType", "org.oaqa.model.CandidateAnswerOccurrence");
    jcasType.ll_cas.ll_setStringValue(addr, ((CandidateAnswerOccurrence_Type)jcasType).casFeatCode_mentionType, v);}    
   
    
  //*--------------*
  //* Feature: source

  /** getter for source - gets The source of the candidate answer.
   * @generated */
  public SearchResult getSource() {
    if (CandidateAnswerOccurrence_Type.featOkTst && ((CandidateAnswerOccurrence_Type)jcasType).casFeat_source == null)
      jcasType.jcas.throwFeatMissing("source", "org.oaqa.model.CandidateAnswerOccurrence");
    return (SearchResult)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((CandidateAnswerOccurrence_Type)jcasType).casFeatCode_source)));}
    
  /** setter for source - sets The source of the candidate answer. 
   * @generated */
  public void setSource(SearchResult v) {
    if (CandidateAnswerOccurrence_Type.featOkTst && ((CandidateAnswerOccurrence_Type)jcasType).casFeat_source == null)
      jcasType.jcas.throwFeatMissing("source", "org.oaqa.model.CandidateAnswerOccurrence");
    jcasType.ll_cas.ll_setRefValue(addr, ((CandidateAnswerOccurrence_Type)jcasType).casFeatCode_source, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: sourceBegin

  /** getter for sourceBegin - gets The character offset of the start of this candidate answer within the text of the source.
   * @generated */
  public int getSourceBegin() {
    if (CandidateAnswerOccurrence_Type.featOkTst && ((CandidateAnswerOccurrence_Type)jcasType).casFeat_sourceBegin == null)
      jcasType.jcas.throwFeatMissing("sourceBegin", "org.oaqa.model.CandidateAnswerOccurrence");
    return jcasType.ll_cas.ll_getIntValue(addr, ((CandidateAnswerOccurrence_Type)jcasType).casFeatCode_sourceBegin);}
    
  /** setter for sourceBegin - sets The character offset of the start of this candidate answer within the text of the source. 
   * @generated */
  public void setSourceBegin(int v) {
    if (CandidateAnswerOccurrence_Type.featOkTst && ((CandidateAnswerOccurrence_Type)jcasType).casFeat_sourceBegin == null)
      jcasType.jcas.throwFeatMissing("sourceBegin", "org.oaqa.model.CandidateAnswerOccurrence");
    jcasType.ll_cas.ll_setIntValue(addr, ((CandidateAnswerOccurrence_Type)jcasType).casFeatCode_sourceBegin, v);}    
   
    
  //*--------------*
  //* Feature: sourceEnd

  /** getter for sourceEnd - gets The character offset of the end of this candidate answer within the text of the source.
   * @generated */
  public int getSourceEnd() {
    if (CandidateAnswerOccurrence_Type.featOkTst && ((CandidateAnswerOccurrence_Type)jcasType).casFeat_sourceEnd == null)
      jcasType.jcas.throwFeatMissing("sourceEnd", "org.oaqa.model.CandidateAnswerOccurrence");
    return jcasType.ll_cas.ll_getIntValue(addr, ((CandidateAnswerOccurrence_Type)jcasType).casFeatCode_sourceEnd);}
    
  /** setter for sourceEnd - sets The character offset of the end of this candidate answer within the text of the source. 
   * @generated */
  public void setSourceEnd(int v) {
    if (CandidateAnswerOccurrence_Type.featOkTst && ((CandidateAnswerOccurrence_Type)jcasType).casFeat_sourceEnd == null)
      jcasType.jcas.throwFeatMissing("sourceEnd", "org.oaqa.model.CandidateAnswerOccurrence");
    jcasType.ll_cas.ll_setIntValue(addr, ((CandidateAnswerOccurrence_Type)jcasType).casFeatCode_sourceEnd, v);}    
  }

    