package net.andrewcpu.elevenlabs.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.model.ElevenModel;
import net.andrewcpu.elevenlabs.model.voice.VoiceSettings;

public class TextToSpeechRequest extends ElevenModel {
	@JsonProperty("text")
	private String text;

	@JsonProperty("model_id")
	private String modelId;

	@JsonProperty("voice_settings")
	private VoiceSettings voiceSettings;

	public TextToSpeechRequest(String text, String modelId, VoiceSettings voiceSettings) {
		this.text = text;
		this.modelId = modelId;
		this.voiceSettings = voiceSettings;
	}

	public TextToSpeechRequest() {
	}

	@JsonIgnore
	public String getText() {
		return text;
	}

	@JsonIgnore
	public String getModelId() {
		return modelId;
	}

	@JsonIgnore
	public VoiceSettings getVoiceSettings() {
		return voiceSettings;
	}

	@JsonIgnore
	@Override
	public String toString() {
		return "TextToSpeechRequest{" +
				"text='" + text + '\'' +
				", modelId='" + modelId + '\'' +
				", voiceSettings=" + voiceSettings +
				'}';
	}
}
