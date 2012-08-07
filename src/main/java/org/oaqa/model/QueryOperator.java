

/* First created by JCasGen Wed Aug 01 12:12:46 EDT 2012 */
package org.oaqa.model;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.StringList;


/** A query operator in the abstract search query model.
 * Updated by JCasGen Wed Aug 01 12:12:46 EDT 2012
 * XML source: /Users/elmer/Documents/workspace/oaqa/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class QueryOperator extends OAQATop {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(QueryOperator.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected QueryOperator() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public QueryOperator(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public QueryOperator(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {}
     
 
    
  //*--------------*
  //* Feature: name

  /** getter for name - gets The name (kind) of the operator.
   * @generated */
  public String getName() {
    if (QueryOperator_Type.featOkTst && ((QueryOperator_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "org.oaqa.model.QueryOperator");
    return jcasType.ll_cas.ll_getStringValue(addr, ((QueryOperator_Type)jcasType).casFeatCode_name);}
    
  /** setter for name - sets The name (kind) of the operator. 
   * @generated */
  public void setName(String v) {
    if (QueryOperator_Type.featOkTst && ((QueryOperator_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "org.oaqa.model.QueryOperator");
    jcasType.ll_cas.ll_setStringValue(addr, ((QueryOperator_Type)jcasType).casFeatCode_name, v);}    
   
    
  //*--------------*
  //* Feature: args

  /** getter for args - gets The arguments for the operator.
   * @generated */
  public StringList getArgs() {
    if (QueryOperator_Type.featOkTst && ((QueryOperator_Type)jcasType).casFeat_args == null)
      jcasType.jcas.throwFeatMissing("args", "org.oaqa.model.QueryOperator");
    return (StringList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((QueryOperator_Type)jcasType).casFeatCode_args)));}
    
  /** setter for args - sets The arguments for the operator. 
   * @generated */
  public void setArgs(StringList v) {
    if (QueryOperator_Type.featOkTst && ((QueryOperator_Type)jcasType).casFeat_args == null)
      jcasType.jcas.throwFeatMissing("args", "org.oaqa.model.QueryOperator");
    jcasType.ll_cas.ll_setRefValue(addr, ((QueryOperator_Type)jcasType).casFeatCode_args, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    