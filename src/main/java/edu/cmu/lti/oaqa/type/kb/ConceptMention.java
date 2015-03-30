

/* First created by JCasGen Sat Mar 28 16:16:33 EDT 2015 */
package edu.cmu.lti.oaqa.type.kb;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** A superclass for EntityMention and RelationMention.
 * Updated by JCasGen Sun Mar 29 18:53:35 EDT 2015
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/baseqa/type/OAQATypes.xml
 * @generated */
public class ConceptMention extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(ConceptMention.class);
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
  protected ConceptMention() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public ConceptMention(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public ConceptMention(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public ConceptMention(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
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
  //* Feature: concept

  /** getter for concept - gets The abstract concept that the text span conveys.
   * @generated
   * @return value of the feature 
   */
  public Concept getConcept() {
    if (ConceptMention_Type.featOkTst && ((ConceptMention_Type)jcasType).casFeat_concept == null)
      jcasType.jcas.throwFeatMissing("concept", "edu.cmu.lti.oaqa.type.kb.ConceptMention");
    return (Concept)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((ConceptMention_Type)jcasType).casFeatCode_concept)));}
    
  /** setter for concept - sets The abstract concept that the text span conveys. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setConcept(Concept v) {
    if (ConceptMention_Type.featOkTst && ((ConceptMention_Type)jcasType).casFeat_concept == null)
      jcasType.jcas.throwFeatMissing("concept", "edu.cmu.lti.oaqa.type.kb.ConceptMention");
    jcasType.ll_cas.ll_setRefValue(addr, ((ConceptMention_Type)jcasType).casFeatCode_concept, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: matchedName

  /** getter for matchedName - gets A synonym of the concept that best matches the
            concept mention (similar to conceptMatched in metamap).
   * @generated
   * @return value of the feature 
   */
  public String getMatchedName() {
    if (ConceptMention_Type.featOkTst && ((ConceptMention_Type)jcasType).casFeat_matchedName == null)
      jcasType.jcas.throwFeatMissing("matchedName", "edu.cmu.lti.oaqa.type.kb.ConceptMention");
    return jcasType.ll_cas.ll_getStringValue(addr, ((ConceptMention_Type)jcasType).casFeatCode_matchedName);}
    
  /** setter for matchedName - sets A synonym of the concept that best matches the
            concept mention (similar to conceptMatched in metamap). 
   * @generated
   * @param v value to set into the feature 
   */
  public void setMatchedName(String v) {
    if (ConceptMention_Type.featOkTst && ((ConceptMention_Type)jcasType).casFeat_matchedName == null)
      jcasType.jcas.throwFeatMissing("matchedName", "edu.cmu.lti.oaqa.type.kb.ConceptMention");
    jcasType.ll_cas.ll_setStringValue(addr, ((ConceptMention_Type)jcasType).casFeatCode_matchedName, v);}    
   
    
  //*--------------*
  //* Feature: score

  /** getter for score - gets The confidence score that the concept mention matches the concept.
   * @generated
   * @return value of the feature 
   */
  public double getScore() {
    if (ConceptMention_Type.featOkTst && ((ConceptMention_Type)jcasType).casFeat_score == null)
      jcasType.jcas.throwFeatMissing("score", "edu.cmu.lti.oaqa.type.kb.ConceptMention");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((ConceptMention_Type)jcasType).casFeatCode_score);}
    
  /** setter for score - sets The confidence score that the concept mention matches the concept. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setScore(double v) {
    if (ConceptMention_Type.featOkTst && ((ConceptMention_Type)jcasType).casFeat_score == null)
      jcasType.jcas.throwFeatMissing("score", "edu.cmu.lti.oaqa.type.kb.ConceptMention");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((ConceptMention_Type)jcasType).casFeatCode_score, v);}    
  }

    