package edu.cmu.lti.oaqa.framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.uima.cas.CASException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.cas.StringArray;
import org.oaqa.model.AbstractQuery;
import org.oaqa.model.Constituent;
import org.oaqa.model.ExternalResource;
import org.oaqa.model.Passage;
import org.oaqa.model.Search;
import org.oaqa.model.TagInfo;

import edu.cmu.lti.oaqa.framework.data.Keyterm;
import edu.cmu.lti.oaqa.framework.data.PassageCandidate;
import edu.cmu.lti.oaqa.framework.data.RetrievalResult;

/**
 * 
 * @author Zi Yang <ziy@cs.cmu.edu>
 * 
 */

public class JCasHelper extends BaseJCasHelper {

  public static List<Keyterm> getKeyterms(JCas jcas) {

    List<Keyterm> result = new ArrayList<Keyterm>();
    AbstractQuery query = (AbstractQuery) JCasHelper.getFS(jcas, AbstractQuery.type);

    if (query != null) {
      FSList constituent = query.getConcepts();
      for (Constituent concept : JCasHelper.<Constituent> fsIterator(constituent)) {
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

    FSList constituents = new FSList(jcas);
    for (Keyterm keyterm : keyterms) {
      Constituent constituent = new Constituent(jcas);
      constituent.setSequence(keyterm.getSequenceId());
      constituent.setText(keyterm.getText());
      constituent.setCType(keyterm.getType());
      FSList tags = new FSList(jcas);
      for (String source : keyterm.getAllTagSources()) {
        TagInfo tag = new TagInfo(jcas);
        tag.setSource(source);
        tag.setTag(keyterm.getTagBySource(source));
        tags = addToFSList(jcas, tags, tag);
      }
      constituent.setTags(tags);
      FSList resources = new FSList(jcas);
      for (String source : keyterm.getAllResourceSources()) {
        ExternalResource resource = new ExternalResource(jcas);
        resource.setSource(source);
        resource.setConcept(keyterm.getConceptBySource(source));
        resource.setCategory(keyterm.getCategoryBySource(source));
        List<String> synonyms = keyterm.getSynonymsBySource(source);
        StringArray array = new StringArray(jcas, synonyms.size());
        array.copyFromArray(synonyms.toArray(new String[0]), 0, 0, synonyms.size());
        resource.setSynonyms(array);
        resources = addToFSList(jcas, resources, resource);
      }
      constituent.setResources(resources);
      constituents = addToFSList(jcas, constituents, constituent);
    }

    AbstractQuery query = new AbstractQuery(jcas);
    query.setConcepts(constituents);
    query.addToIndexes();
  }

  public static List<RetrievalResult> getDocuments(JCas documentView) throws CASException {

    List<RetrievalResult> documents = new ArrayList<RetrievalResult>();
    Iterator<?> it = documentView.getJFSIndexRepository().getAllIndexedFS(Search.type);

    if (it.hasNext()) {
      Search retrievalResult = (Search) it.next();
      FSArray hitList = retrievalResult.getHitList();
      for (int i = 0; i < hitList.size(); i++) {
        Passage sr = (Passage) hitList.get(i);
        RetrievalResult document = new RetrievalResult(sr);
        documents.add(document);
      }
    }
    return documents;
  }

  /**
   * @deprecated Use {@link #getDocuments(JCas)} directly.
   */
  @Deprecated
  public static List<RetrievalResult> getDocumentsNoText(JCas documentView) throws CASException {
    return getDocuments(documentView);
  }

  public static void storeDocuments(JCas documentView, List<RetrievalResult> documents) {

    Collections.sort(documents, Collections.reverseOrder());
    Iterator<?> it = documentView.getJFSIndexRepository().getAllIndexedFS(Search.type);
    while (it.hasNext()) {
      Search search = (Search) it.next();
      search.removeFromIndexes();
    }

    FSArray hitList = new FSArray(documentView, documents.size());
    double prevScore = Double.NaN;
    int prevRank = 0;
    for (int i = 0; i < documents.size(); i++) {
      RetrievalResult document = documents.get(i);
      Passage sr = new Passage(documentView);
      sr.setUri(document.getDocID());
      sr.setQueryString(document.getQueryString());
      double curScore = document.getScore();
      sr.setScore(curScore);
      if (curScore != prevScore) {
        sr.setRank(i + 1);
        prevScore = curScore;
        prevRank = i + 1;
      } else {
        sr.setRank(prevRank);
      }
      hitList.set(i, sr);
    }

    Search search = new Search(documentView);
    search.setHitList(hitList);
    search.addToIndexes();
  }

  public static List<PassageCandidate> getPassages(JCas candidateView) {

    List<PassageCandidate> passages = new ArrayList<PassageCandidate>();
    Iterator<?> it = candidateView.getJFSIndexRepository().getAllIndexedFS(Search.type);

    if (it.hasNext()) {
      Search retrievalResult = (Search) it.next();
      FSArray hitList = retrievalResult.getHitList();
      for (int i = 0; i < hitList.size(); i++) {
        Passage p = (Passage) hitList.get(i);
        passages.add(new PassageCandidate(p));
      }
    }
    return passages;
  }

  public static void storePassages(JCas candidateView, List<PassageCandidate> passages) {

    Collections.sort(passages, Collections.reverseOrder());
    Iterator<?> it = candidateView.getJFSIndexRepository().getAllIndexedFS(Search.type);
    while (it.hasNext()) {
      Search search = (Search) it.next();
      search.removeFromIndexes();
    }

    FSArray hitList = new FSArray(candidateView, passages.size());
    double prevScore = Double.NaN;
    int prevRank = 0;
    for (int i = 0; i < passages.size(); i++) {
      PassageCandidate passage = passages.get(i);
      Passage p = new Passage(candidateView);
      p.setUri(passage.getDocID());
      p.setBegin(passage.getStart());
      p.setEnd(passage.getEnd());
      p.setQueryString(passage.getQueryString());
      double curScore = passage.getScore();
      p.setScore(curScore);
      if (curScore != prevScore) {
        p.setRank(i + 1);
        prevScore = curScore;
        prevRank = i + 1;
      } else {
        p.setRank(prevRank);
      }
      hitList.set(i, p);
    }

    Search search = new Search(candidateView);
    search.setHitList(hitList);
    search.addToIndexes();
  }

  public static void storePassageTexts(JCas finalView, List<PassageCandidate> passages,
          List<String> texts) {

    Collections.sort(passages, Collections.reverseOrder());
    Iterator<?> it = finalView.getJFSIndexRepository().getAllIndexedFS(Search.type);
    while (it.hasNext()) {
      Search search = (Search) it.next();
      search.removeFromIndexes();
    }

    FSArray hitList = new FSArray(finalView, passages.size());
    for (int i = 0; i < passages.size(); i++) {
      PassageCandidate passage = passages.get(i);
      String text = texts.get(i);
      Passage p = new Passage(finalView);
      p.setUri(passage.getDocID());
      p.setBegin(passage.getStart());
      p.setEnd(passage.getEnd());
      p.setRank(passage.getRank());
      p.setScore(passage.getScore());
      p.setQueryString(passage.getQueryString());
      p.setText(text);
      hitList.set(i, p);
    }

    Search search = new Search(finalView);
    search.setHitList(hitList);
    search.addToIndexes();
  }
  
}
