package net.andrewcpu.elevenlabs.requests.voices;

import net.andrewcpu.elevenlabs.model.voice.VoiceSettings;
import net.andrewcpu.elevenlabs.requests.GetRequest;

public class GetVoiceSettingsRequest extends GetRequest<VoiceSettings> {
	public GetVoiceSettingsRequest(String voiceId) {
		super("v1/voices/" + voiceId + "/settings", VoiceSettings.class);
	}
}
