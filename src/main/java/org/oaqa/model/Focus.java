

/* First created by JCasGen Wed Aug 01 12:12:46 EDT 2012 */
package org.oaqa.model;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** The phrase in the question that indicates the answer variable.
 * Updated by JCasGen Wed Aug 01 12:12:46 EDT 2012
 * XML source: /Users/elmer/Documents/workspace/oaqa/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class Focus extends OAQAAnnotation {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(Focus.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Focus() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Focus(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Focus(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Focus(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {}
     
 
    
  //*--------------*
  //* Feature: predicate

  /** getter for predicate - gets The corresponding predicate for the focus.
   * @generated */
  public Predicate getPredicate() {
    if (Focus_Type.featOkTst && ((Focus_Type)jcasType).casFeat_predicate == null)
      jcasType.jcas.throwFeatMissing("predicate", "org.oaqa.model.Focus");
    return (Predicate)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Focus_Type)jcasType).casFeatCode_predicate)));}
    
  /** setter for predicate - sets The corresponding predicate for the focus. 
   * @generated */
  public void setPredicate(Predicate v) {
    if (Focus_Type.featOkTst && ((Focus_Type)jcasType).casFeat_predicate == null)
      jcasType.jcas.throwFeatMissing("predicate", "org.oaqa.model.Focus");
    jcasType.ll_cas.ll_setRefValue(addr, ((Focus_Type)jcasType).casFeatCode_predicate, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: label

  /** getter for label - gets String representation of the Question Focus.
   * @generated */
  public String getLabel() {
    if (Focus_Type.featOkTst && ((Focus_Type)jcasType).casFeat_label == null)
      jcasType.jcas.throwFeatMissing("label", "org.oaqa.model.Focus");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Focus_Type)jcasType).casFeatCode_label);}
    
  /** setter for label - sets String representation of the Question Focus. 
   * @generated */
  public void setLabel(String v) {
    if (Focus_Type.featOkTst && ((Focus_Type)jcasType).casFeat_label == null)
      jcasType.jcas.throwFeatMissing("label", "org.oaqa.model.Focus");
    jcasType.ll_cas.ll_setStringValue(addr, ((Focus_Type)jcasType).casFeatCode_label, v);}    
  }

    