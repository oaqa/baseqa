package edu.cmu.lti.oaqa.framework.eval.retrieval;

import java.util.Collections;
import java.util.List;

import org.apache.uima.cas.CASException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.Passage;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;

import edu.cmu.lti.oaqa.ecd.eval.retrieval.RetrievalEvalConsumer;
import edu.cmu.lti.oaqa.framework.ViewManager;
import edu.cmu.lti.oaqa.framework.ViewManager.ViewType;

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
    return (view != null) ? PassageHelper.loadDocumentSet(view) : Collections.<Passage>emptyList();
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
