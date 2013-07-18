
/* First created by JCasGen Mon Jul 08 17:12:14 EDT 2013 */
package org.oaqa.model.kb;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.oaqa.model.gerp.GerpTop_Type;

/** A superclass for EntityConcept and RelationConcept.
 * Updated by JCasGen Thu Jul 18 17:30:38 EDT 2013
 * @generated */
public class Concept_Type extends GerpTop_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Concept_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Concept_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Concept(addr, Concept_Type.this);
  			   Concept_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Concept(addr, Concept_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Concept.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.oaqa.model.kb.Concept");
 
  /** @generated */
  final Feature casFeat_name;
  /** @generated */
  final int     casFeatCode_name;
  /** @generated */ 
  public String getName(int addr) {
        if (featOkTst && casFeat_name == null)
      jcas.throwFeatMissing("name", "org.oaqa.model.kb.Concept");
    return ll_cas.ll_getStringValue(addr, casFeatCode_name);
  }
  /** @generated */    
  public void setName(int addr, String v) {
        if (featOkTst && casFeat_name == null)
      jcas.throwFeatMissing("name", "org.oaqa.model.kb.Concept");
    ll_cas.ll_setStringValue(addr, casFeatCode_name, v);}
    
  
 
  /** @generated */
  final Feature casFeat_ids;
  /** @generated */
  final int     casFeatCode_ids;
  /** @generated */ 
  public int getIds(int addr) {
        if (featOkTst && casFeat_ids == null)
      jcas.throwFeatMissing("ids", "org.oaqa.model.kb.Concept");
    return ll_cas.ll_getRefValue(addr, casFeatCode_ids);
  }
  /** @generated */    
  public void setIds(int addr, int v) {
        if (featOkTst && casFeat_ids == null)
      jcas.throwFeatMissing("ids", "org.oaqa.model.kb.Concept");
    ll_cas.ll_setRefValue(addr, casFeatCode_ids, v);}
    
  
 
  /** @generated */
  final Feature casFeat_mentions;
  /** @generated */
  final int     casFeatCode_mentions;
  /** @generated */ 
  public int getMentions(int addr) {
        if (featOkTst && casFeat_mentions == null)
      jcas.throwFeatMissing("mentions", "org.oaqa.model.kb.Concept");
    return ll_cas.ll_getRefValue(addr, casFeatCode_mentions);
  }
  /** @generated */    
  public void setMentions(int addr, int v) {
        if (featOkTst && casFeat_mentions == null)
      jcas.throwFeatMissing("mentions", "org.oaqa.model.kb.Concept");
    ll_cas.ll_setRefValue(addr, casFeatCode_mentions, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Concept_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_name = jcas.getRequiredFeatureDE(casType, "name", "uima.cas.String", featOkTst);
    casFeatCode_name  = (null == casFeat_name) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_name).getCode();

 
    casFeat_ids = jcas.getRequiredFeatureDE(casType, "ids", "uima.cas.StringList", featOkTst);
    casFeatCode_ids  = (null == casFeat_ids) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_ids).getCode();

 
    casFeat_mentions = jcas.getRequiredFeatureDE(casType, "mentions", "uima.cas.FSList", featOkTst);
    casFeatCode_mentions  = (null == casFeat_mentions) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_mentions).getCode();

  }
}



    