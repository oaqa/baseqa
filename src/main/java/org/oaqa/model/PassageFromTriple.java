

/* First created by JCasGen Mon Oct 08 18:56:44 EDT 2012 */
package org.oaqa.model;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** A passage search result that was the result of a search from the subject and object of a triple
 * Updated by JCasGen Tue Oct 09 21:34:49 EDT 2012
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class PassageFromTriple extends Passage {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(PassageFromTriple.class);
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
  protected PassageFromTriple() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public PassageFromTriple(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public PassageFromTriple(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: sourceTriple

  /** getter for sourceTriple - gets The triple from which the search result was generated
   * @generated */
  public Triple getSourceTriple() {
    if (PassageFromTriple_Type.featOkTst && ((PassageFromTriple_Type)jcasType).casFeat_sourceTriple == null)
      jcasType.jcas.throwFeatMissing("sourceTriple", "org.oaqa.model.PassageFromTriple");
    return (Triple)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((PassageFromTriple_Type)jcasType).casFeatCode_sourceTriple)));}
    
  /** setter for sourceTriple - sets The triple from which the search result was generated 
   * @generated */
  public void setSourceTriple(Triple v) {
    if (PassageFromTriple_Type.featOkTst && ((PassageFromTriple_Type)jcasType).casFeat_sourceTriple == null)
      jcasType.jcas.throwFeatMissing("sourceTriple", "org.oaqa.model.PassageFromTriple");
    jcasType.ll_cas.ll_setRefValue(addr, ((PassageFromTriple_Type)jcasType).casFeatCode_sourceTriple, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    