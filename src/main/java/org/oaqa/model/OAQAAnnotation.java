

/* First created by JCasGen Mon Oct 08 18:56:44 EDT 2012 */
package org.oaqa.model;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** The Question Analysis supertype that defines the attributes common to all question analysis results.
 * Updated by JCasGen Thu Oct 11 12:34:48 EDT 2012
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class OAQAAnnotation extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(OAQAAnnotation.class);
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
  protected OAQAAnnotation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public OAQAAnnotation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public OAQAAnnotation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public OAQAAnnotation(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
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
    if (OAQAAnnotation_Type.featOkTst && ((OAQAAnnotation_Type)jcasType).casFeat_componentId == null)
      jcasType.jcas.throwFeatMissing("componentId", "org.oaqa.model.OAQAAnnotation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((OAQAAnnotation_Type)jcasType).casFeatCode_componentId);}
    
  /** setter for componentId - sets The unique id of the component that created this instance. 
   * @generated */
  public void setComponentId(String v) {
    if (OAQAAnnotation_Type.featOkTst && ((OAQAAnnotation_Type)jcasType).casFeat_componentId == null)
      jcasType.jcas.throwFeatMissing("componentId", "org.oaqa.model.OAQAAnnotation");
    jcasType.ll_cas.ll_setStringValue(addr, ((OAQAAnnotation_Type)jcasType).casFeatCode_componentId, v);}    
   
    
  //*--------------*
  //* Feature: probability

  /** getter for probability - gets The annotator's estimate of the probability associated with this annotation.
   * @generated */
  public float getProbability() {
    if (OAQAAnnotation_Type.featOkTst && ((OAQAAnnotation_Type)jcasType).casFeat_probability == null)
      jcasType.jcas.throwFeatMissing("probability", "org.oaqa.model.OAQAAnnotation");
    return jcasType.ll_cas.ll_getFloatValue(addr, ((OAQAAnnotation_Type)jcasType).casFeatCode_probability);}
    
  /** setter for probability - sets The annotator's estimate of the probability associated with this annotation. 
   * @generated */
  public void setProbability(float v) {
    if (OAQAAnnotation_Type.featOkTst && ((OAQAAnnotation_Type)jcasType).casFeat_probability == null)
      jcasType.jcas.throwFeatMissing("probability", "org.oaqa.model.OAQAAnnotation");
    jcasType.ll_cas.ll_setFloatValue(addr, ((OAQAAnnotation_Type)jcasType).casFeatCode_probability, v);}    
   
    
  //*--------------*
  //* Feature: implementingWrapper

  /** getter for implementingWrapper - gets 
   * @generated */
  public String getImplementingWrapper() {
    if (OAQAAnnotation_Type.featOkTst && ((OAQAAnnotation_Type)jcasType).casFeat_implementingWrapper == null)
      jcasType.jcas.throwFeatMissing("implementingWrapper", "org.oaqa.model.OAQAAnnotation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((OAQAAnnotation_Type)jcasType).casFeatCode_implementingWrapper);}
    
  /** setter for implementingWrapper - sets  
   * @generated */
  public void setImplementingWrapper(String v) {
    if (OAQAAnnotation_Type.featOkTst && ((OAQAAnnotation_Type)jcasType).casFeat_implementingWrapper == null)
      jcasType.jcas.throwFeatMissing("implementingWrapper", "org.oaqa.model.OAQAAnnotation");
    jcasType.ll_cas.ll_setStringValue(addr, ((OAQAAnnotation_Type)jcasType).casFeatCode_implementingWrapper, v);}    
  }

    