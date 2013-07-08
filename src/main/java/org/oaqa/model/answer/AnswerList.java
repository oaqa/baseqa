

/* First created by JCasGen Mon Jul 08 17:12:14 EDT 2013 */
package org.oaqa.model.answer;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;
import org.oaqa.model.gerp.GerpTop;


/** A ranked list of candidate answers.
 * Updated by JCasGen Mon Jul 08 17:12:14 EDT 2013
 * XML source: C:/Users/yangz13/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class AnswerList extends GerpTop {
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
      jcasType.jcas.throwFeatMissing("answerList", "org.oaqa.model.answer.AnswerList");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((AnswerList_Type)jcasType).casFeatCode_answerList)));}
    
  /** setter for answerList - sets Hit list of candidate answers, rank ordered, with highest scoring answer first. 
   * @generated */
  public void setAnswerList(FSArray v) {
    if (AnswerList_Type.featOkTst && ((AnswerList_Type)jcasType).casFeat_answerList == null)
      jcasType.jcas.throwFeatMissing("answerList", "org.oaqa.model.answer.AnswerList");
    jcasType.ll_cas.ll_setRefValue(addr, ((AnswerList_Type)jcasType).casFeatCode_answerList, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for answerList - gets an indexed value - Hit list of candidate answers, rank ordered, with highest scoring answer first.
   * @generated */
  public Answer getAnswerList(int i) {
    if (AnswerList_Type.featOkTst && ((AnswerList_Type)jcasType).casFeat_answerList == null)
      jcasType.jcas.throwFeatMissing("answerList", "org.oaqa.model.answer.AnswerList");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((AnswerList_Type)jcasType).casFeatCode_answerList), i);
    return (Answer)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((AnswerList_Type)jcasType).casFeatCode_answerList), i)));}

  /** indexed setter for answerList - sets an indexed value - Hit list of candidate answers, rank ordered, with highest scoring answer first.
   * @generated */
  public void setAnswerList(int i, Answer v) { 
    if (AnswerList_Type.featOkTst && ((AnswerList_Type)jcasType).casFeat_answerList == null)
      jcasType.jcas.throwFeatMissing("answerList", "org.oaqa.model.answer.AnswerList");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((AnswerList_Type)jcasType).casFeatCode_answerList), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((AnswerList_Type)jcasType).casFeatCode_answerList), i, jcasType.ll_cas.ll_getFSRef(v));}
  }

    