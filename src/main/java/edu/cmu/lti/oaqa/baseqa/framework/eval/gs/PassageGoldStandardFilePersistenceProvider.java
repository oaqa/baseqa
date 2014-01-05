package edu.cmu.lti.oaqa.baseqa.framework.eval.gs;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;

import org.apache.uima.jcas.JCas;
import org.oaqa.model.retrieval.Passage;

public class PassageGoldStandardFilePersistenceProvider extends
        AbstractGoldStandardFilePersistenceProvider<GoldStandardSpan> {

  @Override
  public List<Passage> populateRetrievalGS(String dataset, String sequenceId, JCas gsView) {
    List<Passage> gsAnnotations = new ArrayList<Passage>();
    List<GoldStandardSpan> gsSpans = id2gsSpans.get(new DatasetSequenceId(dataset, sequenceId));
    if (gsSpans != null) {
      for (GoldStandardSpan gsSpan : gsSpans) {
        Passage passage = new Passage(gsView);
        passage.setUri(gsSpan.docId);
        passage.setBegin(gsSpan.begin);
        passage.setEnd(gsSpan.end);
        passage.setAspects(gsSpan.aspects);
        gsAnnotations.add(passage);
      }
    }
    return gsAnnotations;
  }

  @Override
  protected GoldStandardSpan getGoldStandardFromParsedResult(MatchResult result) {
    return new GoldStandardSpan(result.group(2), Integer.parseInt(result.group(3)),
            Integer.parseInt(result.group(4)), result.group(5));
  }

}
