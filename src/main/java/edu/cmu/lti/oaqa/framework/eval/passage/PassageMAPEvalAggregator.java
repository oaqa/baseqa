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

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CASException;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceSpecifier;
import org.apache.uima.resource.Resource_ImplBase;
import org.oaqa.model.Passage;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;

import edu.cmu.lti.oaqa.ecd.BaseExperimentBuilder;
import edu.cmu.lti.oaqa.framework.eval.Key;
import edu.cmu.lti.oaqa.framework.eval.retrieval.EvaluationAggregator;
import edu.cmu.lti.oaqa.framework.eval.retrieval.EvaluationHelper;

public class PassageMAPEvalAggregator extends Resource_ImplBase implements EvaluationAggregator<Passage> {

  private PassageMAPEvalPersistenceProvider persistence;

  @Override
  public boolean initialize(ResourceSpecifier aSpecifier, Map<String, Object> tuples)
          throws ResourceInitializationException {
    String pp = (String) tuples.get("persistence-provider");
    if (pp == null) {
      throw new ResourceInitializationException(new IllegalArgumentException(
              "Must provide a parameter of type <persistence-provider>"));
    }
    this.persistence = BaseExperimentBuilder.loadProvider(pp,
            PassageMAPEvalPersistenceProvider.class);
    return true;
  }
  
  @Override
  public void update(Key key, String sequenceId, List<Passage> docs, List<Passage> gs, Ordering<Passage> ordering, Function<Passage, String> toIdString) throws AnalysisEngineProcessException {
    PassageMAPCounts cnt = count(docs, gs, ordering, toIdString);
    try {
      persistence.deletePassageAggrEval(key, sequenceId);
      persistence.insertPartialCounts(key, sequenceId, cnt);
    } catch (SQLException e) {
      throw new AnalysisEngineProcessException(e);
    }
  }

  private PassageMAPCounts count(List<Passage> docs, List<Passage> gs, Ordering<Passage> ordering, Function<Passage, String> toIdString) {
    Set<String> gsSet = EvaluationHelper.getStringSet(gs, toIdString);
    List<Passage> legalDocs = checkLegalSpan(docs);
    List<String> docsArray = EvaluationHelper.getUniqeDocIdList(legalDocs, ordering, toIdString);
    float docavep = EvaluationHelper.getAvgMAP(docsArray, gsSet);
    float psgavep = getAvgPsgMAP(legalDocs, gs);
    float aspavep = getAvgAspMAP(legalDocs, gs);
    return new PassageMAPCounts(docavep, psgavep, aspavep, 1);
  }

  private List<Passage> checkLegalSpan(List<Passage> docs) {
    List<Passage> legalDocs = new ArrayList<Passage>();
    for (Passage doc : docs) {
      try {
        legalDocs.add(isSpanLegal(doc) ? doc : new Passage(doc.getCAS().getJCas()));
      } catch (CASException e) {
        e.printStackTrace();
      }
    }
    return legalDocs;
  }

  private boolean isSpanLegal(Passage doc) {
    // TODO: Legal span check
    return true;
  }

  float getAvgPsgMAP(List<Passage> docs, List<Passage> gs) {
    if (gs.size() == 0) {
      return 0;
    }
    float avep = 0;
    int totalchars = 0;
    int overlaplength = 0;
    float ccpsum = 0;
    int count = 0;
    HashSet<Passage> foundGoldTriplets = new HashSet<Passage>();
    for (int i = 0; i < docs.size(); ++i) {
      totalchars = totalchars + docs.get(i).getEnd() - docs.get(i).getBegin();

      String docid = docs.get(i).getUri();
      int releFlag = 0;
      if (docid == null)
        System.out.println("docID == null: " + docs.get(i).getUri());
      Passage temppsg = null;
      for (int j = 0; j < gs.size(); ++j) {
        if (!gs.get(j).getUri().equals(docid))
          continue;

        if ((docs.get(i).getBegin() >= gs.get(j).getBegin())
                && (docs.get(i).getEnd() <= gs.get(j).getEnd())) {
          overlaplength = overlaplength + docs.get(i).getEnd() - docs.get(i).getBegin();
          releFlag = 1;
          temppsg = gs.get(j);
          break;
        } else if ((docs.get(i).getBegin() < gs.get(j).getBegin())
                && (docs.get(i).getEnd() <= gs.get(j).getEnd())
                && (docs.get(i).getEnd() >= gs.get(j).getBegin())) {
          overlaplength = overlaplength + docs.get(i).getEnd() - gs.get(j).getBegin();
          releFlag = 1;
          temppsg = gs.get(j);
          break;
        } else if ((docs.get(i).getBegin() >= gs.get(j).getBegin())
                && (docs.get(i).getBegin() <= gs.get(j).getEnd())
                && (docs.get(i).getEnd() > gs.get(j).getEnd())) {
          overlaplength = overlaplength + gs.get(j).getEnd() - docs.get(i).getBegin();
          releFlag = 1;
          temppsg = gs.get(j);
          break;
        } else if ((docs.get(i).getBegin() < gs.get(j).getBegin())
                && (docs.get(i).getEnd() > gs.get(j).getEnd())) {
          overlaplength = overlaplength + gs.get(j).getEnd() - gs.get(j).getBegin();
          releFlag = 1;
          temppsg = gs.get(j);
          break;
        }
      }
      if (releFlag == 1) {
        ccpsum += (float) overlaplength / (float) totalchars;
        count++;
        foundGoldTriplets.add(temppsg);
      }
    }
    // int numZeros = gs.size() - foundGoldTriplets.size();
    int numZeros = 0;
    for (int i = 0; i < gs.size(); ++i)
      if (!foundGoldTriplets.contains(gs.get(i)))
        numZeros++;

    avep = (float) ccpsum / (float) (count + numZeros);
    return avep;
  }

