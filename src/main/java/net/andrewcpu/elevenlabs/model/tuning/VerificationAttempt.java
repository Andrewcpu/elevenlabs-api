package net.andrewcpu.elevenlabs.model.tuning;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.model.ElevenModel;

public class VerificationAttempt extends ElevenModel {
	@JsonProperty("text")
	private String text;

	@JsonProperty("date_unix")
	private long dateUnix;

	@JsonProperty("accepted")
	private boolean accepted;

	@JsonProperty("similarity")
	private double similarity;

	@JsonProperty("levenshtein_distance")
	private double levenshteinDistance;

	@JsonProperty("recording")
	private Recording recording;

	public VerificationAttempt(String text, long dateUnix, boolean accepted, double similarity, double levenshteinDistance, Recording recording) {
		this.text = text;
		this.dateUnix = dateUnix;
		this.accepted = accepted;
		this.similarity = similarity;
		this.levenshteinDistance = levenshteinDistance;
		this.recording = recording;
	}

	public VerificationAttempt() {
	}

	@JsonIgnore
	public String getText() {
		return text;
	}

	@JsonIgnore
	public long getDateUnix() {
		return dateUnix;
	}

	@JsonIgnore
	public boolean isAccepted() {
		return accepted;
	}

	@JsonIgnore
	public double getSimilarity() {
		return similarity;
	}

	@JsonIgnore
	public double getLevenshteinDistance() {
		return levenshteinDistance;
	}

	@JsonIgnore
	public Recording getRecording() {
		return recording;
	}

	@JsonIgnore
	@Override
	public String toString() {
		return "VerificationAttempt{" +
				"text='" + text + '\'' +
				", dateUnix=" + dateUnix +
				", accepted=" + accepted +
				", similarity=" + similarity +
				", levenshteinDistance=" + levenshteinDistance +
				", recording=" + recording +
				'}';
	}
}
