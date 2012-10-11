
/* First created by JCasGen Mon Oct 08 18:56:44 EDT 2012 */
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

/** Annotates a span of text identified as a candidate answer.
 * Updated by JCasGen Tue Oct 09 21:34:48 EDT 2012
 * @generated */
public class CandidateAnswerOccurrence_Type extends OAQAAnnotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (CandidateAnswerOccurrence_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = CandidateAnswerOccurrence_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new CandidateAnswerOccurrence(addr, CandidateAnswerOccurrence_Type.this);
  			   CandidateAnswerOccurrence_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new CandidateAnswerOccurrence(addr, CandidateAnswerOccurrence_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = CandidateAnswerOccurrence.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.oaqa.model.CandidateAnswerOccurrence");
 
  /** @generated */
  final Feature casFeat_text;
  /** @generated */
  final int     casFeatCode_text;
  /** @generated */ 
  public String getText(int addr) {
        if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "org.oaqa.model.CandidateAnswerOccurrence");
    return ll_cas.ll_getStringValue(addr, casFeatCode_text);
  }
  /** @generated */    
  public void setText(int addr, String v) {
        if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "org.oaqa.model.CandidateAnswerOccurrence");
    ll_cas.ll_setStringValue(addr, casFeatCode_text, v);}
    
  
 
  /** @generated */
  final Feature casFeat_mentionType;
  /** @generated */
  final int     casFeatCode_mentionType;
  /** @generated */ 
  public String getMentionType(int addr) {
        if (featOkTst && casFeat_mentionType == null)
      jcas.throwFeatMissing("mentionType", "org.oaqa.model.CandidateAnswerOccurrence");
    return ll_cas.ll_getStringValue(addr, casFeatCode_mentionType);
  }
  /** @generated */    
  public void setMentionType(int addr, String v) {
        if (featOkTst && casFeat_mentionType == null)
      jcas.throwFeatMissing("mentionType", "org.oaqa.model.CandidateAnswerOccurrence");
    ll_cas.ll_setStringValue(addr, casFeatCode_mentionType, v);}
    
  
 
  /** @generated */
  final Feature casFeat_source;
  /** @generated */
  final int     casFeatCode_source;
  /** @generated */ 
  public int getSource(int addr) {
        if (featOkTst && casFeat_source == null)
      jcas.throwFeatMissing("source", "org.oaqa.model.CandidateAnswerOccurrence");
    return ll_cas.ll_getRefValue(addr, casFeatCode_source);
  }
  /** @generated */    
  public void setSource(int addr, int v) {
        if (featOkTst && casFeat_source == null)
      jcas.throwFeatMissing("source", "org.oaqa.model.CandidateAnswerOccurrence");
    ll_cas.ll_setRefValue(addr, casFeatCode_source, v);}
    
  
 
  /** @generated */
  final Feature casFeat_sourceBegin;
  /** @generated */
  final int     casFeatCode_sourceBegin;
  /** @generated */ 
  public int getSourceBegin(int addr) {
        if (featOkTst && casFeat_sourceBegin == null)
      jcas.throwFeatMissing("sourceBegin", "org.oaqa.model.CandidateAnswerOccurrence");
    return ll_cas.ll_getIntValue(addr, casFeatCode_sourceBegin);
  }
  /** @generated */    
  public void setSourceBegin(int addr, int v) {
        if (featOkTst && casFeat_sourceBegin == null)
      jcas.throwFeatMissing("sourceBegin", "org.oaqa.model.CandidateAnswerOccurrence");
    ll_cas.ll_setIntValue(addr, casFeatCode_sourceBegin, v);}
    
  
 
  /** @generated */
  final Feature casFeat_sourceEnd;
  /** @generated */
  final int     casFeatCode_sourceEnd;
  /** @generated */ 
  public int getSourceEnd(int addr) {
        if (featOkTst && casFeat_sourceEnd == null)
      jcas.throwFeatMissing("sourceEnd", "org.oaqa.model.CandidateAnswerOccurrence");
    return ll_cas.ll_getIntValue(addr, casFeatCode_sourceEnd);
  }
  /** @generated */    
  public void setSourceEnd(int addr, int v) {
        if (featOkTst && casFeat_sourceEnd == null)
      jcas.throwFeatMissing("sourceEnd", "org.oaqa.model.CandidateAnswerOccurrence");
    ll_cas.ll_setIntValue(addr, casFeatCode_sourceEnd, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public CandidateAnswerOccurrence_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_text = jcas.getRequiredFeatureDE(casType, "text", "uima.cas.String", featOkTst);
    casFeatCode_text  = (null == casFeat_text) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_text).getCode();

 
    casFeat_mentionType = jcas.getRequiredFeatureDE(casType, "mentionType", "uima.cas.String", featOkTst);
    casFeatCode_mentionType  = (null == casFeat_mentionType) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_mentionType).getCode();

 
    casFeat_source = jcas.getRequiredFeatureDE(casType, "source", "org.oaqa.model.SearchResult", featOkTst);
    casFeatCode_source  = (null == casFeat_source) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_source).getCode();

 
    casFeat_sourceBegin = jcas.getRequiredFeatureDE(casType, "sourceBegin", "uima.cas.Integer", featOkTst);
    casFeatCode_sourceBegin  = (null == casFeat_sourceBegin) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_sourceBegin).getCode();

 
    casFeat_sourceEnd = jcas.getRequiredFeatureDE(casType, "sourceEnd", "uima.cas.Integer", featOkTst);
    casFeatCode_sourceEnd  = (null == casFeat_sourceEnd) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_sourceEnd).getCode();

  }
}



    