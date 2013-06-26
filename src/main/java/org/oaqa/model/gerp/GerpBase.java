

/* First created by JCasGen Mon Jun 24 14:02:20 EDT 2013 */
package org.oaqa.model.gerp;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.oaqa.model.core.OAQATop;
import org.apache.uima.jcas.cas.FSList;


/** A base class for GERP intermediate data: Evidence, Rank, PruningDecision.
 * Updated by JCasGen Wed Jun 26 17:33:02 EDT 2013
 * XML source: C:/Users/yangz13/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class GerpBase extends OAQATop {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(GerpBase.class);
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
  protected GerpBase() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public GerpBase(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public GerpBase(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: comments

  /** getter for comments - gets A placeholder for any additional comments that evidencers, rankers or pruners may provide.
   * @generated */
  public FSList getComments() {
    if (GerpBase_Type.featOkTst && ((GerpBase_Type)jcasType).casFeat_comments == null)
      jcasType.jcas.throwFeatMissing("comments", "org.oaqa.model.gerp.GerpBase");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((GerpBase_Type)jcasType).casFeatCode_comments)));}
    
  /** setter for comments - sets A placeholder for any additional comments that evidencers, rankers or pruners may provide. 
   * @generated */
  public void setComments(FSList v) {
    if (GerpBase_Type.featOkTst && ((GerpBase_Type)jcasType).casFeat_comments == null)
      jcasType.jcas.throwFeatMissing("comments", "org.oaqa.model.gerp.GerpBase");
    jcasType.ll_cas.ll_setRefValue(addr, ((GerpBase_Type)jcasType).casFeatCode_comments, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    