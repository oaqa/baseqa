package edu.cmu.lti.oaqa.framework.data;

import java.util.ArrayList;
import java.util.List;

import org.apache.uima.jcas.JCas;
import org.oaqa.model.QueryConcept;

import edu.cmu.lti.oaqa.framework.data.QueryConceptWrapper;

/**
 * 
 * @author Leonid Boytsov <srchvrs@cmu.edu>
 * 
 */

public class BaseQAJCasHelper {
  /**
   * Store (overwrite) key terms and phrases. 
   * 
   * @param questionView
   * @param keyTerms
   * @param keyPhrases
   */
  public static void storeKeyTermsAndPhrases(JCas questionView,
      List<String> keyTerms, List<String> keyPhrases)  throws Exception  {
    List<QueryConceptWrapper> concepts = new ArrayList<QueryConceptWrapper>();
    
    for (String term: keyTerms) {
        concepts.add(new QueryConceptWrapper(term, QueryConceptTypes.KEY_TERMS.toString()));
    }
    
    for (String phrase: keyPhrases) {
      /*
      QueryConcept concept = new QueryConcept(questionView);
      concept.setConceptType(QueryConceptTypes.KEY_PHRASES.toString());
      concept.setText(phrase);
      QueryConceptWrapper wrap = new QueryConceptWrapper();
      
      wrap.wrap(concept);
      concepts.add(wrap);
      */
      concepts.add(new QueryConceptWrapper(phrase, QueryConceptTypes.KEY_PHRASES.toString()));
    }
    QueryConceptList.storeQueryConcepts(questionView, concepts);
  }
  /**
   * Load key terms and phrases.
   * 
   * @param questionView
   * @param keyterms
   */  
  public static void loadKeyTermsAndPhrases(JCas questionView,
                                           List<String> keyTerms,
                                           List<String> keyPhrases) throws Exception {
    List<QueryConceptWrapper> concepts = QueryConceptList.retrieveQueryConcepts(questionView);
    
    for (QueryConceptWrapper wrap: concepts) {
      if (wrap.getType().equals(QueryConceptTypes.KEY_PHRASES.toString())) {
        keyPhrases.add(wrap.getText());
      } else if (wrap.getType().equals(QueryConceptTypes.KEY_TERMS.toString())) {
        keyTerms.add(wrap.getText());
      } else {
        throw new Exception("Unknown concept type: " + wrap.getType());
      }
    }
  }
 }
