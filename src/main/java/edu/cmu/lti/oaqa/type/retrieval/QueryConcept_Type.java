
/* First created by JCasGen Sun Oct 05 18:02:25 EDT 2014 */
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

/** A query concept in the abstract search query model.
 * Updated by JCasGen Mon Oct 06 20:47:19 EDT 2014
 * @generated */
public class QueryConcept_Type extends TOP_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (QueryConcept_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = QueryConcept_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new QueryConcept(addr, QueryConcept_Type.this);
  			   QueryConcept_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new QueryConcept(addr, QueryConcept_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = QueryConcept.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.oaqa.type.retrieval.QueryConcept");
 
  /** @generated */
  final Feature casFeat_namedEntityTypes;
  /** @generated */
  final int     casFeatCode_namedEntityTypes;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getNamedEntityTypes(int addr) {
        if (featOkTst && casFeat_namedEntityTypes == null)
      jcas.throwFeatMissing("namedEntityTypes", "edu.cmu.lti.oaqa.type.retrieval.QueryConcept");
    return ll_cas.ll_getRefValue(addr, casFeatCode_namedEntityTypes);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setNamedEntityTypes(int addr, int v) {
        if (featOkTst && casFeat_namedEntityTypes == null)
      jcas.throwFeatMissing("namedEntityTypes", "edu.cmu.lti.oaqa.type.retrieval.QueryConcept");
    ll_cas.ll_setRefValue(addr, casFeatCode_namedEntityTypes, v);}
    
  
 
  /** @generated */
  final Feature casFeat_conceptType;
  /** @generated */
  final int     casFeatCode_conceptType;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getConceptType(int addr) {
        if (featOkTst && casFeat_conceptType == null)
      jcas.throwFeatMissing("conceptType", "edu.cmu.lti.oaqa.type.retrieval.QueryConcept");
    return ll_cas.ll_getStringValue(addr, casFeatCode_conceptType);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setConceptType(int addr, String v) {
        if (featOkTst && casFeat_conceptType == null)
      jcas.throwFeatMissing("conceptType", "edu.cmu.lti.oaqa.type.retrieval.QueryConcept");
    ll_cas.ll_setStringValue(addr, casFeatCode_conceptType, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public QueryConcept_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_namedEntityTypes = jcas.getRequiredFeatureDE(casType, "namedEntityTypes", "uima.cas.StringList", featOkTst);
    casFeatCode_namedEntityTypes  = (null == casFeat_namedEntityTypes) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_namedEntityTypes).getCode();

 
    casFeat_conceptType = jcas.getRequiredFeatureDE(casType, "conceptType", "edu.cmu.lti.oaqa.type.retrieval.ConceptType", featOkTst);
    casFeatCode_conceptType  = (null == casFeat_conceptType) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_conceptType).getCode();

  }
}



    