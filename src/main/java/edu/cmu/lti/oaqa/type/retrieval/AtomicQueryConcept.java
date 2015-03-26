

/* First created by JCasGen Sun Oct 19 14:47:24 EDT 2014 */
package edu.cmu.lti.oaqa.type.retrieval;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** A primitive query concept represented by a single text string
 * Updated by JCasGen Tue Mar 17 14:36:55 EDT 2015
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/baseqa/type/OAQATypes.xml
 * @generated */
public class AtomicQueryConcept extends QueryConcept {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(AtomicQueryConcept.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected AtomicQueryConcept() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public AtomicQueryConcept(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public AtomicQueryConcept(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: text

  /** getter for text - gets The keyword text.
   * @generated
   * @return value of the feature 
   */
  public String getText() {
    if (AtomicQueryConcept_Type.featOkTst && ((AtomicQueryConcept_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "edu.cmu.lti.oaqa.type.retrieval.AtomicQueryConcept");
    return jcasType.ll_cas.ll_getStringValue(addr, ((AtomicQueryConcept_Type)jcasType).casFeatCode_text);}
    
  /** setter for text - sets The keyword text. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setText(String v) {
    if (AtomicQueryConcept_Type.featOkTst && ((AtomicQueryConcept_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "edu.cmu.lti.oaqa.type.retrieval.AtomicQueryConcept");
    jcasType.ll_cas.ll_setStringValue(addr, ((AtomicQueryConcept_Type)jcasType).casFeatCode_text, v);}    
   
    
  //*--------------*
  //* Feature: originalText

  /** getter for originalText - gets The lexical string in the question.
   * @generated
   * @return value of the feature 
   */
  public String getOriginalText() {
    if (AtomicQueryConcept_Type.featOkTst && ((AtomicQueryConcept_Type)jcasType).casFeat_originalText == null)
      jcasType.jcas.throwFeatMissing("originalText", "edu.cmu.lti.oaqa.type.retrieval.AtomicQueryConcept");
    return jcasType.ll_cas.ll_getStringValue(addr, ((AtomicQueryConcept_Type)jcasType).casFeatCode_originalText);}
    
  /** setter for originalText - sets The lexical string in the question. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setOriginalText(String v) {
    if (AtomicQueryConcept_Type.featOkTst && ((AtomicQueryConcept_Type)jcasType).casFeat_originalText == null)
      jcasType.jcas.throwFeatMissing("originalText", "edu.cmu.lti.oaqa.type.retrieval.AtomicQueryConcept");
    jcasType.ll_cas.ll_setStringValue(addr, ((AtomicQueryConcept_Type)jcasType).casFeatCode_originalText, v);}    
  }

    