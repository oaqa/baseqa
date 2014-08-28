
/* First created by JCasGen Tue Aug 05 23:03:53 EDT 2014 */
package edu.cmu.lti.oaqa.type.retrieval;

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

/** A query concept in the abstract search query model.
 * Updated by JCasGen Sat Aug 16 20:55:37 EDT 2014
 * @generated */
public class QueryConcept_Type extends TOP_Type {
  /** @generated 
   * @return the generator for this type
   */
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
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.oaqa.type.retrieval.QueryConcept");
 
  /** @generated */
  final Feature casFeat_namedEntityTypes;
  /** @generated */
  final int     casFeatCode_namedEntityTypes;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getNamedEntityTypes(int addr) {
        if (featOkTst && casFeat_namedEntityTypes == null)
      jcas.throwFeatMissing("namedEntityTypes", "edu.cmu.lti.oaqa.type.retrieval.QueryConcept");
    return ll_cas.ll_getRefValue(addr, casFeatCode_namedEntityTypes);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setNamedEntityTypes(int addr, int v) {
        if (featOkTst && casFeat_namedEntityTypes == null)
      jcas.throwFeatMissing("namedEntityTypes", "edu.cmu.lti.oaqa.type.retrieval.QueryConcept");
    ll_cas.ll_setRefValue(addr, casFeatCode_namedEntityTypes, v);}
    
  
 
  /** @generated */
  final Feature casFeat_conceptType;
  /** @generated */
  final int     casFeatCode_conceptType;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getConceptType(int addr) {
        if (featOkTst && casFeat_conceptType == null)
      jcas.throwFeatMissing("conceptType", "edu.cmu.lti.oaqa.type.retrieval.QueryConcept");
    return ll_cas.ll_getStringValue(addr, casFeatCode_conceptType);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setConceptType(int addr, String v) {
        if (featOkTst && casFeat_conceptType == null)
      jcas.throwFeatMissing("conceptType", "edu.cmu.lti.oaqa.type.retrieval.QueryConcept");
    ll_cas.ll_setStringValue(addr, casFeatCode_conceptType, v);}
    
  
 
  /** @generated */
  final Feature casFeat_text;
  /** @generated */
  final int     casFeatCode_text;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getText(int addr) {
        if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "edu.cmu.lti.oaqa.type.retrieval.QueryConcept");
    return ll_cas.ll_getStringValue(addr, casFeatCode_text);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setText(int addr, String v) {
        if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "edu.cmu.lti.oaqa.type.retrieval.QueryConcept");
    ll_cas.ll_setStringValue(addr, casFeatCode_text, v);}
    
  
 
  /** @generated */
  final Feature casFeat_originalText;
  /** @generated */
  final int     casFeatCode_originalText;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getOriginalText(int addr) {
        if (featOkTst && casFeat_originalText == null)
      jcas.throwFeatMissing("originalText", "edu.cmu.lti.oaqa.type.retrieval.QueryConcept");
    return ll_cas.ll_getStringValue(addr, casFeatCode_originalText);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setOriginalText(int addr, String v) {
        if (featOkTst && casFeat_originalText == null)
      jcas.throwFeatMissing("originalText", "edu.cmu.lti.oaqa.type.retrieval.QueryConcept");
    ll_cas.ll_setStringValue(addr, casFeatCode_originalText, v);}
    
  
 
  /** @generated */
  final Feature casFeat_operator;
  /** @generated */
  final int     casFeatCode_operator;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getOperator(int addr) {
        if (featOkTst && casFeat_operator == null)
      jcas.throwFeatMissing("operator", "edu.cmu.lti.oaqa.type.retrieval.QueryConcept");
    return ll_cas.ll_getRefValue(addr, casFeatCode_operator);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setOperator(int addr, int v) {
        if (featOkTst && casFeat_operator == null)
      jcas.throwFeatMissing("operator", "edu.cmu.lti.oaqa.type.retrieval.QueryConcept");
    ll_cas.ll_setRefValue(addr, casFeatCode_operator, v);}
    
  
 
  /** @generated */
  final Feature casFeat_operatorArgs;
  /** @generated */
  final int     casFeatCode_operatorArgs;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getOperatorArgs(int addr) {
        if (featOkTst && casFeat_operatorArgs == null)
      jcas.throwFeatMissing("operatorArgs", "edu.cmu.lti.oaqa.type.retrieval.QueryConcept");
    return ll_cas.ll_getRefValue(addr, casFeatCode_operatorArgs);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setOperatorArgs(int addr, int v) {
        if (featOkTst && casFeat_operatorArgs == null)
      jcas.throwFeatMissing("operatorArgs", "edu.cmu.lti.oaqa.type.retrieval.QueryConcept");
    ll_cas.ll_setRefValue(addr, casFeatCode_operatorArgs, v);}
    
  
 
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
      jcas.throwFeatMissing("partOfSpeech", "edu.cmu.lti.oaqa.type.retrieval.QueryConcept");
    return ll_cas.ll_getStringValue(addr, casFeatCode_partOfSpeech);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setPartOfSpeech(int addr, String v) {
        if (featOkTst && casFeat_partOfSpeech == null)
      jcas.throwFeatMissing("partOfSpeech", "edu.cmu.lti.oaqa.type.retrieval.QueryConcept");
    ll_cas.ll_setStringValue(addr, casFeatCode_partOfSpeech, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public QueryConcept_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_namedEntityTypes = jcas.getRequiredFeatureDE(casType, "namedEntityTypes", "uima.cas.StringList", featOkTst);
    casFeatCode_namedEntityTypes  = (null == casFeat_namedEntityTypes) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_namedEntityTypes).getCode();

 
    casFeat_conceptType = jcas.getRequiredFeatureDE(casType, "conceptType", "edu.cmu.lti.oaqa.type.nlp.ConceptType", featOkTst);
    casFeatCode_conceptType  = (null == casFeat_conceptType) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_conceptType).getCode();

 
    casFeat_text = jcas.getRequiredFeatureDE(casType, "text", "uima.cas.String", featOkTst);
    casFeatCode_text  = (null == casFeat_text) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_text).getCode();

 
    casFeat_originalText = jcas.getRequiredFeatureDE(casType, "originalText", "uima.cas.String", featOkTst);
    casFeatCode_originalText  = (null == casFeat_originalText) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_originalText).getCode();

 
    casFeat_operator = jcas.getRequiredFeatureDE(casType, "operator", "edu.cmu.lti.oaqa.type.retrieval.QueryOperator", featOkTst);
    casFeatCode_operator  = (null == casFeat_operator) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_operator).getCode();

 
    casFeat_operatorArgs = jcas.getRequiredFeatureDE(casType, "operatorArgs", "uima.cas.FSList", featOkTst);
    casFeatCode_operatorArgs  = (null == casFeat_operatorArgs) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_operatorArgs).getCode();

 
    casFeat_partOfSpeech = jcas.getRequiredFeatureDE(casType, "partOfSpeech", "uima.cas.String", featOkTst);
    casFeatCode_partOfSpeech  = (null == casFeat_partOfSpeech) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_partOfSpeech).getCode();

  }
}



    