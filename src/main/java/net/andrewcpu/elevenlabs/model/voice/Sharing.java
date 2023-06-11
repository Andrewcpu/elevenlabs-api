package net.andrewcpu.elevenlabs.model.voice;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.model.ElevenModel;

public class Sharing extends ElevenModel {
	@JsonProperty("status")
	private String status;

	@JsonProperty("history_item_sample_id")
	private String historyItemSampleId;

	@JsonProperty("original_voice_id")
	private String originalVoiceId;

	@JsonProperty("public_owner_id")
	private String publicOwnerId;

	@JsonProperty("liked_by_count")
	private int likedByCount;

	@JsonProperty("cloned_by_count")
	private int clonedByCount;

	public Sharing(String status, String historyItemSampleId, String originalVoiceId, String publicOwnerId, int likedByCount, int clonedByCount) {
		this.status = status;
		this.historyItemSampleId = historyItemSampleId;
		this.originalVoiceId = originalVoiceId;
		this.publicOwnerId = publicOwnerId;
		this.likedByCount = likedByCount;
		this.clonedByCount = clonedByCount;
	}

	public Sharing() {
	}

	@JsonIgnore
	public String getStatus() {
		return status;
	}

	@JsonIgnore
	public String getHistoryItemSampleId() {
		return historyItemSampleId;
	}

	@JsonIgnore
	public String getOriginalVoiceId() {
		return originalVoiceId;
	}

	@JsonIgnore
	public String getPublicOwnerId() {
		return publicOwnerId;
	}

	@JsonIgnore
	public int getLikedByCount() {
		return likedByCount;
	}

	@JsonIgnore
	public int getClonedByCount() {
		return clonedByCount;
	}

	@Override
	@JsonIgnore
	public String toString() {
		return "Sharing{" +
				"status='" + status + '\'' +
				", historyItemSampleId='" + historyItemSampleId + '\'' +
				", originalVoiceId='" + originalVoiceId + '\'' +
				", publicOwnerId='" + publicOwnerId + '\'' +
				", likedByCount=" + likedByCount +
				", clonedByCount=" + clonedByCount +
				'}';
	}
}
