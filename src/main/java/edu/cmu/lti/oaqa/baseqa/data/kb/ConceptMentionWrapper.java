package edu.cmu.lti.oaqa.baseqa.data.kb;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
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
    try {
      this.concept = WrapperHelper.matchSubclassAndWrapIfNotWrapped(annotation.getConcept(),
              ConceptWrapper.class);
    } catch (Exception e) {
      throw new AnalysisEngineProcessException(e);
    }
  }

  @Override
  public ConceptMention unwrap(JCas jcas) throws AnalysisEngineProcessException {
    ConceptMention annotation = super.unwrap(jcas);
    annotation.setConcept(concept.unwrapIfNotUnwrapped(jcas));
    return annotation;
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
