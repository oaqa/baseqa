

/* First created by JCasGen Mon Jul 08 17:12:14 EDT 2013 */
package org.oaqa.model.kb;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSList;


/** A named relation mention that identify or define the named relation concept.
 * Updated by JCasGen Mon Jul 29 18:17:35 EDT 2013
 * XML source: C:/Users/yangz13/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
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
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected RelationMention() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public RelationMention(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public RelationMention(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public RelationMention(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: argumentMentions

  /** getter for argumentMentions - gets A list of entity mentions being the arguments (e.g. sub, obj, etc.) of the relation mention.
   * @generated */
  public FSList getArgumentMentions() {
    if (RelationMention_Type.featOkTst && ((RelationMention_Type)jcasType).casFeat_argumentMentions == null)
      jcasType.jcas.throwFeatMissing("argumentMentions", "org.oaqa.model.kb.RelationMention");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((RelationMention_Type)jcasType).casFeatCode_argumentMentions)));}
    
  /** setter for argumentMentions - sets A list of entity mentions being the arguments (e.g. sub, obj, etc.) of the relation mention. 
   * @generated */
  public void setArgumentMentions(FSList v) {
    if (RelationMention_Type.featOkTst && ((RelationMention_Type)jcasType).casFeat_argumentMentions == null)
      jcasType.jcas.throwFeatMissing("argumentMentions", "org.oaqa.model.kb.RelationMention");
    jcasType.ll_cas.ll_setRefValue(addr, ((RelationMention_Type)jcasType).casFeatCode_argumentMentions, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    