
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
import org.apache.uima.jcas.cas.TOP_Type;

/** A query operator in the abstract search query model.
 * Updated by JCasGen Mon Apr 13 16:42:08 EDT 2015
 * @generated */
public class QueryOperator_Type extends TOP_Type {
  /** @generated 
   * @return the generator for this type
   */
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
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.oaqa.type.retrieval.QueryOperator");
 
  /** @generated */
  final Feature casFeat_name;
  /** @generated */
  final int     casFeatCode_name;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getName(int addr) {
        if (featOkTst && casFeat_name == null)
      jcas.throwFeatMissing("name", "edu.cmu.lti.oaqa.type.retrieval.QueryOperator");
    return ll_cas.ll_getStringValue(addr, casFeatCode_name);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setName(int addr, String v) {
        if (featOkTst && casFeat_name == null)
      jcas.throwFeatMissing("name", "edu.cmu.lti.oaqa.type.retrieval.QueryOperator");
    ll_cas.ll_setStringValue(addr, casFeatCode_name, v);}
    
  
 
  /** @generated */
  final Feature casFeat_args;
  /** @generated */
  final int     casFeatCode_args;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getArgs(int addr) {
        if (featOkTst && casFeat_args == null)
      jcas.throwFeatMissing("args", "edu.cmu.lti.oaqa.type.retrieval.QueryOperator");
    return ll_cas.ll_getRefValue(addr, casFeatCode_args);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setArgs(int addr, int v) {
        if (featOkTst && casFeat_args == null)
      jcas.throwFeatMissing("args", "edu.cmu.lti.oaqa.type.retrieval.QueryOperator");
    ll_cas.ll_setRefValue(addr, casFeatCode_args, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public QueryOperator_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_name = jcas.getRequiredFeatureDE(casType, "name", "edu.cmu.lti.oaqa.type.retrieval.QueryOperatorName", featOkTst);
    casFeatCode_name  = (null == casFeat_name) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_name).getCode();

 
    casFeat_args = jcas.getRequiredFeatureDE(casType, "args", "uima.cas.StringList", featOkTst);
    casFeatCode_args  = (null == casFeat_args) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_args).getCode();

  }
}



    