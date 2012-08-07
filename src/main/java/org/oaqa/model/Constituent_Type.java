
/* First created by JCasGen Wed Aug 01 12:12:46 EDT 2012 */
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

/** This type contains information for both token and phrase.
 * Updated by JCasGen Wed Aug 01 12:12:46 EDT 2012
 * @generated */
public class Constituent_Type extends Annotation_Type {
  /** @generated */
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Constituent_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Constituent_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Constituent(addr, Constituent_Type.this);
  			   Constituent_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Constituent(addr, Constituent_Type.this);
  	  }
    };
  /** @generated */
  public final static int typeIndexID = Constituent.typeIndexID;
  /** @generated 
     @modifiable */
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.oaqa.model.Constituent");
 
  /** @generated */
  final Feature casFeat_sequence;
  /** @generated */
  final int     casFeatCode_sequence;
  /** @generated */ 
  public int getSequence(int addr) {
        if (featOkTst && casFeat_sequence == null)
      jcas.throwFeatMissing("sequence", "org.oaqa.model.Constituent");
    return ll_cas.ll_getIntValue(addr, casFeatCode_sequence);
  }
  /** @generated */    
  public void setSequence(int addr, int v) {
        if (featOkTst && casFeat_sequence == null)
      jcas.throwFeatMissing("sequence", "org.oaqa.model.Constituent");
    ll_cas.ll_setIntValue(addr, casFeatCode_sequence, v);}
    
  
 
  /** @generated */
  final Feature casFeat_text;
  /** @generated */
  final int     casFeatCode_text;
  /** @generated */ 
  public String getText(int addr) {
        if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "org.oaqa.model.Constituent");
    return ll_cas.ll_getStringValue(addr, casFeatCode_text);
  }
  /** @generated */    
  public void setText(int addr, String v) {
        if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "org.oaqa.model.Constituent");
    ll_cas.ll_setStringValue(addr, casFeatCode_text, v);}
    
  
 
  /** @generated */
  final Feature casFeat_cType;
  /** @generated */
  final int     casFeatCode_cType;
  /** @generated */ 
  public int getCType(int addr) {
        if (featOkTst && casFeat_cType == null)
      jcas.throwFeatMissing("cType", "org.oaqa.model.Constituent");
    return ll_cas.ll_getIntValue(addr, casFeatCode_cType);
  }
  /** @generated */    
  public void setCType(int addr, int v) {
        if (featOkTst && casFeat_cType == null)
      jcas.throwFeatMissing("cType", "org.oaqa.model.Constituent");
    ll_cas.ll_setIntValue(addr, casFeatCode_cType, v);}
    
  
 
  /** @generated */
  final Feature casFeat_resources;
  /** @generated */
  final int     casFeatCode_resources;
  /** @generated */ 
  public int getResources(int addr) {
        if (featOkTst && casFeat_resources == null)
      jcas.throwFeatMissing("resources", "org.oaqa.model.Constituent");
    return ll_cas.ll_getRefValue(addr, casFeatCode_resources);
  }
  /** @generated */    
  public void setResources(int addr, int v) {
        if (featOkTst && casFeat_resources == null)
      jcas.throwFeatMissing("resources", "org.oaqa.model.Constituent");
    ll_cas.ll_setRefValue(addr, casFeatCode_resources, v);}
    
  
 
  /** @generated */
  final Feature casFeat_tags;
  /** @generated */
  final int     casFeatCode_tags;
  /** @generated */ 
  public int getTags(int addr) {
        if (featOkTst && casFeat_tags == null)
      jcas.throwFeatMissing("tags", "org.oaqa.model.Constituent");
    return ll_cas.ll_getRefValue(addr, casFeatCode_tags);
  }
  /** @generated */    
  public void setTags(int addr, int v) {
        if (featOkTst && casFeat_tags == null)
      jcas.throwFeatMissing("tags", "org.oaqa.model.Constituent");
    ll_cas.ll_setRefValue(addr, casFeatCode_tags, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Constituent_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_sequence = jcas.getRequiredFeatureDE(casType, "sequence", "uima.cas.Integer", featOkTst);
    casFeatCode_sequence  = (null == casFeat_sequence) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_sequence).getCode();

 
    casFeat_text = jcas.getRequiredFeatureDE(casType, "text", "uima.cas.String", featOkTst);
    casFeatCode_text  = (null == casFeat_text) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_text).getCode();

 
    casFeat_cType = jcas.getRequiredFeatureDE(casType, "cType", "uima.cas.Integer", featOkTst);
    casFeatCode_cType  = (null == casFeat_cType) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_cType).getCode();

 
    casFeat_resources = jcas.getRequiredFeatureDE(casType, "resources", "uima.cas.FSList", featOkTst);
    casFeatCode_resources  = (null == casFeat_resources) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_resources).getCode();

 
    casFeat_tags = jcas.getRequiredFeatureDE(casType, "tags", "uima.cas.FSList", featOkTst);
    casFeatCode_tags  = (null == casFeat_tags) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_tags).getCode();

  }
}



    