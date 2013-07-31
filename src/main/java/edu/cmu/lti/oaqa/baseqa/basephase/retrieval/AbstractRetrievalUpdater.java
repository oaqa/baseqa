/*
 *  Copyright 2012 Carnegie Mellon University
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

package edu.cmu.lti.oaqa.baseqa.basephase.retrieval;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.baseqa.data.nlp.Keyterm;
import edu.cmu.lti.oaqa.baseqa.data.nlp.KeytermList;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.RetrievalResult;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.RetrievalResultArray;
import edu.cmu.lti.oaqa.baseqa.framework.QALogEntry;
import edu.cmu.lti.oaqa.core.data.WrapperIndexer;
import edu.cmu.lti.oaqa.ecd.log.AbstractLoggedComponent;
import edu.cmu.lti.oaqa.framework.BaseJCasHelper;
import edu.cmu.lti.oaqa.framework.ViewManager;
import edu.cmu.lti.oaqa.framework.types.InputElement;

/**
 * 
 * @author Zi Yang <ziy@cs.cmu.edu>
 * 
 */
@Deprecated
public abstract class AbstractRetrievalUpdater extends AbstractLoggedComponent {

  protected abstract List<RetrievalResult> updateDocuments(String question, List<Keyterm> keyterms,
          List<RetrievalResult> documents);

  @Override
  public final void process(JCas jcas) throws AnalysisEngineProcessException {
    super.process(jcas);
    try {
      // prepare input
      WrapperIndexer indexer = new WrapperIndexer();
      InputElement input = ((InputElement) BaseJCasHelper.getAnnotation(jcas, InputElement.type));
      List<Keyterm> keyterms = KeytermList.retrieveKeyterms(indexer, jcas);
      List<RetrievalResult> documents = RetrievalResultArray.retrieveRetrievalResults(indexer,
              ViewManager.getDocumentView(jcas));
      // do task
      documents = updateDocuments(input.getQuestion(), keyterms, documents);
      log("RETRIEVED: " + documents.size());
      // save output
      RetrievalResultArray.storeRetrievalResults(indexer, ViewManager.getDocumentView(jcas),
              documents);
    } catch (Exception e) {
      throw new AnalysisEngineProcessException(e);
    }
  }

  protected final void log(String message) {
    super.log(QALogEntry.RETRIEVAL, message);
  }

}
