
/* First created by JCasGen Mon Oct 08 18:56:44 EDT 2012 */
package org.oaqa.model;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;

/** A search result.
 * Updated by JCasGen Tue Oct 09 21:34:49 EDT 2012
 * @generated */
public class SearchResult_Type extends OAQATop_Type {
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
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.oaqa.model.SearchResult");
 
  /** @generated */
  final Feature casFeat_uri;
  /** @generated */
  final int     casFeatCode_uri;
  /** @generated */ 
  public String getUri(int addr) {
        if (featOkTst && casFeat_uri == null)
      jcas.throwFeatMissing("uri", "org.oaqa.model.SearchResult");
    return ll_cas.ll_getStringValue(addr, casFeatCode_uri);
  }
  /** @generated */    
  public void setUri(int addr, String v) {
        if (featOkTst && casFeat_uri == null)
      jcas.throwFeatMissing("uri", "org.oaqa.model.SearchResult");
    ll_cas.ll_setStringValue(addr, casFeatCode_uri, v);}
    
  
 
  /** @generated */
  final Feature casFeat_score;
  /** @generated */
  final int     casFeatCode_score;
  /** @generated */ 
  public double getScore(int addr) {
        if (featOkTst && casFeat_score == null)
      jcas.throwFeatMissing("score", "org.oaqa.model.SearchResult");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_score);
  }
  /** @generated */    
  public void setScore(int addr, double v) {
        if (featOkTst && casFeat_score == null)
      jcas.throwFeatMissing("score", "org.oaqa.model.SearchResult");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_score, v);}
    
  
 
  /** @generated */
  final Feature casFeat_text;
  /** @generated */
  final int     casFeatCode_text;
  /** @generated */ 
  public String getText(int addr) {
        if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "org.oaqa.model.SearchResult");
    return ll_cas.ll_getStringValue(addr, casFeatCode_text);
  }
  /** @generated */    
  public void setText(int addr, String v) {
        if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "org.oaqa.model.SearchResult");
    ll_cas.ll_setStringValue(addr, casFeatCode_text, v);}
    
  
 
  /** @generated */
  final Feature casFeat_rank;
  /** @generated */
  final int     casFeatCode_rank;
  /** @generated */ 
  public int getRank(int addr) {
        if (featOkTst && casFeat_rank == null)
      jcas.throwFeatMissing("rank", "org.oaqa.model.SearchResult");
    return ll_cas.ll_getIntValue(addr, casFeatCode_rank);
  }
  /** @generated */    
  public void setRank(int addr, int v) {
        if (featOkTst && casFeat_rank == null)
      jcas.throwFeatMissing("rank", "org.oaqa.model.SearchResult");
    ll_cas.ll_setIntValue(addr, casFeatCode_rank, v);}
    
  
 
  /** @generated */
  final Feature casFeat_queryString;
  /** @generated */
  final int     casFeatCode_queryString;
  /** @generated */ 
  public String getQueryString(int addr) {
        if (featOkTst && casFeat_queryString == null)
      jcas.throwFeatMissing("queryString", "org.oaqa.model.SearchResult");
    return ll_cas.ll_getStringValue(addr, casFeatCode_queryString);
  }
  /** @generated */    
  public void setQueryString(int addr, String v) {
        if (featOkTst && casFeat_queryString == null)
      jcas.throwFeatMissing("queryString", "org.oaqa.model.SearchResult");
    ll_cas.ll_setStringValue(addr, casFeatCode_queryString, v);}
    
  
 
  /** @generated */
  final Feature casFeat_searchId;
  /** @generated */
  final int     casFeatCode_searchId;
  /** @generated */ 
  public String getSearchId(int addr) {
        if (featOkTst && casFeat_searchId == null)
      jcas.throwFeatMissing("searchId", "org.oaqa.model.SearchResult");
    return ll_cas.ll_getStringValue(addr, casFeatCode_searchId);
  }
  /** @generated */    
  public void setSearchId(int addr, String v) {
        if (featOkTst && casFeat_searchId == null)
      jcas.throwFeatMissing("searchId", "org.oaqa.model.SearchResult");
    ll_cas.ll_setStringValue(addr, casFeatCode_searchId, v);}
    
  
 
  /** @generated */
  final Feature casFeat_candidateAnswers;
  /** @generated */
  final int     casFeatCode_candidateAnswers;
  /** @generated */ 
  public int getCandidateAnswers(int addr) {
        if (featOkTst && casFeat_candidateAnswers == null)
      jcas.throwFeatMissing("candidateAnswers", "org.oaqa.model.SearchResult");
    return ll_cas.ll_getRefValue(addr, casFeatCode_candidateAnswers);
  }
  /** @generated */    
  public void setCandidateAnswers(int addr, int v) {
        if (featOkTst && casFeat_candidateAnswers == null)
      jcas.throwFeatMissing("candidateAnswers", "org.oaqa.model.SearchResult");
    ll_cas.ll_setRefValue(addr, casFeatCode_candidateAnswers, v);}
    
   /** @generated */
  public int getCandidateAnswers(int addr, int i) {
        if (featOkTst && casFeat_candidateAnswers == null)
      jcas.throwFeatMissing("candidateAnswers", "org.oaqa.model.SearchResult");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_candidateAnswers), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_candidateAnswers), i);
  return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_candidateAnswers), i);
  }
   
  /** @generated */ 
  public void setCandidateAnswers(int addr, int i, int v) {
        if (featOkTst && casFeat_candidateAnswers == null)
      jcas.throwFeatMissing("candidateAnswers", "org.oaqa.model.SearchResult");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_candidateAnswers), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_candidateAnswers), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_candidateAnswers), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_features;
  /** @generated */
  final int     casFeatCode_features;
  /** @generated */ 
  public int getFeatures(int addr) {
        if (featOkTst && casFeat_features == null)
      jcas.throwFeatMissing("features", "org.oaqa.model.SearchResult");
    return ll_cas.ll_getRefValue(addr, casFeatCode_features);
  }
  /** @generated */    
  public void setFeatures(int addr, int v) {
        if (featOkTst && casFeat_features == null)
      jcas.throwFeatMissing("features", "org.oaqa.model.SearchResult");
    ll_cas.ll_setRefValue(addr, casFeatCode_features, v);}
    
  
 
  /** @generated */
  final Feature casFeat_featureVector;
  /** @generated */
  final int     casFeatCode_featureVector;
  /** @generated */ 
  public int getFeatureVector(int addr) {
        if (featOkTst && casFeat_featureVector == null)
      jcas.throwFeatMissing("featureVector", "org.oaqa.model.SearchResult");
    return ll_cas.ll_getRefValue(addr, casFeatCode_featureVector);
  }
  /** @generated */    
  public void setFeatureVector(int addr, int v) {
        if (featOkTst && casFeat_featureVector == null)
      jcas.throwFeatMissing("featureVector", "org.oaqa.model.SearchResult");
    ll_cas.ll_setRefValue(addr, casFeatCode_featureVector, v);}
    
   /** @generated */
  public double getFeatureVector(int addr, int i) {
        if (featOkTst && casFeat_featureVector == null)
      jcas.throwFeatMissing("featureVector", "org.oaqa.model.SearchResult");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getDoubleArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_featureVector), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_featureVector), i);
  return ll_cas.ll_getDoubleArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_featureVector), i);
  }
   
  /** @generated */ 
  public void setFeatureVector(int addr, int i, double v) {
        if (featOkTst && casFeat_featureVector == null)
      jcas.throwFeatMissing("featureVector", "org.oaqa.model.SearchResult");
    if (lowLevelTypeChecks)
      ll_cas.ll_setDoubleArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_featureVector), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_featureVector), i);
    ll_cas.ll_setDoubleArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_featureVector), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_rankVector;
  /** @generated */
  final int     casFeatCode_rankVector;
  /** @generated */ 
  public int getRankVector(int addr) {
        if (featOkTst && casFeat_rankVector == null)
      jcas.throwFeatMissing("rankVector", "org.oaqa.model.SearchResult");
    return ll_cas.ll_getRefValue(addr, casFeatCode_rankVector);
  }
  /** @generated */    
  public void setRankVector(int addr, int v) {
        if (featOkTst && casFeat_rankVector == null)
      jcas.throwFeatMissing("rankVector", "org.oaqa.model.SearchResult");
    ll_cas.ll_setRefValue(addr, casFeatCode_rankVector, v);}
    
   /** @generated */
  public int getRankVector(int addr, int i) {
        if (featOkTst && casFeat_rankVector == null)
      jcas.throwFeatMissing("rankVector", "org.oaqa.model.SearchResult");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getIntArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_rankVector), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_rankVector), i);
  return ll_cas.ll_getIntArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_rankVector), i);
  }
   
  /** @generated */ 
  public void setRankVector(int addr, int i, int v) {
        if (featOkTst && casFeat_rankVector == null)
      jcas.throwFeatMissing("rankVector", "org.oaqa.model.SearchResult");
    if (lowLevelTypeChecks)
      ll_cas.ll_setIntArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_rankVector), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_rankVector), i);
    ll_cas.ll_setIntArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_rankVector), i, v);
  }
 



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public SearchResult_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_uri = jcas.getRequiredFeatureDE(casType, "uri", "uima.cas.String", featOkTst);
    casFeatCode_uri  = (null == casFeat_uri) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_uri).getCode();

 
    casFeat_score = jcas.getRequiredFeatureDE(casType, "score", "uima.cas.Double", featOkTst);
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

 
    casFeat_features = jcas.getRequiredFeatureDE(casType, "features", "uima.cas.FSList", featOkTst);
    casFeatCode_features  = (null == casFeat_features) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_features).getCode();

 
    casFeat_featureVector = jcas.getRequiredFeatureDE(casType, "featureVector", "uima.cas.DoubleArray", featOkTst);
    casFeatCode_featureVector  = (null == casFeat_featureVector) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_featureVector).getCode();

 
    casFeat_rankVector = jcas.getRequiredFeatureDE(casType, "rankVector", "uima.cas.IntegerArray", featOkTst);
    casFeatCode_rankVector  = (null == casFeat_rankVector) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_rankVector).getCode();

  }
}



    