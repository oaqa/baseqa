

/* First created by JCasGen Mon Oct 08 18:56:44 EDT 2012 */
package org.oaqa.model;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** A Named Entity type that represents the type of the answer being sought.
 * Updated by JCasGen Thu Oct 11 12:34:48 EDT 2012
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class AnswerType extends OAQAAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(AnswerType.class);
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
  protected AnswerType() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public AnswerType(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public AnswerType(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public AnswerType(JCas jcas, int begin, int end) {
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
  //* Feature: label

  /** getter for label - gets An answer type identified for the question.
   * @generated */
  public String getLabel() {
    if (AnswerType_Type.featOkTst && ((AnswerType_Type)jcasType).casFeat_label == null)
      jcasType.jcas.throwFeatMissing("label", "org.oaqa.model.AnswerType");
    return jcasType.ll_cas.ll_getStringValue(addr, ((AnswerType_Type)jcasType).casFeatCode_label);}
    
  /** setter for label - sets An answer type identified for the question. 
   * @generated */
  public void setLabel(String v) {
    if (AnswerType_Type.featOkTst && ((AnswerType_Type)jcasType).casFeat_label == null)
      jcasType.jcas.throwFeatMissing("label", "org.oaqa.model.AnswerType");
    jcasType.ll_cas.ll_setStringValue(addr, ((AnswerType_Type)jcasType).casFeatCode_label, v);}    
   
    
  //*--------------*
  //* Feature: targetType

  /** getter for targetType - gets The actual target type annotation.
   * @generated */
  public Annotation getTargetType() {
    if (AnswerType_Type.featOkTst && ((AnswerType_Type)jcasType).casFeat_targetType == null)
      jcasType.jcas.throwFeatMissing("targetType", "org.oaqa.model.AnswerType");
    return (Annotation)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((AnswerType_Type)jcasType).casFeatCode_targetType)));}
    
  /** setter for targetType - sets The actual target type annotation. 
   * @generated */
  public void setTargetType(Annotation v) {
    if (AnswerType_Type.featOkTst && ((AnswerType_Type)jcasType).casFeat_targetType == null)
      jcasType.jcas.throwFeatMissing("targetType", "org.oaqa.model.AnswerType");
    jcasType.ll_cas.ll_setRefValue(addr, ((AnswerType_Type)jcasType).casFeatCode_targetType, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    