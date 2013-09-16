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

package edu.cmu.lti.oaqa.baseqa.framework.eval.passage;

import java.util.Iterator;
import java.util.List;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;
import org.oaqa.model.retrieval.Passage;
import org.oaqa.model.retrieval.Search;

import com.google.common.collect.Lists;

public class PassageHelper {

  public static List<Passage> loadDocumentSet(JCas jcas) {
    List<Passage> result = Lists.newArrayList();
    Iterator<?> it = jcas.getJFSIndexRepository().getAllIndexedFS(Search.type);
    if (it.hasNext()) {
      Search retrievalResult = (Search) it.next();
      FSArray hitList = retrievalResult.getHitList();
      for (int i = 0; i < hitList.size(); i++) {
        Passage sr = (Passage) hitList.get(i);
        result.add(sr);
      }
    }
    return result;
  }

}
