/*
 *  Copyright 2013 Carnegie Mellon University
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package edu.cmu.lti.oaqa.cse.baseqa;

import java.util.List;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import edu.cmu.lti.oaqa.ecd.BaseExperimentBuilder;
import edu.cmu.lti.oaqa.ecd.log.AbstractLoggedComponent;
import edu.cmu.lti.oaqa.ecd.log.LogEntry;
import edu.cmu.lti.oaqa.cse.baseqa.ConfigurableProviderAnnotator;


/**
 * 
 * Combines several CAS annotators by executing them sequentially. 

 * The consumers are registered in the YAML configuration file 
 * using the "elements" list like follows:
 * 
 * elements: |
 *    - inherit: yaml.path.for.element1
 *    - inherit: yaml.path.for.element2    
 *                 ...
 *    - inherit: yaml.path.for.elementN
 *    
 *    OR:
 *    
 * elements: [ yaml.path.for.element1, ... , yaml.path.for.elementN]
 *    
 * 
 * @author Leonid Boytsov
 * @author Zi Yang <ziy@cs.cmu.edu>
 * 
 */

public class ConfigProviderAnnotatorAggreagtor extends AbstractLoggedComponent {

  protected List<ConfigurableProviderAnnotator>    elements;

  @Override
  public void initialize(UimaContext c) throws ResourceInitializationException {
    super.initialize(c);
    Object elementNames = c.getConfigParameterValue("elements");
    if (elementNames != null) {
      elements = BaseExperimentBuilder.createResourceList(elementNames,
                                                          ConfigurableProviderAnnotator.class);
      for (ConfigurableProviderAnnotator oneElem : elements) {
        oneElem.setCreator(this);
      }      
    }
  }

  @Override
  public void process(JCas jcas) throws AnalysisEngineProcessException {
    super.process(jcas);
    for (ConfigurableProviderAnnotator oneElem : elements) {
      oneElem.process(jcas);
    }
  }
  
  @Override
  public void collectionProcessComplete() throws AnalysisEngineProcessException {
    super.collectionProcessComplete();
    for (ConfigurableProviderAnnotator oneElem : elements) {
      oneElem.collectionProcessComplete();
    }    
  }
  
  public void log(LogEntry type, String message) {
    super.log(type, message);
  }
}
