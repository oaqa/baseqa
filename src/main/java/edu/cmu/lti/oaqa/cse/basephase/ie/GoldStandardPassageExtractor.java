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

package edu.cmu.lti.oaqa.cse.basephase.ie;

import java.util.ArrayList;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.Passage;

import edu.cmu.lti.oaqa.ecd.log.AbstractLoggedComponent;
import edu.cmu.lti.oaqa.framework.ViewManager;
import edu.cmu.lti.oaqa.framework.ViewManager.ViewType;
import edu.cmu.lti.oaqa.framework.data.PassageCandidate;
import edu.cmu.lti.oaqa.framework.data.PassageCandidateArray;
import edu.cmu.lti.oaqa.framework.eval.passage.PassageHelper;

public class GoldStandardPassageExtractor extends AbstractLoggedComponent {

  @Override
  public final void process(JCas jcas) throws AnalysisEngineProcessException {
    super.process(jcas);
    try {
      JCas gsView = ViewManager.getView(jcas, ViewType.DOCUMENT_GS);
      List<Passage> gs = PassageHelper.loadDocumentSet(gsView);
      List<PassageCandidate> passages = new ArrayList<PassageCandidate>();
      for (Passage passage : gs) {
        PassageCandidate candidate = new PassageCandidate();
        candidate.wrap(passage);
        passages.add(candidate);
      }
      JCas candidateView = ViewManager.getCandidateView(jcas);
      PassageCandidateArray.storePassageCandidates(candidateView, passages);
    } catch (Exception e) {
      throw new AnalysisEngineProcessException(e);
    }
  }

}
