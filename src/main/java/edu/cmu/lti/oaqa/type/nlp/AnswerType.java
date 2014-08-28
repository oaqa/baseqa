

/* First created by JCasGen Tue Aug 05 23:03:53 EDT 2014 */
package edu.cmu.lti.oaqa.type.nlp;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** A Named Entity type that represents the type of the answer being sought.
 * Updated by JCasGen Sat Aug 16 20:55:37 EDT 2014
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class AnswerType extends Annotation {
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
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected AnswerType() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public AnswerType(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public AnswerType(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public AnswerType(JCas jcas, int begin, int end) {
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
  //* Feature: label

  /** getter for label - gets An answer type identified for the question.
   * @generated
   * @return value of the feature 
   */
  public String getLabel() {
    if (AnswerType_Type.featOkTst && ((AnswerType_Type)jcasType).casFeat_label == null)
      jcasType.jcas.throwFeatMissing("label", "edu.cmu.lti.oaqa.type.nlp.AnswerType");
    return jcasType.ll_cas.ll_getStringValue(addr, ((AnswerType_Type)jcasType).casFeatCode_label);}
    
  /** setter for label - sets An answer type identified for the question. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setLabel(String v) {
    if (AnswerType_Type.featOkTst && ((AnswerType_Type)jcasType).casFeat_label == null)
      jcasType.jcas.throwFeatMissing("label", "edu.cmu.lti.oaqa.type.nlp.AnswerType");
    jcasType.ll_cas.ll_setStringValue(addr, ((AnswerType_Type)jcasType).casFeatCode_label, v);}    
   
    
  //*--------------*
  //* Feature: targetType

  /** getter for targetType - gets The actual target type annotation.
   * @generated
   * @return value of the feature 
   */
  public Annotation getTargetType() {
    if (AnswerType_Type.featOkTst && ((AnswerType_Type)jcasType).casFeat_targetType == null)
      jcasType.jcas.throwFeatMissing("targetType", "edu.cmu.lti.oaqa.type.nlp.AnswerType");
    return (Annotation)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((AnswerType_Type)jcasType).casFeatCode_targetType)));}
    
  /** setter for targetType - sets The actual target type annotation. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setTargetType(Annotation v) {
    if (AnswerType_Type.featOkTst && ((AnswerType_Type)jcasType).casFeat_targetType == null)
      jcasType.jcas.throwFeatMissing("targetType", "edu.cmu.lti.oaqa.type.nlp.AnswerType");
    jcasType.ll_cas.ll_setRefValue(addr, ((AnswerType_Type)jcasType).casFeatCode_targetType, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    