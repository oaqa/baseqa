

/* First created by JCasGen Tue Mar 11 18:40:04 EDT 2014 */
package org.oaqa.model.retrieval;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;
import org.oaqa.model.kb.Entity;


/** A search result from an ontology.
 * Updated by JCasGen Tue Mar 11 18:43:41 EDT 2014
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class EntitySearchResult extends AnswerSearchResult {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(EntitySearchResult.class);
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
  protected EntitySearchResult() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public EntitySearchResult(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public EntitySearchResult(JCas jcas) {
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
  //* Feature: entities

  /** getter for entities - gets The relevant concepts searched in the ontology.
   * @generated
   * @return value of the feature 
   */
  public FSArray getEntities() {
    if (EntitySearchResult_Type.featOkTst && ((EntitySearchResult_Type)jcasType).casFeat_entities == null)
      jcasType.jcas.throwFeatMissing("entities", "org.oaqa.model.retrieval.EntitySearchResult");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((EntitySearchResult_Type)jcasType).casFeatCode_entities)));}
    
  /** setter for entities - sets The relevant concepts searched in the ontology. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setEntities(FSArray v) {
    if (EntitySearchResult_Type.featOkTst && ((EntitySearchResult_Type)jcasType).casFeat_entities == null)
      jcasType.jcas.throwFeatMissing("entities", "org.oaqa.model.retrieval.EntitySearchResult");
    jcasType.ll_cas.ll_setRefValue(addr, ((EntitySearchResult_Type)jcasType).casFeatCode_entities, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for entities - gets an indexed value - The relevant concepts searched in the ontology.
   * @generated
   * @param i index in the array to get
   * @return value of the element at index i 
   */
  public Entity getEntities(int i) {
    if (EntitySearchResult_Type.featOkTst && ((EntitySearchResult_Type)jcasType).casFeat_entities == null)
      jcasType.jcas.throwFeatMissing("entities", "org.oaqa.model.retrieval.EntitySearchResult");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((EntitySearchResult_Type)jcasType).casFeatCode_entities), i);
    return (Entity)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((EntitySearchResult_Type)jcasType).casFeatCode_entities), i)));}

  /** indexed setter for entities - sets an indexed value - The relevant concepts searched in the ontology.
   * @generated
   * @param i index in the array to set
   * @param v value to set into the array 
   */
  public void setEntities(int i, Entity v) { 
    if (EntitySearchResult_Type.featOkTst && ((EntitySearchResult_Type)jcasType).casFeat_entities == null)
      jcasType.jcas.throwFeatMissing("entities", "org.oaqa.model.retrieval.EntitySearchResult");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((EntitySearchResult_Type)jcasType).casFeatCode_entities), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((EntitySearchResult_Type)jcasType).casFeatCode_entities), i, jcasType.ll_cas.ll_getFSRef(v));}
  }

    