package edu.cmu.lti.oaqa.baseqa.eval;

import java.util.HashMap;
import java.util.Map;

public interface Measure {

  String getName();

  static Map<String, Measure> name2measure = new HashMap<>();

  static Measure forName(String name) {
    return name2measure.get(name);
  }

}
