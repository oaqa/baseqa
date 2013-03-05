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

package edu.cmu.lti.oaqa.cse.basephase.keyterm;

import java.util.ArrayList;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.ecd.log.AbstractLoggedComponent;
import edu.cmu.lti.oaqa.framework.BaseJCasHelper;
import edu.cmu.lti.oaqa.framework.QALogEntry;
import edu.cmu.lti.oaqa.framework.data.base.JCasHelper;
import edu.cmu.lti.oaqa.framework.types.InputElement;

/**
 * 
 * @author Zi Yang <ziy@cs.cmu.edu>
 * 
 */
public abstract class AbstractKeytermUpdater extends AbstractLoggedComponent {

  protected abstract void updateKeyterms(String question, List<String> keyTerms, List<String> keyPhrases);

  @Override
  public final void process(JCas jcas) throws AnalysisEngineProcessException {
    super.process(jcas);
    try {
      // prepare input
      String question = ((InputElement) BaseJCasHelper.getAnnotation(jcas, InputElement.type)).getQuestion();
      
      List<String>  keyTerms   = new ArrayList<String>();
      List<String>  keyPhrases = new ArrayList<String>();
      
      // Retrieve key terms and phrases
      JCasHelper.loadKeyTermsAndPhrases(jcas, keyTerms, keyPhrases);
      
      // updated
      updateKeyterms(question, keyTerms, keyPhrases);
      log("Updated KeyTerms:   " + keyTerms.toString());
      log("Updated KeyPhrases: " + keyTerms.toString());
      // save output
      JCasHelper.storeKeyTermsAndPhrases(jcas, keyTerms, keyPhrases);
    } catch (Exception e) {
      throw new AnalysisEngineProcessException(e);
    }
  }

  protected final void log(String message) {
    super.log(QALogEntry.KEYTERM, message);
  }

}
