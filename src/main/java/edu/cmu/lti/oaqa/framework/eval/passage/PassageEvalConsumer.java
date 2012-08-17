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

package edu.cmu.lti.oaqa.framework.eval.passage;

import java.util.Collections;
import java.util.List;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.oaqa.model.Passage;
import org.uimafit.component.CasConsumer_ImplBase;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;

import edu.cmu.lti.oaqa.ecd.BaseExperimentBuilder;
import edu.cmu.lti.oaqa.ecd.phase.ProcessingStepUtils;
import edu.cmu.lti.oaqa.ecd.phase.Trace;
import edu.cmu.lti.oaqa.framework.ViewManager;
import edu.cmu.lti.oaqa.framework.ViewManager.ViewType;
import edu.cmu.lti.oaqa.framework.eval.Key;
import edu.cmu.lti.oaqa.framework.eval.retrieval.EvaluationAggregator;
import edu.cmu.lti.oaqa.framework.types.ExperimentUUID;
import edu.cmu.lti.oaqa.framework.types.ProcessingStep;

public class PassageEvalConsumer extends CasConsumer_ImplBase {

  private final Ordering<Passage> ordering = new TRECPassageOrdering();

  private final Function<Passage, String> toIdString = new PassageToIdString();

  @SuppressWarnings("rawtypes")
  private List<EvaluationAggregator> aggregators;

  private int limit;

  @Override
  public void initialize(UimaContext context) throws ResourceInitializationException {
    try {
      limit = (Integer) context.getConfigParameterValue("limit");
    } catch (NullPointerException e) {
      limit = Integer.MAX_VALUE;
    }
    Object aggregatorNames = (Object) context.getConfigParameterValue("aggregators");
    if (aggregatorNames != null) {
      this.aggregators = BaseExperimentBuilder.createResourceList(aggregatorNames,
              EvaluationAggregator.class);
    }
  }

  /**
   * Reads the results from the retrieval phase from the DOCUMENT and the DOCUEMNT_GS views of the
   * JCAs, and generates and evaluates them using the evaluate method from the FMeasureConsumer
   * class.
   */
  @Override
  public void process(CAS aCAS) throws AnalysisEngineProcessException {
    try {
      JCas jcas = aCAS.getJCas();
      ExperimentUUID experiment = ProcessingStepUtils.getCurrentExperiment(jcas);
      AnnotationIndex<Annotation> steps = jcas.getAnnotationIndex(ProcessingStep.type);
      Trace trace = ProcessingStepUtils.getTrace(steps);
      JCas view = ViewManager.getView(jcas, ViewType.CANDIDATE);
      JCas gsView = ViewManager.getView(jcas, ViewType.DOCUMENT_GS);
      if (gsView != null) {
        List<Passage> gs = PassageHelper.loadDocumentSet(gsView);
        List<Passage> docs = (view != null) ? PassageHelper.loadDocumentSet(view) : Collections
                .<Passage> emptyList();
        docs = docs.subList(0, Math.min(docs.size(), limit));
        int sequenceId = ProcessingStepUtils.getSequenceId(jcas);
        for (EvaluationAggregator<Passage> aggregator : aggregators) {
          Key key = new Key(experiment.getUuid(), trace, experiment.getStageId());
          aggregator.update(key, sequenceId, docs, gs, ordering, toIdString);
        }
      }
    } catch (Exception e) {
      throw new AnalysisEngineProcessException(e);
    }
  }
}
