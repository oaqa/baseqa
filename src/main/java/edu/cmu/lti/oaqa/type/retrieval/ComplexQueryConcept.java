

/* First created by JCasGen Sat Apr 11 19:49:33 EDT 2015 */
package edu.cmu.lti.oaqa.type.retrieval;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSList;


/** A hierarchical query concept represented by a query operation on a list of concepts
 * Updated by JCasGen Sun Apr 19 19:46:50 EDT 2015
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/baseqa/type/OAQATypes.xml
 * @generated */
public class ComplexQueryConcept extends QueryConcept {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(ComplexQueryConcept.class);
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
  protected ComplexQueryConcept() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public ComplexQueryConcept(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public ComplexQueryConcept(JCas jcas) {
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
  //* Feature: operator

  /** getter for operator - gets The operator associated with this concept.
   * @generated
   * @return value of the feature 
   */
  public QueryOperator getOperator() {
    if (ComplexQueryConcept_Type.featOkTst && ((ComplexQueryConcept_Type)jcasType).casFeat_operator == null)
      jcasType.jcas.throwFeatMissing("operator", "edu.cmu.lti.oaqa.type.retrieval.ComplexQueryConcept");
    return (QueryOperator)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((ComplexQueryConcept_Type)jcasType).casFeatCode_operator)));}
    
  /** setter for operator - sets The operator associated with this concept. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setOperator(QueryOperator v) {
    if (ComplexQueryConcept_Type.featOkTst && ((ComplexQueryConcept_Type)jcasType).casFeat_operator == null)
      jcasType.jcas.throwFeatMissing("operator", "edu.cmu.lti.oaqa.type.retrieval.ComplexQueryConcept");
    jcasType.ll_cas.ll_setRefValue(addr, ((ComplexQueryConcept_Type)jcasType).casFeatCode_operator, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: operatorArgs

  /** getter for operatorArgs - gets The operator arguments in a complex query concept.
   * @generated
   * @return value of the feature 
   */
  public FSList getOperatorArgs() {
    if (ComplexQueryConcept_Type.featOkTst && ((ComplexQueryConcept_Type)jcasType).casFeat_operatorArgs == null)
      jcasType.jcas.throwFeatMissing("operatorArgs", "edu.cmu.lti.oaqa.type.retrieval.ComplexQueryConcept");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((ComplexQueryConcept_Type)jcasType).casFeatCode_operatorArgs)));}
    
  /** setter for operatorArgs - sets The operator arguments in a complex query concept. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setOperatorArgs(FSList v) {
    if (ComplexQueryConcept_Type.featOkTst && ((ComplexQueryConcept_Type)jcasType).casFeat_operatorArgs == null)
      jcasType.jcas.throwFeatMissing("operatorArgs", "edu.cmu.lti.oaqa.type.retrieval.ComplexQueryConcept");
    jcasType.ll_cas.ll_setRefValue(addr, ((ComplexQueryConcept_Type)jcasType).casFeatCode_operatorArgs, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    