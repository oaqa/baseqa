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

final class PassageMAPEvaluationData {

  final float docMap;

  final float psgMap;

  final float aspMap;

  final float count;

  PassageMAPEvaluationData(float docMAP, float psgMAP, float aspMAP, int count) {
    this.docMap = docMAP;
    this.psgMap = psgMAP;
    this.aspMap = aspMAP;
    this.count = count;
  }
}