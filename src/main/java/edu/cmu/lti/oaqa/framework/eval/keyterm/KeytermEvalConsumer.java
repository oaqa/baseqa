package edu.cmu.lti.oaqa.framework.eval.keyterm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Nullable;

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
import edu.cmu.lti.oaqa.framework.data.QueryConceptList;
import edu.cmu.lti.oaqa.framework.data.QueryConceptTypes;
import edu.cmu.lti.oaqa.framework.data.QueryConceptWrapper;
import edu.cmu.lti.oaqa.framework.eval.retrieval.RetrievalEvalConsumer;

public class KeytermEvalConsumer extends RetrievalEvalConsumer<QueryConcept> {

  @Override
  protected Ordering<QueryConcept> getOrdering() {
    return new Ordering<QueryConcept>() {

      @Override
      public int compare(@Nullable
      QueryConcept left, @Nullable
      QueryConcept right) {
        return left.getText().compareTo(right.getText());
      }

    }.reverse();
  }

  @Override
  protected Function<QueryConcept, String> getToIdStringFct() {
    return new Function<QueryConcept, String>() {

      @Override
      @Nullable
      public String apply(@Nullable
      QueryConcept input) {
        return input.getText();
      }
    };
  }

  @Override
  protected List<QueryConcept> getGoldStandard(JCas jcas) throws CASException {
    JCas   gsView = ViewManager.getOrCreateView(jcas, ViewType.CANDIDATE_GS);
    List<QueryConceptWrapper>   concepts;
    
    List<QueryConcept> annotations = new ArrayList<QueryConcept>();
    
    try {
      concepts = QueryConceptList.retrieveQueryConcepts(gsView);
      
      for(QueryConceptWrapper w: concepts) {
        QueryConcept concept = w.unwrap(gsView);
        
        if (w.getType().equals(QueryConceptTypes.KeyTerms) ) {
          annotations.add(concept);
        }
      }
    
    } catch (Exception e) {
      throw new CASException(e);
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
