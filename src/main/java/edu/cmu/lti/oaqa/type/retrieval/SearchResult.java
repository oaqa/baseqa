

/* First created by JCasGen Sun Oct 19 14:47:24 EDT 2014 */
package edu.cmu.lti.oaqa.type.retrieval;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import edu.cmu.lti.oaqa.type.answer.CandidateAnswerVariant;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.cas.TOP;


/** A search result.
 * Updated by JCasGen Tue Mar 17 14:36:56 EDT 2015
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/baseqa/type/OAQATypes.xml
 * @generated */
public class SearchResult extends TOP {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(SearchResult.class);
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
  protected SearchResult() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public SearchResult(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public SearchResult(JCas jcas) {
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
  //* Feature: uri

  /** getter for uri - gets An identifier for the source of this search result, e.g., the name of the file that this result is drawn from, which, when combined with offset and length, uniquely identifies the span of text for this result.
   * @generated
   * @return value of the feature 
   */
  public String getUri() {
    if (SearchResult_Type.featOkTst && ((SearchResult_Type)jcasType).casFeat_uri == null)
      jcasType.jcas.throwFeatMissing("uri", "edu.cmu.lti.oaqa.type.retrieval.SearchResult");
    return jcasType.ll_cas.ll_getStringValue(addr, ((SearchResult_Type)jcasType).casFeatCode_uri);}
    
  /** setter for uri - sets An identifier for the source of this search result, e.g., the name of the file that this result is drawn from, which, when combined with offset and length, uniquely identifies the span of text for this result. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setUri(String v) {
    if (SearchResult_Type.featOkTst && ((SearchResult_Type)jcasType).casFeat_uri == null)
      jcasType.jcas.throwFeatMissing("uri", "edu.cmu.lti.oaqa.type.retrieval.SearchResult");
    jcasType.ll_cas.ll_setStringValue(addr, ((SearchResult_Type)jcasType).casFeatCode_uri, v);}    
   
    
  //*--------------*
  //* Feature: score

  /** getter for score - gets Relevance score associated with the search result.
   * @generated
   * @return value of the feature 
   */
  public double getScore() {
    if (SearchResult_Type.featOkTst && ((SearchResult_Type)jcasType).casFeat_score == null)
      jcasType.jcas.throwFeatMissing("score", "edu.cmu.lti.oaqa.type.retrieval.SearchResult");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((SearchResult_Type)jcasType).casFeatCode_score);}
    
  /** setter for score - sets Relevance score associated with the search result. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setScore(double v) {
    if (SearchResult_Type.featOkTst && ((SearchResult_Type)jcasType).casFeat_score == null)
      jcasType.jcas.throwFeatMissing("score", "edu.cmu.lti.oaqa.type.retrieval.SearchResult");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((SearchResult_Type)jcasType).casFeatCode_score, v);}    
   
    
  //*--------------*
  //* Feature: text

  /** getter for text - gets The text associated with the hit.
   * @generated
   * @return value of the feature 
   */
  public String getText() {
    if (SearchResult_Type.featOkTst && ((SearchResult_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "edu.cmu.lti.oaqa.type.retrieval.SearchResult");
    return jcasType.ll_cas.ll_getStringValue(addr, ((SearchResult_Type)jcasType).casFeatCode_text);}
    
  /** setter for text - sets The text associated with the hit. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setText(String v) {
    if (SearchResult_Type.featOkTst && ((SearchResult_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "edu.cmu.lti.oaqa.type.retrieval.SearchResult");
    jcasType.ll_cas.ll_setStringValue(addr, ((SearchResult_Type)jcasType).casFeatCode_text, v);}    
   
    
  //*--------------*
  //* Feature: rank

  /** getter for rank - gets Rank of this result in the original hit-list.
   * @generated
   * @return value of the feature 
   */
  public int getRank() {
    if (SearchResult_Type.featOkTst && ((SearchResult_Type)jcasType).casFeat_rank == null)
      jcasType.jcas.throwFeatMissing("rank", "edu.cmu.lti.oaqa.type.retrieval.SearchResult");
    return jcasType.ll_cas.ll_getIntValue(addr, ((SearchResult_Type)jcasType).casFeatCode_rank);}
    
  /** setter for rank - sets Rank of this result in the original hit-list. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setRank(int v) {
    if (SearchResult_Type.featOkTst && ((SearchResult_Type)jcasType).casFeat_rank == null)
      jcasType.jcas.throwFeatMissing("rank", "edu.cmu.lti.oaqa.type.retrieval.SearchResult");
    jcasType.ll_cas.ll_setIntValue(addr, ((SearchResult_Type)jcasType).casFeatCode_rank, v);}    
   
    
  //*--------------*
  //* Feature: queryString

  /** getter for queryString - gets The query string associated with the hit.
   * @generated
   * @return value of the feature 
   */
  public String getQueryString() {
    if (SearchResult_Type.featOkTst && ((SearchResult_Type)jcasType).casFeat_queryString == null)
      jcasType.jcas.throwFeatMissing("queryString", "edu.cmu.lti.oaqa.type.retrieval.SearchResult");
    return jcasType.ll_cas.ll_getStringValue(addr, ((SearchResult_Type)jcasType).casFeatCode_queryString);}
    
  /** setter for queryString - sets The query string associated with the hit. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setQueryString(String v) {
    if (SearchResult_Type.featOkTst && ((SearchResult_Type)jcasType).casFeat_queryString == null)
      jcasType.jcas.throwFeatMissing("queryString", "edu.cmu.lti.oaqa.type.retrieval.SearchResult");
    jcasType.ll_cas.ll_setStringValue(addr, ((SearchResult_Type)jcasType).casFeatCode_queryString, v);}    
   
    
  //*--------------*
  //* Feature: searchId

  /** getter for searchId - gets ID of the search object to which this search result belongs (matches the searchId field in the Search object).
   * @generated
   * @return value of the feature 
   */
  public String getSearchId() {
    if (SearchResult_Type.featOkTst && ((SearchResult_Type)jcasType).casFeat_searchId == null)
      jcasType.jcas.throwFeatMissing("searchId", "edu.cmu.lti.oaqa.type.retrieval.SearchResult");
    return jcasType.ll_cas.ll_getStringValue(addr, ((SearchResult_Type)jcasType).casFeatCode_searchId);}
    
  /** setter for searchId - sets ID of the search object to which this search result belongs (matches the searchId field in the Search object). 
   * @generated
   * @param v value to set into the feature 
   */
  public void setSearchId(String v) {
    if (SearchResult_Type.featOkTst && ((SearchResult_Type)jcasType).casFeat_searchId == null)
      jcasType.jcas.throwFeatMissing("searchId", "edu.cmu.lti.oaqa.type.retrieval.SearchResult");
    jcasType.ll_cas.ll_setStringValue(addr, ((SearchResult_Type)jcasType).casFeatCode_searchId, v);}    
   
    
  //*--------------*
  //* Feature: candidateAnswers

  /** getter for candidateAnswers - gets CandidateAnswerVariants generated from this SearchResult.
   * @generated
   * @return value of the feature 
   */
  public FSArray getCandidateAnswers() {
    if (SearchResult_Type.featOkTst && ((SearchResult_Type)jcasType).casFeat_candidateAnswers == null)
      jcasType.jcas.throwFeatMissing("candidateAnswers", "edu.cmu.lti.oaqa.type.retrieval.SearchResult");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((SearchResult_Type)jcasType).casFeatCode_candidateAnswers)));}
    
