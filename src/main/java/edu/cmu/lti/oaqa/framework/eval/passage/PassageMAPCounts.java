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

package edu.cmu.lti.oaqa.framework.eval.passage;

public final class PassageMAPCounts {

  private float docavep;

  private float psgavep;
	
  private float aspavep;
	
  private int count;
	
	PassageMAPCounts() {
		this(0, 0, 0, 0);
	}

	public PassageMAPCounts(float avep, float psgavep, float aspavep, int num) {
		this.docavep = avep;
		this.psgavep = psgavep;
		this.aspavep = aspavep;
		this.count = num;
	}

	void update(PassageMAPCounts other) {
		docavep += other.docavep;
		psgavep += other.psgavep;
		aspavep += other.aspavep;
		count += other.count;
	}

  public float getDocavep() {
    return docavep;
  }

  public float getPsgavep() {
    return psgavep;
  }

  public float getAspavep() {
    return aspavep;
  }

  public int getCount() {
    return count;
  }
}
