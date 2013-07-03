

/* First created by JCasGen Wed Jul 03 11:52:04 EDT 2013 */
package org.oaqa.model.retrieval;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.oaqa.model.gerp.GerpTop;
import org.apache.uima.jcas.cas.FSList;


/** An abstract search query for the question that represents query concepts and query operators over those concepts.
 * Updated by JCasGen Wed Jul 03 15:44:17 EDT 2013
 * XML source: C:/Users/yangz13/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class AbstractQuery extends GerpTop {
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
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected AbstractQuery() {/* intentionally empty block */}
    
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
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: concepts

  /** getter for concepts - gets The list of query concepts that make up this abstract query.  The list is ordered.
   * @generated */
  public FSList getConcepts() {
    if (AbstractQuery_Type.featOkTst && ((AbstractQuery_Type)jcasType).casFeat_concepts == null)
      jcasType.jcas.throwFeatMissing("concepts", "org.oaqa.model.retrieval.AbstractQuery");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((AbstractQuery_Type)jcasType).casFeatCode_concepts)));}
    
  /** setter for concepts - sets The list of query concepts that make up this abstract query.  The list is ordered. 
   * @generated */
  public void setConcepts(FSList v) {
    if (AbstractQuery_Type.featOkTst && ((AbstractQuery_Type)jcasType).casFeat_concepts == null)
      jcasType.jcas.throwFeatMissing("concepts", "org.oaqa.model.retrieval.AbstractQuery");
    jcasType.ll_cas.ll_setRefValue(addr, ((AbstractQuery_Type)jcasType).casFeatCode_concepts, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    