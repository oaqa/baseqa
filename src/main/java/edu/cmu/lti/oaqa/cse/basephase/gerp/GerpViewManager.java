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

package edu.cmu.lti.oaqa.cse.basephase.gerp;

import org.apache.uima.cas.CASException;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.framework.ViewManager.Type;

public class GerpViewManager {

  public enum ViewType implements Type {
    KEYTERM_EVIDENCE, KEYTERM_RANK, DOCUMENT_EVIDENCE, DOCUMENT_RANK, CANDIDATE_EVIDENCE, CANDIDATE_RANK
  ,PLACEHOLDER_EVIDENCE,PLACEHOLDER_RANK}

  public static JCas getView(JCas jcas, Type type) throws CASException {
    String viewName = type.toString();
    try {
      return jcas.getView(viewName);
    } catch (Exception e) {
      return null;
    }
  }

  public static JCas getOrCreateView(JCas jcas, Type type) throws CASException {
    String viewName = type.toString();
    try {
      return jcas.getView(viewName);
    } catch (Exception e) {
      jcas.createView(viewName);
      return jcas.getView(viewName);
    }
  }

}
