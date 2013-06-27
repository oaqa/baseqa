

/* First created by JCasGen Mon Jun 24 14:02:20 EDT 2013 */
package org.oaqa.model.retrieval;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;
import org.oaqa.model.core.Triple;


/** A search result from a triple store, e.g., an RDF store.
 * Updated by JCasGen Thu Jun 27 14:37:29 EDT 2013
 * XML source: C:/Users/yangz13/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class TripleStoreSearchResult extends AnswerSearchResult {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(TripleStoreSearchResult.class);
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
  protected TripleStoreSearchResult() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public TripleStoreSearchResult(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public TripleStoreSearchResult(JCas jcas) {
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
    if (TripleStoreSearchResult_Type.featOkTst && ((TripleStoreSearchResult_Type)jcasType).casFeat_context == null)
      jcasType.jcas.throwFeatMissing("context", "org.oaqa.model.retrieval.TripleStoreSearchResult");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((TripleStoreSearchResult_Type)jcasType).casFeatCode_context)));}
    
  /** setter for context - sets The context of the triple store search result, i.e., triples identifying all neighboring nodes in the store. 
   * @generated */
  public void setContext(FSArray v) {
    if (TripleStoreSearchResult_Type.featOkTst && ((TripleStoreSearchResult_Type)jcasType).casFeat_context == null)
      jcasType.jcas.throwFeatMissing("context", "org.oaqa.model.retrieval.TripleStoreSearchResult");
    jcasType.ll_cas.ll_setRefValue(addr, ((TripleStoreSearchResult_Type)jcasType).casFeatCode_context, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for context - gets an indexed value - The context of the triple store search result, i.e., triples identifying all neighboring nodes in the store.
   * @generated */
  public Triple getContext(int i) {
    if (TripleStoreSearchResult_Type.featOkTst && ((TripleStoreSearchResult_Type)jcasType).casFeat_context == null)
      jcasType.jcas.throwFeatMissing("context", "org.oaqa.model.retrieval.TripleStoreSearchResult");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((TripleStoreSearchResult_Type)jcasType).casFeatCode_context), i);
    return (Triple)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((TripleStoreSearchResult_Type)jcasType).casFeatCode_context), i)));}

  /** indexed setter for context - sets an indexed value - The context of the triple store search result, i.e., triples identifying all neighboring nodes in the store.
   * @generated */
  public void setContext(int i, Triple v) { 
    if (TripleStoreSearchResult_Type.featOkTst && ((TripleStoreSearchResult_Type)jcasType).casFeat_context == null)
      jcasType.jcas.throwFeatMissing("context", "org.oaqa.model.retrieval.TripleStoreSearchResult");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((TripleStoreSearchResult_Type)jcasType).casFeatCode_context), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((TripleStoreSearchResult_Type)jcasType).casFeatCode_context), i, jcasType.ll_cas.ll_getFSRef(v));}
  }

    