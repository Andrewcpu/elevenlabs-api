package net.andrewcpu.elevenlabs.model.error;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.model.ElevenModel;

import java.util.List;

public class ValidationError extends ElevenModel {
	@JsonProperty("detail")
	private List<ValidationErrorDetail> details;

	public ValidationError(List<ValidationErrorDetail> details) {
		this.details = details;
	}

	public ValidationError() {
	}

	@JsonIgnore
	public List<ValidationErrorDetail> getDetails() {
		return details;
	}

	@Override
	@JsonIgnore
	public String toString() {
		return "ValidationError{" +
				"details=" + details +
				'}';
	}
}
