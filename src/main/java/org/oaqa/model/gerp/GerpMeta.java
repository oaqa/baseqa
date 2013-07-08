

/* First created by JCasGen Mon Jul 08 17:12:14 EDT 2013 */
package org.oaqa.model.gerp;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.oaqa.model.core.OAQATop;
import org.apache.uima.jcas.cas.StringArray;


/** A GERP-style component type, which contains some generators, evidencers, rankers and pruners, that capture the common metadata shared across the feature structures (GerpTops and GerpAnnotations) to be generated in the component, e.g. the name of all generators, evidencers, rankers and pruners.
 * Updated by JCasGen Mon Jul 08 17:12:14 EDT 2013
 * XML source: C:/Users/yangz13/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class GerpMeta extends OAQATop {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(GerpMeta.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected GerpMeta() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public GerpMeta(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public GerpMeta(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: generators

  /** getter for generators - gets An array of generator names.
   * @generated */
  public StringArray getGenerators() {
    if (GerpMeta_Type.featOkTst && ((GerpMeta_Type)jcasType).casFeat_generators == null)
      jcasType.jcas.throwFeatMissing("generators", "org.oaqa.model.gerp.GerpMeta");
    return (StringArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((GerpMeta_Type)jcasType).casFeatCode_generators)));}
    
  /** setter for generators - sets An array of generator names. 
   * @generated */
  public void setGenerators(StringArray v) {
    if (GerpMeta_Type.featOkTst && ((GerpMeta_Type)jcasType).casFeat_generators == null)
      jcasType.jcas.throwFeatMissing("generators", "org.oaqa.model.gerp.GerpMeta");
    jcasType.ll_cas.ll_setRefValue(addr, ((GerpMeta_Type)jcasType).casFeatCode_generators, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for generators - gets an indexed value - An array of generator names.
   * @generated */
  public String getGenerators(int i) {
    if (GerpMeta_Type.featOkTst && ((GerpMeta_Type)jcasType).casFeat_generators == null)
      jcasType.jcas.throwFeatMissing("generators", "org.oaqa.model.gerp.GerpMeta");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((GerpMeta_Type)jcasType).casFeatCode_generators), i);
    return jcasType.ll_cas.ll_getStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((GerpMeta_Type)jcasType).casFeatCode_generators), i);}

  /** indexed setter for generators - sets an indexed value - An array of generator names.
   * @generated */
  public void setGenerators(int i, String v) { 
    if (GerpMeta_Type.featOkTst && ((GerpMeta_Type)jcasType).casFeat_generators == null)
      jcasType.jcas.throwFeatMissing("generators", "org.oaqa.model.gerp.GerpMeta");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((GerpMeta_Type)jcasType).casFeatCode_generators), i);
    jcasType.ll_cas.ll_setStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((GerpMeta_Type)jcasType).casFeatCode_generators), i, v);}
   
    
  //*--------------*
  //* Feature: evidencers

  /** getter for evidencers - gets An array of evidencer names.
   * @generated */
  public StringArray getEvidencers() {
    if (GerpMeta_Type.featOkTst && ((GerpMeta_Type)jcasType).casFeat_evidencers == null)
      jcasType.jcas.throwFeatMissing("evidencers", "org.oaqa.model.gerp.GerpMeta");
    return (StringArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((GerpMeta_Type)jcasType).casFeatCode_evidencers)));}
    
  /** setter for evidencers - sets An array of evidencer names. 
   * @generated */
  public void setEvidencers(StringArray v) {
    if (GerpMeta_Type.featOkTst && ((GerpMeta_Type)jcasType).casFeat_evidencers == null)
      jcasType.jcas.throwFeatMissing("evidencers", "org.oaqa.model.gerp.GerpMeta");
    jcasType.ll_cas.ll_setRefValue(addr, ((GerpMeta_Type)jcasType).casFeatCode_evidencers, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for evidencers - gets an indexed value - An array of evidencer names.
   * @generated */
  public String getEvidencers(int i) {
    if (GerpMeta_Type.featOkTst && ((GerpMeta_Type)jcasType).casFeat_evidencers == null)
      jcasType.jcas.throwFeatMissing("evidencers", "org.oaqa.model.gerp.GerpMeta");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((GerpMeta_Type)jcasType).casFeatCode_evidencers), i);
    return jcasType.ll_cas.ll_getStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((GerpMeta_Type)jcasType).casFeatCode_evidencers), i);}

  /** indexed setter for evidencers - sets an indexed value - An array of evidencer names.
   * @generated */
  public void setEvidencers(int i, String v) { 
    if (GerpMeta_Type.featOkTst && ((GerpMeta_Type)jcasType).casFeat_evidencers == null)
      jcasType.jcas.throwFeatMissing("evidencers", "org.oaqa.model.gerp.GerpMeta");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((GerpMeta_Type)jcasType).casFeatCode_evidencers), i);
    jcasType.ll_cas.ll_setStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((GerpMeta_Type)jcasType).casFeatCode_evidencers), i, v);}
   
    
  //*--------------*
  //* Feature: rankers

  /** getter for rankers - gets An array of ranker names.
   * @generated */
  public StringArray getRankers() {
    if (GerpMeta_Type.featOkTst && ((GerpMeta_Type)jcasType).casFeat_rankers == null)
      jcasType.jcas.throwFeatMissing("rankers", "org.oaqa.model.gerp.GerpMeta");
    return (StringArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((GerpMeta_Type)jcasType).casFeatCode_rankers)));}
    
  /** setter for rankers - sets An array of ranker names. 
   * @generated */
  public void setRankers(StringArray v) {
    if (GerpMeta_Type.featOkTst && ((GerpMeta_Type)jcasType).casFeat_rankers == null)
      jcasType.jcas.throwFeatMissing("rankers", "org.oaqa.model.gerp.GerpMeta");
    jcasType.ll_cas.ll_setRefValue(addr, ((GerpMeta_Type)jcasType).casFeatCode_rankers, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for rankers - gets an indexed value - An array of ranker names.
   * @generated */
  public String getRankers(int i) {
    if (GerpMeta_Type.featOkTst && ((GerpMeta_Type)jcasType).casFeat_rankers == null)
      jcasType.jcas.throwFeatMissing("rankers", "org.oaqa.model.gerp.GerpMeta");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((GerpMeta_Type)jcasType).casFeatCode_rankers), i);
    return jcasType.ll_cas.ll_getStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((GerpMeta_Type)jcasType).casFeatCode_rankers), i);}

  /** indexed setter for rankers - sets an indexed value - An array of ranker names.
   * @generated */
  public void setRankers(int i, String v) { 
    if (GerpMeta_Type.featOkTst && ((GerpMeta_Type)jcasType).casFeat_rankers == null)
      jcasType.jcas.throwFeatMissing("rankers", "org.oaqa.model.gerp.GerpMeta");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((GerpMeta_Type)jcasType).casFeatCode_rankers), i);
    jcasType.ll_cas.ll_setStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((GerpMeta_Type)jcasType).casFeatCode_rankers), i, v);}
   
    
  //*--------------*
  //* Feature: pruners

  /** getter for pruners - gets An array of pruner names.
   * @generated */
  public StringArray getPruners() {
    if (GerpMeta_Type.featOkTst && ((GerpMeta_Type)jcasType).casFeat_pruners == null)
      jcasType.jcas.throwFeatMissing("pruners", "org.oaqa.model.gerp.GerpMeta");
    return (StringArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((GerpMeta_Type)jcasType).casFeatCode_pruners)));}
    
  /** setter for pruners - sets An array of pruner names. 
   * @generated */
  public void setPruners(StringArray v) {
    if (GerpMeta_Type.featOkTst && ((GerpMeta_Type)jcasType).casFeat_pruners == null)
      jcasType.jcas.throwFeatMissing("pruners", "org.oaqa.model.gerp.GerpMeta");
    jcasType.ll_cas.ll_setRefValue(addr, ((GerpMeta_Type)jcasType).casFeatCode_pruners, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for pruners - gets an indexed value - An array of pruner names.
   * @generated */
  public String getPruners(int i) {
    if (GerpMeta_Type.featOkTst && ((GerpMeta_Type)jcasType).casFeat_pruners == null)
      jcasType.jcas.throwFeatMissing("pruners", "org.oaqa.model.gerp.GerpMeta");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((GerpMeta_Type)jcasType).casFeatCode_pruners), i);
    return jcasType.ll_cas.ll_getStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((GerpMeta_Type)jcasType).casFeatCode_pruners), i);}

  /** indexed setter for pruners - sets an indexed value - An array of pruner names.
   * @generated */
  public void setPruners(int i, String v) { 
    if (GerpMeta_Type.featOkTst && ((GerpMeta_Type)jcasType).casFeat_pruners == null)
      jcasType.jcas.throwFeatMissing("pruners", "org.oaqa.model.gerp.GerpMeta");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((GerpMeta_Type)jcasType).casFeatCode_pruners), i);
    jcasType.ll_cas.ll_setStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((GerpMeta_Type)jcasType).casFeatCode_pruners), i, v);}
  }

    