
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
import org.apache.uima.jcas.cas.TOP_Type;

/** The base class for OAQA feature structures that are not Annotations.
 * Updated by JCasGen Thu Oct 11 12:34:48 EDT 2012
 * @generated */
public class OAQATop_Type extends TOP_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (OAQATop_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = OAQATop_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new OAQATop(addr, OAQATop_Type.this);
  			   OAQATop_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new OAQATop(addr, OAQATop_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = OAQATop.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.oaqa.model.OAQATop");
 
  /** @generated */
  final Feature casFeat_componentId;
  /** @generated */
  final int     casFeatCode_componentId;
  /** @generated */ 
  public String getComponentId(int addr) {
        if (featOkTst && casFeat_componentId == null)
      jcas.throwFeatMissing("componentId", "org.oaqa.model.OAQATop");
    return ll_cas.ll_getStringValue(addr, casFeatCode_componentId);
  }
  /** @generated */    
  public void setComponentId(int addr, String v) {
        if (featOkTst && casFeat_componentId == null)
      jcas.throwFeatMissing("componentId", "org.oaqa.model.OAQATop");
    ll_cas.ll_setStringValue(addr, casFeatCode_componentId, v);}
    
  
 
  /** @generated */
  final Feature casFeat_probability;
  /** @generated */
  final int     casFeatCode_probability;
  /** @generated */ 
  public float getProbability(int addr) {
        if (featOkTst && casFeat_probability == null)
      jcas.throwFeatMissing("probability", "org.oaqa.model.OAQATop");
    return ll_cas.ll_getFloatValue(addr, casFeatCode_probability);
  }
  /** @generated */    
  public void setProbability(int addr, float v) {
        if (featOkTst && casFeat_probability == null)
      jcas.throwFeatMissing("probability", "org.oaqa.model.OAQATop");
    ll_cas.ll_setFloatValue(addr, casFeatCode_probability, v);}
    
  
 
  /** @generated */
  final Feature casFeat_implementingWrapper;
  /** @generated */
  final int     casFeatCode_implementingWrapper;
  /** @generated */ 
  public String getImplementingWrapper(int addr) {
        if (featOkTst && casFeat_implementingWrapper == null)
      jcas.throwFeatMissing("implementingWrapper", "org.oaqa.model.OAQATop");
    return ll_cas.ll_getStringValue(addr, casFeatCode_implementingWrapper);
  }
  /** @generated */    
  public void setImplementingWrapper(int addr, String v) {
        if (featOkTst && casFeat_implementingWrapper == null)
      jcas.throwFeatMissing("implementingWrapper", "org.oaqa.model.OAQATop");
    ll_cas.ll_setStringValue(addr, casFeatCode_implementingWrapper, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public OAQATop_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_componentId = jcas.getRequiredFeatureDE(casType, "componentId", "uima.cas.String", featOkTst);
    casFeatCode_componentId  = (null == casFeat_componentId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_componentId).getCode();

 
    casFeat_probability = jcas.getRequiredFeatureDE(casType, "probability", "uima.cas.Float", featOkTst);
    casFeatCode_probability  = (null == casFeat_probability) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_probability).getCode();

 
    casFeat_implementingWrapper = jcas.getRequiredFeatureDE(casType, "implementingWrapper", "uima.cas.String", featOkTst);
    casFeatCode_implementingWrapper  = (null == casFeat_implementingWrapper) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_implementingWrapper).getCode();

  }
}



    