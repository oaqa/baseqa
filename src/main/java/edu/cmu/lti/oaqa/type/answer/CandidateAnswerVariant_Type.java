
/* First created by JCasGen Tue Aug 05 23:03:53 EDT 2014 */
package edu.cmu.lti.oaqa.type.answer;

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

/** A variant of a candidate answer.  A variant may have multiple occurrences, all of which are collected in a variant object.
 * Updated by JCasGen Tue Sep 30 18:21:24 EDT 2014
 * @generated */
public class CandidateAnswerVariant_Type extends TOP_Type {
  /** @generated 
   * @return the generator for this type
   */
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
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.oaqa.type.answer.CandidateAnswerVariant");
 
  /** @generated */
  final Feature casFeat_occurrences;
  /** @generated */
  final int     casFeatCode_occurrences;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getOccurrences(int addr) {
        if (featOkTst && casFeat_occurrences == null)
      jcas.throwFeatMissing("occurrences", "edu.cmu.lti.oaqa.type.answer.CandidateAnswerVariant");
    return ll_cas.ll_getRefValue(addr, casFeatCode_occurrences);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setOccurrences(int addr, int v) {
        if (featOkTst && casFeat_occurrences == null)
      jcas.throwFeatMissing("occurrences", "edu.cmu.lti.oaqa.type.answer.CandidateAnswerVariant");
    ll_cas.ll_setRefValue(addr, casFeatCode_occurrences, v);}
    
  
 
  /** @generated */
  final Feature casFeat_candidateId;
  /** @generated */
  final int     casFeatCode_candidateId;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getCandidateId(int addr) {
        if (featOkTst && casFeat_candidateId == null)
      jcas.throwFeatMissing("candidateId", "edu.cmu.lti.oaqa.type.answer.CandidateAnswerVariant");
    return ll_cas.ll_getStringValue(addr, casFeatCode_candidateId);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setCandidateId(int addr, String v) {
        if (featOkTst && casFeat_candidateId == null)
      jcas.throwFeatMissing("candidateId", "edu.cmu.lti.oaqa.type.answer.CandidateAnswerVariant");
    ll_cas.ll_setStringValue(addr, casFeatCode_candidateId, v);}
    
  
 
  /** @generated */
  final Feature casFeat_text;
  /** @generated */
  final int     casFeatCode_text;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getText(int addr) {
        if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "edu.cmu.lti.oaqa.type.answer.CandidateAnswerVariant");
    return ll_cas.ll_getStringValue(addr, casFeatCode_text);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setText(int addr, String v) {
        if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "edu.cmu.lti.oaqa.type.answer.CandidateAnswerVariant");
    ll_cas.ll_setStringValue(addr, casFeatCode_text, v);}
    
  
 
  /** @generated */
  final Feature casFeat_alternativeNames;
  /** @generated */
  final int     casFeatCode_alternativeNames;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getAlternativeNames(int addr) {
        if (featOkTst && casFeat_alternativeNames == null)
      jcas.throwFeatMissing("alternativeNames", "edu.cmu.lti.oaqa.type.answer.CandidateAnswerVariant");
    return ll_cas.ll_getRefValue(addr, casFeatCode_alternativeNames);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setAlternativeNames(int addr, int v) {
        if (featOkTst && casFeat_alternativeNames == null)
      jcas.throwFeatMissing("alternativeNames", "edu.cmu.lti.oaqa.type.answer.CandidateAnswerVariant");
    ll_cas.ll_setRefValue(addr, casFeatCode_alternativeNames, v);}
    
  
 
  /** @generated */
  final Feature casFeat_uri;
  /** @generated */
  final int     casFeatCode_uri;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getUri(int addr) {
        if (featOkTst && casFeat_uri == null)
      jcas.throwFeatMissing("uri", "edu.cmu.lti.oaqa.type.answer.CandidateAnswerVariant");
    return ll_cas.ll_getStringValue(addr, casFeatCode_uri);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setUri(int addr, String v) {
        if (featOkTst && casFeat_uri == null)
      jcas.throwFeatMissing("uri", "edu.cmu.lti.oaqa.type.answer.CandidateAnswerVariant");
    ll_cas.ll_setStringValue(addr, casFeatCode_uri, v);}
    
  
 
  /** @generated */
  final Feature casFeat_docId;
  /** @generated */
  final int     casFeatCode_docId;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getDocId(int addr) {
        if (featOkTst && casFeat_docId == null)
      jcas.throwFeatMissing("docId", "edu.cmu.lti.oaqa.type.answer.CandidateAnswerVariant");
    return ll_cas.ll_getStringValue(addr, casFeatCode_docId);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setDocId(int addr, String v) {
        if (featOkTst && casFeat_docId == null)
      jcas.throwFeatMissing("docId", "edu.cmu.lti.oaqa.type.answer.CandidateAnswerVariant");
    ll_cas.ll_setStringValue(addr, casFeatCode_docId, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public CandidateAnswerVariant_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_occurrences = jcas.getRequiredFeatureDE(casType, "occurrences", "uima.cas.FSList", featOkTst);
    casFeatCode_occurrences  = (null == casFeat_occurrences) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_occurrences).getCode();

 
    casFeat_candidateId = jcas.getRequiredFeatureDE(casType, "candidateId", "uima.cas.String", featOkTst);
    casFeatCode_candidateId  = (null == casFeat_candidateId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_candidateId).getCode();

 
    casFeat_text = jcas.getRequiredFeatureDE(casType, "text", "uima.cas.String", featOkTst);
    casFeatCode_text  = (null == casFeat_text) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_text).getCode();

 
    casFeat_alternativeNames = jcas.getRequiredFeatureDE(casType, "alternativeNames", "uima.cas.StringList", featOkTst);
    casFeatCode_alternativeNames  = (null == casFeat_alternativeNames) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_alternativeNames).getCode();

 
    casFeat_uri = jcas.getRequiredFeatureDE(casType, "uri", "uima.cas.String", featOkTst);
    casFeatCode_uri  = (null == casFeat_uri) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_uri).getCode();

 
    casFeat_docId = jcas.getRequiredFeatureDE(casType, "docId", "uima.cas.String", featOkTst);
    casFeatCode_docId  = (null == casFeat_docId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_docId).getCode();

  }
}



    