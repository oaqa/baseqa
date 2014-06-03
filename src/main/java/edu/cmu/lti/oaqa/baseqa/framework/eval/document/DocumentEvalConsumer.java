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

package edu.cmu.lti.oaqa.baseqa.framework.eval.document;

import java.util.Collection;
import java.util.List;

import org.apache.uima.cas.CASException;
import org.apache.uima.fit.util.FSCollectionFactory;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.TOP;
import org.oaqa.model.answer.AnswerList;
import org.oaqa.model.gerp.Evidence;
import org.oaqa.model.retrieval.Document;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

import edu.cmu.lti.oaqa.framework.ViewManager;
import edu.cmu.lti.oaqa.framework.ViewManager.ViewType;
import edu.cmu.lti.oaqa.framework.eval.retrieval.RetrievalEvalConsumer;

public class DocumentEvalConsumer extends RetrievalEvalConsumer<Document> {

  @Override
  protected List<Document> getGoldStandard(JCas jcas) throws CASException {
    return getDocuments(jcas, ViewType.FINAL_ANSWER_GS);
  }

  @Override
  protected List<Document> getResults(JCas jcas) throws CASException {
    return getDocuments(jcas, ViewType.FINAL_ANSWER);
  }

  private List<Document> getDocuments(JCas jcas, ViewType viewType) throws CASException {
    JCas view = ViewManager.getView(jcas, viewType);
    List<Document> ret = Lists.newArrayList();
    AnswerList answerList;
    try {
      answerList = JCasUtil.selectSingle(view, AnswerList.class);
    } catch (Exception e) {
      return ret;
    }
    for (Evidence evidence : FSCollectionFactory.create(answerList.getEvidences(), Evidence.class)) {
      Collection<TOP> addEvidences = FSCollectionFactory.create(evidence.getAdditionalEvidences(),
              TOP.class);
      if (addEvidences.isEmpty()) {
        continue;
      }
      for (TOP top : addEvidences) {
        ret.add((Document) top);
      }
    }
    return ret;
  }

  @Override
  protected Ordering<Document> getOrdering() {
    return new Ordering<Document>(){

      @Override
      public int compare(Document left, Document right) {
        return Ints.compare(left.getRank(), right.getRank());
      }};
  }

  @Override
  protected Function<Document, String> getToIdStringFct() {
    return new Function<Document, String>(){

      @Override
      public String apply(Document input) {
        return input.getDocId();
      }};
  }

}
