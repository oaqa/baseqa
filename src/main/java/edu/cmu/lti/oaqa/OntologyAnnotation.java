

/* First created by JCasGen Thu May 24 16:45:52 EDT 2012 */
package edu.cmu.lti.oaqa;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Thu May 24 16:57:33 EDT 2012
 * XML source: /Users/elmer/Documents/workspace/MergedQA/src/main/resources/edu/cmu/lti/oaqa/bio/model/bioTypes.xml
 * @generated */
public class OntologyAnnotation extends Annotation {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(OntologyAnnotation.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected OntologyAnnotation() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public OntologyAnnotation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public OntologyAnnotation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public OntologyAnnotation(JCas jcas, int begin, int end) {
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

  /** getter for ComponentID - gets Name of the ontology / wordlist / Component that created this
   * @generated */
  public String getComponentID() {
    if (OntologyAnnotation_Type.featOkTst && ((OntologyAnnotation_Type)jcasType).casFeat_ComponentID == null)
      jcasType.jcas.throwFeatMissing("ComponentID", "edu.cmu.lti.oaqa.OntologyAnnotation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((OntologyAnnotation_Type)jcasType).casFeatCode_ComponentID);}
    
  /** setter for ComponentID - sets Name of the ontology / wordlist / Component that created this 
   * @generated */
  public void setComponentID(String v) {
    if (OntologyAnnotation_Type.featOkTst && ((OntologyAnnotation_Type)jcasType).casFeat_ComponentID == null)
      jcasType.jcas.throwFeatMissing("ComponentID", "edu.cmu.lti.oaqa.OntologyAnnotation");
    jcasType.ll_cas.ll_setStringValue(addr, ((OntologyAnnotation_Type)jcasType).casFeatCode_ComponentID, v);}    
  }

    