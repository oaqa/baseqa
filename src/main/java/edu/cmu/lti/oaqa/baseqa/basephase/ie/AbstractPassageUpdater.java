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

package edu.cmu.lti.oaqa.baseqa.basephase.ie;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.baseqa.data.nlp.Keyterm;
import edu.cmu.lti.oaqa.baseqa.data.nlp.KeytermList;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.PassageCandidate;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.PassageCandidateArray;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.RetrievalResult;
import edu.cmu.lti.oaqa.baseqa.data.retrieval.RetrievalResultArray;
import edu.cmu.lti.oaqa.baseqa.framework.QALogEntry;
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
public abstract class AbstractPassageUpdater extends AbstractLoggedComponent {

  protected abstract List<PassageCandidate> updatePassages(String question, List<Keyterm> keyterms,
          List<RetrievalResult> documents, List<PassageCandidate> passages);

  @Override
  public final void process(JCas jcas) throws AnalysisEngineProcessException {
    super.process(jcas);
    try {
      // prepare input
      String questionText = ((InputElement) BaseJCasHelper.getAnnotation(jcas, InputElement.type))
              .getQuestion();
      KeytermList keytermList = new KeytermList(jcas);
      List<Keyterm> keyterms = keytermList.getKeyterms();
      List<RetrievalResult> documents = RetrievalResultArray.retrieveRetrievalResults(ViewManager
              .getDocumentView(jcas));
      List<PassageCandidate> passages = PassageCandidateArray.retrievePassageCandidates(ViewManager
              .getCandidateView(jcas));
      // do task
      passages = updatePassages(questionText, keyterms, documents, passages);
      log("ANSWER PASSAGES: " + passages.size());
      // save output
      PassageCandidateArray.storePassageCandidates(ViewManager.getCandidateView(jcas), passages);
    } catch (Exception e) {
      throw new AnalysisEngineProcessException(e);
    }
  }

  protected final void log(String message) {
    super.log(QALogEntry.INFORMATION_EXTRACTION, message);
  }

}
