

/* First created by JCasGen Mon Jun 24 14:02:20 EDT 2013 */
package org.oaqa.model.gerp;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** A type represents the rank for the candidate entities, which is normally done by a ranker's synthesized analysis of collected evidences.
 * Updated by JCasGen Thu Jun 27 14:37:29 EDT 2013
 * XML source: C:/Users/yangz13/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class Rank extends GerpBase {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Rank.class);
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
  protected Rank() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Rank(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Rank(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: rank

  /** getter for rank - gets A non-negative integer represents the rank of candidate.
   * @generated */
  public int getRank() {
    if (Rank_Type.featOkTst && ((Rank_Type)jcasType).casFeat_rank == null)
      jcasType.jcas.throwFeatMissing("rank", "org.oaqa.model.gerp.Rank");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Rank_Type)jcasType).casFeatCode_rank);}
    
  /** setter for rank - sets A non-negative integer represents the rank of candidate. 
   * @generated */
  public void setRank(int v) {
    if (Rank_Type.featOkTst && ((Rank_Type)jcasType).casFeat_rank == null)
      jcasType.jcas.throwFeatMissing("rank", "org.oaqa.model.gerp.Rank");
    jcasType.ll_cas.ll_setIntValue(addr, ((Rank_Type)jcasType).casFeatCode_rank, v);}    
   
    
  //*--------------*
  //* Feature: score

  /** getter for score - gets A float value represents how likely the candidate is relevant. The value is not required to have a probabilistic interpretation, instead any similarity, distance, etc. can be used.
   * @generated */
  public float getScore() {
    if (Rank_Type.featOkTst && ((Rank_Type)jcasType).casFeat_score == null)
      jcasType.jcas.throwFeatMissing("score", "org.oaqa.model.gerp.Rank");
    return jcasType.ll_cas.ll_getFloatValue(addr, ((Rank_Type)jcasType).casFeatCode_score);}
    
  /** setter for score - sets A float value represents how likely the candidate is relevant. The value is not required to have a probabilistic interpretation, instead any similarity, distance, etc. can be used. 
   * @generated */
  public void setScore(float v) {
    if (Rank_Type.featOkTst && ((Rank_Type)jcasType).casFeat_score == null)
      jcasType.jcas.throwFeatMissing("score", "org.oaqa.model.gerp.Rank");
    jcasType.ll_cas.ll_setFloatValue(addr, ((Rank_Type)jcasType).casFeatCode_score, v);}    
  }

    