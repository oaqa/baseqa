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

import java.sql.SQLException;

import org.apache.uima.resource.Resource;

import com.google.common.collect.Multimap;

import edu.cmu.lti.oaqa.ecd.eval.ExperimentKey;
import edu.cmu.lti.oaqa.ecd.eval.Key;

public interface PassageMAPEvalPersistenceProvider extends Resource {

  void deletePassageAggrEval(Key key, int sequenceId) throws SQLException;

  void insertPartialCounts(Key key, int sequenceId, PassageMAPCounts cnt) throws SQLException;

  Multimap<Key, PassageMAPCounts> retrievePartialCounts(ExperimentKey experiment);

  void deletePassageMeasureEval(ExperimentKey experiment);

  void insertMAPMeasureEval(Key key, String eName, PassageMAPEvaluationData eval) throws SQLException;

}
