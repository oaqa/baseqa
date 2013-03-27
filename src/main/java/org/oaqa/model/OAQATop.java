

/* First created by JCasGen Tue Mar 26 17:55:41 EDT 2013 */
package org.oaqa.model;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.TOP;


/** The base class for OAQA feature structures that are not Annotations.
 * Updated by JCasGen Tue Mar 26 17:55:41 EDT 2013
 * XML source: /usr0/srchvrs/stuff/OAQA.rankqa/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
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
  //* Feature: score

  /** getter for score - gets The annotator's score.
   * @generated */
  public double getScore() {
    if (OAQATop_Type.featOkTst && ((OAQATop_Type)jcasType).casFeat_score == null)
      jcasType.jcas.throwFeatMissing("score", "org.oaqa.model.OAQATop");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((OAQATop_Type)jcasType).casFeatCode_score);}
    
  /** setter for score - sets The annotator's score. 
   * @generated */
  public void setScore(double v) {
    if (OAQATop_Type.featOkTst && ((OAQATop_Type)jcasType).casFeat_score == null)
      jcasType.jcas.throwFeatMissing("score", "org.oaqa.model.OAQATop");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((OAQATop_Type)jcasType).casFeatCode_score, v);}    
   
    
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

    