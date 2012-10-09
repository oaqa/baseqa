

/* First created by JCasGen Mon Oct 08 18:56:44 EDT 2012 */
package org.oaqa.model;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** A feature of a candidate answer produced by a feature generator or answer scorer.
 * Updated by JCasGen Thu Oct 11 12:34:48 EDT 2012
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class CaFeature extends OAQATop {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(CaFeature.class);
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
  protected CaFeature() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public CaFeature(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public CaFeature(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: answer

  /** getter for answer - gets The candidate answer to which this feature applies.
   * @generated */
  public CandidateAnswerVariant getAnswer() {
    if (CaFeature_Type.featOkTst && ((CaFeature_Type)jcasType).casFeat_answer == null)
      jcasType.jcas.throwFeatMissing("answer", "org.oaqa.model.CaFeature");
    return (CandidateAnswerVariant)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((CaFeature_Type)jcasType).casFeatCode_answer)));}
    
  /** setter for answer - sets The candidate answer to which this feature applies. 
   * @generated */
  public void setAnswer(CandidateAnswerVariant v) {
    if (CaFeature_Type.featOkTst && ((CaFeature_Type)jcasType).casFeat_answer == null)
      jcasType.jcas.throwFeatMissing("answer", "org.oaqa.model.CaFeature");
    jcasType.ll_cas.ll_setRefValue(addr, ((CaFeature_Type)jcasType).casFeatCode_answer, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: label

  /** getter for label - gets Identify or distinguish this specific feature.
   * @generated */
  public String getLabel() {
    if (CaFeature_Type.featOkTst && ((CaFeature_Type)jcasType).casFeat_label == null)
      jcasType.jcas.throwFeatMissing("label", "org.oaqa.model.CaFeature");
    return jcasType.ll_cas.ll_getStringValue(addr, ((CaFeature_Type)jcasType).casFeatCode_label);}
    
  /** setter for label - sets Identify or distinguish this specific feature. 
   * @generated */
  public void setLabel(String v) {
    if (CaFeature_Type.featOkTst && ((CaFeature_Type)jcasType).casFeat_label == null)
      jcasType.jcas.throwFeatMissing("label", "org.oaqa.model.CaFeature");
    jcasType.ll_cas.ll_setStringValue(addr, ((CaFeature_Type)jcasType).casFeatCode_label, v);}    
   
    
  //*--------------*
  //* Feature: score

  /** getter for score - gets The score associated with this feature.
   * @generated */
  public double getScore() {
    if (CaFeature_Type.featOkTst && ((CaFeature_Type)jcasType).casFeat_score == null)
      jcasType.jcas.throwFeatMissing("score", "org.oaqa.model.CaFeature");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((CaFeature_Type)jcasType).casFeatCode_score);}
    
  /** setter for score - sets The score associated with this feature. 
   * @generated */
  public void setScore(double v) {
    if (CaFeature_Type.featOkTst && ((CaFeature_Type)jcasType).casFeat_score == null)
      jcasType.jcas.throwFeatMissing("score", "org.oaqa.model.CaFeature");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((CaFeature_Type)jcasType).casFeatCode_score, v);}    
  }

    