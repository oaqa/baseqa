/*
 *  Copyright 2013 Carnegie Mellon University
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package edu.cmu.lti.oaqa.framework.data.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.AnswerType;


import edu.cmu.lti.oaqa.framework.data.QueryConceptWrapper;
import edu.cmu.lti.oaqa.framework.data.QueryConceptList;
import edu.cmu.lti.oaqa.framework.data.QueryConceptTypes;


/**
 * 
 *  Helper functions to store/retrieve data to/from a CAS.
 *
 * @author Rui Liu 
 * @author Leonid Boytsov 
 * 
 */


public class JCasHelper {
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

  /**
   * Retrieve an answer type from a CAS.
   * 
   * @param questionView
   * @return answerType
   */
  public static String loadAnswerType(JCas questionView) {
    String result = null;
    AnnotationIndex<?> index = questionView.getAnnotationIndex(AnswerType.type);
    Iterator<?> it = index.iterator();

    if (it.hasNext()) {
      AnswerType atype = (AnswerType) it.next();
      result = atype.getLabel();
    }
    return result;
  }

  /**
   * Stores (overwrite) an answer type in a cas
   * 
   * @param questionView
   * @param type
   */
  public static void storeAnswerType(JCas questionView, String type) {
		// Remove previous entries first
		Iterator<?> it = questionView.getJFSIndexRepository().getAllIndexedFS(AnswerType.type);
		while (it.hasNext()) {
			AnswerType oaqaType = (AnswerType) it.next();
        oaqaType.removeFromIndexes();
		  }

		  AnswerType oaqaType = new AnswerType(questionView);
		  oaqaType.setLabel(type);
		  oaqaType.addToIndexes();
	 }
}
