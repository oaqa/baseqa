package edu.cmu.lti.oaqa.baseqa.data.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.cas.TOP;
import org.oaqa.model.core.OAQATop;

@Deprecated
public abstract class FSArrayWrapper<T extends OAQATop> implements ContainerWrapper<T> {

  protected JCas jcas;

  protected FSArray array;

  protected int i;

  public FSArrayWrapper(JCas jcas, int length) {
    this.jcas = jcas;
    array = new FSArray(jcas, length);
    i = 0;
  }

  @Override
  public void add(TopWrapper<T> annotation) throws AnalysisEngineProcessException {
    array.set(i++, annotation.unwrap(jcas));
  }

  @Override
  public abstract void clear();

  @Override
  public abstract void complete();

  protected final <W extends TopWrapper<T>> void appendArray(Collection<W> wrappers)
          throws AnalysisEngineProcessException {
    for (W wrapper : wrappers) {
      add(wrapper);
    }
    complete();
  }

  protected final <W extends TopWrapper<T>> void setArray(Collection<W> wrappers)
          throws AnalysisEngineProcessException {
    clear();
    appendArray(wrappers);
  }

  protected final <W extends TopWrapper<T>> List<W> getArray(Class<W> classWrapper)
          throws AnalysisEngineProcessException {
    List<W> result = new ArrayList<W>();
    for (int i = 0; i < array.size(); i++) {
      try {
        result.add(WrapperHelper.checkWrappedMatchSubclassAndWrap((TOP) array.get(i), classWrapper));
      } catch (Exception e) {
        throw new AnalysisEngineProcessException(e);
      }
    }
    return result;
  }
}
