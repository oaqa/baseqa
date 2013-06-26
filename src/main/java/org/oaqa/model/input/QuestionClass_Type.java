
/* First created by JCasGen Mon Jun 24 14:02:20 EDT 2013 */
package org.oaqa.model.input;

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

/** The class of the question, determined by an automatic question classification process.
 * Updated by JCasGen Wed Jun 26 17:33:02 EDT 2013
 * @generated */
public class QuestionClass_Type extends GerpAnnotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (QuestionClass_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = QuestionClass_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new QuestionClass(addr, QuestionClass_Type.this);
  			   QuestionClass_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new QuestionClass(addr, QuestionClass_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = QuestionClass.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.oaqa.model.input.QuestionClass");
 
  /** @generated */
  final Feature casFeat_questionClass;
  /** @generated */
  final int     casFeatCode_questionClass;
  /** @generated */ 
  public String getQuestionClass(int addr) {
        if (featOkTst && casFeat_questionClass == null)
      jcas.throwFeatMissing("questionClass", "org.oaqa.model.input.QuestionClass");
    return ll_cas.ll_getStringValue(addr, casFeatCode_questionClass);
  }
  /** @generated */    
  public void setQuestionClass(int addr, String v) {
        if (featOkTst && casFeat_questionClass == null)
      jcas.throwFeatMissing("questionClass", "org.oaqa.model.input.QuestionClass");
    ll_cas.ll_setStringValue(addr, casFeatCode_questionClass, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public QuestionClass_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_questionClass = jcas.getRequiredFeatureDE(casType, "questionClass", "org.oaqa.model.input.QuestionClassType", featOkTst);
    casFeatCode_questionClass  = (null == casFeat_questionClass) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_questionClass).getCode();

  }
}



    