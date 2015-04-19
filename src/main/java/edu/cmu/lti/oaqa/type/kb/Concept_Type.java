
/* First created by JCasGen Sat Apr 11 19:49:33 EDT 2015 */
package edu.cmu.lti.oaqa.type.kb;

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

/** A superclass for EntityConcept and RelationConcept.
 * Updated by JCasGen Sun Apr 19 19:46:50 EDT 2015
 * @generated */
public class Concept_Type extends TOP_Type {
  /** @generated 
   * @return the generator for this type
   */
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
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.oaqa.type.kb.Concept");
 
  /** @generated */
  final Feature casFeat_names;
  /** @generated */
  final int     casFeatCode_names;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getNames(int addr) {
        if (featOkTst && casFeat_names == null)
      jcas.throwFeatMissing("names", "edu.cmu.lti.oaqa.type.kb.Concept");
    return ll_cas.ll_getRefValue(addr, casFeatCode_names);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setNames(int addr, int v) {
        if (featOkTst && casFeat_names == null)
      jcas.throwFeatMissing("names", "edu.cmu.lti.oaqa.type.kb.Concept");
    ll_cas.ll_setRefValue(addr, casFeatCode_names, v);}
    
  
 
  /** @generated */
  final Feature casFeat_uris;
  /** @generated */
  final int     casFeatCode_uris;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getUris(int addr) {
        if (featOkTst && casFeat_uris == null)
      jcas.throwFeatMissing("uris", "edu.cmu.lti.oaqa.type.kb.Concept");
    return ll_cas.ll_getRefValue(addr, casFeatCode_uris);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setUris(int addr, int v) {
        if (featOkTst && casFeat_uris == null)
      jcas.throwFeatMissing("uris", "edu.cmu.lti.oaqa.type.kb.Concept");
    ll_cas.ll_setRefValue(addr, casFeatCode_uris, v);}
    
  
 
  /** @generated */
  final Feature casFeat_ids;
  /** @generated */
  final int     casFeatCode_ids;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getIds(int addr) {
        if (featOkTst && casFeat_ids == null)
      jcas.throwFeatMissing("ids", "edu.cmu.lti.oaqa.type.kb.Concept");
    return ll_cas.ll_getRefValue(addr, casFeatCode_ids);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setIds(int addr, int v) {
        if (featOkTst && casFeat_ids == null)
      jcas.throwFeatMissing("ids", "edu.cmu.lti.oaqa.type.kb.Concept");
    ll_cas.ll_setRefValue(addr, casFeatCode_ids, v);}
    
  
 
  /** @generated */
  final Feature casFeat_mentions;
  /** @generated */
  final int     casFeatCode_mentions;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getMentions(int addr) {
        if (featOkTst && casFeat_mentions == null)
      jcas.throwFeatMissing("mentions", "edu.cmu.lti.oaqa.type.kb.Concept");
    return ll_cas.ll_getRefValue(addr, casFeatCode_mentions);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setMentions(int addr, int v) {
        if (featOkTst && casFeat_mentions == null)
      jcas.throwFeatMissing("mentions", "edu.cmu.lti.oaqa.type.kb.Concept");
    ll_cas.ll_setRefValue(addr, casFeatCode_mentions, v);}
    
  
 
  /** @generated */
  final Feature casFeat_types;
  /** @generated */
  final int     casFeatCode_types;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getTypes(int addr) {
        if (featOkTst && casFeat_types == null)
      jcas.throwFeatMissing("types", "edu.cmu.lti.oaqa.type.kb.Concept");
    return ll_cas.ll_getRefValue(addr, casFeatCode_types);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setTypes(int addr, int v) {
        if (featOkTst && casFeat_types == null)
      jcas.throwFeatMissing("types", "edu.cmu.lti.oaqa.type.kb.Concept");
    ll_cas.ll_setRefValue(addr, casFeatCode_types, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Concept_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_names = jcas.getRequiredFeatureDE(casType, "names", "uima.cas.StringList", featOkTst);
    casFeatCode_names  = (null == casFeat_names) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_names).getCode();

 
    casFeat_uris = jcas.getRequiredFeatureDE(casType, "uris", "uima.cas.StringList", featOkTst);
    casFeatCode_uris  = (null == casFeat_uris) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_uris).getCode();

 
    casFeat_ids = jcas.getRequiredFeatureDE(casType, "ids", "uima.cas.StringList", featOkTst);
    casFeatCode_ids  = (null == casFeat_ids) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_ids).getCode();

 
    casFeat_mentions = jcas.getRequiredFeatureDE(casType, "mentions", "uima.cas.FSList", featOkTst);
    casFeatCode_mentions  = (null == casFeat_mentions) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_mentions).getCode();

 
    casFeat_types = jcas.getRequiredFeatureDE(casType, "types", "uima.cas.FSList", featOkTst);
    casFeatCode_types  = (null == casFeat_types) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_types).getCode();

  }
}



    