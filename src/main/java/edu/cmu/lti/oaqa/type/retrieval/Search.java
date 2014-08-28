

/* First created by JCasGen Tue Aug 05 23:03:53 EDT 2014 */
package edu.cmu.lti.oaqa.type.retrieval;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.cas.TOP;


/** An object that holds a query and results for a search (text search, fact search, KB search, etc.)
 * Updated by JCasGen Sat Aug 16 20:55:38 EDT 2014
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class Search extends TOP {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Search.class);
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
  protected Search() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Search(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Search(JCas jcas) {
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
  //* Feature: query

  /** getter for query - gets The query in the native syntax of the corresponding search engine.
   * @generated
   * @return value of the feature 
   */
  public String getQuery() {
    if (Search_Type.featOkTst && ((Search_Type)jcasType).casFeat_query == null)
      jcasType.jcas.throwFeatMissing("query", "edu.cmu.lti.oaqa.type.retrieval.Search");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Search_Type)jcasType).casFeatCode_query);}
    
  /** setter for query - sets The query in the native syntax of the corresponding search engine. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setQuery(String v) {
    if (Search_Type.featOkTst && ((Search_Type)jcasType).casFeat_query == null)
      jcasType.jcas.throwFeatMissing("query", "edu.cmu.lti.oaqa.type.retrieval.Search");
    jcasType.ll_cas.ll_setStringValue(addr, ((Search_Type)jcasType).casFeatCode_query, v);}    
   
    
  //*--------------*
  //* Feature: hitList

  /** getter for hitList - gets Hit list of search results, sorted in descreasing order of relevance score.
   * @generated
   * @return value of the feature 
   */
  public FSArray getHitList() {
    if (Search_Type.featOkTst && ((Search_Type)jcasType).casFeat_hitList == null)
      jcasType.jcas.throwFeatMissing("hitList", "edu.cmu.lti.oaqa.type.retrieval.Search");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Search_Type)jcasType).casFeatCode_hitList)));}
    
  /** setter for hitList - sets Hit list of search results, sorted in descreasing order of relevance score. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setHitList(FSArray v) {
    if (Search_Type.featOkTst && ((Search_Type)jcasType).casFeat_hitList == null)
      jcasType.jcas.throwFeatMissing("hitList", "edu.cmu.lti.oaqa.type.retrieval.Search");
    jcasType.ll_cas.ll_setRefValue(addr, ((Search_Type)jcasType).casFeatCode_hitList, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for hitList - gets an indexed value - Hit list of search results, sorted in descreasing order of relevance score.
   * @generated
   * @param i index in the array to get
   * @return value of the element at index i 
   */
  public SearchResult getHitList(int i) {
    if (Search_Type.featOkTst && ((Search_Type)jcasType).casFeat_hitList == null)
      jcasType.jcas.throwFeatMissing("hitList", "edu.cmu.lti.oaqa.type.retrieval.Search");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Search_Type)jcasType).casFeatCode_hitList), i);
    return (SearchResult)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Search_Type)jcasType).casFeatCode_hitList), i)));}

  /** indexed setter for hitList - sets an indexed value - Hit list of search results, sorted in descreasing order of relevance score.
   * @generated
   * @param i index in the array to set
   * @param v value to set into the array 
   */
  public void setHitList(int i, SearchResult v) { 
    if (Search_Type.featOkTst && ((Search_Type)jcasType).casFeat_hitList == null)
      jcasType.jcas.throwFeatMissing("hitList", "edu.cmu.lti.oaqa.type.retrieval.Search");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Search_Type)jcasType).casFeatCode_hitList), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Search_Type)jcasType).casFeatCode_hitList), i, jcasType.ll_cas.ll_getFSRef(v));}
   
    
  //*--------------*
  //* Feature: abstractQuery

  /** getter for abstractQuery - gets The abstract query from which this actual query was generated.
   * @generated
   * @return value of the feature 
   */
  public AbstractQuery getAbstractQuery() {
    if (Search_Type.featOkTst && ((Search_Type)jcasType).casFeat_abstractQuery == null)
      jcasType.jcas.throwFeatMissing("abstractQuery", "edu.cmu.lti.oaqa.type.retrieval.Search");
    return (AbstractQuery)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Search_Type)jcasType).casFeatCode_abstractQuery)));}
    
  /** setter for abstractQuery - sets The abstract query from which this actual query was generated. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setAbstractQuery(AbstractQuery v) {
    if (Search_Type.featOkTst && ((Search_Type)jcasType).casFeat_abstractQuery == null)
      jcasType.jcas.throwFeatMissing("abstractQuery", "edu.cmu.lti.oaqa.type.retrieval.Search");
    jcasType.ll_cas.ll_setRefValue(addr, ((Search_Type)jcasType).casFeatCode_abstractQuery, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: searchId

  /** getter for searchId - gets An identifier for this search result.  Used to collect hit-list objects that belong to this search result after they've been split out for parallel processing then gathered up again.
   * @generated
   * @return value of the feature 
   */
  public String getSearchId() {
    if (Search_Type.featOkTst && ((Search_Type)jcasType).casFeat_searchId == null)
      jcasType.jcas.throwFeatMissing("searchId", "edu.cmu.lti.oaqa.type.retrieval.Search");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Search_Type)jcasType).casFeatCode_searchId);}
    
  /** setter for searchId - sets An identifier for this search result.  Used to collect hit-list objects that belong to this search result after they've been split out for parallel processing then gathered up again. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setSearchId(String v) {
    if (Search_Type.featOkTst && ((Search_Type)jcasType).casFeat_searchId == null)
      jcasType.jcas.throwFeatMissing("searchId", "edu.cmu.lti.oaqa.type.retrieval.Search");
    jcasType.ll_cas.ll_setStringValue(addr, ((Search_Type)jcasType).casFeatCode_searchId, v);}    
  }

    