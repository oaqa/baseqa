
/* First created by JCasGen Sat Mar 02 19:54:39 EST 2013 */
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

/** A feature of a candidate answer produced by a feature generator or answer scorer.
 * Updated by JCasGen Sat Mar 02 19:54:39 EST 2013
 * @generated */
public class CaFeature_Type extends OAQATop_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (CaFeature_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = CaFeature_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new CaFeature(addr, CaFeature_Type.this);
  			   CaFeature_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new CaFeature(addr, CaFeature_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = CaFeature.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.oaqa.model.CaFeature");
 
  /** @generated */
  final Feature casFeat_answer;
  /** @generated */
  final int     casFeatCode_answer;
  /** @generated */ 
  public int getAnswer(int addr) {
        if (featOkTst && casFeat_answer == null)
      jcas.throwFeatMissing("answer", "org.oaqa.model.CaFeature");
    return ll_cas.ll_getRefValue(addr, casFeatCode_answer);
  }
  /** @generated */    
  public void setAnswer(int addr, int v) {
        if (featOkTst && casFeat_answer == null)
      jcas.throwFeatMissing("answer", "org.oaqa.model.CaFeature");
    ll_cas.ll_setRefValue(addr, casFeatCode_answer, v);}
    
  
 
  /** @generated */
  final Feature casFeat_label;
  /** @generated */
  final int     casFeatCode_label;
  /** @generated */ 
  public String getLabel(int addr) {
        if (featOkTst && casFeat_label == null)
      jcas.throwFeatMissing("label", "org.oaqa.model.CaFeature");
    return ll_cas.ll_getStringValue(addr, casFeatCode_label);
  }
  /** @generated */    
  public void setLabel(int addr, String v) {
        if (featOkTst && casFeat_label == null)
      jcas.throwFeatMissing("label", "org.oaqa.model.CaFeature");
    ll_cas.ll_setStringValue(addr, casFeatCode_label, v);}
    
  
 
  /** @generated */
  final Feature casFeat_score;
  /** @generated */
  final int     casFeatCode_score;
  /** @generated */ 
  public double getScore(int addr) {
        if (featOkTst && casFeat_score == null)
      jcas.throwFeatMissing("score", "org.oaqa.model.CaFeature");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_score);
  }
  /** @generated */    
  public void setScore(int addr, double v) {
        if (featOkTst && casFeat_score == null)
      jcas.throwFeatMissing("score", "org.oaqa.model.CaFeature");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_score, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public CaFeature_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_answer = jcas.getRequiredFeatureDE(casType, "answer", "org.oaqa.model.CandidateAnswerVariant", featOkTst);
    casFeatCode_answer  = (null == casFeat_answer) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_answer).getCode();

 
    casFeat_label = jcas.getRequiredFeatureDE(casType, "label", "uima.cas.String", featOkTst);
    casFeatCode_label  = (null == casFeat_label) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_label).getCode();

 
    casFeat_score = jcas.getRequiredFeatureDE(casType, "score", "uima.cas.Double", featOkTst);
    casFeatCode_score  = (null == casFeat_score) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_score).getCode();

  }
}



    