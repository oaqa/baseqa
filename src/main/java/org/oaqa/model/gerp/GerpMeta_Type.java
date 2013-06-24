
/* First created by JCasGen Mon Jun 24 14:02:20 EDT 2013 */
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
import org.oaqa.model.core.OAQATop_Type;

/** A GERP-style component type, which contains some generators, evidencers, rankers and pruners, that capture the common metadata shared across the feature structures (GerpTops and GerpAnnotations) to be generated in the component, e.g. the name of all generators, evidencers, rankers and pruners.
 * Updated by JCasGen Mon Jun 24 14:02:20 EDT 2013
 * @generated */
public class GerpMeta_Type extends OAQATop_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (GerpMeta_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = GerpMeta_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new GerpMeta(addr, GerpMeta_Type.this);
  			   GerpMeta_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new GerpMeta(addr, GerpMeta_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = GerpMeta.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.oaqa.model.gerp.GerpMeta");
 
  /** @generated */
  final Feature casFeat_generators;
  /** @generated */
  final int     casFeatCode_generators;
  /** @generated */ 
  public int getGenerators(int addr) {
        if (featOkTst && casFeat_generators == null)
      jcas.throwFeatMissing("generators", "org.oaqa.model.gerp.GerpMeta");
    return ll_cas.ll_getRefValue(addr, casFeatCode_generators);
  }
  /** @generated */    
  public void setGenerators(int addr, int v) {
        if (featOkTst && casFeat_generators == null)
      jcas.throwFeatMissing("generators", "org.oaqa.model.gerp.GerpMeta");
    ll_cas.ll_setRefValue(addr, casFeatCode_generators, v);}
    
   /** @generated */
  public String getGenerators(int addr, int i) {
        if (featOkTst && casFeat_generators == null)
      jcas.throwFeatMissing("generators", "org.oaqa.model.gerp.GerpMeta");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_generators), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_generators), i);
	return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_generators), i);
  }
   
  /** @generated */ 
  public void setGenerators(int addr, int i, String v) {
        if (featOkTst && casFeat_generators == null)
      jcas.throwFeatMissing("generators", "org.oaqa.model.gerp.GerpMeta");
    if (lowLevelTypeChecks)
      ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_generators), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_generators), i);
    ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_generators), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_evidencers;
  /** @generated */
  final int     casFeatCode_evidencers;
  /** @generated */ 
  public int getEvidencers(int addr) {
        if (featOkTst && casFeat_evidencers == null)
      jcas.throwFeatMissing("evidencers", "org.oaqa.model.gerp.GerpMeta");
    return ll_cas.ll_getRefValue(addr, casFeatCode_evidencers);
  }
  /** @generated */    
  public void setEvidencers(int addr, int v) {
        if (featOkTst && casFeat_evidencers == null)
      jcas.throwFeatMissing("evidencers", "org.oaqa.model.gerp.GerpMeta");
    ll_cas.ll_setRefValue(addr, casFeatCode_evidencers, v);}
    
   /** @generated */
  public String getEvidencers(int addr, int i) {
        if (featOkTst && casFeat_evidencers == null)
      jcas.throwFeatMissing("evidencers", "org.oaqa.model.gerp.GerpMeta");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_evidencers), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_evidencers), i);
	return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_evidencers), i);
  }
   
  /** @generated */ 
  public void setEvidencers(int addr, int i, String v) {
        if (featOkTst && casFeat_evidencers == null)
      jcas.throwFeatMissing("evidencers", "org.oaqa.model.gerp.GerpMeta");
    if (lowLevelTypeChecks)
      ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_evidencers), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_evidencers), i);
    ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_evidencers), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_rankers;
  /** @generated */
  final int     casFeatCode_rankers;
  /** @generated */ 
  public int getRankers(int addr) {
        if (featOkTst && casFeat_rankers == null)
      jcas.throwFeatMissing("rankers", "org.oaqa.model.gerp.GerpMeta");
    return ll_cas.ll_getRefValue(addr, casFeatCode_rankers);
  }
  /** @generated */    
  public void setRankers(int addr, int v) {
        if (featOkTst && casFeat_rankers == null)
      jcas.throwFeatMissing("rankers", "org.oaqa.model.gerp.GerpMeta");
    ll_cas.ll_setRefValue(addr, casFeatCode_rankers, v);}
    
   /** @generated */
  public String getRankers(int addr, int i) {
        if (featOkTst && casFeat_rankers == null)
      jcas.throwFeatMissing("rankers", "org.oaqa.model.gerp.GerpMeta");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_rankers), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_rankers), i);
	return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_rankers), i);
  }
   
  /** @generated */ 
  public void setRankers(int addr, int i, String v) {
        if (featOkTst && casFeat_rankers == null)
      jcas.throwFeatMissing("rankers", "org.oaqa.model.gerp.GerpMeta");
    if (lowLevelTypeChecks)
      ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_rankers), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_rankers), i);
    ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_rankers), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_pruners;
  /** @generated */
  final int     casFeatCode_pruners;
  /** @generated */ 
  public int getPruners(int addr) {
        if (featOkTst && casFeat_pruners == null)
      jcas.throwFeatMissing("pruners", "org.oaqa.model.gerp.GerpMeta");
    return ll_cas.ll_getRefValue(addr, casFeatCode_pruners);
  }
  /** @generated */    
  public void setPruners(int addr, int v) {
        if (featOkTst && casFeat_pruners == null)
      jcas.throwFeatMissing("pruners", "org.oaqa.model.gerp.GerpMeta");
    ll_cas.ll_setRefValue(addr, casFeatCode_pruners, v);}
    
   /** @generated */
  public String getPruners(int addr, int i) {
        if (featOkTst && casFeat_pruners == null)
      jcas.throwFeatMissing("pruners", "org.oaqa.model.gerp.GerpMeta");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_pruners), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_pruners), i);
	return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_pruners), i);
  }
   
  /** @generated */ 
  public void setPruners(int addr, int i, String v) {
        if (featOkTst && casFeat_pruners == null)
      jcas.throwFeatMissing("pruners", "org.oaqa.model.gerp.GerpMeta");
    if (lowLevelTypeChecks)
      ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_pruners), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_pruners), i);
    ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_pruners), i, v);
  }
 



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public GerpMeta_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_generators = jcas.getRequiredFeatureDE(casType, "generators", "uima.cas.StringArray", featOkTst);
    casFeatCode_generators  = (null == casFeat_generators) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_generators).getCode();

 
    casFeat_evidencers = jcas.getRequiredFeatureDE(casType, "evidencers", "uima.cas.StringArray", featOkTst);
    casFeatCode_evidencers  = (null == casFeat_evidencers) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_evidencers).getCode();

 
    casFeat_rankers = jcas.getRequiredFeatureDE(casType, "rankers", "uima.cas.StringArray", featOkTst);
    casFeatCode_rankers  = (null == casFeat_rankers) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_rankers).getCode();

 
    casFeat_pruners = jcas.getRequiredFeatureDE(casType, "pruners", "uima.cas.StringArray", featOkTst);
    casFeatCode_pruners  = (null == casFeat_pruners) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_pruners).getCode();

  }
}



    