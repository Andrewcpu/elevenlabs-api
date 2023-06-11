package net.andrewcpu.elevenlabs.model.tuning;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.model.ElevenModel;

public class Recording extends ElevenModel {
	@JsonProperty("recording_id")
	private String recordingId;

	@JsonProperty("mime_type")
	private String mimeType;

	@JsonProperty("size_bytes")
	private long sizeBytes;

	@JsonProperty("upload_date_unix")
	private long uploadDateUnix;

	@JsonProperty("transcription")
	private String transcription;

	public Recording(String recordingId, String mimeType, long sizeBytes, long uploadDateUnix, String transcription) {
		this.recordingId = recordingId;
		this.mimeType = mimeType;
		this.sizeBytes = sizeBytes;
		this.uploadDateUnix = uploadDateUnix;
		this.transcription = transcription;
	}

	public Recording() {
	}

	@JsonIgnore
	public String getRecordingId() {
		return recordingId;
	}

	@JsonIgnore
	public String getMimeType() {
		return mimeType;
	}

	@JsonIgnore
	public long getSizeBytes() {
		return sizeBytes;
	}

	@JsonIgnore
	public long getUploadDateUnix() {
		return uploadDateUnix;
	}

	@JsonIgnore
	public String getTranscription() {
		return transcription;
	}

	@JsonIgnore
	@Override
	public String toString() {
		return "Recording{" +
				"recordingId='" + recordingId + '\'' +
				", mimeType='" + mimeType + '\'' +
				", sizeBytes=" + sizeBytes +
				", uploadDateUnix=" + uploadDateUnix +
				", transcription='" + transcription + '\'' +
				'}';
	}
}
