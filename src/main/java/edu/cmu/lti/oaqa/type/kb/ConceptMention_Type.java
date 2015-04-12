
/* First created by JCasGen Sat Apr 11 19:49:33 EDT 2015 */
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
 * Updated by JCasGen Mon Apr 13 16:42:08 EDT 2015
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
    
  
 
  /** @generated */
  final Feature casFeat_matchedName;
  /** @generated */
  final int     casFeatCode_matchedName;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getMatchedName(int addr) {
        if (featOkTst && casFeat_matchedName == null)
      jcas.throwFeatMissing("matchedName", "edu.cmu.lti.oaqa.type.kb.ConceptMention");
    return ll_cas.ll_getStringValue(addr, casFeatCode_matchedName);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setMatchedName(int addr, String v) {
        if (featOkTst && casFeat_matchedName == null)
      jcas.throwFeatMissing("matchedName", "edu.cmu.lti.oaqa.type.kb.ConceptMention");
    ll_cas.ll_setStringValue(addr, casFeatCode_matchedName, v);}
    
  
 
  /** @generated */
  final Feature casFeat_score;
  /** @generated */
  final int     casFeatCode_score;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public double getScore(int addr) {
        if (featOkTst && casFeat_score == null)
      jcas.throwFeatMissing("score", "edu.cmu.lti.oaqa.type.kb.ConceptMention");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_score);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setScore(int addr, double v) {
        if (featOkTst && casFeat_score == null)
      jcas.throwFeatMissing("score", "edu.cmu.lti.oaqa.type.kb.ConceptMention");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_score, v);}
    
  



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

 
    casFeat_matchedName = jcas.getRequiredFeatureDE(casType, "matchedName", "uima.cas.String", featOkTst);
    casFeatCode_matchedName  = (null == casFeat_matchedName) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_matchedName).getCode();

 
    casFeat_score = jcas.getRequiredFeatureDE(casType, "score", "uima.cas.Double", featOkTst);
    casFeatCode_score  = (null == casFeat_score) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_score).getCode();

  }
}



    