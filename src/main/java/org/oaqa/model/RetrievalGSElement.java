

/* First created by JCasGen Sat Mar 02 19:54:39 EST 2013 */
package org.oaqa.model;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Sat Mar 02 19:54:39 EST 2013
 * XML source: /home/leo/stuff/OAQA.rankqa/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class RetrievalGSElement extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(RetrievalGSElement.class);
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
  protected RetrievalGSElement() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public RetrievalGSElement(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public RetrievalGSElement(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public RetrievalGSElement(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: sequenceId

  /** getter for sequenceId - gets 
   * @generated */
  public int getSequenceId() {
    if (RetrievalGSElement_Type.featOkTst && ((RetrievalGSElement_Type)jcasType).casFeat_sequenceId == null)
      jcasType.jcas.throwFeatMissing("sequenceId", "org.oaqa.model.RetrievalGSElement");
    return jcasType.ll_cas.ll_getIntValue(addr, ((RetrievalGSElement_Type)jcasType).casFeatCode_sequenceId);}
    
  /** setter for sequenceId - sets  
   * @generated */
  public void setSequenceId(int v) {
    if (RetrievalGSElement_Type.featOkTst && ((RetrievalGSElement_Type)jcasType).casFeat_sequenceId == null)
      jcasType.jcas.throwFeatMissing("sequenceId", "org.oaqa.model.RetrievalGSElement");
    jcasType.ll_cas.ll_setIntValue(addr, ((RetrievalGSElement_Type)jcasType).casFeatCode_sequenceId, v);}    
   
    
  //*--------------*
  //* Feature: docId

  /** getter for docId - gets 
   * @generated */
  public String getDocId() {
    if (RetrievalGSElement_Type.featOkTst && ((RetrievalGSElement_Type)jcasType).casFeat_docId == null)
      jcasType.jcas.throwFeatMissing("docId", "org.oaqa.model.RetrievalGSElement");
    return jcasType.ll_cas.ll_getStringValue(addr, ((RetrievalGSElement_Type)jcasType).casFeatCode_docId);}
    
  /** setter for docId - sets  
   * @generated */
  public void setDocId(String v) {
    if (RetrievalGSElement_Type.featOkTst && ((RetrievalGSElement_Type)jcasType).casFeat_docId == null)
      jcasType.jcas.throwFeatMissing("docId", "org.oaqa.model.RetrievalGSElement");
    jcasType.ll_cas.ll_setStringValue(addr, ((RetrievalGSElement_Type)jcasType).casFeatCode_docId, v);}    
   
    
  //*--------------*
  //* Feature: offset

  /** getter for offset - gets 
   * @generated */
  public int getOffset() {
    if (RetrievalGSElement_Type.featOkTst && ((RetrievalGSElement_Type)jcasType).casFeat_offset == null)
      jcasType.jcas.throwFeatMissing("offset", "org.oaqa.model.RetrievalGSElement");
    return jcasType.ll_cas.ll_getIntValue(addr, ((RetrievalGSElement_Type)jcasType).casFeatCode_offset);}
    
  /** setter for offset - sets  
   * @generated */
  public void setOffset(int v) {
    if (RetrievalGSElement_Type.featOkTst && ((RetrievalGSElement_Type)jcasType).casFeat_offset == null)
      jcasType.jcas.throwFeatMissing("offset", "org.oaqa.model.RetrievalGSElement");
    jcasType.ll_cas.ll_setIntValue(addr, ((RetrievalGSElement_Type)jcasType).casFeatCode_offset, v);}    
   
    
  //*--------------*
  //* Feature: length

  /** getter for length - gets 
   * @generated */
  public int getLength() {
    if (RetrievalGSElement_Type.featOkTst && ((RetrievalGSElement_Type)jcasType).casFeat_length == null)
      jcasType.jcas.throwFeatMissing("length", "org.oaqa.model.RetrievalGSElement");
    return jcasType.ll_cas.ll_getIntValue(addr, ((RetrievalGSElement_Type)jcasType).casFeatCode_length);}
    
  /** setter for length - sets  
   * @generated */
  public void setLength(int v) {
    if (RetrievalGSElement_Type.featOkTst && ((RetrievalGSElement_Type)jcasType).casFeat_length == null)
      jcasType.jcas.throwFeatMissing("length", "org.oaqa.model.RetrievalGSElement");
    jcasType.ll_cas.ll_setIntValue(addr, ((RetrievalGSElement_Type)jcasType).casFeatCode_length, v);}    
   
    
  //*--------------*
  //* Feature: aspects

  /** getter for aspects - gets 
   * @generated */
  public String getAspects() {
    if (RetrievalGSElement_Type.featOkTst && ((RetrievalGSElement_Type)jcasType).casFeat_aspects == null)
      jcasType.jcas.throwFeatMissing("aspects", "org.oaqa.model.RetrievalGSElement");
    return jcasType.ll_cas.ll_getStringValue(addr, ((RetrievalGSElement_Type)jcasType).casFeatCode_aspects);}
    
  /** setter for aspects - sets  
   * @generated */
  public void setAspects(String v) {
    if (RetrievalGSElement_Type.featOkTst && ((RetrievalGSElement_Type)jcasType).casFeat_aspects == null)
      jcasType.jcas.throwFeatMissing("aspects", "org.oaqa.model.RetrievalGSElement");
    jcasType.ll_cas.ll_setStringValue(addr, ((RetrievalGSElement_Type)jcasType).casFeatCode_aspects, v);}    
   
    
  //*--------------*
  //* Feature: dataset

  /** getter for dataset - gets 
   * @generated */
  public String getDataset() {
    if (RetrievalGSElement_Type.featOkTst && ((RetrievalGSElement_Type)jcasType).casFeat_dataset == null)
      jcasType.jcas.throwFeatMissing("dataset", "org.oaqa.model.RetrievalGSElement");
    return jcasType.ll_cas.ll_getStringValue(addr, ((RetrievalGSElement_Type)jcasType).casFeatCode_dataset);}
    
  /** setter for dataset - sets  
   * @generated */
  public void setDataset(String v) {
    if (RetrievalGSElement_Type.featOkTst && ((RetrievalGSElement_Type)jcasType).casFeat_dataset == null)
      jcasType.jcas.throwFeatMissing("dataset", "org.oaqa.model.RetrievalGSElement");
    jcasType.ll_cas.ll_setStringValue(addr, ((RetrievalGSElement_Type)jcasType).casFeatCode_dataset, v);}    
  }

    