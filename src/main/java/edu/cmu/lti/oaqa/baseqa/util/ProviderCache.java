package edu.cmu.lti.oaqa.baseqa.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.uima.resource.Resource;
import org.apache.uima.resource.ResourceInitializationException;

import edu.cmu.lti.oaqa.ecd.BaseExperimentBuilder;

public class ProviderCache {

  public static final Map<String, Resource> provider2resource = new HashMap<>();

  public static <T extends Resource> T getProvider(String provider, Class<T> type)
          throws ResourceInitializationException {
    Resource resource;
    if ((resource = provider2resource.get(provider)) == null) {
      if ((resource = BaseExperimentBuilder.loadProvider(provider, type)) != null) {
        provider2resource.put(provider, resource);
      }
    }
    return type.cast(resource);
  }

}
