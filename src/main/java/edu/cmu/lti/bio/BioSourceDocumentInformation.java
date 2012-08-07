

/* First created by JCasGen Thu May 24 16:45:52 EDT 2012 */
package edu.cmu.lti.bio;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** Stores detailed information about the original source document for the bio medical domain.
 * Updated by JCasGen Thu May 24 16:57:32 EDT 2012
 * XML source: /Users/elmer/Documents/workspace/MergedQA/src/main/resources/edu/cmu/lti/oaqa/bio/model/bioTypes.xml
 * @generated */
public class BioSourceDocumentInformation extends Annotation {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(BioSourceDocumentInformation.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected BioSourceDocumentInformation() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public BioSourceDocumentInformation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public BioSourceDocumentInformation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public BioSourceDocumentInformation(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {}
     
 
    
  //*--------------*
  //* Feature: uri

  /** getter for uri - gets URI of document. (For example, file:///MyDirectory/myFile.txt for a simple file or http://incubator.apache.org/uima/index.html for content from a web source.)
   * @generated */
  public String getUri() {
    if (BioSourceDocumentInformation_Type.featOkTst && ((BioSourceDocumentInformation_Type)jcasType).casFeat_uri == null)
      jcasType.jcas.throwFeatMissing("uri", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((BioSourceDocumentInformation_Type)jcasType).casFeatCode_uri);}
    
  /** setter for uri - sets URI of document. (For example, file:///MyDirectory/myFile.txt for a simple file or http://incubator.apache.org/uima/index.html for content from a web source.) 
   * @generated */
  public void setUri(String v) {
    if (BioSourceDocumentInformation_Type.featOkTst && ((BioSourceDocumentInformation_Type)jcasType).casFeat_uri == null)
      jcasType.jcas.throwFeatMissing("uri", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    jcasType.ll_cas.ll_setStringValue(addr, ((BioSourceDocumentInformation_Type)jcasType).casFeatCode_uri, v);}    
   
    
  //*--------------*
  //* Feature: documentSize

  /** getter for documentSize - gets Size of original document in bytes before processing by CAS Initializer. Either absolute file size of size within file or other source.
   * @generated */
  public int getDocumentSize() {
    if (BioSourceDocumentInformation_Type.featOkTst && ((BioSourceDocumentInformation_Type)jcasType).casFeat_documentSize == null)
      jcasType.jcas.throwFeatMissing("documentSize", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    return jcasType.ll_cas.ll_getIntValue(addr, ((BioSourceDocumentInformation_Type)jcasType).casFeatCode_documentSize);}
    
  /** setter for documentSize - sets Size of original document in bytes before processing by CAS Initializer. Either absolute file size of size within file or other source. 
   * @generated */
  public void setDocumentSize(int v) {
    if (BioSourceDocumentInformation_Type.featOkTst && ((BioSourceDocumentInformation_Type)jcasType).casFeat_documentSize == null)
      jcasType.jcas.throwFeatMissing("documentSize", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    jcasType.ll_cas.ll_setIntValue(addr, ((BioSourceDocumentInformation_Type)jcasType).casFeatCode_documentSize, v);}    
   
    
  //*--------------*
  //* Feature: PMCID

  /** getter for PMCID - gets a unique reference number or identifier that is assigned to every article that is accepted into PMC
   * @generated */
  public String getPMCID() {
    if (BioSourceDocumentInformation_Type.featOkTst && ((BioSourceDocumentInformation_Type)jcasType).casFeat_PMCID == null)
      jcasType.jcas.throwFeatMissing("PMCID", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((BioSourceDocumentInformation_Type)jcasType).casFeatCode_PMCID);}
    
  /** setter for PMCID - sets a unique reference number or identifier that is assigned to every article that is accepted into PMC 
   * @generated */
  public void setPMCID(String v) {
    if (BioSourceDocumentInformation_Type.featOkTst && ((BioSourceDocumentInformation_Type)jcasType).casFeat_PMCID == null)
      jcasType.jcas.throwFeatMissing("PMCID", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    jcasType.ll_cas.ll_setStringValue(addr, ((BioSourceDocumentInformation_Type)jcasType).casFeatCode_PMCID, v);}    
   
    
  //*--------------*
  //* Feature: PMID

  /** getter for PMID - gets a unique reference number for PubMed citations
   * @generated */
  public String getPMID() {
    if (BioSourceDocumentInformation_Type.featOkTst && ((BioSourceDocumentInformation_Type)jcasType).casFeat_PMID == null)
      jcasType.jcas.throwFeatMissing("PMID", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((BioSourceDocumentInformation_Type)jcasType).casFeatCode_PMID);}
    
  /** setter for PMID - sets a unique reference number for PubMed citations 
   * @generated */
  public void setPMID(String v) {
    if (BioSourceDocumentInformation_Type.featOkTst && ((BioSourceDocumentInformation_Type)jcasType).casFeat_PMID == null)
      jcasType.jcas.throwFeatMissing("PMID", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    jcasType.ll_cas.ll_setStringValue(addr, ((BioSourceDocumentInformation_Type)jcasType).casFeatCode_PMID, v);}    
   
    
  //*--------------*
  //* Feature: PharmGKBID

  /** getter for PharmGKBID - gets PharmGKB ID
   * @generated */
  public String getPharmGKBID() {
    if (BioSourceDocumentInformation_Type.featOkTst && ((BioSourceDocumentInformation_Type)jcasType).casFeat_PharmGKBID == null)
      jcasType.jcas.throwFeatMissing("PharmGKBID", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((BioSourceDocumentInformation_Type)jcasType).casFeatCode_PharmGKBID);}
    
  /** setter for PharmGKBID - sets PharmGKB ID 
   * @generated */
  public void setPharmGKBID(String v) {
    if (BioSourceDocumentInformation_Type.featOkTst && ((BioSourceDocumentInformation_Type)jcasType).casFeat_PharmGKBID == null)
      jcasType.jcas.throwFeatMissing("PharmGKBID", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    jcasType.ll_cas.ll_setStringValue(addr, ((BioSourceDocumentInformation_Type)jcasType).casFeatCode_PharmGKBID, v);}    
   
    
  //*--------------*
  //* Feature: title

  /** getter for title - gets Contents of the first <article-title> tag
   * @generated */
  public String getTitle() {
    if (BioSourceDocumentInformation_Type.featOkTst && ((BioSourceDocumentInformation_Type)jcasType).casFeat_title == null)
      jcasType.jcas.throwFeatMissing("title", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((BioSourceDocumentInformation_Type)jcasType).casFeatCode_title);}
    
  /** setter for title - sets Contents of the first <article-title> tag 
   * @generated */
  public void setTitle(String v) {
    if (BioSourceDocumentInformation_Type.featOkTst && ((BioSourceDocumentInformation_Type)jcasType).casFeat_title == null)
      jcasType.jcas.throwFeatMissing("title", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    jcasType.ll_cas.ll_setStringValue(addr, ((BioSourceDocumentInformation_Type)jcasType).casFeatCode_title, v);}    
   
    
  //*--------------*
  //* Feature: authors

  /** getter for authors - gets multiple authors
   * @generated */
  public String getAuthors() {
    if (BioSourceDocumentInformation_Type.featOkTst && ((BioSourceDocumentInformation_Type)jcasType).casFeat_authors == null)
      jcasType.jcas.throwFeatMissing("authors", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((BioSourceDocumentInformation_Type)jcasType).casFeatCode_authors);}
    
  /** setter for authors - sets multiple authors 
   * @generated */
  public void setAuthors(String v) {
    if (BioSourceDocumentInformation_Type.featOkTst && ((BioSourceDocumentInformation_Type)jcasType).casFeat_authors == null)
      jcasType.jcas.throwFeatMissing("authors", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    jcasType.ll_cas.ll_setStringValue(addr, ((BioSourceDocumentInformation_Type)jcasType).casFeatCode_authors, v);}    
   
    
  //*--------------*
  //* Feature: publisher

  /** getter for publisher - gets contents of the <publisher> tag
   * @generated */
  public String getPublisher() {
    if (BioSourceDocumentInformation_Type.featOkTst && ((BioSourceDocumentInformation_Type)jcasType).casFeat_publisher == null)
      jcasType.jcas.throwFeatMissing("publisher", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((BioSourceDocumentInformation_Type)jcasType).casFeatCode_publisher);}
    
  /** setter for publisher - sets contents of the <publisher> tag 
   * @generated */
  public void setPublisher(String v) {
    if (BioSourceDocumentInformation_Type.featOkTst && ((BioSourceDocumentInformation_Type)jcasType).casFeat_publisher == null)
      jcasType.jcas.throwFeatMissing("publisher", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    jcasType.ll_cas.ll_setStringValue(addr, ((BioSourceDocumentInformation_Type)jcasType).casFeatCode_publisher, v);}    
   
    
  //*--------------*
  //* Feature: publishDate

  /** getter for publishDate - gets The date when this document was published.
   * @generated */
  public String getPublishDate() {
    if (BioSourceDocumentInformation_Type.featOkTst && ((BioSourceDocumentInformation_Type)jcasType).casFeat_publishDate == null)
      jcasType.jcas.throwFeatMissing("publishDate", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((BioSourceDocumentInformation_Type)jcasType).casFeatCode_publishDate);}
    
  /** setter for publishDate - sets The date when this document was published. 
   * @generated */
  public void setPublishDate(String v) {
    if (BioSourceDocumentInformation_Type.featOkTst && ((BioSourceDocumentInformation_Type)jcasType).casFeat_publishDate == null)
      jcasType.jcas.throwFeatMissing("publishDate", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    jcasType.ll_cas.ll_setStringValue(addr, ((BioSourceDocumentInformation_Type)jcasType).casFeatCode_publishDate, v);}    
   
    
  //*--------------*
  //* Feature: category

  /** getter for category - gets A top-level group.
   * @generated */
  public String getCategory() {
    if (BioSourceDocumentInformation_Type.featOkTst && ((BioSourceDocumentInformation_Type)jcasType).casFeat_category == null)
      jcasType.jcas.throwFeatMissing("category", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((BioSourceDocumentInformation_Type)jcasType).casFeatCode_category);}
    
  /** setter for category - sets A top-level group. 
   * @generated */
  public void setCategory(String v) {
    if (BioSourceDocumentInformation_Type.featOkTst && ((BioSourceDocumentInformation_Type)jcasType).casFeat_category == null)
      jcasType.jcas.throwFeatMissing("category", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    jcasType.ll_cas.ll_setStringValue(addr, ((BioSourceDocumentInformation_Type)jcasType).casFeatCode_category, v);}    
   
    
  //*--------------*
  //* Feature: subcategory

  /** getter for subcategory - gets A second-level group.
   * @generated */
  public String getSubcategory() {
    if (BioSourceDocumentInformation_Type.featOkTst && ((BioSourceDocumentInformation_Type)jcasType).casFeat_subcategory == null)
      jcasType.jcas.throwFeatMissing("subcategory", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((BioSourceDocumentInformation_Type)jcasType).casFeatCode_subcategory);}
    
  /** setter for subcategory - sets A second-level group. 
   * @generated */
  public void setSubcategory(String v) {
    if (BioSourceDocumentInformation_Type.featOkTst && ((BioSourceDocumentInformation_Type)jcasType).casFeat_subcategory == null)
      jcasType.jcas.throwFeatMissing("subcategory", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    jcasType.ll_cas.ll_setStringValue(addr, ((BioSourceDocumentInformation_Type)jcasType).casFeatCode_subcategory, v);}    
   
    
  //*--------------*
  //* Feature: Docno

  /** getter for Docno - gets Unique doc identifier for Indri & SEPIA to use.  May differ for different corpora
   * @generated */
  public String getDocno() {
    if (BioSourceDocumentInformation_Type.featOkTst && ((BioSourceDocumentInformation_Type)jcasType).casFeat_Docno == null)
      jcasType.jcas.throwFeatMissing("Docno", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((BioSourceDocumentInformation_Type)jcasType).casFeatCode_Docno);}
    
  /** setter for Docno - sets Unique doc identifier for Indri & SEPIA to use.  May differ for different corpora 
   * @generated */
  public void setDocno(String v) {
    if (BioSourceDocumentInformation_Type.featOkTst && ((BioSourceDocumentInformation_Type)jcasType).casFeat_Docno == null)
      jcasType.jcas.throwFeatMissing("Docno", "edu.cmu.lti.bio.BioSourceDocumentInformation");
    jcasType.ll_cas.ll_setStringValue(addr, ((BioSourceDocumentInformation_Type)jcasType).casFeatCode_Docno, v);}    
  }

    