package net.andrewcpu.elevenlabs.net.voices;

import net.andrewcpu.elevenlabs.model.voice.VoiceSettings;
import net.andrewcpu.elevenlabs.net.GetRequest;

public class GetVoiceSettingsRequest extends GetRequest<VoiceSettings> {
	public GetVoiceSettingsRequest(String voiceId) {
		super("v1/voices/" + voiceId + "/settings", VoiceSettings.class);
	}

	@Override
	public Object getPayload() {
		return null;
	}
}
