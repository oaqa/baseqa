/*
 *  Copyright 2012 Carnegie Mellon University
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

package edu.cmu.lti.oaqa.mergeqa;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import edu.cmu.lti.oaqa.ecd.BaseExperimentBuilder;
import edu.cmu.lti.oaqa.ecd.phase.ProcessingStepUtils;
import edu.cmu.lti.oaqa.ecd.phase.Trace;
import edu.cmu.lti.oaqa.framework.QALogEntry;

public abstract class AbstractComponent extends JCasAnnotator_ImplBase {

  protected String uuid;

  protected Trace trace;
  
  private LogPersistenceProvider persistence;

  @Override
  public void initialize(UimaContext c)
          throws ResourceInitializationException {
    String pp = (String) c.getConfigParameterValue("persistence-provider");
    if (pp == null) {
      throw new ResourceInitializationException(new IllegalArgumentException(
              "Must provide a parameter of type <persistence-provider>"));
    }
    this.persistence = BaseExperimentBuilder.loadProvider(pp,
            LogPersistenceProvider.class);
  }
  
  @Override
  public void process(JCas jcas) throws AnalysisEngineProcessException {
    uuid = ProcessingStepUtils.getCurrentExperimentId(jcas);
    trace = ProcessingStepUtils.getTrace(jcas);
  }

  protected void log(QALogEntry type, String message) {
    persistence.log(uuid, trace, type, message);
  }
}
