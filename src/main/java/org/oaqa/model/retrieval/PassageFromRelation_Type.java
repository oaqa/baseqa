
/* First created by JCasGen Mon Jul 08 17:12:14 EDT 2013 */
package org.oaqa.model.retrieval;

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
 * Updated by JCasGen Mon Jul 29 18:17:35 EDT 2013
 * @generated */
public class PassageFromRelation_Type extends Passage_Type {
  /** @generated */
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
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.oaqa.model.retrieval.PassageFromRelation");
 
  /** @generated */
  final Feature casFeat_sourceRelation;
  /** @generated */
  final int     casFeatCode_sourceRelation;
  /** @generated */ 
  public int getSourceRelation(int addr) {
        if (featOkTst && casFeat_sourceRelation == null)
      jcas.throwFeatMissing("sourceRelation", "org.oaqa.model.retrieval.PassageFromRelation");
    return ll_cas.ll_getRefValue(addr, casFeatCode_sourceRelation);
  }
  /** @generated */    
  public void setSourceRelation(int addr, int v) {
        if (featOkTst && casFeat_sourceRelation == null)
      jcas.throwFeatMissing("sourceRelation", "org.oaqa.model.retrieval.PassageFromRelation");
    ll_cas.ll_setRefValue(addr, casFeatCode_sourceRelation, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public PassageFromRelation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_sourceRelation = jcas.getRequiredFeatureDE(casType, "sourceRelation", "org.oaqa.model.kb.Relation", featOkTst);
    casFeatCode_sourceRelation  = (null == casFeat_sourceRelation) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_sourceRelation).getCode();

  }
}



    