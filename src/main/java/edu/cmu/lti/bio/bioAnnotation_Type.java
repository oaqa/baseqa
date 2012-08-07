
/* First created by JCasGen Thu May 24 16:45:52 EDT 2012 */
package edu.cmu.lti.bio;

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

/** Annotation from which others inherit ComponentID and other common attributes
 * Updated by JCasGen Thu May 24 16:57:33 EDT 2012
 * @generated */
public class bioAnnotation_Type extends Annotation_Type {
  /** @generated */
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (bioAnnotation_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = bioAnnotation_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new bioAnnotation(addr, bioAnnotation_Type.this);
  			   bioAnnotation_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new bioAnnotation(addr, bioAnnotation_Type.this);
  	  }
    };
  /** @generated */
  public final static int typeIndexID = bioAnnotation.typeIndexID;
  /** @generated 
     @modifiable */
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.bio.bioAnnotation");
 
  /** @generated */
  final Feature casFeat_ComponentID;
  /** @generated */
  final int     casFeatCode_ComponentID;
  /** @generated */ 
  public String getComponentID(int addr) {
        if (featOkTst && casFeat_ComponentID == null)
      jcas.throwFeatMissing("ComponentID", "edu.cmu.lti.bio.bioAnnotation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_ComponentID);
  }
  /** @generated */    
  public void setComponentID(int addr, String v) {
        if (featOkTst && casFeat_ComponentID == null)
      jcas.throwFeatMissing("ComponentID", "edu.cmu.lti.bio.bioAnnotation");
    ll_cas.ll_setStringValue(addr, casFeatCode_ComponentID, v);}
    
  
 
  /** @generated */
  final Feature casFeat_Version;
  /** @generated */
  final int     casFeatCode_Version;
  /** @generated */ 
  public String getVersion(int addr) {
        if (featOkTst && casFeat_Version == null)
      jcas.throwFeatMissing("Version", "edu.cmu.lti.bio.bioAnnotation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Version);
  }
  /** @generated */    
  public void setVersion(int addr, String v) {
        if (featOkTst && casFeat_Version == null)
      jcas.throwFeatMissing("Version", "edu.cmu.lti.bio.bioAnnotation");
    ll_cas.ll_setStringValue(addr, casFeatCode_Version, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public bioAnnotation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_ComponentID = jcas.getRequiredFeatureDE(casType, "ComponentID", "uima.cas.String", featOkTst);
    casFeatCode_ComponentID  = (null == casFeat_ComponentID) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_ComponentID).getCode();

 
    casFeat_Version = jcas.getRequiredFeatureDE(casType, "Version", "uima.cas.String", featOkTst);
    casFeatCode_Version  = (null == casFeat_Version) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Version).getCode();

  }
}



    