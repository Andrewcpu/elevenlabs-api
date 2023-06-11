package net.andrewcpu.elevenlabs.model.voice;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.model.ElevenModel;

public class Sample extends ElevenModel {
	@JsonProperty("sample_id")
	private String sampleId;

	@JsonProperty("file_name")
	private String fileName;

	@JsonProperty("mime_type")
	private String mimeType;

	@JsonProperty("size_bytes")
	private long sizeBytes;

	@JsonProperty("hash")
	private String hash;

	public Sample(String sampleId, String fileName, String mimeType, long sizeBytes, String hash) {
		this.sampleId = sampleId;
		this.fileName = fileName;
		this.mimeType = mimeType;
		this.sizeBytes = sizeBytes;
		this.hash = hash;
	}

	public Sample() {
	}

	@JsonIgnore
	public String getSampleId() {
		return sampleId;
	}

	@JsonIgnore
	public String getFileName() {
		return fileName;
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
	public String getHash() {
		return hash;
	}

	@Override
	@JsonIgnore
	public String toString() {
		return "Sample{" +
				"sampleId='" + sampleId + '\'' +
				", fileName='" + fileName + '\'' +
				", mimeType='" + mimeType + '\'' +
				", sizeBytes=" + sizeBytes +
				", hash='" + hash + '\'' +
				'}';
	}
}
