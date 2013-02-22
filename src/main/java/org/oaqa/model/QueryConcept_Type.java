
/* First created by JCasGen Thu Feb 21 16:50:37 EST 2013 */
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

/** A query concept in the abstract search query model.
 * Updated by JCasGen Thu Feb 21 16:50:37 EST 2013
 * @generated */
public class QueryConcept_Type extends OAQATop_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (QueryConcept_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = QueryConcept_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new QueryConcept(addr, QueryConcept_Type.this);
  			   QueryConcept_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new QueryConcept(addr, QueryConcept_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = QueryConcept.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.oaqa.model.QueryConcept");
 
  /** @generated */
  final Feature casFeat_neTypes;
  /** @generated */
  final int     casFeatCode_neTypes;
  /** @generated */ 
  public int getNeTypes(int addr) {
        if (featOkTst && casFeat_neTypes == null)
      jcas.throwFeatMissing("neTypes", "org.oaqa.model.QueryConcept");
    return ll_cas.ll_getRefValue(addr, casFeatCode_neTypes);
  }
  /** @generated */    
  public void setNeTypes(int addr, int v) {
        if (featOkTst && casFeat_neTypes == null)
      jcas.throwFeatMissing("neTypes", "org.oaqa.model.QueryConcept");
    ll_cas.ll_setRefValue(addr, casFeatCode_neTypes, v);}
    
  
 
  /** @generated */
  final Feature casFeat_conceptType;
  /** @generated */
  final int     casFeatCode_conceptType;
  /** @generated */ 
  public String getConceptType(int addr) {
        if (featOkTst && casFeat_conceptType == null)
      jcas.throwFeatMissing("conceptType", "org.oaqa.model.QueryConcept");
    return ll_cas.ll_getStringValue(addr, casFeatCode_conceptType);
  }
  /** @generated */    
  public void setConceptType(int addr, String v) {
        if (featOkTst && casFeat_conceptType == null)
      jcas.throwFeatMissing("conceptType", "org.oaqa.model.QueryConcept");
    ll_cas.ll_setStringValue(addr, casFeatCode_conceptType, v);}
    
  
 
  /** @generated */
  final Feature casFeat_text;
  /** @generated */
  final int     casFeatCode_text;
  /** @generated */ 
  public String getText(int addr) {
        if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "org.oaqa.model.QueryConcept");
    return ll_cas.ll_getStringValue(addr, casFeatCode_text);
  }
  /** @generated */    
  public void setText(int addr, String v) {
        if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "org.oaqa.model.QueryConcept");
    ll_cas.ll_setStringValue(addr, casFeatCode_text, v);}
    
  
 
  /** @generated */
  final Feature casFeat_originalText;
  /** @generated */
  final int     casFeatCode_originalText;
  /** @generated */ 
  public String getOriginalText(int addr) {
        if (featOkTst && casFeat_originalText == null)
      jcas.throwFeatMissing("originalText", "org.oaqa.model.QueryConcept");
    return ll_cas.ll_getStringValue(addr, casFeatCode_originalText);
  }
  /** @generated */    
  public void setOriginalText(int addr, String v) {
        if (featOkTst && casFeat_originalText == null)
      jcas.throwFeatMissing("originalText", "org.oaqa.model.QueryConcept");
    ll_cas.ll_setStringValue(addr, casFeatCode_originalText, v);}
    
  
 
  /** @generated */
  final Feature casFeat_operator;
  /** @generated */
  final int     casFeatCode_operator;
  /** @generated */ 
  public int getOperator(int addr) {
        if (featOkTst && casFeat_operator == null)
      jcas.throwFeatMissing("operator", "org.oaqa.model.QueryConcept");
    return ll_cas.ll_getRefValue(addr, casFeatCode_operator);
  }
  /** @generated */    
  public void setOperator(int addr, int v) {
        if (featOkTst && casFeat_operator == null)
      jcas.throwFeatMissing("operator", "org.oaqa.model.QueryConcept");
    ll_cas.ll_setRefValue(addr, casFeatCode_operator, v);}
    
  
 
  /** @generated */
  final Feature casFeat_operatorArgs;
  /** @generated */
  final int     casFeatCode_operatorArgs;
  /** @generated */ 
  public int getOperatorArgs(int addr) {
        if (featOkTst && casFeat_operatorArgs == null)
      jcas.throwFeatMissing("operatorArgs", "org.oaqa.model.QueryConcept");
    return ll_cas.ll_getRefValue(addr, casFeatCode_operatorArgs);
  }
  /** @generated */    
  public void setOperatorArgs(int addr, int v) {
        if (featOkTst && casFeat_operatorArgs == null)
      jcas.throwFeatMissing("operatorArgs", "org.oaqa.model.QueryConcept");
    ll_cas.ll_setRefValue(addr, casFeatCode_operatorArgs, v);}
    
  
 
  /** @generated */
  final Feature casFeat_pos;
  /** @generated */
  final int     casFeatCode_pos;
  /** @generated */ 
  public int getPos(int addr) {
        if (featOkTst && casFeat_pos == null)
      jcas.throwFeatMissing("pos", "org.oaqa.model.QueryConcept");
    return ll_cas.ll_getIntValue(addr, casFeatCode_pos);
  }
  /** @generated */    
  public void setPos(int addr, int v) {
        if (featOkTst && casFeat_pos == null)
      jcas.throwFeatMissing("pos", "org.oaqa.model.QueryConcept");
    ll_cas.ll_setIntValue(addr, casFeatCode_pos, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public QueryConcept_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_neTypes = jcas.getRequiredFeatureDE(casType, "neTypes", "uima.cas.StringList", featOkTst);
    casFeatCode_neTypes  = (null == casFeat_neTypes) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_neTypes).getCode();

 
    casFeat_conceptType = jcas.getRequiredFeatureDE(casType, "conceptType", "org.oaqa.model.ConceptType", featOkTst);
    casFeatCode_conceptType  = (null == casFeat_conceptType) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_conceptType).getCode();

 
    casFeat_text = jcas.getRequiredFeatureDE(casType, "text", "uima.cas.String", featOkTst);
    casFeatCode_text  = (null == casFeat_text) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_text).getCode();

 
    casFeat_originalText = jcas.getRequiredFeatureDE(casType, "originalText", "uima.cas.String", featOkTst);
    casFeatCode_originalText  = (null == casFeat_originalText) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_originalText).getCode();

 
    casFeat_operator = jcas.getRequiredFeatureDE(casType, "operator", "org.oaqa.model.QueryOperator", featOkTst);
    casFeatCode_operator  = (null == casFeat_operator) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_operator).getCode();

 
    casFeat_operatorArgs = jcas.getRequiredFeatureDE(casType, "operatorArgs", "uima.cas.FSList", featOkTst);
    casFeatCode_operatorArgs  = (null == casFeat_operatorArgs) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_operatorArgs).getCode();

 
    casFeat_pos = jcas.getRequiredFeatureDE(casType, "pos", "uima.cas.Integer", featOkTst);
    casFeatCode_pos  = (null == casFeat_pos) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_pos).getCode();

  }
}



    