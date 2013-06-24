

/* First created by JCasGen Mon Jun 24 14:02:20 EDT 2013 */
package org.oaqa.model.gerp;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** A type represents the pruning decision for the candidate entities, which is provided by a pruner.
 * Updated by JCasGen Mon Jun 24 14:02:20 EDT 2013
 * XML source: C:/Users/yangz13/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class PruningDecision extends GerpBase {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(PruningDecision.class);
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
  protected PruningDecision() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public PruningDecision(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public PruningDecision(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: decision

  /** getter for decision - gets A binary pruning decision made by a pruner.
   * @generated */
  public boolean getDecision() {
    if (PruningDecision_Type.featOkTst && ((PruningDecision_Type)jcasType).casFeat_decision == null)
      jcasType.jcas.throwFeatMissing("decision", "org.oaqa.model.gerp.PruningDecision");
    return jcasType.ll_cas.ll_getBooleanValue(addr, ((PruningDecision_Type)jcasType).casFeatCode_decision);}
    
  /** setter for decision - sets A binary pruning decision made by a pruner. 
   * @generated */
  public void setDecision(boolean v) {
    if (PruningDecision_Type.featOkTst && ((PruningDecision_Type)jcasType).casFeat_decision == null)
      jcasType.jcas.throwFeatMissing("decision", "org.oaqa.model.gerp.PruningDecision");
    jcasType.ll_cas.ll_setBooleanValue(addr, ((PruningDecision_Type)jcasType).casFeatCode_decision, v);}    
  }

    