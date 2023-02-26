package net.andrewcpu.elevenlabs.elements.voice;

import net.andrewcpu.elevenlabs.ElevenLabsAPI;
import net.andrewcpu.elevenlabs.api.SampleAPI;
import net.andrewcpu.elevenlabs.exceptions.ElevenLabsException;
import org.json.simple.JSONObject;

import java.io.File;

public class Sample {
	private final String sampleId;
	private final String fileName;
	private final String mimeType;
	private final long sizeBytes;
	private final String hash;
	private Voice voice;

	static Sample fromJSON(JSONObject object) {
		String sampleId = (String) object.get("sample_id");
		String fileName = (String) object.get("file_name");
		String mimeType = (String) object.get("mime_type");
		int sizeBytes = ((Long) object.get("size_bytes")).intValue();
		String hash = (String) object.get("hash");

		return new Sample(sampleId, fileName, mimeType, sizeBytes, hash);
	}


	private Sample(String sampleId, String fileName, String mimeType, long sizeBytes, String hash) {
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

	public boolean delete() throws ElevenLabsException {
		JSONObject result = SampleAPI.deleteSample(voice,this);
		if(result.containsKey("status")){
			if(result.get("status").equals("ok")){
				return true;
			}
		}
		return false;
	}

	public File downloadAudio(File outputFile) throws ElevenLabsException {
		return SampleAPI.getSampleAudio(voice, this, outputFile);
	}

	@Override
	public String toString() {
		return "Sample{" +
				"sampleId='" + sampleId + '\'' +
				", fileName='" + fileName + '\'' +
				", mimeType='" + mimeType + '\'' +
				", sizeBytes=" + sizeBytes +
				", hash='" + hash + '\'' +
				", voice=" + voice.getVoiceId() +
				'}';
	}
}
