
/* First created by JCasGen Thu Feb 21 16:50:37 EST 2013 */
package org.oaqa.model;

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
 * Updated by JCasGen Thu Feb 21 16:50:37 EST 2013
 * @generated */
public class PassageFromTriple_Type extends Passage_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (PassageFromTriple_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = PassageFromTriple_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new PassageFromTriple(addr, PassageFromTriple_Type.this);
  			   PassageFromTriple_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new PassageFromTriple(addr, PassageFromTriple_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = PassageFromTriple.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.oaqa.model.PassageFromTriple");
 
  /** @generated */
  final Feature casFeat_sourceTriple;
  /** @generated */
  final int     casFeatCode_sourceTriple;
  /** @generated */ 
  public int getSourceTriple(int addr) {
        if (featOkTst && casFeat_sourceTriple == null)
      jcas.throwFeatMissing("sourceTriple", "org.oaqa.model.PassageFromTriple");
    return ll_cas.ll_getRefValue(addr, casFeatCode_sourceTriple);
  }
  /** @generated */    
  public void setSourceTriple(int addr, int v) {
        if (featOkTst && casFeat_sourceTriple == null)
      jcas.throwFeatMissing("sourceTriple", "org.oaqa.model.PassageFromTriple");
    ll_cas.ll_setRefValue(addr, casFeatCode_sourceTriple, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public PassageFromTriple_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_sourceTriple = jcas.getRequiredFeatureDE(casType, "sourceTriple", "org.oaqa.model.Triple", featOkTst);
    casFeatCode_sourceTriple  = (null == casFeat_sourceTriple) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_sourceTriple).getCode();

  }
}



    