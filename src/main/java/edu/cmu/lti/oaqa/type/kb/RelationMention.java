

/* First created by JCasGen Tue Aug 05 23:03:53 EDT 2014 */
package edu.cmu.lti.oaqa.type.kb;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSList;


/** A named relation mention that identify or define the named relation concept.
 * Updated by JCasGen Sat Aug 16 20:55:37 EDT 2014
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class RelationMention extends ConceptMention {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(RelationMention.class);
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
  protected RelationMention() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public RelationMention(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public RelationMention(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public RelationMention(JCas jcas, int begin, int end) {
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
  //* Feature: argumentMentions

  /** getter for argumentMentions - gets A list of entity mentions being the arguments (e.g. sub, obj, etc.) of the relation mention.
   * @generated
   * @return value of the feature 
   */
  public FSList getArgumentMentions() {
    if (RelationMention_Type.featOkTst && ((RelationMention_Type)jcasType).casFeat_argumentMentions == null)
      jcasType.jcas.throwFeatMissing("argumentMentions", "edu.cmu.lti.oaqa.type.kb.RelationMention");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((RelationMention_Type)jcasType).casFeatCode_argumentMentions)));}
    
  /** setter for argumentMentions - sets A list of entity mentions being the arguments (e.g. sub, obj, etc.) of the relation mention. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setArgumentMentions(FSList v) {
    if (RelationMention_Type.featOkTst && ((RelationMention_Type)jcasType).casFeat_argumentMentions == null)
      jcasType.jcas.throwFeatMissing("argumentMentions", "edu.cmu.lti.oaqa.type.kb.RelationMention");
    jcasType.ll_cas.ll_setRefValue(addr, ((RelationMention_Type)jcasType).casFeatCode_argumentMentions, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    