package net.andrewcpu.elevenlabs.api.requests.voices;

import net.andrewcpu.elevenlabs.api.requests.ElevenLabsDeleteRequest;
import net.andrewcpu.elevenlabs.api.transformers.RequestTransformer;

import java.util.List;

public class DeleteVoiceRequest extends ElevenLabsDeleteRequest<String> {
	public DeleteVoiceRequest(String voiceId) {
		super(List.of(voiceId), RequestTransformer.STRING_RESULT_TRANSFORMER);
	}

	@Override
	public String getEndpoint() {
		return "voices/{voiceId}";
	}
}
