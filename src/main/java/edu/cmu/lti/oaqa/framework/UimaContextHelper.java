/*
 *  Copyright 2013 Carnegie Mellon University
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

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
    }catch (NullPointerException e) {
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
}