  private float getAvgAspMAP(List<Passage> docs, List<Passage> gs) {
    if (gs.size() == 0) {
      return 0;
    }
    float avep = 0;
    HashSet<String> aspectsFound = new HashSet<String>();
    HashSet<String> uniqueAspectsByTopic = new HashSet<String>();
    for (int j = 0; j < gs.size(); ++j) {
      String[] temp = gs.get(j).getAspects().split("\\|");
      for (int k = 0; k < temp.length; ++k)
        if (!uniqueAspectsByTopic.contains(temp[k]))
          uniqueAspectsByTopic.add(temp[k]);
    }
    int numerator = 0;
    int denominator = 0;
    float sumPrecision = 0;

    for (int i = 0; i < docs.size(); ++i) {
      String Aspect = "";
      int releFlag = 0;
      String docid = docs.get(i).getUri();
      for (int j = 0; j < gs.size(); ++j) {
        if (!gs.get(j).getUri().equals(docid))
          continue;
        if ((docs.get(i).getBegin() >= gs.get(j).getBegin())
                && (docs.get(i).getEnd() <= gs.get(j).getEnd())) {
          releFlag = 1;
          Aspect = gs.get(j).getAspects();
          break;
        } else if ((docs.get(i).getBegin() < gs.get(j).getBegin())
                && (docs.get(i).getEnd() <= gs.get(j).getEnd())
                && (docs.get(i).getEnd() >= gs.get(j).getBegin())) {
          releFlag = 1;
          Aspect = gs.get(j).getAspects();
          break;
        } else if ((docs.get(i).getBegin() >= gs.get(j).getBegin())
                && (docs.get(i).getBegin() <= gs.get(j).getEnd())
                && (docs.get(i).getEnd() > gs.get(j).getEnd())) {
          releFlag = 1;
          Aspect = gs.get(j).getAspects();
          break;
        } else if ((docs.get(i).getBegin() < gs.get(j).getBegin())
                && (docs.get(i).getEnd() > gs.get(j).getEnd())) {
          releFlag = 1;
          Aspect = gs.get(j).getAspects();
          break;
        }
      }
      if (releFlag == 1) {
        ArrayList<String> DocsaspectList = new ArrayList<String>();
        String[] split = Aspect.split("\\|");
        for (int j = 0; j < split.length; ++j) {
          if (!DocsaspectList.contains(split[j])) {
            DocsaspectList.add(split[j]);
          }
        }
        int numNewAspects = 0;
        for (int j = 0; j < DocsaspectList.size(); ++j) {
          if (!aspectsFound.contains(DocsaspectList.get(j)))
            numNewAspects++;
        }
        if (numNewAspects > 0) {
          numerator++;
          denominator++;
          sumPrecision += numNewAspects * (float) numerator / (float) denominator;
        }

        for (int j = 0; j < split.length; ++j) {
          if (!aspectsFound.contains(split[j]))
            aspectsFound.add(split[j]);
        }
      }
      if (releFlag == 0)
        denominator++;
    }
    avep = (float) sumPrecision / (float) uniqueAspectsByTopic.size();
    return avep;
  }
}
