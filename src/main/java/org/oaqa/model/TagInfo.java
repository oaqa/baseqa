

/* First created by JCasGen Wed Aug 01 12:12:46 EDT 2012 */
package org.oaqa.model;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** Tag that associates with a token from a particular NLP tool
 * Updated by JCasGen Wed Aug 01 12:12:46 EDT 2012
 * XML source: /Users/elmer/Documents/workspace/oaqa/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class TagInfo extends Annotation {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(TagInfo.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected TagInfo() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public TagInfo(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public TagInfo(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public TagInfo(JCas jcas, int begin, int end) {
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
  //* Feature: tag

  /** getter for tag - gets Tag generated from the NLP tagging tool
   * @generated */
  public String getTag() {
    if (TagInfo_Type.featOkTst && ((TagInfo_Type)jcasType).casFeat_tag == null)
      jcasType.jcas.throwFeatMissing("tag", "org.oaqa.model.TagInfo");
    return jcasType.ll_cas.ll_getStringValue(addr, ((TagInfo_Type)jcasType).casFeatCode_tag);}
    
  /** setter for tag - sets Tag generated from the NLP tagging tool 
   * @generated */
  public void setTag(String v) {
    if (TagInfo_Type.featOkTst && ((TagInfo_Type)jcasType).casFeat_tag == null)
      jcasType.jcas.throwFeatMissing("tag", "org.oaqa.model.TagInfo");
    jcasType.ll_cas.ll_setStringValue(addr, ((TagInfo_Type)jcasType).casFeatCode_tag, v);}    
   
    
  //*--------------*
  //* Feature: source

  /** getter for source - gets Source id of the NLP tool
   * @generated */
  public String getSource() {
    if (TagInfo_Type.featOkTst && ((TagInfo_Type)jcasType).casFeat_source == null)
      jcasType.jcas.throwFeatMissing("source", "org.oaqa.model.TagInfo");
    return jcasType.ll_cas.ll_getStringValue(addr, ((TagInfo_Type)jcasType).casFeatCode_source);}
    
  /** setter for source - sets Source id of the NLP tool 
   * @generated */
  public void setSource(String v) {
    if (TagInfo_Type.featOkTst && ((TagInfo_Type)jcasType).casFeat_source == null)
      jcasType.jcas.throwFeatMissing("source", "org.oaqa.model.TagInfo");
    jcasType.ll_cas.ll_setStringValue(addr, ((TagInfo_Type)jcasType).casFeatCode_source, v);}    
  }

    