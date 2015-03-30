
/* First created by JCasGen Sat Mar 28 16:16:33 EDT 2015 */
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

/** Annotation on a token, which may have arguments if
        they are predicates; useful in transforming text into a "logical
        form", with affordances similar to the ones provided in Extended
        WordNet and the like.
 * Updated by JCasGen Sun Mar 29 18:53:36 EDT 2015
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
  final Feature casFeat_head;
  /** @generated */
  final int     casFeatCode_head;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getHead(int addr) {
        if (featOkTst && casFeat_head == null)
      jcas.throwFeatMissing("head", "edu.cmu.lti.oaqa.type.nlp.Token");
    return ll_cas.ll_getRefValue(addr, casFeatCode_head);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setHead(int addr, int v) {
        if (featOkTst && casFeat_head == null)
      jcas.throwFeatMissing("head", "edu.cmu.lti.oaqa.type.nlp.Token");
    ll_cas.ll_setRefValue(addr, casFeatCode_head, v);}
    
  
 
  /** @generated */
  final Feature casFeat_depLabel;
  /** @generated */
  final int     casFeatCode_depLabel;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getDepLabel(int addr) {
        if (featOkTst && casFeat_depLabel == null)
      jcas.throwFeatMissing("depLabel", "edu.cmu.lti.oaqa.type.nlp.Token");
    return ll_cas.ll_getStringValue(addr, casFeatCode_depLabel);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setDepLabel(int addr, String v) {
        if (featOkTst && casFeat_depLabel == null)
      jcas.throwFeatMissing("depLabel", "edu.cmu.lti.oaqa.type.nlp.Token");
    ll_cas.ll_setStringValue(addr, casFeatCode_depLabel, v);}
    
  
 
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

 
    casFeat_head = jcas.getRequiredFeatureDE(casType, "head", "edu.cmu.lti.oaqa.type.nlp.Token", featOkTst);
    casFeatCode_head  = (null == casFeat_head) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_head).getCode();

 
    casFeat_depLabel = jcas.getRequiredFeatureDE(casType, "depLabel", "uima.cas.String", featOkTst);
    casFeatCode_depLabel  = (null == casFeat_depLabel) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_depLabel).getCode();

 
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



    