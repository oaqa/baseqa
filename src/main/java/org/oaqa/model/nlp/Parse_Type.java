
/* First created by JCasGen Mon Jul 08 17:12:14 EDT 2013 */
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
import org.oaqa.model.gerp.GerpTop_Type;

/** A data structure that represents various NLP annotations from a parser, e.g. lists of tokens, semantic roles, etc.
 * Updated by JCasGen Mon Jul 29 18:17:35 EDT 2013
 * @generated */
public class Parse_Type extends GerpTop_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Parse_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Parse_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Parse(addr, Parse_Type.this);
  			   Parse_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Parse(addr, Parse_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Parse.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.oaqa.model.nlp.Parse");
 
  /** @generated */
  final Feature casFeat_tokens;
  /** @generated */
  final int     casFeatCode_tokens;
  /** @generated */ 
  public int getTokens(int addr) {
        if (featOkTst && casFeat_tokens == null)
      jcas.throwFeatMissing("tokens", "org.oaqa.model.nlp.Parse");
    return ll_cas.ll_getRefValue(addr, casFeatCode_tokens);
  }
  /** @generated */    
  public void setTokens(int addr, int v) {
        if (featOkTst && casFeat_tokens == null)
      jcas.throwFeatMissing("tokens", "org.oaqa.model.nlp.Parse");
    ll_cas.ll_setRefValue(addr, casFeatCode_tokens, v);}
    
  
 
  /** @generated */
  final Feature casFeat_semanticRoles;
  /** @generated */
  final int     casFeatCode_semanticRoles;
  /** @generated */ 
  public int getSemanticRoles(int addr) {
        if (featOkTst && casFeat_semanticRoles == null)
      jcas.throwFeatMissing("semanticRoles", "org.oaqa.model.nlp.Parse");
    return ll_cas.ll_getRefValue(addr, casFeatCode_semanticRoles);
  }
  /** @generated */    
  public void setSemanticRoles(int addr, int v) {
        if (featOkTst && casFeat_semanticRoles == null)
      jcas.throwFeatMissing("semanticRoles", "org.oaqa.model.nlp.Parse");
    ll_cas.ll_setRefValue(addr, casFeatCode_semanticRoles, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Parse_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_tokens = jcas.getRequiredFeatureDE(casType, "tokens", "uima.cas.FSList", featOkTst);
    casFeatCode_tokens  = (null == casFeat_tokens) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_tokens).getCode();

 
    casFeat_semanticRoles = jcas.getRequiredFeatureDE(casType, "semanticRoles", "uima.cas.FSList", featOkTst);
    casFeatCode_semanticRoles  = (null == casFeat_semanticRoles) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_semanticRoles).getCode();

  }
}



    