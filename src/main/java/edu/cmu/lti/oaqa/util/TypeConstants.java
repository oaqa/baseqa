package edu.cmu.lti.oaqa.util;

import edu.cmu.lti.oaqa.type.nlp.Token;

public class TypeConstants {

  public enum QueryOperatorName {
    SYNONYM, PHRASE, TIE, WEIGHT, REQUIRED, RELATION, QUOTEDPHRASE;
  }

  public enum ConceptType {
    KEYWORD_TYPE, QATOKEN_TYPE, ANSWER_TYPE;
  }

  public static final int RANK_UNKNOWN = -1;

  public static final double SCORE_UNKNOWN = Double.NaN;

  public static final String NAME_UNKNOWN = null;

  public static final String TITLE_UNKNOWN = null;

  public static final String TEXT_UNKNOWN = null;

  public static final String QUERY_STRING_UNKNOWN = null;

  public static final String SEARCH_ID_UNKNOWN = null;

  public static final String ASPECTS_UNKNOWN = null;

  public static final String URI_UNKNOWN = null;

  public static final String DOC_ID_UNKNOWN = null;
  
  public static final Token HEAD_UNKNOWN = null;

  public static final String DEPLABEL_UNKNOWN = null;

  public static final String SEMANTIC_TYPE_UNKNOWN = null;

  public static final String PART_OF_SPEECH_UNKNOWN = null;

  public static final String LEMMA_FORM_UNKNOWN = null;

  public static final boolean IS_MAIN_REFERENCE_UNKNOWN = false;

  public static final boolean IS_VARIABLE_UNKNOWN = false;

  public static final String DETERMINER_UNKNOWN = null;

}
