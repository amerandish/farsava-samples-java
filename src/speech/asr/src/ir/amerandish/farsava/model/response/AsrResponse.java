package ir.amerandish.farsava.model.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AsrResponse {

	@JsonProperty("duration")
	private int duration;

	@JsonProperty("transcriptionId")
	private String transcriptionId;

	@JsonProperty("inferenceTime")
	private int inferenceTime;

	@JsonProperty("results")
	private List<ResultsItem> results;

	@JsonProperty("status")
	private String status;

	public void setDuration(int duration){
		this.duration = duration;
	}

	public int getDuration(){
		return duration;
	}

	public void setTranscriptionId(String transcriptionId){
		this.transcriptionId = transcriptionId;
	}

	public String getTranscriptionId(){
		return transcriptionId;
	}

	public void setInferenceTime(int inferenceTime){
		this.inferenceTime = inferenceTime;
	}

	public int getInferenceTime(){
		return inferenceTime;
	}

	public void setResults(List<ResultsItem> results){
		this.results = results;
	}

	public List<ResultsItem> getResults(){
		return results;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
	public String toString() {
		return "Asr{" +
				"duration=" + duration +
				", transcriptionId='" + transcriptionId + '\'' +
				", inferenceTime=" + inferenceTime +
				", results=" + results +
				", status='" + status + '\'' +
				'}';
	}
}