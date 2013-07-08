
/* First created by JCasGen Mon Jul 08 17:12:14 EDT 2013 */
package org.oaqa.model.kb;

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

/** A superclass for EntityMention and RelationMention.
 * Updated by JCasGen Mon Jul 08 17:12:14 EDT 2013
 * @generated */
public class ConceptMention_Type extends GerpAnnotation_Type {
  /** @generated */
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
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.oaqa.model.kb.ConceptMention");
 
  /** @generated */
  final Feature casFeat_concept;
  /** @generated */
  final int     casFeatCode_concept;
  /** @generated */ 
  public int getConcept(int addr) {
        if (featOkTst && casFeat_concept == null)
      jcas.throwFeatMissing("concept", "org.oaqa.model.kb.ConceptMention");
    return ll_cas.ll_getRefValue(addr, casFeatCode_concept);
  }
  /** @generated */    
  public void setConcept(int addr, int v) {
        if (featOkTst && casFeat_concept == null)
      jcas.throwFeatMissing("concept", "org.oaqa.model.kb.ConceptMention");
    ll_cas.ll_setRefValue(addr, casFeatCode_concept, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public ConceptMention_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_concept = jcas.getRequiredFeatureDE(casType, "concept", "org.oaqa.model.kb.Concept", featOkTst);
    casFeatCode_concept  = (null == casFeat_concept) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_concept).getCode();

  }
}



    