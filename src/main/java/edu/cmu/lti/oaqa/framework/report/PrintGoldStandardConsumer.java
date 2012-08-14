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

package edu.cmu.lti.oaqa.framework.report;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CAS;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;
import org.apache.uima.util.ProcessTrace;
import org.oaqa.model.Passage;

import edu.cmu.lti.oaqa.framework.CasUtils;
import edu.cmu.lti.oaqa.framework.ViewManager;
import edu.cmu.lti.oaqa.framework.ViewManager.ViewType;
import edu.cmu.lti.oaqa.framework.eval.passage.PassageHelper;
import edu.cmu.lti.oaqa.framework.types.InputElement;

public class PrintGoldStandardConsumer extends CasConsumer_ImplBase {
  
  private PrintStream out;

  @Override
  public void initialize() throws ResourceInitializationException {
    String outputFile = (String) getConfigParameterValue("outputFile");
    try {
      this.out = new PrintStream(new FileOutputStream(outputFile));
    } catch (FileNotFoundException e) {
      throw new ResourceInitializationException(e);
    }
  }

  @Override
  public void processCas(CAS aCAS) throws ResourceProcessException {
    try {
      JCas jcas = aCAS.getJCas();
      InputElement input = (InputElement) CasUtils.getFirst(jcas, InputElement.class.getName());
      JCas gsView = ViewManager.getView(jcas, ViewType.DOCUMENT_GS);
      List<Passage> gs = PassageHelper.loadDocumentSet(gsView);
      out.printf("%s: %s [%s]\n", input.getSequenceId(), input.getQuestion(), gs.size());
      for (Passage passage : gs) {
        out.printf("(%s) %s@[%s:%s]>>>\n%s\n", passage.getRank(), passage.getUri(), passage.getBegin(), passage.getEnd(), passage.getText());
      }
      out.println("=============================================");
    } catch (Exception e) {
      throw new ResourceProcessException(e);
    }
  }

  @Override
  public void collectionProcessComplete(ProcessTrace arg0) throws AnalysisEngineProcessException {
    out.close();
  }
}
