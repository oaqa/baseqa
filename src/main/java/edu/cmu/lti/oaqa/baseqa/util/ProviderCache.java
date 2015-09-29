package edu.cmu.lti.oaqa.baseqa.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.uima.resource.Resource;
import org.apache.uima.resource.ResourceInitializationException;
import org.yaml.snakeyaml.Yaml;

import edu.cmu.lti.oaqa.ecd.BaseExperimentBuilder;

public class ProviderCache {

  private static final Map<Map<String, String>, Resource> GLOBAL_CONF_TO_RESOURCE = new HashMap<>();

  private static final Yaml GLOBAL_YAML = new Yaml();

  public static <T extends Resource> T getProvider(String providerDesc, Class<T> type)
          throws ResourceInitializationException {
    @SuppressWarnings("unchecked")
    Map<String, String> providerConfMap = (Map<String, String>) GLOBAL_YAML.load(providerDesc);
    return getProvider(providerConfMap, type);
  }

  public static <T extends Resource> List<T> getProviders(String providerDescs, Class<T> type)
          throws ResourceInitializationException {
    @SuppressWarnings("unchecked")
    List<Map<String, String>> providerConfMaps = (List<Map<String, String>>) GLOBAL_YAML
            .load(providerDescs);
    List<T> providers = new ArrayList<>();
    for (Map<String, String> map : providerConfMaps) {
      providers.add(getProvider(map, type));
    }
    return providers;
  }

  private static <T extends Resource> T getProvider(Map<String, String> providerConfMap,
          Class<T> type) throws ResourceInitializationException {
    Resource resource = GLOBAL_CONF_TO_RESOURCE.get(providerConfMap);
    if (resource == null) {
      resource = BaseExperimentBuilder
              .buildResource(BaseExperimentBuilder.buildHandleFromMap(providerConfMap), type);
    }
    if (resource == null) {
      throw new ResourceInitializationException();
    }
    GLOBAL_CONF_TO_RESOURCE.put(providerConfMap, resource);
    return type.cast(resource);
  }

}
