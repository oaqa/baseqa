
/* First created by JCasGen Sat Apr 11 19:49:33 EDT 2015 */
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

/** A search result from an ontology.
 * Updated by JCasGen Sun Apr 19 19:46:50 EDT 2015
 * @generated */
public class ConceptSearchResult_Type extends AnswerSearchResult_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (ConceptSearchResult_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = ConceptSearchResult_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new ConceptSearchResult(addr, ConceptSearchResult_Type.this);
  			   ConceptSearchResult_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new ConceptSearchResult(addr, ConceptSearchResult_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = ConceptSearchResult.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.oaqa.type.retrieval.ConceptSearchResult");
 
  /** @generated */
  final Feature casFeat_concept;
  /** @generated */
  final int     casFeatCode_concept;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getConcept(int addr) {
        if (featOkTst && casFeat_concept == null)
      jcas.throwFeatMissing("concept", "edu.cmu.lti.oaqa.type.retrieval.ConceptSearchResult");
    return ll_cas.ll_getRefValue(addr, casFeatCode_concept);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setConcept(int addr, int v) {
        if (featOkTst && casFeat_concept == null)
      jcas.throwFeatMissing("concept", "edu.cmu.lti.oaqa.type.retrieval.ConceptSearchResult");
    ll_cas.ll_setRefValue(addr, casFeatCode_concept, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public ConceptSearchResult_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_concept = jcas.getRequiredFeatureDE(casType, "concept", "edu.cmu.lti.oaqa.type.kb.Concept", featOkTst);
    casFeatCode_concept  = (null == casFeat_concept) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_concept).getCode();

  }
}



    