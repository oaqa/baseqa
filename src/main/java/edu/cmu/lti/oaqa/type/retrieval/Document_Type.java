
/* First created by JCasGen Sun Oct 19 14:47:24 EDT 2014 */
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

/** A document search result.
 * Updated by JCasGen Sun Oct 19 14:47:24 EDT 2014
 * @generated */
public class Document_Type extends SearchResult_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Document_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Document_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Document(addr, Document_Type.this);
  			   Document_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Document(addr, Document_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Document.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.oaqa.type.retrieval.Document");
 
  /** @generated */
  final Feature casFeat_title;
  /** @generated */
  final int     casFeatCode_title;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getTitle(int addr) {
        if (featOkTst && casFeat_title == null)
      jcas.throwFeatMissing("title", "edu.cmu.lti.oaqa.type.retrieval.Document");
    return ll_cas.ll_getStringValue(addr, casFeatCode_title);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setTitle(int addr, String v) {
        if (featOkTst && casFeat_title == null)
      jcas.throwFeatMissing("title", "edu.cmu.lti.oaqa.type.retrieval.Document");
    ll_cas.ll_setStringValue(addr, casFeatCode_title, v);}
    
  
 
  /** @generated */
  final Feature casFeat_docId;
  /** @generated */
  final int     casFeatCode_docId;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getDocId(int addr) {
        if (featOkTst && casFeat_docId == null)
      jcas.throwFeatMissing("docId", "edu.cmu.lti.oaqa.type.retrieval.Document");
    return ll_cas.ll_getStringValue(addr, casFeatCode_docId);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setDocId(int addr, String v) {
        if (featOkTst && casFeat_docId == null)
      jcas.throwFeatMissing("docId", "edu.cmu.lti.oaqa.type.retrieval.Document");
    ll_cas.ll_setStringValue(addr, casFeatCode_docId, v);}
    
  
 
  /** @generated */
  final Feature casFeat_sections;
  /** @generated */
  final int     casFeatCode_sections;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getSections(int addr) {
        if (featOkTst && casFeat_sections == null)
      jcas.throwFeatMissing("sections", "edu.cmu.lti.oaqa.type.retrieval.Document");
    return ll_cas.ll_getRefValue(addr, casFeatCode_sections);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setSections(int addr, int v) {
        if (featOkTst && casFeat_sections == null)
      jcas.throwFeatMissing("sections", "edu.cmu.lti.oaqa.type.retrieval.Document");
    ll_cas.ll_setRefValue(addr, casFeatCode_sections, v);}
    
   /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @return value at index i in the array 
   */
  public String getSections(int addr, int i) {
        if (featOkTst && casFeat_sections == null)
      jcas.throwFeatMissing("sections", "edu.cmu.lti.oaqa.type.retrieval.Document");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_sections), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_sections), i);
	return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_sections), i);
  }
   
  /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @param v value to set
   */ 
  public void setSections(int addr, int i, String v) {
        if (featOkTst && casFeat_sections == null)
      jcas.throwFeatMissing("sections", "edu.cmu.lti.oaqa.type.retrieval.Document");
    if (lowLevelTypeChecks)
      ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_sections), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_sections), i);
    ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_sections), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_sectionLabels;
  /** @generated */
  final int     casFeatCode_sectionLabels;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getSectionLabels(int addr) {
        if (featOkTst && casFeat_sectionLabels == null)
      jcas.throwFeatMissing("sectionLabels", "edu.cmu.lti.oaqa.type.retrieval.Document");
    return ll_cas.ll_getRefValue(addr, casFeatCode_sectionLabels);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setSectionLabels(int addr, int v) {
        if (featOkTst && casFeat_sectionLabels == null)
      jcas.throwFeatMissing("sectionLabels", "edu.cmu.lti.oaqa.type.retrieval.Document");
    ll_cas.ll_setRefValue(addr, casFeatCode_sectionLabels, v);}
    
   /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @return value at index i in the array 
   */
  public String getSectionLabels(int addr, int i) {
        if (featOkTst && casFeat_sectionLabels == null)
      jcas.throwFeatMissing("sectionLabels", "edu.cmu.lti.oaqa.type.retrieval.Document");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_sectionLabels), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_sectionLabels), i);
	return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_sectionLabels), i);
  }
   
  /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @param v value to set
   */ 
  public void setSectionLabels(int addr, int i, String v) {
        if (featOkTst && casFeat_sectionLabels == null)
      jcas.throwFeatMissing("sectionLabels", "edu.cmu.lti.oaqa.type.retrieval.Document");
    if (lowLevelTypeChecks)
      ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_sectionLabels), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_sectionLabels), i);
    ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_sectionLabels), i, v);
  }
 



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Document_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_title = jcas.getRequiredFeatureDE(casType, "title", "uima.cas.String", featOkTst);
    casFeatCode_title  = (null == casFeat_title) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_title).getCode();

 
    casFeat_docId = jcas.getRequiredFeatureDE(casType, "docId", "uima.cas.String", featOkTst);
    casFeatCode_docId  = (null == casFeat_docId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_docId).getCode();

 
    casFeat_sections = jcas.getRequiredFeatureDE(casType, "sections", "uima.cas.StringArray", featOkTst);
    casFeatCode_sections  = (null == casFeat_sections) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_sections).getCode();

 
    casFeat_sectionLabels = jcas.getRequiredFeatureDE(casType, "sectionLabels", "uima.cas.StringArray", featOkTst);
    casFeatCode_sectionLabels  = (null == casFeat_sectionLabels) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_sectionLabels).getCode();

  }
}



    