  /** setter for candidateAnswers - sets CandidateAnswerVariants generated from this SearchResult. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setCandidateAnswers(FSArray v) {
    if (SearchResult_Type.featOkTst && ((SearchResult_Type)jcasType).casFeat_candidateAnswers == null)
      jcasType.jcas.throwFeatMissing("candidateAnswers", "edu.cmu.lti.oaqa.type.retrieval.SearchResult");
    jcasType.ll_cas.ll_setRefValue(addr, ((SearchResult_Type)jcasType).casFeatCode_candidateAnswers, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for candidateAnswers - gets an indexed value - CandidateAnswerVariants generated from this SearchResult.
   * @generated
   * @param i index in the array to get
   * @return value of the element at index i 
   */
  public CandidateAnswerVariant getCandidateAnswers(int i) {
    if (SearchResult_Type.featOkTst && ((SearchResult_Type)jcasType).casFeat_candidateAnswers == null)
      jcasType.jcas.throwFeatMissing("candidateAnswers", "edu.cmu.lti.oaqa.type.retrieval.SearchResult");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((SearchResult_Type)jcasType).casFeatCode_candidateAnswers), i);
    return (CandidateAnswerVariant)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((SearchResult_Type)jcasType).casFeatCode_candidateAnswers), i)));}

  /** indexed setter for candidateAnswers - sets an indexed value - CandidateAnswerVariants generated from this SearchResult.
   * @generated
   * @param i index in the array to set
   * @param v value to set into the array 
   */
  public void setCandidateAnswers(int i, CandidateAnswerVariant v) { 
    if (SearchResult_Type.featOkTst && ((SearchResult_Type)jcasType).casFeat_candidateAnswers == null)
      jcasType.jcas.throwFeatMissing("candidateAnswers", "edu.cmu.lti.oaqa.type.retrieval.SearchResult");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((SearchResult_Type)jcasType).casFeatCode_candidateAnswers), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((SearchResult_Type)jcasType).casFeatCode_candidateAnswers), i, jcasType.ll_cas.ll_getFSRef(v));}
  }

    