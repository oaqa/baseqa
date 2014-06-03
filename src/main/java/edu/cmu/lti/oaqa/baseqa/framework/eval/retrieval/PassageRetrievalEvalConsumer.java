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

package edu.cmu.lti.oaqa.baseqa.framework.eval.retrieval;

import java.util.Collections;
import java.util.List;

import org.apache.uima.cas.CASException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.answer.AnswerList;
import org.oaqa.model.gerp.Evidence;
import org.oaqa.model.retrieval.Passage;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;

import edu.cmu.lti.oaqa.baseqa.framework.eval.document.DocumentEvalConsumer;
import edu.cmu.lti.oaqa.baseqa.framework.eval.passage.PassageHelper;
import edu.cmu.lti.oaqa.baseqa.framework.eval.passage.PassageToIdString;
import edu.cmu.lti.oaqa.baseqa.framework.eval.passage.TRECPassageOrdering;
import edu.cmu.lti.oaqa.framework.ViewManager;
import edu.cmu.lti.oaqa.framework.ViewManager.ViewType;
import edu.cmu.lti.oaqa.framework.eval.retrieval.RetrievalEvalConsumer;
import edu.cmu.lti.oaqa.gerp.data.DocumentEvidenceWrapper;

/**
 * 
 * @author yangzi
 * @deprecated use {@link DocumentEvalConsumer} instead for documents stored as
 *             {@link DocumentEvidenceWrapper} inside {@link Evidence} of an {@link AnswerList}.
 *
 */
@Deprecated
public class PassageRetrievalEvalConsumer extends RetrievalEvalConsumer<Passage> {

  @Override
  protected List<Passage> getGoldStandard(JCas jcas) throws CASException {
    return getDocuments(jcas, ViewType.DOCUMENT_GS);
  }

  @Override
  protected List<Passage> getResults(JCas jcas) throws CASException {
    return getDocuments(jcas, ViewType.DOCUMENT);
  }

  private List<Passage> getDocuments(JCas jcas, ViewType viewType) throws CASException {
    JCas view = ViewManager.getView(jcas, viewType);
    return (view != null) ? PassageHelper.loadDocumentSet(view) : Collections.<Passage> emptyList();
  }

  @Override
  protected Ordering<Passage> getOrdering() {
    return new TRECPassageOrdering();
  }

  @Override
  protected Function<Passage, String> getToIdStringFct() {
    return new PassageToIdString();
  }

}
