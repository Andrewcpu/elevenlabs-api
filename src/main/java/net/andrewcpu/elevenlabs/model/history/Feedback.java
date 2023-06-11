package net.andrewcpu.elevenlabs.model.history;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.model.ElevenModel;

public class Feedback extends ElevenModel {
	@JsonProperty("thumbs_up")
	private boolean thumbsUp;

	@JsonProperty("feedback")
	private String feedback;

	@JsonProperty("emotions")
	private boolean emotions;

	@JsonProperty("inaccurate_clone")
	private boolean inaccurateClone;

	@JsonProperty("glitches")
	private boolean glitches;

	@JsonProperty("audio_quality")
	private boolean audioQuality;

	@JsonProperty("other")
	private boolean other;

	@JsonProperty("review_status")
	private String reviewStatus;


	public Feedback(boolean thumbsUp, String feedback, boolean emotions, boolean inaccurateClone, boolean glitches, boolean audioQuality, boolean other, String reviewStatus) {
		this.thumbsUp = thumbsUp;
		this.feedback = feedback;
		this.emotions = emotions;
		this.inaccurateClone = inaccurateClone;
		this.glitches = glitches;
		this.audioQuality = audioQuality;
		this.other = other;
		this.reviewStatus = reviewStatus;
	}

	public Feedback() {
	}

	@JsonIgnore
	public boolean isThumbsUp() {
		return thumbsUp;
	}

	@JsonIgnore
	public String getFeedback() {
		return feedback;
	}

	@JsonIgnore
	public boolean isEmotions() {
		return emotions;
	}

	@JsonIgnore
	public boolean isInaccurateClone() {
		return inaccurateClone;
	}

	@JsonIgnore
	public boolean isGlitches() {
		return glitches;
	}

	@JsonIgnore
	public boolean isAudioQuality() {
		return audioQuality;
	}

	@JsonIgnore
	public boolean isOther() {
		return other;
	}

	@JsonIgnore
	public String getReviewStatus() {
		return reviewStatus;
	}

	@JsonIgnore
	@Override
	public String toString() {
		return "Feedback{" +
				"thumbsUp=" + thumbsUp +
				", feedback='" + feedback + '\'' +
				", emotions=" + emotions +
				", inaccurateClone=" + inaccurateClone +
				", glitches=" + glitches +
				", audioQuality=" + audioQuality +
				", other=" + other +
				", reviewStatus='" + reviewStatus + '\'' +
				'}';
	}
}
