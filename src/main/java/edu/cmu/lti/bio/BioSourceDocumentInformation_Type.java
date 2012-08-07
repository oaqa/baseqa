
/* First created by JCasGen Thu May 24 16:45:52 EDT 2012 */
package edu.cmu.lti.bio;

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

/** Stores detailed information about the original source document for the bio medical domain.
 * Updated by JCasGen Thu May 24 16:57:33 EDT 2012
 * @generated */
public class BioSourceDocumentInformation_Type extends Annotation_Type {
  /** @generated */
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (BioSourceDocumentInformation_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = BioSourceDocumentInformation_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new BioSourceDocumentInformation(addr, BioSourceDocumentInformation_Type.this);
  			   BioSourceDocumentInformation_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new BioSourceDocumentInformation(addr, BioSourceDocumentInformation_Type.this);
  	  }
    };
  /** @generated */
  public final static int typeIndexID = BioSourceDocumentInformation.typeIndexID;
  /** @generated 
     @modifiable */
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.bio.BioSourceDocumentInformation");
 
  /** @generated */
  final Feature casFeat_uri;
  /** @generated */
  final int     casFeatCode_uri;
  /** @generated */ 
  public String getUri(int addr) {
        if (featOkTst && casFeat_uri == null)
      jcas.throwFeatMissing("uri", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_uri);
  }
  /** @generated */    
  public void setUri(int addr, String v) {
        if (featOkTst && casFeat_uri == null)
      jcas.throwFeatMissing("uri", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    ll_cas.ll_setStringValue(addr, casFeatCode_uri, v);}
    
  
 
  /** @generated */
  final Feature casFeat_documentSize;
  /** @generated */
  final int     casFeatCode_documentSize;
  /** @generated */ 
  public int getDocumentSize(int addr) {
        if (featOkTst && casFeat_documentSize == null)
      jcas.throwFeatMissing("documentSize", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    return ll_cas.ll_getIntValue(addr, casFeatCode_documentSize);
  }
  /** @generated */    
  public void setDocumentSize(int addr, int v) {
        if (featOkTst && casFeat_documentSize == null)
      jcas.throwFeatMissing("documentSize", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    ll_cas.ll_setIntValue(addr, casFeatCode_documentSize, v);}
    
  
 
  /** @generated */
  final Feature casFeat_PMCID;
  /** @generated */
  final int     casFeatCode_PMCID;
  /** @generated */ 
  public String getPMCID(int addr) {
        if (featOkTst && casFeat_PMCID == null)
      jcas.throwFeatMissing("PMCID", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_PMCID);
  }
  /** @generated */    
  public void setPMCID(int addr, String v) {
        if (featOkTst && casFeat_PMCID == null)
      jcas.throwFeatMissing("PMCID", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    ll_cas.ll_setStringValue(addr, casFeatCode_PMCID, v);}
    
  
 
  /** @generated */
  final Feature casFeat_PMID;
  /** @generated */
  final int     casFeatCode_PMID;
  /** @generated */ 
  public String getPMID(int addr) {
        if (featOkTst && casFeat_PMID == null)
      jcas.throwFeatMissing("PMID", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_PMID);
  }
  /** @generated */    
  public void setPMID(int addr, String v) {
        if (featOkTst && casFeat_PMID == null)
      jcas.throwFeatMissing("PMID", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    ll_cas.ll_setStringValue(addr, casFeatCode_PMID, v);}
    
  
 
  /** @generated */
  final Feature casFeat_PharmGKBID;
  /** @generated */
  final int     casFeatCode_PharmGKBID;
  /** @generated */ 
  public String getPharmGKBID(int addr) {
        if (featOkTst && casFeat_PharmGKBID == null)
      jcas.throwFeatMissing("PharmGKBID", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_PharmGKBID);
  }
  /** @generated */    
  public void setPharmGKBID(int addr, String v) {
        if (featOkTst && casFeat_PharmGKBID == null)
      jcas.throwFeatMissing("PharmGKBID", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    ll_cas.ll_setStringValue(addr, casFeatCode_PharmGKBID, v);}
    
  
 
  /** @generated */
  final Feature casFeat_title;
  /** @generated */
  final int     casFeatCode_title;
  /** @generated */ 
  public String getTitle(int addr) {
        if (featOkTst && casFeat_title == null)
      jcas.throwFeatMissing("title", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_title);
  }
  /** @generated */    
  public void setTitle(int addr, String v) {
        if (featOkTst && casFeat_title == null)
      jcas.throwFeatMissing("title", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    ll_cas.ll_setStringValue(addr, casFeatCode_title, v);}
    
  
 
  /** @generated */
  final Feature casFeat_authors;
  /** @generated */
  final int     casFeatCode_authors;
  /** @generated */ 
  public String getAuthors(int addr) {
        if (featOkTst && casFeat_authors == null)
      jcas.throwFeatMissing("authors", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_authors);
  }
  /** @generated */    
  public void setAuthors(int addr, String v) {
        if (featOkTst && casFeat_authors == null)
      jcas.throwFeatMissing("authors", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    ll_cas.ll_setStringValue(addr, casFeatCode_authors, v);}
    
  
 
  /** @generated */
  final Feature casFeat_publisher;
  /** @generated */
  final int     casFeatCode_publisher;
  /** @generated */ 
  public String getPublisher(int addr) {
        if (featOkTst && casFeat_publisher == null)
      jcas.throwFeatMissing("publisher", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_publisher);
  }
  /** @generated */    
  public void setPublisher(int addr, String v) {
        if (featOkTst && casFeat_publisher == null)
      jcas.throwFeatMissing("publisher", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    ll_cas.ll_setStringValue(addr, casFeatCode_publisher, v);}
    
  
 
  /** @generated */
  final Feature casFeat_publishDate;
  /** @generated */
  final int     casFeatCode_publishDate;
  /** @generated */ 
  public String getPublishDate(int addr) {
        if (featOkTst && casFeat_publishDate == null)
      jcas.throwFeatMissing("publishDate", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_publishDate);
  }
  /** @generated */    
  public void setPublishDate(int addr, String v) {
        if (featOkTst && casFeat_publishDate == null)
      jcas.throwFeatMissing("publishDate", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    ll_cas.ll_setStringValue(addr, casFeatCode_publishDate, v);}
    
  
 
  /** @generated */
  final Feature casFeat_category;
  /** @generated */
  final int     casFeatCode_category;
  /** @generated */ 
  public String getCategory(int addr) {
        if (featOkTst && casFeat_category == null)
      jcas.throwFeatMissing("category", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_category);
  }
  /** @generated */    
  public void setCategory(int addr, String v) {
        if (featOkTst && casFeat_category == null)
      jcas.throwFeatMissing("category", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    ll_cas.ll_setStringValue(addr, casFeatCode_category, v);}
    
  
 
  /** @generated */
  final Feature casFeat_subcategory;
  /** @generated */
  final int     casFeatCode_subcategory;
  /** @generated */ 
  public String getSubcategory(int addr) {
        if (featOkTst && casFeat_subcategory == null)
      jcas.throwFeatMissing("subcategory", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_subcategory);
  }
  /** @generated */    
  public void setSubcategory(int addr, String v) {
        if (featOkTst && casFeat_subcategory == null)
      jcas.throwFeatMissing("subcategory", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    ll_cas.ll_setStringValue(addr, casFeatCode_subcategory, v);}
    
  
 
  /** @generated */
  final Feature casFeat_Docno;
  /** @generated */
  final int     casFeatCode_Docno;
  /** @generated */ 
  public String getDocno(int addr) {
        if (featOkTst && casFeat_Docno == null)
      jcas.throwFeatMissing("Docno", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Docno);
  }
  /** @generated */    
  public void setDocno(int addr, String v) {
        if (featOkTst && casFeat_Docno == null)
      jcas.throwFeatMissing("Docno", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    ll_cas.ll_setStringValue(addr, casFeatCode_Docno, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public BioSourceDocumentInformation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_uri = jcas.getRequiredFeatureDE(casType, "uri", "uima.cas.String", featOkTst);
    casFeatCode_uri  = (null == casFeat_uri) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_uri).getCode();

 
    casFeat_documentSize = jcas.getRequiredFeatureDE(casType, "documentSize", "uima.cas.Integer", featOkTst);
    casFeatCode_documentSize  = (null == casFeat_documentSize) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_documentSize).getCode();

 
    casFeat_PMCID = jcas.getRequiredFeatureDE(casType, "PMCID", "uima.cas.String", featOkTst);
    casFeatCode_PMCID  = (null == casFeat_PMCID) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_PMCID).getCode();

 
    casFeat_PMID = jcas.getRequiredFeatureDE(casType, "PMID", "uima.cas.String", featOkTst);
    casFeatCode_PMID  = (null == casFeat_PMID) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_PMID).getCode();

 
    casFeat_PharmGKBID = jcas.getRequiredFeatureDE(casType, "PharmGKBID", "uima.cas.String", featOkTst);
    casFeatCode_PharmGKBID  = (null == casFeat_PharmGKBID) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_PharmGKBID).getCode();

 
    casFeat_title = jcas.getRequiredFeatureDE(casType, "title", "uima.cas.String", featOkTst);
    casFeatCode_title  = (null == casFeat_title) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_title).getCode();

 
    casFeat_authors = jcas.getRequiredFeatureDE(casType, "authors", "uima.cas.String", featOkTst);
    casFeatCode_authors  = (null == casFeat_authors) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_authors).getCode();

 
    casFeat_publisher = jcas.getRequiredFeatureDE(casType, "publisher", "uima.cas.String", featOkTst);
    casFeatCode_publisher  = (null == casFeat_publisher) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_publisher).getCode();

 
    casFeat_publishDate = jcas.getRequiredFeatureDE(casType, "publishDate", "uima.cas.String", featOkTst);
    casFeatCode_publishDate  = (null == casFeat_publishDate) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_publishDate).getCode();

 
    casFeat_category = jcas.getRequiredFeatureDE(casType, "category", "uima.cas.String", featOkTst);
    casFeatCode_category  = (null == casFeat_category) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_category).getCode();

 
    casFeat_subcategory = jcas.getRequiredFeatureDE(casType, "subcategory", "uima.cas.String", featOkTst);
    casFeatCode_subcategory  = (null == casFeat_subcategory) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_subcategory).getCode();

 
    casFeat_Docno = jcas.getRequiredFeatureDE(casType, "Docno", "uima.cas.String", featOkTst);
    casFeatCode_Docno  = (null == casFeat_Docno) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Docno).getCode();

  }
}



    