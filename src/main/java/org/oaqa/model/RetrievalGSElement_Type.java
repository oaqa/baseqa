
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
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Thu Oct 11 12:34:48 EDT 2012
 * @generated */
public class RetrievalGSElement_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (RetrievalGSElement_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = RetrievalGSElement_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new RetrievalGSElement(addr, RetrievalGSElement_Type.this);
  			   RetrievalGSElement_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new RetrievalGSElement(addr, RetrievalGSElement_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = RetrievalGSElement.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.oaqa.model.RetrievalGSElement");
 
  /** @generated */
  final Feature casFeat_sequenceId;
  /** @generated */
  final int     casFeatCode_sequenceId;
  /** @generated */ 
  public int getSequenceId(int addr) {
        if (featOkTst && casFeat_sequenceId == null)
      jcas.throwFeatMissing("sequenceId", "org.oaqa.model.RetrievalGSElement");
    return ll_cas.ll_getIntValue(addr, casFeatCode_sequenceId);
  }
  /** @generated */    
  public void setSequenceId(int addr, int v) {
        if (featOkTst && casFeat_sequenceId == null)
      jcas.throwFeatMissing("sequenceId", "org.oaqa.model.RetrievalGSElement");
    ll_cas.ll_setIntValue(addr, casFeatCode_sequenceId, v);}
    
  
 
  /** @generated */
  final Feature casFeat_docId;
  /** @generated */
  final int     casFeatCode_docId;
  /** @generated */ 
  public String getDocId(int addr) {
        if (featOkTst && casFeat_docId == null)
      jcas.throwFeatMissing("docId", "org.oaqa.model.RetrievalGSElement");
    return ll_cas.ll_getStringValue(addr, casFeatCode_docId);
  }
  /** @generated */    
  public void setDocId(int addr, String v) {
        if (featOkTst && casFeat_docId == null)
      jcas.throwFeatMissing("docId", "org.oaqa.model.RetrievalGSElement");
    ll_cas.ll_setStringValue(addr, casFeatCode_docId, v);}
    
  
 
  /** @generated */
  final Feature casFeat_offset;
  /** @generated */
  final int     casFeatCode_offset;
  /** @generated */ 
  public int getOffset(int addr) {
        if (featOkTst && casFeat_offset == null)
      jcas.throwFeatMissing("offset", "org.oaqa.model.RetrievalGSElement");
    return ll_cas.ll_getIntValue(addr, casFeatCode_offset);
  }
  /** @generated */    
  public void setOffset(int addr, int v) {
        if (featOkTst && casFeat_offset == null)
      jcas.throwFeatMissing("offset", "org.oaqa.model.RetrievalGSElement");
    ll_cas.ll_setIntValue(addr, casFeatCode_offset, v);}
    
  
 
  /** @generated */
  final Feature casFeat_length;
  /** @generated */
  final int     casFeatCode_length;
  /** @generated */ 
  public int getLength(int addr) {
        if (featOkTst && casFeat_length == null)
      jcas.throwFeatMissing("length", "org.oaqa.model.RetrievalGSElement");
    return ll_cas.ll_getIntValue(addr, casFeatCode_length);
  }
  /** @generated */    
  public void setLength(int addr, int v) {
        if (featOkTst && casFeat_length == null)
      jcas.throwFeatMissing("length", "org.oaqa.model.RetrievalGSElement");
    ll_cas.ll_setIntValue(addr, casFeatCode_length, v);}
    
  
 
  /** @generated */
  final Feature casFeat_aspects;
  /** @generated */
  final int     casFeatCode_aspects;
  /** @generated */ 
  public String getAspects(int addr) {
        if (featOkTst && casFeat_aspects == null)
      jcas.throwFeatMissing("aspects", "org.oaqa.model.RetrievalGSElement");
    return ll_cas.ll_getStringValue(addr, casFeatCode_aspects);
  }
  /** @generated */    
  public void setAspects(int addr, String v) {
        if (featOkTst && casFeat_aspects == null)
      jcas.throwFeatMissing("aspects", "org.oaqa.model.RetrievalGSElement");
    ll_cas.ll_setStringValue(addr, casFeatCode_aspects, v);}
    
  
 
  /** @generated */
  final Feature casFeat_dataset;
  /** @generated */
  final int     casFeatCode_dataset;
  /** @generated */ 
  public String getDataset(int addr) {
        if (featOkTst && casFeat_dataset == null)
      jcas.throwFeatMissing("dataset", "org.oaqa.model.RetrievalGSElement");
    return ll_cas.ll_getStringValue(addr, casFeatCode_dataset);
  }
  /** @generated */    
  public void setDataset(int addr, String v) {
        if (featOkTst && casFeat_dataset == null)
      jcas.throwFeatMissing("dataset", "org.oaqa.model.RetrievalGSElement");
    ll_cas.ll_setStringValue(addr, casFeatCode_dataset, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public RetrievalGSElement_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_sequenceId = jcas.getRequiredFeatureDE(casType, "sequenceId", "uima.cas.Integer", featOkTst);
    casFeatCode_sequenceId  = (null == casFeat_sequenceId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_sequenceId).getCode();

 
    casFeat_docId = jcas.getRequiredFeatureDE(casType, "docId", "uima.cas.String", featOkTst);
    casFeatCode_docId  = (null == casFeat_docId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_docId).getCode();

 
    casFeat_offset = jcas.getRequiredFeatureDE(casType, "offset", "uima.cas.Integer", featOkTst);
    casFeatCode_offset  = (null == casFeat_offset) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_offset).getCode();

 
    casFeat_length = jcas.getRequiredFeatureDE(casType, "length", "uima.cas.Integer", featOkTst);
    casFeatCode_length  = (null == casFeat_length) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_length).getCode();

 
    casFeat_aspects = jcas.getRequiredFeatureDE(casType, "aspects", "uima.cas.String", featOkTst);
    casFeatCode_aspects  = (null == casFeat_aspects) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_aspects).getCode();

 
    casFeat_dataset = jcas.getRequiredFeatureDE(casType, "dataset", "uima.cas.String", featOkTst);
    casFeatCode_dataset  = (null == casFeat_dataset) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_dataset).getCode();

  }
}



    