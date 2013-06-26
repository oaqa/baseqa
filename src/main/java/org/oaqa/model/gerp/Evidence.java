

/* First created by JCasGen Mon Jun 24 14:02:20 EDT 2013 */
package org.oaqa.model.gerp;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSList;


/** A type represents the evidence for the candidate entities, which is provided by an evidencer.
 * Updated by JCasGen Wed Jun 26 17:33:01 EDT 2013
 * XML source: C:/Users/yangz13/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class Evidence extends GerpBase {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Evidence.class);
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
  protected Evidence() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Evidence(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Evidence(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: confidence

  /** getter for confidence - gets A score that indicates how likely the evidencer estimates the entity is qualified for the task.
   * @generated */
  public float getConfidence() {
    if (Evidence_Type.featOkTst && ((Evidence_Type)jcasType).casFeat_confidence == null)
      jcasType.jcas.throwFeatMissing("confidence", "org.oaqa.model.gerp.Evidence");
    return jcasType.ll_cas.ll_getFloatValue(addr, ((Evidence_Type)jcasType).casFeatCode_confidence);}
    
  /** setter for confidence - sets A score that indicates how likely the evidencer estimates the entity is qualified for the task. 
   * @generated */
  public void setConfidence(float v) {
    if (Evidence_Type.featOkTst && ((Evidence_Type)jcasType).casFeat_confidence == null)
      jcasType.jcas.throwFeatMissing("confidence", "org.oaqa.model.gerp.Evidence");
    jcasType.ll_cas.ll_setFloatValue(addr, ((Evidence_Type)jcasType).casFeatCode_confidence, v);}    
   
    
  //*--------------*
  //* Feature: additionalEvidences

  /** getter for additionalEvidences - gets Detailed evidences provided by the evidencer in addition to the confidence score, e.g. related document URIs where a text similarity based evidence is calculated.
   * @generated */
  public FSList getAdditionalEvidences() {
    if (Evidence_Type.featOkTst && ((Evidence_Type)jcasType).casFeat_additionalEvidences == null)
      jcasType.jcas.throwFeatMissing("additionalEvidences", "org.oaqa.model.gerp.Evidence");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Evidence_Type)jcasType).casFeatCode_additionalEvidences)));}
    
  /** setter for additionalEvidences - sets Detailed evidences provided by the evidencer in addition to the confidence score, e.g. related document URIs where a text similarity based evidence is calculated. 
   * @generated */
  public void setAdditionalEvidences(FSList v) {
    if (Evidence_Type.featOkTst && ((Evidence_Type)jcasType).casFeat_additionalEvidences == null)
      jcasType.jcas.throwFeatMissing("additionalEvidences", "org.oaqa.model.gerp.Evidence");
    jcasType.ll_cas.ll_setRefValue(addr, ((Evidence_Type)jcasType).casFeatCode_additionalEvidences, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    