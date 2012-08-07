

/* First created by JCasGen Thu May 24 16:45:52 EDT 2012 */
package edu.cmu.lti.bio;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** Annotation from which others inherit ComponentID and other common attributes
 * Updated by JCasGen Thu May 24 16:57:33 EDT 2012
 * XML source: /Users/elmer/Documents/workspace/MergedQA/src/main/resources/edu/cmu/lti/oaqa/bio/model/bioTypes.xml
 * @generated */
public class bioAnnotation extends Annotation {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(bioAnnotation.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected bioAnnotation() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public bioAnnotation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public bioAnnotation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public bioAnnotation(JCas jcas, int begin, int end) {
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
  //* Feature: ComponentID

  /** getter for ComponentID - gets Description (name) of the AE Component that generated this annotation
   * @generated */
  public String getComponentID() {
    if (bioAnnotation_Type.featOkTst && ((bioAnnotation_Type)jcasType).casFeat_ComponentID == null)
      jcasType.jcas.throwFeatMissing("ComponentID", "edu.cmu.lti.bio.bioAnnotation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((bioAnnotation_Type)jcasType).casFeatCode_ComponentID);}
    
  /** setter for ComponentID - sets Description (name) of the AE Component that generated this annotation 
   * @generated */
  public void setComponentID(String v) {
    if (bioAnnotation_Type.featOkTst && ((bioAnnotation_Type)jcasType).casFeat_ComponentID == null)
      jcasType.jcas.throwFeatMissing("ComponentID", "edu.cmu.lti.bio.bioAnnotation");
    jcasType.ll_cas.ll_setStringValue(addr, ((bioAnnotation_Type)jcasType).casFeatCode_ComponentID, v);}    
   
    
  //*--------------*
  //* Feature: Version

  /** getter for Version - gets Version identifier of AE Component (or configuration) that produced this annotation
   * @generated */
  public String getVersion() {
    if (bioAnnotation_Type.featOkTst && ((bioAnnotation_Type)jcasType).casFeat_Version == null)
      jcasType.jcas.throwFeatMissing("Version", "edu.cmu.lti.bio.bioAnnotation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((bioAnnotation_Type)jcasType).casFeatCode_Version);}
    
  /** setter for Version - sets Version identifier of AE Component (or configuration) that produced this annotation 
   * @generated */
  public void setVersion(String v) {
    if (bioAnnotation_Type.featOkTst && ((bioAnnotation_Type)jcasType).casFeat_Version == null)
      jcasType.jcas.throwFeatMissing("Version", "edu.cmu.lti.bio.bioAnnotation");
    jcasType.ll_cas.ll_setStringValue(addr, ((bioAnnotation_Type)jcasType).casFeatCode_Version, v);}    
  }

    