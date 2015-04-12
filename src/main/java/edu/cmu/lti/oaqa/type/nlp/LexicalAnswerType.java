

/* First created by JCasGen Sat Apr 11 19:49:33 EDT 2015 */
package edu.cmu.lti.oaqa.type.nlp;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.TOP;


/** The lexical answer type found in the question.
 * Updated by JCasGen Mon Apr 13 16:42:08 EDT 2015
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/baseqa/type/OAQATypes.xml
 * @generated */
public class LexicalAnswerType extends TOP {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(LexicalAnswerType.class);
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
  protected LexicalAnswerType() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public LexicalAnswerType(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public LexicalAnswerType(JCas jcas) {
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
  //* Feature: token

  /** getter for token - gets The corresponding token for the LAT (if any).
   * @generated
   * @return value of the feature 
   */
  public Token getToken() {
    if (LexicalAnswerType_Type.featOkTst && ((LexicalAnswerType_Type)jcasType).casFeat_token == null)
      jcasType.jcas.throwFeatMissing("token", "edu.cmu.lti.oaqa.type.nlp.LexicalAnswerType");
    return (Token)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((LexicalAnswerType_Type)jcasType).casFeatCode_token)));}
    
  /** setter for token - sets The corresponding token for the LAT (if any). 
   * @generated
   * @param v value to set into the feature 
   */
  public void setToken(Token v) {
    if (LexicalAnswerType_Type.featOkTst && ((LexicalAnswerType_Type)jcasType).casFeat_token == null)
      jcasType.jcas.throwFeatMissing("token", "edu.cmu.lti.oaqa.type.nlp.LexicalAnswerType");
    jcasType.ll_cas.ll_setRefValue(addr, ((LexicalAnswerType_Type)jcasType).casFeatCode_token, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: label

  /** getter for label - gets The normalized LAT string.
   * @generated
   * @return value of the feature 
   */
  public String getLabel() {
    if (LexicalAnswerType_Type.featOkTst && ((LexicalAnswerType_Type)jcasType).casFeat_label == null)
      jcasType.jcas.throwFeatMissing("label", "edu.cmu.lti.oaqa.type.nlp.LexicalAnswerType");
    return jcasType.ll_cas.ll_getStringValue(addr, ((LexicalAnswerType_Type)jcasType).casFeatCode_label);}
    
  /** setter for label - sets The normalized LAT string. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setLabel(String v) {
    if (LexicalAnswerType_Type.featOkTst && ((LexicalAnswerType_Type)jcasType).casFeat_label == null)
      jcasType.jcas.throwFeatMissing("label", "edu.cmu.lti.oaqa.type.nlp.LexicalAnswerType");
    jcasType.ll_cas.ll_setStringValue(addr, ((LexicalAnswerType_Type)jcasType).casFeatCode_label, v);}    
  }

    