
/* First created by JCasGen Sat Jun 29 17:55:59 EDT 2013 */
package org.oaqa.model.answer;

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

/** A ranked list of candidate answers.
 * Updated by JCasGen Sat Jun 29 17:55:59 EDT 2013
 * @generated */
public class AnswerList_Type extends GerpTop_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (AnswerList_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = AnswerList_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new AnswerList(addr, AnswerList_Type.this);
  			   AnswerList_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new AnswerList(addr, AnswerList_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = AnswerList.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.oaqa.model.answer.AnswerList");
 
  /** @generated */
  final Feature casFeat_answerList;
  /** @generated */
  final int     casFeatCode_answerList;
  /** @generated */ 
  public int getAnswerList(int addr) {
        if (featOkTst && casFeat_answerList == null)
      jcas.throwFeatMissing("answerList", "org.oaqa.model.answer.AnswerList");
    return ll_cas.ll_getRefValue(addr, casFeatCode_answerList);
  }
  /** @generated */    
  public void setAnswerList(int addr, int v) {
        if (featOkTst && casFeat_answerList == null)
      jcas.throwFeatMissing("answerList", "org.oaqa.model.answer.AnswerList");
    ll_cas.ll_setRefValue(addr, casFeatCode_answerList, v);}
    
   /** @generated */
  public int getAnswerList(int addr, int i) {
        if (featOkTst && casFeat_answerList == null)
      jcas.throwFeatMissing("answerList", "org.oaqa.model.answer.AnswerList");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_answerList), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_answerList), i);
	return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_answerList), i);
  }
   
  /** @generated */ 
  public void setAnswerList(int addr, int i, int v) {
        if (featOkTst && casFeat_answerList == null)
      jcas.throwFeatMissing("answerList", "org.oaqa.model.answer.AnswerList");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_answerList), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_answerList), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_answerList), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_nilAnswer;
  /** @generated */
  final int     casFeatCode_nilAnswer;
  /** @generated */ 
  public boolean getNilAnswer(int addr) {
        if (featOkTst && casFeat_nilAnswer == null)
      jcas.throwFeatMissing("nilAnswer", "org.oaqa.model.answer.AnswerList");
    return ll_cas.ll_getBooleanValue(addr, casFeatCode_nilAnswer);
  }
  /** @generated */    
  public void setNilAnswer(int addr, boolean v) {
        if (featOkTst && casFeat_nilAnswer == null)
      jcas.throwFeatMissing("nilAnswer", "org.oaqa.model.answer.AnswerList");
    ll_cas.ll_setBooleanValue(addr, casFeatCode_nilAnswer, v);}
    
  
 
  /** @generated */
  final Feature casFeat_featureLabels;
  /** @generated */
  final int     casFeatCode_featureLabels;
  /** @generated */ 
  public int getFeatureLabels(int addr) {
        if (featOkTst && casFeat_featureLabels == null)
      jcas.throwFeatMissing("featureLabels", "org.oaqa.model.answer.AnswerList");
    return ll_cas.ll_getRefValue(addr, casFeatCode_featureLabels);
  }
  /** @generated */    
  public void setFeatureLabels(int addr, int v) {
        if (featOkTst && casFeat_featureLabels == null)
      jcas.throwFeatMissing("featureLabels", "org.oaqa.model.answer.AnswerList");
    ll_cas.ll_setRefValue(addr, casFeatCode_featureLabels, v);}
    
   /** @generated */
  public String getFeatureLabels(int addr, int i) {
        if (featOkTst && casFeat_featureLabels == null)
      jcas.throwFeatMissing("featureLabels", "org.oaqa.model.answer.AnswerList");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_featureLabels), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_featureLabels), i);
	return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_featureLabels), i);
  }
   
  /** @generated */ 
  public void setFeatureLabels(int addr, int i, String v) {
        if (featOkTst && casFeat_featureLabels == null)
      jcas.throwFeatMissing("featureLabels", "org.oaqa.model.answer.AnswerList");
    if (lowLevelTypeChecks)
      ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_featureLabels), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_featureLabels), i);
    ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_featureLabels), i, v);
  }
 



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public AnswerList_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_answerList = jcas.getRequiredFeatureDE(casType, "answerList", "uima.cas.FSArray", featOkTst);
    casFeatCode_answerList  = (null == casFeat_answerList) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_answerList).getCode();

 
    casFeat_nilAnswer = jcas.getRequiredFeatureDE(casType, "nilAnswer", "uima.cas.Boolean", featOkTst);
    casFeatCode_nilAnswer  = (null == casFeat_nilAnswer) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_nilAnswer).getCode();

 
    casFeat_featureLabels = jcas.getRequiredFeatureDE(casType, "featureLabels", "uima.cas.StringArray", featOkTst);
    casFeatCode_featureLabels  = (null == casFeat_featureLabels) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_featureLabels).getCode();

  }
}



    