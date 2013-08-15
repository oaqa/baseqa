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

package edu.cmu.lti.oaqa.framework.data;

import java.util.List;

public class TextSpan implements Comparable<TextSpan> {

  public int begin;

  public int end;

  public TextSpan(int begin, int end) {
    this.begin = begin;
    this.end = end;
  }

  @Override
  public int compareTo(TextSpan span) {
    if (begin != span.begin) {
      return begin < span.begin ? -1 : 1;
    }
    if (end != span.end) {
      return end > span.end ? -1 : 1;
    }
    return 0;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + begin;
    result = prime * result + end;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    TextSpan other = (TextSpan) obj;
    if (begin != other.begin)
      return false;
    if (end != other.end)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "(" + begin + ", " + end + ")";
  }

  public int getLength() {
    return end - begin;
  }

  public static int getOverlapLength(TextSpan s1, TextSpan s2) {
    return Math.max(0, Math.min(s1.end, s2.end) - Math.max(s1.begin, s2.begin));
  }

  public static TextSpan getOverlapTextSpan(TextSpan s1, TextSpan s2) {
    return new TextSpan(Math.max(s1.begin, s2.begin), Math.min(s1.end, s2.end));
  }

  public static TextSpan getBoundingTextSpan(TextSpan s1, TextSpan s2) {
    return new TextSpan(Math.min(s1.begin, s2.begin), Math.max(s1.end, s2.end));
  }

  public static TextSpan getBoundingTextSpan(List<TextSpan> spans) {
    TextSpan newSpan = spans.get(0);
    for (TextSpan span : spans) {
      newSpan = getBoundingTextSpan(newSpan, span);
    }
    return newSpan;
  }
}