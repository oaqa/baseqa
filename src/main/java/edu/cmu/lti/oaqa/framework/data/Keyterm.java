package edu.cmu.lti.oaqa.framework.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSList;
import org.oaqa.model.AbstractQuery;
import org.oaqa.model.QueryConcept;

import edu.cmu.lti.oaqa.framework.BaseJCasHelper;

/**
 * TOKEN type refers to the original token terms, and phrases refer to the name entities identified
 * by NameEntity.
 * 
 * @author Zi Yang <ziy@cs.cmu.edu>
 * 
 */
public class Keyterm implements Serializable {

  private static final long serialVersionUID = 1L;

  private String text = null;

  /**
   * Default constructor where sequenceId will be set -1, and type will be set <code>UNKNOWN</code>.
   * 
   * @param concept
   *          token or phrase
   */
  public Keyterm(QueryConcept concept) {
    this.text = concept.getText();
  }

  public Keyterm(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }

  @Override
  public String toString() {
    return text;
  }

  public static List<Keyterm> getKeyterms(JCas jcas) {

    List<Keyterm> result = new ArrayList<Keyterm>();
    AbstractQuery query = (AbstractQuery) BaseJCasHelper.getFS(jcas, AbstractQuery.type);

    if (query != null) {
      FSList constituent = query.getConcepts();
      for (QueryConcept concept : BaseJCasHelper.<QueryConcept> fsIterator(constituent)) {
        result.add(new Keyterm(concept));
      }
    }
    return result;
  }

  public static void storeKeyterms(JCas jcas, List<Keyterm> keyterms) {

    Iterator<?> it = jcas.getJFSIndexRepository().getAllIndexedFS(AbstractQuery.type);
    while (it.hasNext()) {
      AbstractQuery query = (AbstractQuery) it.next();
      query.removeFromIndexes();
    }

    FSList concepts = new FSList(jcas);
    for (Keyterm keyterm : keyterms) {
      QueryConcept constituent = new QueryConcept(jcas);
      constituent.setText(keyterm.getText());
      concepts = BaseJCasHelper.addToFSList(jcas, concepts, constituent);
    }

    AbstractQuery query = new AbstractQuery(jcas);
    query.setConcepts(concepts);
    query.addToIndexes();
  }

}
