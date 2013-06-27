
/* First created by JCasGen Mon Jun 24 14:02:20 EDT 2013 */
package org.oaqa.model.retrieval;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.oaqa.model.gerp.GerpTop_Type;

/** A search result.
 * Updated by JCasGen Thu Jun 27 14:37:29 EDT 2013
 * @generated */
public class SearchResult_Type extends GerpTop_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (SearchResult_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = SearchResult_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new SearchResult(addr, SearchResult_Type.this);
  			   SearchResult_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new SearchResult(addr, SearchResult_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = SearchResult.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.oaqa.model.retrieval.SearchResult");
 
  /** @generated */
  final Feature casFeat_uri;
  /** @generated */
  final int     casFeatCode_uri;
  /** @generated */ 
  public String getUri(int addr) {
        if (featOkTst && casFeat_uri == null)
      jcas.throwFeatMissing("uri", "org.oaqa.model.retrieval.SearchResult");
    return ll_cas.ll_getStringValue(addr, casFeatCode_uri);
  }
  /** @generated */    
  public void setUri(int addr, String v) {
        if (featOkTst && casFeat_uri == null)
      jcas.throwFeatMissing("uri", "org.oaqa.model.retrieval.SearchResult");
    ll_cas.ll_setStringValue(addr, casFeatCode_uri, v);}
    
  
 
  /** @generated */
  final Feature casFeat_score;
  /** @generated */
  final int     casFeatCode_score;
  /** @generated */ 
  public float getScore(int addr) {
        if (featOkTst && casFeat_score == null)
      jcas.throwFeatMissing("score", "org.oaqa.model.retrieval.SearchResult");
    return ll_cas.ll_getFloatValue(addr, casFeatCode_score);
  }
  /** @generated */    
  public void setScore(int addr, float v) {
        if (featOkTst && casFeat_score == null)
      jcas.throwFeatMissing("score", "org.oaqa.model.retrieval.SearchResult");
    ll_cas.ll_setFloatValue(addr, casFeatCode_score, v);}
    
  
 
  /** @generated */
  final Feature casFeat_text;
  /** @generated */
  final int     casFeatCode_text;
  /** @generated */ 
  public String getText(int addr) {
        if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "org.oaqa.model.retrieval.SearchResult");
    return ll_cas.ll_getStringValue(addr, casFeatCode_text);
  }
  /** @generated */    
  public void setText(int addr, String v) {
        if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "org.oaqa.model.retrieval.SearchResult");
    ll_cas.ll_setStringValue(addr, casFeatCode_text, v);}
    
  
 
  /** @generated */
  final Feature casFeat_rank;
  /** @generated */
  final int     casFeatCode_rank;
  /** @generated */ 
  public int getRank(int addr) {
        if (featOkTst && casFeat_rank == null)
      jcas.throwFeatMissing("rank", "org.oaqa.model.retrieval.SearchResult");
    return ll_cas.ll_getIntValue(addr, casFeatCode_rank);
  }
  /** @generated */    
  public void setRank(int addr, int v) {
        if (featOkTst && casFeat_rank == null)
      jcas.throwFeatMissing("rank", "org.oaqa.model.retrieval.SearchResult");
    ll_cas.ll_setIntValue(addr, casFeatCode_rank, v);}
    
  
 
  /** @generated */
  final Feature casFeat_queryString;
  /** @generated */
  final int     casFeatCode_queryString;
  /** @generated */ 
  public String getQueryString(int addr) {
        if (featOkTst && casFeat_queryString == null)
      jcas.throwFeatMissing("queryString", "org.oaqa.model.retrieval.SearchResult");
    return ll_cas.ll_getStringValue(addr, casFeatCode_queryString);
  }
  /** @generated */    
  public void setQueryString(int addr, String v) {
        if (featOkTst && casFeat_queryString == null)
      jcas.throwFeatMissing("queryString", "org.oaqa.model.retrieval.SearchResult");
    ll_cas.ll_setStringValue(addr, casFeatCode_queryString, v);}
    
  
 
  /** @generated */
  final Feature casFeat_searchId;
  /** @generated */
  final int     casFeatCode_searchId;
  /** @generated */ 
  public String getSearchId(int addr) {
        if (featOkTst && casFeat_searchId == null)
      jcas.throwFeatMissing("searchId", "org.oaqa.model.retrieval.SearchResult");
    return ll_cas.ll_getStringValue(addr, casFeatCode_searchId);
  }
  /** @generated */    
  public void setSearchId(int addr, String v) {
        if (featOkTst && casFeat_searchId == null)
      jcas.throwFeatMissing("searchId", "org.oaqa.model.retrieval.SearchResult");
    ll_cas.ll_setStringValue(addr, casFeatCode_searchId, v);}
    
  
 
  /** @generated */
  final Feature casFeat_candidateAnswers;
  /** @generated */
  final int     casFeatCode_candidateAnswers;
  /** @generated */ 
  public int getCandidateAnswers(int addr) {
        if (featOkTst && casFeat_candidateAnswers == null)
      jcas.throwFeatMissing("candidateAnswers", "org.oaqa.model.retrieval.SearchResult");
    return ll_cas.ll_getRefValue(addr, casFeatCode_candidateAnswers);
  }
  /** @generated */    
  public void setCandidateAnswers(int addr, int v) {
        if (featOkTst && casFeat_candidateAnswers == null)
      jcas.throwFeatMissing("candidateAnswers", "org.oaqa.model.retrieval.SearchResult");
    ll_cas.ll_setRefValue(addr, casFeatCode_candidateAnswers, v);}
    
   /** @generated */
  public int getCandidateAnswers(int addr, int i) {
        if (featOkTst && casFeat_candidateAnswers == null)
      jcas.throwFeatMissing("candidateAnswers", "org.oaqa.model.retrieval.SearchResult");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_candidateAnswers), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_candidateAnswers), i);
  return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_candidateAnswers), i);
  }
   
  /** @generated */ 
  public void setCandidateAnswers(int addr, int i, int v) {
        if (featOkTst && casFeat_candidateAnswers == null)
      jcas.throwFeatMissing("candidateAnswers", "org.oaqa.model.retrieval.SearchResult");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_candidateAnswers), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_candidateAnswers), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_candidateAnswers), i, v);
  }
 



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public SearchResult_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_uri = jcas.getRequiredFeatureDE(casType, "uri", "uima.cas.String", featOkTst);
    casFeatCode_uri  = (null == casFeat_uri) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_uri).getCode();

 
    casFeat_score = jcas.getRequiredFeatureDE(casType, "score", "uima.cas.Float", featOkTst);
    casFeatCode_score  = (null == casFeat_score) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_score).getCode();

 
    casFeat_text = jcas.getRequiredFeatureDE(casType, "text", "uima.cas.String", featOkTst);
    casFeatCode_text  = (null == casFeat_text) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_text).getCode();

 
    casFeat_rank = jcas.getRequiredFeatureDE(casType, "rank", "uima.cas.Integer", featOkTst);
    casFeatCode_rank  = (null == casFeat_rank) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_rank).getCode();

 
    casFeat_queryString = jcas.getRequiredFeatureDE(casType, "queryString", "uima.cas.String", featOkTst);
    casFeatCode_queryString  = (null == casFeat_queryString) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_queryString).getCode();

 
    casFeat_searchId = jcas.getRequiredFeatureDE(casType, "searchId", "uima.cas.String", featOkTst);
    casFeatCode_searchId  = (null == casFeat_searchId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_searchId).getCode();

 
    casFeat_candidateAnswers = jcas.getRequiredFeatureDE(casType, "candidateAnswers", "uima.cas.FSArray", featOkTst);
    casFeatCode_candidateAnswers  = (null == casFeat_candidateAnswers) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_candidateAnswers).getCode();

  }
}



    