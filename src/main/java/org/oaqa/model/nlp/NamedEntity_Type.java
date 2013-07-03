
/* First created by JCasGen Wed Jul 03 11:52:04 EDT 2013 */
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

/** A named entity with one or more URIs that identify or define the named entity.  The URIs could reference any source that defines or disambiguates the named entity.
 * Updated by JCasGen Wed Jul 03 15:44:17 EDT 2013
 * @generated */
public class NamedEntity_Type extends GerpAnnotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (NamedEntity_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = NamedEntity_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new NamedEntity(addr, NamedEntity_Type.this);
  			   NamedEntity_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new NamedEntity(addr, NamedEntity_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = NamedEntity.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.oaqa.model.nlp.NamedEntity");
 
  /** @generated */
  final Feature casFeat_ids;
  /** @generated */
  final int     casFeatCode_ids;
  /** @generated */ 
  public int getIds(int addr) {
        if (featOkTst && casFeat_ids == null)
      jcas.throwFeatMissing("ids", "org.oaqa.model.nlp.NamedEntity");
    return ll_cas.ll_getRefValue(addr, casFeatCode_ids);
  }
  /** @generated */    
  public void setIds(int addr, int v) {
        if (featOkTst && casFeat_ids == null)
      jcas.throwFeatMissing("ids", "org.oaqa.model.nlp.NamedEntity");
    ll_cas.ll_setRefValue(addr, casFeatCode_ids, v);}
    
   /** @generated */
  public String getIds(int addr, int i) {
        if (featOkTst && casFeat_ids == null)
      jcas.throwFeatMissing("ids", "org.oaqa.model.nlp.NamedEntity");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_ids), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_ids), i);
  return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_ids), i);
  }
   
  /** @generated */ 
  public void setIds(int addr, int i, String v) {
        if (featOkTst && casFeat_ids == null)
      jcas.throwFeatMissing("ids", "org.oaqa.model.nlp.NamedEntity");
    if (lowLevelTypeChecks)
      ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_ids), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_ids), i);
    ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_ids), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_context;
  /** @generated */
  final int     casFeatCode_context;
  /** @generated */ 
  public int getContext(int addr) {
        if (featOkTst && casFeat_context == null)
      jcas.throwFeatMissing("context", "org.oaqa.model.nlp.NamedEntity");
    return ll_cas.ll_getRefValue(addr, casFeatCode_context);
  }
  /** @generated */    
  public void setContext(int addr, int v) {
        if (featOkTst && casFeat_context == null)
      jcas.throwFeatMissing("context", "org.oaqa.model.nlp.NamedEntity");
    ll_cas.ll_setRefValue(addr, casFeatCode_context, v);}
    
   /** @generated */
  public int getContext(int addr, int i) {
        if (featOkTst && casFeat_context == null)
      jcas.throwFeatMissing("context", "org.oaqa.model.nlp.NamedEntity");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_context), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_context), i);
  return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_context), i);
  }
   
  /** @generated */ 
  public void setContext(int addr, int i, int v) {
        if (featOkTst && casFeat_context == null)
      jcas.throwFeatMissing("context", "org.oaqa.model.nlp.NamedEntity");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_context), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_context), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_context), i, v);
  }
 



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public NamedEntity_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_ids = jcas.getRequiredFeatureDE(casType, "ids", "uima.cas.StringArray", featOkTst);
    casFeatCode_ids  = (null == casFeat_ids) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_ids).getCode();

 
    casFeat_context = jcas.getRequiredFeatureDE(casType, "context", "uima.cas.FSArray", featOkTst);
    casFeatCode_context  = (null == casFeat_context) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_context).getCode();

  }
}



    