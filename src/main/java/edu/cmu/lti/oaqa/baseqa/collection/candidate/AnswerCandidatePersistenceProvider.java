package edu.cmu.lti.oaqa.baseqa.collection.candidate;

import java.util.List;

import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.Resource;

import edu.cmu.lti.oaqa.type.answer.Answer;

public interface AnswerCandidatePersistenceProvider extends Resource {

  List<Answer> getAnswerCandidates(String questionId, JCas candidateView);

}
