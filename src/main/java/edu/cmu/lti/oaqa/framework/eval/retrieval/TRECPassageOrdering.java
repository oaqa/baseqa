package edu.cmu.lti.oaqa.framework.eval.retrieval;

import org.oaqa.model.Passage;

import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

public final class TRECPassageOrdering extends Ordering<Passage> {
  public int compare(Passage left, Passage right) {
    int rankDiff = Ints.compare(left.getRank(),right.getRank());
    if (rankDiff != 0) {
      return rankDiff;
    }
    int pmidDiff = left.getUri().compareTo(right.getUri());
    if (pmidDiff != 0) {
      return pmidDiff;
    }
    int offsetDiff = Ints.compare(left.getBegin(), right.getBegin());
    if (offsetDiff != 0) {
      return offsetDiff;
    }
    return Ints.compare(left.getEnd() - left.getBegin(), 
            right.getEnd() - right.getBegin());
  }
}