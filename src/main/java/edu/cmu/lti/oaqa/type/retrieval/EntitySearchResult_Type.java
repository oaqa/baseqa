
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

/** A search result from an ontology.
 * Updated by JCasGen Sat Aug 16 20:55:37 EDT 2014
 * @generated */
public class EntitySearchResult_Type extends AnswerSearchResult_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (EntitySearchResult_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = EntitySearchResult_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new EntitySearchResult(addr, EntitySearchResult_Type.this);
  			   EntitySearchResult_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new EntitySearchResult(addr, EntitySearchResult_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = EntitySearchResult.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.oaqa.type.retrieval.EntitySearchResult");
 
  /** @generated */
  final Feature casFeat_entities;
  /** @generated */
  final int     casFeatCode_entities;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getEntities(int addr) {
        if (featOkTst && casFeat_entities == null)
      jcas.throwFeatMissing("entities", "edu.cmu.lti.oaqa.type.retrieval.EntitySearchResult");
    return ll_cas.ll_getRefValue(addr, casFeatCode_entities);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setEntities(int addr, int v) {
        if (featOkTst && casFeat_entities == null)
      jcas.throwFeatMissing("entities", "edu.cmu.lti.oaqa.type.retrieval.EntitySearchResult");
    ll_cas.ll_setRefValue(addr, casFeatCode_entities, v);}
    
   /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @return value at index i in the array 
   */
  public int getEntities(int addr, int i) {
        if (featOkTst && casFeat_entities == null)
      jcas.throwFeatMissing("entities", "edu.cmu.lti.oaqa.type.retrieval.EntitySearchResult");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_entities), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_entities), i);
  return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_entities), i);
  }
   
  /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @param v value to set
   */ 
  public void setEntities(int addr, int i, int v) {
        if (featOkTst && casFeat_entities == null)
      jcas.throwFeatMissing("entities", "edu.cmu.lti.oaqa.type.retrieval.EntitySearchResult");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_entities), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_entities), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_entities), i, v);
  }
 



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public EntitySearchResult_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_entities = jcas.getRequiredFeatureDE(casType, "entities", "uima.cas.FSArray", featOkTst);
    casFeatCode_entities  = (null == casFeat_entities) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_entities).getCode();

  }
}



    