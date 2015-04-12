

/* First created by JCasGen Sat Apr 11 19:49:33 EDT 2015 */
package edu.cmu.lti.oaqa.type.retrieval;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.StringArray;


/** A document search result.
 * Updated by JCasGen Mon Apr 13 16:42:08 EDT 2015
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/baseqa/type/OAQATypes.xml
 * @generated */
public class Document extends SearchResult {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Document.class);
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
  protected Document() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Document(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Document(JCas jcas) {
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

  /** getter for title - gets The title of the document.
   * @generated
   * @return value of the feature 
   */
  public String getTitle() {
    if (Document_Type.featOkTst && ((Document_Type)jcasType).casFeat_title == null)
      jcasType.jcas.throwFeatMissing("title", "edu.cmu.lti.oaqa.type.retrieval.Document");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Document_Type)jcasType).casFeatCode_title);}
    
  /** setter for title - sets The title of the document. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setTitle(String v) {
    if (Document_Type.featOkTst && ((Document_Type)jcasType).casFeat_title == null)
      jcasType.jcas.throwFeatMissing("title", "edu.cmu.lti.oaqa.type.retrieval.Document");
    jcasType.ll_cas.ll_setStringValue(addr, ((Document_Type)jcasType).casFeatCode_title, v);}    
   
    
  //*--------------*
  //* Feature: docId

  /** getter for docId - gets A unique identifier for this document.
   * @generated
   * @return value of the feature 
   */
  public String getDocId() {
    if (Document_Type.featOkTst && ((Document_Type)jcasType).casFeat_docId == null)
      jcasType.jcas.throwFeatMissing("docId", "edu.cmu.lti.oaqa.type.retrieval.Document");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Document_Type)jcasType).casFeatCode_docId);}
    
  /** setter for docId - sets A unique identifier for this document. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setDocId(String v) {
    if (Document_Type.featOkTst && ((Document_Type)jcasType).casFeat_docId == null)
      jcasType.jcas.throwFeatMissing("docId", "edu.cmu.lti.oaqa.type.retrieval.Document");
    jcasType.ll_cas.ll_setStringValue(addr, ((Document_Type)jcasType).casFeatCode_docId, v);}    
   
    
  //*--------------*
  //* Feature: sections

  /** getter for sections - gets Content of sections in the document.
   * @generated
   * @return value of the feature 
   */
  public StringArray getSections() {
    if (Document_Type.featOkTst && ((Document_Type)jcasType).casFeat_sections == null)
      jcasType.jcas.throwFeatMissing("sections", "edu.cmu.lti.oaqa.type.retrieval.Document");
    return (StringArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Document_Type)jcasType).casFeatCode_sections)));}
    
  /** setter for sections - sets Content of sections in the document. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setSections(StringArray v) {
    if (Document_Type.featOkTst && ((Document_Type)jcasType).casFeat_sections == null)
      jcasType.jcas.throwFeatMissing("sections", "edu.cmu.lti.oaqa.type.retrieval.Document");
    jcasType.ll_cas.ll_setRefValue(addr, ((Document_Type)jcasType).casFeatCode_sections, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for sections - gets an indexed value - Content of sections in the document.
   * @generated
   * @param i index in the array to get
   * @return value of the element at index i 
   */
  public String getSections(int i) {
    if (Document_Type.featOkTst && ((Document_Type)jcasType).casFeat_sections == null)
      jcasType.jcas.throwFeatMissing("sections", "edu.cmu.lti.oaqa.type.retrieval.Document");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Document_Type)jcasType).casFeatCode_sections), i);
    return jcasType.ll_cas.ll_getStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Document_Type)jcasType).casFeatCode_sections), i);}

  /** indexed setter for sections - sets an indexed value - Content of sections in the document.
   * @generated
   * @param i index in the array to set
   * @param v value to set into the array 
   */
  public void setSections(int i, String v) { 
    if (Document_Type.featOkTst && ((Document_Type)jcasType).casFeat_sections == null)
      jcasType.jcas.throwFeatMissing("sections", "edu.cmu.lti.oaqa.type.retrieval.Document");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Document_Type)jcasType).casFeatCode_sections), i);
    jcasType.ll_cas.ll_setStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Document_Type)jcasType).casFeatCode_sections), i, v);}
   
    
  //*--------------*
  //* Feature: sectionLabels

  /** getter for sectionLabels - gets Section labels in the document, e.g. sections.0, sections1, etc.
   * @generated
   * @return value of the feature 
   */
  public StringArray getSectionLabels() {
    if (Document_Type.featOkTst && ((Document_Type)jcasType).casFeat_sectionLabels == null)
      jcasType.jcas.throwFeatMissing("sectionLabels", "edu.cmu.lti.oaqa.type.retrieval.Document");
    return (StringArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Document_Type)jcasType).casFeatCode_sectionLabels)));}
    
  /** setter for sectionLabels - sets Section labels in the document, e.g. sections.0, sections1, etc. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setSectionLabels(StringArray v) {
    if (Document_Type.featOkTst && ((Document_Type)jcasType).casFeat_sectionLabels == null)
      jcasType.jcas.throwFeatMissing("sectionLabels", "edu.cmu.lti.oaqa.type.retrieval.Document");
    jcasType.ll_cas.ll_setRefValue(addr, ((Document_Type)jcasType).casFeatCode_sectionLabels, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for sectionLabels - gets an indexed value - Section labels in the document, e.g. sections.0, sections1, etc.
   * @generated
   * @param i index in the array to get
   * @return value of the element at index i 
   */
  public String getSectionLabels(int i) {
    if (Document_Type.featOkTst && ((Document_Type)jcasType).casFeat_sectionLabels == null)
      jcasType.jcas.throwFeatMissing("sectionLabels", "edu.cmu.lti.oaqa.type.retrieval.Document");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Document_Type)jcasType).casFeatCode_sectionLabels), i);
    return jcasType.ll_cas.ll_getStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Document_Type)jcasType).casFeatCode_sectionLabels), i);}

  /** indexed setter for sectionLabels - sets an indexed value - Section labels in the document, e.g. sections.0, sections1, etc.
   * @generated
   * @param i index in the array to set
   * @param v value to set into the array 
   */
  public void setSectionLabels(int i, String v) { 
    if (Document_Type.featOkTst && ((Document_Type)jcasType).casFeat_sectionLabels == null)
      jcasType.jcas.throwFeatMissing("sectionLabels", "edu.cmu.lti.oaqa.type.retrieval.Document");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Document_Type)jcasType).casFeatCode_sectionLabels), i);
    jcasType.ll_cas.ll_setStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Document_Type)jcasType).casFeatCode_sectionLabels), i, v);}
  }

    