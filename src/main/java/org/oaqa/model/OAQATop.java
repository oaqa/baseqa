

/* First created by JCasGen Mon Oct 08 18:56:44 EDT 2012 */
package org.oaqa.model;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.TOP;


/** The base class for OAQA feature structures that are not Annotations.
 * Updated by JCasGen Thu Oct 11 12:39:21 EDT 2012
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class OAQATop extends TOP {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(OAQATop.class);
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
  protected OAQATop() {/* intentionally empty block */}
    
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
  private void readObject() {/*default - does nothing empty block */}
     
 
    
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
   
    
  //*--------------*
  //* Feature: implementingWrapper

  /** getter for implementingWrapper - gets 
   * @generated */
  public String getImplementingWrapper() {
    if (OAQATop_Type.featOkTst && ((OAQATop_Type)jcasType).casFeat_implementingWrapper == null)
      jcasType.jcas.throwFeatMissing("implementingWrapper", "org.oaqa.model.OAQATop");
    return jcasType.ll_cas.ll_getStringValue(addr, ((OAQATop_Type)jcasType).casFeatCode_implementingWrapper);}
    
  /** setter for implementingWrapper - sets  
   * @generated */
  public void setImplementingWrapper(String v) {
    if (OAQATop_Type.featOkTst && ((OAQATop_Type)jcasType).casFeat_implementingWrapper == null)
      jcasType.jcas.throwFeatMissing("implementingWrapper", "org.oaqa.model.OAQATop");
    jcasType.ll_cas.ll_setStringValue(addr, ((OAQATop_Type)jcasType).casFeatCode_implementingWrapper, v);}    
  }

    