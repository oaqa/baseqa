

/* First created by JCasGen Mon Jul 08 17:12:14 EDT 2013 */
package org.oaqa.model.retrieval;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;
import org.oaqa.model.kb.Relation;


/** A search result from a triple store, e.g., an RDF store.
 * Updated by JCasGen Thu Jul 18 17:30:38 EDT 2013
 * XML source: C:/Users/yangz13/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
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
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected RelationSearchResult() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public RelationSearchResult(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public RelationSearchResult(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: context

  /** getter for context - gets The context of the triple store search result, i.e., triples identifying all neighboring nodes in the store.
   * @generated */
  public FSArray getContext() {
    if (RelationSearchResult_Type.featOkTst && ((RelationSearchResult_Type)jcasType).casFeat_context == null)
      jcasType.jcas.throwFeatMissing("context", "org.oaqa.model.retrieval.RelationSearchResult");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((RelationSearchResult_Type)jcasType).casFeatCode_context)));}
    
  /** setter for context - sets The context of the triple store search result, i.e., triples identifying all neighboring nodes in the store. 
   * @generated */
  public void setContext(FSArray v) {
    if (RelationSearchResult_Type.featOkTst && ((RelationSearchResult_Type)jcasType).casFeat_context == null)
      jcasType.jcas.throwFeatMissing("context", "org.oaqa.model.retrieval.RelationSearchResult");
    jcasType.ll_cas.ll_setRefValue(addr, ((RelationSearchResult_Type)jcasType).casFeatCode_context, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for context - gets an indexed value - The context of the triple store search result, i.e., triples identifying all neighboring nodes in the store.
   * @generated */
  public Relation getContext(int i) {
    if (RelationSearchResult_Type.featOkTst && ((RelationSearchResult_Type)jcasType).casFeat_context == null)
      jcasType.jcas.throwFeatMissing("context", "org.oaqa.model.retrieval.RelationSearchResult");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((RelationSearchResult_Type)jcasType).casFeatCode_context), i);
    return (Relation)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((RelationSearchResult_Type)jcasType).casFeatCode_context), i)));}

  /** indexed setter for context - sets an indexed value - The context of the triple store search result, i.e., triples identifying all neighboring nodes in the store.
   * @generated */
  public void setContext(int i, Relation v) { 
    if (RelationSearchResult_Type.featOkTst && ((RelationSearchResult_Type)jcasType).casFeat_context == null)
      jcasType.jcas.throwFeatMissing("context", "org.oaqa.model.retrieval.RelationSearchResult");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((RelationSearchResult_Type)jcasType).casFeatCode_context), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((RelationSearchResult_Type)jcasType).casFeatCode_context), i, jcasType.ll_cas.ll_getFSRef(v));}
  }

    