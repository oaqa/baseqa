package edu.cmu.lti.oaqa.baseqa.collection.candidate;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;

import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceSpecifier;
import org.yaml.snakeyaml.Yaml;

import edu.cmu.lti.oaqa.ecd.config.ConfigurableProvider;
import edu.cmu.lti.oaqa.type.answer.Answer;
import edu.cmu.lti.oaqa.util.TypeFactory;

public class YamlResourceAnswerCandidatePersistenceProvider extends ConfigurableProvider implements
        AnswerCandidatePersistenceProvider {

  private static final Yaml YAML = new Yaml();

  private Map<String, List<String>> id2candidates;

  @SuppressWarnings("unchecked")
  @Override
  public boolean initialize(ResourceSpecifier specifier, Map<String, Object> additionalParams)
          throws ResourceInitializationException {
    String path = (String) additionalParams.get("path");
    id2candidates = (Map<String, List<String>>) YAML.load(getClass().getResourceAsStream(path));
    return true;
  }

  @Override
  public List<Answer> getAnswerCandidates(String questionId, JCas candidateView) {
    return id2candidates.get(questionId).stream()
            .map(text -> TypeFactory.createAnswer(candidateView, text)).collect(toList());
  }

}
