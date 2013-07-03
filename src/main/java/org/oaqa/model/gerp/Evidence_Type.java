
/* First created by JCasGen Wed Jul 03 11:51:45 EDT 2013 */
package org.oaqa.model.gerp;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;

/** A type represents the evidence for the candidate entities, which is provided by an evidencer.
 * Updated by JCasGen Wed Jul 03 14:53:43 EDT 2013
 * @generated */
public class Evidence_Type extends GerpBase_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Evidence_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Evidence_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Evidence(addr, Evidence_Type.this);
  			   Evidence_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Evidence(addr, Evidence_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Evidence.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.oaqa.model.gerp.Evidence");
 
  /** @generated */
  final Feature casFeat_confidence;
  /** @generated */
  final int     casFeatCode_confidence;
  /** @generated */ 
  public float getConfidence(int addr) {
        if (featOkTst && casFeat_confidence == null)
      jcas.throwFeatMissing("confidence", "org.oaqa.model.gerp.Evidence");
    return ll_cas.ll_getFloatValue(addr, casFeatCode_confidence);
  }
  /** @generated */    
  public void setConfidence(int addr, float v) {
        if (featOkTst && casFeat_confidence == null)
      jcas.throwFeatMissing("confidence", "org.oaqa.model.gerp.Evidence");
    ll_cas.ll_setFloatValue(addr, casFeatCode_confidence, v);}
    
  
 
  /** @generated */
  final Feature casFeat_additionalEvidences;
  /** @generated */
  final int     casFeatCode_additionalEvidences;
  /** @generated */ 
  public int getAdditionalEvidences(int addr) {
        if (featOkTst && casFeat_additionalEvidences == null)
      jcas.throwFeatMissing("additionalEvidences", "org.oaqa.model.gerp.Evidence");
    return ll_cas.ll_getRefValue(addr, casFeatCode_additionalEvidences);
  }
  /** @generated */    
  public void setAdditionalEvidences(int addr, int v) {
        if (featOkTst && casFeat_additionalEvidences == null)
      jcas.throwFeatMissing("additionalEvidences", "org.oaqa.model.gerp.Evidence");
    ll_cas.ll_setRefValue(addr, casFeatCode_additionalEvidences, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Evidence_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_confidence = jcas.getRequiredFeatureDE(casType, "confidence", "uima.cas.Float", featOkTst);
    casFeatCode_confidence  = (null == casFeat_confidence) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_confidence).getCode();

 
    casFeat_additionalEvidences = jcas.getRequiredFeatureDE(casType, "additionalEvidences", "uima.cas.FSList", featOkTst);
    casFeatCode_additionalEvidences  = (null == casFeat_additionalEvidences) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_additionalEvidences).getCode();

  }
}



    