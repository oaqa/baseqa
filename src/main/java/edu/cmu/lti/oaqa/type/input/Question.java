

/* First created by JCasGen Tue Aug 05 23:03:53 EDT 2014 */
package edu.cmu.lti.oaqa.type.input;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** The Question and any associated meta-data.
 * Updated by JCasGen Tue Sep 30 18:21:24 EDT 2014
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/baseqa/type/OAQATypes.xml
 * @generated */
public class Question extends Annotation {
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
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Question() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Question(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Question(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Question(JCas jcas, int begin, int end) {
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
  //* Feature: id

  /** getter for id - gets A unique id for the question.
   * @generated
   * @return value of the feature 
   */
  public String getId() {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "edu.cmu.lti.oaqa.type.input.Question");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Question_Type)jcasType).casFeatCode_id);}
    
  /** setter for id - sets A unique id for the question. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setId(String v) {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "edu.cmu.lti.oaqa.type.input.Question");
    jcasType.ll_cas.ll_setStringValue(addr, ((Question_Type)jcasType).casFeatCode_id, v);}    
   
    
  //*--------------*
  //* Feature: source

  /** getter for source - gets The source of the question, e.g., TREC11, Jeopardy, etc.
   * @generated
   * @return value of the feature 
   */
  public String getSource() {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_source == null)
      jcasType.jcas.throwFeatMissing("source", "edu.cmu.lti.oaqa.type.input.Question");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Question_Type)jcasType).casFeatCode_source);}
    
  /** setter for source - sets The source of the question, e.g., TREC11, Jeopardy, etc. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setSource(String v) {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_source == null)
      jcasType.jcas.throwFeatMissing("source", "edu.cmu.lti.oaqa.type.input.Question");
    jcasType.ll_cas.ll_setStringValue(addr, ((Question_Type)jcasType).casFeatCode_source, v);}    
   
    
  //*--------------*
  //* Feature: questionType

  /** getter for questionType - gets The class of the question, determined by either an automatic question classification process or human judgment.
   * @generated
   * @return value of the feature 
   */
  public String getQuestionType() {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_questionType == null)
      jcasType.jcas.throwFeatMissing("questionType", "edu.cmu.lti.oaqa.type.input.Question");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Question_Type)jcasType).casFeatCode_questionType);}
    
  /** setter for questionType - sets The class of the question, determined by either an automatic question classification process or human judgment. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setQuestionType(String v) {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_questionType == null)
      jcasType.jcas.throwFeatMissing("questionType", "edu.cmu.lti.oaqa.type.input.Question");
    jcasType.ll_cas.ll_setStringValue(addr, ((Question_Type)jcasType).casFeatCode_questionType, v);}    
   
    
  //*--------------*
  //* Feature: text

  /** getter for text - gets The question content.
   * @generated
   * @return value of the feature 
   */
  public String getText() {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "edu.cmu.lti.oaqa.type.input.Question");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Question_Type)jcasType).casFeatCode_text);}
    
  /** setter for text - sets The question content. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setText(String v) {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "edu.cmu.lti.oaqa.type.input.Question");
    jcasType.ll_cas.ll_setStringValue(addr, ((Question_Type)jcasType).casFeatCode_text, v);}    
  }

    