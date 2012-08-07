

/* First created by JCasGen Wed Aug 01 12:12:46 EDT 2012 */
package org.oaqa.model;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.TOP;


/** The base class for OAQA feature structures that are not Annotations.
 * Updated by JCasGen Wed Aug 01 12:12:46 EDT 2012
 * XML source: /Users/elmer/Documents/workspace/oaqa/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class OAQATop extends TOP {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(OAQATop.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected OAQATop() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public OAQATop(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public OAQATop(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {}
     
 
    
  //*--------------*
  //* Feature: componentId

  /** getter for componentId - gets The unique id of the component that created this instance.
   * @generated */
  public String getComponentId() {
    if (OAQATop_Type.featOkTst && ((OAQATop_Type)jcasType).casFeat_componentId == null)
      jcasType.jcas.throwFeatMissing("componentId", "org.oaqa.model.OAQATop");
    return jcasType.ll_cas.ll_getStringValue(addr, ((OAQATop_Type)jcasType).casFeatCode_componentId);}
    
  /** setter for componentId - sets The unique id of the component that created this instance. 
   * @generated */
  public void setComponentId(String v) {
    if (OAQATop_Type.featOkTst && ((OAQATop_Type)jcasType).casFeat_componentId == null)
      jcasType.jcas.throwFeatMissing("componentId", "org.oaqa.model.OAQATop");
    jcasType.ll_cas.ll_setStringValue(addr, ((OAQATop_Type)jcasType).casFeatCode_componentId, v);}    
   
    
  //*--------------*
  //* Feature: probability

  /** getter for probability - gets The annotator's estimate of the probability associated with this annotation.
   * @generated */
  public float getProbability() {
    if (OAQATop_Type.featOkTst && ((OAQATop_Type)jcasType).casFeat_probability == null)
      jcasType.jcas.throwFeatMissing("probability", "org.oaqa.model.OAQATop");
    return jcasType.ll_cas.ll_getFloatValue(addr, ((OAQATop_Type)jcasType).casFeatCode_probability);}
    
  /** setter for probability - sets The annotator's estimate of the probability associated with this annotation. 
   * @generated */
  public void setProbability(float v) {
    if (OAQATop_Type.featOkTst && ((OAQATop_Type)jcasType).casFeat_probability == null)
      jcasType.jcas.throwFeatMissing("probability", "org.oaqa.model.OAQATop");
    jcasType.ll_cas.ll_setFloatValue(addr, ((OAQATop_Type)jcasType).casFeatCode_probability, v);}    
  }

    