
/* First created by JCasGen Wed Jul 03 11:52:04 EDT 2013 */
package org.oaqa.model.nlp;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.oaqa.model.gerp.GerpAnnotation_Type;

/** The phrase in the question that indicates the answer variable.
 * Updated by JCasGen Wed Jul 03 14:53:43 EDT 2013
 * @generated */
public class Focus_Type extends GerpAnnotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Focus_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Focus_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Focus(addr, Focus_Type.this);
  			   Focus_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Focus(addr, Focus_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Focus.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.oaqa.model.nlp.Focus");
 
  /** @generated */
  final Feature casFeat_predicate;
  /** @generated */
  final int     casFeatCode_predicate;
  /** @generated */ 
  public int getPredicate(int addr) {
        if (featOkTst && casFeat_predicate == null)
      jcas.throwFeatMissing("predicate", "org.oaqa.model.nlp.Focus");
    return ll_cas.ll_getRefValue(addr, casFeatCode_predicate);
  }
  /** @generated */    
  public void setPredicate(int addr, int v) {
        if (featOkTst && casFeat_predicate == null)
      jcas.throwFeatMissing("predicate", "org.oaqa.model.nlp.Focus");
    ll_cas.ll_setRefValue(addr, casFeatCode_predicate, v);}
    
  
 
  /** @generated */
  final Feature casFeat_label;
  /** @generated */
  final int     casFeatCode_label;
  /** @generated */ 
  public String getLabel(int addr) {
        if (featOkTst && casFeat_label == null)
      jcas.throwFeatMissing("label", "org.oaqa.model.nlp.Focus");
    return ll_cas.ll_getStringValue(addr, casFeatCode_label);
  }
  /** @generated */    
  public void setLabel(int addr, String v) {
        if (featOkTst && casFeat_label == null)
      jcas.throwFeatMissing("label", "org.oaqa.model.nlp.Focus");
    ll_cas.ll_setStringValue(addr, casFeatCode_label, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Focus_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_predicate = jcas.getRequiredFeatureDE(casType, "predicate", "org.oaqa.model.nlp.Predicate", featOkTst);
    casFeatCode_predicate  = (null == casFeat_predicate) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_predicate).getCode();

 
    casFeat_label = jcas.getRequiredFeatureDE(casType, "label", "uima.cas.String", featOkTst);
    casFeatCode_label  = (null == casFeat_label) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_label).getCode();

  }
}



    