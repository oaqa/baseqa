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

package edu.cmu.lti.oaqa.cse.basephase.retrieval;

import java.util.ArrayList;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.UimaContext;
import org.apache.uima.resource.ResourceInitializationException;

import edu.cmu.lti.oaqa.ecd.log.AbstractLoggedComponent;
import edu.cmu.lti.oaqa.framework.BaseJCasHelper;
import edu.cmu.lti.oaqa.framework.QALogEntry;
import edu.cmu.lti.oaqa.framework.ViewManager;
import edu.cmu.lti.oaqa.framework.data.base.JCasHelper;
import edu.cmu.lti.oaqa.framework.data.RetrievalResult;
import edu.cmu.lti.oaqa.framework.data.RetrievalResultArray;
import edu.cmu.lti.oaqa.framework.types.InputElement;
import edu.cmu.lti.oaqa.cse.basephase.retrieval.SourceIdHelper;

/**
 * 
 * @author Zi Yang <ziy@cs.cmu.edu> 
 * 
 */
public abstract class AbstractRetrievalStrategist extends AbstractLoggedComponent {

  protected abstract List<RetrievalResult> retrieveDocuments(String qid, String question,
                      List<String> keyTerms, List<String> keyPhrases) throws Exception;


  @Override
  public void initialize(UimaContext c) throws ResourceInitializationException {
    super.initialize(c);
    SourceId = SourceIdHelper.GetSourceId(c); 
  }

  @Override
  public final void process(JCas jcas) throws AnalysisEngineProcessException {
    super.process(jcas);
    try {
      // prepare input
      InputElement input = ((InputElement) BaseJCasHelper.getAnnotation(jcas, InputElement.type));
      String        qid      = input.getSequenceId().toString();
      
      List<String>  keyTerms   = new ArrayList<String>();
      List<String>  keyPhrases = new ArrayList<String>();
      
      JCasHelper.loadKeyTermsAndPhrases(jcas, keyTerms, keyPhrases);
      
      // do task
      List<RetrievalResult> documents = retrieveDocuments(qid, input.getQuestion(), keyTerms, keyPhrases);
      
      log("RETRIEVED: " + documents.size());
      
      // save output
      RetrievalResultArray.storeRetrievalResults(SourceId, ViewManager.getDocumentView(jcas), documents);
    } catch (Exception e) {
      throw new AnalysisEngineProcessException(e);
    }
  }

  protected final void log(String message) {
    super.log(QALogEntry.RETRIEVAL, message);
  }

  protected String SourceId;

}
