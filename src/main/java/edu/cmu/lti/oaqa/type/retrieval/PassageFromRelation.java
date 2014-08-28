

/* First created by JCasGen Tue Aug 05 23:03:53 EDT 2014 */
package edu.cmu.lti.oaqa.type.retrieval;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import edu.cmu.lti.oaqa.type.kb.Relation;


/** A passage search result that was the result of a search from the subject and object of a triple
 * Updated by JCasGen Sat Aug 16 20:55:37 EDT 2014
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
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
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected PassageFromRelation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public PassageFromRelation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public PassageFromRelation(JCas jcas) {
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
  //* Feature: sourceRelation

  /** getter for sourceRelation - gets The triple from which the search result was generated
   * @generated
   * @return value of the feature 
   */
  public Relation getSourceRelation() {
    if (PassageFromRelation_Type.featOkTst && ((PassageFromRelation_Type)jcasType).casFeat_sourceRelation == null)
      jcasType.jcas.throwFeatMissing("sourceRelation", "edu.cmu.lti.oaqa.type.retrieval.PassageFromRelation");
    return (Relation)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((PassageFromRelation_Type)jcasType).casFeatCode_sourceRelation)));}
    
  /** setter for sourceRelation - sets The triple from which the search result was generated 
   * @generated
   * @param v value to set into the feature 
   */
  public void setSourceRelation(Relation v) {
    if (PassageFromRelation_Type.featOkTst && ((PassageFromRelation_Type)jcasType).casFeat_sourceRelation == null)
      jcasType.jcas.throwFeatMissing("sourceRelation", "edu.cmu.lti.oaqa.type.retrieval.PassageFromRelation");
    jcasType.ll_cas.ll_setRefValue(addr, ((PassageFromRelation_Type)jcasType).casFeatCode_sourceRelation, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    