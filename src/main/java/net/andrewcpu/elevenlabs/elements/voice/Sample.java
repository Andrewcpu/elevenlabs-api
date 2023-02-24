package net.andrewcpu.elevenlabs.elements.voice;

import net.andrewcpu.elevenlabs.ElevenLabsAPI;
import net.andrewcpu.elevenlabs.exceptions.ElevenAPINotInitiatedException;
import net.andrewcpu.elevenlabs.exceptions.ElevenLabsValidationException;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;

public class Sample {
	private final String sampleId;
	private final String fileName;
	private final String mimeType;
	private final long sizeBytes;
	private final String hash;
	private Voice voice;

	public static Sample fromJSON(JSONObject object) {
		String sampleId = (String) object.get("sample_id");
		String fileName = (String) object.get("file_name");
		String mimeType = (String) object.get("mime_type");
		int sizeBytes = ((Long) object.get("size_bytes")).intValue();
		String hash = (String) object.get("hash");

		return new Sample(sampleId, fileName, mimeType, sizeBytes, hash);
	}


	public Sample(String sampleId, String fileName, String mimeType, long sizeBytes, String hash) {
		this.sampleId = sampleId;
		this.fileName = fileName;
		this.mimeType = mimeType;
		this.sizeBytes = sizeBytes;
		this.hash = hash;
	}

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}

	public String getSampleId() {
		return sampleId;
	}

	public String getFileName() {
		return fileName;
	}


	public String getMimeType() {
		return mimeType;
	}

	public long getSizeBytes() {
		return sizeBytes;
	}

	public String getHash() {
		return hash;
	}

	public String delete() throws IOException, ElevenLabsValidationException, ElevenAPINotInitiatedException {
		return ElevenLabsAPI.getInstance().deleteSample(voice,this);
	}

	public File downloadAudio(File outputFile) throws IOException, ElevenLabsValidationException, ElevenAPINotInitiatedException {
		return ElevenLabsAPI.getInstance().getSampleAudio(voice, this, outputFile);
	}

	@Override
	public String toString() {
		return "Sample{" +
				"sampleId='" + sampleId + '\'' +
				", fileName='" + fileName + '\'' +
				", mimeType='" + mimeType + '\'' +
				", sizeBytes=" + sizeBytes +
				", hash='" + hash + '\'' +
				", voice=" + voice +
				'}';
	}
}
