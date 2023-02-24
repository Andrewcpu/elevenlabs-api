package net.andrewcpu.elevenlabs.api.requests.voices;

import net.andrewcpu.elevenlabs.api.ElevenLabsRequest;
import net.andrewcpu.elevenlabs.api.transformers.obj.VoiceTransformer;
import net.andrewcpu.elevenlabs.elements.voice.Voice;
import net.andrewcpu.elevenlabs.enums.HTTPMethod;

import java.util.List;

public class GetVoiceRequest extends ElevenLabsRequest<Voice> {
	public GetVoiceRequest(String voiceId, boolean withSettings) {
		super(List.of(voiceId, String.valueOf(withSettings)), HTTPMethod.GET, new VoiceTransformer());
	}

	@Override
	public String getEndpoint() {
		return "v1/voices/%s?with_settings=%s";
	}
}
