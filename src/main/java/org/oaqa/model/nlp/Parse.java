

/* First created by JCasGen Mon Jul 08 17:12:14 EDT 2013 */
package org.oaqa.model.nlp;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.oaqa.model.gerp.GerpTop;
import org.apache.uima.jcas.cas.FSList;


/** A data structure that represents various NLP annotations from a parser, e.g. lists of tokens, semantic roles, etc.
 * Updated by JCasGen Mon Jul 29 18:17:35 EDT 2013
 * XML source: C:/Users/yangz13/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class Parse extends GerpTop {
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
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Parse() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Parse(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Parse(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: tokens

  /** getter for tokens - gets A list of tokens.
   * @generated */
  public FSList getTokens() {
    if (Parse_Type.featOkTst && ((Parse_Type)jcasType).casFeat_tokens == null)
      jcasType.jcas.throwFeatMissing("tokens", "org.oaqa.model.nlp.Parse");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Parse_Type)jcasType).casFeatCode_tokens)));}
    
  /** setter for tokens - sets A list of tokens. 
   * @generated */
  public void setTokens(FSList v) {
    if (Parse_Type.featOkTst && ((Parse_Type)jcasType).casFeat_tokens == null)
      jcasType.jcas.throwFeatMissing("tokens", "org.oaqa.model.nlp.Parse");
    jcasType.ll_cas.ll_setRefValue(addr, ((Parse_Type)jcasType).casFeatCode_tokens, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: semanticRoles

  /** getter for semanticRoles - gets A list of semantic roles.
   * @generated */
  public FSList getSemanticRoles() {
    if (Parse_Type.featOkTst && ((Parse_Type)jcasType).casFeat_semanticRoles == null)
      jcasType.jcas.throwFeatMissing("semanticRoles", "org.oaqa.model.nlp.Parse");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Parse_Type)jcasType).casFeatCode_semanticRoles)));}
    
  /** setter for semanticRoles - sets A list of semantic roles. 
   * @generated */
  public void setSemanticRoles(FSList v) {
    if (Parse_Type.featOkTst && ((Parse_Type)jcasType).casFeat_semanticRoles == null)
      jcasType.jcas.throwFeatMissing("semanticRoles", "org.oaqa.model.nlp.Parse");
    jcasType.ll_cas.ll_setRefValue(addr, ((Parse_Type)jcasType).casFeatCode_semanticRoles, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    