package edu.cmu.lti.oaqa.cse.baseqa;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.ecd.config.ConfigurableProvider;
import edu.cmu.lti.oaqa.ecd.log.LogEntry;

public abstract class ConfigurableProviderAnnotator extends ConfigurableProvider {

  public abstract void process(JCas jcas) throws AnalysisEngineProcessException;
  
  public void setCreator(ConfigProviderAnnotatorAggreagtor creator) {
    this.Creator = creator;
  }
  
  public void log(LogEntry type, String message) {
    Creator.log(type, message);
  }  
  
  public void collectionProcessComplete() throws AnalysisEngineProcessException {
  }
    
  private ConfigProviderAnnotatorAggreagtor Creator;

}
