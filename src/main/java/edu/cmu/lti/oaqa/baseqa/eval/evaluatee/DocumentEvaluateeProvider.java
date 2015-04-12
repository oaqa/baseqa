package edu.cmu.lti.oaqa.baseqa.eval.evaluatee;

import java.util.Collection;
import java.util.Comparator;
import java.util.function.Function;

import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.baseqa.eval.EvaluateeProvider;
import edu.cmu.lti.oaqa.baseqa.util.ViewType;
import edu.cmu.lti.oaqa.ecd.config.ConfigurableProvider;
import edu.cmu.lti.oaqa.type.retrieval.Document;
import edu.cmu.lti.oaqa.util.TypeUtil;

public class DocumentEvaluateeProvider extends ConfigurableProvider implements
        EvaluateeProvider<Document> {

  @Override
  public Collection<Document> getGoldStandard(JCas jcas) {
    return TypeUtil.getRankedDocuments(ViewType.getGsView(jcas));
  }

  @Override
  public Collection<Document> getResults(JCas jcas) {
    return TypeUtil.getRankedDocuments(jcas);
  }

  @Override
  public Comparator<Document> comparator() {
    return Comparator.comparing(Document::getRank);
  }

  @Override
  public Function<Document, String> uniqueIdMapper() {
    return Document::getUri;
  }

  @Override
  public String getName() {
    return "Document";
  }
  
}
