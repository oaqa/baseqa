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

package edu.cmu.lti.oaqa.baseqa.framework.persistence;

import java.sql.SQLException;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

import edu.cmu.lti.oaqa.baseqa.framework.eval.passage.PassageMAPCounts;
import edu.cmu.lti.oaqa.baseqa.framework.eval.passage.PassageMAPEvaluationData;
import edu.cmu.lti.oaqa.framework.eval.ExperimentKey;
import edu.cmu.lti.oaqa.framework.eval.Key;

public class DefaultPassageMAPEvalPersistenceProvider extends AbstractPassageMAPEvalPersistenceProvider {

  @Override
  public void deletePassageAggrEval(final Key key, final String sequenceId) {
  }

  @Override
  public void insertPartialCounts(final Key key, final String sequenceId, final PassageMAPCounts counts)
          throws SQLException {
  }

  @Override
  public Multimap<Key, PassageMAPCounts> retrievePartialCounts(final ExperimentKey experiment) {
    return LinkedHashMultimap.create();
  }
 
  @Override
  public void deletePassageMeasureEval(final ExperimentKey experiment) {
  }

  @Override
  public void insertMAPMeasureEval(final Key key, final String eName, final PassageMAPEvaluationData eval)
          throws SQLException {
  }
}
