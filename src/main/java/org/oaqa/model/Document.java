

/* First created by JCasGen Wed Aug 01 12:12:46 EDT 2012 */
package org.oaqa.model;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** A document search result.
 * Updated by JCasGen Wed Aug 01 12:12:46 EDT 2012
 * XML source: /Users/elmer/Documents/workspace/oaqa/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class Document extends SearchResult {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(Document.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Document() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Document(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Document(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {}
     
 
    
  //*--------------*
  //* Feature: title

  /** getter for title - gets The title of the document.
   * @generated */
  public String getTitle() {
    if (Document_Type.featOkTst && ((Document_Type)jcasType).casFeat_title == null)
      jcasType.jcas.throwFeatMissing("title", "org.oaqa.model.Document");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Document_Type)jcasType).casFeatCode_title);}
    
  /** setter for title - sets The title of the document. 
   * @generated */
  public void setTitle(String v) {
    if (Document_Type.featOkTst && ((Document_Type)jcasType).casFeat_title == null)
      jcasType.jcas.throwFeatMissing("title", "org.oaqa.model.Document");
    jcasType.ll_cas.ll_setStringValue(addr, ((Document_Type)jcasType).casFeatCode_title, v);}    
   
    
  //*--------------*
  //* Feature: docId

  /** getter for docId - gets A unique identifier for this document.
   * @generated */
  public String getDocId() {
    if (Document_Type.featOkTst && ((Document_Type)jcasType).casFeat_docId == null)
      jcasType.jcas.throwFeatMissing("docId", "org.oaqa.model.Document");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Document_Type)jcasType).casFeatCode_docId);}
    
  /** setter for docId - sets A unique identifier for this document. 
   * @generated */
  public void setDocId(String v) {
    if (Document_Type.featOkTst && ((Document_Type)jcasType).casFeat_docId == null)
      jcasType.jcas.throwFeatMissing("docId", "org.oaqa.model.Document");
    jcasType.ll_cas.ll_setStringValue(addr, ((Document_Type)jcasType).casFeatCode_docId, v);}    
  }

    