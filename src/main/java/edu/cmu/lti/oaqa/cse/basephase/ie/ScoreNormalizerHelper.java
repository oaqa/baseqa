/**
 * 
 */
package edu.cmu.lti.oaqa.cse.basephase.ie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.uima.resource.ResourceInitializationException;
import edu.cmu.lti.oaqa.framework.data.ScoreInterface;

/**
 * @author sushant3d
 * 
 */
public class ScoreNormalizerHelper<T extends ScoreInterface> {

  /**
   * Normalizes the scores from generic objects which implement ScoreInterface like RetrievalResult,
   * PassageCandidate, AnswerWrapper etc
   * 
   * @param elements
   * @return normalized elements
   */
  public List<T> normalizeScore(List<T> elements) {
    List<Double> scores = new ArrayList<Double>();
    for (T element : elements) {
      scores.add(element.getScore());
    }
    Map<Double, Double> scoreMap = transform(scores);
    // update the scores
    for (T element : elements) {
      double score = element.getScore();
      element.setScore(scoreMap.get(score));
    }
    return elements;
  }

  public enum TransformMode {
    no_transform, exponential, logarithmic, reciprocal_of_rank, 
    normalized, normalized_of_exponential, exponential_of_normalized, 
    logarithmic_of_normalized, normalized_of_logarithmic,z_Score //Added z-score part
  }

  public TransformMode getTransformModeValue(String mode) {
    return TransformMode.valueOf(mode);
  }

  /**
   * Creates a map of original score to the normalized score based on different normalization modes
   * 
   * @param scores
   * @return map of original to normalized scores
   */
  public Map<Double, Double> transform(List<Double> scores) {
    Map<Double, Double> ret = new HashMap<Double, Double>();

    if (scores.isEmpty()) {
      return ret;
    }

    double maxScore = Collections.max(scores);
    double minScore = Collections.min(scores);
    // If ALL scores are the same, we don't want to divide by zero
    double Divisor = Math.max(maxScore - minScore, 1);
    switch (mode) {
      case exponential:
        for (double score : scores) {
          if (!ret.containsKey(score)) {
            ret.put(score, (double) Math.exp(score));
          }
        }
        break;
      case logarithmic:
        for (double score : scores) {
          if (!ret.containsKey(score)) {
            ret.put(score, (double) safeLog(score));
          }
        }
        break;
      case normalized:
        for (double score : scores) {
          if (!ret.containsKey(score)) {
            ret.put(score, (double) (score - minScore) / Divisor);
          }
        }
        break;
      case exponential_of_normalized:
        for (double score : scores) {
          if (!ret.containsKey(score)) {
            ret.put(score, (double) Math.exp((score - minScore) / Divisor));
          }
        }
        break;
      case normalized_of_exponential:
        for (double score : scores) {
          if (!ret.containsKey(score)) {
            ret.put(score, (double) Math.exp(score));
          }
        }
        double maxExpScore = Collections.max(ret.values());
        double minExpScore = Collections.min(ret.values());
        
        Divisor = Math.max(maxExpScore - minExpScore, 1);
        
        for (double score : ret.keySet()) {
          ret.put(score, (double) (ret.get(score) - minExpScore) / Divisor);
        }
        break;
      case logarithmic_of_normalized:
        for (double score : scores) {
          if (!ret.containsKey(score)) {
            ret.put(score, (double) safeLog((score - minScore) / (maxScore - minScore)));
          }
        }
        break;
      case normalized_of_logarithmic:
        for (double score : scores) {
          if (!ret.containsKey(score)) {
            ret.put(score, (double) safeLog(score));
          }
        }
        double maxLogScore = Collections.max(ret.values());
        double minLogScore = Collections.min(ret.values());
        
        Divisor = Math.max(maxLogScore - minLogScore, 1);
        
        for (double score : ret.keySet()) {
          ret.put(score, (double) (ret.get(score) - minLogScore) / Divisor);
        }
        break;
      case reciprocal_of_rank:
        int i = 1;
        for (double score : scores) {
          if (!ret.containsKey(score)) {
            ret.put(score, (double) 1.0 / i);
          }
          i++;
        }
        break;
      case no_transform:
      default:
        for (double score : scores) {
          ret.put(score, score);
        }
        break;
        
      case z_Score:
    	  //First compute the mean
    	  double mean=0.0;
    	  double sum_Scores=0.0;
    	  int n=scores.size();
    	  for (double score : scores) {
    		  sum_Scores = sum_Scores + score;
            }
    	  mean = sum_Scores / n;
    			  
    	  //Next compute the standard deviation
    	  //Standard formula z-score = sqrt(1/N (i=0 to N)(score_i - mean)^2)
    	  double std_Dev=0.0;
    	  for (double score : scores) 
    	  {
    		  std_Dev = std_Dev + Math.pow((score -mean), 2);
    	  }
    	  std_Dev = Math.sqrt(std_Dev/n);
    	  
    	  for (double score : scores) {
              ret.put(score, zScore(score,mean,std_Dev));
            }
            break; 
    }
    return ret;
  }

  private static double safeLog(double value) {
    return value > 0 ? Math.log(value) : Double.NEGATIVE_INFINITY;
  }
  
  public static double zScore(double score, double mean,double std_dev)
  {
	  if (score==0.0)
			  return 0.0;
	  else
		  return (score-mean)/std_dev;
  }
  
  
  public void initialize(String sourceId, TransformMode Mode, double DocWeight)
          throws ResourceInitializationException {
    this.SourceId = sourceId;
    this.mode = Mode;
    this.docWeight = DocWeight;
  }

  private double docWeight;

  private TransformMode mode;

  private String SourceId;

  public String getSourceId() {
    return SourceId;
  }

  public void setSourceId(String sourceId) {
    SourceId = sourceId;
  }

  public double getDocWeight() {
    return docWeight;
  }

  public void setDocWeight(double docWeight) {
    this.docWeight = docWeight;
  }

  public TransformMode getMode() {
    return mode;
  }

  public void setMode(TransformMode mode) {
    this.mode = mode;
  }
}
