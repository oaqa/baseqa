

/* First created by JCasGen Sat Apr 11 19:49:33 EDT 2015 */
package edu.cmu.lti.oaqa.type.retrieval;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.TOP;
import org.apache.uima.jcas.cas.StringList;


/** A query concept in the abstract search query model.
 * Updated by JCasGen Mon Apr 13 16:42:08 EDT 2015
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/baseqa/type/OAQATypes.xml
 * @generated */
public class QueryConcept extends TOP {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(QueryConcept.class);
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
  protected QueryConcept() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public QueryConcept(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public QueryConcept(JCas jcas) {
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
  //* Feature: namedEntityTypes

  /** getter for namedEntityTypes - gets List of Named Entity types associated with this concept.
   * @generated
   * @return value of the feature 
   */
  public StringList getNamedEntityTypes() {
    if (QueryConcept_Type.featOkTst && ((QueryConcept_Type)jcasType).casFeat_namedEntityTypes == null)
      jcasType.jcas.throwFeatMissing("namedEntityTypes", "edu.cmu.lti.oaqa.type.retrieval.QueryConcept");
    return (StringList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((QueryConcept_Type)jcasType).casFeatCode_namedEntityTypes)));}
    
  /** setter for namedEntityTypes - sets List of Named Entity types associated with this concept. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setNamedEntityTypes(StringList v) {
    if (QueryConcept_Type.featOkTst && ((QueryConcept_Type)jcasType).casFeat_namedEntityTypes == null)
      jcasType.jcas.throwFeatMissing("namedEntityTypes", "edu.cmu.lti.oaqa.type.retrieval.QueryConcept");
    jcasType.ll_cas.ll_setRefValue(addr, ((QueryConcept_Type)jcasType).casFeatCode_namedEntityTypes, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: conceptType

  /** getter for conceptType - gets The type of this concept.
   * @generated
   * @return value of the feature 
   */
  public String getConceptType() {
    if (QueryConcept_Type.featOkTst && ((QueryConcept_Type)jcasType).casFeat_conceptType == null)
      jcasType.jcas.throwFeatMissing("conceptType", "edu.cmu.lti.oaqa.type.retrieval.QueryConcept");
    return jcasType.ll_cas.ll_getStringValue(addr, ((QueryConcept_Type)jcasType).casFeatCode_conceptType);}
    
  /** setter for conceptType - sets The type of this concept. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setConceptType(String v) {
    if (QueryConcept_Type.featOkTst && ((QueryConcept_Type)jcasType).casFeat_conceptType == null)
      jcasType.jcas.throwFeatMissing("conceptType", "edu.cmu.lti.oaqa.type.retrieval.QueryConcept");
    jcasType.ll_cas.ll_setStringValue(addr, ((QueryConcept_Type)jcasType).casFeatCode_conceptType, v);}    
  }

    