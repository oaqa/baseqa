
/* First created by JCasGen Tue Aug 05 23:03:53 EDT 2014 */
package edu.cmu.lti.oaqa.type.kb;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;

/** A named relation mention that identify or define the named relation concept.
 * Updated by JCasGen Tue Sep 30 18:21:24 EDT 2014
 * @generated */
public class RelationMention_Type extends ConceptMention_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (RelationMention_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = RelationMention_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new RelationMention(addr, RelationMention_Type.this);
  			   RelationMention_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new RelationMention(addr, RelationMention_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = RelationMention.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.oaqa.type.kb.RelationMention");
 
  /** @generated */
  final Feature casFeat_argumentMentions;
  /** @generated */
  final int     casFeatCode_argumentMentions;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getArgumentMentions(int addr) {
        if (featOkTst && casFeat_argumentMentions == null)
      jcas.throwFeatMissing("argumentMentions", "edu.cmu.lti.oaqa.type.kb.RelationMention");
    return ll_cas.ll_getRefValue(addr, casFeatCode_argumentMentions);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setArgumentMentions(int addr, int v) {
        if (featOkTst && casFeat_argumentMentions == null)
      jcas.throwFeatMissing("argumentMentions", "edu.cmu.lti.oaqa.type.kb.RelationMention");
    ll_cas.ll_setRefValue(addr, casFeatCode_argumentMentions, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public RelationMention_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_argumentMentions = jcas.getRequiredFeatureDE(casType, "argumentMentions", "uima.cas.FSList", featOkTst);
    casFeatCode_argumentMentions  = (null == casFeat_argumentMentions) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_argumentMentions).getCode();

  }
}



    