package edu.cmu.lti.oaqa.baseqa.data.kb;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.kb.Concept;

import com.google.common.base.Objects;

import edu.cmu.lti.oaqa.baseqa.data.core.WrapperHelper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.GerpTopWrapper;

public class ConceptWrapper extends GerpTopWrapper<Concept> {

  private static final long serialVersionUID = 1L;

  private String name;

  private List<String> ids;

  private List<ConceptMentionWrapper> mentions;

  public ConceptWrapper(String name, List<String> ids, List<ConceptMentionWrapper> mentions) {
    super();
    this.name = name;
    this.ids = ids;
    this.mentions = mentions;
  }

  public ConceptWrapper(String name, List<String> ids, List<ConceptMentionWrapper> mentions,
          String generator) {
    super(generator);
    this.name = name;
    this.ids = ids;
    this.mentions = mentions;
  }

  @Override
  public Class<? extends Concept> getTypeClass() {
    return Concept.class;
  }

  @Override
  public void wrap(Concept top) throws AnalysisEngineProcessException {
    super.wrap(top);
    this.name = top.getName();
    this.ids = WrapperHelper.wrapStringList(top.getIds());
    try {
      this.mentions = WrapperHelper.wrapAnnotationList(top.getMentions(),
              ConceptMentionWrapper.class);
    } catch (Exception e) {
      throw new AnalysisEngineProcessException(e);
    }
  }

  @Override
  public Concept unwrap(JCas jcas) throws AnalysisEngineProcessException {
    Concept top = super.unwrap(jcas);
    top.setName(name);
    top.setIds(WrapperHelper.unwrapStringList(ids, jcas));
    top.setMentions(WrapperHelper.unwrapAnnotationList(mentions, jcas));
    return top;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), name);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    ConceptWrapper other = (ConceptWrapper) obj;
    return Objects.equal(name, other.name);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getIds() {
    return ids;
  }

  public void setIds(List<String> ids) {
    this.ids = ids;
  }

  public List<ConceptMentionWrapper> getMentions() {
    return mentions;
  }

  public void setMentions(List<ConceptMentionWrapper> mentions) {
    this.mentions = mentions;
  }

}
