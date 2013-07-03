

/* First created by JCasGen Wed Jul 03 15:35:55 EDT 2013 */
package org.oaqa.model.nlp;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.oaqa.model.gerp.GerpTop;


import org.apache.uima.jcas.cas.FSList;


/** A data structure that represents various NLP annotations from a parser, e.g. lists of Predicate, NamedEntity, SemanticRole, etc.
 * Updated by JCasGen Wed Jul 03 15:44:17 EDT 2013
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
  //* Feature: predicates

  /** getter for predicates - gets A list of predicates.
   * @generated */
  public FSList getPredicates() {
    if (Parse_Type.featOkTst && ((Parse_Type)jcasType).casFeat_predicates == null)
      jcasType.jcas.throwFeatMissing("predicates", "org.oaqa.model.nlp.Parse");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Parse_Type)jcasType).casFeatCode_predicates)));}
    
  /** setter for predicates - sets A list of predicates. 
   * @generated */
  public void setPredicates(FSList v) {
    if (Parse_Type.featOkTst && ((Parse_Type)jcasType).casFeat_predicates == null)
      jcasType.jcas.throwFeatMissing("predicates", "org.oaqa.model.nlp.Parse");
    jcasType.ll_cas.ll_setRefValue(addr, ((Parse_Type)jcasType).casFeatCode_predicates, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: namedEntities

  /** getter for namedEntities - gets A list of named entities.
   * @generated */
  public FSList getNamedEntities() {
    if (Parse_Type.featOkTst && ((Parse_Type)jcasType).casFeat_namedEntities == null)
      jcasType.jcas.throwFeatMissing("namedEntities", "org.oaqa.model.nlp.Parse");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Parse_Type)jcasType).casFeatCode_namedEntities)));}
    
  /** setter for namedEntities - sets A list of named entities. 
   * @generated */
  public void setNamedEntities(FSList v) {
    if (Parse_Type.featOkTst && ((Parse_Type)jcasType).casFeat_namedEntities == null)
      jcasType.jcas.throwFeatMissing("namedEntities", "org.oaqa.model.nlp.Parse");
    jcasType.ll_cas.ll_setRefValue(addr, ((Parse_Type)jcasType).casFeatCode_namedEntities, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
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

    