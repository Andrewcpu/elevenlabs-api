package net.andrewcpu.elevenlabs.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.andrewcpu.elevenlabs.model.ElevenModel;

public class CreateVoiceResponse extends ElevenModel {
	@JsonProperty("voice_id")
	private String voiceId;

	public CreateVoiceResponse(String voiceId) {
		this.voiceId = voiceId;
	}

	public CreateVoiceResponse() {
	}

	@JsonIgnore
	public String getVoiceId() {
		return voiceId;
	}

	@JsonIgnore
	@Override
	public String toString() {
		return "CreateVoiceResponse{" +
				"voiceId='" + voiceId + '\'' +
				'}';
	}
}
