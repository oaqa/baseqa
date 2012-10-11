

/* First created by JCasGen Mon Oct 08 18:56:44 EDT 2012 */
package org.oaqa.model;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.cas.StringArray;


/** A named entity with one or more URIs that identify or define the named entity.  The URIs could reference any source that defines or disambiguates the named entity.
<<<<<<< HEAD
 * Updated by JCasGen Thu Oct 11 12:34:48 EDT 2012
=======
 * Updated by JCasGen Tue Oct 09 21:34:48 EDT 2012
>>>>>>> b546a96e32521e5cc420b3a114ad3fb1279252a1
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class NamedEntity extends OAQAAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(NamedEntity.class);
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
  protected NamedEntity() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public NamedEntity(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public NamedEntity(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public NamedEntity(JCas jcas, int begin, int end) {
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
  //* Feature: ids

  /** getter for ids - gets Array of ids that identify this named entity.  There may be more than one id if this named entity is ambiguous.  The ids are typically URIs.
   * @generated */
  public StringArray getIds() {
    if (NamedEntity_Type.featOkTst && ((NamedEntity_Type)jcasType).casFeat_ids == null)
      jcasType.jcas.throwFeatMissing("ids", "org.oaqa.model.NamedEntity");
    return (StringArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((NamedEntity_Type)jcasType).casFeatCode_ids)));}
    
  /** setter for ids - sets Array of ids that identify this named entity.  There may be more than one id if this named entity is ambiguous.  The ids are typically URIs. 
   * @generated */
  public void setIds(StringArray v) {
    if (NamedEntity_Type.featOkTst && ((NamedEntity_Type)jcasType).casFeat_ids == null)
      jcasType.jcas.throwFeatMissing("ids", "org.oaqa.model.NamedEntity");
    jcasType.ll_cas.ll_setRefValue(addr, ((NamedEntity_Type)jcasType).casFeatCode_ids, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for ids - gets an indexed value - Array of ids that identify this named entity.  There may be more than one id if this named entity is ambiguous.  The ids are typically URIs.
   * @generated */
  public String getIds(int i) {
    if (NamedEntity_Type.featOkTst && ((NamedEntity_Type)jcasType).casFeat_ids == null)
      jcasType.jcas.throwFeatMissing("ids", "org.oaqa.model.NamedEntity");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((NamedEntity_Type)jcasType).casFeatCode_ids), i);
    return jcasType.ll_cas.ll_getStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((NamedEntity_Type)jcasType).casFeatCode_ids), i);}

  /** indexed setter for ids - sets an indexed value - Array of ids that identify this named entity.  There may be more than one id if this named entity is ambiguous.  The ids are typically URIs.
   * @generated */
  public void setIds(int i, String v) { 
    if (NamedEntity_Type.featOkTst && ((NamedEntity_Type)jcasType).casFeat_ids == null)
      jcasType.jcas.throwFeatMissing("ids", "org.oaqa.model.NamedEntity");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((NamedEntity_Type)jcasType).casFeatCode_ids), i);
    jcasType.ll_cas.ll_setStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((NamedEntity_Type)jcasType).casFeatCode_ids), i, v);}
   
    
  //*--------------*
  //* Feature: context

  /** getter for context - gets The context of this named entity, i.e., triples identifying all neighboring nodes in the store.
   * @generated */
  public FSArray getContext() {
    if (NamedEntity_Type.featOkTst && ((NamedEntity_Type)jcasType).casFeat_context == null)
      jcasType.jcas.throwFeatMissing("context", "org.oaqa.model.NamedEntity");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((NamedEntity_Type)jcasType).casFeatCode_context)));}
    
  /** setter for context - sets The context of this named entity, i.e., triples identifying all neighboring nodes in the store. 
   * @generated */
  public void setContext(FSArray v) {
    if (NamedEntity_Type.featOkTst && ((NamedEntity_Type)jcasType).casFeat_context == null)
      jcasType.jcas.throwFeatMissing("context", "org.oaqa.model.NamedEntity");
    jcasType.ll_cas.ll_setRefValue(addr, ((NamedEntity_Type)jcasType).casFeatCode_context, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for context - gets an indexed value - The context of this named entity, i.e., triples identifying all neighboring nodes in the store.
   * @generated */
  public Triple getContext(int i) {
    if (NamedEntity_Type.featOkTst && ((NamedEntity_Type)jcasType).casFeat_context == null)
      jcasType.jcas.throwFeatMissing("context", "org.oaqa.model.NamedEntity");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((NamedEntity_Type)jcasType).casFeatCode_context), i);
    return (Triple)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((NamedEntity_Type)jcasType).casFeatCode_context), i)));}

  /** indexed setter for context - sets an indexed value - The context of this named entity, i.e., triples identifying all neighboring nodes in the store.
   * @generated */
  public void setContext(int i, Triple v) { 
    if (NamedEntity_Type.featOkTst && ((NamedEntity_Type)jcasType).casFeat_context == null)
      jcasType.jcas.throwFeatMissing("context", "org.oaqa.model.NamedEntity");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((NamedEntity_Type)jcasType).casFeatCode_context), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((NamedEntity_Type)jcasType).casFeatCode_context), i, jcasType.ll_cas.ll_getFSRef(v));}
  }

    