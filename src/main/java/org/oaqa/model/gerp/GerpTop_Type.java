
/* First created by JCasGen Mon Jul 08 17:12:14 EDT 2013 */
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

/** The base class for Gerp feature structures that are not Annotations, with G/E/E/P features defined.
 * Updated by JCasGen Mon Jul 29 18:17:35 EDT 2013
 * @generated */
public class GerpTop_Type extends OAQATop_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (GerpTop_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = GerpTop_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new GerpTop(addr, GerpTop_Type.this);
  			   GerpTop_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new GerpTop(addr, GerpTop_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = GerpTop.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.oaqa.model.gerp.GerpTop");
 
  /** @generated */
  final Feature casFeat_generators;
  /** @generated */
  final int     casFeatCode_generators;
  /** @generated */ 
  public int getGenerators(int addr) {
        if (featOkTst && casFeat_generators == null)
      jcas.throwFeatMissing("generators", "org.oaqa.model.gerp.GerpTop");
    return ll_cas.ll_getRefValue(addr, casFeatCode_generators);
  }
  /** @generated */    
  public void setGenerators(int addr, int v) {
        if (featOkTst && casFeat_generators == null)
      jcas.throwFeatMissing("generators", "org.oaqa.model.gerp.GerpTop");
    ll_cas.ll_setRefValue(addr, casFeatCode_generators, v);}
    
  
 
  /** @generated */
  final Feature casFeat_evidences;
  /** @generated */
  final int     casFeatCode_evidences;
  /** @generated */ 
  public int getEvidences(int addr) {
        if (featOkTst && casFeat_evidences == null)
      jcas.throwFeatMissing("evidences", "org.oaqa.model.gerp.GerpTop");
    return ll_cas.ll_getRefValue(addr, casFeatCode_evidences);
  }
  /** @generated */    
  public void setEvidences(int addr, int v) {
        if (featOkTst && casFeat_evidences == null)
      jcas.throwFeatMissing("evidences", "org.oaqa.model.gerp.GerpTop");
    ll_cas.ll_setRefValue(addr, casFeatCode_evidences, v);}
    
  
 
  /** @generated */
  final Feature casFeat_ranks;
  /** @generated */
  final int     casFeatCode_ranks;
  /** @generated */ 
  public int getRanks(int addr) {
        if (featOkTst && casFeat_ranks == null)
      jcas.throwFeatMissing("ranks", "org.oaqa.model.gerp.GerpTop");
    return ll_cas.ll_getRefValue(addr, casFeatCode_ranks);
  }
  /** @generated */    
  public void setRanks(int addr, int v) {
        if (featOkTst && casFeat_ranks == null)
      jcas.throwFeatMissing("ranks", "org.oaqa.model.gerp.GerpTop");
    ll_cas.ll_setRefValue(addr, casFeatCode_ranks, v);}
    
  
 
  /** @generated */
  final Feature casFeat_pruningDecisions;
  /** @generated */
  final int     casFeatCode_pruningDecisions;
  /** @generated */ 
  public int getPruningDecisions(int addr) {
        if (featOkTst && casFeat_pruningDecisions == null)
      jcas.throwFeatMissing("pruningDecisions", "org.oaqa.model.gerp.GerpTop");
    return ll_cas.ll_getRefValue(addr, casFeatCode_pruningDecisions);
  }
  /** @generated */    
  public void setPruningDecisions(int addr, int v) {
        if (featOkTst && casFeat_pruningDecisions == null)
      jcas.throwFeatMissing("pruningDecisions", "org.oaqa.model.gerp.GerpTop");
    ll_cas.ll_setRefValue(addr, casFeatCode_pruningDecisions, v);}
    
  
 
  /** @generated */
  final Feature casFeat_gerpMeta;
  /** @generated */
  final int     casFeatCode_gerpMeta;
  /** @generated */ 
  public int getGerpMeta(int addr) {
        if (featOkTst && casFeat_gerpMeta == null)
      jcas.throwFeatMissing("gerpMeta", "org.oaqa.model.gerp.GerpTop");
    return ll_cas.ll_getRefValue(addr, casFeatCode_gerpMeta);
  }
  /** @generated */    
  public void setGerpMeta(int addr, int v) {
        if (featOkTst && casFeat_gerpMeta == null)
      jcas.throwFeatMissing("gerpMeta", "org.oaqa.model.gerp.GerpTop");
    ll_cas.ll_setRefValue(addr, casFeatCode_gerpMeta, v);}
    
  
 
  /** @generated */
  final Feature casFeat_dependencies;
  /** @generated */
  final int     casFeatCode_dependencies;
  /** @generated */ 
  public int getDependencies(int addr) {
        if (featOkTst && casFeat_dependencies == null)
      jcas.throwFeatMissing("dependencies", "org.oaqa.model.gerp.GerpTop");
    return ll_cas.ll_getRefValue(addr, casFeatCode_dependencies);
  }
  /** @generated */    
  public void setDependencies(int addr, int v) {
        if (featOkTst && casFeat_dependencies == null)
      jcas.throwFeatMissing("dependencies", "org.oaqa.model.gerp.GerpTop");
    ll_cas.ll_setRefValue(addr, casFeatCode_dependencies, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public GerpTop_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_generators = jcas.getRequiredFeatureDE(casType, "generators", "uima.cas.StringList", featOkTst);
    casFeatCode_generators  = (null == casFeat_generators) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_generators).getCode();

 
    casFeat_evidences = jcas.getRequiredFeatureDE(casType, "evidences", "uima.cas.FSList", featOkTst);
    casFeatCode_evidences  = (null == casFeat_evidences) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_evidences).getCode();

 
    casFeat_ranks = jcas.getRequiredFeatureDE(casType, "ranks", "uima.cas.FSList", featOkTst);
    casFeatCode_ranks  = (null == casFeat_ranks) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_ranks).getCode();

 
    casFeat_pruningDecisions = jcas.getRequiredFeatureDE(casType, "pruningDecisions", "uima.cas.FSList", featOkTst);
    casFeatCode_pruningDecisions  = (null == casFeat_pruningDecisions) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_pruningDecisions).getCode();

 
    casFeat_gerpMeta = jcas.getRequiredFeatureDE(casType, "gerpMeta", "org.oaqa.model.gerp.GerpMeta", featOkTst);
    casFeatCode_gerpMeta  = (null == casFeat_gerpMeta) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_gerpMeta).getCode();

 
    casFeat_dependencies = jcas.getRequiredFeatureDE(casType, "dependencies", "uima.cas.FSList", featOkTst);
    casFeatCode_dependencies  = (null == casFeat_dependencies) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_dependencies).getCode();

  }
}



    