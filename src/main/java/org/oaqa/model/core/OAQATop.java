

/* First created by JCasGen Mon Jun 24 14:02:20 EDT 2013 */
package org.oaqa.model.core;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.TOP;


/** The base class for OAQA feature structures that are not Annotations.
 * Updated by JCasGen Mon Jun 24 14:02:20 EDT 2013
 * XML source: C:/Users/yangz13/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
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
  //* Feature: implementingWrapper

  /** getter for implementingWrapper - gets The name of the Java wrapper class that enables more convenient methods for the original derived Java class.
   * @generated */
  public String getImplementingWrapper() {
    if (OAQATop_Type.featOkTst && ((OAQATop_Type)jcasType).casFeat_implementingWrapper == null)
      jcasType.jcas.throwFeatMissing("implementingWrapper", "org.oaqa.model.core.OAQATop");
    return jcasType.ll_cas.ll_getStringValue(addr, ((OAQATop_Type)jcasType).casFeatCode_implementingWrapper);}
    
  /** setter for implementingWrapper - sets The name of the Java wrapper class that enables more convenient methods for the original derived Java class. 
   * @generated */
  public void setImplementingWrapper(String v) {
    if (OAQATop_Type.featOkTst && ((OAQATop_Type)jcasType).casFeat_implementingWrapper == null)
      jcasType.jcas.throwFeatMissing("implementingWrapper", "org.oaqa.model.core.OAQATop");
    jcasType.ll_cas.ll_setStringValue(addr, ((OAQATop_Type)jcasType).casFeatCode_implementingWrapper, v);}    
  }

    