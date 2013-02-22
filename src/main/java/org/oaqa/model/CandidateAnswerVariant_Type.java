
/* First created by JCasGen Thu Feb 21 16:50:37 EST 2013 */
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

/** A variant of a candidate answer.  A variant may have multiple occurrences, all of which are collected in a variant object.
 * Updated by JCasGen Thu Feb 21 16:50:37 EST 2013
 * @generated */
public class CandidateAnswerVariant_Type extends OAQATop_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (CandidateAnswerVariant_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = CandidateAnswerVariant_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new CandidateAnswerVariant(addr, CandidateAnswerVariant_Type.this);
  			   CandidateAnswerVariant_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new CandidateAnswerVariant(addr, CandidateAnswerVariant_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = CandidateAnswerVariant.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.oaqa.model.CandidateAnswerVariant");
 
  /** @generated */
  final Feature casFeat_occurrences;
  /** @generated */
  final int     casFeatCode_occurrences;
  /** @generated */ 
  public int getOccurrences(int addr) {
        if (featOkTst && casFeat_occurrences == null)
      jcas.throwFeatMissing("occurrences", "org.oaqa.model.CandidateAnswerVariant");
    return ll_cas.ll_getRefValue(addr, casFeatCode_occurrences);
  }
  /** @generated */    
  public void setOccurrences(int addr, int v) {
        if (featOkTst && casFeat_occurrences == null)
      jcas.throwFeatMissing("occurrences", "org.oaqa.model.CandidateAnswerVariant");
    ll_cas.ll_setRefValue(addr, casFeatCode_occurrences, v);}
    
  
 
  /** @generated */
  final Feature casFeat_candidateId;
  /** @generated */
  final int     casFeatCode_candidateId;
  /** @generated */ 
  public String getCandidateId(int addr) {
        if (featOkTst && casFeat_candidateId == null)
      jcas.throwFeatMissing("candidateId", "org.oaqa.model.CandidateAnswerVariant");
    return ll_cas.ll_getStringValue(addr, casFeatCode_candidateId);
  }
  /** @generated */    
  public void setCandidateId(int addr, String v) {
        if (featOkTst && casFeat_candidateId == null)
      jcas.throwFeatMissing("candidateId", "org.oaqa.model.CandidateAnswerVariant");
    ll_cas.ll_setStringValue(addr, casFeatCode_candidateId, v);}
    
  
 
  /** @generated */
  final Feature casFeat_text;
  /** @generated */
  final int     casFeatCode_text;
  /** @generated */ 
  public String getText(int addr) {
        if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "org.oaqa.model.CandidateAnswerVariant");
    return ll_cas.ll_getStringValue(addr, casFeatCode_text);
  }
  /** @generated */    
  public void setText(int addr, String v) {
        if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "org.oaqa.model.CandidateAnswerVariant");
    ll_cas.ll_setStringValue(addr, casFeatCode_text, v);}
    
  
 
  /** @generated */
  final Feature casFeat_features;
  /** @generated */
  final int     casFeatCode_features;
  /** @generated */ 
  public int getFeatures(int addr) {
        if (featOkTst && casFeat_features == null)
      jcas.throwFeatMissing("features", "org.oaqa.model.CandidateAnswerVariant");
    return ll_cas.ll_getRefValue(addr, casFeatCode_features);
  }
  /** @generated */    
  public void setFeatures(int addr, int v) {
        if (featOkTst && casFeat_features == null)
      jcas.throwFeatMissing("features", "org.oaqa.model.CandidateAnswerVariant");
    ll_cas.ll_setRefValue(addr, casFeatCode_features, v);}
    
  
 
  /** @generated */
  final Feature casFeat_supportingEvidenceSearches;
  /** @generated */
  final int     casFeatCode_supportingEvidenceSearches;
  /** @generated */ 
  public int getSupportingEvidenceSearches(int addr) {
        if (featOkTst && casFeat_supportingEvidenceSearches == null)
      jcas.throwFeatMissing("supportingEvidenceSearches", "org.oaqa.model.CandidateAnswerVariant");
    return ll_cas.ll_getRefValue(addr, casFeatCode_supportingEvidenceSearches);
  }
  /** @generated */    
  public void setSupportingEvidenceSearches(int addr, int v) {
        if (featOkTst && casFeat_supportingEvidenceSearches == null)
      jcas.throwFeatMissing("supportingEvidenceSearches", "org.oaqa.model.CandidateAnswerVariant");
    ll_cas.ll_setRefValue(addr, casFeatCode_supportingEvidenceSearches, v);}
    
   /** @generated */
  public int getSupportingEvidenceSearches(int addr, int i) {
        if (featOkTst && casFeat_supportingEvidenceSearches == null)
      jcas.throwFeatMissing("supportingEvidenceSearches", "org.oaqa.model.CandidateAnswerVariant");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_supportingEvidenceSearches), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_supportingEvidenceSearches), i);
	return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_supportingEvidenceSearches), i);
  }
   
  /** @generated */ 
  public void setSupportingEvidenceSearches(int addr, int i, int v) {
        if (featOkTst && casFeat_supportingEvidenceSearches == null)
      jcas.throwFeatMissing("supportingEvidenceSearches", "org.oaqa.model.CandidateAnswerVariant");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_supportingEvidenceSearches), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_supportingEvidenceSearches), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_supportingEvidenceSearches), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_alternativeNames;
  /** @generated */
  final int     casFeatCode_alternativeNames;
  /** @generated */ 
  public int getAlternativeNames(int addr) {
        if (featOkTst && casFeat_alternativeNames == null)
      jcas.throwFeatMissing("alternativeNames", "org.oaqa.model.CandidateAnswerVariant");
    return ll_cas.ll_getRefValue(addr, casFeatCode_alternativeNames);
  }
  /** @generated */    
  public void setAlternativeNames(int addr, int v) {
        if (featOkTst && casFeat_alternativeNames == null)
      jcas.throwFeatMissing("alternativeNames", "org.oaqa.model.CandidateAnswerVariant");
    ll_cas.ll_setRefValue(addr, casFeatCode_alternativeNames, v);}
    
  
 
  /** @generated */
  final Feature casFeat_uri;
  /** @generated */
  final int     casFeatCode_uri;
  /** @generated */ 
  public String getUri(int addr) {
        if (featOkTst && casFeat_uri == null)
      jcas.throwFeatMissing("uri", "org.oaqa.model.CandidateAnswerVariant");
    return ll_cas.ll_getStringValue(addr, casFeatCode_uri);
  }
  /** @generated */    
  public void setUri(int addr, String v) {
        if (featOkTst && casFeat_uri == null)
      jcas.throwFeatMissing("uri", "org.oaqa.model.CandidateAnswerVariant");
    ll_cas.ll_setStringValue(addr, casFeatCode_uri, v);}
    
  
 
  /** @generated */
  final Feature casFeat_docId;
  /** @generated */
  final int     casFeatCode_docId;
  /** @generated */ 
  public String getDocId(int addr) {
        if (featOkTst && casFeat_docId == null)
      jcas.throwFeatMissing("docId", "org.oaqa.model.CandidateAnswerVariant");
    return ll_cas.ll_getStringValue(addr, casFeatCode_docId);
  }
  /** @generated */    
  public void setDocId(int addr, String v) {
        if (featOkTst && casFeat_docId == null)
      jcas.throwFeatMissing("docId", "org.oaqa.model.CandidateAnswerVariant");
    ll_cas.ll_setStringValue(addr, casFeatCode_docId, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public CandidateAnswerVariant_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_occurrences = jcas.getRequiredFeatureDE(casType, "occurrences", "uima.cas.FSList", featOkTst);
    casFeatCode_occurrences  = (null == casFeat_occurrences) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_occurrences).getCode();

 
    casFeat_candidateId = jcas.getRequiredFeatureDE(casType, "candidateId", "uima.cas.String", featOkTst);
    casFeatCode_candidateId  = (null == casFeat_candidateId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_candidateId).getCode();

 
    casFeat_text = jcas.getRequiredFeatureDE(casType, "text", "uima.cas.String", featOkTst);
    casFeatCode_text  = (null == casFeat_text) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_text).getCode();

 
    casFeat_features = jcas.getRequiredFeatureDE(casType, "features", "uima.cas.FSList", featOkTst);
    casFeatCode_features  = (null == casFeat_features) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_features).getCode();

 
    casFeat_supportingEvidenceSearches = jcas.getRequiredFeatureDE(casType, "supportingEvidenceSearches", "uima.cas.FSArray", featOkTst);
    casFeatCode_supportingEvidenceSearches  = (null == casFeat_supportingEvidenceSearches) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_supportingEvidenceSearches).getCode();

 
    casFeat_alternativeNames = jcas.getRequiredFeatureDE(casType, "alternativeNames", "uima.cas.StringList", featOkTst);
    casFeatCode_alternativeNames  = (null == casFeat_alternativeNames) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_alternativeNames).getCode();

 
    casFeat_uri = jcas.getRequiredFeatureDE(casType, "uri", "uima.cas.String", featOkTst);
    casFeatCode_uri  = (null == casFeat_uri) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_uri).getCode();

 
    casFeat_docId = jcas.getRequiredFeatureDE(casType, "docId", "uima.cas.String", featOkTst);
    casFeatCode_docId  = (null == casFeat_docId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_docId).getCode();

  }
}



    