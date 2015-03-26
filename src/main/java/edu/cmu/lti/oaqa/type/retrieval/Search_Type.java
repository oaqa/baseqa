
/* First created by JCasGen Sun Oct 19 14:47:24 EDT 2014 */
package edu.cmu.lti.oaqa.type.retrieval;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.cas.TOP_Type;

/** An object that holds a query and results for a search (text search, fact search, KB search, etc.)
 * Updated by JCasGen Tue Mar 17 14:36:56 EDT 2015
 * @generated */
public class Search_Type extends TOP_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Search_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Search_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Search(addr, Search_Type.this);
  			   Search_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Search(addr, Search_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Search.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.oaqa.type.retrieval.Search");
 
  /** @generated */
  final Feature casFeat_query;
  /** @generated */
  final int     casFeatCode_query;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getQuery(int addr) {
        if (featOkTst && casFeat_query == null)
      jcas.throwFeatMissing("query", "edu.cmu.lti.oaqa.type.retrieval.Search");
    return ll_cas.ll_getStringValue(addr, casFeatCode_query);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setQuery(int addr, String v) {
        if (featOkTst && casFeat_query == null)
      jcas.throwFeatMissing("query", "edu.cmu.lti.oaqa.type.retrieval.Search");
    ll_cas.ll_setStringValue(addr, casFeatCode_query, v);}
    
  
 
  /** @generated */
  final Feature casFeat_hitList;
  /** @generated */
  final int     casFeatCode_hitList;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getHitList(int addr) {
        if (featOkTst && casFeat_hitList == null)
      jcas.throwFeatMissing("hitList", "edu.cmu.lti.oaqa.type.retrieval.Search");
    return ll_cas.ll_getRefValue(addr, casFeatCode_hitList);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setHitList(int addr, int v) {
        if (featOkTst && casFeat_hitList == null)
      jcas.throwFeatMissing("hitList", "edu.cmu.lti.oaqa.type.retrieval.Search");
    ll_cas.ll_setRefValue(addr, casFeatCode_hitList, v);}
    
   /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @return value at index i in the array 
   */
  public int getHitList(int addr, int i) {
        if (featOkTst && casFeat_hitList == null)
      jcas.throwFeatMissing("hitList", "edu.cmu.lti.oaqa.type.retrieval.Search");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_hitList), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_hitList), i);
  return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_hitList), i);
  }
   
  /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @param v value to set
   */ 
  public void setHitList(int addr, int i, int v) {
        if (featOkTst && casFeat_hitList == null)
      jcas.throwFeatMissing("hitList", "edu.cmu.lti.oaqa.type.retrieval.Search");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_hitList), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_hitList), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_hitList), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_abstractQuery;
  /** @generated */
  final int     casFeatCode_abstractQuery;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getAbstractQuery(int addr) {
        if (featOkTst && casFeat_abstractQuery == null)
      jcas.throwFeatMissing("abstractQuery", "edu.cmu.lti.oaqa.type.retrieval.Search");
    return ll_cas.ll_getRefValue(addr, casFeatCode_abstractQuery);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setAbstractQuery(int addr, int v) {
        if (featOkTst && casFeat_abstractQuery == null)
      jcas.throwFeatMissing("abstractQuery", "edu.cmu.lti.oaqa.type.retrieval.Search");
    ll_cas.ll_setRefValue(addr, casFeatCode_abstractQuery, v);}
    
  
 
  /** @generated */
  final Feature casFeat_searchId;
  /** @generated */
  final int     casFeatCode_searchId;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getSearchId(int addr) {
        if (featOkTst && casFeat_searchId == null)
      jcas.throwFeatMissing("searchId", "edu.cmu.lti.oaqa.type.retrieval.Search");
    return ll_cas.ll_getStringValue(addr, casFeatCode_searchId);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setSearchId(int addr, String v) {
        if (featOkTst && casFeat_searchId == null)
      jcas.throwFeatMissing("searchId", "edu.cmu.lti.oaqa.type.retrieval.Search");
    ll_cas.ll_setStringValue(addr, casFeatCode_searchId, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Search_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_query = jcas.getRequiredFeatureDE(casType, "query", "uima.cas.String", featOkTst);
    casFeatCode_query  = (null == casFeat_query) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_query).getCode();

 
    casFeat_hitList = jcas.getRequiredFeatureDE(casType, "hitList", "uima.cas.FSArray", featOkTst);
    casFeatCode_hitList  = (null == casFeat_hitList) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_hitList).getCode();

 
    casFeat_abstractQuery = jcas.getRequiredFeatureDE(casType, "abstractQuery", "edu.cmu.lti.oaqa.type.retrieval.AbstractQuery", featOkTst);
    casFeatCode_abstractQuery  = (null == casFeat_abstractQuery) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_abstractQuery).getCode();

 
    casFeat_searchId = jcas.getRequiredFeatureDE(casType, "searchId", "uima.cas.String", featOkTst);
    casFeatCode_searchId  = (null == casFeat_searchId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_searchId).getCode();

  }
}



    