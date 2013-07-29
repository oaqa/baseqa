
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
import org.oaqa.model.gerp.GerpTop_Type;

/** An abstract search query for the question that represents query concepts and query operators over those concepts.
 * Updated by JCasGen Mon Jul 29 18:17:35 EDT 2013
 * @generated */
public class AbstractQuery_Type extends GerpTop_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (AbstractQuery_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = AbstractQuery_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new AbstractQuery(addr, AbstractQuery_Type.this);
  			   AbstractQuery_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new AbstractQuery(addr, AbstractQuery_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = AbstractQuery.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.oaqa.model.retrieval.AbstractQuery");
 
  /** @generated */
  final Feature casFeat_concepts;
  /** @generated */
  final int     casFeatCode_concepts;
  /** @generated */ 
  public int getConcepts(int addr) {
        if (featOkTst && casFeat_concepts == null)
      jcas.throwFeatMissing("concepts", "org.oaqa.model.retrieval.AbstractQuery");
    return ll_cas.ll_getRefValue(addr, casFeatCode_concepts);
  }
  /** @generated */    
  public void setConcepts(int addr, int v) {
        if (featOkTst && casFeat_concepts == null)
      jcas.throwFeatMissing("concepts", "org.oaqa.model.retrieval.AbstractQuery");
    ll_cas.ll_setRefValue(addr, casFeatCode_concepts, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public AbstractQuery_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_concepts = jcas.getRequiredFeatureDE(casType, "concepts", "uima.cas.FSList", featOkTst);
    casFeatCode_concepts  = (null == casFeat_concepts) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_concepts).getCode();

  }
}



    