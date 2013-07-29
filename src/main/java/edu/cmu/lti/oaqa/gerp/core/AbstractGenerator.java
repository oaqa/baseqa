package edu.cmu.lti.oaqa.gerp.core;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.TOP;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.reflect.TypeToken;

import edu.cmu.lti.oaqa.core.data.TopWrapper;
import edu.cmu.lti.oaqa.core.data.WrapperHelper;
import edu.cmu.lti.oaqa.ecd.log.AbstractLoggedComponent;
import edu.cmu.lti.oaqa.gerp.data.Gerpable;

public abstract class AbstractGenerator<T extends TOP, W extends Gerpable & TopWrapper<T>> extends
        AbstractLoggedComponent implements Generator<W> {

  public abstract List<Integer> getRequiredInputTypes();

  public TypeToken<W> type = new TypeToken<W>(getClass()) {

    private static final long serialVersionUID = 1L;

  };

  protected void log(String message) {
    super.log(GerpLogEntry.getGenerateLog(type.getClass()), message);
  };

  @Override
  public void process(JCas jcas) throws AnalysisEngineProcessException {
    super.process(jcas);
    List<TopWrapper<? extends TOP>> inputs = Lists.newArrayList();
    for (int type : getRequiredInputTypes()) {
      inputs.add(Iterables.getOnlyElement(WrapperHelper.wrapAllFromJCas(jcas, type)));
    }
    W output = generate(inputs);
    WrapperHelper.unwrap(output, jcas).addToIndexes(jcas);
  }

}
