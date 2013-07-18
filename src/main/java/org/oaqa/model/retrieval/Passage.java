

/* First created by JCasGen Mon Jul 08 17:12:14 EDT 2013 */
package org.oaqa.model.retrieval;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** A passage search result.
 * Updated by JCasGen Thu Jul 18 17:30:38 EDT 2013
 * XML source: C:/Users/yangz13/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class Passage extends SearchResult {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Passage.class);
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
  protected Passage() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Passage(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Passage(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: title

  /** getter for title - gets The title of the document that contains this passage.
   * @generated */
  public String getTitle() {
    if (Passage_Type.featOkTst && ((Passage_Type)jcasType).casFeat_title == null)
      jcasType.jcas.throwFeatMissing("title", "org.oaqa.model.retrieval.Passage");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Passage_Type)jcasType).casFeatCode_title);}
    
  /** setter for title - sets The title of the document that contains this passage. 
   * @generated */
  public void setTitle(String v) {
    if (Passage_Type.featOkTst && ((Passage_Type)jcasType).casFeat_title == null)
      jcasType.jcas.throwFeatMissing("title", "org.oaqa.model.retrieval.Passage");
    jcasType.ll_cas.ll_setStringValue(addr, ((Passage_Type)jcasType).casFeatCode_title, v);}    
   
    
  //*--------------*
  //* Feature: docId

  /** getter for docId - gets A unique identifier for the document that conatins this passage.
   * @generated */
  public String getDocId() {
    if (Passage_Type.featOkTst && ((Passage_Type)jcasType).casFeat_docId == null)
      jcasType.jcas.throwFeatMissing("docId", "org.oaqa.model.retrieval.Passage");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Passage_Type)jcasType).casFeatCode_docId);}
    
  /** setter for docId - sets A unique identifier for the document that conatins this passage. 
   * @generated */
  public void setDocId(String v) {
    if (Passage_Type.featOkTst && ((Passage_Type)jcasType).casFeat_docId == null)
      jcasType.jcas.throwFeatMissing("docId", "org.oaqa.model.retrieval.Passage");
    jcasType.ll_cas.ll_setStringValue(addr, ((Passage_Type)jcasType).casFeatCode_docId, v);}    
   
    
  //*--------------*
  //* Feature: begin

  /** getter for begin - gets Character offset of the start of this passage within the document that contains this passage.
   * @generated */
  public int getBegin() {
    if (Passage_Type.featOkTst && ((Passage_Type)jcasType).casFeat_begin == null)
      jcasType.jcas.throwFeatMissing("begin", "org.oaqa.model.retrieval.Passage");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Passage_Type)jcasType).casFeatCode_begin);}
    
  /** setter for begin - sets Character offset of the start of this passage within the document that contains this passage. 
   * @generated */
  public void setBegin(int v) {
    if (Passage_Type.featOkTst && ((Passage_Type)jcasType).casFeat_begin == null)
      jcasType.jcas.throwFeatMissing("begin", "org.oaqa.model.retrieval.Passage");
    jcasType.ll_cas.ll_setIntValue(addr, ((Passage_Type)jcasType).casFeatCode_begin, v);}    
   
    
  //*--------------*
  //* Feature: end

  /** getter for end - gets Character offset of the end of this passage within the document that contains this passage.
   * @generated */
  public int getEnd() {
    if (Passage_Type.featOkTst && ((Passage_Type)jcasType).casFeat_end == null)
      jcasType.jcas.throwFeatMissing("end", "org.oaqa.model.retrieval.Passage");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Passage_Type)jcasType).casFeatCode_end);}
    
  /** setter for end - sets Character offset of the end of this passage within the document that contains this passage. 
   * @generated */
  public void setEnd(int v) {
    if (Passage_Type.featOkTst && ((Passage_Type)jcasType).casFeat_end == null)
      jcasType.jcas.throwFeatMissing("end", "org.oaqa.model.retrieval.Passage");
    jcasType.ll_cas.ll_setIntValue(addr, ((Passage_Type)jcasType).casFeatCode_end, v);}    
   
    
  //*--------------*
  //* Feature: aspects

  /** getter for aspects - gets Aspects of the gold standard passage.
   * @generated */
  public String getAspects() {
    if (Passage_Type.featOkTst && ((Passage_Type)jcasType).casFeat_aspects == null)
      jcasType.jcas.throwFeatMissing("aspects", "org.oaqa.model.retrieval.Passage");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Passage_Type)jcasType).casFeatCode_aspects);}
    
  /** setter for aspects - sets Aspects of the gold standard passage. 
   * @generated */
  public void setAspects(String v) {
    if (Passage_Type.featOkTst && ((Passage_Type)jcasType).casFeat_aspects == null)
      jcasType.jcas.throwFeatMissing("aspects", "org.oaqa.model.retrieval.Passage");
    jcasType.ll_cas.ll_setStringValue(addr, ((Passage_Type)jcasType).casFeatCode_aspects, v);}    
  }

    