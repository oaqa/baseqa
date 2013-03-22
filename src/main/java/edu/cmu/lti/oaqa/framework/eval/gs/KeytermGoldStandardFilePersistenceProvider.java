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

/**
 * A gold standard persistence provider that reads a file containing 
 * gold standard annotations and stores it in a CAS.
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
          String      seqNum = result.group(1);
          DatasetSequenceId id = new DatasetSequenceId(dataset, seqNum);
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
  public void populateRetrievalGS(String dataset, String sequenceId, JCas gsView) throws Exception {
    List<QueryConceptWrapper>   concepts = new ArrayList<QueryConceptWrapper>();
    List<String>                gsKeyterms = id2gsSpans.get(new DatasetSequenceId(dataset, sequenceId));
    
    if (gsKeyterms != null) {
      for (String Keyterm : gsKeyterms) {
        concepts.add(new QueryConceptWrapper(Keyterm, QueryConceptTypes.KeyTerms));        
      }
    }
    QueryConceptList.storeQueryConcepts(gsView, concepts);
  }
}
