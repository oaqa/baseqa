

/* First created by JCasGen Wed Aug 01 12:12:46 EDT 2012 */
package org.oaqa.model;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** A search result where the candidate answer is obtained as part of the search process and saved in the text field of the search result.
 * Updated by JCasGen Wed Aug 01 12:12:46 EDT 2012
 * XML source: /Users/elmer/Documents/workspace/oaqa/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class AnswerSearchResult extends SearchResult {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(AnswerSearchResult.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected AnswerSearchResult() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public AnswerSearchResult(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public AnswerSearchResult(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {}
     
}

    