
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

/** A passage search result that was the result of a search from the subject and object of a triple
 * Updated by JCasGen Tue Sep 30 18:21:25 EDT 2014
 * @generated */
public class PassageFromRelation_Type extends Passage_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (PassageFromRelation_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = PassageFromRelation_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new PassageFromRelation(addr, PassageFromRelation_Type.this);
  			   PassageFromRelation_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new PassageFromRelation(addr, PassageFromRelation_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = PassageFromRelation.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.oaqa.type.retrieval.PassageFromRelation");
 
  /** @generated */
  final Feature casFeat_sourceRelation;
  /** @generated */
  final int     casFeatCode_sourceRelation;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getSourceRelation(int addr) {
        if (featOkTst && casFeat_sourceRelation == null)
      jcas.throwFeatMissing("sourceRelation", "edu.cmu.lti.oaqa.type.retrieval.PassageFromRelation");
    return ll_cas.ll_getRefValue(addr, casFeatCode_sourceRelation);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setSourceRelation(int addr, int v) {
        if (featOkTst && casFeat_sourceRelation == null)
      jcas.throwFeatMissing("sourceRelation", "edu.cmu.lti.oaqa.type.retrieval.PassageFromRelation");
    ll_cas.ll_setRefValue(addr, casFeatCode_sourceRelation, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public PassageFromRelation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_sourceRelation = jcas.getRequiredFeatureDE(casType, "sourceRelation", "edu.cmu.lti.oaqa.type.kb.Relation", featOkTst);
    casFeatCode_sourceRelation  = (null == casFeat_sourceRelation) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_sourceRelation).getCode();

  }
}



    