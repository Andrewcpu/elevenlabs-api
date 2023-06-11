package net.andrewcpu.elevenlabs.net.voices;

import net.andrewcpu.elevenlabs.model.voice.VoiceSettings;
import net.andrewcpu.elevenlabs.net.GetRequest;

public class GetDefaultVoiceSettingsRequest extends GetRequest<VoiceSettings> {
	public GetDefaultVoiceSettingsRequest() {
		super("v1/voices/settings/default", VoiceSettings.class);
	}

	@Override
	public Object getPayload() {
		return null;
	}
}
