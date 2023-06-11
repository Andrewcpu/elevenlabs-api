package net.andrewcpu.elevenlabs.model.error;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.model.ElevenModel;

import java.util.List;

public class ValidationErrorDetail extends ElevenModel {
	@JsonProperty("loc")
	private List locations;

	@JsonProperty("msg")
	private String message;

	@JsonProperty("type")
	private String type;

	public ValidationErrorDetail(List locations, String message, String type) {
		this.locations = locations;
		this.message = message;
		this.type = type;
	}

	public ValidationErrorDetail() {
	}

	@JsonIgnore
	public List getLocations() {
		return locations;
	}

	@JsonIgnore
	public String getMessage() {
		return message;
	}

	@JsonIgnore
	public String getType() {
		return type;
	}

	@JsonIgnore
	@Override
	public String toString() {
		return "ValidationErrorDetail{" +
				"locations=" + locations +
				", message='" + message + '\'' +
				", type='" + type + '\'' +
				'}';
	}
}
