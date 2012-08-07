package edu.cmu.lti.oaqa.framework.eval.retrieval;

import java.util.Iterator;
import java.util.List;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;
import org.oaqa.model.Passage;
import org.oaqa.model.Search;

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
