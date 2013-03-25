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

package edu.cmu.lti.oaqa.framework.eval.answer;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
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
import edu.cmu.lti.oaqa.framework.data.AnswerArray;
import edu.cmu.lti.oaqa.framework.data.AnswerWrapper;
import edu.cmu.lti.oaqa.framework.data.QueryConceptWrapper;
import edu.cmu.lti.oaqa.framework.data.QueryConceptList;


public class AnswersEvalConsumer extends CasConsumer_ImplBase {
  private final class AnswerToIdString implements Function<String, String> {
    @Override
    public String apply(String answ) {
      // Answers are very small, so the text of an answer
      // is a unique identifier
      return answ;
    }
  }

  private final class AnswerOrdering extends Ordering<String> {
    @Override
    public int compare(String left, String right) {
      return left.compareTo(right);
    }
  }

  private final Ordering<String> ordering = new AnswerOrdering();

  private final Function<String, String> toIdString = new AnswerToIdString();

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

  @Override
  public void process(CAS aCAS) throws AnalysisEngineProcessException {
    try {
      JCas jcas = aCAS.getJCas();
      ExperimentUUID experiment = ProcessingStepUtils.getCurrentExperiment(jcas);
      AnnotationIndex<Annotation> steps = jcas.getAnnotationIndex(ProcessingStep.type);
      Trace trace = ProcessingStepUtils.getTrace(steps);
      JCas view   = ViewManager.getView(jcas, ViewType.FINAL_ANSWER);
      JCas gsView = ViewManager.getView(jcas, ViewType.FINAL_ANSWER_GS);
      if (gsView != null) {
        List<QueryConceptWrapper> _gs   = QueryConceptList.retrieveQueryConcepts(gsView);
        List<AnswerWrapper>       _answ = (view != null) ? 
                                          AnswerArray.retrieveAnswers(AnswerArray.MergedSourceId, view) : 
                                          Collections.<AnswerWrapper> emptyList();
        List<String>              gs = new ArrayList<String>();
        List<String>              answ = new ArrayList<String>();

        for(QueryConceptWrapper w: _gs) {
          gs.add(w.getText());
        }
        for(AnswerWrapper w: _answ) {
          answ.add(w.getText());
        }

        answ = answ.subList(0, Math.min(answ.size(), limit));
        String sequenceId = ProcessingStepUtils.getSequenceId(jcas);
        for (EvaluationAggregator<String> aggregator : aggregators) {
          Key key = new Key(experiment.getUuid(), trace, experiment.getStageId());
          aggregator.update(key, sequenceId, answ, gs, ordering, toIdString);
        }
      }
    } catch (Exception e) {
      throw new AnalysisEngineProcessException(e);
    }
  }
}
