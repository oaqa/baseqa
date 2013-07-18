
/* First created by JCasGen Mon Jul 08 17:12:14 EDT 2013 */
package org.oaqa.model.nlp;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.oaqa.model.gerp.GerpAnnotation_Type;

/** A Named Entity type that represents the type of the answer being sought.
 * Updated by JCasGen Thu Jul 18 17:30:38 EDT 2013
 * @generated */
public class AnswerType_Type extends GerpAnnotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (AnswerType_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = AnswerType_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new AnswerType(addr, AnswerType_Type.this);
  			   AnswerType_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new AnswerType(addr, AnswerType_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = AnswerType.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.oaqa.model.nlp.AnswerType");
 
  /** @generated */
  final Feature casFeat_label;
  /** @generated */
  final int     casFeatCode_label;
  /** @generated */ 
  public String getLabel(int addr) {
        if (featOkTst && casFeat_label == null)
      jcas.throwFeatMissing("label", "org.oaqa.model.nlp.AnswerType");
    return ll_cas.ll_getStringValue(addr, casFeatCode_label);
  }
  /** @generated */    
  public void setLabel(int addr, String v) {
        if (featOkTst && casFeat_label == null)
      jcas.throwFeatMissing("label", "org.oaqa.model.nlp.AnswerType");
    ll_cas.ll_setStringValue(addr, casFeatCode_label, v);}
    
  
 
  /** @generated */
  final Feature casFeat_targetType;
  /** @generated */
  final int     casFeatCode_targetType;
  /** @generated */ 
  public int getTargetType(int addr) {
        if (featOkTst && casFeat_targetType == null)
      jcas.throwFeatMissing("targetType", "org.oaqa.model.nlp.AnswerType");
    return ll_cas.ll_getRefValue(addr, casFeatCode_targetType);
  }
  /** @generated */    
  public void setTargetType(int addr, int v) {
        if (featOkTst && casFeat_targetType == null)
      jcas.throwFeatMissing("targetType", "org.oaqa.model.nlp.AnswerType");
    ll_cas.ll_setRefValue(addr, casFeatCode_targetType, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public AnswerType_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_label = jcas.getRequiredFeatureDE(casType, "label", "uima.cas.String", featOkTst);
    casFeatCode_label  = (null == casFeat_label) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_label).getCode();

 
    casFeat_targetType = jcas.getRequiredFeatureDE(casType, "targetType", "uima.tcas.Annotation", featOkTst);
    casFeatCode_targetType  = (null == casFeat_targetType) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_targetType).getCode();

  }
}



    