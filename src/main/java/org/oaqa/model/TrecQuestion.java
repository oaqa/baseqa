

/* First created by JCasGen Thu Feb 21 16:50:37 EST 2013 */
package org.oaqa.model;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** A TREC evaluation question.
 * Updated by JCasGen Thu Feb 21 16:50:37 EST 2013
 * XML source: /usr0/srchvrs/stuff/OAQA.rankqa/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class TrecQuestion extends Question {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(TrecQuestion.class);
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
  protected TrecQuestion() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public TrecQuestion(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public TrecQuestion(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public TrecQuestion(JCas jcas, int begin, int end) {
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
  //* Feature: qType

  /** getter for qType - gets The question type given in the TREC question.
   * @generated */
  public String getQType() {
    if (TrecQuestion_Type.featOkTst && ((TrecQuestion_Type)jcasType).casFeat_qType == null)
      jcasType.jcas.throwFeatMissing("qType", "org.oaqa.model.TrecQuestion");
    return jcasType.ll_cas.ll_getStringValue(addr, ((TrecQuestion_Type)jcasType).casFeatCode_qType);}
    
  /** setter for qType - sets The question type given in the TREC question. 
   * @generated */
  public void setQType(String v) {
    if (TrecQuestion_Type.featOkTst && ((TrecQuestion_Type)jcasType).casFeat_qType == null)
      jcasType.jcas.throwFeatMissing("qType", "org.oaqa.model.TrecQuestion");
    jcasType.ll_cas.ll_setStringValue(addr, ((TrecQuestion_Type)jcasType).casFeatCode_qType, v);}    
  }

    