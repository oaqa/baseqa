
/* First created by JCasGen Mon Jun 24 14:02:20 EDT 2013 */
package org.oaqa.model.retrieval;

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

/** A query concept in the abstract search query model.
 * Updated by JCasGen Sat Jun 29 17:56:00 EDT 2013
 * @generated */
public class QueryConcept_Type extends GerpTop_Type {
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
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.oaqa.model.retrieval.QueryConcept");
 
  /** @generated */
  final Feature casFeat_namedEntityTypes;
  /** @generated */
  final int     casFeatCode_namedEntityTypes;
  /** @generated */ 
  public int getNamedEntityTypes(int addr) {
        if (featOkTst && casFeat_namedEntityTypes == null)
      jcas.throwFeatMissing("namedEntityTypes", "org.oaqa.model.retrieval.QueryConcept");
    return ll_cas.ll_getRefValue(addr, casFeatCode_namedEntityTypes);
  }
  /** @generated */    
  public void setNamedEntityTypes(int addr, int v) {
        if (featOkTst && casFeat_namedEntityTypes == null)
      jcas.throwFeatMissing("namedEntityTypes", "org.oaqa.model.retrieval.QueryConcept");
    ll_cas.ll_setRefValue(addr, casFeatCode_namedEntityTypes, v);}
    
  
 
  /** @generated */
  final Feature casFeat_conceptType;
  /** @generated */
  final int     casFeatCode_conceptType;
  /** @generated */ 
  public String getConceptType(int addr) {
        if (featOkTst && casFeat_conceptType == null)
      jcas.throwFeatMissing("conceptType", "org.oaqa.model.retrieval.QueryConcept");
    return ll_cas.ll_getStringValue(addr, casFeatCode_conceptType);
  }
  /** @generated */    
  public void setConceptType(int addr, String v) {
        if (featOkTst && casFeat_conceptType == null)
      jcas.throwFeatMissing("conceptType", "org.oaqa.model.retrieval.QueryConcept");
    ll_cas.ll_setStringValue(addr, casFeatCode_conceptType, v);}
    
  
 
  /** @generated */
  final Feature casFeat_text;
  /** @generated */
  final int     casFeatCode_text;
  /** @generated */ 
  public String getText(int addr) {
        if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "org.oaqa.model.retrieval.QueryConcept");
    return ll_cas.ll_getStringValue(addr, casFeatCode_text);
  }
  /** @generated */    
  public void setText(int addr, String v) {
        if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "org.oaqa.model.retrieval.QueryConcept");
    ll_cas.ll_setStringValue(addr, casFeatCode_text, v);}
    
  
 
  /** @generated */
  final Feature casFeat_originalText;
  /** @generated */
  final int     casFeatCode_originalText;
  /** @generated */ 
  public String getOriginalText(int addr) {
        if (featOkTst && casFeat_originalText == null)
      jcas.throwFeatMissing("originalText", "org.oaqa.model.retrieval.QueryConcept");
    return ll_cas.ll_getStringValue(addr, casFeatCode_originalText);
  }
  /** @generated */    
  public void setOriginalText(int addr, String v) {
        if (featOkTst && casFeat_originalText == null)
      jcas.throwFeatMissing("originalText", "org.oaqa.model.retrieval.QueryConcept");
    ll_cas.ll_setStringValue(addr, casFeatCode_originalText, v);}
    
  
 
  /** @generated */
  final Feature casFeat_operator;
  /** @generated */
  final int     casFeatCode_operator;
  /** @generated */ 
  public int getOperator(int addr) {
        if (featOkTst && casFeat_operator == null)
      jcas.throwFeatMissing("operator", "org.oaqa.model.retrieval.QueryConcept");
    return ll_cas.ll_getRefValue(addr, casFeatCode_operator);
  }
  /** @generated */    
  public void setOperator(int addr, int v) {
        if (featOkTst && casFeat_operator == null)
      jcas.throwFeatMissing("operator", "org.oaqa.model.retrieval.QueryConcept");
    ll_cas.ll_setRefValue(addr, casFeatCode_operator, v);}
    
  
 
  /** @generated */
  final Feature casFeat_operatorArgs;
  /** @generated */
  final int     casFeatCode_operatorArgs;
  /** @generated */ 
  public int getOperatorArgs(int addr) {
        if (featOkTst && casFeat_operatorArgs == null)
      jcas.throwFeatMissing("operatorArgs", "org.oaqa.model.retrieval.QueryConcept");
    return ll_cas.ll_getRefValue(addr, casFeatCode_operatorArgs);
  }
  /** @generated */    
  public void setOperatorArgs(int addr, int v) {
        if (featOkTst && casFeat_operatorArgs == null)
      jcas.throwFeatMissing("operatorArgs", "org.oaqa.model.retrieval.QueryConcept");
    ll_cas.ll_setRefValue(addr, casFeatCode_operatorArgs, v);}
    
  
 
  /** @generated */
  final Feature casFeat_partOfSpeech;
  /** @generated */
  final int     casFeatCode_partOfSpeech;
  /** @generated */ 
  public String getPartOfSpeech(int addr) {
        if (featOkTst && casFeat_partOfSpeech == null)
      jcas.throwFeatMissing("partOfSpeech", "org.oaqa.model.retrieval.QueryConcept");
    return ll_cas.ll_getStringValue(addr, casFeatCode_partOfSpeech);
  }
  /** @generated */    
  public void setPartOfSpeech(int addr, String v) {
        if (featOkTst && casFeat_partOfSpeech == null)
      jcas.throwFeatMissing("partOfSpeech", "org.oaqa.model.retrieval.QueryConcept");
    ll_cas.ll_setStringValue(addr, casFeatCode_partOfSpeech, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public QueryConcept_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_namedEntityTypes = jcas.getRequiredFeatureDE(casType, "namedEntityTypes", "uima.cas.StringList", featOkTst);
    casFeatCode_namedEntityTypes  = (null == casFeat_namedEntityTypes) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_namedEntityTypes).getCode();

 
    casFeat_conceptType = jcas.getRequiredFeatureDE(casType, "conceptType", "org.oaqa.model.nlp.ConceptType", featOkTst);
    casFeatCode_conceptType  = (null == casFeat_conceptType) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_conceptType).getCode();

 
    casFeat_text = jcas.getRequiredFeatureDE(casType, "text", "uima.cas.String", featOkTst);
    casFeatCode_text  = (null == casFeat_text) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_text).getCode();

 
    casFeat_originalText = jcas.getRequiredFeatureDE(casType, "originalText", "uima.cas.String", featOkTst);
    casFeatCode_originalText  = (null == casFeat_originalText) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_originalText).getCode();

 
    casFeat_operator = jcas.getRequiredFeatureDE(casType, "operator", "org.oaqa.model.retrieval.QueryOperator", featOkTst);
    casFeatCode_operator  = (null == casFeat_operator) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_operator).getCode();

 
    casFeat_operatorArgs = jcas.getRequiredFeatureDE(casType, "operatorArgs", "uima.cas.FSList", featOkTst);
    casFeatCode_operatorArgs  = (null == casFeat_operatorArgs) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_operatorArgs).getCode();

 
    casFeat_partOfSpeech = jcas.getRequiredFeatureDE(casType, "partOfSpeech", "uima.cas.String", featOkTst);
    casFeatCode_partOfSpeech  = (null == casFeat_partOfSpeech) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_partOfSpeech).getCode();

  }
}



    