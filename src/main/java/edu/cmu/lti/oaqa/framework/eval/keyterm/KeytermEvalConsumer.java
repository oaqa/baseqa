package edu.cmu.lti.oaqa.framework.eval.keyterm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.uima.cas.CASException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.AbstractQuery;
import org.oaqa.model.OAQATop;
import org.oaqa.model.QueryConcept;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;

import edu.cmu.lti.oaqa.framework.BaseJCasHelper;
import edu.cmu.lti.oaqa.framework.ViewManager;
import edu.cmu.lti.oaqa.framework.ViewManager.ViewType;
import edu.cmu.lti.oaqa.framework.eval.retrieval.RetrievalEvalConsumer;

public class KeytermEvalConsumer extends RetrievalEvalConsumer<QueryConcept> {

  @Override
  protected Ordering<QueryConcept> getOrdering() {
    return new Ordering<QueryConcept>() {

      @Override
      public int compare(QueryConcept left, QueryConcept right) {
        return left.getText().compareTo(right.getText());
      }

    }.reverse();
  }

  @Override
  protected Function<QueryConcept, String> getToIdStringFct() {
    return new Function<QueryConcept, String>() {

      @Override
      public String apply(QueryConcept input) {
        return input.getText();
      }
    };
  }

  @Override
  protected List<QueryConcept> getGoldStandard(JCas jcas) throws CASException {
    Iterator<?> it = ViewManager.getOrCreateView(jcas, ViewType.CANDIDATE_GS)
            .getJFSIndexRepository().getAllIndexedFS(QueryConcept.type);
    List<QueryConcept> annotations = new ArrayList<QueryConcept>();
    while (it.hasNext()) {
      annotations.add((QueryConcept) it.next());
    }
    return annotations;
  }

  @Override
  protected List<QueryConcept> getResults(JCas jcas) throws CASException {
    Iterator<?> it = jcas.getJFSIndexRepository().getAllIndexedFS(AbstractQuery.type);
    List<QueryConcept> annotations = new ArrayList<QueryConcept>();
    while (it.hasNext()) {
      AbstractQuery query = (AbstractQuery) it.next();
      for (OAQATop top : BaseJCasHelper.<OAQATop> fsIterator(query.getConcepts())) {
        annotations.add((QueryConcept) top);
      }
    }
    return annotations;
  }

}
