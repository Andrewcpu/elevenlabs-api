package net.andrewcpu.elevenlabs.api.requests.voices.settings;

import net.andrewcpu.elevenlabs.api.requests.ElevenLabsGetRequest;
import net.andrewcpu.elevenlabs.api.transformers.RequestTransformer;
import net.andrewcpu.elevenlabs.elements.voice.VoiceSettings;

import java.util.List;

public class GetVoiceSettingsRequest extends ElevenLabsGetRequest<VoiceSettings> {
	public GetVoiceSettingsRequest(String voiceId) {
		super(List.of(voiceId), RequestTransformer.VOICE_SETTINGS_TRANSFORMER);
	}

	@Override
	public String getEndpoint() {
		return "voices/{voiceId}/settings";
	}
}
