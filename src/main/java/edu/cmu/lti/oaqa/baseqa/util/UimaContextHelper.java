package edu.cmu.lti.oaqa.baseqa.util;

import org.apache.uima.UimaContext;
import org.apache.uima.resource.ResourceInitializationException;

public class UimaContextHelper {

  public static boolean getConfigParameterBooleanValue(UimaContext aContext, String paramName,
          boolean defaultValue) {
    try {
      return (Boolean) aContext.getConfigParameterValue(paramName);
    } catch (ClassCastException e) {
      return Boolean.parseBoolean((String) aContext.getConfigParameterValue(paramName));
    } catch (NullPointerException e) {
      System.out.println(" * Parameter \"" + paramName + "\" cannot be found, use default value \""
              + defaultValue + "\" instead.");
      return defaultValue;
    }
  }

  public static float getConfigParameterFloatValue(UimaContext aContext, String paramName,
          float defaultValue) {
    try {
      return (Float) aContext.getConfigParameterValue(paramName);
    } catch (ClassCastException e) {
      try {
        return (Integer) aContext.getConfigParameterValue(paramName);
      } catch (ClassCastException err) {
        return Float.parseFloat((String) aContext.getConfigParameterValue(paramName));
      }
    } catch (NullPointerException e) {
      System.out.println(" * Parameter \"" + paramName + "\" cannot be found, use default value \""
              + defaultValue + "\" instead.");
      return defaultValue;
    }
  }

  public static int getConfigParameterIntValue(UimaContext aContext, String paramName,
          int defaultValue) {
    try {
      return (Integer) aContext.getConfigParameterValue(paramName);
    } catch (ClassCastException e) {
      return Integer.parseInt((String) aContext.getConfigParameterValue(paramName));
    } catch (NullPointerException e) {
      System.out.println(" * Parameter \"" + paramName + "\" cannot be found, use default value \""
              + defaultValue + "\" instead.");
      return defaultValue;
    }
  }

  public static String getConfigParameterStringValue(UimaContext aContext, String paramName,
          String defaultValue) {
    String value = (String) aContext.getConfigParameterValue(paramName);
    if (value != null) {
      return value;
    } else {
      System.out.println(" * Parameter \"" + paramName + "\" cannot be found, use default value \""
              + defaultValue + "\" instead.");
      return defaultValue;
    }
  }

  public static Object getConfigParameterClassInstance(UimaContext aContext, String paramName,
          String defaultClassName) {
    String className = (String) getConfigParameterStringValue(aContext, paramName, defaultClassName);
    try {
      return Class.forName(className).newInstance();
    } catch (Exception e) {
      System.out.println(" * Class \"" + className + "\" cannot be set");
      return new Object();
    }
  }

  public static String getConfigParameterStringValue(UimaContext aContext, String paramName)
          throws ResourceInitializationException {
    String value = (String) aContext.getConfigParameterValue(paramName);
    if (value == null) {
      throw new ResourceInitializationException(new IllegalArgumentException(
              "Must provide a parameter of type <" + paramName + ">"));
    }
    return value;
  }

  public static Object getConfigParameterValue(UimaContext aContext, String paramName)
          throws ResourceInitializationException {
    Object value = aContext.getConfigParameterValue(paramName);
    if (value == null) {
      throw new ResourceInitializationException(new IllegalArgumentException(
              "Must provide a parameter of type <" + paramName + ">"));
    }
    return value;
  }

}
