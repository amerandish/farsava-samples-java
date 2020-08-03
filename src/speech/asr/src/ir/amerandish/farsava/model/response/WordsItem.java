package ir.amerandish.farsava.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WordsItem{

	@JsonProperty("confidence")
	private double confidence;

	@JsonProperty("startTime")
	private int startTime;

	@JsonProperty("endTime")
	private double endTime;

	@JsonProperty("word")
	private String word;

	public void setConfidence(double confidence){
		this.confidence = confidence;
	}

	public double getConfidence(){
		return confidence;
	}

	public void setStartTime(int startTime){
		this.startTime = startTime;
	}

	public int getStartTime(){
		return startTime;
	}

	public void setEndTime(double endTime){
		this.endTime = endTime;
	}

	public double getEndTime(){
		return endTime;
	}

	public void setWord(String word){
		this.word = word;
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