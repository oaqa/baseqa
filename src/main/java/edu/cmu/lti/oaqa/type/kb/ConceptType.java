

/* First created by JCasGen Sat Apr 11 19:49:33 EDT 2015 */
package edu.cmu.lti.oaqa.type.kb;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.TOP;


/** The type/category the concept belongs to.
 * Updated by JCasGen Sun Apr 19 19:46:50 EDT 2015
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/baseqa/type/OAQATypes.xml
 * @generated */
public class ConceptType extends TOP {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(ConceptType.class);
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
  protected ConceptType() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public ConceptType(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public ConceptType(JCas jcas) {
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
  //* Feature: id

  /** getter for id - gets The id of the concept type.
   * @generated
   * @return value of the feature 
   */
  public String getId() {
    if (ConceptType_Type.featOkTst && ((ConceptType_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "edu.cmu.lti.oaqa.type.kb.ConceptType");
    return jcasType.ll_cas.ll_getStringValue(addr, ((ConceptType_Type)jcasType).casFeatCode_id);}
    
  /** setter for id - sets The id of the concept type. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setId(String v) {
    if (ConceptType_Type.featOkTst && ((ConceptType_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "edu.cmu.lti.oaqa.type.kb.ConceptType");
    jcasType.ll_cas.ll_setStringValue(addr, ((ConceptType_Type)jcasType).casFeatCode_id, v);}    
   
    
  //*--------------*
  //* Feature: name

  /** getter for name - gets A human readable concept label.
   * @generated
   * @return value of the feature 
   */
  public String getName() {
    if (ConceptType_Type.featOkTst && ((ConceptType_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "edu.cmu.lti.oaqa.type.kb.ConceptType");
    return jcasType.ll_cas.ll_getStringValue(addr, ((ConceptType_Type)jcasType).casFeatCode_name);}
    
  /** setter for name - sets A human readable concept label. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setName(String v) {
    if (ConceptType_Type.featOkTst && ((ConceptType_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "edu.cmu.lti.oaqa.type.kb.ConceptType");
    jcasType.ll_cas.ll_setStringValue(addr, ((ConceptType_Type)jcasType).casFeatCode_name, v);}    
   
    
  //*--------------*
  //* Feature: abbreviation

  /** getter for abbreviation - gets The abbreviation of the name label.
   * @generated
   * @return value of the feature 
   */
  public String getAbbreviation() {
    if (ConceptType_Type.featOkTst && ((ConceptType_Type)jcasType).casFeat_abbreviation == null)
      jcasType.jcas.throwFeatMissing("abbreviation", "edu.cmu.lti.oaqa.type.kb.ConceptType");
    return jcasType.ll_cas.ll_getStringValue(addr, ((ConceptType_Type)jcasType).casFeatCode_abbreviation);}
    
  /** setter for abbreviation - sets The abbreviation of the name label. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setAbbreviation(String v) {
    if (ConceptType_Type.featOkTst && ((ConceptType_Type)jcasType).casFeat_abbreviation == null)
      jcasType.jcas.throwFeatMissing("abbreviation", "edu.cmu.lti.oaqa.type.kb.ConceptType");
    jcasType.ll_cas.ll_setStringValue(addr, ((ConceptType_Type)jcasType).casFeatCode_abbreviation, v);}    
  }

    