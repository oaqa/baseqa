package edu.cmu.lti.oaqa.baseqa.collection.json;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import com.google.common.io.Files;

import edu.cmu.lti.oaqa.baseqa.collection.json.gson.TestQuestion;
import edu.cmu.lti.oaqa.baseqa.collection.json.gson.TestSet;
import edu.cmu.lti.oaqa.baseqa.util.UimaContextHelper;
import edu.cmu.lti.oaqa.ecd.phase.ProcessingStepUtils;

public class JsonCasConsumer extends JCasAnnotator_ImplBase {

  private int documentLimit;

  private int snippetLimit;

  private int conceptLimit;

  private int tripleLimit;

  private int factoidAnswerLimit;

  private int listAnswerLimit;

  private File resultDir;

  private List<TestQuestion> questions;

  private String traceHash;

  @Override
  public void initialize(UimaContext context) throws ResourceInitializationException {
    super.initialize(context);
    documentLimit = UimaContextHelper.getConfigParameterIntValue(context, "document-limit",
            Integer.MAX_VALUE);
    snippetLimit = UimaContextHelper.getConfigParameterIntValue(context, "snippet-limit",
            Integer.MAX_VALUE);
    conceptLimit = UimaContextHelper.getConfigParameterIntValue(context, "concept-limit",
            Integer.MAX_VALUE);
    tripleLimit = UimaContextHelper.getConfigParameterIntValue(context, "triple-limit",
            Integer.MAX_VALUE);
    factoidAnswerLimit = UimaContextHelper.getConfigParameterIntValue(context,
            "factoid-answer-limit", Integer.MAX_VALUE);
    listAnswerLimit = UimaContextHelper.getConfigParameterIntValue(context, "list-answer-limit",
            Integer.MAX_VALUE);
    resultDir = new File(UimaContextHelper.getConfigParameterStringValue(context, "result-dir"));
    if (!resultDir.exists()) {
      resultDir.mkdirs();
    }
    questions = new ArrayList<>();
  }

  @Override
  public void process(JCas jcas) throws AnalysisEngineProcessException {
    questions.add(JsonCasConsumerHelper.getQuestionFromIndex(jcas, documentLimit, snippetLimit,
            conceptLimit, tripleLimit, factoidAnswerLimit, listAnswerLimit));
    traceHash = ProcessingStepUtils.getTrace(jcas).getTraceHash();
  }

  @Override
  public void collectionProcessComplete() throws AnalysisEngineProcessException {
    super.collectionProcessComplete();
    String json = TestSet.dump(questions);
    File resultFile = new File(resultDir, traceHash);
    try {
      Files.write(json, resultFile, StandardCharsets.UTF_8);
    } catch (IOException e) {
      throw new AnalysisEngineProcessException(e);
    }
  }
}
