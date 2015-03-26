

/* First created by JCasGen Sun Oct 19 14:47:24 EDT 2014 */
package edu.cmu.lti.oaqa.type.retrieval;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.cas.TOP;


/** An abstract search query for the question that represents query concepts and query operators over those concepts.
 * Updated by JCasGen Tue Mar 17 14:36:55 EDT 2015
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/baseqa/type/OAQATypes.xml
 * @generated */
public class AbstractQuery extends TOP {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(AbstractQuery.class);
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
  protected AbstractQuery() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public AbstractQuery(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public AbstractQuery(JCas jcas) {
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
  //* Feature: concepts

  /** getter for concepts - gets The list of query concepts that make up this abstract query.  The list is ordered.
   * @generated
   * @return value of the feature 
   */
  public FSList getConcepts() {
    if (AbstractQuery_Type.featOkTst && ((AbstractQuery_Type)jcasType).casFeat_concepts == null)
      jcasType.jcas.throwFeatMissing("concepts", "edu.cmu.lti.oaqa.type.retrieval.AbstractQuery");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((AbstractQuery_Type)jcasType).casFeatCode_concepts)));}
    
  /** setter for concepts - sets The list of query concepts that make up this abstract query.  The list is ordered. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setConcepts(FSList v) {
    if (AbstractQuery_Type.featOkTst && ((AbstractQuery_Type)jcasType).casFeat_concepts == null)
      jcasType.jcas.throwFeatMissing("concepts", "edu.cmu.lti.oaqa.type.retrieval.AbstractQuery");
    jcasType.ll_cas.ll_setRefValue(addr, ((AbstractQuery_Type)jcasType).casFeatCode_concepts, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    