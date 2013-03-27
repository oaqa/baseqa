package edu.cmu.lti.oaqa.framework.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
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

public class AnswerWrapper extends BaseAnnotationWrapper<Answer> implements Serializable, ScoreInterface {

  private static final long serialVersionUID = 1L;

	private String 									text = "";
	private List<Double> 						featureValues;
	private List<String> 						featureLabels;
	private int 										rank = -1;
	private List<RetrievalResult> 	retrievalResultList;


	/**
	 * Default Constructor
	 */	
  public AnswerWrapper() {
    super();
    
		this.featureValues       = new ArrayList<Double>();
		this.featureLabels       = new ArrayList<String>();
		this.retrievalResultList = new ArrayList<RetrievalResult>();    
  }
  
	/**
	 * Constructor
	 * 
	 * @param answer
	 *            answer model object
	 */

  public AnswerWrapper(Answer answer) throws Exception {
    super();

    this.featureValues       = new ArrayList<Double>();
    this.featureLabels       = new ArrayList<String>();
    this.retrievalResultList = new ArrayList<RetrievalResult>();    		
		
		this.text  = answer.getText();
		this.score = answer.getScore();
		this.rank  = answer.getRank();
		
		if (answer.getFeatureVector() != null &&
		    answer.getFeatureLabels() != null) {
		  
		  if (answer.getFeatureLabels().size() !=
		      answer.getFeatureVector().size()) {

		      throw new Exception("Internal error, sizes are differrent. " +
		                      " The size of feature values: " + answer.getFeatureLabels().size() +
		                      " The size of feature labels: " + featureLabels.size());  		    
		  }
		  
			for (int j = 0; j < answer.getFeatureVector().size(); j++) {
				this.addFeature(answer.getFeatureVector(j), answer.getFeatureLabels(j));
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
		
    this.featureLabels = new ArrayList<String>();
    this.featureValues = new ArrayList<Double>();
    
		this.retrievalResultList = new ArrayList<RetrievalResult>();
		for (RetrievalResult result : results) {
			this.addRetrievalResult(result);
		}
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

	
  public int getFeatureQty() {
    return featureValues.size();
  }

	/**
	 * Set feature values & labels
	 * 
	 * @param featureValues
	 *            list of feature values
   * @param featureLabels
   *            list of feature labels            
	 * 
	 */
	public void setFeatures(List<Double> featureValues, List<String> featureLabels) 
	            throws Exception{
	  if (featureValues.size() != featureLabels.size()) {
	    throw new Exception("Internal error, sizes are differrent. " +
	                    " The size of feature values: " + featureValues.size() +
	                    " The size of feature labels: " + featureLabels.size());  
	  }
	  Iterator<String> itLabel = featureLabels.iterator();
	  Iterator<Double> itValue = featureValues.iterator();
	  
		while (itLabel.hasNext() && itValue.hasNext()) {
			addFeature(itValue.next(), itLabel.next());
		}
	}

	/**
	 * Set feature values
	 * 
	 * @param features
	 *            array of feature values
	 */
	public void setFeatures(double[] featureValues, String[] featureLabels) 
	            throws Exception {
    if (featureValues.length != featureLabels.length) {
      throw new Exception("Internal error, sizes are differrent. " +
                      " The size of feature values: " + featureValues.length +
                      " The size of feature labels: " + featureLabels.length);  
    }
	  
		for (int i = 0; i < featureValues.length; ++i) {
			this.addFeature(featureValues[i], featureLabels[i]);
		}
	}


	/**
	 * Add feature value
	 * 
	 * @param feature
	 */
	public void addFeature(double feature, String label) {
		this.featureValues.add(feature);
		this.featureLabels.add(label);
	}

	/**
	 * Get feature value
	 * 
	 * @param index
	 *            index of feature
	 * @return feature value
	 */
	public double getFeatureValue(int index) {
		return this.featureValues.get(index);
	}
	

  /**
   * Set feature label
   * 
   * @param index
   *            index of feature
   * @param value
   *            feature label
   */
  public void setFeatureLabel(int index, String value) {
    this.featureLabels.set(index, value);
  }
  

  /**
   * Set feature value
   * 
   * @param index
   *            index of feature
   * @param value
   *            feature value          
   */
  public void setFeatureValue(int index, double value) {
    this.featureValues.set(index, value);
  }
  

  /**
   * Get feature label
   * 
   * @param index
   *            index of feature
   * @return feature label

   */
  public String getFeatureLabel(int index) {
    return this.featureLabels.get(index);
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



	@Override
  public String toString() {
	  return "AnswerWrapper [text=" + text + ", featureList=" + featureValues
	      + ", featureLabels=" + featureLabels + ", score="
	      + score + ", retrievalResultList=" + retrievalResultList + "]";
  }
	
	@Override
  public void wrap(Answer answer) throws Exception {
    super.wrap(answer);
    
  	text						= answer.getText();
  	score		        = answer.getScore();
  	rank						= answer.getRank();
  	

	  setFeatures(answer.getFeatureVector().toArray(), 
	              answer.getFeatureLabels().toArray());
  	

    if (answer.getSearchResultList() != null) {
	  	int fls = answer.getSearchResultList().size();
	  	  	
	  	ArrayList<SearchResult>	sres = new ArrayList<SearchResult>();
	  	
	  	for(int i = 0; i < fls; ++i) {
	  		sres.add(answer.getSearchResultList(i));
	  	}
    }

  }

  @Override
  public Answer unwrap(JCas jcas) throws Exception {
    Answer answer = super.unwrap(jcas);
    
    answer.setText(text);
    answer.setScore(score);
    answer.setRank(rank);
    

    double[]		tmpFeatureValues = new double[featureValues.size()];

    int i = 0;
    for (double d: featureValues) {
    	tmpFeatureValues[i++] = d;
    }

    DoubleArray tmpValueArray = new DoubleArray(jcas, tmpFeatureValues.length);    
    tmpValueArray.copyFromArray(tmpFeatureValues, 0, 0, tmpFeatureValues.length);
    
    answer.setFeatureVector(tmpValueArray);
    
    String[]  tmpFeatureLabels = new String[featureLabels.size()];
    int j = 0;
    for (String s: featureLabels) {
      tmpFeatureLabels[j++] = s;
    }
    StringArray tmpLabelArray = new StringArray(jcas, tmpFeatureLabels.length);
    tmpLabelArray.copyFromArray(tmpFeatureLabels, 0, 0, tmpFeatureLabels.length);
   
    	
    answer.setFeatureLabels(tmpLabelArray);
    
    return answer;
  }

  @Override
  public Class<? extends Answer> getTypeClass() {
    return Answer.class;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result
        + ((featureLabels == null) ? 0 : featureLabels.hashCode());
    result = prime * result
        + ((featureValues == null) ? 0 : featureValues.hashCode());
    result = prime * result + rank;
    result = prime * result
        + ((retrievalResultList == null) ? 0 : retrievalResultList.hashCode());
    long temp;
    temp = Double.doubleToLongBits(score);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    result = prime * result + ((text == null) ? 0 : text.hashCode());
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
    AnswerWrapper other = (AnswerWrapper) obj;
    if (featureLabels == null) {
      if (other.featureLabels != null)
        return false;
    } else if (!featureLabels.equals(other.featureLabels))
      return false;
    if (featureValues == null) {
      if (other.featureValues != null)
        return false;
    } else if (!featureValues.equals(other.featureValues))
      return false;
    if (rank != other.rank)
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

  
  
}
