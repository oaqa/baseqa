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

package edu.cmu.lti.oaqa.framework.eval.retrieval;

import org.oaqa.model.Passage;

import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

public final class TRECPassageOrdering extends Ordering<Passage> {
  public int compare(Passage left, Passage right) {
    int rankDiff = Ints.compare(left.getRank(),right.getRank());
    if (rankDiff != 0) {
      return rankDiff;
    }
    int pmidDiff = left.getUri().compareTo(right.getUri());
    if (pmidDiff != 0) {
      return pmidDiff;
    }
    int offsetDiff = Ints.compare(left.getBegin(), right.getBegin());
    if (offsetDiff != 0) {
      return offsetDiff;
    }
    return Ints.compare(left.getEnd() - left.getBegin(), 
            right.getEnd() - right.getBegin());
  }
}