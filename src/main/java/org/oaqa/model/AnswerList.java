

/* First created by JCasGen Mon Oct 08 18:56:44 EDT 2012 */
package org.oaqa.model;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.cas.StringArray;


/** A ranked list of candidate answers.
 * Updated by JCasGen Thu Oct 11 12:34:48 EDT 2012
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class AnswerList extends OAQATop {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(AnswerList.class);
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
  protected AnswerList() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public AnswerList(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public AnswerList(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: answerList

  /** getter for answerList - gets Hit list of candidate answers, rank ordered, with highest scoring answer first.
   * @generated */
  public FSArray getAnswerList() {
    if (AnswerList_Type.featOkTst && ((AnswerList_Type)jcasType).casFeat_answerList == null)
      jcasType.jcas.throwFeatMissing("answerList", "org.oaqa.model.AnswerList");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((AnswerList_Type)jcasType).casFeatCode_answerList)));}
    
  /** setter for answerList - sets Hit list of candidate answers, rank ordered, with highest scoring answer first. 
   * @generated */
  public void setAnswerList(FSArray v) {
    if (AnswerList_Type.featOkTst && ((AnswerList_Type)jcasType).casFeat_answerList == null)
      jcasType.jcas.throwFeatMissing("answerList", "org.oaqa.model.AnswerList");
    jcasType.ll_cas.ll_setRefValue(addr, ((AnswerList_Type)jcasType).casFeatCode_answerList, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for answerList - gets an indexed value - Hit list of candidate answers, rank ordered, with highest scoring answer first.
   * @generated */
  public Answer getAnswerList(int i) {
    if (AnswerList_Type.featOkTst && ((AnswerList_Type)jcasType).casFeat_answerList == null)
      jcasType.jcas.throwFeatMissing("answerList", "org.oaqa.model.AnswerList");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((AnswerList_Type)jcasType).casFeatCode_answerList), i);
    return (Answer)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((AnswerList_Type)jcasType).casFeatCode_answerList), i)));}

  /** indexed setter for answerList - sets an indexed value - Hit list of candidate answers, rank ordered, with highest scoring answer first.
   * @generated */
  public void setAnswerList(int i, Answer v) { 
    if (AnswerList_Type.featOkTst && ((AnswerList_Type)jcasType).casFeat_answerList == null)
      jcasType.jcas.throwFeatMissing("answerList", "org.oaqa.model.AnswerList");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((AnswerList_Type)jcasType).casFeatCode_answerList), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((AnswerList_Type)jcasType).casFeatCode_answerList), i, jcasType.ll_cas.ll_getFSRef(v));}
   
    
  //*--------------*
  //* Feature: nilAnswer

  /** getter for nilAnswer - gets True if there is no answer to the question, False otherwise.
   * @generated */
  public boolean getNilAnswer() {
    if (AnswerList_Type.featOkTst && ((AnswerList_Type)jcasType).casFeat_nilAnswer == null)
      jcasType.jcas.throwFeatMissing("nilAnswer", "org.oaqa.model.AnswerList");
    return jcasType.ll_cas.ll_getBooleanValue(addr, ((AnswerList_Type)jcasType).casFeatCode_nilAnswer);}
    
  /** setter for nilAnswer - sets True if there is no answer to the question, False otherwise. 
   * @generated */
  public void setNilAnswer(boolean v) {
    if (AnswerList_Type.featOkTst && ((AnswerList_Type)jcasType).casFeat_nilAnswer == null)
      jcasType.jcas.throwFeatMissing("nilAnswer", "org.oaqa.model.AnswerList");
    jcasType.ll_cas.ll_setBooleanValue(addr, ((AnswerList_Type)jcasType).casFeatCode_nilAnswer, v);}    
   
    
  //*--------------*
  //* Feature: featureLabels

  /** getter for featureLabels - gets Array of feature labels, which correspond to the elements of the featureVector of each Answer in this AnswerList.
   * @generated */
  public StringArray getFeatureLabels() {
    if (AnswerList_Type.featOkTst && ((AnswerList_Type)jcasType).casFeat_featureLabels == null)
      jcasType.jcas.throwFeatMissing("featureLabels", "org.oaqa.model.AnswerList");
    return (StringArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((AnswerList_Type)jcasType).casFeatCode_featureLabels)));}
    
  /** setter for featureLabels - sets Array of feature labels, which correspond to the elements of the featureVector of each Answer in this AnswerList. 
   * @generated */
  public void setFeatureLabels(StringArray v) {
    if (AnswerList_Type.featOkTst && ((AnswerList_Type)jcasType).casFeat_featureLabels == null)
      jcasType.jcas.throwFeatMissing("featureLabels", "org.oaqa.model.AnswerList");
    jcasType.ll_cas.ll_setRefValue(addr, ((AnswerList_Type)jcasType).casFeatCode_featureLabels, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for featureLabels - gets an indexed value - Array of feature labels, which correspond to the elements of the featureVector of each Answer in this AnswerList.
   * @generated */
  public String getFeatureLabels(int i) {
    if (AnswerList_Type.featOkTst && ((AnswerList_Type)jcasType).casFeat_featureLabels == null)
      jcasType.jcas.throwFeatMissing("featureLabels", "org.oaqa.model.AnswerList");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((AnswerList_Type)jcasType).casFeatCode_featureLabels), i);
    return jcasType.ll_cas.ll_getStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((AnswerList_Type)jcasType).casFeatCode_featureLabels), i);}

  /** indexed setter for featureLabels - sets an indexed value - Array of feature labels, which correspond to the elements of the featureVector of each Answer in this AnswerList.
   * @generated */
  public void setFeatureLabels(int i, String v) { 
    if (AnswerList_Type.featOkTst && ((AnswerList_Type)jcasType).casFeat_featureLabels == null)
      jcasType.jcas.throwFeatMissing("featureLabels", "org.oaqa.model.AnswerList");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((AnswerList_Type)jcasType).casFeatCode_featureLabels), i);
    jcasType.ll_cas.ll_setStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((AnswerList_Type)jcasType).casFeatCode_featureLabels), i, v);}
  }

    