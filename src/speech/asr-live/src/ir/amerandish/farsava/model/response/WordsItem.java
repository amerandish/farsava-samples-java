package ir.amerandish.farsava.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WordsItem{

	@JsonProperty("confidence")
	private double confidence;

	@JsonProperty("startTime")
	private int startTime;

	@JsonProperty("endTime")
	private int endTime;

	@JsonProperty("word")
	private String word;

	public double getConfidence(){
		return confidence;
	}

	public int getStartTime(){
		return startTime;
	}

	public int getEndTime(){
		return endTime;
	}

	public String getWord(){
		return word;
	}

	@Override
	public String toString() {
		return "WordsItem{" +
				"confidence=" + confidence +
				", startTime=" + startTime +
				", endTime=" + endTime +
				", word='" + word + '\'' +
				'}';
	}
}