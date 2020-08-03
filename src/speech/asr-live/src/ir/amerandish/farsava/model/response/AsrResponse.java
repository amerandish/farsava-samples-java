package ir.amerandish.farsava.model.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AsrResponse{

	@JsonProperty("duration")
	private int duration;

	@JsonProperty("transcriptionId")
	private String transcriptionId;

	@JsonProperty("inferenceTime")
	private int inferenceTime;

	@JsonProperty("partial")
	private int partial;

	@JsonProperty("results")
	private List<ResultsItem> results;

	@JsonProperty("status")
	private String status;

	public int getDuration(){
		return duration;
	}

	public String getTranscriptionId(){
		return transcriptionId;
	}

	public int getInferenceTime(){
		return inferenceTime;
	}

	public int getPartial(){
		return partial;
	}

	public List<ResultsItem> getResults(){
		return results;
	}

	public String getStatus(){
		return status;
	}

	@Override
	public String toString() {
		return "AsrResponse{" +
				"duration=" + duration +
				", transcriptionId='" + transcriptionId + '\'' +
				", inferenceTime=" + inferenceTime +
				", partial=" + partial +
				", results=" + results +
				", status='" + status + '\'' +
				'}';
	}
}