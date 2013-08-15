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

package edu.cmu.lti.oaqa.framework.eval.gs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceSpecifier;
import org.oaqa.model.QueryConcept;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * A gold standard persistence provider that can read a file containing gold standard annotations
 * into the memory, and stored in a map structure, and populate gold standard labels for each input
 * element.
 * 
 * Required parameter: DataSet, LineSyntax (specifying what the line syntax of the gold standard
 * annotation, e.g. "(\d+)\s+(\d+)\s+(\d+)" represent the sequence id, begin and end are separated
 * by white-spaces), and PathPattern (refer to the PathMatchingResourcePatternResolver in the spring
 * framework for more detail)
 * 
 * @author Zi Yang <ziy@cs.cmu.edu>
 * 
 */
public class KeytermGoldStandardFilePersistenceProvider extends
        AbstractGoldStandardPersistenceProvider {

  private static final PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

  private Map<DatasetSequenceId, List<String>> id2gsSpans = new HashMap<DatasetSequenceId, List<String>>();

  @Override
  public boolean initialize(ResourceSpecifier aSpecifier, Map<String, Object> aAdditionalParams)
          throws ResourceInitializationException {
    boolean ret = super.initialize(aSpecifier, aAdditionalParams);
    String dataset = (String) getParameterValue("DataSet");
    Pattern lineSyntaxPattern = Pattern.compile((String) getParameterValue("LineSyntax"));
    try {
      Resource[] resources = resolver.getResources((String) getParameterValue("PathPattern"));
      for (Resource resource : resources) {
        Scanner scanner = new Scanner(resource.getInputStream());
        while (scanner.findInLine(lineSyntaxPattern) != null) {
          MatchResult result = scanner.match();
          DatasetSequenceId id = new DatasetSequenceId(dataset, result.group(1));
          if (!id2gsSpans.containsKey(id)) {
            id2gsSpans.put(id, new ArrayList<String>());
          }
          id2gsSpans.get(id).add(result.group(4));
          if (scanner.hasNextLine()) {
            scanner.nextLine();
          } else {
            break;
          }
        }
        scanner.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return ret;
  }

  @Override
  public List<QueryConcept> populateRetrievalGS(String dataset, String sequenceId, JCas gsView) {
    List<QueryConcept> gsAnnotations = new ArrayList<QueryConcept>();
    List<String> gsSpans = id2gsSpans.get(new DatasetSequenceId(dataset, sequenceId));
    if (gsSpans != null) {
      for (String gsSpan : gsSpans) {
        QueryConcept concept = new QueryConcept(gsView);
        concept.setText(gsSpan);
        gsAnnotations.add(concept);
      }
    }
    return gsAnnotations;
  }

  /**
   * A dataset, sequenceId pair used as the key of the GSProvider to populate gold-standards wrt
   * particular input.
   * 
   * @author Zi Yang <ziy@cs.cmu.edu>
   * 
   */
  public class DatasetSequenceId {
    String dataset;

    String sequenceId;

    public DatasetSequenceId(String dataset, String sequenceId) {
      super();
      this.dataset = dataset;
      this.sequenceId = sequenceId;
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + getOuterType().hashCode();
      result = prime * result + ((dataset == null) ? 0 : dataset.hashCode());
      result = prime * result + sequenceId.hashCode();
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      DatasetSequenceId other = (DatasetSequenceId) obj;
      if (!getOuterType().equals(other.getOuterType()))
        return false;
      if (dataset == null) {
        if (other.dataset != null)
          return false;
      } else if (!dataset.equals(other.dataset))
        return false;
      if (!sequenceId.equals(other.sequenceId)) {
          return false;
      }      
      return true;
    }

    private KeytermGoldStandardFilePersistenceProvider getOuterType() {
      return KeytermGoldStandardFilePersistenceProvider.this;
    }

  }

}
