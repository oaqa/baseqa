package edu.cmu.lti.oaqa.framework.data.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;
import org.oaqa.model.OAQATop;

public abstract class FSArrayWrapper<T extends OAQATop> implements ContainerWrapper<T> {

  protected JCas jcas;

  protected FSArray array;

  protected int index;

  public FSArrayWrapper(JCas jcas, int length) {
    this.jcas = jcas;
    array = new FSArray(jcas, length);
    index = 0;
  }

  @Override
  public void add(AnnotationWrapper<T> annotation) throws Exception {
    array.set(index++, annotation.unwrap(jcas));
  }

  @Override
  public abstract void clear();

  @Override
  public abstract void complete();

  protected final <W extends AnnotationWrapper<T>> void setArray(Collection<W> wrappers)
          throws Exception {
    clear();
    for (W wrapper : wrappers) {
      add(wrapper);
    }
    complete();
  }

  protected final <W extends AnnotationWrapper<T>> List<W> getArray(Class<T> type,
          Class<W> classWrapper) throws AnalysisEngineProcessException {
    List<W> result = new ArrayList<W>();
    for (int i = 0; i < array.size(); i++) {
      result.add(BaseAnnotationWrapper.wrap((OAQATop) array.get(i), type, classWrapper));
    }
    return result;
  }
}
