package edu.cmu.lti.oaqa.baseqa.data.kb;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.kb.Concept;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

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
    this(name, ids, mentions);
    addGenerator(generator);
  }

  public ConceptWrapper() {
    this(null, Lists.<String> newArrayList(), Lists.<ConceptMentionWrapper> newArrayList());
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
    this.mentions = WrapperHelper
            .wrapAnnotationList(top.getMentions(), ConceptMentionWrapper.class);
  }

  @Override
  public void unwrap(Concept top) throws AnalysisEngineProcessException {
    super.unwrap(top);
    top.setName(name);
    JCas jcas = WrapperHelper.getJCas(top);
    top.setIds(WrapperHelper.unwrapStringList(ids, jcas));
    top.setMentions(WrapperHelper.unwrapAnnotationList(mentions, jcas));
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ConceptWrapper other = (ConceptWrapper) obj;
    return Objects.equal(this.name, other.name);
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
