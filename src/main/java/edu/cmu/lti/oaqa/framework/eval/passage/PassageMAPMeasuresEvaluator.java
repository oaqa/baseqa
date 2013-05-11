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

import java.util.Map;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceSpecifier;
import org.apache.uima.resource.Resource_ImplBase;

import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

import edu.cmu.lti.oaqa.ecd.BaseExperimentBuilder;
import edu.cmu.lti.oaqa.framework.eval.ExperimentKey;
import edu.cmu.lti.oaqa.framework.eval.ExperimentListener;
import edu.cmu.lti.oaqa.framework.eval.Key;

public class PassageMAPMeasuresEvaluator extends Resource_ImplBase implements ExperimentListener {

  private PassageMAPEvalPersistenceProvider persistence;

  @Override
  public boolean initialize(ResourceSpecifier aSpecifier, Map<String, Object> tuples)
          throws ResourceInitializationException {
    String pp = (String) tuples.get("persistence-provider");
    if (pp == null) {
      throw new ResourceInitializationException(new IllegalArgumentException(
              "Must provide a parameter of type <persistence-provider>"));
    }
    this.persistence = BaseExperimentBuilder.loadProvider(pp,
            PassageMAPEvalPersistenceProvider.class);
    return true;
  }

  private final Map<Key, PassageMAPCounts> countMap = Maps.newHashMap();

  @Override
  public void process(ExperimentKey experiment) throws AnalysisEngineProcessException {
    persistence.deletePassageMeasureEval(experiment);
    Multimap<Key, PassageMAPCounts> counts = persistence.retrievePartialCounts(experiment);
    for (Map.Entry<Key, PassageMAPCounts> me : counts.entries()) {
      update(me.getKey(), me.getValue());
    }
    doEvaluate();
  }

  public void doEvaluate() throws AnalysisEngineProcessException {
    for (Map.Entry<Key, PassageMAPCounts> me : countMap.entrySet()) {
      Key key = me.getKey();
      String eName = getClass().getSimpleName();
      PassageMAPEvaluationData eval = evaluate(me.getValue());
      try {
        persistence.insertMAPMeasureEval(key, eName, eval);
      } catch (Exception e) {
        e.printStackTrace();
        throw new AnalysisEngineProcessException(e);
      }
    }
  }

  private PassageMAPEvaluationData evaluate(PassageMAPCounts counts) {
    float docMAP = counts.getDocavep() / counts.getCount();
    float psgMAP = counts.getPsgavep() / counts.getCount();
    float psg2MAP = counts.getPsg2avep() / counts.getCount();
    float aspMAP = counts.getAspavep() / counts.getCount();
    return new PassageMAPEvaluationData(docMAP, psgMAP, psg2MAP, aspMAP, counts.getCount());
  }

  private void update(Key key, PassageMAPCounts cnt) {
    PassageMAPCounts globals = countMap.get(key);
    if (globals == null) {
      globals = new PassageMAPCounts();
      countMap.put(key, globals);
    }
    globals.update(cnt);
  }

}
