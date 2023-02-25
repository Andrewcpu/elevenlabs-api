package net.andrewcpu.elevenlabs.api.requests.voices.settings;

import net.andrewcpu.elevenlabs.api.requests.ElevenLabsGetRequest;
import net.andrewcpu.elevenlabs.api.transformers.RequestTransformer;
import net.andrewcpu.elevenlabs.elements.voice.VoiceSettings;

public class GetDefaultVoiceSettingsRequest extends ElevenLabsGetRequest<VoiceSettings> {
	public GetDefaultVoiceSettingsRequest() {
		super(RequestTransformer.VOICE_SETTINGS_TRANSFORMER);
	}

	@Override
	public String getEndpoint() {
		return "voices/settings/default";
	}
}
