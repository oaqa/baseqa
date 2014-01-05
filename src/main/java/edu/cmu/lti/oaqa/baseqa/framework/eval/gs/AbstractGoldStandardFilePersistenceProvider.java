package edu.cmu.lti.oaqa.baseqa.framework.eval.gs;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceSpecifier;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

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
public abstract class AbstractGoldStandardFilePersistenceProvider<T> extends
        AbstractGoldStandardPersistenceProvider {

  private static final PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

  protected ListMultimap<DatasetSequenceId, T> id2gsSpans = ArrayListMultimap.create();

  public AbstractGoldStandardFilePersistenceProvider() {
    super();
  }

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
          id2gsSpans.get(id).add(getGoldStandardFromParsedResult(result));
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

  protected abstract T getGoldStandardFromParsedResult(MatchResult result);

}