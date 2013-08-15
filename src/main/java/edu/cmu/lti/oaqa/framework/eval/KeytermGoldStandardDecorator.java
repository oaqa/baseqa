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

package edu.cmu.lti.oaqa.framework.eval;

import java.util.List;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.oaqa.model.QueryConcept;

import edu.cmu.lti.oaqa.ecd.BaseExperimentBuilder;
import edu.cmu.lti.oaqa.framework.CasUtils;
import edu.cmu.lti.oaqa.framework.ViewManager;
import edu.cmu.lti.oaqa.framework.ViewManager.ViewType;
import edu.cmu.lti.oaqa.framework.eval.gs.GoldStandardPersistenceProvider;
import edu.cmu.lti.oaqa.framework.types.InputElement;

public class KeytermGoldStandardDecorator extends JCasAnnotator_ImplBase {

  private GoldStandardPersistenceProvider persistence;

  @Override
  public void initialize(UimaContext c) throws ResourceInitializationException {
    String pp = (String) c.getConfigParameterValue("persistence-provider");
    if (pp == null) {
      throw new ResourceInitializationException(new IllegalArgumentException(
              "Must provide a parameter of type <persistence-provider>"));
    }
    this.persistence = BaseExperimentBuilder
            .loadProvider(pp, GoldStandardPersistenceProvider.class);
  }

  /**
   * Retrieves the gold standard data from the database for the retrieval task. And stores FSArray
   * of Search on the DOCUMENT_GS view of the JCas.
   */
  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    try {
      final InputElement input = (InputElement) CasUtils.getFirst(aJCas,
              InputElement.class.getName());
      final JCas gsView = ViewManager.getOrCreateView(aJCas, ViewType.CANDIDATE_GS);
      final String dataset = input.getDataset();
      final String sequenceId = input.getSequenceId();
      @SuppressWarnings("unchecked")
      List<QueryConcept> gsAnnotations = (List<QueryConcept>) persistence.populateRetrievalGS(dataset, sequenceId, gsView);
      if (!gsAnnotations.isEmpty()) {
        for (int i = 0; i < gsAnnotations.size(); i++) {
          gsAnnotations.get(i).addToIndexes(gsView);
        }
      }
    } catch (Exception e) {
      throw new AnalysisEngineProcessException(e);
    }
  }

}
