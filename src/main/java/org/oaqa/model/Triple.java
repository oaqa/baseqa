

/* First created by JCasGen Thu Feb 21 16:50:37 EST 2013 */
package org.oaqa.model;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** A triple, e.g., and RDF triple.
 * Updated by JCasGen Thu Feb 21 16:50:37 EST 2013
 * XML source: /usr0/srchvrs/stuff/OAQA.rankqa/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class Triple extends OAQATop {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Triple.class);
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
  protected Triple() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Triple(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Triple(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: subject

  /** getter for subject - gets The subject of the triple - always a URI.
   * @generated */
  public String getSubject() {
    if (Triple_Type.featOkTst && ((Triple_Type)jcasType).casFeat_subject == null)
      jcasType.jcas.throwFeatMissing("subject", "org.oaqa.model.Triple");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Triple_Type)jcasType).casFeatCode_subject);}
    
  /** setter for subject - sets The subject of the triple - always a URI. 
   * @generated */
  public void setSubject(String v) {
    if (Triple_Type.featOkTst && ((Triple_Type)jcasType).casFeat_subject == null)
      jcasType.jcas.throwFeatMissing("subject", "org.oaqa.model.Triple");
    jcasType.ll_cas.ll_setStringValue(addr, ((Triple_Type)jcasType).casFeatCode_subject, v);}    
   
    
  //*--------------*
  //* Feature: predicate

  /** getter for predicate - gets The predicate of the triple - always a URI.
   * @generated */
  public String getPredicate() {
    if (Triple_Type.featOkTst && ((Triple_Type)jcasType).casFeat_predicate == null)
      jcasType.jcas.throwFeatMissing("predicate", "org.oaqa.model.Triple");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Triple_Type)jcasType).casFeatCode_predicate);}
    
  /** setter for predicate - sets The predicate of the triple - always a URI. 
   * @generated */
  public void setPredicate(String v) {
    if (Triple_Type.featOkTst && ((Triple_Type)jcasType).casFeat_predicate == null)
      jcasType.jcas.throwFeatMissing("predicate", "org.oaqa.model.Triple");
    jcasType.ll_cas.ll_setStringValue(addr, ((Triple_Type)jcasType).casFeatCode_predicate, v);}    
   
    
  //*--------------*
  //* Feature: object

  /** getter for object - gets The object of the triple - may be a URI or an xml datatype (string, int, etc.).  See isObjeUri to determine if object is a URI.
   * @generated */
  public String getObject() {
    if (Triple_Type.featOkTst && ((Triple_Type)jcasType).casFeat_object == null)
      jcasType.jcas.throwFeatMissing("object", "org.oaqa.model.Triple");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Triple_Type)jcasType).casFeatCode_object);}
    
  /** setter for object - sets The object of the triple - may be a URI or an xml datatype (string, int, etc.).  See isObjeUri to determine if object is a URI. 
   * @generated */
  public void setObject(String v) {
    if (Triple_Type.featOkTst && ((Triple_Type)jcasType).casFeat_object == null)
      jcasType.jcas.throwFeatMissing("object", "org.oaqa.model.Triple");
    jcasType.ll_cas.ll_setStringValue(addr, ((Triple_Type)jcasType).casFeatCode_object, v);}    
   
    
  //*--------------*
  //* Feature: isObjUri

  /** getter for isObjUri - gets Boolean flag - true of object field is a URI, false otherwise.
   * @generated */
  public boolean getIsObjUri() {
    if (Triple_Type.featOkTst && ((Triple_Type)jcasType).casFeat_isObjUri == null)
      jcasType.jcas.throwFeatMissing("isObjUri", "org.oaqa.model.Triple");
    return jcasType.ll_cas.ll_getBooleanValue(addr, ((Triple_Type)jcasType).casFeatCode_isObjUri);}
    
  /** setter for isObjUri - sets Boolean flag - true of object field is a URI, false otherwise. 
   * @generated */
  public void setIsObjUri(boolean v) {
    if (Triple_Type.featOkTst && ((Triple_Type)jcasType).casFeat_isObjUri == null)
      jcasType.jcas.throwFeatMissing("isObjUri", "org.oaqa.model.Triple");
    jcasType.ll_cas.ll_setBooleanValue(addr, ((Triple_Type)jcasType).casFeatCode_isObjUri, v);}    
  }

    