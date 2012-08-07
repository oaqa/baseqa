
/* First created by JCasGen Thu May 24 16:45:52 EDT 2012 */
package edu.cmu.lti.bio.ie;

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

/** Ontology annotation from Open Biological Ontology format file.  Labels a word as having been found in the list of [Term]s contained in an OBO format ontology, as well as the name of the ontology file in which it was found.
 * Updated by JCasGen Thu May 24 16:57:33 EDT 2012
 * @generated */
public class OBOtation_Type extends Annotation_Type {
  /** @generated */
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (OBOtation_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = OBOtation_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new OBOtation(addr, OBOtation_Type.this);
  			   OBOtation_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new OBOtation(addr, OBOtation_Type.this);
  	  }
    };
  /** @generated */
  public final static int typeIndexID = OBOtation.typeIndexID;
  /** @generated 
     @modifiable */
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.bio.ie.OBOtation");
 
  /** @generated */
  final Feature casFeat_OntologyFile;
  /** @generated */
  final int     casFeatCode_OntologyFile;
  /** @generated */ 
  public String getOntologyFile(int addr) {
        if (featOkTst && casFeat_OntologyFile == null)
      jcas.throwFeatMissing("OntologyFile", "edu.cmu.lti.bio.ie.OBOtation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_OntologyFile);
  }
  /** @generated */    
  public void setOntologyFile(int addr, String v) {
        if (featOkTst && casFeat_OntologyFile == null)
      jcas.throwFeatMissing("OntologyFile", "edu.cmu.lti.bio.ie.OBOtation");
    ll_cas.ll_setStringValue(addr, casFeatCode_OntologyFile, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public OBOtation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_OntologyFile = jcas.getRequiredFeatureDE(casType, "OntologyFile", "uima.cas.String", featOkTst);
    casFeatCode_OntologyFile  = (null == casFeat_OntologyFile) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_OntologyFile).getCode();

  }
}



    