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

package edu.cmu.lti.oaqa.cse.baseqa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.uima.UIMAFramework;
import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import org.apache.uima.resource.ResourceInitializationException;
import org.uimafit.factory.AnalysisEngineFactory;
import org.yaml.snakeyaml.Yaml;

import com.google.common.base.Throwables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;

import edu.cmu.lti.oaqa.ecd.BaseExperimentBuilder;
import edu.cmu.lti.oaqa.ecd.ResourceHandle;
import edu.cmu.lti.oaqa.ecd.log.AbstractLoggedComponent;
import edu.cmu.lti.oaqa.ecd.phase.event.TerminateEvent;


/**
 * 
 * Combines several CAS annotators by executing them sequentially. 

 * The consumers are registered in the YAML configuration file 
 * using the "elements" list like follows:
 * <p> 
 * elements: |
 *    - inherit: rankqa.element1
 *    - inherit: rankqa.element2    
 *                 ...
 *    - inherit: rankqa.elementN
 * 
 * @author Leonid Boytsov <srcvhrs@cmu.edu> 
 * 
 */

public class AnnotatorAggregator extends AbstractLoggedComponent {
	private static String ElementNames    = "elements";
	private static String InheritKeyword  = "inherit";
	private static String FormatErrorMsg  = "Each entry in " + ElementNames + 
														" must have exactly one element in the form: " +
														" " + InheritKeyword + ": <name>";

  private 			List<AnalysisEngine> elements;

  @Override
  public void initialize(UimaContext context) throws ResourceInitializationException {
  	super.initialize(context);
  	
  	ReadElements(context);
  }
  
  public void terminate(TerminateEvent event) {
  	super.terminate(event);
  }  

  /**
   * Sequentially passes aCAS to all components in the "elements" list,
   * which is defined in the YAML-configuration file.
   */
  @Override
  public final void process(JCas jcas) throws AnalysisEngineProcessException {
    super.process(jcas);
  	
    try {
      for (AnalysisEngine oneElem : elements) {
        oneElem.process(jcas);     
      }
    } catch (Exception e) {
      throw new AnalysisEngineProcessException(e);
    }    	
  }
  
  @Override
  public void collectionProcessComplete() throws AnalysisEngineProcessException {
    super.collectionProcessComplete();
    for (AnalysisEngine oneElem : elements) {
      oneElem.collectionProcessComplete();     
    }
  }
  
  
  /**
   * Create a list of annotators specified in the YAML configuration file.
   */
  
  private void ReadElements(UimaContext context) throws ResourceInitializationException {
    Object elementNames = (Object) context.getConfigParameterValue(ElementNames);
    if (elementNames != null) {
      this.elements = new ArrayList<AnalysisEngine>();
      
      if (elementNames instanceof String) {
        String description = (String) elementNames;
        Yaml yaml = new Yaml();
       
        
        Object obj = yaml.load(description);
        
        try {
        	// TODO: Figure out why compiler complains about an unchecked exception
        	@SuppressWarnings("unchecked")
        	List<Map<String, String>> elems = (List<Map<String, String>>) obj;

        	for (Map<String, String> DescMap: elems) {
        		elements.add(CreateAnnotator(DescMap));
        	}
        } catch (ClassCastException e) {
        	System.err.printf("[ERROR] cannot parse elements' description %s:\n", description);
        	throw new ResourceInitializationException(new Exception(FormatErrorMsg));
        } catch (ResourceInitializationException e) {
        	System.err.printf("[ERROR] cannot parse elements' description %s:\n", description);
        	throw new ResourceInitializationException(new Exception(FormatErrorMsg));        	        	        	
        }
      } else {
      	throw new ResourceInitializationException(new Exception("Parameter: " +
      																		ElementNames +" should be a string"));
      }
    } else {
    	throw new ResourceInitializationException(new Exception("Missing parameter: " 
    																													+ ElementNames));
    }
  	
  }
  
  AnalysisEngine CreateAnnotator(Map<String, String> DescMap) throws ResourceInitializationException {
  	if (DescMap.size() != 1) {
  		throw new ResourceInitializationException();
  	}
  	
  	Map.Entry<String, String> OneDesc = Iterators.get(DescMap.entrySet().iterator(), 0);
  	
  	if (!OneDesc.getKey().equals(InheritKeyword)) {
  		throw new ResourceInitializationException();        		
  	}  	

    
    /*
     * Elements are the list in the form:
     * 
     * elements: |
		 *    - inherit: rankqa.element1
		 *    - inherit: rankqa.element2    
		 *                 ...
		 *    - inherit: rankqa.elementN
		 *    
		 *  In YAML, it is a list of maps.
		 *  Each map contains only a single key-value pair.
		 *  The key is always "inherit"
     * 
     */  	
  	
  	try {
	    Map<String, Object> tuples = Maps.newHashMap();
	    
	    ResourceHandle handle = BaseExperimentBuilder.buildHandleFromMap(DescMap);
	    Class<? extends JCasAnnotator_ImplBase> 
	    	aClass = BaseExperimentBuilder.loadFromClassOrInherit(handle,
	            															JCasAnnotator_ImplBase.class, tuples);
	    Object[] params = BaseExperimentBuilder.getParamList(tuples);	    
	    AnalysisEngineDescription aeDesc = AnalysisEngineFactory.createPrimitiveDescription(aClass, params);
	    return UIMAFramework.produceAnalysisEngine(aeDesc);
  	} catch (Exception e) {
  		Throwables.getRootCause(e).printStackTrace();
  		throw new ResourceInitializationException(e);
	  }
  }
}
