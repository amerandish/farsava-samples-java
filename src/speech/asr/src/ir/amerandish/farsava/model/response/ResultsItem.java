package ir.amerandish.farsava.model.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultsItem{

	@JsonProperty("transcript")
	private String transcript;

	@JsonProperty("confidence")
	private double confidence;

	@JsonProperty("words")
	private List<WordsItem> words;

	public void setTranscript(String transcript){
		this.transcript = transcript;
	}

	public String getTranscript(){
		return transcript;
	}

	public void setConfidence(double confidence){
		this.confidence = confidence;
	}

	public double getConfidence(){
		return confidence;
	}

	public void setWords(List<WordsItem> words){
		this.words = words;
	}

	public List<WordsItem> getWords(){
		return words;
	}

	@Override
	public String toString() {
		return "ResultsItem{" +
				"transcript='" + transcript + '\'' +
				", confidence=" + confidence +
				", words=" + words +
				'}';
	}
}