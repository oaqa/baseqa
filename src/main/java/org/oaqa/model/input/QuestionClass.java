

/* First created by JCasGen Mon Jun 24 14:02:20 EDT 2013 */
package org.oaqa.model.input;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.oaqa.model.gerp.GerpAnnotation;


/** The class of the question, determined by an automatic question classification process.
 * Updated by JCasGen Sat Jun 29 17:55:59 EDT 2013
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class QuestionClass extends GerpAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(QuestionClass.class);
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
  protected QuestionClass() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public QuestionClass(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public QuestionClass(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public QuestionClass(JCas jcas, int begin, int end) {
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
  //* Feature: questionClass

  /** getter for questionClass - gets The kind (class) of the question.
   * @generated */
  public String getQuestionClass() {
    if (QuestionClass_Type.featOkTst && ((QuestionClass_Type)jcasType).casFeat_questionClass == null)
      jcasType.jcas.throwFeatMissing("questionClass", "org.oaqa.model.input.QuestionClass");
    return jcasType.ll_cas.ll_getStringValue(addr, ((QuestionClass_Type)jcasType).casFeatCode_questionClass);}
    
  /** setter for questionClass - sets The kind (class) of the question. 
   * @generated */
  public void setQuestionClass(String v) {
    if (QuestionClass_Type.featOkTst && ((QuestionClass_Type)jcasType).casFeat_questionClass == null)
      jcasType.jcas.throwFeatMissing("questionClass", "org.oaqa.model.input.QuestionClass");
    jcasType.ll_cas.ll_setStringValue(addr, ((QuestionClass_Type)jcasType).casFeatCode_questionClass, v);}    
  }

    