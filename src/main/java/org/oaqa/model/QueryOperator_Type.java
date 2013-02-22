
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

/** A query operator in the abstract search query model.
 * Updated by JCasGen Thu Feb 21 16:50:37 EST 2013
 * @generated */
public class QueryOperator_Type extends OAQATop_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (QueryOperator_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = QueryOperator_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new QueryOperator(addr, QueryOperator_Type.this);
  			   QueryOperator_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new QueryOperator(addr, QueryOperator_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = QueryOperator.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.oaqa.model.QueryOperator");
 
  /** @generated */
  final Feature casFeat_name;
  /** @generated */
  final int     casFeatCode_name;
  /** @generated */ 
  public String getName(int addr) {
        if (featOkTst && casFeat_name == null)
      jcas.throwFeatMissing("name", "org.oaqa.model.QueryOperator");
    return ll_cas.ll_getStringValue(addr, casFeatCode_name);
  }
  /** @generated */    
  public void setName(int addr, String v) {
        if (featOkTst && casFeat_name == null)
      jcas.throwFeatMissing("name", "org.oaqa.model.QueryOperator");
    ll_cas.ll_setStringValue(addr, casFeatCode_name, v);}
    
  
 
  /** @generated */
  final Feature casFeat_args;
  /** @generated */
  final int     casFeatCode_args;
  /** @generated */ 
  public int getArgs(int addr) {
        if (featOkTst && casFeat_args == null)
      jcas.throwFeatMissing("args", "org.oaqa.model.QueryOperator");
    return ll_cas.ll_getRefValue(addr, casFeatCode_args);
  }
  /** @generated */    
  public void setArgs(int addr, int v) {
        if (featOkTst && casFeat_args == null)
      jcas.throwFeatMissing("args", "org.oaqa.model.QueryOperator");
    ll_cas.ll_setRefValue(addr, casFeatCode_args, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public QueryOperator_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_name = jcas.getRequiredFeatureDE(casType, "name", "org.oaqa.model.QueryOperatorName", featOkTst);
    casFeatCode_name  = (null == casFeat_name) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_name).getCode();

 
    casFeat_args = jcas.getRequiredFeatureDE(casType, "args", "uima.cas.StringList", featOkTst);
    casFeatCode_args  = (null == casFeat_args) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_args).getCode();

  }
}



    