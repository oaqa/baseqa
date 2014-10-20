

/* First created by JCasGen Sun Oct 19 14:47:24 EDT 2014 */
package edu.cmu.lti.oaqa.type.nlp;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.cas.TOP;


/** A data structure that represents various NLP annotations from a parser, e.g. lists of tokens, semantic roles, etc.
 * Updated by JCasGen Sun Oct 19 14:47:24 EDT 2014
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/baseqa/type/OAQATypes.xml
 * @generated */
public class Parse extends TOP {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Parse.class);
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
  protected Parse() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Parse(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Parse(JCas jcas) {
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
  //* Feature: tokens

  /** getter for tokens - gets A list of tokens.
   * @generated
   * @return value of the feature 
   */
  public FSList getTokens() {
    if (Parse_Type.featOkTst && ((Parse_Type)jcasType).casFeat_tokens == null)
      jcasType.jcas.throwFeatMissing("tokens", "edu.cmu.lti.oaqa.type.nlp.Parse");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Parse_Type)jcasType).casFeatCode_tokens)));}
    
  /** setter for tokens - sets A list of tokens. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setTokens(FSList v) {
    if (Parse_Type.featOkTst && ((Parse_Type)jcasType).casFeat_tokens == null)
      jcasType.jcas.throwFeatMissing("tokens", "edu.cmu.lti.oaqa.type.nlp.Parse");
    jcasType.ll_cas.ll_setRefValue(addr, ((Parse_Type)jcasType).casFeatCode_tokens, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: semanticRoles

  /** getter for semanticRoles - gets A list of semantic roles.
   * @generated
   * @return value of the feature 
   */
  public FSList getSemanticRoles() {
    if (Parse_Type.featOkTst && ((Parse_Type)jcasType).casFeat_semanticRoles == null)
      jcasType.jcas.throwFeatMissing("semanticRoles", "edu.cmu.lti.oaqa.type.nlp.Parse");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Parse_Type)jcasType).casFeatCode_semanticRoles)));}
    
  /** setter for semanticRoles - sets A list of semantic roles. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setSemanticRoles(FSList v) {
    if (Parse_Type.featOkTst && ((Parse_Type)jcasType).casFeat_semanticRoles == null)
      jcasType.jcas.throwFeatMissing("semanticRoles", "edu.cmu.lti.oaqa.type.nlp.Parse");
    jcasType.ll_cas.ll_setRefValue(addr, ((Parse_Type)jcasType).casFeatCode_semanticRoles, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    