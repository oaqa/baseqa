

/* First created by JCasGen Tue Aug 05 23:03:53 EDT 2014 */
package edu.cmu.lti.oaqa.type.retrieval;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.StringList;
import org.apache.uima.jcas.cas.TOP;


/** A query operator in the abstract search query model.
 * Updated by JCasGen Tue Sep 30 18:21:25 EDT 2014
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/baseqa/type/OAQATypes.xml
 * @generated */
public class QueryOperator extends TOP {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(QueryOperator.class);
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
  protected QueryOperator() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public QueryOperator(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public QueryOperator(JCas jcas) {
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
  //* Feature: name

  /** getter for name - gets The name (kind) of the operator.
   * @generated
   * @return value of the feature 
   */
  public String getName() {
    if (QueryOperator_Type.featOkTst && ((QueryOperator_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "edu.cmu.lti.oaqa.type.retrieval.QueryOperator");
    return jcasType.ll_cas.ll_getStringValue(addr, ((QueryOperator_Type)jcasType).casFeatCode_name);}
    
  /** setter for name - sets The name (kind) of the operator. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setName(String v) {
    if (QueryOperator_Type.featOkTst && ((QueryOperator_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "edu.cmu.lti.oaqa.type.retrieval.QueryOperator");
    jcasType.ll_cas.ll_setStringValue(addr, ((QueryOperator_Type)jcasType).casFeatCode_name, v);}    
   
    
  //*--------------*
  //* Feature: args

  /** getter for args - gets The arguments for the operator.
   * @generated
   * @return value of the feature 
   */
  public StringList getArgs() {
    if (QueryOperator_Type.featOkTst && ((QueryOperator_Type)jcasType).casFeat_args == null)
      jcasType.jcas.throwFeatMissing("args", "edu.cmu.lti.oaqa.type.retrieval.QueryOperator");
    return (StringList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((QueryOperator_Type)jcasType).casFeatCode_args)));}
    
  /** setter for args - sets The arguments for the operator. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setArgs(StringList v) {
    if (QueryOperator_Type.featOkTst && ((QueryOperator_Type)jcasType).casFeat_args == null)
      jcasType.jcas.throwFeatMissing("args", "edu.cmu.lti.oaqa.type.retrieval.QueryOperator");
    jcasType.ll_cas.ll_setRefValue(addr, ((QueryOperator_Type)jcasType).casFeatCode_args, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    