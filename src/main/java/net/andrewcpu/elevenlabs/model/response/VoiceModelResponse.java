package net.andrewcpu.elevenlabs.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.model.ElevenModel;
import net.andrewcpu.elevenlabs.model.voice.Voice;

import java.util.List;

public class VoiceModelResponse extends ElevenModel {
	@JsonProperty("voices")
	private List<Voice> voices;

	public VoiceModelResponse(List<Voice> voices) {
		this.voices = voices;
	}

	public VoiceModelResponse() {
	}

	@JsonIgnore
	public List<Voice> getVoices() {
		return voices;
	}

	@JsonIgnore
	@Override
	public String toString() {
		return "VoiceModelResponse{" +
				"voices=" + voices +
				'}';
	}
}
