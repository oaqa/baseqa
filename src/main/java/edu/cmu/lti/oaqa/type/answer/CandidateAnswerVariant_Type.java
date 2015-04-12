
/* First created by JCasGen Sat Apr 11 19:49:33 EDT 2015 */
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

/** A variant of a candidate answer. A variant may have multiple occurrences, all of which are collected in a variant object.
 * Updated by JCasGen Mon Apr 13 16:42:07 EDT 2015
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
  final Feature casFeat_names;
  /** @generated */
  final int     casFeatCode_names;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getNames(int addr) {
        if (featOkTst && casFeat_names == null)
      jcas.throwFeatMissing("names", "edu.cmu.lti.oaqa.type.answer.CandidateAnswerVariant");
    return ll_cas.ll_getRefValue(addr, casFeatCode_names);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setNames(int addr, int v) {
        if (featOkTst && casFeat_names == null)
      jcas.throwFeatMissing("names", "edu.cmu.lti.oaqa.type.answer.CandidateAnswerVariant");
    ll_cas.ll_setRefValue(addr, casFeatCode_names, v);}
    
  
 
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

 
    casFeat_names = jcas.getRequiredFeatureDE(casType, "names", "uima.cas.StringList", featOkTst);
    casFeatCode_names  = (null == casFeat_names) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_names).getCode();

 
    casFeat_docId = jcas.getRequiredFeatureDE(casType, "docId", "uima.cas.String", featOkTst);
    casFeatCode_docId  = (null == casFeat_docId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_docId).getCode();

  }
}



    