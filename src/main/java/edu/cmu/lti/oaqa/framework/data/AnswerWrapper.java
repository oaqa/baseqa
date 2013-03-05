package edu.cmu.lti.oaqa.framework.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.DoubleArray;
import org.apache.uima.jcas.cas.StringArray;
import org.oaqa.model.Document;
import org.oaqa.model.SearchResult;
import org.oaqa.model.Answer;

import edu.cmu.lti.oaqa.framework.data.base.BaseAnnotationWrapper;

/*
 * A wrapper class for the class Answer.
 * 
 *  @author Leonid Boytsov
 *  @author Kevin Dela Rosa
 *  
 */

public class AnswerWrapper extends BaseAnnotationWrapper<Answer> implements Serializable {

  private static final long serialVersionUID = 1L;

	private String 									text = "";
	private List<Double> 						featureList;
	private String[] 								featureLabels;
	private double 									score = 0.0;
	private int 										rank = -1;
	private List<RetrievalResult> 	retrievalResultList;


	/**
	 * Default Constructor
	 */	
  public AnswerWrapper() {
    super();
    
		this.featureList = new ArrayList<Double>(0);
		this.retrievalResultList = new ArrayList<RetrievalResult>(0);    
  }
  
	/**
	 * Constructor
	 * 
	 * @param answer
	 *            answer model object
	 */

  public AnswerWrapper(Answer answer) throws Exception {
    super();

		this.featureList = new ArrayList<Double>();
		this.text  = answer.getText();
		this.score = answer.getScore();
		this.rank  = answer.getRank();
		if (answer.getFeatureVector() != null) {
			for (int j = 0; j < answer.getFeatureVector().size(); j++) {
				this.addFeature(answer.getFeatureVector(j));
			}
		}
		this.retrievalResultList = new ArrayList<RetrievalResult>();
		if (answer.getSearchResultList() != null) {
			for (int j = 0; j < answer.getSearchResultList().size(); j++) {
				SearchResult OneRes = answer.getSearchResultList(j);
				if (OneRes instanceof Document) {
					this.addRetrievalResult(new RetrievalResult((Document)OneRes));
				} else {
				// TODO: Leonid Boytsov thinks this has to be somehow 
			  //       enforced at the level of the type system.
			  //
					throw new Exception("Internal error: retrieval results" + 
								" should store a list where elements have the type Document!");
				}
			}
		}
  }
  
	/**
	 * Constructor
	 * 
	 * @param text
	 *            text value of answer
	 * @param results
	 *            list of documents that contain answer
	 */
	public AnswerWrapper(String text, List<RetrievalResult> results) {
		this.text = text;
		this.featureList = new ArrayList<Double>();
		this.retrievalResultList = new ArrayList<RetrievalResult>();
		for (RetrievalResult result : results) {
			this.addRetrievalResult(result);
		}
	}


	/**
	 * Constructor
	 * 
	 * @param text
	 *            text value of answer
	 * @param results
	 *            list of documents that contain answer
	 * @param featureLabels
	 *            labels of features stored in object
	 */
	public AnswerWrapper(String text, List<RetrievalResult> results,
											String[] featureLabels) {
		this.text = text;
		this.retrievalResultList = new ArrayList<RetrievalResult>();
		for (RetrievalResult result : results) {
			this.addRetrievalResult(result);
		}
		this.featureLabels = featureLabels;
		this.featureList = new ArrayList<Double>();
	}

  
	/**
	 * Sets list of documents
	 * 
	 * @param results
	 *            list of documents/results that contain answer
	 */
	public void setRetrievalResultList(List<RetrievalResult> results) {
		this.retrievalResultList = new ArrayList<RetrievalResult>();
		for (RetrievalResult result : results) {
			this.addRetrievalResult(result);
		}
	}

	/**
	 * Get list of documents
	 * 
	 * @return list of documents/results that contain answer
	 */
	public List<RetrievalResult> getRetrievalResults() {
		return this.retrievalResultList;
	}

	/**
	 * Add retrieval result to document/result list
	 * 
	 * @param result
	 *            document/result that contains answer
	 */
	public void addRetrievalResult(RetrievalResult result) {
		this.retrievalResultList.add(result);
	}

	/**
	 * Set score
	 * 
	 * @param score
	 *            score for answer
	 */
	public void setScore(double score) {
		this.score = score;
	}

	/**
	 * Get score
	 * 
	 * @return score for answer
	 */
	public double getScore() {
		return this.score;
	}
	

  public int getRank() {
    return rank;
  }

  public void setRank(int rank) {
    this.rank = rank;
  }

	

	/**
	 * Set feature values
	 * 
	 * @param features
	 *            list of feature values
	 */
	public void setFeatures(List<Double> features) {
		for (double feature : features) {
			this.addFeature(feature);
		}
	}

