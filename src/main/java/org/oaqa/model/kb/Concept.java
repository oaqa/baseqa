

/* First created by JCasGen Mon Jul 08 17:12:14 EDT 2013 */
package org.oaqa.model.kb;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.oaqa.model.gerp.GerpTop;
import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.cas.StringList;


/** A superclass for EntityConcept and RelationConcept.
 * Updated by JCasGen Mon Jul 29 18:17:35 EDT 2013
 * XML source: C:/Users/yangz13/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class Concept extends GerpTop {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Concept.class);
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
  protected Concept() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Concept(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Concept(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: name

  /** getter for name - gets The name of the concept.
   * @generated */
  public String getName() {
    if (Concept_Type.featOkTst && ((Concept_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "org.oaqa.model.kb.Concept");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Concept_Type)jcasType).casFeatCode_name);}
    
  /** setter for name - sets The name of the concept. 
   * @generated */
  public void setName(String v) {
    if (Concept_Type.featOkTst && ((Concept_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "org.oaqa.model.kb.Concept");
    jcasType.ll_cas.ll_setStringValue(addr, ((Concept_Type)jcasType).casFeatCode_name, v);}    
   
    
  //*--------------*
  //* Feature: ids

  /** getter for ids - gets Array of ids that identify this named entity.  There may be more than one id if this named entity is ambiguous.  The ids are typically URIs.
   * @generated */
  public StringList getIds() {
    if (Concept_Type.featOkTst && ((Concept_Type)jcasType).casFeat_ids == null)
      jcasType.jcas.throwFeatMissing("ids", "org.oaqa.model.kb.Concept");
    return (StringList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Concept_Type)jcasType).casFeatCode_ids)));}
    
  /** setter for ids - sets Array of ids that identify this named entity.  There may be more than one id if this named entity is ambiguous.  The ids are typically URIs. 
   * @generated */
  public void setIds(StringList v) {
    if (Concept_Type.featOkTst && ((Concept_Type)jcasType).casFeat_ids == null)
      jcasType.jcas.throwFeatMissing("ids", "org.oaqa.model.kb.Concept");
    jcasType.ll_cas.ll_setRefValue(addr, ((Concept_Type)jcasType).casFeatCode_ids, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: mentions

  /** getter for mentions - gets A list of ConceptMentions (text spans) that might be surface forms to this concept.
   * @generated */
  public FSList getMentions() {
    if (Concept_Type.featOkTst && ((Concept_Type)jcasType).casFeat_mentions == null)
      jcasType.jcas.throwFeatMissing("mentions", "org.oaqa.model.kb.Concept");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Concept_Type)jcasType).casFeatCode_mentions)));}
    
  /** setter for mentions - sets A list of ConceptMentions (text spans) that might be surface forms to this concept. 
   * @generated */
  public void setMentions(FSList v) {
    if (Concept_Type.featOkTst && ((Concept_Type)jcasType).casFeat_mentions == null)
      jcasType.jcas.throwFeatMissing("mentions", "org.oaqa.model.kb.Concept");
    jcasType.ll_cas.ll_setRefValue(addr, ((Concept_Type)jcasType).casFeatCode_mentions, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    