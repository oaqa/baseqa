
/* First created by JCasGen Sun Oct 19 14:47:24 EDT 2014 */
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
import org.apache.uima.jcas.tcas.Annotation_Type;

/** A superclass for EntityMention and RelationMention.
 * Updated by JCasGen Sun Oct 19 14:47:24 EDT 2014
 * @generated */
public class ConceptMention_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (ConceptMention_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = ConceptMention_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new ConceptMention(addr, ConceptMention_Type.this);
  			   ConceptMention_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new ConceptMention(addr, ConceptMention_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = ConceptMention.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.oaqa.type.kb.ConceptMention");
 
  /** @generated */
  final Feature casFeat_concept;
  /** @generated */
  final int     casFeatCode_concept;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getConcept(int addr) {
        if (featOkTst && casFeat_concept == null)
      jcas.throwFeatMissing("concept", "edu.cmu.lti.oaqa.type.kb.ConceptMention");
    return ll_cas.ll_getRefValue(addr, casFeatCode_concept);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setConcept(int addr, int v) {
        if (featOkTst && casFeat_concept == null)
      jcas.throwFeatMissing("concept", "edu.cmu.lti.oaqa.type.kb.ConceptMention");
    ll_cas.ll_setRefValue(addr, casFeatCode_concept, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public ConceptMention_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_concept = jcas.getRequiredFeatureDE(casType, "concept", "edu.cmu.lti.oaqa.type.kb.Concept", featOkTst);
    casFeatCode_concept  = (null == casFeat_concept) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_concept).getCode();

  }
}



    