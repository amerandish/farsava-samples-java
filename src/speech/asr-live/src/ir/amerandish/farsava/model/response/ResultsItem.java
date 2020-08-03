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

	public String getTranscript(){
		return transcript;
	}

	public double getConfidence(){
		return confidence;
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