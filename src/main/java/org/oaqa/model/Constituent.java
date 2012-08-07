

/* First created by JCasGen Wed Aug 01 12:12:46 EDT 2012 */
package org.oaqa.model;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.tcas.Annotation;


/** This type contains information for both token and phrase.
 * Updated by JCasGen Wed Aug 01 12:12:46 EDT 2012
 * XML source: /Users/elmer/Documents/workspace/oaqa/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class Constituent extends Annotation {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(Constituent.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Constituent() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Constituent(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Constituent(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Constituent(JCas jcas, int begin, int end) {
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
  //* Feature: sequence

  /** getter for sequence - gets This is the position of constituent in the question.
   * @generated */
  public int getSequence() {
    if (Constituent_Type.featOkTst && ((Constituent_Type)jcasType).casFeat_sequence == null)
      jcasType.jcas.throwFeatMissing("sequence", "org.oaqa.model.Constituent");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Constituent_Type)jcasType).casFeatCode_sequence);}
    
  /** setter for sequence - sets This is the position of constituent in the question. 
   * @generated */
  public void setSequence(int v) {
    if (Constituent_Type.featOkTst && ((Constituent_Type)jcasType).casFeat_sequence == null)
      jcasType.jcas.throwFeatMissing("sequence", "org.oaqa.model.Constituent");
    jcasType.ll_cas.ll_setIntValue(addr, ((Constituent_Type)jcasType).casFeatCode_sequence, v);}    
   
    
  //*--------------*
  //* Feature: text

  /** getter for text - gets The original text of name entity
   * @generated */
  public String getText() {
    if (Constituent_Type.featOkTst && ((Constituent_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "org.oaqa.model.Constituent");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Constituent_Type)jcasType).casFeatCode_text);}
    
  /** setter for text - sets The original text of name entity 
   * @generated */
  public void setText(String v) {
    if (Constituent_Type.featOkTst && ((Constituent_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "org.oaqa.model.Constituent");
    jcasType.ll_cas.ll_setStringValue(addr, ((Constituent_Type)jcasType).casFeatCode_text, v);}    
   
    
  //*--------------*
  //* Feature: cType

  /** getter for cType - gets The type of this constituent.
   * @generated */
  public int getCType() {
    if (Constituent_Type.featOkTst && ((Constituent_Type)jcasType).casFeat_cType == null)
      jcasType.jcas.throwFeatMissing("cType", "org.oaqa.model.Constituent");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Constituent_Type)jcasType).casFeatCode_cType);}
    
  /** setter for cType - sets The type of this constituent. 
   * @generated */
  public void setCType(int v) {
    if (Constituent_Type.featOkTst && ((Constituent_Type)jcasType).casFeat_cType == null)
      jcasType.jcas.throwFeatMissing("cType", "org.oaqa.model.Constituent");
    jcasType.ll_cas.ll_setIntValue(addr, ((Constituent_Type)jcasType).casFeatCode_cType, v);}    
   
    
  //*--------------*
  //* Feature: resources

  /** getter for resources - gets External resource list.
   * @generated */
  public FSList getResources() {
    if (Constituent_Type.featOkTst && ((Constituent_Type)jcasType).casFeat_resources == null)
      jcasType.jcas.throwFeatMissing("resources", "org.oaqa.model.Constituent");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Constituent_Type)jcasType).casFeatCode_resources)));}
    
  /** setter for resources - sets External resource list. 
   * @generated */
  public void setResources(FSList v) {
    if (Constituent_Type.featOkTst && ((Constituent_Type)jcasType).casFeat_resources == null)
      jcasType.jcas.throwFeatMissing("resources", "org.oaqa.model.Constituent");
    jcasType.ll_cas.ll_setRefValue(addr, ((Constituent_Type)jcasType).casFeatCode_resources, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: tags

  /** getter for tags - gets Part-of-speech tag of the token
   * @generated */
  public FSList getTags() {
    if (Constituent_Type.featOkTst && ((Constituent_Type)jcasType).casFeat_tags == null)
      jcasType.jcas.throwFeatMissing("tags", "org.oaqa.model.Constituent");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Constituent_Type)jcasType).casFeatCode_tags)));}
    
  /** setter for tags - sets Part-of-speech tag of the token 
   * @generated */
  public void setTags(FSList v) {
    if (Constituent_Type.featOkTst && ((Constituent_Type)jcasType).casFeat_tags == null)
      jcasType.jcas.throwFeatMissing("tags", "org.oaqa.model.Constituent");
    jcasType.ll_cas.ll_setRefValue(addr, ((Constituent_Type)jcasType).casFeatCode_tags, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    