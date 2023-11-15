package net.andrewcpu.elevenlabs.model.tuning;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.model.ElevenModel;

import java.util.List;

public class FineTuning extends ElevenModel {
	@JsonProperty("model_id")
	private String modelId;

	@JsonProperty("language")
	private String language;

	@JsonProperty("is_allowed_to_fine_tune")
	private boolean isAllowedToFineTune;

	@JsonProperty("fine_tuning_requested")
	private boolean fineTuningRequested;

	@JsonProperty("finetuning_state")
	private String finetuningState;

	@JsonProperty("verification_attempts")
	private List<VerificationAttempt> verificationAttempts;

	@JsonProperty("verification_failures")
	private List<String> verificationFailures;

	@JsonProperty("verification_attempts_count")
	private int verificationAttemptsCount;

	@JsonProperty("slice_ids")
	private List<String> sliceIds;

	public FineTuning(String modelId, String language, boolean isAllowedToFineTune, boolean fineTuningRequested, String finetuningState, List<VerificationAttempt> verificationAttempts, List<String> verificationFailures, int verificationAttemptsCount, List<String> sliceIds) {
		this.modelId = modelId;
		this.language = language;
		this.isAllowedToFineTune = isAllowedToFineTune;
		this.fineTuningRequested = fineTuningRequested;
		this.finetuningState = finetuningState;
		this.verificationAttempts = verificationAttempts;
		this.verificationFailures = verificationFailures;
		this.verificationAttemptsCount = verificationAttemptsCount;
		this.sliceIds = sliceIds;
	}

	public FineTuning() {
	}

	@JsonIgnore
	public String getModelId() {
		return modelId;
	}

	@JsonIgnore
	public String getLanguage() {
		return language;
	}

	@JsonIgnore
	public boolean isAllowedToFineTune() {
		return isAllowedToFineTune;
	}

	@JsonIgnore
	public boolean isFineTuningRequested() {
		return fineTuningRequested;
	}

	@JsonIgnore
	public String getFinetuningState() {
		return finetuningState;
	}

	@JsonIgnore
	public List<VerificationAttempt> getVerificationAttempts() {
		return verificationAttempts;
	}

	@JsonIgnore
	public List<String> getVerificationFailures() {
		return verificationFailures;
	}

	@JsonIgnore
	public int getVerificationAttemptsCount() {
		return verificationAttemptsCount;
	}

	@JsonIgnore
	public List<String> getSliceIds() {
		return sliceIds;
	}

	@Override
	@JsonIgnore
	public String toString() {
		return "FineTuning{" +
				"modelId='" + modelId + '\'' +
				", language='" + language + '\'' +
				", isAllowedToFineTune=" + isAllowedToFineTune +
				", fineTuningRequested=" + fineTuningRequested +
				", finetuningState='" + finetuningState + '\'' +
				", verificationAttempts=" + verificationAttempts +
				", verificationFailures=" + verificationFailures +
				", verificationAttemptsCount=" + verificationAttemptsCount +
				", sliceIds=" + sliceIds +
				'}';
	}
}
