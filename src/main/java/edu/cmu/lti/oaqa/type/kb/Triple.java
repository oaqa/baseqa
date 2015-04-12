

/* First created by JCasGen Sat Apr 11 19:49:33 EDT 2015 */
package edu.cmu.lti.oaqa.type.kb;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.TOP;


/** A triple, e.g., and RDF triple.
 * Updated by JCasGen Mon Apr 13 16:42:08 EDT 2015
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/baseqa/type/OAQATypes.xml
 * @generated */
public class Triple extends TOP {
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
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Triple() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Triple(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Triple(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: subject

  /** getter for subject - gets The subject of the triple - always a URI.
   * @generated
   * @return value of the feature 
   */
  public String getSubject() {
    if (Triple_Type.featOkTst && ((Triple_Type)jcasType).casFeat_subject == null)
      jcasType.jcas.throwFeatMissing("subject", "edu.cmu.lti.oaqa.type.kb.Triple");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Triple_Type)jcasType).casFeatCode_subject);}
    
  /** setter for subject - sets The subject of the triple - always a URI. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setSubject(String v) {
    if (Triple_Type.featOkTst && ((Triple_Type)jcasType).casFeat_subject == null)
      jcasType.jcas.throwFeatMissing("subject", "edu.cmu.lti.oaqa.type.kb.Triple");
    jcasType.ll_cas.ll_setStringValue(addr, ((Triple_Type)jcasType).casFeatCode_subject, v);}    
   
    
  //*--------------*
  //* Feature: predicate

  /** getter for predicate - gets The predicate of the triple - always a URI.
   * @generated
   * @return value of the feature 
   */
  public String getPredicate() {
    if (Triple_Type.featOkTst && ((Triple_Type)jcasType).casFeat_predicate == null)
      jcasType.jcas.throwFeatMissing("predicate", "edu.cmu.lti.oaqa.type.kb.Triple");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Triple_Type)jcasType).casFeatCode_predicate);}
    
  /** setter for predicate - sets The predicate of the triple - always a URI. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setPredicate(String v) {
    if (Triple_Type.featOkTst && ((Triple_Type)jcasType).casFeat_predicate == null)
      jcasType.jcas.throwFeatMissing("predicate", "edu.cmu.lti.oaqa.type.kb.Triple");
    jcasType.ll_cas.ll_setStringValue(addr, ((Triple_Type)jcasType).casFeatCode_predicate, v);}    
   
    
  //*--------------*
  //* Feature: object

  /** getter for object - gets The object of the triple - may be a URI or an xml datatype (string, int, etc.). See isObjeUri to determine if object is a URI.
   * @generated
   * @return value of the feature 
   */
  public String getObject() {
    if (Triple_Type.featOkTst && ((Triple_Type)jcasType).casFeat_object == null)
      jcasType.jcas.throwFeatMissing("object", "edu.cmu.lti.oaqa.type.kb.Triple");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Triple_Type)jcasType).casFeatCode_object);}
    
  /** setter for object - sets The object of the triple - may be a URI or an xml datatype (string, int, etc.). See isObjeUri to determine if object is a URI. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setObject(String v) {
    if (Triple_Type.featOkTst && ((Triple_Type)jcasType).casFeat_object == null)
      jcasType.jcas.throwFeatMissing("object", "edu.cmu.lti.oaqa.type.kb.Triple");
    jcasType.ll_cas.ll_setStringValue(addr, ((Triple_Type)jcasType).casFeatCode_object, v);}    
   
    
  //*--------------*
  //* Feature: isObjUri

  /** getter for isObjUri - gets Boolean flag - true of object field is a URI, false otherwise.
   * @generated
   * @return value of the feature 
   */
  public boolean getIsObjUri() {
    if (Triple_Type.featOkTst && ((Triple_Type)jcasType).casFeat_isObjUri == null)
      jcasType.jcas.throwFeatMissing("isObjUri", "edu.cmu.lti.oaqa.type.kb.Triple");
    return jcasType.ll_cas.ll_getBooleanValue(addr, ((Triple_Type)jcasType).casFeatCode_isObjUri);}
    
  /** setter for isObjUri - sets Boolean flag - true of object field is a URI, false otherwise. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setIsObjUri(boolean v) {
    if (Triple_Type.featOkTst && ((Triple_Type)jcasType).casFeat_isObjUri == null)
      jcasType.jcas.throwFeatMissing("isObjUri", "edu.cmu.lti.oaqa.type.kb.Triple");
    jcasType.ll_cas.ll_setBooleanValue(addr, ((Triple_Type)jcasType).casFeatCode_isObjUri, v);}    
  }

    