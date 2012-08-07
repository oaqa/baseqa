

/* First created by JCasGen Wed Aug 01 12:12:46 EDT 2012 */
package org.oaqa.model;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.jcas.cas.StringArray;


/** External resource including ontology
 * Updated by JCasGen Wed Aug 01 12:12:46 EDT 2012
 * XML source: /Users/elmer/Documents/workspace/oaqa/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class ExternalResource extends Annotation {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(ExternalResource.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected ExternalResource() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public ExternalResource(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public ExternalResource(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public ExternalResource(JCas jcas, int begin, int end) {
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
  //* Feature: concept

  /** getter for concept - gets Concept information of this constituent from external resource
   * @generated */
  public String getConcept() {
    if (ExternalResource_Type.featOkTst && ((ExternalResource_Type)jcasType).casFeat_concept == null)
      jcasType.jcas.throwFeatMissing("concept", "org.oaqa.model.ExternalResource");
    return jcasType.ll_cas.ll_getStringValue(addr, ((ExternalResource_Type)jcasType).casFeatCode_concept);}
    
  /** setter for concept - sets Concept information of this constituent from external resource 
   * @generated */
  public void setConcept(String v) {
    if (ExternalResource_Type.featOkTst && ((ExternalResource_Type)jcasType).casFeat_concept == null)
      jcasType.jcas.throwFeatMissing("concept", "org.oaqa.model.ExternalResource");
    jcasType.ll_cas.ll_setStringValue(addr, ((ExternalResource_Type)jcasType).casFeatCode_concept, v);}    
   
    
  //*--------------*
  //* Feature: category

  /** getter for category - gets The category information of consituent
   * @generated */
  public String getCategory() {
    if (ExternalResource_Type.featOkTst && ((ExternalResource_Type)jcasType).casFeat_category == null)
      jcasType.jcas.throwFeatMissing("category", "org.oaqa.model.ExternalResource");
    return jcasType.ll_cas.ll_getStringValue(addr, ((ExternalResource_Type)jcasType).casFeatCode_category);}
    
  /** setter for category - sets The category information of consituent 
   * @generated */
  public void setCategory(String v) {
    if (ExternalResource_Type.featOkTst && ((ExternalResource_Type)jcasType).casFeat_category == null)
      jcasType.jcas.throwFeatMissing("category", "org.oaqa.model.ExternalResource");
    jcasType.ll_cas.ll_setStringValue(addr, ((ExternalResource_Type)jcasType).casFeatCode_category, v);}    
   
    
  //*--------------*
  //* Feature: synonyms

  /** getter for synonyms - gets It contains string array of synonyms
   * @generated */
  public StringArray getSynonyms() {
    if (ExternalResource_Type.featOkTst && ((ExternalResource_Type)jcasType).casFeat_synonyms == null)
      jcasType.jcas.throwFeatMissing("synonyms", "org.oaqa.model.ExternalResource");
    return (StringArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((ExternalResource_Type)jcasType).casFeatCode_synonyms)));}
    
  /** setter for synonyms - sets It contains string array of synonyms 
   * @generated */
  public void setSynonyms(StringArray v) {
    if (ExternalResource_Type.featOkTst && ((ExternalResource_Type)jcasType).casFeat_synonyms == null)
      jcasType.jcas.throwFeatMissing("synonyms", "org.oaqa.model.ExternalResource");
    jcasType.ll_cas.ll_setRefValue(addr, ((ExternalResource_Type)jcasType).casFeatCode_synonyms, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for synonyms - gets an indexed value - It contains string array of synonyms
   * @generated */
  public String getSynonyms(int i) {
    if (ExternalResource_Type.featOkTst && ((ExternalResource_Type)jcasType).casFeat_synonyms == null)
      jcasType.jcas.throwFeatMissing("synonyms", "org.oaqa.model.ExternalResource");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((ExternalResource_Type)jcasType).casFeatCode_synonyms), i);
    return jcasType.ll_cas.ll_getStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((ExternalResource_Type)jcasType).casFeatCode_synonyms), i);}

  /** indexed setter for synonyms - sets an indexed value - It contains string array of synonyms
   * @generated */
  public void setSynonyms(int i, String v) { 
    if (ExternalResource_Type.featOkTst && ((ExternalResource_Type)jcasType).casFeat_synonyms == null)
      jcasType.jcas.throwFeatMissing("synonyms", "org.oaqa.model.ExternalResource");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((ExternalResource_Type)jcasType).casFeatCode_synonyms), i);
    jcasType.ll_cas.ll_setStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((ExternalResource_Type)jcasType).casFeatCode_synonyms), i, v);}
   
    
  //*--------------*
  //* Feature: source

  /** getter for source - gets The source name of this external resource
   * @generated */
  public String getSource() {
    if (ExternalResource_Type.featOkTst && ((ExternalResource_Type)jcasType).casFeat_source == null)
      jcasType.jcas.throwFeatMissing("source", "org.oaqa.model.ExternalResource");
    return jcasType.ll_cas.ll_getStringValue(addr, ((ExternalResource_Type)jcasType).casFeatCode_source);}
    
  /** setter for source - sets The source name of this external resource 
   * @generated */
  public void setSource(String v) {
    if (ExternalResource_Type.featOkTst && ((ExternalResource_Type)jcasType).casFeat_source == null)
      jcasType.jcas.throwFeatMissing("source", "org.oaqa.model.ExternalResource");
    jcasType.ll_cas.ll_setStringValue(addr, ((ExternalResource_Type)jcasType).casFeatCode_source, v);}    
  }

    