

/* First created by JCasGen Mon Jul 08 17:12:14 EDT 2013 */
package org.oaqa.model.nlp;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.oaqa.model.gerp.GerpAnnotation;


/** The lexical answer type found in the question.
 * Updated by JCasGen Mon Jul 08 17:12:14 EDT 2013
 * XML source: C:/Users/yangz13/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class LexicalAnswerType extends GerpAnnotation {
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
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected LexicalAnswerType() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public LexicalAnswerType(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public LexicalAnswerType(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public LexicalAnswerType(JCas jcas, int begin, int end) {
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
  //* Feature: token

  /** getter for token - gets The corresponding token for the LAT.
   * @generated */
  public Token getToken() {
    if (LexicalAnswerType_Type.featOkTst && ((LexicalAnswerType_Type)jcasType).casFeat_token == null)
      jcasType.jcas.throwFeatMissing("token", "org.oaqa.model.nlp.LexicalAnswerType");
    return (Token)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((LexicalAnswerType_Type)jcasType).casFeatCode_token)));}
    
  /** setter for token - sets The corresponding token for the LAT. 
   * @generated */
  public void setToken(Token v) {
    if (LexicalAnswerType_Type.featOkTst && ((LexicalAnswerType_Type)jcasType).casFeat_token == null)
      jcasType.jcas.throwFeatMissing("token", "org.oaqa.model.nlp.LexicalAnswerType");
    jcasType.ll_cas.ll_setRefValue(addr, ((LexicalAnswerType_Type)jcasType).casFeatCode_token, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: label

  /** getter for label - gets The normalized LAT string.
   * @generated */
  public String getLabel() {
    if (LexicalAnswerType_Type.featOkTst && ((LexicalAnswerType_Type)jcasType).casFeat_label == null)
      jcasType.jcas.throwFeatMissing("label", "org.oaqa.model.nlp.LexicalAnswerType");
    return jcasType.ll_cas.ll_getStringValue(addr, ((LexicalAnswerType_Type)jcasType).casFeatCode_label);}
    
  /** setter for label - sets The normalized LAT string. 
   * @generated */
  public void setLabel(String v) {
    if (LexicalAnswerType_Type.featOkTst && ((LexicalAnswerType_Type)jcasType).casFeat_label == null)
      jcasType.jcas.throwFeatMissing("label", "org.oaqa.model.nlp.LexicalAnswerType");
    jcasType.ll_cas.ll_setStringValue(addr, ((LexicalAnswerType_Type)jcasType).casFeatCode_label, v);}    
  }

    