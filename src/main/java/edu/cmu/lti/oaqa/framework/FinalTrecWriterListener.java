package edu.cmu.lti.oaqa.framework;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CASException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceSpecifier;
import org.apache.uima.resource.Resource_ImplBase;

import edu.cmu.lti.oaqa.ecd.eval.Key;
import edu.cmu.lti.oaqa.ecd.eval.TraceListener;
import edu.cmu.lti.oaqa.framework.data.PassageCandidate;
import edu.cmu.lti.oaqa.framework.types.InputElement;

public class FinalTrecWriterListener extends Resource_ImplBase implements TraceListener {

	private FileWriter writer;

  @Override
  public boolean initialize(ResourceSpecifier aSpecifier,
          Map<String,Object> aAdditionalParams) throws ResourceInitializationException {
		String date = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
		File file = new File("target/" + date + "-" + UUID.randomUUID() + ".trec");
		File dir = file.getParentFile();
		if (!dir.exists())
		{
			dir.mkdirs();
		}
		try
		{
			writer = new FileWriter(file);
			return true;
		}
		catch (IOException e)
		{
			throw new ResourceInitializationException(e);
		}
	}

	@Override
	public void process(Key key, JCas jcas) throws AnalysisEngineProcessException
	{
		try
		{
			int qid = ((InputElement) JCasHelper.getAnnotation(jcas, InputElement.type)).getSequenceId();
			JCas finalView = ViewManager.getCandidateView(jcas);
			List<PassageCandidate> results = JCasHelper.getPassages(finalView);
			for (int i = 0; i < Math.min(1000, results.size()); i++)
			{
				PassageCandidate result = results.get(i);
				writer.write(qid + "\t" 
						+ result.getDocID() + "\t" 
						+ (i + 1) + "\t" 
						+ result.getScore() + "\t" 
						+ result.getStart() + "\t"
						+ (result.getEnd() - result.getStart()) + "\t" 
						+ key.getTrace().getTrace().replaceAll("\\s", "_") 
						+ "\t" + key.hashString() 
						+ "\n");
			}
			writer.flush();
		}
		catch (IOException e)
		{
			throw new AnalysisEngineProcessException(e);
		}
		catch (CASException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void collectionProcessComplete() throws AnalysisEngineProcessException
	{
		try
		{
			writer.close();
		}
		catch (IOException e)
		{
			throw new AnalysisEngineProcessException(e);
		}
	}
}
