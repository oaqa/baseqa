

/* First created by JCasGen Tue Aug 05 23:03:53 EDT 2014 */
package edu.cmu.lti.oaqa.type.answer;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.cas.TOP;


/** A ranked list of candidate answers.
 * Updated by JCasGen Sat Aug 16 20:55:37 EDT 2014
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class AnswerList extends TOP {
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
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected AnswerList() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public AnswerList(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public AnswerList(JCas jcas) {
    super(jcas);
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
  //* Feature: answerList

  /** getter for answerList - gets Hit list of candidate answers, rank ordered, with highest scoring answer first.
   * @generated
   * @return value of the feature 
   */
  public FSArray getAnswerList() {
    if (AnswerList_Type.featOkTst && ((AnswerList_Type)jcasType).casFeat_answerList == null)
      jcasType.jcas.throwFeatMissing("answerList", "edu.cmu.lti.oaqa.type.answer.AnswerList");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((AnswerList_Type)jcasType).casFeatCode_answerList)));}
    
  /** setter for answerList - sets Hit list of candidate answers, rank ordered, with highest scoring answer first. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setAnswerList(FSArray v) {
    if (AnswerList_Type.featOkTst && ((AnswerList_Type)jcasType).casFeat_answerList == null)
      jcasType.jcas.throwFeatMissing("answerList", "edu.cmu.lti.oaqa.type.answer.AnswerList");
    jcasType.ll_cas.ll_setRefValue(addr, ((AnswerList_Type)jcasType).casFeatCode_answerList, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for answerList - gets an indexed value - Hit list of candidate answers, rank ordered, with highest scoring answer first.
   * @generated
   * @param i index in the array to get
   * @return value of the element at index i 
   */
  public Answer getAnswerList(int i) {
    if (AnswerList_Type.featOkTst && ((AnswerList_Type)jcasType).casFeat_answerList == null)
      jcasType.jcas.throwFeatMissing("answerList", "edu.cmu.lti.oaqa.type.answer.AnswerList");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((AnswerList_Type)jcasType).casFeatCode_answerList), i);
    return (Answer)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((AnswerList_Type)jcasType).casFeatCode_answerList), i)));}

  /** indexed setter for answerList - sets an indexed value - Hit list of candidate answers, rank ordered, with highest scoring answer first.
   * @generated
   * @param i index in the array to set
   * @param v value to set into the array 
   */
  public void setAnswerList(int i, Answer v) { 
    if (AnswerList_Type.featOkTst && ((AnswerList_Type)jcasType).casFeat_answerList == null)
      jcasType.jcas.throwFeatMissing("answerList", "edu.cmu.lti.oaqa.type.answer.AnswerList");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((AnswerList_Type)jcasType).casFeatCode_answerList), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((AnswerList_Type)jcasType).casFeatCode_answerList), i, jcasType.ll_cas.ll_getFSRef(v));}
  }

    