
/* First created by JCasGen Tue Mar 05 08:57:57 EST 2013 */
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
import org.apache.uima.jcas.tcas.Annotation_Type;

/** The Question Analysis supertype that defines the attributes common to all question analysis results.
 * Updated by JCasGen Tue Mar 05 08:57:57 EST 2013
 * @generated */
public class OAQAAnnotation_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (OAQAAnnotation_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = OAQAAnnotation_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new OAQAAnnotation(addr, OAQAAnnotation_Type.this);
  			   OAQAAnnotation_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new OAQAAnnotation(addr, OAQAAnnotation_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = OAQAAnnotation.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.oaqa.model.OAQAAnnotation");
 
  /** @generated */
  final Feature casFeat_componentId;
  /** @generated */
  final int     casFeatCode_componentId;
  /** @generated */ 
  public String getComponentId(int addr) {
        if (featOkTst && casFeat_componentId == null)
      jcas.throwFeatMissing("componentId", "org.oaqa.model.OAQAAnnotation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_componentId);
  }
  /** @generated */    
  public void setComponentId(int addr, String v) {
        if (featOkTst && casFeat_componentId == null)
      jcas.throwFeatMissing("componentId", "org.oaqa.model.OAQAAnnotation");
    ll_cas.ll_setStringValue(addr, casFeatCode_componentId, v);}
    
  
 
  /** @generated */
  final Feature casFeat_implementingWrapper;
  /** @generated */
  final int     casFeatCode_implementingWrapper;
  /** @generated */ 
  public String getImplementingWrapper(int addr) {
        if (featOkTst && casFeat_implementingWrapper == null)
      jcas.throwFeatMissing("implementingWrapper", "org.oaqa.model.OAQAAnnotation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_implementingWrapper);
  }
  /** @generated */    
  public void setImplementingWrapper(int addr, String v) {
        if (featOkTst && casFeat_implementingWrapper == null)
      jcas.throwFeatMissing("implementingWrapper", "org.oaqa.model.OAQAAnnotation");
    ll_cas.ll_setStringValue(addr, casFeatCode_implementingWrapper, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public OAQAAnnotation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_componentId = jcas.getRequiredFeatureDE(casType, "componentId", "uima.cas.String", featOkTst);
    casFeatCode_componentId  = (null == casFeat_componentId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_componentId).getCode();

 
    casFeat_implementingWrapper = jcas.getRequiredFeatureDE(casType, "implementingWrapper", "uima.cas.String", featOkTst);
    casFeatCode_implementingWrapper  = (null == casFeat_implementingWrapper) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_implementingWrapper).getCode();

  }
}



    