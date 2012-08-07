

/* First created by JCasGen Wed Aug 01 12:12:46 EDT 2012 */
package org.oaqa.model;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** The class of the question, determined by an automatic question classification process.
 * Updated by JCasGen Wed Aug 01 12:12:46 EDT 2012
 * XML source: /Users/elmer/Documents/workspace/oaqa/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class QClass extends OAQAAnnotation {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(QClass.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected QClass() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public QClass(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public QClass(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public QClass(JCas jcas, int begin, int end) {
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
  //* Feature: qClass

  /** getter for qClass - gets The kind (class) of the question.
   * @generated */
  public String getQClass() {
    if (QClass_Type.featOkTst && ((QClass_Type)jcasType).casFeat_qClass == null)
      jcasType.jcas.throwFeatMissing("qClass", "org.oaqa.model.QClass");
    return jcasType.ll_cas.ll_getStringValue(addr, ((QClass_Type)jcasType).casFeatCode_qClass);}
    
  /** setter for qClass - sets The kind (class) of the question. 
   * @generated */
  public void setQClass(String v) {
    if (QClass_Type.featOkTst && ((QClass_Type)jcasType).casFeat_qClass == null)
      jcasType.jcas.throwFeatMissing("qClass", "org.oaqa.model.QClass");
    jcasType.ll_cas.ll_setStringValue(addr, ((QClass_Type)jcasType).casFeatCode_qClass, v);}    
  }

    