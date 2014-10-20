
/* First created by JCasGen Sun Oct 19 14:47:24 EDT 2014 */
package edu.cmu.lti.oaqa.type.nlp;

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

/** Annotation on a token, which may have arguments if they are predicates; useful in transforming text into a "logical form", with affordances similar to the ones provided in Extended WordNet and the like. --- Source: Murdock
 * Updated by JCasGen Sun Oct 19 14:47:24 EDT 2014
 * @generated */
public class Token_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Token_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Token_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Token(addr, Token_Type.this);
  			   Token_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Token(addr, Token_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Token.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.oaqa.type.nlp.Token");
 
  /** @generated */
  final Feature casFeat_arguments;
  /** @generated */
  final int     casFeatCode_arguments;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getArguments(int addr) {
        if (featOkTst && casFeat_arguments == null)
      jcas.throwFeatMissing("arguments", "edu.cmu.lti.oaqa.type.nlp.Token");
    return ll_cas.ll_getRefValue(addr, casFeatCode_arguments);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setArguments(int addr, int v) {
        if (featOkTst && casFeat_arguments == null)
      jcas.throwFeatMissing("arguments", "edu.cmu.lti.oaqa.type.nlp.Token");
    ll_cas.ll_setRefValue(addr, casFeatCode_arguments, v);}
    
   /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @return value at index i in the array 
   */
  public int getArguments(int addr, int i) {
        if (featOkTst && casFeat_arguments == null)
      jcas.throwFeatMissing("arguments", "edu.cmu.lti.oaqa.type.nlp.Token");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_arguments), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_arguments), i);
	return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_arguments), i);
  }
   
  /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @param v value to set
   */ 
  public void setArguments(int addr, int i, int v) {
        if (featOkTst && casFeat_arguments == null)
      jcas.throwFeatMissing("arguments", "edu.cmu.lti.oaqa.type.nlp.Token");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_arguments), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_arguments), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_arguments), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_argumentLabels;
  /** @generated */
  final int     casFeatCode_argumentLabels;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getArgumentLabels(int addr) {
        if (featOkTst && casFeat_argumentLabels == null)
      jcas.throwFeatMissing("argumentLabels", "edu.cmu.lti.oaqa.type.nlp.Token");
    return ll_cas.ll_getRefValue(addr, casFeatCode_argumentLabels);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setArgumentLabels(int addr, int v) {
        if (featOkTst && casFeat_argumentLabels == null)
      jcas.throwFeatMissing("argumentLabels", "edu.cmu.lti.oaqa.type.nlp.Token");
    ll_cas.ll_setRefValue(addr, casFeatCode_argumentLabels, v);}
    
   /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @return value at index i in the array 
   */
  public String getArgumentLabels(int addr, int i) {
        if (featOkTst && casFeat_argumentLabels == null)
      jcas.throwFeatMissing("argumentLabels", "edu.cmu.lti.oaqa.type.nlp.Token");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_argumentLabels), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_argumentLabels), i);
	return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_argumentLabels), i);
  }
   
  /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @param v value to set
   */ 
  public void setArgumentLabels(int addr, int i, String v) {
        if (featOkTst && casFeat_argumentLabels == null)
      jcas.throwFeatMissing("argumentLabels", "edu.cmu.lti.oaqa.type.nlp.Token");
    if (lowLevelTypeChecks)
      ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_argumentLabels), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_argumentLabels), i);
    ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_argumentLabels), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_parse;
  /** @generated */
  final int     casFeatCode_parse;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getParse(int addr) {
        if (featOkTst && casFeat_parse == null)
      jcas.throwFeatMissing("parse", "edu.cmu.lti.oaqa.type.nlp.Token");
    return ll_cas.ll_getRefValue(addr, casFeatCode_parse);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setParse(int addr, int v) {
        if (featOkTst && casFeat_parse == null)
      jcas.throwFeatMissing("parse", "edu.cmu.lti.oaqa.type.nlp.Token");
    ll_cas.ll_setRefValue(addr, casFeatCode_parse, v);}
    
  
 
  /** @generated */
  final Feature casFeat_semanticType;
  /** @generated */
  final int     casFeatCode_semanticType;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getSemanticType(int addr) {
        if (featOkTst && casFeat_semanticType == null)
      jcas.throwFeatMissing("semanticType", "edu.cmu.lti.oaqa.type.nlp.Token");
    return ll_cas.ll_getStringValue(addr, casFeatCode_semanticType);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setSemanticType(int addr, String v) {
        if (featOkTst && casFeat_semanticType == null)
      jcas.throwFeatMissing("semanticType", "edu.cmu.lti.oaqa.type.nlp.Token");
    ll_cas.ll_setStringValue(addr, casFeatCode_semanticType, v);}
    
  
 
  /** @generated */
  final Feature casFeat_partOfSpeech;
  /** @generated */
  final int     casFeatCode_partOfSpeech;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getPartOfSpeech(int addr) {
        if (featOkTst && casFeat_partOfSpeech == null)
      jcas.throwFeatMissing("partOfSpeech", "edu.cmu.lti.oaqa.type.nlp.Token");
    return ll_cas.ll_getStringValue(addr, casFeatCode_partOfSpeech);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setPartOfSpeech(int addr, String v) {
        if (featOkTst && casFeat_partOfSpeech == null)
      jcas.throwFeatMissing("partOfSpeech", "edu.cmu.lti.oaqa.type.nlp.Token");
    ll_cas.ll_setStringValue(addr, casFeatCode_partOfSpeech, v);}
    
  
 
  /** @generated */
  final Feature casFeat_lemmaForm;
  /** @generated */
  final int     casFeatCode_lemmaForm;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getLemmaForm(int addr) {
        if (featOkTst && casFeat_lemmaForm == null)
      jcas.throwFeatMissing("lemmaForm", "edu.cmu.lti.oaqa.type.nlp.Token");
    return ll_cas.ll_getStringValue(addr, casFeatCode_lemmaForm);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setLemmaForm(int addr, String v) {
        if (featOkTst && casFeat_lemmaForm == null)
      jcas.throwFeatMissing("lemmaForm", "edu.cmu.lti.oaqa.type.nlp.Token");
    ll_cas.ll_setStringValue(addr, casFeatCode_lemmaForm, v);}
    
  
 
  /** @generated */
  final Feature casFeat_isMainReference;
  /** @generated */
  final int     casFeatCode_isMainReference;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public boolean getIsMainReference(int addr) {
        if (featOkTst && casFeat_isMainReference == null)
      jcas.throwFeatMissing("isMainReference", "edu.cmu.lti.oaqa.type.nlp.Token");
    return ll_cas.ll_getBooleanValue(addr, casFeatCode_isMainReference);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setIsMainReference(int addr, boolean v) {
        if (featOkTst && casFeat_isMainReference == null)
      jcas.throwFeatMissing("isMainReference", "edu.cmu.lti.oaqa.type.nlp.Token");
    ll_cas.ll_setBooleanValue(addr, casFeatCode_isMainReference, v);}
    
  
 
  /** @generated */
  final Feature casFeat_isVariable;
  /** @generated */
  final int     casFeatCode_isVariable;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public boolean getIsVariable(int addr) {
        if (featOkTst && casFeat_isVariable == null)
      jcas.throwFeatMissing("isVariable", "edu.cmu.lti.oaqa.type.nlp.Token");
    return ll_cas.ll_getBooleanValue(addr, casFeatCode_isVariable);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setIsVariable(int addr, boolean v) {
        if (featOkTst && casFeat_isVariable == null)
      jcas.throwFeatMissing("isVariable", "edu.cmu.lti.oaqa.type.nlp.Token");
    ll_cas.ll_setBooleanValue(addr, casFeatCode_isVariable, v);}
    
  
 
  /** @generated */
  final Feature casFeat_determiner;
  /** @generated */
  final int     casFeatCode_determiner;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getDeterminer(int addr) {
        if (featOkTst && casFeat_determiner == null)
      jcas.throwFeatMissing("determiner", "edu.cmu.lti.oaqa.type.nlp.Token");
    return ll_cas.ll_getStringValue(addr, casFeatCode_determiner);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setDeterminer(int addr, String v) {
        if (featOkTst && casFeat_determiner == null)
      jcas.throwFeatMissing("determiner", "edu.cmu.lti.oaqa.type.nlp.Token");
    ll_cas.ll_setStringValue(addr, casFeatCode_determiner, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Token_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_arguments = jcas.getRequiredFeatureDE(casType, "arguments", "uima.cas.FSArray", featOkTst);
    casFeatCode_arguments  = (null == casFeat_arguments) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_arguments).getCode();

 
    casFeat_argumentLabels = jcas.getRequiredFeatureDE(casType, "argumentLabels", "uima.cas.StringArray", featOkTst);
    casFeatCode_argumentLabels  = (null == casFeat_argumentLabels) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_argumentLabels).getCode();

 
    casFeat_parse = jcas.getRequiredFeatureDE(casType, "parse", "edu.cmu.lti.oaqa.type.nlp.Token", featOkTst);
    casFeatCode_parse  = (null == casFeat_parse) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_parse).getCode();

 
    casFeat_semanticType = jcas.getRequiredFeatureDE(casType, "semanticType", "uima.cas.String", featOkTst);
    casFeatCode_semanticType  = (null == casFeat_semanticType) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_semanticType).getCode();

 
    casFeat_partOfSpeech = jcas.getRequiredFeatureDE(casType, "partOfSpeech", "uima.cas.String", featOkTst);
    casFeatCode_partOfSpeech  = (null == casFeat_partOfSpeech) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_partOfSpeech).getCode();

 
    casFeat_lemmaForm = jcas.getRequiredFeatureDE(casType, "lemmaForm", "uima.cas.String", featOkTst);
    casFeatCode_lemmaForm  = (null == casFeat_lemmaForm) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_lemmaForm).getCode();

 
    casFeat_isMainReference = jcas.getRequiredFeatureDE(casType, "isMainReference", "uima.cas.Boolean", featOkTst);
    casFeatCode_isMainReference  = (null == casFeat_isMainReference) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_isMainReference).getCode();

 
    casFeat_isVariable = jcas.getRequiredFeatureDE(casType, "isVariable", "uima.cas.Boolean", featOkTst);
    casFeatCode_isVariable  = (null == casFeat_isVariable) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_isVariable).getCode();

 
    casFeat_determiner = jcas.getRequiredFeatureDE(casType, "determiner", "uima.cas.String", featOkTst);
    casFeatCode_determiner  = (null == casFeat_determiner) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_determiner).getCode();

  }
}



    