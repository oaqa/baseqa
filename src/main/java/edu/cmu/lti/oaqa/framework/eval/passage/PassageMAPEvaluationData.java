package edu.cmu.lti.oaqa.framework.eval.passage;

final class PassageMAPEvaluationData {

  final float docMap;

  final float psgMap;

  final float aspMap;

  final float count;

  PassageMAPEvaluationData(float docMAP, float psgMAP, float aspMAP, int count) {
    this.docMap = docMAP;
    this.psgMap = psgMAP;
    this.aspMap = aspMAP;
    this.count = count;
  }
}