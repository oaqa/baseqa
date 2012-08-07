
/* First created by JCasGen Thu May 24 16:45:52 EDT 2012 */
package edu.cmu.lti.oaqa;

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

/** 
 * Updated by JCasGen Thu May 24 16:57:33 EDT 2012
 * @generated */
public class OntologyAnnotation_Type extends Annotation_Type {
  /** @generated */
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (OntologyAnnotation_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = OntologyAnnotation_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new OntologyAnnotation(addr, OntologyAnnotation_Type.this);
  			   OntologyAnnotation_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new OntologyAnnotation(addr, OntologyAnnotation_Type.this);
  	  }
    };
  /** @generated */
  public final static int typeIndexID = OntologyAnnotation.typeIndexID;
  /** @generated 
     @modifiable */
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.oaqa.OntologyAnnotation");
 
  /** @generated */
  final Feature casFeat_ComponentID;
  /** @generated */
  final int     casFeatCode_ComponentID;
  /** @generated */ 
  public String getComponentID(int addr) {
        if (featOkTst && casFeat_ComponentID == null)
      jcas.throwFeatMissing("ComponentID", "edu.cmu.lti.oaqa.OntologyAnnotation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_ComponentID);
  }
  /** @generated */    
  public void setComponentID(int addr, String v) {
        if (featOkTst && casFeat_ComponentID == null)
      jcas.throwFeatMissing("ComponentID", "edu.cmu.lti.oaqa.OntologyAnnotation");
    ll_cas.ll_setStringValue(addr, casFeatCode_ComponentID, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public OntologyAnnotation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_ComponentID = jcas.getRequiredFeatureDE(casType, "ComponentID", "uima.cas.String", featOkTst);
    casFeatCode_ComponentID  = (null == casFeat_ComponentID) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_ComponentID).getCode();

  }
}



    