
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

/** A triple, e.g., and RDF triple.
 * Updated by JCasGen Fri Jan 18 20:41:49 EST 2013
 * @generated */
public class Triple_Type extends OAQATop_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Triple_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Triple_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Triple(addr, Triple_Type.this);
  			   Triple_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Triple(addr, Triple_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Triple.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.oaqa.model.Triple");
 
  /** @generated */
  final Feature casFeat_subject;
  /** @generated */
  final int     casFeatCode_subject;
  /** @generated */ 
  public String getSubject(int addr) {
        if (featOkTst && casFeat_subject == null)
      jcas.throwFeatMissing("subject", "org.oaqa.model.Triple");
    return ll_cas.ll_getStringValue(addr, casFeatCode_subject);
  }
  /** @generated */    
  public void setSubject(int addr, String v) {
        if (featOkTst && casFeat_subject == null)
      jcas.throwFeatMissing("subject", "org.oaqa.model.Triple");
    ll_cas.ll_setStringValue(addr, casFeatCode_subject, v);}
    
  
 
  /** @generated */
  final Feature casFeat_predicate;
  /** @generated */
  final int     casFeatCode_predicate;
  /** @generated */ 
  public String getPredicate(int addr) {
        if (featOkTst && casFeat_predicate == null)
      jcas.throwFeatMissing("predicate", "org.oaqa.model.Triple");
    return ll_cas.ll_getStringValue(addr, casFeatCode_predicate);
  }
  /** @generated */    
  public void setPredicate(int addr, String v) {
        if (featOkTst && casFeat_predicate == null)
      jcas.throwFeatMissing("predicate", "org.oaqa.model.Triple");
    ll_cas.ll_setStringValue(addr, casFeatCode_predicate, v);}
    
  
 
  /** @generated */
  final Feature casFeat_object;
  /** @generated */
  final int     casFeatCode_object;
  /** @generated */ 
  public String getObject(int addr) {
        if (featOkTst && casFeat_object == null)
      jcas.throwFeatMissing("object", "org.oaqa.model.Triple");
    return ll_cas.ll_getStringValue(addr, casFeatCode_object);
  }
  /** @generated */    
  public void setObject(int addr, String v) {
        if (featOkTst && casFeat_object == null)
      jcas.throwFeatMissing("object", "org.oaqa.model.Triple");
    ll_cas.ll_setStringValue(addr, casFeatCode_object, v);}
    
  
 
  /** @generated */
  final Feature casFeat_isObjUri;
  /** @generated */
  final int     casFeatCode_isObjUri;
  /** @generated */ 
  public boolean getIsObjUri(int addr) {
        if (featOkTst && casFeat_isObjUri == null)
      jcas.throwFeatMissing("isObjUri", "org.oaqa.model.Triple");
    return ll_cas.ll_getBooleanValue(addr, casFeatCode_isObjUri);
  }
  /** @generated */    
  public void setIsObjUri(int addr, boolean v) {
        if (featOkTst && casFeat_isObjUri == null)
      jcas.throwFeatMissing("isObjUri", "org.oaqa.model.Triple");
    ll_cas.ll_setBooleanValue(addr, casFeatCode_isObjUri, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Triple_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_subject = jcas.getRequiredFeatureDE(casType, "subject", "uima.cas.String", featOkTst);
    casFeatCode_subject  = (null == casFeat_subject) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_subject).getCode();

 
    casFeat_predicate = jcas.getRequiredFeatureDE(casType, "predicate", "uima.cas.String", featOkTst);
    casFeatCode_predicate  = (null == casFeat_predicate) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_predicate).getCode();

 
    casFeat_object = jcas.getRequiredFeatureDE(casType, "object", "uima.cas.String", featOkTst);
    casFeatCode_object  = (null == casFeat_object) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_object).getCode();

 
    casFeat_isObjUri = jcas.getRequiredFeatureDE(casType, "isObjUri", "uima.cas.Boolean", featOkTst);
    casFeatCode_isObjUri  = (null == casFeat_isObjUri) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_isObjUri).getCode();

  }
}



    