	/**
	 * Set feature values
	 * 
	 * @param features
	 *            array of feature values
	 */
	public void setFeatures(double[] features) {
		for (double feature : features) {
			this.addFeature(feature);
		}
	}

	/**
	 * Get feature values
	 * 
	 * @return array of feature values
	 */
	public double[] getFeatures() {
		if (featureList != null) {
			double[] features = new double[featureList.size()];
			for (int i = 0; i < features.length; i++) {
				features[i] = featureList.get(i);
			}
			return features;
		}
		return null;
	}

	/**
	 * Add feature value
	 * 
	 * @param feature
	 */
	public void addFeature(double feature) {
		this.featureList.add(feature);
	}

	/**
	 * Get feature value
	 * 
	 * @param index
	 *            index of feature
	 * @return feature value
	 */
	public double getFeature(int index) {
		return this.featureList.get(index);
	}

	/**
	 * Set answer text
	 * 
	 * @param text
	 *            answer text value
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Get answer text
	 * 
	 * @return answer text value
	 */
	public String getText() {
		return this.text;
	}

	/**
	 * Get feature labels
	 * 
	 * @return array of feature labels
	 */
	public String[] getFeatureLabels() {
		return this.featureLabels;
	}

	/**
	 * Set feature labels
	 * 
	 * @param featureLabels
	 *            array of feature labels
	 */
	public void setFeatureLables(String[] featureLabels) {
		this.featureLabels = featureLabels;
	}
	

  @Override
  public int hashCode() {
	  final int prime = 31;
	  int result = 1;
	  result = prime * result + Arrays.hashCode(featureLabels);
	  result = prime * result
	      + ((featureList == null) ? 0 : featureList.hashCode());
	  result = prime * result
	      + ((retrievalResultList == null) ? 0 : retrievalResultList.hashCode());
	  long temp;
	  temp = Double.doubleToLongBits(score);
	  result = prime * result + (int) (temp ^ (temp >>> 32));
	  result = prime * result + ((text == null) ? 0 : text.hashCode());
	  return result;
  }

	@Override
  public String toString() {
	  return "AnswerWrapper [text=" + text + ", featureList=" + featureList
	      + ", featureLabels=" + Arrays.toString(featureLabels) + ", score="
	      + score + ", retrievalResultList=" + retrievalResultList + "]";
  }

	@Override
  public boolean equals(Object obj) {
	  if (this == obj)
		  return true;
	  if (obj == null)
		  return false;
	  if (getClass() != obj.getClass())
		  return false;
	  AnswerWrapper other = (AnswerWrapper) obj;
	  if (!Arrays.equals(featureLabels, other.featureLabels))
		  return false;
	  if (featureList == null) {
		  if (other.featureList != null)
			  return false;
	  } else if (!featureList.equals(other.featureList))
		  return false;
	  if (retrievalResultList == null) {
		  if (other.retrievalResultList != null)
			  return false;
	  } else if (!retrievalResultList.equals(other.retrievalResultList))
		  return false;
	  if (Double.doubleToLongBits(score) != Double.doubleToLongBits(other.score))
		  return false;
	  if (text == null) {
		  if (other.text != null)
			  return false;
	  } else if (!text.equals(other.text))
		  return false;
	  return true;
  }

	@Override
  public void wrap(Answer answer) {
    super.wrap(answer);
    
  	text						= answer.getText();
  	score		        = answer.getScore();
  	rank						= answer.getRank();
  	
  	setFeatures(answer.getFeatureVector().toArray());
  	setFeatureLables(answer.getFeatureLabels().toArray());

  	int fls = answer.getSearchResultList().size();
  	  	
  	ArrayList<SearchResult>	sres = new ArrayList<SearchResult>();
  	
  	for(int i = 0; i < fls; ++i) {
  		sres.add(answer.getSearchResultList(i));
  	}

  }

  @Override
  public Answer unwrap(JCas jcas) throws Exception {
    Answer answer = super.unwrap(jcas);
    
    answer.setText(text);
    answer.setScore(score);
    answer.setRank(rank);
    
    if (featureList != null) {
	    double[]		tmpFeatureList = new double[featureList.size()];
	    int i = 0;
	    for (double d: featureList) {
	    	tmpFeatureList[i++] = d;
	    }
	    DoubleArray tmpDoubleArray = new DoubleArray(jcas, tmpFeatureList.length);    
	    tmpDoubleArray.copyFromArray(tmpFeatureList, 0, 0, tmpFeatureList.length);
	    
	    answer.setFeatureVector(tmpDoubleArray);
    }
    
    if (featureLabels != null) {
    	StringArray tmpLabelsArray = new StringArray(jcas, featureLabels.length);
    	tmpLabelsArray.copyFromArray(featureLabels, 0, 0, featureLabels.length);
    	
    	answer.setFeatureLabels(tmpLabelsArray);
    }

    
    return answer;
  }

  @Override
  public Class<? extends Answer> getTypeClass() {
    return Answer.class;
  }

}
