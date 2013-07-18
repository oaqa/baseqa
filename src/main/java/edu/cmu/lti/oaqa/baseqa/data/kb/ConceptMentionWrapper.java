package edu.cmu.lti.oaqa.baseqa.data.kb;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.oaqa.model.kb.ConceptMention;

import com.google.common.base.Objects;

import edu.cmu.lti.oaqa.baseqa.data.core.WrapperHelper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.GerpAnnotationWrapper;

public class ConceptMentionWrapper extends GerpAnnotationWrapper<ConceptMention> {

  private static final long serialVersionUID = 1L;

  private ConceptWrapper concept;

  public ConceptMentionWrapper(int begin, int end, ConceptWrapper concept) {
    super(begin, end);
    this.concept = concept;
  }

  public ConceptMentionWrapper(int begin, int end, ConceptWrapper concept, String generator) {
    this(begin, end, concept);
    addGenerator(generator);
  }

  public ConceptMentionWrapper() {
    this(0, Integer.MAX_VALUE, null);
  }

  @Override
  public Class<? extends ConceptMention> getTypeClass() {
    return ConceptMention.class;
  }

  @Override
  public void wrap(ConceptMention annotation) throws AnalysisEngineProcessException {
    super.wrap(annotation);
    if (annotation.getConcept() != null) {
      this.concept = WrapperHelper.matchSubclassAndWrap(annotation.getConcept(),
              ConceptWrapper.class);
    }
  }

  @Override
  public void unwrap(ConceptMention annotation) throws AnalysisEngineProcessException {
    super.unwrap(annotation);
    if (concept != null) {
      annotation.setConcept(WrapperHelper.unwrap(concept, WrapperHelper.getJCas(annotation)));
    }
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), concept);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    ConceptMentionWrapper other = (ConceptMentionWrapper) obj;
    return Objects.equal(this.concept, other.concept);
  }

  public ConceptWrapper getConcept() {
    return concept;
  }

  public void setConcept(ConceptWrapper concept) {
    this.concept = concept;
  }

}
