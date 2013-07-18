

/* First created by JCasGen Mon Jul 08 17:12:14 EDT 2013 */
package org.oaqa.model.retrieval;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.oaqa.model.kb.Relation;


/** A passage search result that was the result of a search from the subject and object of a triple
 * Updated by JCasGen Thu Jul 18 17:30:38 EDT 2013
 * XML source: C:/Users/yangz13/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class PassageFromRelation extends Passage {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(PassageFromRelation.class);
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
  protected PassageFromRelation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public PassageFromRelation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public PassageFromRelation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: sourceRelation

  /** getter for sourceRelation - gets The triple from which the search result was generated
   * @generated */
  public Relation getSourceRelation() {
    if (PassageFromRelation_Type.featOkTst && ((PassageFromRelation_Type)jcasType).casFeat_sourceRelation == null)
      jcasType.jcas.throwFeatMissing("sourceRelation", "org.oaqa.model.retrieval.PassageFromRelation");
    return (Relation)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((PassageFromRelation_Type)jcasType).casFeatCode_sourceRelation)));}
    
  /** setter for sourceRelation - sets The triple from which the search result was generated 
   * @generated */
  public void setSourceRelation(Relation v) {
    if (PassageFromRelation_Type.featOkTst && ((PassageFromRelation_Type)jcasType).casFeat_sourceRelation == null)
      jcasType.jcas.throwFeatMissing("sourceRelation", "org.oaqa.model.retrieval.PassageFromRelation");
    jcasType.ll_cas.ll_setRefValue(addr, ((PassageFromRelation_Type)jcasType).casFeatCode_sourceRelation, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    