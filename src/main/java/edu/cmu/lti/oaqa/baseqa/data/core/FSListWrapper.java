package edu.cmu.lti.oaqa.baseqa.data.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSList;
import org.oaqa.model.core.OAQATop;

import edu.cmu.lti.oaqa.framework.BaseJCasHelper;

@Deprecated
public abstract class FSListWrapper<T extends OAQATop> implements ContainerWrapper<T> {

  protected JCas jcas;

  protected FSList list;

  public FSListWrapper(JCas jcas) {
    this.jcas = jcas;
    list = new FSList(jcas);
  }

  @Override
  public void add(TopWrapper<T> wrapper) throws AnalysisEngineProcessException {
    list = BaseJCasHelper.addToFSList(jcas, list, WrapperHelper.unwrap(wrapper, jcas));
  }

  @Override
  public abstract void clear();

  @Override
  public abstract void complete();

  protected final <W extends TopWrapper<T>> void appendList(Collection<W> wrappers)
          throws AnalysisEngineProcessException {
    for (W wrapper : wrappers) {
      add(wrapper);
    }
    complete();
  }

  protected final <W extends TopWrapper<T>> void setList(Collection<W> wrappers)
          throws AnalysisEngineProcessException {
    clear();
    appendList(wrappers);
  }

  protected final <W extends TopWrapper<T>> List<W> getList(Class<W> classWrapper)
          throws AnalysisEngineProcessException {
    List<W> result = new ArrayList<W>();
    for (OAQATop top : BaseJCasHelper.<OAQATop> fsIterator(list)) {
      try {
        result.add(WrapperHelper.matchSubclassAndWrap(top, classWrapper));
      } catch (Exception e) {
        throw new AnalysisEngineProcessException(e);
      }
    }
    return result;
  }
}
