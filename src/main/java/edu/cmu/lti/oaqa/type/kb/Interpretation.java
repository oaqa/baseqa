

/* First created by JCasGen Tue Aug 05 23:03:53 EDT 2014 */
package edu.cmu.lti.oaqa.type.kb;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.cas.TOP;


/** A container that integrates Concepts and ConceptMentions.
 * Updated by JCasGen Sat Aug 16 20:55:37 EDT 2014
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class Interpretation extends TOP {
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
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Interpretation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Interpretation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Interpretation(JCas jcas) {
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
  //* Feature: concepts

  /** getter for concepts - gets A list of all concepts mentioned in the corresponding text.
   * @generated
   * @return value of the feature 
   */
  public FSList getConcepts() {
    if (Interpretation_Type.featOkTst && ((Interpretation_Type)jcasType).casFeat_concepts == null)
      jcasType.jcas.throwFeatMissing("concepts", "edu.cmu.lti.oaqa.type.kb.Interpretation");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Interpretation_Type)jcasType).casFeatCode_concepts)));}
    
  /** setter for concepts - sets A list of all concepts mentioned in the corresponding text. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setConcepts(FSList v) {
    if (Interpretation_Type.featOkTst && ((Interpretation_Type)jcasType).casFeat_concepts == null)
      jcasType.jcas.throwFeatMissing("concepts", "edu.cmu.lti.oaqa.type.kb.Interpretation");
    jcasType.ll_cas.ll_setRefValue(addr, ((Interpretation_Type)jcasType).casFeatCode_concepts, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: mentions

  /** getter for mentions - gets A list of all mentions in the text.
   * @generated
   * @return value of the feature 
   */
  public FSList getMentions() {
    if (Interpretation_Type.featOkTst && ((Interpretation_Type)jcasType).casFeat_mentions == null)
      jcasType.jcas.throwFeatMissing("mentions", "edu.cmu.lti.oaqa.type.kb.Interpretation");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Interpretation_Type)jcasType).casFeatCode_mentions)));}
    
  /** setter for mentions - sets A list of all mentions in the text. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setMentions(FSList v) {
    if (Interpretation_Type.featOkTst && ((Interpretation_Type)jcasType).casFeat_mentions == null)
      jcasType.jcas.throwFeatMissing("mentions", "edu.cmu.lti.oaqa.type.kb.Interpretation");
    jcasType.ll_cas.ll_setRefValue(addr, ((Interpretation_Type)jcasType).casFeatCode_mentions, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    