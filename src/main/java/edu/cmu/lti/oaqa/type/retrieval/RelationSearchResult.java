

/* First created by JCasGen Tue Aug 05 23:03:53 EDT 2014 */
package edu.cmu.lti.oaqa.type.retrieval;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;
import edu.cmu.lti.oaqa.type.kb.Relation;


/** A search result from a triple store, e.g., an RDF store.
 * Updated by JCasGen Tue Sep 30 18:21:25 EDT 2014
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/baseqa/type/OAQATypes.xml
 * @generated */
public class RelationSearchResult extends AnswerSearchResult {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(RelationSearchResult.class);
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
  protected RelationSearchResult() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public RelationSearchResult(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public RelationSearchResult(JCas jcas) {
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
  //* Feature: context

  /** getter for context - gets The context of the triple store search result, i.e., triples identifying all neighboring nodes in the store.
   * @generated
   * @return value of the feature 
   */
  public FSArray getContext() {
    if (RelationSearchResult_Type.featOkTst && ((RelationSearchResult_Type)jcasType).casFeat_context == null)
      jcasType.jcas.throwFeatMissing("context", "edu.cmu.lti.oaqa.type.retrieval.RelationSearchResult");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((RelationSearchResult_Type)jcasType).casFeatCode_context)));}
    
  /** setter for context - sets The context of the triple store search result, i.e., triples identifying all neighboring nodes in the store. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setContext(FSArray v) {
    if (RelationSearchResult_Type.featOkTst && ((RelationSearchResult_Type)jcasType).casFeat_context == null)
      jcasType.jcas.throwFeatMissing("context", "edu.cmu.lti.oaqa.type.retrieval.RelationSearchResult");
    jcasType.ll_cas.ll_setRefValue(addr, ((RelationSearchResult_Type)jcasType).casFeatCode_context, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for context - gets an indexed value - The context of the triple store search result, i.e., triples identifying all neighboring nodes in the store.
   * @generated
   * @param i index in the array to get
   * @return value of the element at index i 
   */
  public Relation getContext(int i) {
    if (RelationSearchResult_Type.featOkTst && ((RelationSearchResult_Type)jcasType).casFeat_context == null)
      jcasType.jcas.throwFeatMissing("context", "edu.cmu.lti.oaqa.type.retrieval.RelationSearchResult");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((RelationSearchResult_Type)jcasType).casFeatCode_context), i);
    return (Relation)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((RelationSearchResult_Type)jcasType).casFeatCode_context), i)));}

  /** indexed setter for context - sets an indexed value - The context of the triple store search result, i.e., triples identifying all neighboring nodes in the store.
   * @generated
   * @param i index in the array to set
   * @param v value to set into the array 
   */
  public void setContext(int i, Relation v) { 
    if (RelationSearchResult_Type.featOkTst && ((RelationSearchResult_Type)jcasType).casFeat_context == null)
      jcasType.jcas.throwFeatMissing("context", "edu.cmu.lti.oaqa.type.retrieval.RelationSearchResult");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((RelationSearchResult_Type)jcasType).casFeatCode_context), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((RelationSearchResult_Type)jcasType).casFeatCode_context), i, jcasType.ll_cas.ll_getFSRef(v));}
  }

    