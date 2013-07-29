

/* First created by JCasGen Mon Jul 08 17:12:14 EDT 2013 */
package org.oaqa.model.kb;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.oaqa.model.gerp.GerpAnnotation;


/** A superclass for EntityMention and RelationMention.
 * Updated by JCasGen Mon Jul 29 18:17:35 EDT 2013
 * XML source: C:/Users/yangz13/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class ConceptMention extends GerpAnnotation {
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
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected ConceptMention() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public ConceptMention(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public ConceptMention(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public ConceptMention(JCas jcas, int begin, int end) {
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
  //* Feature: concept

  /** getter for concept - gets The abstract concept that the text span conveys.
   * @generated */
  public Concept getConcept() {
    if (ConceptMention_Type.featOkTst && ((ConceptMention_Type)jcasType).casFeat_concept == null)
      jcasType.jcas.throwFeatMissing("concept", "org.oaqa.model.kb.ConceptMention");
    return (Concept)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((ConceptMention_Type)jcasType).casFeatCode_concept)));}
    
  /** setter for concept - sets The abstract concept that the text span conveys. 
   * @generated */
  public void setConcept(Concept v) {
    if (ConceptMention_Type.featOkTst && ((ConceptMention_Type)jcasType).casFeat_concept == null)
      jcasType.jcas.throwFeatMissing("concept", "org.oaqa.model.kb.ConceptMention");
    jcasType.ll_cas.ll_setRefValue(addr, ((ConceptMention_Type)jcasType).casFeatCode_concept, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    