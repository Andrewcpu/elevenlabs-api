package net.andrewcpu.elevenlabs.requests.voices;

import net.andrewcpu.elevenlabs.model.voice.VoiceSettings;
import net.andrewcpu.elevenlabs.requests.PostRequest;

public class PostEditVoiceSettingsRequest extends PostRequest<String> {
	private final VoiceSettings voiceSettings;
	public PostEditVoiceSettingsRequest(String voiceId, VoiceSettings voiceSettings) {
		super("v1/voices/" + voiceId + "/settings/edit", String.class);
		this.voiceSettings = voiceSettings;
	}

	@Override
	public Object getPayload() {
		return voiceSettings;
	}
}
