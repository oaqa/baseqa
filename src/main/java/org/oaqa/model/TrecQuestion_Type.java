
/* First created by JCasGen Mon Oct 08 18:56:44 EDT 2012 */
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

/** A TREC evaluation question.
 * Updated by JCasGen Thu Oct 11 12:34:48 EDT 2012
 * @generated */
public class TrecQuestion_Type extends Question_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (TrecQuestion_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = TrecQuestion_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new TrecQuestion(addr, TrecQuestion_Type.this);
  			   TrecQuestion_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new TrecQuestion(addr, TrecQuestion_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = TrecQuestion.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.oaqa.model.TrecQuestion");
 
  /** @generated */
  final Feature casFeat_qType;
  /** @generated */
  final int     casFeatCode_qType;
  /** @generated */ 
  public String getQType(int addr) {
        if (featOkTst && casFeat_qType == null)
      jcas.throwFeatMissing("qType", "org.oaqa.model.TrecQuestion");
    return ll_cas.ll_getStringValue(addr, casFeatCode_qType);
  }
  /** @generated */    
  public void setQType(int addr, String v) {
        if (featOkTst && casFeat_qType == null)
      jcas.throwFeatMissing("qType", "org.oaqa.model.TrecQuestion");
    ll_cas.ll_setStringValue(addr, casFeatCode_qType, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public TrecQuestion_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_qType = jcas.getRequiredFeatureDE(casType, "qType", "org.oaqa.model.QuestionClass", featOkTst);
    casFeatCode_qType  = (null == casFeat_qType) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_qType).getCode();

  }
}



    