
/* First created by JCasGen Wed Jul 03 11:51:45 EDT 2013 */
package org.oaqa.model.gerp;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;

/** A type represents the pruning decision for the candidate entities, which is provided by a pruner.
 * Updated by JCasGen Wed Jul 03 14:53:43 EDT 2013
 * @generated */
public class PruningDecision_Type extends GerpBase_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (PruningDecision_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = PruningDecision_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new PruningDecision(addr, PruningDecision_Type.this);
  			   PruningDecision_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new PruningDecision(addr, PruningDecision_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = PruningDecision.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.oaqa.model.gerp.PruningDecision");
 
  /** @generated */
  final Feature casFeat_decision;
  /** @generated */
  final int     casFeatCode_decision;
  /** @generated */ 
  public boolean getDecision(int addr) {
        if (featOkTst && casFeat_decision == null)
      jcas.throwFeatMissing("decision", "org.oaqa.model.gerp.PruningDecision");
    return ll_cas.ll_getBooleanValue(addr, casFeatCode_decision);
  }
  /** @generated */    
  public void setDecision(int addr, boolean v) {
        if (featOkTst && casFeat_decision == null)
      jcas.throwFeatMissing("decision", "org.oaqa.model.gerp.PruningDecision");
    ll_cas.ll_setBooleanValue(addr, casFeatCode_decision, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public PruningDecision_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_decision = jcas.getRequiredFeatureDE(casType, "decision", "uima.cas.Boolean", featOkTst);
    casFeatCode_decision  = (null == casFeat_decision) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_decision).getCode();

  }
}



    