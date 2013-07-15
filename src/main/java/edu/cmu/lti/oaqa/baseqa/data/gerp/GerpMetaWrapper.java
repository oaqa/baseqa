package edu.cmu.lti.oaqa.baseqa.data.gerp;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.gerp.GerpMeta;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.data.core.OAQATopWrapper;
import edu.cmu.lti.oaqa.baseqa.data.core.WrapperHelper;

public class GerpMetaWrapper extends OAQATopWrapper<GerpMeta> {

  private static final long serialVersionUID = 1L;

  protected List<String> generators;

  protected List<String> evidencers;

  protected List<String> rankers;

  protected List<String> pruners;

  public GerpMetaWrapper(List<String> generators, List<String> evidencers, List<String> rankers,
          List<String> pruners) {
    super();
    this.generators = generators;
    this.evidencers = evidencers;
    this.rankers = rankers;
    this.pruners = pruners;
  }

  public GerpMetaWrapper() {
    this(Lists.<String> newArrayList(), Lists.<String> newArrayList(), Lists
            .<String> newArrayList(), Lists.<String> newArrayList());
  }

  @Override
  public Class<? extends GerpMeta> getTypeClass() {
    return GerpMeta.class;
  }

  @Override
  public void wrap(GerpMeta top) throws AnalysisEngineProcessException {
    super.wrap(top);
    generators = WrapperHelper.wrapStringArray(top.getGenerators());
    evidencers = WrapperHelper.wrapStringArray(top.getEvidencers());
    rankers = WrapperHelper.wrapStringArray(top.getRankers());
    pruners = WrapperHelper.wrapStringArray(top.getPruners());
  }

  @Override
  public GerpMeta unwrap(JCas jcas) throws AnalysisEngineProcessException {
    GerpMeta top = super.unwrap(jcas);
    top.setGenerators(WrapperHelper.unwrapStringArray(generators, jcas));
    top.setEvidencers(WrapperHelper.unwrapStringArray(evidencers, jcas));
    top.setRankers(WrapperHelper.unwrapStringArray(rankers, jcas));
    top.setPruners(WrapperHelper.unwrapStringArray(pruners, jcas));
    return top;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(generators, evidencers, rankers, pruners);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    GerpMetaWrapper other = (GerpMetaWrapper) obj;
    return Objects.equal(this.generators, other.generators)
            && Objects.equal(this.evidencers, other.evidencers)
            && Objects.equal(this.rankers, other.rankers)
            && Objects.equal(this.pruners, other.pruners);
  }

  public List<String> getGenerators() {
    return generators;
  }

  public void setGenerators(List<String> generators) {
    this.generators = generators;
  }

  public List<String> getEvidencers() {
    return evidencers;
  }

  public void setEvidencers(List<String> evidencers) {
    this.evidencers = evidencers;
  }

  public List<String> getRankers() {
    return rankers;
  }

  public void setRankers(List<String> rankers) {
    this.rankers = rankers;
  }

  public List<String> getPruners() {
    return pruners;
  }

  public void setPruners(List<String> pruners) {
    this.pruners = pruners;
  }

}
