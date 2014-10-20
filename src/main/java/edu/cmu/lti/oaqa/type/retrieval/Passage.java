

/* First created by JCasGen Sun Oct 19 14:47:24 EDT 2014 */
package edu.cmu.lti.oaqa.type.retrieval;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** A passage search result.
 * Updated by JCasGen Sun Oct 19 14:47:24 EDT 2014
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/baseqa/type/OAQATypes.xml
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
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Passage() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Passage(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Passage(JCas jcas) {
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
  //* Feature: title

  /** getter for title - gets The title of the document that contains this passage.
   * @generated
   * @return value of the feature 
   */
  public String getTitle() {
    if (Passage_Type.featOkTst && ((Passage_Type)jcasType).casFeat_title == null)
      jcasType.jcas.throwFeatMissing("title", "edu.cmu.lti.oaqa.type.retrieval.Passage");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Passage_Type)jcasType).casFeatCode_title);}
    
  /** setter for title - sets The title of the document that contains this passage. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setTitle(String v) {
    if (Passage_Type.featOkTst && ((Passage_Type)jcasType).casFeat_title == null)
      jcasType.jcas.throwFeatMissing("title", "edu.cmu.lti.oaqa.type.retrieval.Passage");
    jcasType.ll_cas.ll_setStringValue(addr, ((Passage_Type)jcasType).casFeatCode_title, v);}    
   
    
  //*--------------*
  //* Feature: docId

  /** getter for docId - gets A unique identifier for the document that conatins this passage.
   * @generated
   * @return value of the feature 
   */
  public String getDocId() {
    if (Passage_Type.featOkTst && ((Passage_Type)jcasType).casFeat_docId == null)
      jcasType.jcas.throwFeatMissing("docId", "edu.cmu.lti.oaqa.type.retrieval.Passage");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Passage_Type)jcasType).casFeatCode_docId);}
    
  /** setter for docId - sets A unique identifier for the document that conatins this passage. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setDocId(String v) {
    if (Passage_Type.featOkTst && ((Passage_Type)jcasType).casFeat_docId == null)
      jcasType.jcas.throwFeatMissing("docId", "edu.cmu.lti.oaqa.type.retrieval.Passage");
    jcasType.ll_cas.ll_setStringValue(addr, ((Passage_Type)jcasType).casFeatCode_docId, v);}    
   
    
  //*--------------*
  //* Feature: offsetInBeginSection

  /** getter for offsetInBeginSection - gets Character offset of the start of this passage within the section that contains this passage.
   * @generated
   * @return value of the feature 
   */
  public int getOffsetInBeginSection() {
    if (Passage_Type.featOkTst && ((Passage_Type)jcasType).casFeat_offsetInBeginSection == null)
      jcasType.jcas.throwFeatMissing("offsetInBeginSection", "edu.cmu.lti.oaqa.type.retrieval.Passage");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Passage_Type)jcasType).casFeatCode_offsetInBeginSection);}
    
  /** setter for offsetInBeginSection - sets Character offset of the start of this passage within the section that contains this passage. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setOffsetInBeginSection(int v) {
    if (Passage_Type.featOkTst && ((Passage_Type)jcasType).casFeat_offsetInBeginSection == null)
      jcasType.jcas.throwFeatMissing("offsetInBeginSection", "edu.cmu.lti.oaqa.type.retrieval.Passage");
    jcasType.ll_cas.ll_setIntValue(addr, ((Passage_Type)jcasType).casFeatCode_offsetInBeginSection, v);}    
   
    
  //*--------------*
  //* Feature: offsetInEndSection

  /** getter for offsetInEndSection - gets Character offset of the end of this passage within the section that contains this passage.
   * @generated
   * @return value of the feature 
   */
  public int getOffsetInEndSection() {
    if (Passage_Type.featOkTst && ((Passage_Type)jcasType).casFeat_offsetInEndSection == null)
      jcasType.jcas.throwFeatMissing("offsetInEndSection", "edu.cmu.lti.oaqa.type.retrieval.Passage");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Passage_Type)jcasType).casFeatCode_offsetInEndSection);}
    
  /** setter for offsetInEndSection - sets Character offset of the end of this passage within the section that contains this passage. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setOffsetInEndSection(int v) {
    if (Passage_Type.featOkTst && ((Passage_Type)jcasType).casFeat_offsetInEndSection == null)
      jcasType.jcas.throwFeatMissing("offsetInEndSection", "edu.cmu.lti.oaqa.type.retrieval.Passage");
    jcasType.ll_cas.ll_setIntValue(addr, ((Passage_Type)jcasType).casFeatCode_offsetInEndSection, v);}    
   
    
  //*--------------*
  //* Feature: beginSection

  /** getter for beginSection - gets The start section of this passage within the document that contains this passage.
   * @generated
   * @return value of the feature 
   */
  public String getBeginSection() {
    if (Passage_Type.featOkTst && ((Passage_Type)jcasType).casFeat_beginSection == null)
      jcasType.jcas.throwFeatMissing("beginSection", "edu.cmu.lti.oaqa.type.retrieval.Passage");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Passage_Type)jcasType).casFeatCode_beginSection);}
    
  /** setter for beginSection - sets The start section of this passage within the document that contains this passage. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setBeginSection(String v) {
    if (Passage_Type.featOkTst && ((Passage_Type)jcasType).casFeat_beginSection == null)
      jcasType.jcas.throwFeatMissing("beginSection", "edu.cmu.lti.oaqa.type.retrieval.Passage");
    jcasType.ll_cas.ll_setStringValue(addr, ((Passage_Type)jcasType).casFeatCode_beginSection, v);}    
   
    
  //*--------------*
  //* Feature: endSection

  /** getter for endSection - gets The end section of this passage within the document that contains this passage.
   * @generated
   * @return value of the feature 
   */
  public String getEndSection() {
    if (Passage_Type.featOkTst && ((Passage_Type)jcasType).casFeat_endSection == null)
      jcasType.jcas.throwFeatMissing("endSection", "edu.cmu.lti.oaqa.type.retrieval.Passage");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Passage_Type)jcasType).casFeatCode_endSection);}
    
  /** setter for endSection - sets The end section of this passage within the document that contains this passage. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setEndSection(String v) {
    if (Passage_Type.featOkTst && ((Passage_Type)jcasType).casFeat_endSection == null)
      jcasType.jcas.throwFeatMissing("endSection", "edu.cmu.lti.oaqa.type.retrieval.Passage");
    jcasType.ll_cas.ll_setStringValue(addr, ((Passage_Type)jcasType).casFeatCode_endSection, v);}    
   
    
  //*--------------*
  //* Feature: aspects

  /** getter for aspects - gets Aspects of the gold standard passage.
   * @generated
   * @return value of the feature 
   */
  public String getAspects() {
    if (Passage_Type.featOkTst && ((Passage_Type)jcasType).casFeat_aspects == null)
      jcasType.jcas.throwFeatMissing("aspects", "edu.cmu.lti.oaqa.type.retrieval.Passage");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Passage_Type)jcasType).casFeatCode_aspects);}
    
  /** setter for aspects - sets Aspects of the gold standard passage. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setAspects(String v) {
    if (Passage_Type.featOkTst && ((Passage_Type)jcasType).casFeat_aspects == null)
      jcasType.jcas.throwFeatMissing("aspects", "edu.cmu.lti.oaqa.type.retrieval.Passage");
    jcasType.ll_cas.ll_setStringValue(addr, ((Passage_Type)jcasType).casFeatCode_aspects, v);}    
  }

    