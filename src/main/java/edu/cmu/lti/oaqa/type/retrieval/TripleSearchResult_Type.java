
/* First created by JCasGen Sun Oct 05 18:02:25 EDT 2014 */
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
 * Updated by JCasGen Mon Oct 06 20:47:19 EDT 2014
 * @generated */
public class TripleSearchResult_Type extends AnswerSearchResult_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (TripleSearchResult_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = TripleSearchResult_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new TripleSearchResult(addr, TripleSearchResult_Type.this);
  			   TripleSearchResult_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new TripleSearchResult(addr, TripleSearchResult_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = TripleSearchResult.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.oaqa.type.retrieval.TripleSearchResult");
 
  /** @generated */
  final Feature casFeat_triple;
  /** @generated */
  final int     casFeatCode_triple;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getTriple(int addr) {
        if (featOkTst && casFeat_triple == null)
      jcas.throwFeatMissing("triple", "edu.cmu.lti.oaqa.type.retrieval.TripleSearchResult");
    return ll_cas.ll_getRefValue(addr, casFeatCode_triple);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setTriple(int addr, int v) {
        if (featOkTst && casFeat_triple == null)
      jcas.throwFeatMissing("triple", "edu.cmu.lti.oaqa.type.retrieval.TripleSearchResult");
    ll_cas.ll_setRefValue(addr, casFeatCode_triple, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public TripleSearchResult_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_triple = jcas.getRequiredFeatureDE(casType, "triple", "edu.cmu.lti.oaqa.type.kb.Triple", featOkTst);
    casFeatCode_triple  = (null == casFeat_triple) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_triple).getCode();

  }
}



    