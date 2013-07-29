

/* First created by JCasGen Mon Jul 08 17:12:14 EDT 2013 */
package org.oaqa.model.input;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.oaqa.model.gerp.GerpAnnotation;


/** The Question and any associated meta-data.
 * Updated by JCasGen Mon Jul 29 18:17:35 EDT 2013
 * XML source: C:/Users/yangz13/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class Question extends GerpAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Question.class);
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
  protected Question() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Question(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Question(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Question(JCas jcas, int begin, int end) {
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
  //* Feature: id

  /** getter for id - gets A unique id for the question.
   * @generated */
  public String getId() {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "org.oaqa.model.input.Question");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Question_Type)jcasType).casFeatCode_id);}
    
  /** setter for id - sets A unique id for the question. 
   * @generated */
  public void setId(String v) {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "org.oaqa.model.input.Question");
    jcasType.ll_cas.ll_setStringValue(addr, ((Question_Type)jcasType).casFeatCode_id, v);}    
   
    
  //*--------------*
  //* Feature: source

  /** getter for source - gets The source of the question, e.g., TREC11, Jeopardy, etc.
   * @generated */
  public String getSource() {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_source == null)
      jcasType.jcas.throwFeatMissing("source", "org.oaqa.model.input.Question");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Question_Type)jcasType).casFeatCode_source);}
    
  /** setter for source - sets The source of the question, e.g., TREC11, Jeopardy, etc. 
   * @generated */
  public void setSource(String v) {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_source == null)
      jcasType.jcas.throwFeatMissing("source", "org.oaqa.model.input.Question");
    jcasType.ll_cas.ll_setStringValue(addr, ((Question_Type)jcasType).casFeatCode_source, v);}    
   
    
  //*--------------*
  //* Feature: questionType

  /** getter for questionType - gets The class of the question, determined by either an automatic question classification process or human judgment.
   * @generated */
  public String getQuestionType() {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_questionType == null)
      jcasType.jcas.throwFeatMissing("questionType", "org.oaqa.model.input.Question");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Question_Type)jcasType).casFeatCode_questionType);}
    
  /** setter for questionType - sets The class of the question, determined by either an automatic question classification process or human judgment. 
   * @generated */
  public void setQuestionType(String v) {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_questionType == null)
      jcasType.jcas.throwFeatMissing("questionType", "org.oaqa.model.input.Question");
    jcasType.ll_cas.ll_setStringValue(addr, ((Question_Type)jcasType).casFeatCode_questionType, v);}    
   
    
  //*--------------*
  //* Feature: text

  /** getter for text - gets The question content.
   * @generated */
  public String getText() {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "org.oaqa.model.input.Question");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Question_Type)jcasType).casFeatCode_text);}
    
  /** setter for text - sets The question content. 
   * @generated */
  public void setText(String v) {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "org.oaqa.model.input.Question");
    jcasType.ll_cas.ll_setStringValue(addr, ((Question_Type)jcasType).casFeatCode_text, v);}    
  }

    