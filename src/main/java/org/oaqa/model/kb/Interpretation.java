

/* First created by JCasGen Mon Jul 08 17:12:14 EDT 2013 */
package org.oaqa.model.kb;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.oaqa.model.gerp.GerpTop;
import org.apache.uima.jcas.cas.FSList;


/** A container that integrates Concepts and ConceptMentions.
 * Updated by JCasGen Mon Jul 29 18:17:35 EDT 2013
 * XML source: C:/Users/yangz13/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class Interpretation extends GerpTop {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Interpretation.class);
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
  protected Interpretation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Interpretation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Interpretation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: concepts

  /** getter for concepts - gets A list of all concepts mentioned in the corresponding text.
   * @generated */
  public FSList getConcepts() {
    if (Interpretation_Type.featOkTst && ((Interpretation_Type)jcasType).casFeat_concepts == null)
      jcasType.jcas.throwFeatMissing("concepts", "org.oaqa.model.kb.Interpretation");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Interpretation_Type)jcasType).casFeatCode_concepts)));}
    
  /** setter for concepts - sets A list of all concepts mentioned in the corresponding text. 
   * @generated */
  public void setConcepts(FSList v) {
    if (Interpretation_Type.featOkTst && ((Interpretation_Type)jcasType).casFeat_concepts == null)
      jcasType.jcas.throwFeatMissing("concepts", "org.oaqa.model.kb.Interpretation");
    jcasType.ll_cas.ll_setRefValue(addr, ((Interpretation_Type)jcasType).casFeatCode_concepts, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: mentions

  /** getter for mentions - gets A list of all mentions in the text.
   * @generated */
  public FSList getMentions() {
    if (Interpretation_Type.featOkTst && ((Interpretation_Type)jcasType).casFeat_mentions == null)
      jcasType.jcas.throwFeatMissing("mentions", "org.oaqa.model.kb.Interpretation");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Interpretation_Type)jcasType).casFeatCode_mentions)));}
    
  /** setter for mentions - sets A list of all mentions in the text. 
   * @generated */
  public void setMentions(FSList v) {
    if (Interpretation_Type.featOkTst && ((Interpretation_Type)jcasType).casFeat_mentions == null)
      jcasType.jcas.throwFeatMissing("mentions", "org.oaqa.model.kb.Interpretation");
    jcasType.ll_cas.ll_setRefValue(addr, ((Interpretation_Type)jcasType).casFeatCode_mentions, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    