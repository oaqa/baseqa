/*
 *  Copyright 2012 Carnegie Mellon University
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

package edu.cmu.lti.oaqa.openqa.rankqa.collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.uima.collection.CollectionException;
import org.apache.uima.resource.ResourceInitializationException;

import edu.cmu.lti.oaqa.ecd.collection.KnownSizeCollectionReader;
import edu.cmu.lti.oaqa.framework.DataElement;
import edu.cmu.lti.oaqa.framework.collection.AbstractCollectionReader;

public final class KnownSizeFileCollectionReader extends AbstractCollectionReader implements KnownSizeCollectionReader{

  ArrayList<DataElement> dataList;
  int index;
  
  @Override
  public void initialize() throws ResourceInitializationException {
    super.initialize();
    
    dataList = new ArrayList<DataElement>();
    index = 0;
    
    String resource = (String) getConfigParameterValue("file");
    if (resource != null) {
      System.err.printf("Reading file: %s from the classpath\n", resource);
      InputStream in = getClass().getResourceAsStream(resource);
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      String line;
      try {
        while ((line = br.readLine()) != null) {
          String[] data = line.split("\\|");
          dataList.add(new DataElement(getDataset(), data[0], data[1], null));
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      throw new IllegalArgumentException(String.format("Parameter 'file' must be specified"));
    }
  }
  
  @Override
  public boolean hasNext() throws IOException, CollectionException {
    return dataList.size() > 0 && dataList.size() > index ;
  }

  @Override
  public int size() {
    return dataList.size();
  }

  @Override
  protected DataElement getNextElement() throws Exception {
    return dataList.get(index++);
  }
  
}
