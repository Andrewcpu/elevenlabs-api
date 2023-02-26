package net.andrewcpu.elevenlabs.api.net.requests.voices;

import net.andrewcpu.elevenlabs.api.net.requests.ElevenLabsGetRequest;
import net.andrewcpu.elevenlabs.api.net.transformers.RequestTransformer;
import net.andrewcpu.elevenlabs.elements.voice.Voice;

import java.util.List;

public class GetVoiceRequest extends ElevenLabsGetRequest<Voice> {
	public GetVoiceRequest(String voiceId, boolean withSettings) {
		super(List.of(voiceId, String.valueOf(withSettings)), RequestTransformer.VOICE_TRANSFORMER);
	}

	@Override
	public String getEndpoint() {
		return "voices/{voiceId}?with_settings={withSettings}";
	}
}
