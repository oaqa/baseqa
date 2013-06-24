package edu.cmu.lti.oaqa.baseqa.data.gerp;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.gerp.GerpMeta;

import edu.cmu.lti.oaqa.baseqa.data.core.OAQATopWrapper;
import edu.cmu.lti.oaqa.baseqa.data.core.WrapperHelper;

public class GerpMetaWrapper extends OAQATopWrapper<GerpMeta> {

  protected List<String> generators;

  protected List<String> evidencers;

  protected List<String> rankers;

  protected List<String> pruners;

  @Override
  public Class<? extends GerpMeta> getTypeClass() {
    return GerpMeta.class;
  }

  @Override
  public void wrap(GerpMeta top) throws AnalysisEngineProcessException {
    generators = WrapperHelper.wrapStringArray(top.getGenerators());
    super.wrap(top);
  }

  @Override
  public GerpMeta unwrap(JCas jcas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    return super.unwrap(jcas);
  }

}
