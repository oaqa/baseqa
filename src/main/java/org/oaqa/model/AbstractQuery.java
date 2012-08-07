

/* First created by JCasGen Wed Aug 01 12:12:46 EDT 2012 */
package org.oaqa.model;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSList;


/** An abstract search query for the question that represents query concepts and query operators over those concepts.
 * Updated by JCasGen Wed Aug 01 12:12:46 EDT 2012
 * XML source: /Users/elmer/Documents/workspace/oaqa/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class AbstractQuery extends OAQATop {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(AbstractQuery.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected AbstractQuery() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public AbstractQuery(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public AbstractQuery(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {}
     
 
    
  //*--------------*
  //* Feature: concepts

  /** getter for concepts - gets The list of query concepts that make up this abstract query.  The list is ordered.
   * @generated */
  public FSList getConcepts() {
    if (AbstractQuery_Type.featOkTst && ((AbstractQuery_Type)jcasType).casFeat_concepts == null)
      jcasType.jcas.throwFeatMissing("concepts", "org.oaqa.model.AbstractQuery");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((AbstractQuery_Type)jcasType).casFeatCode_concepts)));}
    
  /** setter for concepts - sets The list of query concepts that make up this abstract query.  The list is ordered. 
   * @generated */
  public void setConcepts(FSList v) {
    if (AbstractQuery_Type.featOkTst && ((AbstractQuery_Type)jcasType).casFeat_concepts == null)
      jcasType.jcas.throwFeatMissing("concepts", "org.oaqa.model.AbstractQuery");
    jcasType.ll_cas.ll_setRefValue(addr, ((AbstractQuery_Type)jcasType).casFeatCode_concepts, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    