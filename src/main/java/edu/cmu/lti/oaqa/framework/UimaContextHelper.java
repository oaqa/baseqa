package edu.cmu.lti.oaqa.framework;

import org.apache.uima.UimaContext;

public class UimaContextHelper {

  public static boolean getConfigParameterBooleanValue(UimaContext aContext, String paramName,
          boolean defaultValue) {
    try {
      return (Boolean) aContext.getConfigParameterValue(paramName);
    } catch (ClassCastException e) {
      return Boolean.parseBoolean((String) aContext.getConfigParameterValue(paramName));
    } catch (NullPointerException e) {
      return defaultValue;
    }
  }

  public static double getConfigParameterDoubleValue(UimaContext aContext, String paramName,
          double defaultValue) {
    try {
      return (Double) aContext.getConfigParameterValue(paramName);
    } catch (ClassCastException e) {
      return Double.parseDouble((String) aContext.getConfigParameterValue(paramName));
    } catch (NullPointerException e) {
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
      return defaultValue;
    }
  }

  public static String getConfigParameterStringValue(UimaContext aContext, String paramName,
          String defaultValue) {
    try {
      return (String) aContext.getConfigParameterValue(paramName);
    } catch (NullPointerException e) {
      return defaultValue;
    }
  }

  public static Object getConfigParameterClassInstance(UimaContext aContext, String paramName,
          String defaultClassName) {
    String className = (String) getConfigParameterStringValue(aContext, paramName, defaultClassName);
    try {
      return Class.forName(className).newInstance();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new Object();
  }
}
