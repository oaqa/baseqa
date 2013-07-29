

/* First created by JCasGen Mon Jul 08 17:12:14 EDT 2013 */
package org.oaqa.model.nlp;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.cas.StringArray;
import org.oaqa.model.gerp.GerpAnnotation;


/** Annotation on a token, which may have arguments if they are predicates; useful in transforming text into a "logical form", with affordances similar to the ones provided in Extended WordNet and the like. --- Source: Murdock
 * Updated by JCasGen Mon Jul 29 18:17:35 EDT 2013
 * XML source: C:/Users/yangz13/QA/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class Token extends GerpAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Token.class);
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
  protected Token() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Token(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Token(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Token(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: arguments

  /** getter for arguments - gets The arguments
   * @generated */
  public FSArray getArguments() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_arguments == null)
      jcasType.jcas.throwFeatMissing("arguments", "org.oaqa.model.nlp.Token");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Token_Type)jcasType).casFeatCode_arguments)));}
    
  /** setter for arguments - sets The arguments 
   * @generated */
  public void setArguments(FSArray v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_arguments == null)
      jcasType.jcas.throwFeatMissing("arguments", "org.oaqa.model.nlp.Token");
    jcasType.ll_cas.ll_setRefValue(addr, ((Token_Type)jcasType).casFeatCode_arguments, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for arguments - gets an indexed value - The arguments
   * @generated */
  public Token getArguments(int i) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_arguments == null)
      jcasType.jcas.throwFeatMissing("arguments", "org.oaqa.model.nlp.Token");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Token_Type)jcasType).casFeatCode_arguments), i);
    return (Token)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Token_Type)jcasType).casFeatCode_arguments), i)));}

  /** indexed setter for arguments - sets an indexed value - The arguments
   * @generated */
  public void setArguments(int i, Token v) { 
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_arguments == null)
      jcasType.jcas.throwFeatMissing("arguments", "org.oaqa.model.nlp.Token");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Token_Type)jcasType).casFeatCode_arguments), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Token_Type)jcasType).casFeatCode_arguments), i, jcasType.ll_cas.ll_getFSRef(v));}
   
    
  //*--------------*
  //* Feature: argumentLabels

  /** getter for argumentLabels - gets The slot labels for the arguments (e.g., subj, obj, objprep)
   * @generated */
  public StringArray getArgumentLabels() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_argumentLabels == null)
      jcasType.jcas.throwFeatMissing("argumentLabels", "org.oaqa.model.nlp.Token");
    return (StringArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Token_Type)jcasType).casFeatCode_argumentLabels)));}
    
  /** setter for argumentLabels - sets The slot labels for the arguments (e.g., subj, obj, objprep) 
   * @generated */
  public void setArgumentLabels(StringArray v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_argumentLabels == null)
      jcasType.jcas.throwFeatMissing("argumentLabels", "org.oaqa.model.nlp.Token");
    jcasType.ll_cas.ll_setRefValue(addr, ((Token_Type)jcasType).casFeatCode_argumentLabels, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for argumentLabels - gets an indexed value - The slot labels for the arguments (e.g., subj, obj, objprep)
   * @generated */
  public String getArgumentLabels(int i) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_argumentLabels == null)
      jcasType.jcas.throwFeatMissing("argumentLabels", "org.oaqa.model.nlp.Token");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Token_Type)jcasType).casFeatCode_argumentLabels), i);
    return jcasType.ll_cas.ll_getStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Token_Type)jcasType).casFeatCode_argumentLabels), i);}

  /** indexed setter for argumentLabels - sets an indexed value - The slot labels for the arguments (e.g., subj, obj, objprep)
   * @generated */
  public void setArgumentLabels(int i, String v) { 
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_argumentLabels == null)
      jcasType.jcas.throwFeatMissing("argumentLabels", "org.oaqa.model.nlp.Token");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Token_Type)jcasType).casFeatCode_argumentLabels), i);
    jcasType.ll_cas.ll_setStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Token_Type)jcasType).casFeatCode_argumentLabels), i, v);}
   
    
  //*--------------*
  //* Feature: parse

  /** getter for parse - gets A parse for which this token was a head (if any)
   * @generated */
  public Token getParse() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_parse == null)
      jcasType.jcas.throwFeatMissing("parse", "org.oaqa.model.nlp.Token");
    return (Token)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Token_Type)jcasType).casFeatCode_parse)));}
    
  /** setter for parse - sets A parse for which this token was a head (if any) 
   * @generated */
  public void setParse(Token v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_parse == null)
      jcasType.jcas.throwFeatMissing("parse", "org.oaqa.model.nlp.Token");
    jcasType.ll_cas.ll_setRefValue(addr, ((Token_Type)jcasType).casFeatCode_parse, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: semanticType

  /** getter for semanticType - gets A semantic type, typically the name of an Entity Annotation type
   * @generated */
  public String getSemanticType() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_semanticType == null)
      jcasType.jcas.throwFeatMissing("semanticType", "org.oaqa.model.nlp.Token");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Token_Type)jcasType).casFeatCode_semanticType);}
    
  /** setter for semanticType - sets A semantic type, typically the name of an Entity Annotation type 
   * @generated */
  public void setSemanticType(String v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_semanticType == null)
      jcasType.jcas.throwFeatMissing("semanticType", "org.oaqa.model.nlp.Token");
    jcasType.ll_cas.ll_setStringValue(addr, ((Token_Type)jcasType).casFeatCode_semanticType, v);}    
   
    
  //*--------------*
  //* Feature: partOfSpeech

  /** getter for partOfSpeech - gets Coarse-grained part of speech --- Example: noun, verb, adj, cord
   * @generated */
  public String getPartOfSpeech() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_partOfSpeech == null)
      jcasType.jcas.throwFeatMissing("partOfSpeech", "org.oaqa.model.nlp.Token");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Token_Type)jcasType).casFeatCode_partOfSpeech);}
    
  /** setter for partOfSpeech - sets Coarse-grained part of speech --- Example: noun, verb, adj, cord 
   * @generated */
  public void setPartOfSpeech(String v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_partOfSpeech == null)
      jcasType.jcas.throwFeatMissing("partOfSpeech", "org.oaqa.model.nlp.Token");
    jcasType.ll_cas.ll_setStringValue(addr, ((Token_Type)jcasType).casFeatCode_partOfSpeech, v);}    
   
    
  //*--------------*
  //* Feature: lemmaForm

  /** getter for lemmaForm - gets A canonical/lemmatized form of the covered text
   * @generated */
  public String getLemmaForm() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_lemmaForm == null)
      jcasType.jcas.throwFeatMissing("lemmaForm", "org.oaqa.model.nlp.Token");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Token_Type)jcasType).casFeatCode_lemmaForm);}
    
  /** setter for lemmaForm - sets A canonical/lemmatized form of the covered text 
   * @generated */
  public void setLemmaForm(String v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_lemmaForm == null)
      jcasType.jcas.throwFeatMissing("lemmaForm", "org.oaqa.model.nlp.Token");
    jcasType.ll_cas.ll_setStringValue(addr, ((Token_Type)jcasType).casFeatCode_lemmaForm, v);}    
   
    
  //*--------------*
  //* Feature: isMainReference

  /** getter for isMainReference - gets If true, then this is the main reference to the first argument.  Modifiers and anaphoric references do not have isMainReference set. --- Example: "A dark blue [hat]"
   * @generated */
  public boolean getIsMainReference() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_isMainReference == null)
      jcasType.jcas.throwFeatMissing("isMainReference", "org.oaqa.model.nlp.Token");
    return jcasType.ll_cas.ll_getBooleanValue(addr, ((Token_Type)jcasType).casFeatCode_isMainReference);}
    
  /** setter for isMainReference - sets If true, then this is the main reference to the first argument.  Modifiers and anaphoric references do not have isMainReference set. --- Example: "A dark blue [hat]" 
   * @generated */
  public void setIsMainReference(boolean v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_isMainReference == null)
      jcasType.jcas.throwFeatMissing("isMainReference", "org.oaqa.model.nlp.Token");
    jcasType.ll_cas.ll_setBooleanValue(addr, ((Token_Type)jcasType).casFeatCode_isMainReference, v);}    
   
    
  //*--------------*
  //* Feature: isVariable

  /** getter for isVariable - gets True iff the token expresses some unknown entity, typically the focus of a question:  --- Example: "[Who] shot JR?", "What [city] was JR born in?"
   * @generated */
  public boolean getIsVariable() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_isVariable == null)
      jcasType.jcas.throwFeatMissing("isVariable", "org.oaqa.model.nlp.Token");
    return jcasType.ll_cas.ll_getBooleanValue(addr, ((Token_Type)jcasType).casFeatCode_isVariable);}
    
  /** setter for isVariable - sets True iff the token expresses some unknown entity, typically the focus of a question:  --- Example: "[Who] shot JR?", "What [city] was JR born in?" 
   * @generated */
  public void setIsVariable(boolean v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_isVariable == null)
      jcasType.jcas.throwFeatMissing("isVariable", "org.oaqa.model.nlp.Token");
    jcasType.ll_cas.ll_setBooleanValue(addr, ((Token_Type)jcasType).casFeatCode_isVariable, v);}    
   
    
  //*--------------*
  //* Feature: determiner

  /** getter for determiner - gets The determiner attached to the node, if any --- Example: [the] book
   * @generated */
  public String getDeterminer() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_determiner == null)
      jcasType.jcas.throwFeatMissing("determiner", "org.oaqa.model.nlp.Token");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Token_Type)jcasType).casFeatCode_determiner);}
    
  /** setter for determiner - sets The determiner attached to the node, if any --- Example: [the] book 
   * @generated */
  public void setDeterminer(String v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_determiner == null)
      jcasType.jcas.throwFeatMissing("determiner", "org.oaqa.model.nlp.Token");
    jcasType.ll_cas.ll_setStringValue(addr, ((Token_Type)jcasType).casFeatCode_determiner, v);}    
  }

    