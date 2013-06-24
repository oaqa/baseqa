
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
import org.oaqa.model.core.OAQAAnnotation_Type;

/** A higher level supertype for all GERPified annotations that defines the common attributes (G/E/R/P).
 * Updated by JCasGen Mon Jun 24 14:02:20 EDT 2013
 * @generated */
public class GerpAnnotation_Type extends OAQAAnnotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (GerpAnnotation_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = GerpAnnotation_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new GerpAnnotation(addr, GerpAnnotation_Type.this);
  			   GerpAnnotation_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new GerpAnnotation(addr, GerpAnnotation_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = GerpAnnotation.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.oaqa.model.gerp.GerpAnnotation");
 
  /** @generated */
  final Feature casFeat_generators;
  /** @generated */
  final int     casFeatCode_generators;
  /** @generated */ 
  public int getGenerators(int addr) {
        if (featOkTst && casFeat_generators == null)
      jcas.throwFeatMissing("generators", "org.oaqa.model.gerp.GerpAnnotation");
    return ll_cas.ll_getRefValue(addr, casFeatCode_generators);
  }
  /** @generated */    
  public void setGenerators(int addr, int v) {
        if (featOkTst && casFeat_generators == null)
      jcas.throwFeatMissing("generators", "org.oaqa.model.gerp.GerpAnnotation");
    ll_cas.ll_setRefValue(addr, casFeatCode_generators, v);}
    
   /** @generated */
  public String getGenerators(int addr, int i) {
        if (featOkTst && casFeat_generators == null)
      jcas.throwFeatMissing("generators", "org.oaqa.model.gerp.GerpAnnotation");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_generators), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_generators), i);
	return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_generators), i);
  }
   
  /** @generated */ 
  public void setGenerators(int addr, int i, String v) {
        if (featOkTst && casFeat_generators == null)
      jcas.throwFeatMissing("generators", "org.oaqa.model.gerp.GerpAnnotation");
    if (lowLevelTypeChecks)
      ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_generators), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_generators), i);
    ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_generators), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_evidences;
  /** @generated */
  final int     casFeatCode_evidences;
  /** @generated */ 
  public int getEvidences(int addr) {
        if (featOkTst && casFeat_evidences == null)
      jcas.throwFeatMissing("evidences", "org.oaqa.model.gerp.GerpAnnotation");
    return ll_cas.ll_getRefValue(addr, casFeatCode_evidences);
  }
  /** @generated */    
  public void setEvidences(int addr, int v) {
        if (featOkTst && casFeat_evidences == null)
      jcas.throwFeatMissing("evidences", "org.oaqa.model.gerp.GerpAnnotation");
    ll_cas.ll_setRefValue(addr, casFeatCode_evidences, v);}
    
   /** @generated */
  public int getEvidences(int addr, int i) {
        if (featOkTst && casFeat_evidences == null)
      jcas.throwFeatMissing("evidences", "org.oaqa.model.gerp.GerpAnnotation");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_evidences), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_evidences), i);
	return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_evidences), i);
  }
   
  /** @generated */ 
  public void setEvidences(int addr, int i, int v) {
        if (featOkTst && casFeat_evidences == null)
      jcas.throwFeatMissing("evidences", "org.oaqa.model.gerp.GerpAnnotation");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_evidences), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_evidences), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_evidences), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_ranks;
  /** @generated */
  final int     casFeatCode_ranks;
  /** @generated */ 
  public int getRanks(int addr) {
        if (featOkTst && casFeat_ranks == null)
      jcas.throwFeatMissing("ranks", "org.oaqa.model.gerp.GerpAnnotation");
    return ll_cas.ll_getRefValue(addr, casFeatCode_ranks);
  }
  /** @generated */    
  public void setRanks(int addr, int v) {
        if (featOkTst && casFeat_ranks == null)
      jcas.throwFeatMissing("ranks", "org.oaqa.model.gerp.GerpAnnotation");
    ll_cas.ll_setRefValue(addr, casFeatCode_ranks, v);}
    
   /** @generated */
  public int getRanks(int addr, int i) {
        if (featOkTst && casFeat_ranks == null)
      jcas.throwFeatMissing("ranks", "org.oaqa.model.gerp.GerpAnnotation");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_ranks), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_ranks), i);
	return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_ranks), i);
  }
   
  /** @generated */ 
  public void setRanks(int addr, int i, int v) {
        if (featOkTst && casFeat_ranks == null)
      jcas.throwFeatMissing("ranks", "org.oaqa.model.gerp.GerpAnnotation");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_ranks), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_ranks), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_ranks), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_pruningDecisions;
  /** @generated */
  final int     casFeatCode_pruningDecisions;
  /** @generated */ 
  public int getPruningDecisions(int addr) {
        if (featOkTst && casFeat_pruningDecisions == null)
      jcas.throwFeatMissing("pruningDecisions", "org.oaqa.model.gerp.GerpAnnotation");
    return ll_cas.ll_getRefValue(addr, casFeatCode_pruningDecisions);
  }
  /** @generated */    
  public void setPruningDecisions(int addr, int v) {
        if (featOkTst && casFeat_pruningDecisions == null)
      jcas.throwFeatMissing("pruningDecisions", "org.oaqa.model.gerp.GerpAnnotation");
    ll_cas.ll_setRefValue(addr, casFeatCode_pruningDecisions, v);}
    
   /** @generated */
  public int getPruningDecisions(int addr, int i) {
        if (featOkTst && casFeat_pruningDecisions == null)
      jcas.throwFeatMissing("pruningDecisions", "org.oaqa.model.gerp.GerpAnnotation");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_pruningDecisions), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_pruningDecisions), i);
	return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_pruningDecisions), i);
  }
   
  /** @generated */ 
  public void setPruningDecisions(int addr, int i, int v) {
        if (featOkTst && casFeat_pruningDecisions == null)
      jcas.throwFeatMissing("pruningDecisions", "org.oaqa.model.gerp.GerpAnnotation");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_pruningDecisions), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_pruningDecisions), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_pruningDecisions), i, v);
  }
 



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public GerpAnnotation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_generators = jcas.getRequiredFeatureDE(casType, "generators", "uima.cas.StringArray", featOkTst);
    casFeatCode_generators  = (null == casFeat_generators) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_generators).getCode();

 
    casFeat_evidences = jcas.getRequiredFeatureDE(casType, "evidences", "uima.cas.FSArray", featOkTst);
    casFeatCode_evidences  = (null == casFeat_evidences) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_evidences).getCode();

 
    casFeat_ranks = jcas.getRequiredFeatureDE(casType, "ranks", "uima.cas.FSArray", featOkTst);
    casFeatCode_ranks  = (null == casFeat_ranks) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_ranks).getCode();

 
    casFeat_pruningDecisions = jcas.getRequiredFeatureDE(casType, "pruningDecisions", "uima.cas.FSArray", featOkTst);
    casFeatCode_pruningDecisions  = (null == casFeat_pruningDecisions) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_pruningDecisions).getCode();

  }
}



    