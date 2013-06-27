
/* First created by JCasGen Mon Jun 24 14:02:20 EDT 2013 */
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
import org.oaqa.model.core.OAQATop_Type;

/** A base class for GERP intermediate data: Evidence, Rank, PruningDecision.
 * Updated by JCasGen Thu Jun 27 14:37:29 EDT 2013
 * @generated */
public class GerpBase_Type extends OAQATop_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (GerpBase_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = GerpBase_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new GerpBase(addr, GerpBase_Type.this);
  			   GerpBase_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new GerpBase(addr, GerpBase_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = GerpBase.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.oaqa.model.gerp.GerpBase");
 
  /** @generated */
  final Feature casFeat_comments;
  /** @generated */
  final int     casFeatCode_comments;
  /** @generated */ 
  public int getComments(int addr) {
        if (featOkTst && casFeat_comments == null)
      jcas.throwFeatMissing("comments", "org.oaqa.model.gerp.GerpBase");
    return ll_cas.ll_getRefValue(addr, casFeatCode_comments);
  }
  /** @generated */    
  public void setComments(int addr, int v) {
        if (featOkTst && casFeat_comments == null)
      jcas.throwFeatMissing("comments", "org.oaqa.model.gerp.GerpBase");
    ll_cas.ll_setRefValue(addr, casFeatCode_comments, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public GerpBase_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_comments = jcas.getRequiredFeatureDE(casType, "comments", "uima.cas.FSList", featOkTst);
    casFeatCode_comments  = (null == casFeat_comments) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_comments).getCode();

  }
}



    