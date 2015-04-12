

/* First created by JCasGen Sat Apr 11 19:49:33 EDT 2015 */
package edu.cmu.lti.oaqa.type.retrieval;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import edu.cmu.lti.oaqa.type.kb.Concept;


/** A search result from an ontology.
 * Updated by JCasGen Mon Apr 13 16:42:08 EDT 2015
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/baseqa/type/OAQATypes.xml
 * @generated */
public class ConceptSearchResult extends AnswerSearchResult {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(ConceptSearchResult.class);
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
  protected ConceptSearchResult() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public ConceptSearchResult(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public ConceptSearchResult(JCas jcas) {
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
  //* Feature: concept

  /** getter for concept - gets The relevant concept searched in the ontology.
   * @generated
   * @return value of the feature 
   */
  public Concept getConcept() {
    if (ConceptSearchResult_Type.featOkTst && ((ConceptSearchResult_Type)jcasType).casFeat_concept == null)
      jcasType.jcas.throwFeatMissing("concept", "edu.cmu.lti.oaqa.type.retrieval.ConceptSearchResult");
    return (Concept)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((ConceptSearchResult_Type)jcasType).casFeatCode_concept)));}
    
  /** setter for concept - sets The relevant concept searched in the ontology. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setConcept(Concept v) {
    if (ConceptSearchResult_Type.featOkTst && ((ConceptSearchResult_Type)jcasType).casFeat_concept == null)
      jcasType.jcas.throwFeatMissing("concept", "edu.cmu.lti.oaqa.type.retrieval.ConceptSearchResult");
    jcasType.ll_cas.ll_setRefValue(addr, ((ConceptSearchResult_Type)jcasType).casFeatCode_concept, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    