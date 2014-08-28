
/* First created by JCasGen Tue Aug 05 23:03:53 EDT 2014 */
package edu.cmu.lti.oaqa.type.retrieval;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;

/** A search result from a triple store, e.g., an RDF store.
 * Updated by JCasGen Sat Aug 16 20:55:38 EDT 2014
 * @generated */
public class RelationSearchResult_Type extends AnswerSearchResult_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (RelationSearchResult_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = RelationSearchResult_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new RelationSearchResult(addr, RelationSearchResult_Type.this);
  			   RelationSearchResult_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new RelationSearchResult(addr, RelationSearchResult_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = RelationSearchResult.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.oaqa.type.retrieval.RelationSearchResult");
 
  /** @generated */
  final Feature casFeat_context;
  /** @generated */
  final int     casFeatCode_context;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getContext(int addr) {
        if (featOkTst && casFeat_context == null)
      jcas.throwFeatMissing("context", "edu.cmu.lti.oaqa.type.retrieval.RelationSearchResult");
    return ll_cas.ll_getRefValue(addr, casFeatCode_context);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setContext(int addr, int v) {
        if (featOkTst && casFeat_context == null)
      jcas.throwFeatMissing("context", "edu.cmu.lti.oaqa.type.retrieval.RelationSearchResult");
    ll_cas.ll_setRefValue(addr, casFeatCode_context, v);}
    
   /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @return value at index i in the array 
   */
  public int getContext(int addr, int i) {
        if (featOkTst && casFeat_context == null)
      jcas.throwFeatMissing("context", "edu.cmu.lti.oaqa.type.retrieval.RelationSearchResult");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_context), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_context), i);
  return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_context), i);
  }
   
  /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @param v value to set
   */ 
  public void setContext(int addr, int i, int v) {
        if (featOkTst && casFeat_context == null)
      jcas.throwFeatMissing("context", "edu.cmu.lti.oaqa.type.retrieval.RelationSearchResult");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_context), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_context), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_context), i, v);
  }
 



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public RelationSearchResult_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_context = jcas.getRequiredFeatureDE(casType, "context", "uima.cas.FSArray", featOkTst);
    casFeatCode_context  = (null == casFeat_context) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_context).getCode();

  }
}



    