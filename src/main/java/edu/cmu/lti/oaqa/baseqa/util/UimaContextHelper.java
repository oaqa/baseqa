package edu.cmu.lti.oaqa.baseqa.util;

import org.apache.uima.UimaContext;
import org.apache.uima.resource.ResourceInitializationException;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

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

  public static String[] getConfigParameterStringArrayValue(UimaContext aContext, String paramName,
          String[] defaultValue) throws ResourceInitializationException {
    String[] value = (String[]) aContext.getConfigParameterValue(paramName);
    if (value != null) {
      return value;
    } else {
      System.out.println(" * Parameter \"" + paramName + "\" cannot be found, use default value \""
              + Arrays.asList(defaultValue) + "\" instead.");
      return defaultValue;
    }
  }

  public static String[] getConfigParameterStringArrayValue(UimaContext aContext, String paramName)
          throws ResourceInitializationException {
    String[] value = (String[]) aContext.getConfigParameterValue(paramName);
    if (value == null) {
      throw new ResourceInitializationException(new IllegalArgumentException(
              "Must provide a parameter of type <" + paramName + ">"));
    }
    return value;
  }

  public static <T> Class<? extends T> getConfigParameterClassValue(UimaContext aContext,
          String paramName, Class<? extends T> defaultValue, Class<T> superClass) {
    String className = getConfigParameterStringValue(aContext, paramName, defaultValue.getName());
    try {
      return Class.forName(className).asSubclass(superClass);
    } catch (Exception e) {
      System.out.println(" * Class \"" + className + "\" cannot be set");
      return defaultValue;
    }
  }

  public static <T> T createObjectFromConfigParameter(UimaContext aContext, String classParamName,
          String constructorParamsParamName, Class<? extends T> defaultClass, Class<T> superClass)
          throws ResourceInitializationException {
    Class<? extends T> clazz = UimaContextHelper.getConfigParameterClassValue(aContext,
            classParamName, defaultClass, superClass);
    String[] params = UimaContextHelper.getConfigParameterStringArrayValue(aContext,
            constructorParamsParamName, new String[0]);
    Class<?>[] paramTypes = Arrays.stream(params).map(p -> String.class).toArray(Class[]::new);
    try {
      return clazz.getConstructor(paramTypes).newInstance((Object[]) params);
    } catch (NoSuchMethodException | SecurityException | InstantiationException
            | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
      throw new ResourceInitializationException(e);
    }
  }

}
