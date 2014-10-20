

/* First created by JCasGen Sun Oct 19 14:47:24 EDT 2014 */
package edu.cmu.lti.oaqa.type.kb;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.cas.TOP;
import org.apache.uima.jcas.cas.StringList;


/** A superclass for EntityConcept and RelationConcept.
 * Updated by JCasGen Sun Oct 19 14:47:24 EDT 2014
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/baseqa/type/OAQATypes.xml
 * @generated */
public class Concept extends TOP {
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
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Concept() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Concept(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Concept(JCas jcas) {
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
  //* Feature: name

  /** getter for name - gets The name of the concept.
   * @generated
   * @return value of the feature 
   */
  public String getName() {
    if (Concept_Type.featOkTst && ((Concept_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "edu.cmu.lti.oaqa.type.kb.Concept");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Concept_Type)jcasType).casFeatCode_name);}
    
  /** setter for name - sets The name of the concept. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setName(String v) {
    if (Concept_Type.featOkTst && ((Concept_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "edu.cmu.lti.oaqa.type.kb.Concept");
    jcasType.ll_cas.ll_setStringValue(addr, ((Concept_Type)jcasType).casFeatCode_name, v);}    
   
    
  //*--------------*
  //* Feature: uris

  /** getter for uris - gets Array of uris that identify this named entity.  There may be more than one uri if this named entity is ambiguous.
   * @generated
   * @return value of the feature 
   */
  public StringList getUris() {
    if (Concept_Type.featOkTst && ((Concept_Type)jcasType).casFeat_uris == null)
      jcasType.jcas.throwFeatMissing("uris", "edu.cmu.lti.oaqa.type.kb.Concept");
    return (StringList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Concept_Type)jcasType).casFeatCode_uris)));}
    
  /** setter for uris - sets Array of uris that identify this named entity.  There may be more than one uri if this named entity is ambiguous. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setUris(StringList v) {
    if (Concept_Type.featOkTst && ((Concept_Type)jcasType).casFeat_uris == null)
      jcasType.jcas.throwFeatMissing("uris", "edu.cmu.lti.oaqa.type.kb.Concept");
    jcasType.ll_cas.ll_setRefValue(addr, ((Concept_Type)jcasType).casFeatCode_uris, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: mentions

  /** getter for mentions - gets A list of ConceptMentions (text spans) that might be surface forms to this concept.
   * @generated
   * @return value of the feature 
   */
  public FSList getMentions() {
    if (Concept_Type.featOkTst && ((Concept_Type)jcasType).casFeat_mentions == null)
      jcasType.jcas.throwFeatMissing("mentions", "edu.cmu.lti.oaqa.type.kb.Concept");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Concept_Type)jcasType).casFeatCode_mentions)));}
    
  /** setter for mentions - sets A list of ConceptMentions (text spans) that might be surface forms to this concept. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setMentions(FSList v) {
    if (Concept_Type.featOkTst && ((Concept_Type)jcasType).casFeat_mentions == null)
      jcasType.jcas.throwFeatMissing("mentions", "edu.cmu.lti.oaqa.type.kb.Concept");
    jcasType.ll_cas.ll_setRefValue(addr, ((Concept_Type)jcasType).casFeatCode_mentions, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    