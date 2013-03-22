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
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import edu.cmu.lti.oaqa.framework.data.QueryConceptList;
import edu.cmu.lti.oaqa.framework.data.QueryConceptTypes;
import edu.cmu.lti.oaqa.framework.data.QueryConceptWrapper;
import edu.cmu.lti.oaqa.framework.eval.gs.AbstractGoldStandardPersistenceProvider;

import edu.cmu.lti.oaqa.framework.eval.gs.DatasetSequenceId;


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
 * @author Di Wang
 * 
 */
public class TrecAnswerGoldStandardFilePersistenceProvider extends
        AbstractGoldStandardPersistenceProvider {

  private static final PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

  private Map<DatasetSequenceId, List<String>> id2gs = new HashMap<DatasetSequenceId, List<String>>();

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
          if (!id2gs.containsKey(id)) {
            id2gs.put(id, new ArrayList<String>());
          }
          id2gs.get(id).add(result.group(2));
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
  public void populateRetrievalGS(String dataset, String sequenceId, JCas gsView) throws Exception {
    List<String>              gsAnswers = id2gs.get(new DatasetSequenceId(dataset, sequenceId));
    List<QueryConceptWrapper> concepts = new ArrayList<QueryConceptWrapper>();
    
    if (gsAnswers != null) {
      for (String answer : gsAnswers) {
        concepts.add(new QueryConceptWrapper(answer, QueryConceptTypes.Answers));
      }
    }
    QueryConceptList.storeQueryConcepts(gsView, concepts);
  }
}
