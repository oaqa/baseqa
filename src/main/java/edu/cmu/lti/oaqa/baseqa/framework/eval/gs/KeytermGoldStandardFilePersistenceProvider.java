package edu.cmu.lti.oaqa.baseqa.framework.eval.gs;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;

import org.apache.uima.jcas.JCas;
import org.oaqa.model.retrieval.QueryConcept;

public class KeytermGoldStandardFilePersistenceProvider extends
        AbstractGoldStandardFilePersistenceProvider<String> {

  @Override
  public List<QueryConcept> populateRetrievalGS(String dataset, String sequenceId, JCas gsView) {
    List<QueryConcept> gsAnnotations = new ArrayList<QueryConcept>();
    List<String> gsSpans = id2gsSpans.get(new DatasetSequenceId(dataset, sequenceId));
    if (gsSpans != null) {
      for (String gsSpan : gsSpans) {
        QueryConcept concept = new QueryConcept(gsView);
        concept.setText(gsSpan);
        gsAnnotations.add(concept);
      }
    }
    return gsAnnotations;
  }

  @Override
  protected String getGoldStandardFromParsedResult(MatchResult result) {
    return result.group(4);
  }

}
